package br.com.banco.desgraca.exception;

public class BancoIndisponivel extends RuntimeException {

    public BancoIndisponivel() {
        super("\n\nBanco não disponível para a conta bancária. Favor verificar informações bancárias.\n" +
                "*Conta Poupança não aceita Nubank;\n" +
                "*Contas Digitais são aceitas apenas por Itaú e Nubank.\n\n");
    }
}
