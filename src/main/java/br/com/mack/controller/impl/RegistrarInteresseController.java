package br.com.mack.controller.impl;

//Classe usada para colocar a lista de interesses na sessão
//Classe usada para verificar se um novo interesse adicionado pelo organizador já existe ou não
public class RegistrarInteresseController extends AbstractController{
    
    @Override
    public void execute(){        
        String opc = this.getRequest().getParameter("opc");
        if(opc.equals("carregar")){
            //colocar interesses na sessão
            this.setReturnPage("organizador_area/cadastrarpalestra.jsp");
        }else{
            //validar novo interesse
            String novoInteresse = this.getRequest().getParameter("novo_interesse");
            //Interesse interesse = daoInteresse.readByName(novoInteresse);
            //if(interesse == null){não tem ainda}else{tem que adicionar}
            this.setReturnPage("sucessoorganizador.jsp");
        }
    }    
}