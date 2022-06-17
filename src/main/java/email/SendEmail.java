package email;

import dao.ApplicationDao;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {

    public boolean sendMail(String recepient, String subject) throws MessagingException {
        System.out.println("preparing to send email.");

        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
      //  properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "localhost");
       // properties.put("mail.smtp.port", "587");

        String emailInfo = new ApplicationDao().mailInfo();
        String[] userPass = emailInfo.split(",");
        String myAccEmail = userPass[0];
        String myPass = userPass[1];

        Authentication authentication = new Authentication(myAccEmail, myPass);
        Session session = Session.getInstance(properties, authentication);

        Message message = preparedMessage(session, myAccEmail, recepient, subject);

        Transport.send(message);

        System.out.println("Message was sent.");
        return true;
    }

    private static Message preparedMessage(Session session, String myAccEmail, String recipient, String subject){
        try {
            System.out.println("came in here.");
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject(subject);
            message.setText("Email body");
            return message;

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}






/*
package email;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

*/
/* Set up mail properties and calls authentication class
 * Then gets a session and compile and sends the email
 * Return boolean to say if mail was sent or not. *//*

public class SendEmail {

    public boolean SendMail(String to, String subject, String msgBody) {

        System.out.println("preparing to send");

        String usernameFrom = "janinahaffner@gmail.com";
        String passwordFrom = "Janinahaf12";
        boolean mailStatus;
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Authentication authentication = new Authentication(usernameFrom, passwordFrom);
        authentication.getPasswordAuthentication();
        properties.put("mail.debug", "true");

        System.out.println("properties set");

        Session session = Session.getInstance(properties, authentication);

        System.out.println("session received");
        subject = "hallo";
        msgBody = "sending mail";


        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(usernameFrom));
            InternetAddress addresses = new InternetAddress(usernameFrom);
            message.setRecipient(Message.RecipientType.TO, addresses);
            message.setSubject(subject);
            message.setSentDate(new Date());
            message.setText(msgBody);
            Transport.send(message);
            mailStatus = true;
        } catch (MessagingException mex) {
            return false;
        }
        return mailStatus;
    }

    public static void main (String [] arg) {
        String to = "janinahaffner@gmail.com";
        String sub = "testing, testing";
        String msg = " testing emails";

        boolean sent = new SendEmail().SendMail(to,sub,msg);
        System.out.println(sent);
    }
}
*/
