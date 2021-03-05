package br.com.cwi.resetflix.mapper;

import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.response.AtoresResponse;
import br.com.cwi.resetflix.response.DiretoresResponse;

import java.util.ArrayList;
import java.util.List;

public class DiretoresResponseMapper {

    public List<DiretoresResponse> mapear(final List<DiretorEntity> diretor) {
        List<DiretoresResponse> diretoresResponses = new ArrayList<>();

        for (DiretorEntity diretorEntity : diretor) {

            DiretoresResponse diretorResponse = new DiretoresResponse(diretorEntity.getId(),
                    diretorEntity.getNome());

            diretoresResponses.add(diretorResponse);
        }

        return diretoresResponses;
    }
}
