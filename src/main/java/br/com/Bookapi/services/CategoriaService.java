package br.com.Bookapi.services;

import br.com.Bookapi.domain.Categoria;
import br.com.Bookapi.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria findById (Long id){
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElse(null);
    }
}
