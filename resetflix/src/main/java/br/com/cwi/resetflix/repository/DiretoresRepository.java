package br.com.cwi.resetflix.repository;


import br.com.cwi.resetflix.entity.DiretorEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DiretoresRepository {

    static List<DiretorEntity> diretores = new ArrayList<>();

    public List<DiretorEntity> getDiretores() {
        return diretores;
    }
}
