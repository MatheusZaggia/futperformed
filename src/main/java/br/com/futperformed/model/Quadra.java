package br.com.futperformed.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quadra implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idQuadra", nullable = false)
    private int idQuadra;

    @Column(name = "nomeQuadra", nullable = false)
    private String nomeQuadra;

    @Column(name = "tipoQuadra", nullable = false)
    private String tipoQuadra;

    @Column(name = "endereco", nullable = false)
    private String endereco;


    @OneToMany(mappedBy = "quadra")
    private List<Jogo> jogo;


}
