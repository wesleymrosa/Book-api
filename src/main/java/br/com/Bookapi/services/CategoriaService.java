package br.com.Bookapi.services;

import br.com.Bookapi.Service.Exceptions.ObjectNotFoundException;
import br.com.Bookapi.domain.Categoria;
import br.com.Bookapi.dtos.CategoriaDTO;
import br.com.Bookapi.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repository;

    public Categoria findById(Long id) {
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado ! Id:" + ", tipo: " + Categoria.class.getName()));
    }

    public List<Categoria> findAll() {
        return repository.findAll();
    }

    public Categoria create(Categoria obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public Categoria update(Long id, CategoriaDTO objDTO) {
        Categoria obj = findById(id);
        obj.setNome(objDTO.getNome());
        obj.setDescricao(objDTO.getDescricao());
        return repository.save(obj);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
