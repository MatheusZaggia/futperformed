package br.com.futperformed.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
public class Jogo implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idJogo;

    private String nomeTimeAdversario;
    private Date dataJogo;
    private String resultado;



    public int getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(int idJogo) {
        this.idJogo = idJogo;
    }

    public String getNomeTimeAdversario() {
        return nomeTimeAdversario;
    }

    public void setNomeTimeAdversario(String nomeTimeAdversario) {
        this.nomeTimeAdversario = nomeTimeAdversario;
    }

    public Date getDataJogo() {
        return dataJogo;
    }

    public void setDataJogo(Date dataJogo) {
        this.dataJogo = dataJogo;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Jogo{" +
                "idJogo=" + idJogo +
                ", nomeTimeAdversario='" + nomeTimeAdversario + '\'' +
                ", dataJogo=" + dataJogo +
                ", resultado='" + resultado + '\'' +
                '}';
    }
}
