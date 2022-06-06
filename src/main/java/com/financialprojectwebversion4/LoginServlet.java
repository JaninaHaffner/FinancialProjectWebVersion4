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

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// send request to login.jsp resource
		RequestDispatcher dispatcher = req.getRequestDispatcher("/jsps/login.jsp");
		dispatcher.forward(req, resp);
	}
	/* get the username from the login form
	 * call DAO for validation logic
	 * check if user is invalid
	 * set up the HTTP session
	 * set the destination page for the response
	 * dispatch request with user or message */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String preference = "";
		String updates = "";
		String stockExchange = "";
		String symbols = "";
		String errorMessage;

		ApplicationDao dao = new ApplicationDao();
		ApplicationDao dao1 = new ApplicationDao();
		boolean isValidUser = dao.validateUser(username, password);
		String userinfo = dao1.userPreferences(username);
		String destPage = "/jsps/login.jsp";

		System.out.println(userinfo);

		if(isValidUser) {
			HttpSession session = req.getSession();
			session.setAttribute("username", username);
			session.setAttribute("preference", preference);
			session.setAttribute("updates", updates);
			session.setAttribute("stockExchange", stockExchange);
			session.setAttribute("symbols", symbols);
			System.out.println(stockExchange + " + " + symbols);
			errorMessage = "Details could not be retrieved.";
			req.setAttribute("errorMessage", errorMessage);
			destPage = "/jsps/homepage.jsp";
		} else {
			errorMessage = "Invalid credentials, please login again!";
			req.setAttribute("errorMessage", errorMessage);
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher(destPage);
		dispatcher.forward(req, resp);
	}
}










