package br.com.futperformed.controller;



import br.com.futperformed.model.Time;
import br.com.futperformed.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TimeController {

    @Autowired
    TimeRepository timeRepository;

    @GetMapping("/times")
    public List<Time> listaTimes(){
        return timeRepository.findAll();
    }

    @GetMapping("/time/{id}")
    public Optional<Time> listaTimeUnico(@PathVariable(value = "id") Long id){
        Optional<Time> time = timeRepository.findById(id);
        return time;
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
