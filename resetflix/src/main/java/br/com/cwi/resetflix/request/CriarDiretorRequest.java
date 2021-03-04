package br.com.cwi.resetflix.request;

import java.util.List;

public class CriarDiretorRequest extends CriarAtorRequest {

    public CriarDiretorRequest(String nome, List<Long> idFilmes) {
        super(nome, idFilmes);
    }
}
