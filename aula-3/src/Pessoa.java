import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

public class Pessoa {

    private String nome;
    private LocalDate aniversario;
    private Genero genero;

        public Pessoa(String nome, LocalDate aniversario, Genero genero) {
        this.nome = nome;
        this.aniversario = aniversario;
        this.genero = genero;
    }

    public void imprimirInformacoes(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + Period.between(this.aniversario, LocalDate.now()).getYears());
        System.out.println("Gênero: " + this.genero.getDescricao());
    }

    public String getNome() {
        return nome;
    }

    /*public void imprimirInformacoes(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade);
        System.out.println("Quantidade de Filmes dirigidos: " + this.quantidadeFilmesDirigidos);
        System.out.println("Gênero: " + this.genero.getDescricao());*/
}
