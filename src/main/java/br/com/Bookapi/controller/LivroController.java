package br.com.Bookapi.controller;

import br.com.Bookapi.domain.Livro;
import br.com.Bookapi.dtos.LivroDTO;
import br.com.Bookapi.services.CategoriaService;
import br.com.Bookapi.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping (value = "/livros")
public class LivroController {
    @Autowired
    private LivroService service;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping (value = "/{id}")
    public ResponseEntity<Livro> findById (@PathVariable Long id){
        Livro obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping
    public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Long id_cat) throws Exception {


        List<Livro> livros = service.buscaLivrosListaPorCategoria(id_cat);
        List<LivroDTO> livrosLista = livros.stream().map((item) -> {
                    return new LivroDTO(item);
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(livrosLista);


    }


//    @PutMapping (value = "/{id}")
//    public ResponseEntity<Livro>update(@PathVariable Long id, @RequestBody Livro obj){
//        Livro newObj = service.update(id, obj);
//        return ResponseEntity.ok().body(newObj);
//    }

//    @PatchMapping (value = "/{id}")
//    public ResponseEntity<Livro>updatePatch(@PathVariable Long id, @RequestBody Livro obj){
//        Livro newObj = service.update(id, obj);
//        return ResponseEntity.ok().body(newObj);
//    }

    @PostMapping
    public ResponseEntity<Livro> create (@RequestParam(value = "categoria", defaultValue = "0") Long id_cat,
            @RequestBody Livro obj){
        Livro newObj = service.create(id_cat,obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/livros/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
