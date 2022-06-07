package com.financialprojectwebversion4;

import dao.ApplicationDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.util.Properties;
import javax.activation.*;
import javax.mail.*;

@WebServlet(name = "EmailServlet", value = "/EmailServlet")
public class EmailServlet extends HttpServlet {

    public void sendEmail (String fullname, String toEmail, String messageBody) {
        String to = toEmail;
        String from = "janinahaffner@gmail.com";
        String host = "localhost";

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String to = "email";
        String from = "janinahaffner@gmail.com";
        String host = "localhost";

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);

        Session session = Session.getDefaultInstance(properties);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            MimeMessage emailMessage = new MimeMessage(session);

            emailMessage.setFrom(new InternetAddress(from));
            emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            emailMessage.setSubject("Financial Curation Report for {fullname}");
            emailMessage.setContent(" ", "");

            Transport.send(emailMessage);
            String title = "Send Email";
            String res = "Sent message successfully";
            String docType = "....";

            out.println(docType + "html tags and code");


        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}