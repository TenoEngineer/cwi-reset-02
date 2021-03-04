package br.com.cwi.resetflix.repository;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.FilmeEntity;

@Repository
public class FilmeRepository {

    @Autowired
    private AtorEntity atorEntity;

    @Autowired
    private DiretorEntity diretorEntity;

    @Autowired
    private DiretoresRepository diretoresRepository;

    static List<FilmeEntity> filmes = Collections.singletonList(
            new FilmeEntity(1l, "Interestelar", Genero.FICCAO_CIENTIFICA,
                    1l, asList(1l))
    );

    public List<FilmeEntity> getFilmes() {
        return filmes;
    }

    public List<FilmeEntity> acharFilmesAtor(final Long id) {
        List<FilmeEntity> filmesAtor = new ArrayList<>();
        AtorEntity ator = new AtorEntity(atorEntity.getNome(), atorEntity.getIdsFilmes());

        for (FilmeRepository filmeRepository : ator.getId()){

        }
        //TODO Filtrar na repository por id de ator
        return filmes;
    }

    public List<FilmeEntity> encontrarFilmesDiretor(final Long id){
        List<FilmeEntity> filmesDiretor = new ArrayList<>();
        DiretorEntity diretor = diretoresRepository.encontrarDiretorPorId(id);

        for (FilmeEntity filmeEntity : filmes){
            if(filmeEntity.getId().equals(diretor){
                filmesDiretor.add(filmeEntity);
            }
        }
        return filmesDiretor;
    }

}
