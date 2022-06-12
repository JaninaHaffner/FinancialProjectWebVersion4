package email;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class SendEmail {

    public boolean SendMail(String to, String subject, String msgBody) {

        String usernameFrom = "janinahaffner@gmail.com";
        String passwordFrom = "Janinahaf12";
        boolean mailStatus = false;
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");

        Authentication authentication = new Authentication(usernameFrom, passwordFrom);
        authentication.getPasswordAuthentication();
        properties.put("mail.debug", "true");

        Session session = (Session) Session.getInstance(properties, authentication);

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(usernameFrom));
            InternetAddress addresses = new InternetAddress(to);
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
}
