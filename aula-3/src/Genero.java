public enum Genero {
    MASCULINO("Masculino"),
    FEMININO("Feminino"),
    NÃO_BINARIO("Não Binário");

    private String descricao;

    Genero(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
