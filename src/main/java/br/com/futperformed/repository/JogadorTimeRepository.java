package br.com.futperformed.repository;

import br.com.futperformed.model.JogadorTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorTimeRepository extends JpaRepository<JogadorTime, Long> {

    JogadorTime findByNomeJogador(String nomeJogador);
}
