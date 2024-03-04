package br.com.Bookapi.services;

import br.com.Bookapi.Service.Exceptions.ObjectNotFoundException;
import br.com.Bookapi.domain.Categoria;
import br.com.Bookapi.domain.Livro;
import br.com.Bookapi.repositories.CategoriaRepository;
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
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaService categoriaService;
    public Livro buscarLivroPorId (Long id){
        Optional<Livro> obj = repository.findById(id);
        return obj.get();
//        return obj.orElseThrow(() -> new ObjectNotFoundException(
//                "Objeto não encontrado ! Id: " + id+ ", Tipo: " + Livro.class.getName()));
    }

    public Optional<Livro> buscaLivroPorId(Long idCat) {

        return repository.findById(idCat);
    }
    public List<Livro> buscaLivrosListaPorCategoria(Long idCategoria) {
        return repository.findLivroByCategoriaId(idCategoria);
    }

    public Livro update(Long id, Livro obj) {
        Livro newObj = buscarLivroPorId(id);
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    private void updateData(Livro newObj, Livro obj) {
        newObj.setTitulo(obj.getTitulo());
        newObj.setNome_autor(obj.getNome_autor());
        newObj.setTexto(obj.getTexto());
    }

    public Livro create(Long idCat, Livro obj) {
        obj.setId(null);
        Categoria cat = categoriaService.findById(idCat);
        obj.setCategoria(cat);
        return repository.save(obj);

    }
}
