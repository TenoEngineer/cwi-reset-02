package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.Data;
import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoTransacao;
import br.com.banco.desgraca.domain.Transacao;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class ClasseAbstrata implements ContaBancaria {

    private int numeroContaCorrente;
    private InstituicaoBancaria instituicaoBancaria;
    private double saldo;
    //private TipoTransacao tipoTransacao; //TODO APAGAR
    List<Transacao> trancacoes = new ArrayList<>();

    public ClasseAbstrata(int numeroContaCorrente, InstituicaoBancaria instituicaoBancaria, double saldo) {
        this.numeroContaCorrente = numeroContaCorrente;
        this.instituicaoBancaria = instituicaoBancaria;
        this.saldo = saldo;
    }

    public int getNumeroContaCorrente() {
        return numeroContaCorrente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    @Override
    public InstituicaoBancaria getInstituicaoBancaria() {
        return instituicaoBancaria;
    }

    @Override
    public Double consultarSaldo() {
        System.out.println(DecimalFormat.getCurrencyInstance().format(saldo));
        return saldo;
    }

    @Override
    public void depositar(Double valor) {
        setSaldo(getSaldo() + valor);
    }

    @Override
    public void sacar(Double valor) {
        setSaldo(getSaldo() - valor);
    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {

    }

    @Override
    public void exibirExtrato(LocalDate inicio, LocalDate fim) {


        for (Transacao transacao : trancacoes) {
            if (inicio == null) {
                System.out.println("Extrato " + transacao.toString());
                auxilioExtrato(transacao.getTipoTransacao().getTipo(), transacao.getValor(), transacao.getDataTransacao());
            } else if (fim == null) {
                System.out.println("Extrato " + transacao.toString());
                auxilioExtrato(transacao.getTipoTransacao().getTipo(), transacao.getValor(), transacao.getDataTransacao());
            } else if (inicio == null && fim == null) {
                System.out.println("Extrato " + transacao.toString());
                auxilioExtrato(transacao.getTipoTransacao().getTipo(), transacao.getValor(), transacao.getDataTransacao());
            }
        }
    }

    public void auxilioExtrato(String tipoTransacao, Double valor, LocalDate DataTransacao) {
        if (tipoTransacao.equals(TipoTransacao.DEPOSITO.getTipo())) {
            System.out.println("+   " + DecimalFormat.getCurrencyInstance().format(valor) + " " + DataTransacao);
        } else {
            System.out.println("-   " + DecimalFormat.getCurrencyInstance().format(valor) + " " + DataTransacao);
        }
    }
}

