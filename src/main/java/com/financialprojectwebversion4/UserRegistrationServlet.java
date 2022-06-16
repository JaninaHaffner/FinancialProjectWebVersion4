package com.financialprojectwebversion4;

import beans.User;
import dao.ApplicationDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UserRegistrationServlet", value = "/UserRegistrationServlet")
public class UserRegistrationServlet extends HttpServlet {

    /* Get all the form data for new user
     * put it in a user bean - creating a new instance of the user object
     * create instance of the application DAO
     * check if user all ready exists
     * save the user object to the database.
     * information message for user about success or failure of operation
     * */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String destpage = "/jsps/login.jsp";

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String fullname = request.getParameter("fullname");
        String preferences = request.getParameter("preferences");
        String updates = request.getParameter("updates");
        String stockExchange = request.getParameter("stockExchange");
        String symbols = request.getParameter("symbols");

        User user = new User(username, password, email, fullname, preferences, updates, stockExchange, symbols);

        ApplicationDao dao = new ApplicationDao();

        boolean valid;
        int rows;
        String errorMessage;

        valid = dao.existingUser(username);
        System.out.println(valid);
        if (valid) {
            errorMessage = "This user all ready exist, please log in.";
            session.setAttribute("errorMessage", errorMessage);
            RequestDispatcher dispatcher = request.getRequestDispatcher(destpage);
            dispatcher.include(request, response);
            //  request.getRequestDispatcher("/login,jsp" + errorMessage).forward(request, response);
        } else {
            rows = dao.registerUser(user);
            if (rows == 0) {
                destpage = "/jsps/registration.jsp";
                errorMessage = "Sorry, an error has occurred! Please retry to register.";
                session.setAttribute("errorMessage", errorMessage);
            } else {
                errorMessage = "Success, you are registered!";
                session.setAttribute("errorMessage", errorMessage);
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher(destpage);
            dispatcher.forward(request, response);
        }
    }
}