package br.com.futperformed.controller;

import br.com.futperformed.model.JogadorTime;
import br.com.futperformed.model.Quadra;
import br.com.futperformed.repository.QuadraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class QuadraController {

    @Autowired
    QuadraRepository quadraRepositoryy;

    @GetMapping("/quadras")
    public List<Quadra> listaQuadras(){
        return quadraRepositoryy.findAll();
    }

    @GetMapping("/quadra/{id}")
    public Optional<Quadra> listaQuadraUnica(@PathVariable(value = "id") Long id){
        Optional<Quadra> quadra = quadraRepositoryy.findById(id);
        return quadra;
    }

    @GetMapping("/quadra/{nome}")
    public Quadra listaNomeQuadra(@PathVariable(value = "nome") String nome){
        return quadraRepositoryy.findByNomeQuadra(nome);
    }

    @PostMapping("/quadra")
    public Quadra salvaQuadra(@RequestBody Quadra quadra){
        return quadraRepositoryy.save(quadra);
    }

    @DeleteMapping("/quadra")
    public void deletaQuadra(@RequestBody Quadra quadra){
        quadraRepositoryy.delete(quadra);
    }

    @PutMapping("/quadra")
    public Quadra atualizaQuadra(@RequestBody Quadra quadra){
        return quadraRepositoryy.save(quadra);
    }

}
