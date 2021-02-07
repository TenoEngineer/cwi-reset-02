import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");


        Calculadora hp = new Calculadora();
        int resultadoSoma = hp.soma(5, 5);
        System.out.println(resultadoSoma);

        Calculadora subt = new Calculadora();
        int resultadoSubitrai = subt.subtrai(20, 10);
        System.out.println(resultadoSubitrai);

        Calculadora mult = new Calculadora();
        int resultadoMultiplica = mult.multiplica(2,5);
        System.out.println(resultadoMultiplica);

        Calculadora div = new Calculadora();
        int resultadoDivide = div.divide(20,2);
        System.out.println(resultadoDivide);

        Camparador comp = new Camparador();
        boolean resultadoMenorQue = comp.menorQue(10,5);
        System.out.println(resultadoMenorQue);
    }
}
