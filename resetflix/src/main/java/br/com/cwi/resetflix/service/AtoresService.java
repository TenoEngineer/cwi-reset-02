package br.com.cwi.resetflix.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    public List<AtoresResponse> getAtores(){
       List<AtorEntity> atores = atorRepository.findAll();
       return atores.stream()
           .map(ator -> ATORES_RESPONSE_MAPPER.apply(ator))
           .collect(Collectors.toList());
    }

    public ConsultarDetalhesAtorResponse getAtorById(final Long id) {
        AtorEntity ator = atorRepository.findById(id);
        if(Objects.isNull(ator)){
            throw new NotFoundException("Ator não encontrado");
        }
        return CONSULTAR_DETALHES_ATOR_RESPONSE_MAPPER.apply(ator);
    }

    public Long criarAtor(final CriarAtorRequest request) {
        AtorEntity ator = new AtorEntity(request.getNome(), request.getIdFilmes());
        return atorRepository.save(ator).getId();
    }

    public List<AtoresResponse> getAtoresByIdIn(final List<Long> idAtores) {
        List<AtorEntity> atores = atorRepository.findAllByIdIn(idAtores);
        return atores.stream().map(ator -> ATORES_RESPONSE_MAPPER.apply(ator)).collect(Collectors.toList());
    }
}
