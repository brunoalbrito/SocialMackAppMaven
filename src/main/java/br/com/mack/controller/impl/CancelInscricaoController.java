package br.com.mack.controller.impl;

import br.com.mack.controller.AbstractController;
import br.com.mack.persistence.PalestraDAO;
import br.com.mack.persistence.entities.Participante;

import br.com.mack.email.EmailDispatcherPalestra;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CancelInscricaoController extends AbstractController {

    PalestraDAO palestraDAO = new PalestraDAO();
    @Override
    public void execute() {
        Participante participante = (Participante) getRequest().getSession().getAttribute("participante");
        
        long id_participante = participante.getId_pessoa();
        long id_palestra = Long.parseLong(getRequest().getParameter("id_palestra"));
        long codigo = Long.parseLong(getRequest().getParameter("codigo"));
        String tema = getRequest().getParameter("tema");
        String email = participante.getEmail();

        try {
            palestraDAO.cancelRegisterInPalestra(id_participante,id_palestra);
            //EmailDispatcherPalestra.sendEmail(email,tema,codigo);
        } catch (Exception ex) {
            Logger.getLogger(RegistrarPalestraController.class.getName()).log(Level.SEVERE, null, ex);
        }
        setReturnPage("user_area/home.jsp");
    }
}
