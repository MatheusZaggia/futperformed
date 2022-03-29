package br.com.futperformed.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
public class Quadra implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idQuadra;

    private String nomeQuadra;
    private String tipoQuadra;
    private String endereco;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Jogo", referencedColumnName = "idJogo", nullable = false)
    private List<Jogo> jogo;


    public int getIdQuadra() {
        return idQuadra;
    }

    public void setIdQuadra(int idQuadra) {
        this.idQuadra = idQuadra;
    }

    public String getNomeQuadra() {
        return nomeQuadra;
    }

    public void setNomeQuadra(String nomeQuadra) {
        this.nomeQuadra = nomeQuadra;
    }

    public String getTipoQuadra() {
        return tipoQuadra;
    }

    public void setTipoQuadra(String tipoQuadra) {
        this.tipoQuadra = tipoQuadra;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Quadra{" +
                "idQuadra=" + idQuadra +
                ", nomeQuadra='" + nomeQuadra + '\'' +
                ", tipoQuadra='" + tipoQuadra + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
