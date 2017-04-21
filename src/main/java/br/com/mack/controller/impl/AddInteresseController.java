package br.com.mack.controller.impl;

import br.com.mack.controller.AbstractController;
import br.com.mack.persistence.InteresseDAO;
import br.com.mack.persistence.entities.Interesse;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddInteresseController extends AbstractController {

    private InteresseDAO daoInteresse = new InteresseDAO();

    @Override
    public void execute() {
        String interesse = this.getRequest().getParameter("novo_interesse");
        
        //Pegando lista atualizada de interesses do banco de dados
        List<Interesse> interesses = daoInteresse.readAll();
        boolean temErro = false;
        
        //Verificando se o interesse desejado já existe no banco de dados
        for(Interesse i:interesses){
            if(i.getDescricao().toUpperCase().replaceAll(" ", "").equals(interesse.toUpperCase().replaceAll(" ", ""))){
                temErro = true;
                break;
            }
        }
        
        //Fazendo trativa de erro (caso o interesse ja esteja salvo no banco de dados)
        if(temErro){
            String errorMessage = "Já existe um interesse com o novo \"" + interesse + "\" salvo no sistema.";
            this.getRequest().getSession().setAttribute("error_message", errorMessage);
        }else{
            //Adicionando ao banco de dados o novo interesse, caso não tenha sido encontrado anteriormente
            Interesse novo = new Interesse();
            novo.setDescricao(interesse);
            daoInteresse.create(novo);
            this.getRequest().getSession().setAttribute("interesses", daoInteresse.readAll());
            this.getRequest().getSession().removeAttribute("error_message");
        }
        this.setReturnPage("organizador_area/palestra_interesses.jsp");
    }

}
