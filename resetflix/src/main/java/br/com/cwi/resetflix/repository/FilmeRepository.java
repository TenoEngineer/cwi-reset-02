package br.com.cwi.resetflix.repository;

import static java.util.Arrays.asList;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;

@Repository
public class FilmeRepository {

    static Long nextId = 3l;

    static FilmeEntity LIGA_DA_JUSTIÇA = new FilmeEntity(1l, "Liga da Justiça", Genero.RUIM, null, asList(1l, 2l));
    static FilmeEntity MAN_FROM_UNCLE = new FilmeEntity(2l, "Man from U.N.C.L.E", Genero.ACAO, null, asList(1l));

    static HashMap<Long, FilmeEntity> filmes = new HashMap<Long, FilmeEntity>() {{
        put(1l, LIGA_DA_JUSTIÇA);
        put(2l, MAN_FROM_UNCLE);
    }};


    public FilmeEntity save(FilmeEntity filme) {

        if (filme.getId() == null) {
            filme.setId(nextId);
            nextId++;
        }

        filmes.put(filme.getId(), filme);

        return filme;
    }

    public FilmeEntity findById(Long id) {
        return filmes.get(id);
    }

    public List<FilmeEntity> findAll() {
        return filmes.values().stream().collect(Collectors.toList());
    }

    public List<FilmeEntity> findAllByGenero(Genero genero) {
        if (genero == null) {
            return findAll();
        } else {
            return filmes.values().stream()
                .filter(filme -> filme.getGenero().equals(genero))
                .collect(Collectors.toList());
        }
    }
}
