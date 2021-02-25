package br.com.banco.desgraca.domain;

public enum TipoTransacao {

    SAQUE("Saque"),
    TRANSFERENCIA("Transferência Bancária"),
    DEPOSITO("Depósito");

private String tipo;

    TipoTransacao(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
