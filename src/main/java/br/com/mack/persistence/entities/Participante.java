package br.com.mack.persistence.entities;

import java.io.Serializable;


public class Participante extends Pessoa implements Serializable{
  
    private String curso;
    
    public Participante() {
    }

    public Participante(String curso, long id_pessoa,String nome, String email, String senha, String celular) {
        super(id_pessoa,nome, email, senha, celular);
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        super();
        return "Participante{" + "curso=" + curso + '}';
    }

   
}