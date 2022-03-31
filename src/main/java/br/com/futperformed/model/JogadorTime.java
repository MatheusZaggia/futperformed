package br.com.futperformed.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JogadorTime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idJogador", nullable = false)
    private int idJogador;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "quadro", nullable = false)
    private String quadro;

    @Column(name = "ddd", nullable = false)
    private int ddd;

    @Column(name = "telefone", nullable = false)
    private int telefone;

    @Column(name = "posicao", nullable = false)
    private String posicao;

    @Column(name = "nomeJogador", nullable = false)
    private String nomeJogador;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTime", referencedColumnName = "idTime" ,nullable = false)
    private Time time;


    public JogadorTime(JogadorTime jogadorTime) {
    }
}