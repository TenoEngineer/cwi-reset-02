package br.com.cwi.resetflix.service;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.exception.NotFoundException;
import br.com.cwi.resetflix.mapper.AtoresResponseMapper;
import br.com.cwi.resetflix.mapper.ConsultarDetalhesDiretorResponseMapper;
import br.com.cwi.resetflix.mapper.DiretoresResponseMapper;
import br.com.cwi.resetflix.repository.DiretoresRepository;
import br.com.cwi.resetflix.request.CriarDiretorRequest;
import br.com.cwi.resetflix.response.AtoresResponse;
import br.com.cwi.resetflix.response.ConsultarDetalhesDiretorResponse;
import br.com.cwi.resetflix.response.DiretoresResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class DiretoresService {

    static ConsultarDetalhesDiretorResponseMapper CONSULTAR_DETALHES_DIRETOR_RESPONSE_MAPPER = new ConsultarDetalhesDiretorResponseMapper();
    static DiretoresResponseMapper DIRETORES_RESPONSE_MAPPER = new DiretoresResponseMapper();
    static DiretoresResponseMapper MAPPER_RESPONSE = new DiretoresResponseMapper();

    @Autowired
    private DiretoresRepository diretoresRepository;

    public List<DiretoresResponse> getDiretores() {
        final List<DiretorEntity> diretores = diretoresRepository.getDiretores();
        return (List<DiretoresResponse>) MAPPER_RESPONSE.apply(diretores);
    }

    public Long criarDiretor(final CriarDiretorRequest request){
        DiretorEntity diretor = new DiretorEntity(request.getNome(),request.getIdFilmes());
        return diretoresRepository.save(diretor).getId();
    }

    public ConsultarDetalhesDiretorResponse getDiretorById(final Long id) {
        DiretorEntity diretor = diretoresRepository.findById(id);
        if(Objects.isNull(diretor)){
            throw new NotFoundException("Diretor não encontrado");
        }
        return CONSULTAR_DETALHES_DIRETOR_RESPONSE_MAPPER.apply(diretor);  //FIXME
    }

    public List<DiretoresResponse> getDiretoresByIdIn(final List<Long> idDiretores) {       //FIXME
        List<DiretorEntity> diretores = diretoresRepository.findAllByIdIn(idDiretores);
        return diretores.stream().map(diretor -> DIRETORES_RESPONSE_MAPPER.apply(diretor)).collect(Collectors.toList());
    }

}
