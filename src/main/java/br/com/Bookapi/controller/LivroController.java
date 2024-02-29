package br.com.Bookapi.controller;

import br.com.Bookapi.domain.Livro;
import br.com.Bookapi.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value = "/livros")
public class LivroController {
    @Autowired
    private LivroService service;
    @GetMapping (value = "/{id}")
    public ResponseEntity<Livro> findById (@PathVariable Long id){
        Livro ogj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
