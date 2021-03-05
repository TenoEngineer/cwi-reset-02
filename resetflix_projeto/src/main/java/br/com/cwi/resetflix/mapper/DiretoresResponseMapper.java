package br.com.cwi.resetflix.mapper;

import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.response.DiretoresResponse;

public class DiretoresResponseMapper {

    public DiretoresResponse mapear(final DiretorEntity diretor) {
        if(diretor.getId())

            return diretoresResponses;
        }
        return null;

    }
}
