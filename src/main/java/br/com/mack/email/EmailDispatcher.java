package br.com.mack.email;

import com.sendgrid.*;
import java.io.IOException;

   public class EmailDispatcher {
               

       public static void sendEmail(String email) {
       
           Email from = new Email("socialmackapp@mackenzie.com.br");
           String subject = "Cadastro em SocialMack!";
           Email to = new Email(email);
           Content content = new Content("text/html", "<h1>Clique <a href='http://socialmackappteste.herokuapp.com/editar.jsp'>aqui</a> para alterar senha.</h1>");
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