package br.com.mack.email;

import com.sendgrid.*;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

   public class EmailDispatcher {
               

       public static void sendEmail(String email,HttpServletRequest httpRequest,String nome) {
       
           Email from = new Email("socialmackapp@gmail.com");
           String subject = "Cadastro em SocialMack!";
           Email to = new Email(email);
           String serverName = httpRequest.getServerName();
           String pattern = httpRequest.getScheme() + "://";
           int portNumber = httpRequest.getServerPort();
           String contextPath = httpRequest.getContextPath();
           Content content = new Content("text/html", "<html><head><meta charset='UTF-8'/></head><body><h1>Parabéns "+nome+" pelo cadastro</h1></br><h3>Clique <a href= '" + pattern + serverName + ":" + portNumber + contextPath + "/editar.jsp'>aqui</a> para alterar senha.</h3></body></html>");
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
