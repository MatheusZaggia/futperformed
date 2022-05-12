package br.com.futperformed.controller;

import br.com.futperformed.dto.CredenciaisDTO;
import br.com.futperformed.dto.TokenDTO;
import br.com.futperformed.exception.SenhaInvalidaExcepetion;
import br.com.futperformed.model.Time;
import br.com.futperformed.repository.TimeRepository;
import br.com.futperformed.secutiry.jwt.JwtService;
import br.com.futperformed.service.impl.TimeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TimeController {

    private final TimeServiceImpl timeServiceimpl;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;


    @Autowired
    TimeRepository timeRepository;

    @GetMapping("/times")
    public List<Time> listaTimes(){
        return timeRepository.findAll();
    }

    @GetMapping("/time")
    public Optional<Time> listaTimePorEmail(@RequestParam(value = "email") String email){
        System.out.println(email);
        return timeRepository.findByEmail(email);
    }

    @GetMapping("/time/{id}")
    public Optional<Time> listaTimeUnico(@RequestParam(value = "id") Long id){
        Optional<Time> time = timeRepository.findById(id);
        return time;
    }

    @PostMapping("/time")
    @ResponseStatus(HttpStatus.CREATED)
    public Time salvaTime(@RequestBody Time time){
        String senhaCriptografada = passwordEncoder.encode(time.getSenha());
        time.setSenha(senhaCriptografada);
        return timeServiceimpl.salvar(time);
    }

    @DeleteMapping("/time")
    public void deletaTime(@RequestBody Time time){
        timeRepository.delete(time);
    }

    @PutMapping("/time")
    public Time atualizaJogadorTime(@RequestBody Time time){
        return timeRepository.save(time);
    }


    @PostMapping("/auth")
    public TokenDTO autentica(@RequestBody CredenciaisDTO credenciais){
        try{

            Time time = Time.builder()
                    .email(credenciais.getLogin())
                    .senha(credenciais.getSenha()).build();

            UserDetails usuarioAutenticado = timeServiceimpl.autenticar(time);

            String token = jwtService.gerarToken(time);

          return new TokenDTO(time.getEmail(), token);

        }catch (UsernameNotFoundException | SenhaInvalidaExcepetion e){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED , e.getMessage());
        }
    }




}
