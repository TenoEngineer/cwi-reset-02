package exemplo.aula;

import java.util.Arrays;

public class Aplicacao {

    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario("123456789","Heitor", 25, 800, "Projetista", "Contratado");
        System.out.println("Salário liquido: " + funcionario.calcularSalarioLiquido());

    }
}
