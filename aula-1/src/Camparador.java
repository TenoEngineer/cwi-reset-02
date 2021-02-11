public class Camparador {
    private int valor1;
    private int valor2;
    private boolean comparacao;

    public Camparador(int valor1, int valor2) {
        this.valor1 = valor1;
        this.valor2 = valor2;
    }

    public boolean isComparacao() {
        comparacao = valor1 < valor2;
        return comparacao;
    }
}