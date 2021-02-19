public class Imovel {

    private int valor;
    private Endereco endereco;
    private String tipo;

    public Imovel(int valor, Endereco endereco, String tipo) {
        this.valor = valor;
        this.endereco = endereco;
        this.tipo = tipo;
    }

    public String apresentacao() {
        return "Imóvel localizado no endereço: " + endereco.getLogadouro() + " - " + endereco.getNumero()
                + "(" + endereco.getComplemento() + ")" + "\n" +
                endereco.getCidade() + " - " + endereco.getEstado();
    }

    public int getValor() {
        return valor;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getTipo() {
        return tipo;
    }
}

