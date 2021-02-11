import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //EXEMPLO INICIAL
        System.out.println("Hello World");

        //EXERCÍCIO 1
        Calculadora hp = new Calculadora(10,20);
        System.out.println("Resultado Soma: " + hp.getSoma());
        System.out.println("Resultado Subtrai: " + hp.getSubtrai());
        System.out.println("Resultado Multiplica: " + hp.getMultiplica());
        System.out.println("Resultado Divide: " + hp.getDivide());

        //EXERCÍCIO 2
        Camparador compara = new Camparador(5,6);
        System.out.println("Valor1 é maior que Valor2? " + compara.isComparacao());

        //EXERCÍCIO 3
        Alunos heitor = new Alunos("Heitor", 3);
        System.out.println("Nome: " + heitor.getNomeAluno());
        System.out.println("Nota: " + heitor.getNotaFinal());
        System.out.println("Aluno aprovado: " + heitor.isSituacaoAluno());

    }
}
