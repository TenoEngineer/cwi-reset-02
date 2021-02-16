package exemplo.aula;

public class Pessoa {

    private String cpf;
    private String nome;
    private int idade;

    public Pessoa(String cpf, String nome, int idade) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
    }

    public void fazerAniversario() {
        this.idade = ++idade;
    }
}
