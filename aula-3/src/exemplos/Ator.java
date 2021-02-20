package exemplos;

import java.time.LocalDate;

public class Ator extends Pessoa{

    private int quantidadeOscarVencidos;

    public Ator(String nome, LocalDate aniversario, int quantidadeOscarVencidos, Genero genero) {
        super(nome, aniversario , genero);
        this.quantidadeOscarVencidos = quantidadeOscarVencidos;
    }

    public void imprimirInformacoes() {
        super.imprimirInformacoes();
        System.out.println("Quantidade de Oscars Vencidos: " + this.quantidadeOscarVencidos);
    }

}
