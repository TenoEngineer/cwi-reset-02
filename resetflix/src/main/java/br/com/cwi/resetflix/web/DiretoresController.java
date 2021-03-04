package br.com.cwi.resetflix.web;

import br.com.cwi.resetflix.request.CriarDiretorRequest;
import br.com.cwi.resetflix.response.ConsultarDetalhesDiretorResponse;
import br.com.cwi.resetflix.response.DiretoresResponse;
import br.com.cwi.resetflix.service.DiretoresService;
import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diretor")
public class DiretoresController {

    @Autowired
    private DiretoresService diretoresService;

    @GetMapping
    public List<DiretoresResponse> getDiretores(){
        return diretoresService.getDiretores();
    }

    @GetMapping("/{id}")
    public ConsultarDetalhesDiretorResponse getDiretorbyId(@PathVariable("id") final Long id){
        return diretoresService.getDiretorById(id);
    }

    @PostMapping
    public Long criarDiretor(@RequestBody final CriarDiretorRequest request){
        return diretoresService.criarDiretor(request);
    }
}
