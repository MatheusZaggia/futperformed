package br.com.futperformed.controller;

import br.com.futperformed.model.Jogo;
import br.com.futperformed.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogo")
public class JogoController {

    @Autowired
    JogoRepository jogoRepository;

    @GetMapping("/jogos")
    public List<Jogo> listaJogos(){
        return jogoRepository.findAll();
    }

    @GetMapping("/jogo/{id}")
    public Jogo listaJogoUnico(@PathVariable(value = "id") int id){
        return jogoRepository.findById(id);
    }

    @PostMapping("/jogo")
    public Jogo salvaJogo(@RequestBody Jogo jogo){
        return jogoRepository.save(jogo);
    }

    @DeleteMapping("/jogo")
    public void deletaJogo(@RequestBody Jogo jogo){
        jogoRepository.delete(jogo);
    }

    @PutMapping("/jogo")
    public Jogo atualizaJogo(@RequestBody Jogo jogo){
        return jogoRepository.save(jogo);
    }


}