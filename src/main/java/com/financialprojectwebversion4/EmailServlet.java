package com.financialprojectwebversion4;

import email.ScreenShot;
import email.SendEmail;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.mail.MessagingException;
import java.io.IOException;

/* Email servlet, gets all the relevant information from the login servlet.
 * Then calls the screenShot class to take a screenshot of the users wishlist.
 * Using an if statement to check if screenshot was taken,
 * then call the sendEmail class.
 * Send user to the profile page with appropriate message  */
@WebServlet (name = "EmailServlet", value = "/EmailServlet")
public class EmailServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String destPage = "/jsps/profile.jsp";
        String errorMessage;
        RequestDispatcher dispatcher;

        HttpSession session = req.getSession();
        String email = (String) session.getAttribute("email");
        String subject = (String) session.getAttribute("subject");
        String stockExchange = (String) session.getAttribute("stockExchange");
        String symbols = (String) session.getAttribute("symbols");

        boolean screenShot = new ScreenShot().TakeScreenShot(stockExchange, symbols);

        if (screenShot) {
            try {
                boolean mailSent = new SendEmail().sendMail(email, subject);

                if(mailSent) {
                    errorMessage = "Your information has been emailed to " + email;
                    req.setAttribute("errorMessage", errorMessage);
                }
            } catch (MessagingException e) {
            errorMessage = "Sorry, we could not send your information to " + email;
            req.setAttribute("errorMessage", errorMessage);
            }
            dispatcher = req.getRequestDispatcher(destPage);
            dispatcher.forward(req, resp);
        }
    }
}