package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoTransacao;
import br.com.banco.desgraca.domain.Transacao;

import java.text.DecimalFormat;
import java.time.LocalDate;

public abstract class ClasseAbstrata implements ContaBancaria{

    private int numeroContaCorrente;
    private InstituicaoBancaria instituicaoBancaria;
    private double saldo;
    private TipoTransacao tipoTransacao;

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

    public void textoTransferencia(){
        System.out.println( tipoTransacao.getTipo() + " realizada no valor de " + DecimalFormat.getCurrencyInstance().format(valor)
                + " da Conta Corrente "
                + getInstituicaoBancaria().getBanco() +
                " para Conta " + contaDestino.getInstituicaoBancaria().getBanco());
    }

    @Override
    public InstituicaoBancaria getInstituicaoBancaria() {
        return instituicaoBancaria;
    }

    @Override
    public Double consultarSaldo() {
        System.out.println(saldo);
        return getSaldo();
    }

    @Override
    public void depositar(Double valor) {
        setSaldo(getSaldo()+valor);
    }

    @Override
    public void sacar(Double valor) {
        setSaldo(getSaldo()-valor);
    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {

    }

    @Override
    public void exibirExtrato(LocalDate inicio, LocalDate fim) {

    }

}
