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
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get the username from the login form
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println("username: " + username);
		System.out.println("password: " + password);

		// call DAO for validation logic
		ApplicationDao dao = new ApplicationDao();
		boolean isValidUser = dao.validateUser(username, password);
		
		// check if user is invalid
		if(isValidUser) {
	
		// set up the HTTP session
		HttpSession session = req.getSession();
		
		// set username as an attribute
	//	session.getAttribute("username", username);
		
		// forward to home jsp
		req.getRequestDispatcher("/jsps/logedInPage.jsp").forward(req, resp);
		}
		else {
			String errorMessage = "Invalid credentials, please login again!";
			req.setAttribute("error", errorMessage);
			req.getRequestDispatcher("/login.jsp" + errorMessage).forward(req, resp);
		}
	}
}










