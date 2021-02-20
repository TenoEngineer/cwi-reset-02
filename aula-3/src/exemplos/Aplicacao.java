package exemplos;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Aplicacao {
    public static void main(String[] args) {

        Diretor diretor = new Diretor("Chistopher Nolan", LocalDate.of(1996,2,23), 3, Genero.MASCULINO);
        Ator ator = new Ator("Leonardo Dicaprio", LocalDate.of(1996,2,23), 1, Genero.MASCULINO);
        Ator ator1 = new Ator("fdsihfusihfdi", LocalDate.of(1996,2,23), 1, Genero.MASCULINO);
        Ator ator2 = new Ator("hsdfuihfuishf",LocalDate.of(1996,2,23), 1, Genero.MASCULINO);

        List<Pessoa> elenco = Arrays.asList(ator, ator1, ator2);

        //List<exemplos.Pessoa> elenco = new ArrayList<exemplos.Pessoa>();
        //elenco.add(new exemplos.Ator("hfdusi", 52, 5, exemplos.Genero.MASCULINO)); //outra forma de fazer a lista

        Filme filmeInterstelar = new Filme("Interstelar", "Melhor filme", 120,
                2014, 5, diretor, elenco);
        //exemplos.Filme filmeBatman = new exemplos.Filme("Batman", "Melhor filme ever", 90, 2008,5,diretor);

        filmeInterstelar.creditos();
        //filmeBatman.exibir();
        //diretor.imprimirInformacoes();
        //ator.imprimirInformacoes();

    }
}