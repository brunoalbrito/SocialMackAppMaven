package br.com.mack.controller.impl;

import br.com.mack.controller.AbstractController;
import br.com.mack.persistence.PalestraDAO;
import br.com.mack.persistence.entities.Organizador;
import br.com.mack.persistence.entities.Palestra;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RegistrarPalestraController extends AbstractController{
    
    PalestraDAO palestraDAO = new PalestraDAO();
    
    public void execute(){
        String tema = getRequest().getParameter("tema");
        int codigo = Integer.parseInt(getRequest().getParameter("codigo"));
        long id_organizador = ((Organizador) getRequest().getSession().getAttribute("organizador")).getId_pessoa();
        
        Palestra palest = new Palestra();
        palest.setTema(tema);
        palest.setCodigo(codigo);
        palest.setId_organizador(id_organizador);
        
        try{
            palestraDAO.create(palest);
            setReturnPage("sucessoorganizador.jsp");
            
        }catch(Exception ex){
            Logger.getLogger(RegistrarPalestraController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}