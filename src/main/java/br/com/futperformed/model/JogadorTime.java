package br.com.futperformed.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
public class JogadorTime implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idJogador;

    private String email;
    private String quadro;
    private int ddd;
    private int telefone;
    private String posicao;
    private String nomeJogador;


    public int getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(int idJogador) {
        this.idJogador = idJogador;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQuadro() {
        return quadro;
    }

    public void setQuadro(String quadro) {
        this.quadro = quadro;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    @Override
    public String toString() {
        return "Time{" +
                "idJogador=" + idJogador +
                ", email='" + email + '\'' +
                ", quadro='" + quadro + '\'' +
                ", ddd=" + ddd +
                ", telefone=" + telefone +
                ", posicao='" + posicao + '\'' +
                ", nomeJogador='" + nomeJogador + '\'' +
                '}';
    }
}
