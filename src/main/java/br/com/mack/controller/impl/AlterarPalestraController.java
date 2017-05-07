package br.com.mack.controller.impl;

import br.com.mack.controller.AbstractController;
import br.com.mack.persistence.PalestraDAO;
import br.com.mack.persistence.entities.Organizador;
import br.com.mack.persistence.entities.Palestra;
import br.com.mack.email.EmailDispatcherPalestra;
import br.com.mack.persistence.entities.Organizador;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;

public class AlterarPalestraController extends AbstractController {
    
    PalestraDAO palestraDAO = new PalestraDAO();
    
    @Override
    public void execute() {
        //List<Palestra> palestras = null;
        
        long id = Long.parseLong(getRequest().getParameter("id_palestra"));
        String tema = getRequest().getParameter("tema");
        int codigo = Integer.parseInt(getRequest().getParameter("codigo"));
        Organizador org = (Organizador) getRequest().getSession().getAttribute("organizador");
        long id_org = org.getId_pessoa();
        
        Palestra p = new Palestra();
        p.setId_palestra(id);
        p.setTema(tema);
        p.setCodigo(codigo);
        p.setId_organizador(id_org);
                
        try {
            palestraDAO.update(p);
            palestras = palestraDAO.readAll();
            //palestraDAO.deletePalestraById(id_palestra);
            setReturnPage("organizador_area/lista_palestras.jsp");
        } catch (Exception ex) {
            Logger.getLogger(AlterarPalestraController.class.getName()).log(Level.SEVERE, null, ex);
        }
        getRequest().getSession().setAttribute("palestras", palestras);
    }
}
