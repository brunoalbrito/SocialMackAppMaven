package br.com.mack.controller.impl;

import br.com.mack.controller.AbstractController;
import br.com.mack.persistence.InteresseDAO;
import br.com.mack.persistence.entities.Palestra;
import br.com.mack.persistence.entities.Interesse;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ValidaRegistroController extends AbstractController{
    
    private InteresseDAO interesseDAO = new InteresseDAO();
    
    public void execute(){
        
        //Criando nova palestra
        String tema = this.getRequest().getParameter("tema");
        int codigo = Integer.parseInt(this.getRequest().getParameter("codigo"));
        Palestra palestra = new Palestra();
        palestra.setTema(tema);
        palestra.setCodigo(codigo);
        
        //Setando nova palestra na sessão - somente após definir os interesses relacionados à ela que a mesma será presistida no banco de dados
        this.getRequest().getSession().setAttribute("palestra_pendente", palestra);        
        
        //Pegando lista de interesses do banco
        List<Interesse> interesses = interesseDAO.readAll();
        
        //Setando lista de interesses na sessão (simulando para teste)
        this.getRequest().getSession().setAttribute("interesses", new String[]{"Interesse a", "Interesse b", "Interesse c", "Interesse d", "Interesse e"});
        
        this.setReturnPage("organizador_area/palestra_interesse.jsp");
    }
    
}
