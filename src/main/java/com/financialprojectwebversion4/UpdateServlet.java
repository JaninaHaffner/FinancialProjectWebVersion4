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
     * put it in a user bean - creating a new instance of the user object
     * create instance of the application DAO
     * check if user all ready exists
     * save the user object to the database.
     * information message for user about success or failure of operation
     * */

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

        System.out.println(username);
        System.out.println(fullname);
        System.out.println(email);
        System.out.println(preference);
        System.out.println(updates);
        System.out.println(stockExchange);
        System.out.println(symbols);

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
            destpage = "/jsps/homepage.jsp";
            errorMessage = "Your details were successfully updated.";
            session.setAttribute("errorMessage", errorMessage);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(destpage);
        dispatcher.forward(request, response);
    }
}