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

    private Beneficiario nome;
    private Imovel imovel;
    private int prazoPagamento;
    private UnidadeFederativa estado;
    private boolean resultado;
    private Beneficiario salario;

    /*private Endereco endereco;
    private Imovel valor;
    private int proposta;*/

    public PropostaFinanciamento(Beneficiario nome, Imovel imovel, int prazoPagamento, UnidadeFederativa estado, Beneficiario salario) {
        this.nome = nome;
        this.imovel = imovel;
        this.prazoPagamento = prazoPagamento;
        this.estado = estado;
        this.salario = salario;
    }

    public void validacao(String estado) {
        if (estado.equals("SP")) {
            boolean resultado = salario * prazoPagamento =>Imovel valor *0.65
        }
    }

    public void validarProposta() {
        imovel.
    }






        if(UnidadeFederativa.getEstado().

    equals(UnidadeFederativa.SP))

    {
        if (salario * mesesParaPagamento =>Imovel valor *0.65){
        int proposta = 0;
    } else if (Endereco.getEstado() == UnidadeFederativa.RJ) {
        if (salario * mesesParaPagamento =>Imovel.getValor() * 0.60;){
            int proposta = 0;
        }

    }

    } else if(false)

    {
        if (salario * mesesParaPagamento =>Imovel.getValor() * 0.5;){
        int proposta = 0;
    } else if (false) {
        int proposta = 1;
    }
    }

}

    private void imprimirPropostaAprovada() {
        System.out.println("Nome: " + nome.getNome() + "\n" +
                "Imóvel: " + "imovel" + "\n"
                + "Prazo: " + "prazo" + "\n" +
                "Mas Tchê! Tu foi aprovado o/");
    }

    private void imprimirPropostaNegada() {
        System.out.println("Nome: " + nome.getNome() + "\n" +
                "Imóvel: " + "imovel" + "\n"
                + "Prazo: " + "prazo" + "\n" +
                "Bah cara! Tu não fostes aprovado :(");
    }
}