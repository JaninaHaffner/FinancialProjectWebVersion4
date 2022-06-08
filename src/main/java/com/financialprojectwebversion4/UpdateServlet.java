package com.financialprojectwebversion4;

import dao.ApplicationDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "UpdateServlet", value = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {

    String username;
    String password;
    String fullname = "";
    String email = "";
    String preference = "";
    String updates = "";
    String stockExchange = "";
    String symbols = "";
    String errorMessage;
    String userinfo;
    String destpage = "/jsps/login.jsp";
    int updateCompleted;
    boolean isValidUser;
    String[] items;
    ApplicationDao dao;
    HttpSession session;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        dao = new ApplicationDao();

        isValidUser = dao.validateUser(username, password);

        if (isValidUser) {
            userinfo = dao.userPreferences(username);

            items = userinfo.split(",");
            fullname = items[0];
            email = items[1];
            preference = items[2];
            updates = items[3];
            stockExchange = items[4];
            symbols = items[5];

            RequestDispatcher dispatcher = req.getRequestDispatcher("/jsps/profile.jsp");
            dispatcher.forward(req, resp);
        }
    }

    /* Get all the form data for updates
     * put it in a user bean - creating a new instance of the user object
     * create instance of the application DAO
     * check if user all ready exists
     * save the user object to the database.
     * information message for user about success or failure of operation
     * */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        session = request.getSession();
        session.setAttribute("username", username);
        session.setAttribute("password", password);
        session.setAttribute("fullname", fullname);
        session.setAttribute("email", email);
        session.setAttribute("preference", preference);
        session.setAttribute("updates", updates);
        session.setAttribute("stockExchange", stockExchange);
        session.setAttribute("symbols", symbols);

        updateCompleted = dao.userUpdates(username, fullname, email, preference, updates, stockExchange, symbols);

        if (updateCompleted == 0) {
            destpage = "/jsps/homepage.jsp";
            errorMessage = "Your details were not updated! Please retry.";
            session.setAttribute("errorMessage", errorMessage);
        } else {
            destpage = "/jsps/homepage.jsp";
            errorMessage = "Your details were successfully updated.";
            session.setAttribute("errorMessage", errorMessage);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(destpage);
        dispatcher.forward(request, response);
    }
}