package br.com.futperformed.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jogo implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idJogo", nullable = false)
    private int idJogo;


    @Column(name = "dataJogo", nullable = false)
    private LocalDateTime dataJogo;

    @Column(name = "resultado", nullable = false)
    private String resultado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "timeVisitante", referencedColumnName = "idTime")
    private Time timeVisitante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "timeMandante", referencedColumnName = "idTime")
    private Time timeMandante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quadra", referencedColumnName = "idQuadra")
    private Quadra quadra;


}
