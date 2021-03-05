package br.com.cwi.resetflix.service;

import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.mapper.ConsultarDetalhesDiretorResponseMapper;
import br.com.cwi.resetflix.mapper.ConsultarDetalhesFilmeResponseMapper;
import br.com.cwi.resetflix.mapper.FilmeEntityMapper;
import br.com.cwi.resetflix.mapper.FilmeResponseMapper;
import br.com.cwi.resetflix.repository.FilmeRepository;
import br.com.cwi.resetflix.request.CriarFilmeRequest;
import br.com.cwi.resetflix.response.ConsultarDetalhesFilmeResponse;
import br.com.cwi.resetflix.response.FilmeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FilmesService {

    @Autowired
    private FilmeRepository filmeRepository;

    static FilmeResponseMapper MAPPER_RESPONSE = new FilmeResponseMapper();
    static FilmeEntityMapper MAPPER_ENTITY = new FilmeEntityMapper();
    static ConsultarDetalhesFilmeResponseMapper MAPPER_DETALHES = new ConsultarDetalhesFilmeResponseMapper();

    public List<FilmeResponse> getFilmes(){
        final List<FilmeEntity> filmes = filmeRepository.getFilmes();
        return MAPPER_RESPONSE.mapear(filmes);
    }

    public Long criarFilme(final CriarFilmeRequest request) {
        FilmeEntity filmeSalvar = MAPPER_ENTITY.mapear(request);
        return filmeRepository.criarFilme(filmeSalvar);
    }

    public ConsultarDetalhesFilmeResponse consultarDetalhesFilme(final Long idFilme){
        FilmeEntity filmeSalvo = filmeRepository.acharFilmePorId(idFilme);
        //List<FilmeEntity> filmeAtores = filmeRepository.acharAtorPorFilme();
        //List<FilmeEntity> filmeDiretor = filmeRepository.acharDiretorPorFilme();
        return MAPPER_DETALHES.mapear(filmeSalvo,atorSalvo, diretorSalvo)

    }
}
