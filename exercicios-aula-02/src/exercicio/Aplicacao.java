package exercicio;

public class Aplicacao {
    public static void main(String[] args) {
        Diretor diretor = new Diretor("Chistopher Nolan", 50, 3);

        Filme filmeInterstelar = new Filme("Interstelar", "Melhor filme", 120, 2014,5, diretor);
        Filme filmeBatman = new Filme("Batman", "Melhor filme ever", 90, 2008,5,diretor);

        filmeInterstelar.exibir();
        filmeBatman.exibir();
    }
}
