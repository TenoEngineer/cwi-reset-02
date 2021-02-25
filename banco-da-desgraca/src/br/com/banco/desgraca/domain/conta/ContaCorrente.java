package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoTransacao;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.exception.ArgumentoIlegal;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;

import java.text.DecimalFormat;
import java.time.LocalDate;

import static br.com.banco.desgraca.domain.TipoTransacao.SAQUE;

public class ContaCorrente extends ClasseAbstrata {

    private Transacao transacao;
    private static final double TAXA_TRANFERENCIA = 0.01;

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
                trancacoes.add(new Transacao(TipoTransacao.SAQUE, transacao.getDataTransacao(), valor));
                transacao.registroTransacao();
            }
        } else {
            throw new SaldoInsuficienteException();
        }
    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {      //FIXME COMO FAZER O REGISTRO EM CONTAS DIFERENTES? registrando uma transação de saída na conta de origem e uma de entrada na conta de destino.

        String tipoTransacao = TipoTransacao.TRANSFERENCIA.getTipo();
        double saldoComTaxa = getSaldo() + valor * TAXA_TRANFERENCIA;
        boolean mesmoBanco = getInstituicaoBancaria().equals(contaDestino.getInstituicaoBancaria());

        if (mesmoBanco) {        //logica para o mesmo banco
            if (getSaldo() >= valor) {
                setSaldo(getSaldo()-valor);
                contaDestino.depositar(valor);
                //FIXME ADICIONAR EM UMA LISTA A TRANSAÇÃO
                System.out.println( tipoTransacao + " realizada com sucesso no valor de " + DecimalFormat.getCurrencyInstance().format(valor)
                        + " da Conta Corrente "
                        + getInstituicaoBancaria().getBanco() + " " + getNumeroContaCorrente() +
                        " para Conta " + contaDestino.getInstituicaoBancaria().getBanco() + " " +
                        contaDestino.getNu);; //FIXME COMO COLOCO O NUMERO DA CONTA QUE RECEBEU A TRANSACAO??
            } else { throw new SaldoInsuficienteException();
            }
        } else {        //para bancos diferentes
            if (saldoComTaxa >= valor) {
                setSaldo(getSaldo()-valor);
                contaDestino.depositar(valor);
                System.out.println("Transferência realizada no valor de " + valor + " da Conta Corrente "
                        + getInstituicaoBancaria().getBanco() +
                        " para Conta " + contaDestino.getInstituicaoBancaria().getBanco());
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
