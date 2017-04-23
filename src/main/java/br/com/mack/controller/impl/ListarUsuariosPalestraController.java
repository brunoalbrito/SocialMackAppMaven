package br.com.mack.controller.impl;

import br.com.mack.controller.AbstractController;
import br.com.mack.persistence.PalestraDAO;
import br.com.mack.persistence.entities.Participante;

import br.com.mack.email.EmailDispatcherPalestra;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;

public class ListarUsuariosPalestraController extends AbstractController {

    PalestraDAO palestraDAO = new PalestraDAO();
    @Override
    public void execute() {

        List<Participante> participantes = null;

        long id_palestra = Long.parseLong(getRequest().getParameter("idPalestra"));
        
        try {
            palestraDAO.readUsersPalestra(id_palestra);
        } catch (Exception ex) {
            Logger.getLogger(RegistrarPalestraController.class.getName()).log(Level.SEVERE, null, ex);
        }
        getRequest().getSession().setAttribute("participantes", participantes);
        setReturnPage("user_area/listar_usuarios.jsp");
    }
}
