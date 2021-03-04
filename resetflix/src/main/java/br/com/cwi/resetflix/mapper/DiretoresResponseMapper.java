package br.com.cwi.resetflix.mapper;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.response.AtoresResponse;
import br.com.cwi.resetflix.response.DiretoresResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class DiretoresResponseMapper{

    public List<DiretoresResponse> apply(final List<DiretorEntity> diretores) {
        List<DiretoresResponse> diretoresResponses = new ArrayList<>();

        for (DiretorEntity diretorEntity : diretores) {

            DiretoresResponse diretorResponse = new DiretoresResponse(diretorEntity.getId(),
                    diretorEntity.getNome());

            diretoresResponses.add(diretorResponse);
        }

        return diretoresResponses;
    }
}

