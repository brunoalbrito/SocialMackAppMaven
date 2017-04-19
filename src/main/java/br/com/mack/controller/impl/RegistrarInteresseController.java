package br.com.mack.controller.impl;

import br.com.mack.controller.AbstractController;

//Classe usada para colocar a lista de interesses na sessão
//Classe usada para verificar se um novo interesse adicionado pelo organizador já existe ou não
public class RegistrarInteresseController extends AbstractController{
    
    @Override
    public void execute(){        
        String opc = this.getRequest().getParameter("opc");
        if(opc.equals("carregar")){
            //colocar interesses na sessão
            System.out.println("Carregando os interesses já cadastrados...");
            this.setReturnPage("organizador_area/cadastrarpalestra.jsp");
        }else{
            System.out.println("Validando registro de novo interesse...");
            //validar novo interesse
            String novoInteresse = this.getRequest().getParameter("novo_interesse");
            //Interesse interesse = daoInteresse.readByName(novoInteresse);
            //if(interesse == null){não tem ainda}else{tem que adicionar}
            this.setReturnPage("sucessoorganizador.jsp");
        }
    }    
}