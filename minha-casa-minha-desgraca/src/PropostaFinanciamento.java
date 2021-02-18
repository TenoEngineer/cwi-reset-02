public class PropostaFinanciamento {

    /**
     * Valida a proposta de financiamento e apresenta o resultado para o cliente.
     * <p>
     * A proposta de financiamento é aceita somente se o salário do beneficiário multiplicado pelo prazo de pagamento
     * for equivalente a pelo menos 50% do valor do imóvel.
     * <p>
     * Esta regra possui duas exceções: se o imóvel se localiza no estado SP ou RJ,
     * o salário multiplicado pelo prazo deve ser equivalente a 65% e 60% do valor imóvel (respectivamente).
     */

    private Beneficiario beneficiario;
    private Imovel imovel;
    private int mesesParaPagamento;
    private UnidadeFederativa estado;
    private boolean resultado;

    /*private Endereco endereco;
    private Imovel valor;
    private int proposta;*/

    public PropostaFinanciamento(Beneficiario beneficiario, Imovel imovel, int mesesParaPagamento,
                                 UnidadeFederativa estado) {
        this.beneficiario = beneficiario;
        this.imovel = imovel;
        this.mesesParaPagamento = mesesParaPagamento;
        this.estado = estado;
    }

    boolean excessao = estado.getEstado().equals("SP") && estado.getEstado().equals("RJ");
    boolean resultadoSP = beneficiario.getSalario() * mesesParaPagamento >= imovel.getValor() * 0.65;
    boolean resultadoRJ = beneficiario.getSalario() * mesesParaPagamento >= imovel.getValor() * 0.60;
    boolean resultadoGeral = beneficiario.getSalario() * mesesParaPagamento >= imovel.getValor() * 0.50;


    public void validarProposta() {
        if (excessao) {
            if (estado.getEstado().equals("SP")) {
                if (resultadoSP) {
                    imprimirPropostaAprovada();
                } else if (resultadoSP) {
                    imprimirPropostaNegada();
                }
            } else if (estado.getEstado().equals("RJ")) {
                imprimirPropostaAprovada();
            } else (estado.getEstado().equals("RJ")) {
                imprimirPropostaNegada();
            }
        } else if (excessao) {
            if (resultadoGeral) {
                imprimirPropostaAprovada();
            } else if (resultadoGeral) {
                imprimirPropostaNegada();
            }
        }
    }

    private void imprimirPropostaAprovada() {
        System.out.println("Nome: " + beneficiario.getNome() + "\n" +
                "Imóvel: " + imovel.getNome() + "\n"
                + "Prazo: " + "prazo" + "\n" +
                "Mas Tchê! Tu foi aprovado o/");
    }

    private void imprimirPropostaNegada() {
        System.out.println("Nome: " + beneficiario.getNome() + "\n" +
                "Imóvel: " + imovel.getNome() + "\n"
                + "Prazo: " + "prazo" + "\n" +
                "Bah cara! Tu não fostes aprovado :(");
    }
}