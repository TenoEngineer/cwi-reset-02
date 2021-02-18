public class Imovel {

    private int valor;
    private Endereco endereco;
    private String nome;

    public Imovel(int valor, Endereco endereco, String nome) {
        this.valor = valor;
        this.endereco = endereco;
        this.nome = nome;
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

    public String getNome() {
        return nome;
    }
}
