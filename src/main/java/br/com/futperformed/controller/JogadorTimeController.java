package br.com.futperformed.controller;

import br.com.futperformed.model.JogadorTime;
import br.com.futperformed.repository.JogadorTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class JogadorTimeController {


    @Autowired
    JogadorTimeRepository jogadorTimeRepository;

    @GetMapping("/jogadoresTime")
    public List<JogadorTime> listaJogadoresTime(){
        return jogadorTimeRepository.findAll();
    }

    @GetMapping("/jogadorTime/{id}")
    public Optional<JogadorTime> listaJogadorTimeUnico(@PathVariable(value = "id") Long id){
        Optional<JogadorTime> jogadorTime = jogadorTimeRepository.findById(id);
        return jogadorTime;
    }


    @GetMapping("/jogadorTime/{nome}")
    public JogadorTime listaNomeJogadorTime(@PathVariable(value = "nome") String nome){
        return jogadorTimeRepository.findByNomeJogador(nome);
    }


    @PostMapping("/jogadorTime")
    public JogadorTime salvaJogadorTime(@RequestBody JogadorTime jogadorTime){
        return jogadorTimeRepository.save(jogadorTime);
    }

    @DeleteMapping("/jogadorTime")
    public void deletaJogadorTime(@RequestBody JogadorTime jogadorTime){
        jogadorTimeRepository.delete(jogadorTime);
    }

    @PutMapping("/jogadorTime")
    public JogadorTime atualizaJogadorTime(@RequestBody JogadorTime jogadorTime){
        return jogadorTimeRepository.save(jogadorTime);
    }


}