public class Pessoa {

    private String nome;
    private int idade;
    private Genero genero;

    public Pessoa(String nome, int idade, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
    }

    public void imprimirInformacoes(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade);
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
