package br.com.mack.persistence.entities;

import java.io.Serializable;

public class Participante extends Pessoa implements Serializable {

    private String curso;
    private byte[] foto;

    public Participante() {
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Participante{" + "curso=" + curso + ", foto=" + foto != null ? "Preenchido" : "Vazio" + '}';
    }

}