package com.financialprojectwebversion4;

import dao.ApplicationDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// send request to login.jsp resource
		RequestDispatcher dispatcher = req.getRequestDispatcher("/jsps/login.jsp");
		dispatcher.forward(req, resp);
	}
	/* Get the username and password from the login form
	 * Call DAO to validate user credentials is valid
	 * If user is valid, set username as a cookie to use in other pages, set cookie age.
	 * Call DAO to retrieve user information to use in jsp pages and update servlet.
	 * Split returned info and set up HTTP session, then set user info as attributes.
	 * If user preference is browser, forward user to homepage.jsp, with all attributes.
	 * If user preference is email, call email servlet, send info to user via email and forward user to emailHomePage.jsp
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

		username = req.getParameter("username");
		password = req.getParameter("password");

		isValidUser = dao.validateUser(username, password);
		destPage = "/jsps/login.jsp";

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

			HttpSession session = req.getSession();
			session.setAttribute("username", username);
			session.setAttribute("fullname", fullname);
			session.setAttribute("email", email);
			session.setAttribute("preference", preference);
			session.setAttribute("updates", updates);
			session.setAttribute("stockExchange", stockExchange);
			session.setAttribute("symbols", symbols);

			if(Objects.equals(preference, "Browser")){
				resp.addCookie(usernameCookie);
				destPage = "/jsps/homepage.jsp";

			} else {
				// send email from here.
				String messageBody = """  
						<script>
						   if (typeof(stockdio_events) == "undefined") {
						      stockdio_events = true;
						      var stockdio_eventMethod = window.addEventListener ? "addEventListener" : "attachEvent";
						      var stockdio_eventer = window[stockdio_eventMethod];
						      var stockdio_messageEvent = stockdio_eventMethod == "attachEvent" ? "onmessage" : "message";
						      stockdio_eventer(stockdio_messageEvent, function (e) {
						         if (typeof(e.data) != "undefined" && typeof(e.data.method) != "undefined") {
						            eval(e.data.method);
						         }
						      },false);
						   }
						</script>
						<iframe id='st_bca20f46886c4a04b507058de1ece60d' frameBorder='0' scrolling='no' width='600' height='100%' 
						src='https://api.stockdio.com/visualization/financial/charts/v1/QuoteBoard?app-key=7F5CA262046A4B63B327718307695CF1&stockExchange=${stockExchange}&symbols=${symbols};&includeVolume=true&palette=Financial-Light&title=Watch%20List&onload=st_bca20f46886c4a04b507058de1ece60d'>
						</iframe>
												
						""";
				EmailServlet sendingEmail = new EmailServlet();
				sendingEmail.sendEmail(fullname, email, messageBody);
				destPage = "";
				errorMessage = "";
				req.setAttribute("errorMessage", errorMessage);
			}
		} else {
			errorMessage = "Invalid credentials, please login again!";
			req.setAttribute("errorMessage", errorMessage);
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher(destPage);
		dispatcher.forward(req, resp);
	}
}










