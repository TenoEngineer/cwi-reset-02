package br.com.cwi.resetflix.mapper;

import java.util.Collections;
import java.util.function.Function;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.response.ConsultarDetalhesAtorResponse;

public class ConsultarDetalhesAtorResponseMapper implements Function<AtorEntity, ConsultarDetalhesAtorResponse> {

    @Override
    public ConsultarDetalhesAtorResponse apply(final AtorEntity ator) {
        return new ConsultarDetalhesAtorResponse(ator.getId(), ator.getNome(),
            //TODO INCLUIR FILME RESPONSE
            Collections.emptyList());
    }
}
