package br.com.futperformed.controller;

import br.com.futperformed.model.JogadorTime;
import br.com.futperformed.model.Jogo;
import br.com.futperformed.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class JogoController {

    @Autowired
    JogoRepository jogoRepository;

    @GetMapping("/jogos")
    public List<Jogo> listaJogos(){
        return jogoRepository.findAll();
    }

    @GetMapping("/jogo/{id}")
    public Optional<Jogo> listaJogoUnico(@PathVariable(value = "id") Long id){
        Optional<Jogo> jogo = jogoRepository.findById(id);
        return jogo;
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