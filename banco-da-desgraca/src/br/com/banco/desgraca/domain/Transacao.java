package br.com.banco.desgraca.domain;

import br.com.banco.desgraca.Data;
import br.com.banco.desgraca.domain.conta.ClasseAbstrata;
import br.com.banco.desgraca.domain.conta.ContaBancaria;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class Transacao {

    private TipoTransacao tipoTransacao;
    private LocalDate DataTransacao;
    private double valor;

    public Transacao(TipoTransacao tipoTransacao, LocalDate dataTransacao, double valor) {
        this.tipoTransacao = tipoTransacao;
        DataTransacao = dataTransacao;
        this.valor = valor;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public double getValor() {
        return valor;
    }

    public LocalDate getDataTransacao() {
        return DataTransacao;
    }

    public void registroTransacao() {
        System.out.println("Transação do tipo " + this.tipoTransacao.getTipo() + " realizado " );
    }

}
