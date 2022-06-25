package email;

import dao.ApplicationDao;
import org.quartz.Job;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

/* SendEmail class has only one function, to send an email
 * Set properties
 * Get username and password from database
 * Authenticate username and password
 * Get session with properties and authentication
 * Use try catch to catch exceptions
 * Use a switch case to send user email with screenshot or to send user reminder to log in to webpage.
 * Create message, and set all attributes to it.
 * Create multipart message and add the file for the screenshot.
 * Send email  */
public class SendEmail {

    public Class<? extends Job> sendMail(String recipient, String subject, String preference, String emailBody) throws MessagingException {

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

        switch (preference) {
            case "Email":
                try {
                    MimeMessage message = new MimeMessage(session);

                    message.setFrom(new InternetAddress(myAccEmail));
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
                    message.setSubject(subject);

                    Multipart multipart = new MimeMultipart();

                    MimeBodyPart attachmentFile = new MimeBodyPart();
                    MimeBodyPart textPart = new MimeBodyPart();

                    try {
                        File file = new File("C:\\Users\\janin\\IdeaProjects\\FinancialProjectWebVersion4\\screenshot.jpeg");

                        attachmentFile.attachFile(file);
                        textPart.setText("Please see your information attached.");
                        multipart.addBodyPart(textPart);
                        multipart.addBodyPart(attachmentFile);

                    } catch (IOException e) {
                        return null;
                    }
                    message.setContent(multipart);
                    message.setSentDate(new Date());

                    Transport.send(message);

                } catch (MessagingException exception) {
                    return null;
                }

            case "Browser":
                try {
                    MimeMessage message = new MimeMessage(session);

                    message.setFrom(new InternetAddress(myAccEmail));
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
                    message.setSubject(subject);
                    message.setText(emailBody);
                    message.setSentDate(new Date());

                    Transport.send(message);
                } catch (Exception e) {
                    return null;
                }
        }
        return null;
    }
}