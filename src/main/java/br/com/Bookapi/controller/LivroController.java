package br.com.Bookapi.controller;

import br.com.Bookapi.domain.Livro;
import br.com.Bookapi.dtos.LivroDTO;
import br.com.Bookapi.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    @GetMapping
    public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Long id_cat){
        List<Livro> list =service.findAll(id_cat);
        List<LivroDTO> listDTO = list.stream().map(obj ->new LivroDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PutMapping (value = "/{id}")
    public ResponseEntity<Livro>update(@PathVariable Long id, @RequestBody Livro obj){
        Livro newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @PatchMapping (value = "/{id}")
    public ResponseEntity<Livro>updatePatch(@PathVariable Long id, @RequestBody Livro obj){
        Livro newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }
}
