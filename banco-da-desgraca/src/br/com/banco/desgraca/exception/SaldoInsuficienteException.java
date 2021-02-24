package br.com.banco.desgraca.exception;

public class SaldoInsuficienteException extends RuntimeException {

    public SaldoInsuficienteException() {
        super("Você não possui saldo suficiente para a transição");
    }

}