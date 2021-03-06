package br.com.cwi.resetflix.repository;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.mapper.AtoresResponseMapper;
import br.com.cwi.resetflix.mapper.FilmeResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.FilmeEntity;

@Repository
public class FilmeRepository {

    /*static List<FilmeEntity> filmes = Collections.singletonList(
            new FilmeEntity(1l, "Interestelar", Genero.FICCAO_CIENTIFICA,
                    1l, asList(1l))
    );*/

    static List<FilmeEntity> filmes = new ArrayList<>();
    static Long contadorIds = 1l;
    static AtoresResponseMapper MAPPER_ATOR = new AtoresResponseMapper();

    public List<FilmeEntity> getFilmes() {
        return filmes;
    }

    public List<FilmeEntity> acharFilmesAtor(final Long idAtor) {
        List<FilmeEntity> filmesAtor = new ArrayList<>();

        for (FilmeEntity filmeEntity : filmes) {
            if (filmeEntity.getIdsAtores().equals(idAtor)) {
                filmesAtor.add(filmeEntity);
            }
        }
        return filmesAtor;
    }

    public List<FilmeEntity> encontrarFilmesDiretor(final Long idDiretor) {
        List<FilmeEntity> filmesDiretor = new ArrayList<>();

        for (FilmeEntity filmeEntity : filmes) {
            if (filmeEntity.getIdDiretor().equals(idDiretor)) {
                filmesDiretor.add(filmeEntity);
            }
        }
        return filmesDiretor;
    }

    public Long criarFilme(final FilmeEntity filmeSalvar) {
        if (filmeSalvar.getId() == null) {
            filmeSalvar.setId(contadorIds);
            contadorIds++;
        }

        filmes.add(filmeSalvar);

        return filmeSalvar.getId();
    }

    public FilmeEntity acharFilmePorId(Long idFilme) {

        for (FilmeEntity filmeEntity : filmes) {
            if (filmeEntity.getId().equals(idFilme)) {
                return filmeEntity;
            }
        }
        return null;
    }

    public List<FilmeEntity> acharAtorPorFilme(final Long idFilme) {
        List<AtorEntity> atoresFilmes = new ArrayList<>();

        for (FilmeEntity filmeEntity : filmes) {
            for (AtorEntity atorEntity.get : filmeEntity.getIdsAtores()){
            atoresFilmes.add(filmeEntity);
            return MAPPER_ATOR.mapear(atoresFilmes);}

        }
        return null;
    }

    public List<FilmeEntity> acharDiretorPorFilme(final Long idFilme) {
        List<FilmeEntity> diretorFilme = new ArrayList<>();

        for (FilmeEntity filmeEntity : filmes) {
            if (filmeEntity.getId().equals(idFilme)) {
                diretorFilme.add(filmeEntity);
            }
        }
        return diretorFilme;
    }

}
