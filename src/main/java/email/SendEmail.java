package email;

import dao.ApplicationDao;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/* Set up mail properties and calls authentication class
 * Then gets a session and compile and sends the email
 * Return boolean to say if mail was sent or not. */
public class SendEmail {

    public boolean SendMail(String to, String subject, String msgBody) {

        String usernameFrom;
        String passwordFrom;
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "587");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");

        String sendInfo = new ApplicationDao().EmailSetup();
        String[] sendInfoSplit = sendInfo.split(",");
        usernameFrom = sendInfoSplit[0];
        passwordFrom = sendInfoSplit[1];

        Authentication authentication = new Authentication(usernameFrom, passwordFrom);
        authentication.getPasswordAuthentication();
        properties.put("mail.debug", "true");


        Session session = Session.getInstance(properties, authentication);

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(usernameFrom));
            InternetAddress addresses = new InternetAddress(to);
            message.setRecipient(Message.RecipientType.TO, addresses);
            message.setSubject(subject);
            message.setSentDate(new Date());
            message.setText(msgBody);
            Transport.send(message);
        } catch (MessagingException mex) {
            return false;
        }
        return true;
    }
}
