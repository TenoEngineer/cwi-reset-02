package br.com.banco.desgraca.exception;

public class ArgumentoIlegal extends IllegalArgumentException{

/*    public ArgumentoIlegal(String s) { //FIXME VER O COMO RESOLVER ISSO
        super(s);
    }*/

    public ArgumentoIlegal() {
        super("Valor para saque não disponível. \n Verificar regras de Saque. \n" +
                "    -   Conta Corrente: Só pode ser realizado com valores divisíveis por 5; \n" +
                "    -   Conta Digital: Valor mínimo de saque de R$10,00; \n" +
                "    -   Conta Poupança: Valor mínimo de saque de R$50,00."  );
    }
}
