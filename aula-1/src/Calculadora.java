public class Calculadora {

    private int soma;
    private int subtrai;
    private int multiplica;
    private int divide;
    private int valor1;
    private int valor2;

    public Calculadora(int valor1, int valor2) {   //Chama os valores da classe
        this.valor1 = valor1;
        this.valor2 = valor2;
    }

    public int getSoma() {                          //método de soma
        int soma = valor1 + valor2;
        return soma;
    }

    public int getSubtrai() {                       //método de subtrair
        int subtrai = valor1 - valor2;
        return subtrai;
    }

    public int getMultiplica() {                    //método de multiplicação
        int multiplica = valor1 * valor2;
        return multiplica;
    }

    public int getDivide() {                        //método de divisão
        int divide = valor1 / valor2;
        return divide;
    }
}
