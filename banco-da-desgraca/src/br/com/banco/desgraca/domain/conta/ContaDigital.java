package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.exception.ArgumentoIlegal;
import br.com.banco.desgraca.exception.BancoIndisponivel;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;

public class ContaDigital extends ClasseAbstrata {

    private Transacao transacao;

    public ContaDigital(int numeroContaCorrente, InstituicaoBancaria instituicaoBancaria, double saldo) {
        super(numeroContaCorrente, instituicaoBancaria, saldo);
    }

    @Override
    public InstituicaoBancaria getInstituicaoBancaria() {
        if (getInstituicaoBancaria() == InstituicaoBancaria.NUBANK || getInstituicaoBancaria() == InstituicaoBancaria.ITAU) {
            return super.getInstituicaoBancaria();
        } else {
            throw new BancoIndisponivel();
        }
    }

    @Override
    public void sacar(Double valor) {
        if (getSaldo() >= valor) {
            if (valor >= 10) {
                setSaldo(getSaldo() - valor);
                transacao.registroTransacao();
            } else {
                throw new ArgumentoIlegal();
            }
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
