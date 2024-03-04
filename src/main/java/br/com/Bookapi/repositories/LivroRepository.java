package br.com.Bookapi.repositories;

import br.com.Bookapi.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
//    @Query("SELECT obj FROM livro obj WHERE obj.categoria.id = :id_cat ORDER BY titulo")
//    Optional<Livro> findAllByCategoria(@Param(value = "id_cat") Long idCat);


    @Query("select l.* from livro l where l.categoria.id = ?1")
    List<Livro> buscaTodosLivrosDeCategoria(Long idCategoria);
}
