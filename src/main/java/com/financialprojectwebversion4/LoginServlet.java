package com.financialprojectwebversion4;

import dao.ApplicationDao;
import email.SendEmail;


import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.mail.MessagingException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.asynchttpclient.request.body.generator.InputStreamBodyGenerator;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// send request to login.jsp resource
		RequestDispatcher dispatcher = req.getRequestDispatcher("src/main/webapp/jsps/login.jsp");
		dispatcher.forward(req, resp);
	}
	/* Get the username and password from the login form
	 * Call DAO to validate user credentials is valid
	 * If user is valid, set username as a cookie to use in other pages, set cookie age.
	 * Call DAO to retrieve user information to use in jsp pages and update servlet.
	 * Split returned info and set up HTTP session, then set user info as attributes.
	 * If user preference is browser, forward user to homepage.jsp, with all attributes.
	 * If user preference is email,forward user to emailHomePage.jsp
	 * Set the destination page for the response
	 * Dispatch request with user info or message */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username;
		String password;
		String fullname;
		String email;
		String preference;
		String updates;
		String stockExchange;
		String symbols;
		String destPage;
		String errorMessage;
		ApplicationDao dao = new ApplicationDao();
		boolean isValidUser;
		String userinfo;
		String[] items;
		Cookie usernameCookie;
		String subject;
		RequestDispatcher dispatcher;

		username = req.getParameter("username");
		password = req.getParameter("password");

		isValidUser = dao.validateUser(username, password);
		destPage = "src/main/webapp/jsps/login.jsp";

		if(isValidUser) {

			usernameCookie = new Cookie("username", username);
			usernameCookie.setMaxAge(365*24*60*60);

			userinfo = dao.userPreferences(username);
			items = userinfo.split(",");

			fullname = items[0];
			email = items[1];
			preference = items[2];
			updates = items[3];
			stockExchange = items[4];
			symbols = items[5];

			subject = "The Financial Curation Report for " + fullname;

			HttpSession session = req.getSession();
			session.setAttribute("username", username);
			session.setAttribute("fullname", fullname);
			session.setAttribute("email", email);
			session.setAttribute("preference", preference);
			session.setAttribute("updates", updates);
			session.setAttribute("stockExchange", stockExchange);
			session.setAttribute("symbols", symbols);
			session.setAttribute("subject", subject);

			if(Objects.equals(preference, "Browser")){
				resp.addCookie(usernameCookie);
				destPage = "/jsps/homepage.jsp";

			} else {
				new EmailServlet().doPost(req, resp);
				destPage = "/jsps/emailHomePage.jsp";
			}
		} else {

			errorMessage = "Invalid credentials, please login again!";
			req.setAttribute("errorMessage", errorMessage);
		}
		dispatcher = req.getRequestDispatcher(destPage);
		dispatcher.forward(req, resp);
	}

}










