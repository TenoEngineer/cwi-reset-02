public class Alunos {

    private String nomeAluno;
    private double notaFinal;
    private boolean situacaoAluno;


    public Alunos(String nomeAluno, double notaFinal){
        this.nomeAluno = nomeAluno;
        this.notaFinal = notaFinal;

        System.out.println("Nome do Aluno: " + nomeAluno + "; Nota Final: " + notaFinal);

    }

    public boolean isSituacaoAluno() {
        boolean situacaoAluno = notaFinal >= 7;
        return situacaoAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public double getNotaFinal() {
        return notaFinal;
    }
}
