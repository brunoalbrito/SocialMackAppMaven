package br.com.mack.controller.impl;

import br.com.mack.controller.AbstractController;
import br.com.mack.persistence.InteresseDAO;
import br.com.mack.persistence.PalestraDAO;
import br.com.mack.persistence.entities.Interesse;
import br.com.mack.persistence.entities.Palestra;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RegistrarPalestraController extends AbstractController{
    
    private PalestraDAO daoPalestra = new PalestraDAO();
    private InteresseDAO daoInteresse = new InteresseDAO();
    
    public void execute(){
        String[] interesses = this.getRequest().getParameterValues("interesse");
        
        if(interesses.length > 0){
            
            Palestra novaPalestra = (Palestra)this.getRequest().getSession().getAttribute("palestra_pendente");
            
            daoPalestra.create(novaPalestra);
            
            long idPalestra = novaPalestra.getId_palestra();
            
            for(String id:interesses){
                long interesseId = Long.parseLong(id);
                daoInteresse.registrarInteresseByPalestra(interesseId, idPalestra);
            }
            
            //Removendo palestra_pendente e lista de interesses da sessão, bem como message_error (caso exista)
            this.getRequest().getSession().removeAttribute("palestra_pendente");
            this.getRequest().getSession().removeAttribute("interesses");
            this.getRequest().getSession().removeAttribute("error_message");
            
            this.setReturnPage("organizador_area/cadastro_palestra.jsp");
        }else{
            this.getRequest().getSession().setAttribute("error_message", "Selecione pelo menos 1 Interesse.");
            this.setReturnPage("organizador_area/palestra_interesses.jsp");
        }
        
    }
}

