package exemplo.aula;

public enum Cargo {
    DESENVOLVEDOR(1.1, "Desenvolvedor"),
    LIDER_TECNICO(1.15, "Líder Técnico"),
    ENGENHEIRO_SOLUCOES(1.2, "Engenheiro de Soluções");

    private double bonus;
    private String nome;

    Cargo(double bonus, String nome){
        this.bonus = bonus;
        this.nome = nome;
    }

    public double getBonus() {
        return bonus;
    }

    public String getNome() {
        return nome;
    }
}
