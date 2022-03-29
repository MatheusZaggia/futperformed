package br.com.futperformed.repository;

import br.com.futperformed.model.Quadra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuadraRepository extends JpaRepository<Quadra, Integer> {

    Quadra findById(int id);

}
