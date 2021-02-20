package com.company.heranca;

import com.company.enumeracao.Genero;

public class Diretor extends Pessoa {

    private Integer quantidadeFilmesDirigidos;

    public Diretor(String nome, Integer idade, Integer quantidadeFilmesDirigidos, Genero genero) {
        super(nome, idade, genero);
        this.quantidadeFilmesDirigidos = quantidadeFilmesDirigidos;
    }

}
