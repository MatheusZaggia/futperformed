package br.com.futperformed.controller;


import br.com.futperformed.model.JogadorTime;
import br.com.futperformed.model.Quadra;
import br.com.futperformed.model.Time;
import br.com.futperformed.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time")
public class TimeController {

    @Autowired
    TimeRepository timeRepository;

    @GetMapping("/times")
    public List<Time> listaTimes(){
        return timeRepository.findAll();
    }

    @GetMapping("/time/{id}")
    public Time listaTimeUnico(@PathVariable(value = "id") int id){
        return timeRepository.findById(id);
    }

    @PostMapping("/time")
    public Time salvaTime(@RequestBody Time time){
        return timeRepository.save(time);
    }

    @DeleteMapping("/time")
    public void deletaTime(@RequestBody Time time){
        timeRepository.delete(time);
    }

    @PutMapping("/time")
    public Time atualizaJogadorTime(@RequestBody Time time){
        return timeRepository.save(time);
    }

}
