package br.com.banco.desgraca.domain;

import br.com.banco.desgraca.Data;
import br.com.banco.desgraca.domain.conta.ContaBancaria;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class Transacao {

    private TipoTransacao tipoTransacao;
    private Data DataTransacao;
    private double valor;

    public Transacao(TipoTransacao tipoTransacao, Data dataTransacao, double valor) {
        this.tipoTransacao = tipoTransacao;
        DataTransacao = dataTransacao;
        this.valor = valor;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public Data getDataTransacao() {
        return DataTransacao;
    }

    public String getValor() {
        return DecimalFormat.getCurrencyInstance().format(valor);
    }

    public void registroTransacao() {
        System.out.println("Transação do tipo " + this.tipoTransacao + "realizado ");
    }
}
