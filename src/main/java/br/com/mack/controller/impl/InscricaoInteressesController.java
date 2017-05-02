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
    Palestra palestra = new Palestra();
    
    public void execute(){
        
        //Pegando atributos da sessao
        String tema = this.getRequest().getParameter("tema");
        int codigo = Integer.parseInt(getRequest().getParameter("codigo"));
        long id_palestra = Long.parseLong(getRequest().getParameter("id_palestra"));


        palestra.setId_palestra(id_palestra);
        palestra.setTema(tema);
        palestra.setCodigo(codigo);
        
        //Pegando lista de interesses do banco
        List<Interesse> interessesInscricao = interesseDAO.readByIdPalestra(id_palestra);
        
        System.out.println(interessesInscricao.size());
        
        //Setando lista de interesses na sessão
        this.getRequest().getSession().setAttribute("interessesInscricao", interessesInscricao);
        this.getRequest().getSession().setAttribute("palestra", palestra);
        
        this.setReturnPage("user_area/inscricao_interesse.jsp");
    }
    
}
