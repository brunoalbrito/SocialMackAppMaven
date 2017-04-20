package br.com.mack.persistence.entities;

import java.io.Serializable;

public class Interesse implements Serializable{
    private long id;
    private String descricao;
    
    public Interesse(){
        
    }
    
    public Interesse(String descricao){
        this.descricao = descricao;
    }
    
    public long getId(){
        return this.id;
    }
    
    public void setId(long id){
        this.id = id;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
    
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
}