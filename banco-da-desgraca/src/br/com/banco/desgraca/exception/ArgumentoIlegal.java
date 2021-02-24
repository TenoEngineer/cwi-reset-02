package br.com.banco.desgraca.exception;

public class ArgumentoIlegal extends IllegalArgumentException{

/*    public ArgumentoIlegal(String s) { //FIXME VER O COMO RESOLVER ISSO
        super(s);
    }*/

    public ArgumentoIlegal() {
        super("Valor não disponível. Se for para saque, digitar valores divisiveis por 5");
    }
}
