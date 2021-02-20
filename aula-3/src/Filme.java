import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Filme {
    private String nome;
    private String descricao;
    private double duracao;
    private int anoLancamento;
    private int avaliacao;
    private Diretor diretor;
    private List<Pessoa> elenco;


    public Filme(String nome, String descricao, double duracao, int anoLancamento, int avaliacao, Diretor diretor, List<Pessoa> elenco) {
        defineAvaliacao(avaliacao);
        validaNomeEDefineAvalicao(nome);
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.anoLancamento = anoLancamento;
        this.diretor = diretor;
        this.elenco = elenco;
    }

    public void exibir() {
        System.out.println("Nome do Filme: " + this.nome);
        System.out.println("Descrição: " + this.descricao);
        System.out.println("Duração: " + this.duracao);
        System.out.println("Nome do Diretor: " + this.diretor.getNome());
    }

    private void defineAvaliacao(int avaliacao) {
        if (avaliacao < 1 || avaliacao > 5) {
            this.avaliacao = 3;
        } else {
            this.avaliacao = avaliacao;
        }
    }

    private void validaNomeEDefineAvalicao(String nome) {
        if ("Batman vs Superman".equals(nome)) {
            this.avaliacao = 1;
        } else if ("Interstelar".equals(nome)){
            this.avaliacao = 5;
        }

    }

    public void creditos(){
        System.out.println("********************  " + this.nome + "  ********************");
        System.out.println("\n" + "----  Diretor  ----");
        diretor.imprimirInformacoes();
        System.out.println("\n" + "--  Elenco  --");
        for (Pessoa pessoa : elenco){
            pessoa.imprimirInformacoes();
        }
    }


}
