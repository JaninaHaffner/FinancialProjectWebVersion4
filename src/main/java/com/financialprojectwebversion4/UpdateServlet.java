package com.financialprojectwebversion4;

import dao.ApplicationDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Objects;


@WebServlet(name = "UpdateServlet", value = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/jsps/profile.jsp");
        dispatcher.forward(req, resp);
    }

    /* Get all the form data for updates
     * Get user current information from DAO
     * Check if new information is not null - if it is null replace with current information
     * Update information using DAO to update database
     * Check if database error occurred, if so return to home page with appropriate message
     * If no errors, retrieve new user information and return the new user information to the home page with appropriate message
    */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username;
        String fullname;
        String email;
        String preference;
        String updates;
        String stockExchange;
        String symbols;
        String fullnameCurrent;
        String emailCurrent;
        String preferenceCurrent;
        String updatesCurrent;
        String stockExchangeCurrent;
        String symbolsCurrent;
        String errorMessage;
        String userinfo;
        String destpage;
        int updateCompleted;
        String[] items;
        ApplicationDao dao = new ApplicationDao();
        HttpSession session = request.getSession();

        username = (String) session.getAttribute("username");
        fullname = request.getParameter("fullname");
        email = request.getParameter("email");
        preference = request.getParameter("preference");
        updates = request.getParameter("updates");
        stockExchange = request.getParameter("stockExchange");
        symbols = request.getParameter("symbols");

        userinfo = dao.userPreferences(username);
        items = userinfo.split(",");

        fullnameCurrent = items[0];
        emailCurrent = items[1];
        preferenceCurrent = items[2];
        updatesCurrent = items[3];
        stockExchangeCurrent = items[4];
        symbolsCurrent = items[5];

        if (Objects.equals(fullname, "")) { fullname = fullnameCurrent;}
        if (Objects.equals(email, "")) { email = emailCurrent;}
        if (preference == null) { preference = preferenceCurrent;}
        if (updates == null) { updates = updatesCurrent;}
        if (Objects.equals(stockExchange, "Choose stock exchange")) { stockExchange = stockExchangeCurrent;}
        if (symbols == null) { symbols = symbolsCurrent;}

        updateCompleted = dao.userUpdates(username, fullname, email, preference, updates, stockExchange, symbols);

        if (updateCompleted == 0) {
            destpage = "/jsps/homepage.jsp";
            errorMessage = "Your details were not updated! Please retry.";
            session.setAttribute("errorMessage", errorMessage);
        } else {
            userinfo = dao.userPreferences(username);
            items = userinfo.split(",");

            fullname = items[0];
            email = items[1];
            preference = items[2];
            updates = items[3];
            stockExchange = items[4];
            symbols = items[5];

            session.setAttribute("username", username);
            session.setAttribute("fullname", fullname);
            session.setAttribute("email", email);
            session.setAttribute("preference", preference);
            session.setAttribute("updates", updates);
            session.setAttribute("stockExchange", stockExchange);
            session.setAttribute("symbols", symbols);

            destpage = "/jsps/homepage.jsp";
            errorMessage = "Your details were successfully updated.";
            session.setAttribute("errorMessage", errorMessage);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(destpage);
        dispatcher.forward(request, response);
    }
}