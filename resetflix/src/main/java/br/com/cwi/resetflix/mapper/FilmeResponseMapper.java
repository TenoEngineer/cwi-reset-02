package br.com.cwi.resetflix.mapper;

import java.util.List;
import java.util.function.Function;

import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.response.FilmeResponse;

public class FilmeResponseMapper implements Function<FilmeEntity, FilmeResponse>{

    @Override
    public FilmeResponse apply(final FilmeEntity filmeEntity) {
        return new FilmeResponse(filmeEntity.getId(), filmeEntity.getNome(), filmeEntity.getGenero());
    }

 }
