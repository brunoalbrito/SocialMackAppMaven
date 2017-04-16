package br.com.mack.email;

import com.sendgrid.*;
import java.io.IOException;
import br.com.mack.persistence.entities.Palestra;

    public class EmailDispatcherPalestra {
                

        public static void sendEmail(String email, String tema) {
            
            
            Email from = new Email("socialmack@mackenzie.com.br");
            String subject = "Cadastro em Palestra"+tema+"!";
            Email to = new Email(email);
            Content content = new Content("text/plain", "Parabéns, você se cadastrou na palestra"+tema);
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