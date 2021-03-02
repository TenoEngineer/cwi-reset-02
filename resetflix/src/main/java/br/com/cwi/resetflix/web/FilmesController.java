
package br.com.cwi.resetflix.web;

import static java.util.Arrays.asList;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.request.CriarFilmeRequest;
import br.com.cwi.resetflix.response.AtoresResponse;
import br.com.cwi.resetflix.response.ConsultarDetalhesFilmeResponse;
import br.com.cwi.resetflix.response.DiretoresResponse;
import br.com.cwi.resetflix.response.FilmeResponse;
import br.com.cwi.resetflix.service.FilmesService;

@RestController
@RequestMapping("/filmes")
public class FilmesController implements FilmesContract {

    @Autowired
    private FilmesService filmesService;

    @GetMapping
    public List<FilmeResponse> getFilmes(@RequestParam(value = "genero", required = false) final Genero genero) {
        return filmesService.getFilmesByGenero(genero);
    }

    @GetMapping("/{id}")
    public ConsultarDetalhesFilmeResponse getFilmeById(@PathVariable("id") final Long id) {
        return filmesService.getFilmeById(id);
    }

    @PostMapping
    public Long criarFilme(@RequestBody final CriarFilmeRequest request) {
        return filmesService.criarFilme(request);
    }

    @GetMapping("/recomendacoes")
    public List<FilmeResponse> getRecomendacoesFilmes() {
        //TODO realizar chamada
        final List<FilmeResponse> filmes = asList(new FilmeResponse(1l, "Liga Da Justiça", Genero.COMEDIA),
            new FilmeResponse(2l, "Zack Snyder's Justice League", Genero.EPICO));

        return filmes;
    }

    @PostMapping("/{id}/assistir")
    public void assistirFilme(@PathVariable("id") final Long id) {
        //TODO realizar chamada
    }
}
