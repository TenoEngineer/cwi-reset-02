package br.com.cwi.resetflix.repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.cwi.resetflix.entity.AtorEntity;

@Repository
public class AtorRepository {

    static AtorEntity HENRY_CAVILL = new AtorEntity(1l, "Henry Cavill", Collections.emptyList());
    static AtorEntity BEN_AFFLECK = new AtorEntity(2l, "Ben Affleck", Collections.emptyList());

    static Long nextId = 3l;

    static HashMap<Long, AtorEntity> atores = new HashMap<Long, AtorEntity>(){{
        put(1l, HENRY_CAVILL);
        put(2l, BEN_AFFLECK);
    }};


    public AtorEntity save(AtorEntity ator){

        if(ator.getId() == null){
            ator.setId(nextId);
            nextId++;
        }

        atores.put(ator.getId(), ator);

        return ator;
    }

    public AtorEntity findById(Long id){
        return atores.get(id);
    }

    public List<AtorEntity> findAll(){
        return atores.values().stream().collect(Collectors.toList());
    }

    public List<AtorEntity> findAllByIdIn(List<Long> ids){
        return atores.values().stream()
            .filter(ator -> ids.contains(ator.getId()))
            .collect(Collectors.toList());
    }

}
