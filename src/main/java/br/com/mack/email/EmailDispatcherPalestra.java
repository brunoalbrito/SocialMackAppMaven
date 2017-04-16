package br.com.mack.email;

import com.sendgrid.*;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

   public class EmailDispatcherPalestra {
               

       public static void sendEmail(String email,String tema,long codigo) {
       
           Email from = new Email("socialmackapp@gmail.com");
           String subject = "Inscrição na palestra "+tema+" !!!";
           Email to = new Email(email);
          
           Content content = new Content("text/html", "<h1>Você se cadastrou na palestra "+tema+"</h1></br><h3>O código da palestra é "+codigo+"</h3>");
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