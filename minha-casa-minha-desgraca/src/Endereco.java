public class Endereco {

    private String logadouro;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private UnidadeFederativa estado;

    public Endereco(String logadouro, int numero, String complemento, String bairro, String cidade, UnidadeFederativa estado) {
        this.logadouro = logadouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public void imprimirEndereco(){
        System.out.println(this.estado.getEstado() + " - " + this.cidade + " - " + this.bairro + " - " + this.logadouro  + ", " + this.numero + " (" + this.complemento + ")");
    }

    public String getLogadouro() {
        return logadouro;
    }

    public int getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public UnidadeFederativa getEstado() {
        return estado;
    }
}

