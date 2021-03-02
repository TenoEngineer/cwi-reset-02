package br.com.cwi.resetflix.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cwi.resetflix.service.AtoresService;
import br.com.cwi.resetflix.request.CriarAtorRequest;
import br.com.cwi.resetflix.response.AtoresResponse;
import br.com.cwi.resetflix.response.ConsultarDetalhesAtorResponse;

@RestController
@RequestMapping("/atores")
public class AtoresController implements AtoresContract {

    @Autowired
    private AtoresService atoresService;

    @GetMapping
    public List<AtoresResponse> getAtores() {
        return atoresService.getAtores();
    }

    @GetMapping("/{id}")
    public ConsultarDetalhesAtorResponse getAtorById(@PathVariable("id") final Long id) {
       return atoresService.getAtorById(id);
    }

    @PostMapping
    public Long criarAtor(@RequestBody final CriarAtorRequest request) {
        return atoresService.criarAtor(request);
    }
}
