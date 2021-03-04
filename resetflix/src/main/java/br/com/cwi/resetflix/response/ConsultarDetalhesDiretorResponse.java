package br.com.cwi.resetflix.response;

import br.com.cwi.resetflix.entity.DiretorEntity;

import java.util.List;

public class ConsultarDetalhesDiretorResponse extends ConsultarDetalhesAtorResponse {

    public ConsultarDetalhesDiretorResponse(Long id, String nome, List<FilmeResponse> filmes) {
        super(id, nome, filmes);
    }
}
