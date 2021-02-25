package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.exception.ArgumentoIlegal;
import br.com.banco.desgraca.exception.BancoIndisponivel;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;

public class ContaPoupança extends ClasseAbstrata {

    private Transacao transacao;
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
        if (getInstituicaoBancaria() == InstituicaoBancaria.NUBANK) {
            throw new BancoIndisponivel();
        } else {
            return super.getInstituicaoBancaria();
        }
    }

    @Override
    public void sacar(Double valor) {

        double saldoComTaxa = getSaldo() + valor * TAXA_SAQUE;

        if (saldoComTaxa >= valor) {
            if (valor < VALOR_MINIMO_SAQUE) {
                throw new ArgumentoIlegal();
            } else {
                setSaldo(getSaldo() - valor);
                transacao.registroTransacao();
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

        if (mesmoBanco) {        //logica para o mesmo banco
            if (saldoComTaxa >= valor) {
                setSaldo(getSaldo() - valor);
                contaDestino.depositar(valor);
                //FIXME ADICIONAR EM UMA LISTA A TRANSAÇÃO
                System.out.println("Transferência realizada no valor de " + valor + " da Conta Corrente "
                        + getInstituicaoBancaria().getBanco() +
                        " para Conta " + contaDestino.getInstituicaoBancaria().getBanco());
            } else {
                throw new SaldoInsuficienteException();
            }
        } else {        //para bancos diferentes
            if (saldoComTaxaDiferente >= valor) {
                setSaldo(getSaldo() - valor);
                contaDestino.depositar(valor);
                System.out.println("Transferência realizada no valor de " + valor + " da Conta Poupança "
                        + getInstituicaoBancaria().getBanco() +
                        " para Conta " + contaDestino.getInstituicaoBancaria().getBanco());
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
