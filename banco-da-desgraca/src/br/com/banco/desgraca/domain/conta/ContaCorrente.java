package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.Data;
import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoTransacao;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.exception.ArgumentoIlegal;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;

import java.text.DecimalFormat;
import java.time.LocalDate;

import static br.com.banco.desgraca.domain.TipoTransacao.SAQUE;

public class ContaCorrente extends ClasseAbstrata {

    private static final double TAXA_TRANFERENCIA = 0.01;

    public ContaCorrente(int numeroContaCorrente, InstituicaoBancaria instituicaoBancaria, double saldo) {
        super(numeroContaCorrente, instituicaoBancaria, saldo);
    }

    @Override
    public void sacar(Double valor) {

        Transacao transacao = new Transacao(TipoTransacao.SAQUE, Data.getDataTransacao(), valor);
        String tipoTransacao = TipoTransacao.SAQUE.getTipo();
        String imprimirTexto = tipoTransacao + " realizado com sucesso no valor de "
                + DecimalFormat.getCurrencyInstance().format(valor)
                + " da Conta Corrente "
                + getInstituicaoBancaria().getBanco() + " " + getNumeroContaCorrente();

        if (getSaldo() >= valor) {
            if (valor % 5 != 0) {
                throw new ArgumentoIlegal();
            } else {
                setSaldo(getSaldo() - valor);
                trancacoes.add(transacao);
                transacao.registroTransacao();
                System.out.println(imprimirTexto);
            }
        } else {
            throw new SaldoInsuficienteException();
        }
    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {      //FIXME COMO FAZER O REGISTRO EM CONTAS DIFERENTES? registrando uma transação de saída na conta de origem e uma de entrada na conta de destino.

        Transacao transacao = new Transacao(TipoTransacao.TRANSFERENCIA, Data.getDataTransacao(), valor);
        String tipoTransacao = TipoTransacao.TRANSFERENCIA.getTipo();
        double saldoComTaxa = getSaldo() + valor * TAXA_TRANFERENCIA;
        boolean mesmoBanco = getInstituicaoBancaria().equals(contaDestino.getInstituicaoBancaria());
        String imprimirTexto = tipoTransacao + " realizada com sucesso no valor de "
                + DecimalFormat.getCurrencyInstance().format(valor)
                + " da Conta Corrente "
                + getInstituicaoBancaria().getBanco() + " " + getNumeroContaCorrente()
                + " para Conta " + contaDestino.getInstituicaoBancaria().getBanco() + " "
                + ((ClasseAbstrata) contaDestino).getNumeroContaCorrente();

        if (mesmoBanco) {        //logica para o mesmo banco
            if (getSaldo() >= valor) {
                setSaldo(getSaldo() - valor);
                contaDestino.depositar(valor);
                trancacoes.add(transacao);
                transacao.registroTransacao();
                System.out.println(imprimirTexto);
            } else {
                throw new SaldoInsuficienteException();
            }
        } else {        //para bancos diferentes
            if (saldoComTaxa >= valor) {
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
    public String toString() {              //TODO ONDE USAR O TOSTRING???
        return "Conta Corrente " + getInstituicaoBancaria() + " " +
                getNumeroContaCorrente();
    }
}
