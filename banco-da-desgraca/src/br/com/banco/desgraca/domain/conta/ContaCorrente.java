package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.exception.ArgumentoIlegal;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;

import java.time.LocalDate;

public class ContaCorrente extends ClasseAbstrata {

    private Transacao transacao;

    public ContaCorrente(int numeroContaCorrente, InstituicaoBancaria instituicaoBancaria, double saldo) {
        super(numeroContaCorrente, instituicaoBancaria, saldo);
    }

    @Override
    public void sacar(Double valor) {
        if ( getSaldo() >= valor) {
            if (valor % 5 != 0) {
                throw new ArgumentoIlegal();
            } else {
                setSaldo(getSaldo()-valor);
                transacao.registroTransacao();
            }
        } else {
            throw new SaldoInsuficienteException();
        }
    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {      //FIXME COMO FAZER O REGISTRO EM CONTAS DIFERENTES? registrando uma transação de saída na conta de origem e uma de entrada na conta de destino.

        double saldoComTaxa = getSaldo() + valor * 0.01;
        boolean mesmoBanco = getInstituicaoBancaria() == contaDestino.getInstituicaoBancaria();

        if (mesmoBanco) {        //logica para o mesmo banco
            if (getSaldo() >= valor) {
                setSaldo(getSaldo()-valor);
                contaDestino.depositar(valor);
                //FIXME ADICIONAR EM UMA LISTA A TRANSAÇÃO

                System.out.println("Transferência realizada no valor  de" + valor + " da Conta Corrente "
                        + getInstituicaoBancaria() +
                        "para conta corrente " + contaDestino.getInstituicaoBancaria());
            } else { throw new SaldoInsuficienteException();
            }
        } else {        //para bancos diferentes
            if (saldoComTaxa >= valor) {
                setSaldo(getSaldo()-valor);
                contaDestino.depositar(valor);
                System.out.println("Transferência realizada no valor  de" + valor + " da Conta Corrente "
                        + getInstituicaoBancaria() +
                        "para conta corrente " + contaDestino.getInstituicaoBancaria());
            } throw new SaldoInsuficienteException();
        }

    }

    @Override
    public void exibirExtrato(LocalDate inicio, LocalDate fim) { //TODO FAZER UMA LISTA DE REGISTROS OU CRIAR UMA CLASSE OU NENHUM DOS DOIS??

    }

    @Override
    public String toString() {
        return "Conta Corrente " + getInstituicaoBancaria() + " " +
                getNumeroContaCorrente();
    }
}
