package com.financialprojectwebversion4;

import email.SendEmail;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.*;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

@WebServlet(name = "EmailServlet", value = "/EmailServlet")
public class EmailServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String errorMessage = "";
        String destPage = "/jsps/profile.jsp";
        String username;
        String fullname;
        String email;
        String preference;
        String updates;
        String stockExchange;
        String symbols;

        resp.setContentType("text/jsp");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();

        email = req.getParameter("email");
        fullname = req.getParameter("fullname");
        String subject = "Financial Curation Report for " + fullname;
        String message = req.getParameter("message");
        username = (String) session.getAttribute("username");
        preference = (String) session.getAttribute("preference");
        updates = (String) session.getAttribute("updates");
        stockExchange = (String) session.getAttribute("stockExchange");
        symbols = (String) session.getAttribute("symbols");

        session.setAttribute("username", username);
        session.setAttribute("fullname", fullname);
        session.setAttribute("email", email);
        session.setAttribute("preference", preference);
        session.setAttribute("updates", updates);
        session.setAttribute("stockExchange", stockExchange);
        session.setAttribute("symbols", symbols);


        SendEmail mail = new SendEmail();
        boolean mailSent = mail.SendMail(email, subject, message);

        if (mailSent) {
            errorMessage = "Your information was sent to your email.";
            session.setAttribute("errorMessage", errorMessage);
        } else {
            errorMessage = "An error occurred, we were un able to send your email!";
            session.setAttribute("errorMessage", errorMessage);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher(destPage);
        dispatcher.forward(req, resp);
    }
}