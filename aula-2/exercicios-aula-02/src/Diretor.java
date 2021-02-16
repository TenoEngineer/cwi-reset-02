public class Diretor extends Pessoa {

    private int quantidadeFilmesDirigidos;

    public Diretor(String nome, int idade, int quantidadeFilmesDirigidos, Genero genero) {
        super(nome, idade, genero);
        this.quantidadeFilmesDirigidos = quantidadeFilmesDirigidos;
    }

}
