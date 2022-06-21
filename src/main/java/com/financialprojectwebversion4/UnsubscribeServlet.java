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

@WebServlet(name = "UnsubscribeServlet", value = "/UnsubscribeServlet")
public class UnsubscribeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username;
        String destpage;
        String errorMessage;
        int deletedCompleted;
        ApplicationDao dao = new ApplicationDao();
        HttpSession session = request.getSession();

        username = (String) session.getAttribute("username");

        deletedCompleted = dao.unSubscribe(username);

        if (deletedCompleted != 0) {
            destpage = "/jsps/index.jsp";
            errorMessage = "You have successfully unsubscribed.";
            session.setAttribute("errorMessage", errorMessage);
        } else {
            destpage = "/jsps/login.jsp";
            errorMessage = "An error occurred, please log in and try again to unsubscribe.";
            session.setAttribute("errorMessage", errorMessage);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(destpage);
        dispatcher.forward(request, response);
    }
}
