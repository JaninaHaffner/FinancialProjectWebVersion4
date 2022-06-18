package email;

import dao.ApplicationDao;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
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

        Message message = preparedMessage(session, myAccEmail, recipient, subject);

        Transport.send(message);

        System.out.println("Message was sent.");
        return true;
    }

    private static Message preparedMessage(Session session, String myAccEmail, String recipient, String subject) {
        try {
            System.out.println("came in here.");

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject(subject);
            message.setSentDate(new Date());
            message.setText("<script>\n" +
                    "            if (typeof(stockdio_events) == \"undefined\") {\n" +
                    "                stockdio_events = true;\n" +
                    "                const stockdio_eventMethod = window.addEventListener ? \"addEventListener\" : \"attachEvent\";\n" +
                    "                const stockdio_eventer = window[stockdio_eventMethod];\n" +
                    "                const stockdio_messageEvent = stockdio_eventMethod === \"attachEvent\" ? \"onmessage\" : \"message\";\n" +
                    "                stockdio_eventer(stockdio_messageEvent, function (e) {\n" +
                    "                    if (typeof(e.data) != \"undefined\" && typeof(e.data.method) != \"undefined\") {\n" +
                    "                        eval(e.data.method);\n" +
                    "                    }\n" +
                    "                },false);\n" +
                    "            }\n" +
                    "        </script>\n" +
                    "        <iframe id='st_d51489f83c2947cb847dc3186c5df69d' width='100%' height='100%'\n" +
                    "                src='https://api.stockdio.com/visualization/financial/charts/v1/EconomicNews?app-key=3F3765F6FF284467B14A9241127AF282&includeDescription=false&imageWidth=40&imageHeight=40&palette=Financial-Light&onload=st_d51489f83c2947cb847dc3186c5df69d'>\n" +
                    "\n" +
                    "        </iframe>\n" +
                    "    </div>\n" +
                    "    <div class=\"main\">\n" +
                    "        <script>\n" +
                    "            if (typeof(stockdio_events) == \"undefined\") {\n" +
                    "                stockdio_events = true;\n" +
                    "                const stockdio_eventMethod = window.addEventListener ? \"addEventListener\" : \"attachEvent\";\n" +
                    "                const stockdio_eventer = window[stockdio_eventMethod];\n" +
                    "                const stockdio_messageEvent = stockdio_eventMethod === \"attachEvent\" ? \"onmessage\" : \"message\";\n" +
                    "                stockdio_eventer(stockdio_messageEvent, function (e) {\n" +
                    "                    if (typeof(e.data) != \"undefined\" && typeof(e.data.method) != \"undefined\") {\n" +
                    "                        eval(e.data.method);\n" +
                    "                    }\n" +
                    "                },false);\n" +
                    "            }\n" +
                    "        </script>\n" +
                    "        <iframe id='st_726f2915c60a4930b73d054a3c013725' width='100%' height='100%'\n" +
                    "                src='https://api.stockdio.com/visualization/financial/charts/v1/Ticker?app-key=7F5CA262046A4B63B327718307695CF1&stockExchange=${stockExchange}&symbols=${symbols};GLN&palette=Financial-Light&layoutType=10&onload=st_726f2915c60a4930b73d054a3c013725'>\n" +
                    "\n" +
                    "        </iframe>\n" +
                    "        <br>\n" +
                    "\n" +
                    "        <script>\n" +
                    "            if (typeof(stockdio_events) == \"undefined\") {\n" +
                    "                stockdio_events = true;\n" +
                    "                const stockdio_eventMethod = window.addEventListener ? \"addEventListener\" : \"attachEvent\";\n" +
                    "                const stockdio_eventer = window[stockdio_eventMethod];\n" +
                    "                const stockdio_messageEvent = stockdio_eventMethod === \"attachEvent\" ? \"onmessage\" : \"message\";\n" +
                    "                stockdio_eventer(stockdio_messageEvent, function (e) {\n" +
                    "                    if (typeof(e.data) != \"undefined\" && typeof(e.data.method) != \"undefined\") {\n" +
                    "                        eval(e.data.method);\n" +
                    "                    }\n" +
                    "                },false);\n" +
                    "            }\n" +
                    "        </script>\n" +
                    "        <iframe id='st_89d5f55da3d0437b824fe93458dc161a' width='100%' height='100%'\n" +
                    "                src='https://api.stockdio.com/visualization/financial/charts/v1/QuoteBoard?app-key=7F5CA262046A4B63B327718307695CF1&stockExchange=${stockExchange}&symbols={symbols};&includeVolume=true&palette=Financial-Light&title=Watch%20List&onload=st_89d5f55da3d0437b824fe93458dc161a'>\n" +
                    "\n" +
                    "        </iframe>");

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
*/
