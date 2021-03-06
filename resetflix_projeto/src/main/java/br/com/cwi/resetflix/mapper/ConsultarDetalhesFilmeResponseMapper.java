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
                                                 final DiretorEntity filmeDiretor,
                                                 final FilmeEntity filme){
        List<AtoresResponse> atoresResponse = new AtoresResponseMapper().mapear(filmeAtores);
        DiretoresResponse diretoresResponse = new DiretoresResponse(filmeDiretor.getId(), filmeDiretor.getNome());
        return new ConsultarDetalhesFilmeResponse(filme.getId(), filme.getNome(), filme.getGenero(), diretoresResponse, atoresResponse);        //FIXME PROBLEMA COM LIST NOS DIRETORES
        //FIXME AQUI EU RETORNO CARACTERISTICAS FILME + DIRETOR + ATORES? OU FAÇO ISSO NO SERVICE? OU NOS DOIS?
    }
}
