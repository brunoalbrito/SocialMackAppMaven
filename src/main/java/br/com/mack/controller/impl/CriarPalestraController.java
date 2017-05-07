package br.com.mack.controller.impl;

import br.com.mack.controller.AbstractController;
import br.com.mack.persistence.PalestraDAO;
import br.com.mack.persistence.entities.Participante;
import br.com.mack.persistence.entities.Palestra;
import br.com.mack.email.EmailDispatcherPalestra;
import br.com.mack.persistence.entities.Organizador;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;

public class CriarPalestraController extends AbstractController {

    PalestraDAO palestraDAO = new PalestraDAO();
    @Override
    public void execute() {

        String tema = getRequest().getParameter("tema");
        int codigo = Integer.parseInt(getRequest().getParameter("codigo"));
        //int id_organizador = (Organizador) getRequest().getSession().getAttribute("participante");
        Organizador org = (Organizador) getRequest().getSession().getAttribute("organizador");
        long id_org = org.getId_pessoa();
        
        Palestra p = new Palestra();
        p.setTema(tema);
        p.setCodigo(codigo);
        p.setId_organizador(id_org);
                
        try {
            palestraDAO.create(p);
            //palestraDAO.deletePalestraById(id_palestra);
            setReturnPage("organizador_area/listar_palestras.jsp");
        } catch (Exception ex) {
            Logger.getLogger(RegistrarPalestraController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
