package br.com.cwi.resetflix.mapper;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.response.AtoresResponse;
import br.com.cwi.resetflix.response.ConsultarDetalhesFilmeResponse;
import br.com.cwi.resetflix.response.DiretoresResponse;
import br.com.cwi.resetflix.response.FilmeResponse;
import br.com.cwi.resetflix.web.FilmesController;

import java.util.List;

public class ConsultarDetalhesFilmeResponseMapper {

    public ConsultarDetalhesFilmeResponse mapear(final List<AtorEntity> filmeAtores,
                                                 final List<DiretorEntity> filmeDiretor,
                                                 final FilmeEntity filme){
        List<AtoresResponse> filmeResponses = new AtoresResponseMapper().mapear(filmeAtores);
        List<DiretoresResponse> diretoresResponse = new DiretoresResponseMapper().mapear(filmeDiretor);
        return new ConsultarDetalhesFilmeResponse(filme.getId(), filme.getNome(), filme.getGenero(), diretoresResponse , filmeResponses);        //FIXME PROBLEMA COM LIST NOS DIRETORES

    }
}
