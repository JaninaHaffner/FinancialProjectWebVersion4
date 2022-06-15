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

/* Email servlet with doPost method
 * Set content type to jsp, and get request session
 * Get all information from jsp and set as attributes
 * Call SendEmail class to send the email to the user
 * If the mail was sent successfully, send user to the email homepage with all attributes and message
 * Else return error message with user to homepage.     */
@WebServlet(name = "EmailServlet", value = "/EmailServlet")
public class EmailServlet extends HttpServlet {

/*
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
*/

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String errorMessage;
        String destPage = "/jsps/profile.jsp";
        String username;
        String fullname;
        String email;
        String preference;
        String updates;
        String stockExchange;
        String symbols;
        String message = "test to see if email is working";

        resp.setContentType("text/jsp");
        HttpSession session = req.getSession();

        email = req.getParameter("email");
        fullname = req.getParameter("fullname");
        String subject = "Financial Curation Report for " + fullname;
       // String message = req.getParameter("message");
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