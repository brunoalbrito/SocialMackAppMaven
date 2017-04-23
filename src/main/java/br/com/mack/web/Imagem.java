package br.com.mack.web;

import br.com.mack.persistence.ParticipanteDAO;
import br.com.mack.persistence.entities.Participante;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "imagem", urlPatterns = {"/imagens/*"})
public class Imagem extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Participante participante = new Participante();

        long id = Long.parseLong(request.getPathInfo().substring(1));
        try {
            participante = new ParticipanteDAO().readById(id);
        } catch (Exception e) {
            Logger.getLogger(Imagem.class.getName()).log(Level.SEVERE, null, e);
        }
        if (participante.getFoto() != null) {
            response.setContentType("image/jpg");
            response.setContentLength(participante.getFoto().length);
            response.getOutputStream().write(participante.getFoto());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}