public class Casa extends Imovel{

    private String patio;

    public Casa(int valor, Endereco endereco, String tipo, String patio) {
        super(valor, endereco, tipo);
        this.patio = patio;
    }

    public String getPatio() {
        return patio;
    }
}
