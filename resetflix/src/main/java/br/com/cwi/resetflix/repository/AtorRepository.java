package br.com.cwi.resetflix.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.cwi.resetflix.entity.AtorEntity;

@Repository
public class AtorRepository {

    static List<AtorEntity> atores = new ArrayList<>();
    static Long contadorIds = 1l;

    public List<AtorEntity> getAtores(){
        return atores;
    }

    public Long criarAtor(final AtorEntity atorSalvar) {
        if(atorSalvar.getId() == null){
            atorSalvar.setId(contadorIds);
            contadorIds++;
        }

        atores.add(atorSalvar);

        return atorSalvar.getId();
    }

    public AtorEntity encontrarAtorPorId(final Long id){
        return (AtorEntity) atores.stream().
                filter(ator -> ator.getId().equals(id));   //FIXME COMO RETORNAR O ATOR?
    }

    public List<AtorEntity> todosAtores(){
        return atores.stream().collect(Collectors.toList());
    }

    public List<AtorEntity> encontrarTodosAtorePorId(List<Long> ids){
        return atores.stream()
            .filter(ator -> ids.contains(ator.getId()))
            .collect(Collectors.toList());
    }

}
