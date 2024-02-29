package br.com.Bookapi.dtos;

import br.com.Bookapi.domain.Livro;

import java.io.Serializable;
public class LivroDTO implements Serializable {
    private static final Long serialVersionUID = 1L;

    private Long id;
    private String titulo;

    public LivroDTO() {
    }

    public LivroDTO(Livro obj) {
        this.id = obj.getId();
        this.titulo = obj.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
