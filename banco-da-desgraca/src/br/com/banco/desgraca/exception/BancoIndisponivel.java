package br.com.banco.desgraca.exception;

public class BancoIndisponivel extends RuntimeException {

    public BancoIndisponivel() {
        super("\nBanco não disponível para a conta bancária.");
    }
}
