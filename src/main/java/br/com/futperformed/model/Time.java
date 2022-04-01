package br.com.futperformed.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Time implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idTime", nullable = false)
    private Long idTime;

    @Column(name = "nomeTime", nullable = false)
    private String nomeTime;

    @Column(name = "cidade", nullable = false)
    private String cidade;

    @Column(name = "bairro", nullable = false)
    private String bairro;

    @Column(name = "zona", nullable = false)
    private String zona;

    @Column(name = "nomeResponsavel", nullable = false)
    private String nomeResponsavel;

    @Column(name = "dataNascimento", nullable = false)
    private Date dataNascimento;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "ddd", nullable = false)
    private String ddd;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "senha", nullable = false)
    private String senha;


    @OneToMany(mappedBy = "timeVisitante")
   private List<Jogo> jogoVisitante;


    @OneToMany(mappedBy = "timeMandante")
    private List<Jogo> jogoMandante;


    @OneToMany(mappedBy = "time")
    private List<JogadorTime> JogadorTime;

}
