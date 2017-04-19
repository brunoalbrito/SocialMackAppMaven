package br.com.mack.controller.impl;


import br.com.mack.controller.AbstractController;
import br.com.mack.persistence.ParticipanteDAO;
import br.com.mack.persistence.entities.Participante;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.mack.email.EmailDispatcher;

public class CadastroController extends AbstractController {

    ParticipanteDAO participanteDAO = new ParticipanteDAO();
    

    @Override
    public void execute() {
        System.out.println("***************CadastroController****************");
        //TesteConnection connection = new TesteConnection();
        
        String name = this.getRequest().getParameter("name");
        String email = this.getRequest().getParameter("email");
        Participante participante = new Participante();
        participante.setNome(name);
        participante.setEmail(email);
        participante.setSenha(generatePassword());
        
        
        try {
            participanteDAO.create(participante);
            getRequest().getSession().setAttribute("participante", participante);
            
            email = this.getRequest().getParameter("email");
            EmailDispatcher.sendEmail(email,getRequest(),participante.getNome());
            
            setReturnPage("user_area/home.jsp");
        } catch (Exception ex) {
            Logger.getLogger(CadastroController.class.getName()).log(Level.SEVERE, null, ex);
            this.setReturnPage("erro.jsp");
        }
    }
    public String generatePassword(){
        StringBuilder senha = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                senha.append((char) ((Math.random() * 25) + 65));
            } else {
                senha.append("").append((int) ((Math.random() * 10))).append("");
            }
        }
        return senha.toString();
    }
}