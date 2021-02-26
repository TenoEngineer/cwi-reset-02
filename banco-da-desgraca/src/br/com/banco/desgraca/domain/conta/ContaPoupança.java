package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.Data;
import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoTransacao;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.exception.ArgumentoIlegal;
import br.com.banco.desgraca.exception.BancoIndisponivel;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;

import java.text.DecimalFormat;

public class ContaPoupança extends ClasseAbstrata {

    private static final double TAXA_SAQUE = 0.02;
    private static final double VALOR_MINIMO_SAQUE = 50;
    private static final double TAXA_TRANSFERENCIA = 0.005;
    private static final double TAXA_TRANSFENCIA_BANCO_DEFERENTE = 0.01;


    public ContaPoupança(int numeroContaCorrente, InstituicaoBancaria instituicaoBancaria, double saldo) {
        super(numeroContaCorrente, instituicaoBancaria, saldo);
        validarBanco(instituicaoBancaria);
    }

    private void validarBanco(Enum banco) {
        if (getInstituicaoBancaria().equals(InstituicaoBancaria.NUBANK)) {
            throw new BancoIndisponivel();
        }
    }

    @Override
    public InstituicaoBancaria getInstituicaoBancaria() {
        return super.getInstituicaoBancaria();
    }

    @Override
    public void sacar(Double valor) {

        Transacao transacao = new Transacao(TipoTransacao.SAQUE, Data.getDataTransacao(), valor);
        String tipoTransacao = TipoTransacao.SAQUE.getTipo();
        double saldoComTaxa = getSaldo() + valor * TAXA_SAQUE;
        String imprimirTexto = tipoTransacao + " realizado com sucesso no valor de "
                + DecimalFormat.getCurrencyInstance().format(valor)
                + " da Conta Poupança "
                + getInstituicaoBancaria().getBanco() + " " + getNumeroContaCorrente();

        if (saldoComTaxa >= valor) {
            if (valor < VALOR_MINIMO_SAQUE) {
                throw new ArgumentoIlegal();
            } else {
                setSaldo(getSaldo() - valor);
                trancacoes.add(transacao);
                System.out.println(imprimirTexto);
                ;
            }
        } else {
            throw new SaldoInsuficienteException();
        }
    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {

        double saldoComTaxa = getSaldo() + valor * TAXA_TRANSFERENCIA;
        double saldoComTaxaDiferente = getSaldo() + valor * TAXA_TRANSFENCIA_BANCO_DEFERENTE;
        boolean mesmoBanco = getInstituicaoBancaria() == contaDestino.getInstituicaoBancaria();
        Transacao transacao = new Transacao(TipoTransacao.SAQUE, Data.getDataTransacao(), valor);
        String tipoTransacao = TipoTransacao.TRANSFERENCIA.getTipo();
        String imprimirTexto = tipoTransacao + " realizada com sucesso no valor de "
                + DecimalFormat.getCurrencyInstance().format(valor)
                + " da Conta Corrente "
                + getInstituicaoBancaria().getBanco() + " " + getNumeroContaCorrente()
                + " para Conta " + contaDestino.getInstituicaoBancaria().getBanco() + " "
                + ((ClasseAbstrata) contaDestino).getNumeroContaCorrente();

        if (mesmoBanco) {        //logica para o mesmo banco
            if (saldoComTaxa >= valor) {
                setSaldo(getSaldo() - valor);
                contaDestino.depositar(valor);
                trancacoes.add(transacao);
                System.out.println(imprimirTexto);
            } else {
                throw new SaldoInsuficienteException();
            }
        } else {        //para bancos diferentes
            if (saldoComTaxaDiferente >= valor) {
                setSaldo(getSaldo() - valor);
                contaDestino.depositar(valor);
                trancacoes.add(transacao);
                transacao.registroTransacao();
                System.out.println(imprimirTexto);
            }
            throw new SaldoInsuficienteException();
        }
    }

    @Override
    public String toString() { //FIXME ONDE UTILIZAR??
        return "Conta Poupança " + getInstituicaoBancaria() + " " +
                getNumeroContaCorrente();
    }

}
