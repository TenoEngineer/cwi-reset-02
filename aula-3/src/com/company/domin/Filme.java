package com.company.domin;

import com.company.heranca.Diretor;

public class Filme {

    private String nome;
    private String descricao;
    private Integer duracao;
    private Integer anoLancamento;
    private Integer avaliacao;
    private Diretor diretor;

    public Filme(String nome, String descricao, Integer duracao, Integer anoLancamento, Integer avaliacao, Diretor diretor) {
        defineAvaliacao(avaliacao);
        validaNomeEDefineAvaliacao(nome);
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.anoLancamento = anoLancamento;
        this.diretor = diretor;
    }

    public void reproduzir() {
        System.out.println("Nome exemplos.Filme: " + this.nome);
        System.out.println("Descrção: " + this.descricao);
        System.out.println("Duração: " + this.duracao);
        System.out.println("Nome do exemplos.Diretor: " + this.diretor.getNome());
    }

    private void defineAvaliacao(Integer avaliacao) {
        if (avaliacao < 1 || avaliacao > 5) {
            throw new IllegalAccessException("Só pode de 1 a 5, cara!");
        }else{
        }
    }

    private void validaNomeEDefineAvaliacao(String nome) {
        if ("Batman vs Superman".equals(nome)) {
            this.avaliacao = 1;
        } else if ("Interestelar".equals(nome)) {
            this.avaliacao = 5;
        }
    }
}
