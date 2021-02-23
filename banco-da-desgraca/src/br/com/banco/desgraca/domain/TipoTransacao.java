package br.com.banco.desgraca.domain;

public enum TipoTransacao {

    SAQUE("Saque"),
    TRANSFERENCIA("Transferência Bancária"),
    DEPOSITO("Depósito");

private String tipoTransicao;

    TipoTransacao(String tipoTransicao) {
        this.tipoTransicao = tipoTransicao;
    }

    public String getTipoTransicao() {
        return tipoTransicao;
    }
}
