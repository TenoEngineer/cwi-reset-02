package exemplos;

import java.time.LocalDate;

public class Diretor extends Pessoa {

    private int quantidadeFilmesDirigidos;

    public Diretor(String nome, LocalDate aniversario, int quantidadeFilmesDirigidos, Genero genero) {
        super(nome, aniversario, genero);
        this.quantidadeFilmesDirigidos = quantidadeFilmesDirigidos;
    }

    public void imprimirInformacoes() {
        super.imprimirInformacoes();
        System.out.println("Quantidade de filmes dirigidos: " + this.quantidadeFilmesDirigidos);
    }

}
