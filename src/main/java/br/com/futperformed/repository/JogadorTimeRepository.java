package br.com.futperformed.repository;

import br.com.futperformed.model.JogadorTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorTimeRepository extends JpaRepository<JogadorTime, Integer> {

    JogadorTime findById(int id);

    JogadorTime findByNomeJogador(String nomeJogador);
}
