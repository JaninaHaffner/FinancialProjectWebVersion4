package com.financialprojectwebversion4;

import beans.User;
import dao.ApplicationDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;

@WebServlet(name = "UserRegistrationServlet", value = "/UserRegistrationServlet")
public class UserRegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page = getHTMLString(request.getServletContext().getRealPath("/jsps/registration.jsp"), "");
        response.getWriter().write(page);

    }

    /* Get all the form data from the registration.jsp page
     * put it in a user bean - creating a new instance of the user object
     * call the application DAO to save the user object to the database.
     * information message for user about success or failure of operation */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
        int rows;
        rows = dao.registerUser(user);

        String infoMessage;
        if(rows==0) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("registration.jsp");
            dispatcher.include(request, response);
            infoMessage = "Sorry, an error has occurred! Please retry to register.";
        }
        else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.include(request, response);
            infoMessage = "Success, you are registered! Please login.";
        }
        request.getRequestDispatcher("login.jsp" + infoMessage).forward(request, response);
    }

    public String getHTMLString(String filePath, String message) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        StringBuilder buffer = new StringBuilder();
        while((line=reader.readLine()) != null) {
            buffer.append(line);
        }
        reader.close();
        String page = buffer.toString();

        // append stocks back to page, fill in stock details - replace data in place holders
        page = MessageFormat.format(page, message);

        return page;
    }
}
