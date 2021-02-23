package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.Transacao;

import java.time.LocalDate;

public class ContaCorrente implements ContaBancaria {


    private int numeroContaCorrente;
    private InstituicaoBancaria instituicaoBancaria;
    private Transacao transacao;
    private double saldo;


    public ContaCorrente(int numeroContaCorrente, InstituicaoBancaria instituicaoBancaria, double saldo) {
        this.numeroContaCorrente = numeroContaCorrente;
        this.instituicaoBancaria = instituicaoBancaria;
        this.saldo = saldo;
    }

    @Override
    public InstituicaoBancaria getInstituicaoBancaria() {
        return instituicaoBancaria;
    }

    @Override
    public Double consultarSaldo() {
        return this.saldo;
    }

    @Override
    public void depositar(Double valor) {
        this.saldo += valor;
    }

    @Override
    public void sacar(Double valor) {
        if (valor % 5 != 0) {
            System.out.println("Você não pode sacar esse valor! Apenas divisíveis por 5");//FIXME exception
        } else {
            this.saldo -= valor;
        }
    }


    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {

        double saldoComTaxa = this.saldo + valor * 0.01;
        boolean mesmoBanco = this.instituicaoBancaria == contaDestino.getInstituicaoBancaria();

        if (mesmoBanco) {        //logica para o mesmo banco
            if (this.saldo >= valor) {
                this.saldo -= valor;
                contaDestino.depositar(valor);
                System.out.println("Transferindo valor " + valor + " da Conta Corrente " + this.instituicaoBancaria +
                        "para conta corrente " + contaDestino.getInstituicaoBancaria());
            } else {//FIXME exception
            }
        } else {        //para bancos diferentes
            if (saldoComTaxa >= valor) {
                this.saldo -= valor;
                contaDestino.depositar(valor);
                System.out.println("Transferindo valor " + valor + " da Conta Corrente " + this.instituicaoBancaria +
                        "para conta corrente " + contaDestino.getInstituicaoBancaria());
            } // FIXME exception
        }

    }

    @Override
    public void exibirExtrato(LocalDate inicio, LocalDate fim) {

    }

    public int getNumeroContaCorrente() {
        return numeroContaCorrente;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() { //FIXME ARRUMAR TOSTRING
        return "Transferindo valor " + valor + " da Conta Corrente " + this.instituicaoBancaria +
                "para conta corrente " + contaDestino.getInstituicaoBancaria();
    }
}
