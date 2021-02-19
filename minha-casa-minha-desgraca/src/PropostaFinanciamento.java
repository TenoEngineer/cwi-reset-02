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
    private Imovel imovelEscolhido;
    private int mesesParaPagamento;
    private UnidadeFederativa estado;

    public PropostaFinanciamento(Beneficiario beneficiario, Imovel imovelEscolhido, int mesesParaPagamento) {
        this.beneficiario = beneficiario;
        this.imovelEscolhido = imovelEscolhido;
        this.mesesParaPagamento = mesesParaPagamento;
    }

    public void validarProposta() {

        boolean excessao = imovelEscolhido.getEndereco().getEstado() == UnidadeFederativa.SP &&
                imovelEscolhido.getEndereco().getEstado() == UnidadeFederativa.RJ;
        boolean resultadoSP = beneficiario.getSalario() * mesesParaPagamento >= imovelEscolhido.getValor() * 0.65;
        boolean resultadoRJ = beneficiario.getSalario() * mesesParaPagamento >= imovelEscolhido.getValor() * 0.60;
        boolean resultadoGeral = beneficiario.getSalario() * mesesParaPagamento >= imovelEscolhido.getValor() * 0.50;

        if (excessao) {
            if (imovelEscolhido.getEndereco().getEstado() == UnidadeFederativa.SP) {
                if (resultadoSP) {
                    imprimirPropostaAprovada();
                } else {
                    imprimirPropostaNegada();
                }
            } else if (imovelEscolhido.getEndereco().getEstado() == UnidadeFederativa.RJ) {
                imprimirPropostaAprovada();
            } else {
                imprimirPropostaNegada();
            }
        } else {
            if (resultadoGeral) {
                imprimirPropostaAprovada();
            } else {
                imprimirPropostaNegada();
            }
        }
    }

    private void imprimirPropostaAprovada() {
        System.out.println("Nome: " + beneficiario.getNome() + "\n" +
                "Imóvel: " + imovelEscolhido.apresentacao() + "\n" +
                "Tipo: " + imovelEscolhido.getTipo() + "\n" +
                "Prazo: " + mesesParaPagamento + "\n" +
                "Mas Tchê! Tu foi aprovado o/");
    }

    private void imprimirPropostaNegada() {
        System.out.println("Nome: " + beneficiario.getNome() + "\n" +
                "Imóvel: " + imovelEscolhido.apresentacao() + "\n" +
                "Tipo: " + imovelEscolhido.getTipo() + "\n" +
                "Bah cara! Tu não fostes aprovado :(");
    }
}