public class Apartamento extends Imovel{

    private int andar;

    public Apartamento(int valor, Endereco endereco, String tipo, int andar) {
        super(valor, endereco, tipo);
        this.andar = andar;
    }

    public int getAndar() {
        return andar;
    }
}
