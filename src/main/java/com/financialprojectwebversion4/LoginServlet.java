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
		String reference = (String) req.getAttribute("origin");
		req.setAttribute("origin", reference);

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
		HttpSession session = req.getSession();

		String username = req.getParameter("username");
		String password = req.getParameter("password");

		ApplicationDao dao = new ApplicationDao();
		boolean isValidUser = dao.validateUser(username, password);
		String destPage = "/jsps/login.jsp";

		if(isValidUser) {
			session.setAttribute("username", username);
			destPage = "/jsps/homepage.jsp";
		} else {
			String errorMessage = "Invalid credentials, please login again!";
			session.setAttribute("errorMessage", errorMessage);
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher(destPage);
		dispatcher.include(req, resp);
	}
}










