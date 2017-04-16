package br.com.mack.email;

import com.sendgrid.*;
import java.io.IOException;
import br.com.mack.persistence.entities.Participante;

    public class EmailDispatcher {
                

        public static void sendEmail(String email, String nome) {
            
            
            Email from = new Email("test@example.com");
            String subject = "Cadastro em SocialMack!";
            Email to = new Email(email);
            Content content = new Content("text/plain", nome+"Clique no link para gerar uma senha \n http://socialmackappteste-pr-56.herokuapp.com/editar.jsp");
            Mail mail = new Mail(from, subject, to, content);

            SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
            Request request = new Request();
            try {
                request.method = Method.POST;
                request.endpoint = "mail/send";
                request.body = mail.build();
                Response response = sg.api(request);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
  
        }
    }