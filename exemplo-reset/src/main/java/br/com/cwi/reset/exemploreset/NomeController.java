package br.com.cwi.reset.exemploreset;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nome")
public class NomeController {

    private static String nome = "Heitor";

    @GetMapping
    public String retornarNome() {
        return nome;
    }

    @PutMapping("/{nome}")
    public String trocarNome(@PathVariable("nome") String novoNome) {
        this.nome = novoNome;
        return this.nome;
    }

    @DeleteMapping
    public void deletarNome() {
        this.nome = null;
    }
}
