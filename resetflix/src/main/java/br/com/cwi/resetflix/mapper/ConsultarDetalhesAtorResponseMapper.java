package br.com.cwi.resetflix.mapper;

import java.util.List;
import java.util.function.Function;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.response.ConsultarDetalhesAtorResponse;
import br.com.cwi.resetflix.response.FilmeResponse;

public class ConsultarDetalhesAtorResponseMapper {

    public ConsultarDetalhesAtorResponse apply(final AtorEntity ator, final List<FilmeEntity> filmesAtor) {
        List<FilmeResponse> filmesResponse = (List<FilmeResponse>) new FilmeResponseMapper().apply((FilmeEntity) filmesAtor);
        return new ConsultarDetalhesAtorResponse(ator.getId(), ator.getNome(), filmesResponse);
    }
}
