package br.com.futperformed.repository;


import br.com.futperformed.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogoRepository extends JpaRepository<Jogo, Integer> {

    Jogo findById(int id);
}
