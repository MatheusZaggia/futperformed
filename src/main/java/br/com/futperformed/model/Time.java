package br.com.futperformed.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Time implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idTime;

    private String nomeTime;
    private String cidade;
    private String bairro;
    private String zona;
    private String nomeResponsavel;
    private Date dataNascimento;
    private String email;
    private int ddd;
    private int telefone;
    private String senha;
    private String local;



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Quadra", referencedColumnName = "idQuadra", nullable = false)
    private Quadra quadra;

    @OneToMany(mappedBy = "jogo", cascade = CascadeType.ALL)
    @JoinColumn(name = "Jogo", referencedColumnName = "idJogo", nullable = false)
    private List<Jogo> jogo;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "JogadorTime", referencedColumnName = "idJogadorTime", nullable = false)
    private List<JogadorTime> JogadorTime;


    public int getIdTime() {
        return idTime;
    }

    public void setIdTime(int idTime) {
        this.idTime = idTime;
    }

    public String getNomeTime() {
        return nomeTime;
    }

    public void setNomeTime(String nomeTime) {
        this.nomeTime = nomeTime;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }


    @Override
    public String toString() {
        return "Time{" +
                "idTime=" + idTime +
                ", nomeTime='" + nomeTime + '\'' +
                ", cidade='" + cidade + '\'' +
                ", bairro='" + bairro + '\'' +
                ", zona='" + zona + '\'' +
                ", nomeResponsavel='" + nomeResponsavel + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", email='" + email + '\'' +
                ", ddd=" + ddd +
                ", telefone=" + telefone +
                ", senha='" + senha + '\'' +
                ", local='" + local + '\'' +
                '}';
    }
}
