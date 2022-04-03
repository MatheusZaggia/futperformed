package br.com.futperformed.repository;


import br.com.futperformed.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeRepository extends JpaRepository<Time, Long> {

    Time findByEmail(String email);

}
