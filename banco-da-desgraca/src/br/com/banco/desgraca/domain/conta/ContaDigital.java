package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.exception.ArgumentoIlegal;
import br.com.banco.desgraca.exception.BancoIndisponivel;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;

public class ContaDigital extends ClasseAbstrata {

    private Transacao transacao;
    private double VALOR_MINIMO_SAQUE = 10;

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
        if (getSaldo() >= valor) {
            if (valor >= VALOR_MINIMO_SAQUE) {
                setSaldo(getSaldo() - valor);
                transacao.registroTransacao();
            } else {
                throw new ArgumentoIlegal();
            }
        } else {
            throw new SaldoInsuficienteException();
        }
    }

    public void transferir(Double valor, ContaBancaria contaDestino) {      //FIXME COMO FAZER O REGISTRO EM CONTAS DIFERENTES? registrando uma transação de saída na conta de origem e uma de entrada na conta de destino.

        if (getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            contaDestino.depositar(valor);
            System.out.println("Transferência realizada no valor de " + valor + " da Conta Digital "
                    + getInstituicaoBancaria().getBanco() +
                    " para Conta " + contaDestino.getInstituicaoBancaria().getBanco());
            //FIXME ADICIONAR EM UMA LISTA A TRANSAÇÃO
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
