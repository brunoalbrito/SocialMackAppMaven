package br.com.mack.controller.impl;

import br.com.mack.controller.AbstractController;
import br.com.mack.persistence.PalestraDAO;
import br.com.mack.persistence.entities.Participante;
import br.com.mack.persistence.entities.Palestra;
import br.com.mack.persistence.InteresseDAO;

import br.com.mack.email.EmailDispatcherPalestra;

import java.util.logging.Level;
import java.util.logging.Logger;

public class InscricaoController extends AbstractController {

   PalestraDAO palestraDAO = new PalestraDAO();
   InteresseDAO interesseDAO = new InteresseDAO();
   @Override
   public void execute() {
        Participante participante = (Participante) getRequest().getSession().getAttribute("participante");
        String [] interesses = this.getRequest().getParameterValues("interesse");
        long id_participante = participante.getId_pessoa();
        String email = participante.getEmail();
        Palestra palestra = (Palestra)this.getRequest().getSession().getAttribute("palestra");
        String tema = palestra.getTema();
        long codigo = palestra.getCodigo();
        
        
        try {
           if (interesses.length > 0) {
               
                long id_inscricao = palestraDAO.registerInPalestra(id_participante,palestra.getId_palestra());
                System.out.println("********************************ID INSCRICAO" + id_inscricao);
                for(String interesse : interesses) {

                    interesseDAO.registrarInteresseByInscricao(Long.parseLong(interesse), id_inscricao);
                
               }
                EmailDispatcherPalestra.sendEmail(email,tema,codigo);
               
           }

       } catch (Exception ex) {
           Logger.getLogger(RegistrarPalestraController.class.getName()).log(Level.SEVERE, null, ex);
       }
       setReturnPage("user_area/home.jsp");
   }
}