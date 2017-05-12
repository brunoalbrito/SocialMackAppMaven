package br.com.mack.controller.impl;

import br.com.mack.controller.AbstractController;
import br.com.mack.persistence.ParticipanteDAO;
import br.com.mack.persistence.entities.Participante;
import java.util.List;

public class PesquisarMatchController extends AbstractController {
    
    @Override
    public void execute() {
        Participante p = (Participante) getRequest().getSession().getAttribute("participante");
        
        List<Participante> participantes = new ParticipanteDAO().searchMeatch(p.getId_pessoa());
        if (!participantes.isEmpty()) {
            getRequest().getSession().setAttribute("participantes", participantes);
            setReturnPage("user_area/match.jsp");
        }
    }
    
}
