public class Diretor {

    private String nome;
    private int idade;
    private int quantidadeFilmesDirigidos;

    public Diretor(String nome, int idade, int quantidadeFilmesDirigidos) {
        this.nome = nome;
        this.idade = idade;
        this.quantidadeFilmesDirigidos = quantidadeFilmesDirigidos;
    }

    public String getNome() {
        return this.nome;
    }
}
