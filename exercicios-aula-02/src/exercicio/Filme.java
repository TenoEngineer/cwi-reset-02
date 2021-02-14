package exercicio;

public class Filme {

    private String nome;
    private String descricao;
    private double duracao;
    private int anoLancamento;
    private int avaliacao;
    private Diretor diretor;

    public Filme(String nome, String descricao, double duracao, int anoLancamento, int avaliacao, Diretor diretor) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.anoLancamento = anoLancamento;
        this.avaliacao = avaliacao;
        this.diretor = diretor;
    }

    public void exibir() {
        System.out.println("Nome do Filme: " + this.nome);
        System.out.println("Descrição: " + this.descricao);
        System.out.println("Duração: " + this.duracao);
        System.out.println("Nome do Diretor: " + this.diretor.getNome());
    }
}

