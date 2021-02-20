package com.company;

import com.company.domin.Editora;
import com.company.domin.Filme;
import com.company.enumeracao.Genero;
import com.company.heranca.Diretor;

import java.util.Arrays;

public class AplicacaoTeste {
    public static void main(String[] args) {


        Editora editora = new Editora("DC Comics", "Eua");

        System.out.println("Editora: " + editora.getNome());

        Editora editora2 = new Editora("Marvel Comics", "Eua");

        System.out.println("Editora: " + editora.getNome());

        Diretor eu = new Diretor("eu", 25, 5, Genero.MASCULINO);

        Filme interstelar = new Filme("Interstelar","dsahdaui", 2,2010,6,eu);

        }
}
