package br.com.mack.persistence.entities;

import java.io.Serializable;

public class Pessoa implements Serializable {

    private long id_pessoa;
    private String email, senha;
    private int celular;

    public Pessoa() {
    }

    public Pessoa(long id_pessoa, String email, String senha, int celular) {
        this.id_pessoa = id_pessoa;
        this.email = email;
        this.senha = senha;
        this.celular = celular;
    }

    public long getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(long id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id_pessoa=" + id_pessoa + ", email=" + email + ", senha=" + senha + ", celular=" + celular + '}';
    }

}
