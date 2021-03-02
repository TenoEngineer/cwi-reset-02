package br.com.cwi.resetflix.mapper;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.response.AtoresResponse;
import br.com.cwi.resetflix.response.ConsultarDetalhesFilmeResponse;

public class ConsultarDetalhesFilmeResponseMapper implements BiFunction<FilmeEntity, List<AtoresResponse>, ConsultarDetalhesFilmeResponse> {

    @Override
    public ConsultarDetalhesFilmeResponse apply(final FilmeEntity filmeEntity, final List<AtoresResponse> atores) {
        return new ConsultarDetalhesFilmeResponse(
            filmeEntity.getId(),
            filmeEntity.getNome(),
            filmeEntity.getGenero(),
            //TODO chamada diretores
            null,
            atores
        );
    }
}
