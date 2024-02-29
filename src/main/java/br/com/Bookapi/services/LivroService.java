package br.com.Bookapi.services;

import br.com.Bookapi.Service.Exceptions.ObjectNotFoundException;
import br.com.Bookapi.domain.Livro;
import br.com.Bookapi.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivroService {
    @Autowired
    private LivroRepository repository;
    public Livro findById (Long id){
        Optional<Livro> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado ! Id: " + id+ ", Tipo: " + Livro.class.getName()));
    }
}
