package br.com.futperformed.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JogadorTime implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idJogador", nullable = false)
    private Long idJogador;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "quadro", nullable = false)
    private String quadro;

    @Column(name = "ddd", nullable = false)
    private String ddd;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "posicao", nullable = false)
    private String posicao;

    @Column(name = "nomeJogador", nullable = false)
    private String nomeJogador;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTime", referencedColumnName = "idTime" , nullable = false)
    private Time time;

}