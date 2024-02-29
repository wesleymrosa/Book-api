package br.com.Bookapi.services;

import br.com.Bookapi.Service.Exceptions.ObjectNotFoundException;
import br.com.Bookapi.domain.Livro;
import br.com.Bookapi.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    @Autowired
    private LivroRepository repository;

    @Autowired
    private CategoriaService categoriaService;
    public Livro findById (Long id){
        Optional<Livro> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado ! Id: " + id+ ", Tipo: " + Livro.class.getName()));
    }

    public List<Livro> findAll(Long idCat) {
        categoriaService.findById(idCat);
        return repository.findAllByCategoria(idCat);
    }
}
