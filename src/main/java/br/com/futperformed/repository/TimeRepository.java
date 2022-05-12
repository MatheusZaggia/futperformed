package br.com.futperformed.repository;


import br.com.futperformed.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TimeRepository extends JpaRepository<Time, Long> {

    Optional<Time> findByEmail(String email);

}
