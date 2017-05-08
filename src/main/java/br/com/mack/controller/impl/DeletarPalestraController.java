package br.com.mack.controller.impl;

import br.com.mack.controller.AbstractController;
import br.com.mack.persistence.PalestraDAO;
import br.com.mack.persistence.entities.Participante;

import br.com.mack.email.EmailDispatcherPalestra;
import br.com.mack.persistence.entities.Palestra;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;

public class DeletarPalestraController extends AbstractController {

    PalestraDAO palestraDAO = new PalestraDAO();
    @Override
    public void execute() {
        List<Palestra> palestras = null;
        
        long id_palestra = Long.parseLong(getRequest().getParameter("idPalestra"));
        
        try {
            palestraDAO.deletePalestraById(id_palestra);
            palestras = palestraDAO.readAll();
            setReturnPage("organizador_area/lista_palestras.jsp");
        } catch (Exception ex) {
            Logger.getLogger(RegistrarPalestraController.class.getName()).log(Level.SEVERE, null, ex);
        }
        getRequest().getSession().setAttribute("palestras", palestras);
    }
}
