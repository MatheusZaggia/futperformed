package br.com.futperformed.service.impl;

import br.com.futperformed.exception.SenhaInvalidaExcepetion;
import br.com.futperformed.model.Time;
import br.com.futperformed.repository.TimeRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TimeServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private TimeRepository timeRepository;

    @Transactional
    public Time salvar(Time time){
        return timeRepository.save(time);
    }


    public UserDetails autenticar(Time time){
        UserDetails userDetails = loadUserByUsername(time.getEmail());
        boolean senhasBatem = StringUtils.equals(time.getSenha(),userDetails.getPassword());

        if(senhasBatem){
            return userDetails;
        }
        throw new SenhaInvalidaExcepetion();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Time time = timeRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Email não Encontrado"));

        return User
                .builder()
                .username(time.getEmail())
                .password(time.getSenha())
                .roles("USER")
                .build();
    }
}
