package exemplo.aula;

public class Funcionario extends Pessoa {

    private double salario;
    private Cargo cargo;
    private String status;
    private int anosDeEmpresa;

    public Funcionario(String cpf, String nome, int idade, double salario, Cargo cargo, String status) {
        super(cpf, nome, idade);
        this.salario = salario;
        this.cargo = cargo;
        this.status = status;
        this.anosDeEmpresa = 0;
    }

    public double calcularSalarioLiquido() {
        return this.salario * 0.8 * cargo.getBonus();
    }

    @Override
    public void fazerAniversario() {
        super.fazerAniversario();
        this.anosDeEmpresa = ++this.anosDeEmpresa;
    }

}
