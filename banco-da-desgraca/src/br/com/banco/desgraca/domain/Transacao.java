package br.com.banco.desgraca.domain;

import br.com.banco.desgraca.domain.conta.ContaBancaria;

import java.time.LocalDate;

public class Transacao {

    private TipoTransacao tipoTransacao;       //limitar criar um enum
    private LocalDate DataTransferencia;        //ajeitar data corretamente
    private double valor;

    public Transacao(TipoTransacao tipoTransacao, LocalDate dataTransferencia, double valor) {
        this.tipoTransacao = tipoTransacao;
        DataTransferencia = dataTransferencia;
        this.valor = valor;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public LocalDate getDataTransferencia() {
        return DataTransferencia;
    }

    public double getValor() {
        return valor;
    }

    public void registroTransacao() {
        System.out.println("Transação do tipo " + this.tipoTransacao + "realizado ");
    }
}
