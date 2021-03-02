package br.com.cwi.resetflix.entity;

import java.util.List;

import br.com.cwi.resetflix.domain.Genero;

public class FilmeEntity {
    Long id;
    String nome;
    Genero genero;
    Long idDiretor;
    List<Long> idAtores;

    public FilmeEntity(final Long id, final String nome, final Genero genero, final Long idDiretor,
        final List<Long> idAtores) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.idDiretor = idDiretor;
        this.idAtores = idAtores;
    }

    public FilmeEntity(final String nome, final Genero genero, final Long idDiretor,
        final List<Long> idAtores) {
        this.nome = nome;
        this.genero = genero;
        this.idDiretor = idDiretor;
        this.idAtores = idAtores;
    }


    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(final Genero genero) {
        this.genero = genero;
    }

    public Long getIdDiretor() {
        return idDiretor;
    }

    public void setIdDiretor(final Long idDiretor) {
        this.idDiretor = idDiretor;
    }

    public List<Long> getIdAtores() {
        return idAtores;
    }

    public void setIdAtores(final List<Long> idAtores) {
        this.idAtores = idAtores;
    }
}
