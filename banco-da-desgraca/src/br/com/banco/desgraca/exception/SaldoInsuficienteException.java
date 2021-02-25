package br.com.banco.desgraca.exception;

public class SaldoInsuficienteException extends RuntimeException {

    public SaldoInsuficienteException() {
        super("\n\nVocê não possui saldo suficiente para a transição\n\n");
    }

}