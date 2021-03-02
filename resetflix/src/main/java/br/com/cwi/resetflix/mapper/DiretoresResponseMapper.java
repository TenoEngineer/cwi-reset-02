package br.com.cwi.resetflix.mapper;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.response.AtoresResponse;
import br.com.cwi.resetflix.response.DiretoresResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class DiretoresResponseMapper implements Function<DiretorEntity, DiretoresResponse> {

    @Override
    public DiretoresResponse apply(final DiretorEntity diretor) {
        return new DiretoresResponse(diretor.getId(), diretor.getNome());
    }
}

