package br.com.cwi.resetflix.mapper;

import java.util.function.Function;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.response.AtoresResponse;

public class AtoresResponseMapper implements Function<AtorEntity, AtoresResponse> {

    @Override
    public AtoresResponse apply(final AtorEntity ator) {
        return new AtoresResponse(ator.getId(), ator.getNome());
    }

}
