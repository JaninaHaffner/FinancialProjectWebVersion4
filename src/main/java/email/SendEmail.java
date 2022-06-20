package email;

import dao.ApplicationDao;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class SendEmail {

    public boolean sendMail(String recipient, String subject) throws MessagingException {
        System.out.println("preparing to send email.");

        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String emailInfo = new ApplicationDao().mailInfo();
        String[] userPass = emailInfo.split(",");
        String myAccEmail = userPass[0];
        String myPass = userPass[1];

        Authentication authentication = new Authentication(myAccEmail, myPass);
        Session session = Session.getInstance(properties, authentication);
        try {

            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(myAccEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject(subject);

            Multipart multipart = new MimeMultipart();

            MimeBodyPart attachementFile = new MimeBodyPart();
            MimeBodyPart textPart = new MimeBodyPart();

            try {
                File file = new File("C:\\Users\\janin\\IdeaProjects\\FinancialProjectWebVersion4\\src\\main\\webapp\\images\\screenshot.bmp");

                attachementFile.attachFile(file);
                textPart.setText("Please see your information attached.");
                multipart.addBodyPart(textPart);
                multipart.addBodyPart(attachementFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            message.setContent(multipart);
            message.setSentDate(new Date());

            System.out.println("sending...");

            Transport.send(message);
            System.out.println("message sent");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return true;
    }
}



      /*  Message message = preparedMessage(session, myAccEmail, recipient, subject);

        Transport.send(message);

        System.out.println("Message was sent.");
        return true;
    }

    private static Message preparedMessage(Session session, String myAccEmail, String recipient, String subject) {

        try {
            System.out.println("came in here.");

         *//*   Multipart multipart = new MimeMultipart();
            MimeBodyPart attachment = new MimeBodyPart();

            File file = new File("src/main/webapp/images/screenshot.bmp");

            attachment.getDataHandler();
            attachment.attachFile(file);
            multipart.addBodyPart(attachment);
*//*
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject(subject);
            message.setSentDate(new Date());
            message.setFileName("src/main/webapp/images/screenshot.bmp");

            //message.setContent(multipart);

            return message;

        } catch (MessagingException  e) {
            throw new RuntimeException(e);
        }
    }
}
*/

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
*/
