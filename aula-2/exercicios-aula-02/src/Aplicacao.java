import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Aplicacao {
    public static void main(String[] args) {
        Diretor diretor = new Diretor("Chistopher Nolan", 50, 3, Genero.MASCULINO);
        Ator ator = new Ator("Leonardo Dicaprio", 35, 1, Genero.MASCULINO);
        Ator ator1 = new Ator("fdsihfusihfdi", 35, 1, Genero.MASCULINO);
        Ator ator2 = new Ator("hsdfuihfuishf", 35, 1, Genero.MASCULINO);
        List<Pessoa> elenco = Arrays.asList(ator, ator1, ator2);
        Filme filmeInterstelar = new Filme("Interstelar", "Melhor filme", 120,
                2014,5, diretor, elenco );
        //Filme filmeBatman = new Filme("Batman", "Melhor filme ever", 90, 2008,5,diretor);

        filmeInterstelar.creditos();
        //filmeBatman.exibir();
       //diretor.imprimirInformacoes();
        //ator.imprimirInformacoes();

    }
}