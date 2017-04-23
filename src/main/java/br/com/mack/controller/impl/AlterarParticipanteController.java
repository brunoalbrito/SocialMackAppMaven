package br.com.mack.controller.impl;

import br.com.mack.controller.AbstractController;
import br.com.mack.persistence.ParticipanteDAO;
import br.com.mack.persistence.entities.Participante;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.nio.charset.Charset;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class AlterarParticipanteController extends AbstractController {

    ParticipanteDAO participanteDAO = new ParticipanteDAO();

    @Override
    public void execute() {
        System.out.println("FUNCIONOU");
        //TesteConnection connection = new TesteConnection();

        long id = Long.parseLong(this.getRequest().getParameter("id"));
        String name = this.getRequest().getParameter("name");
        String email = this.getRequest().getParameter("email");
        String celular = this.getRequest().getParameter("celular");
        String senha = this.getRequest().getParameter("senha");
        String curso = this.getRequest().getParameter("curso");

        Participante participante = new Participante();
        participante.setId_pessoa(id);
        participante.setNome(name);
        participante.setEmail(email);
        participante.setCelular(celular);
        participante.setSenha(senha);
        participante.setCurso(curso);
        participante.setFoto(convertImgToFile(getRequest()));

        System.out.println(participante);

        System.out.println(Charset.defaultCharset());

        try {
            participanteDAO.update(participante);
            getRequest().getSession().setAttribute("participante", participante);
        } catch (Exception ex) {
            Logger.getLogger(CadastroController.class.getName()).log(Level.SEVERE, null, ex);
            this.setReturnPage("erro.jsp");
        }
        this.setReturnPage("user_area/home.jsp");
    }

    public static byte[] convertImgToFile(HttpServletRequest request) {
        Part part;
        byte[] buffer = null;
        try {
            part = request.getPart("imagem");
            InputStream inputStream = part.getInputStream();
            buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
        } catch (IOException ex) {
            Logger.getLogger(ParticipanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(ParticipanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return buffer;
    }
}