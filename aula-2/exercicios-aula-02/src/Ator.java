import java.lang.reflect.GenericSignatureFormatError;

public class Ator extends Pessoa{

    private int quantidadeOscarVencidos;

    public Ator(String nome, int idade, int quantidadeOscarVencidos, Genero genero) {
        super(nome, idade, genero);
        this.quantidadeOscarVencidos = quantidadeOscarVencidos;
    }

}
