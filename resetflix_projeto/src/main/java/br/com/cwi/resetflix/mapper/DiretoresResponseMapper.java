package br.com.cwi.resetflix.mapper;

import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.response.DiretoresResponse;

import java.util.List;

public class DiretoresResponseMapper {

    public DiretoresResponse mapear(final List<DiretorEntity> diretor) {

        for (DiretorEntity diretorEntity : diretor) {
            DiretoresResponse diretorFilmes = new DiretoresResponse(diretorEntity.getId(),
                    diretorEntity.getNome());
            return diretorFilmes;
        }

        return null;
    }
}
