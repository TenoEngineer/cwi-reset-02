package br.com.cwi.resetflix.repository;


import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DiretoresRepository {

    static Long contadorId = 1l;

    static List<DiretorEntity> diretores = new ArrayList<>();

    public List<DiretorEntity> getDiretores() {
        return diretores;
    }


    public AtorEntity save(final DiretorEntity diretor) {

        if (diretor.getId() == null) {
            diretor.setId(contadorId);
            contadorId++;
        }
        diretores.add(diretor);

        return diretor;
    }

    public DiretorEntity findById(Long id) { return diretores.get(Math.toIntExact(id));} //TODO refazer

    //public List<DiretorEntity> findAll() { return diretores.values().stream}               //TODO refazer

    public List<DiretorEntity> findAllByIdIn(List<Long> ids) {
        return diretores.values().stream()
                .filter(diretoe -> ids.contains(diretor.getId()))
                .collect(Collectors.toList());
    }
}
