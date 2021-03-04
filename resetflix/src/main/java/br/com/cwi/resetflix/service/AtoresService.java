package br.com.cwi.resetflix.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import br.com.cwi.resetflix.mapper.AtorEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.exception.NotFoundException;
import br.com.cwi.resetflix.mapper.AtoresResponseMapper;
import br.com.cwi.resetflix.mapper.ConsultarDetalhesAtorResponseMapper;
import br.com.cwi.resetflix.repository.AtorRepository;
import br.com.cwi.resetflix.request.CriarAtorRequest;
import br.com.cwi.resetflix.response.AtoresResponse;
import br.com.cwi.resetflix.response.ConsultarDetalhesAtorResponse;

@Service
public class AtoresService {

    @Autowired
    private AtorRepository atorRepository;

    static AtoresResponseMapper ATORES_RESPONSE_MAPPER = new AtoresResponseMapper();
    static ConsultarDetalhesAtorResponseMapper CONSULTAR_DETALHES_ATOR_RESPONSE_MAPPER = new ConsultarDetalhesAtorResponseMapper();
    static AtoresResponseMapper ATORES_ENTITY_MAPPER = new AtorEntityMapper();

    public List<AtoresResponse> getAtores(){
       final List<AtorEntity> atores = atorRepository.getAtores();
       return ATORES_ENTITY_MAPPER.apply(atores);
    }

    public ConsultarDetalhesAtorResponse getAtorById(final Long idAtor) {
        AtorEntity ator = atorRepository.encontrarAtorPorId(idAtor);
        if(Objects.isNull(ator)){
            throw new NotFoundException("Ator não encontrado");
        }
        //FIXME FAZER UM ALGORITO PARA PEGAR A LISTA DE FILMES QUE O ATOR ATUOU
        return CONSULTAR_DETALHES_ATOR_RESPONSE_MAPPER.apply(ator, filmesAtor);
    }

    public Long criarAtor(final CriarAtorRequest request) {
        AtorEntity ator = new AtorEntity(request.getNome(), request.getIdFilmes());
        return atorRepository.criarAtor(ator);
    }

    public List<AtoresResponse> getAtoresByIdIn(final List<Long> idAtores) {
        List<AtorEntity> atores = atorRepository.encontrarTodosAtorePorId(idAtores);
        return atores.stream().map(ator -> ATORES_RESPONSE_MAPPER.apply(atores)).collect(AtoresResponse);   //FIXME COMO RETORNO UMA LISTA?
    }
}
