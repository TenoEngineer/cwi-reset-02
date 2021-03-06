package br.com.cwi.resetflix.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.response.AtoresResponse;
import org.w3c.dom.ls.LSInput;

public class AtoresResponseMapper {

    public List<AtoresResponse> apply(final List<AtorEntity> atores) {
        List<AtoresResponse> atoresResponses = new ArrayList<>();

        for (AtorEntity atorEntity : atores) {
            AtoresResponse atorResponse = new AtoresResponse(atorEntity.getId(), atorEntity.getNome());
            atoresResponses.add(atorResponse);
        }

        return atoresResponses;
    }
}
