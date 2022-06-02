/*
package email;

import com.sun.net.httpserver.Authenticator;
import com.sun.net.httpserver.HttpExchange;
import jakarta.mail.MessagingException;
import jakarta.websocket.Session;
import org.apache.activemq.transport.Transport;
import sun.jvm.hotspot.debugger.AddressException;

import java.net.PasswordAuthentication;
import java.util.Date;
import java.util.Properties;

import javax.jms.Message;


*/
/**
 * A utility class for sending e-mail messages
 * @author www.codejava.net
 *
 *//*

public class EmailUtility {
    public static void sendEmail(String host, String port,
                                 final String userName, final String password, String toAddress,
                                 String subject, String message) throws AddressException,
            MessagingException {

        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            @Override
            public Result authenticate(HttpExchange exch) {
                return null;
            }

            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };

        Session session = Session.getInstance(properties, auth);

        // creates a new e-mail message
        Message msg = new MimeMessage(session);

        ((MimeMessage) msg).setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = {new InternetAddress(toAddress)};
        ((MimeMessage) msg).setRecipients(Message.RecipientType.TO, toAddresses);
        ((MimeMessage) msg).setSubject(subject);
        ((MimeMessage) msg).setSentDate(new Date());
        ((MimeMessage) msg).setText(message);

        // sends the e-mail
        Transport.send(msg);

    }
}*/
