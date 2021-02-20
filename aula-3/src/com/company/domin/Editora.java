package com.company.domin;

import com.company.exceptions.EditoraException;

public class Editora {

    private String nome;
    private String localizacao;


    public Editora(String nome, String localizacao) {
        validarNome(nome);
        this.nome = nome;
        this.localizacao = localizacao;
    }

    private void validarNome(String nome) {
        if (nome.equals("DC Comics")) {
            throw new EditoraException("\n\nVocê tem bom gosto, mas aqui só aceita Marvel\n");
        }
    }

    public String getNome() {
        return nome;
    }

}
