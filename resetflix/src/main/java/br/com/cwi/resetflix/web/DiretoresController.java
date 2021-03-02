package br.com.cwi.resetflix.web;

import br.com.cwi.resetflix.response.DiretoresResponse;
import br.com.cwi.resetflix.service.DiretoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
