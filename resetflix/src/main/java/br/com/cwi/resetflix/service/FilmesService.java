package br.com.cwi.resetflix.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.mapper.ConsultarDetalhesFilmeResponseMapper;
import br.com.cwi.resetflix.mapper.FilmeResponseMapper;
import br.com.cwi.resetflix.repository.FilmeRepository;
import br.com.cwi.resetflix.request.CriarFilmeRequest;
import br.com.cwi.resetflix.response.AtoresResponse;
import br.com.cwi.resetflix.response.ConsultarDetalhesFilmeResponse;
import br.com.cwi.resetflix.response.FilmeResponse;

@Service
public class FilmesService {

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private AtoresService atoresService;

    static FilmeResponseMapper FILME_RESPONSE_MAPPER = new FilmeResponseMapper();
    static ConsultarDetalhesFilmeResponseMapper CONSULTAR_DETALHES_RESPONSE_MAPPER = new ConsultarDetalhesFilmeResponseMapper();

    public List<FilmeResponse> getFilmesByGenero(final Genero genero) {
        List<FilmeEntity> filmes = filmeRepository.findAllByGenero(genero);
        return filmes.stream().map(filme -> FILME_RESPONSE_MAPPER.apply(filme)).collect(Collectors.toList());
    }

    public ConsultarDetalhesFilmeResponse getFilmeById(final Long id) {
        FilmeEntity filme = filmeRepository.findById(id);
        List<AtoresResponse> atores = atoresService.getAtoresByIdIn(filme.getIdAtores());
        return CONSULTAR_DETALHES_RESPONSE_MAPPER.apply(filme, atores);
    }

    public Long criarFilme(final CriarFilmeRequest request) {
        final FilmeEntity filmeEntity = new FilmeEntity(request.getNome(), request.getGenero(), request.getIdDiretor(), request.getIdsAtores());
        return filmeRepository.save(filmeEntity).getId();
    }
}