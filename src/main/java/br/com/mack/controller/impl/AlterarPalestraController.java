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
        
        //String[] urlQuery = (this.getRequest().getQueryString()).split("=");
       // System.out.println(urlQuery);
        //String p_id = urlQuery[1].trim();
        //System.out.println(p_id);
        long id = Long.parseLong(this.getRequest().getParameter("idPalestra"));
        String tema = getRequest().getParameter("tema");
        System.out.println(tema);
        //int codigo = Integer.parseInt(getRequest().getParameter("codigo"));
        System.out.println(getRequest().getParameter("codigo"));
        Organizador organizador = (Organizador) getRequest().getSession().getAttribute("organizador");
        long id_organizador = organizador.getId_pessoa();
        //Participante participante = (Participante) getRequest().getSession().getAttribute("participante");
        //long id_participante = participante.getId_pessoa();
        
        Palestra p = new Palestra();
        //p.setId_palestra(id);
        //p.setTema(tema);
        //p.setCodigo(codigo);
        //p.setId_organizador(id_organizador);
                
        try {
            palestraDAO.update(p);
            //palestraDAO.deletePalestraById(id_palestra);
        } catch (Exception ex) {
            Logger.getLogger(RegistrarPalestraController.class.getName()).log(Level.SEVERE, null, ex);
        }
        setReturnPage("organizador_area/lista_palestras.jsp");
    }
}
