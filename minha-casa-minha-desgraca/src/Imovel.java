public class Imovel {

    private int valor;
    private Endereco endereco;

    public Imovel(int valor, Endereco endereco) {
        this.valor = valor;
        this.endereco = endereco;
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

}

