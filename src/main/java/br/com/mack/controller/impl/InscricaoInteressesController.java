package br.com.mack.controller.impl;

import br.com.mack.controller.AbstractController;
import br.com.mack.persistence.InteresseDAO;
import br.com.mack.persistence.entities.Palestra;
import br.com.mack.persistence.entities.Interesse;
import br.com.mack.persistence.entities.Organizador;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class InscricaoInteressesController extends AbstractController{
    
    private InteresseDAO interesseDAO = new InteresseDAO();
    
    public void execute(){
        
        //Pegando atributos da sessao
        String tema = this.getRequest().getParameter("tema");
        int codigo = Integer.parseInt(this.getRequest().getParameter("codigo"));
        long id_palestra = Long.parseLong(getRequest().getParameter("id_palestra"));
        
        
        //Pegando lista de interesses do banco
        List<Interesse> interessesInscricao = interesseDAO.readByIdPalestra(id_palestra);
        
        //Setando lista de interesses na sessão
        this.getRequest().getSession().setAttribute("interessesInscricao", interessesInscricao);
        this.getRequest().getSession().setAttribute("tema", tema);
        
        this.setReturnPage("user_area/inscricao_interesse.jsp");
    }
    
}
