package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.Data;
import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoTransacao;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.exception.ArgumentoIlegal;
import br.com.banco.desgraca.exception.BancoIndisponivel;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;

import java.text.DecimalFormat;

public class ContaDigital extends ClasseAbstrata {

    private static final double VALOR_MINIMO_SAQUE = 10;

    public ContaDigital(int numeroContaCorrente, InstituicaoBancaria instituicaoBancaria, double saldo) {
        super(numeroContaCorrente, instituicaoBancaria, saldo);
        validarBanco(instituicaoBancaria);
    }

    private void validarBanco(Enum banco) {
        if (getInstituicaoBancaria().equals(InstituicaoBancaria.BANCO_DO_BRASIL) ||
                getInstituicaoBancaria().equals(InstituicaoBancaria.CAIXA) ||
                getInstituicaoBancaria().equals(InstituicaoBancaria.BRADESCO)) {
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
        String imprimirTexto = tipoTransacao + " realizado com sucesso no valor de "
                + DecimalFormat.getCurrencyInstance().format(valor)
                + " da Conta Poupança "
                + getInstituicaoBancaria().getBanco() + " " + getNumeroContaCorrente();

        if (getSaldo() >= valor) {
            if (valor < VALOR_MINIMO_SAQUE) {
                throw new ArgumentoIlegal();
            } else {
                setSaldo(getSaldo() - valor);
                trancacoes.add(transacao);
                System.out.println(imprimirTexto);
            }
        } else {
            throw new SaldoInsuficienteException();
        }
    }

    public void transferir(Double valor, ContaBancaria contaDestino) {      //FIXME COMO FAZER O REGISTRO EM CONTAS DIFERENTES? registrando uma transação de saída na conta de origem e uma de entrada na conta de destino.

        Transacao transacao = new Transacao(TipoTransacao.TRANSFERENCIA, Data.getDataTransacao(), valor);
        String tipoTransacao = TipoTransacao.TRANSFERENCIA.getTipo();
        String imprimirTexto = tipoTransacao + " realizada com sucesso no valor de "
                + DecimalFormat.getCurrencyInstance().format(valor)
                + " da Conta Digital "
                + getInstituicaoBancaria().getBanco() + " " + getNumeroContaCorrente();

        if (getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            contaDestino.depositar(valor);
            trancacoes.add(transacao);
            transacao.registroTransacao();
            System.out.println(imprimirTexto);
        } else {
            throw new SaldoInsuficienteException();
        }
    }

    @Override
    public String toString() {
        return "Conta Digital " + getInstituicaoBancaria() + " " +
                getNumeroContaCorrente();
    }
}
