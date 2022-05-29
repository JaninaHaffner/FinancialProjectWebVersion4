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
        String page = getHTMLString(request.getServletContext().getRealPath("/html/registration.jsp"), "");
        response.getWriter().write(page);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Get all the form data
        String fullname = request.getParameter("fullname");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String updates = request.getParameter("updates");
        String preferences = request.getParameter("preferences");

        // put it in a user bean - creating a new instance of the user object
        User user = new User(fullname, username, email, password, updates, preferences);

        // call the application DAO to save the user object to the database.
        ApplicationDao dao = new ApplicationDao();
        int rows;
        rows = dao.registerUser(user);

        // information message for user about success or failure of operation
        String infoMessage;
        if(rows==0) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("registration.jsp");
            dispatcher.include(request, response);
            infoMessage = "Sorry, an error has occurred! Please retry to register.";
        }
        else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.include(request, response);
            infoMessage = "Success, you are registered!";
        }
        response.sendRedirect(infoMessage);
        // write the message back to the client browser page
        //String page = getHTMLString(request.getServletContext().getRealPath("/html/registration.html"), infoMessage);
        //response.getWriter().write(page);
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
