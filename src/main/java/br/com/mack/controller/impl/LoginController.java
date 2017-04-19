package br.com.mack.controller.impl;

import br.com.mack.controller.AbstractController;
import br.com.mack.persistence.PessoaDAO;
import br.com.mack.persistence.entities.Organizador;
import br.com.mack.persistence.entities.Participante;
import br.com.mack.persistence.entities.Pessoa;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginController extends AbstractController {

    PessoaDAO pessoaDAO = new PessoaDAO();

    @Override
    public void execute() {
        System.out.println("***************LoginController*****************");

        String email = this.getRequest().getParameter("email");
        String password = this.getRequest().getParameter("senha");
        
        try {
            Pessoa pessoa = pessoaDAO.readByEmail(email,password);
            
            System.out.println("******************Pessoa encontrada: " + pessoa + "**************************");
            
            if(pessoa instanceof Participante){
                System.out.println("Participante: " + ((Participante)pessoa));
            }else{
                System.out.println("Organizador: " + ((Organizador)pessoa));
            }
            
            if ((email.equals(pessoa.getEmail())) && (password.equals(pessoa.getSenha()))) {
                if (pessoa instanceof Participante) {
                    getRequest().getSession().setAttribute("participante", (Participante) pessoa);
                    this.setReturnPage("user_area/home.jsp");
                } else {
                    getRequest().getSession().setAttribute("organizador", (Organizador) pessoa);
                    this.setReturnPage("organizador_area/home.jsp");
                }
            } else {
                this.setReturnPage("erro.jsp");
            }

        } catch (Exception ex) {
            Logger.getLogger(CadastroController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
