package com.financialprojectwebversion4;

import beans.User;
import dao.ApplicationDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import scheduler.JobCreator;

import java.io.IOException;

@WebServlet(name = "UserRegistrationServlet", value = "/UserRegistrationServlet")
public class UserRegistrationServlet extends HttpServlet {

    /* Get all the form data for new user
     * put it in a user bean - creating a new instance of the user object
     * create instance of the application DAO
     * check if user all ready exists
     * save the user object to the database.
     * If user is registered successfully, send request to JobCreator to create schedule for user.
     * information message for user about success or failure of operation
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String destpage = "/jsps/login.jsp";

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String fullname = request.getParameter("fullname");
        String preferences = request.getParameter("preferences");
        String updates = request.getParameter("updates");
        String stockExchange = request.getParameter("stockExchange");
        String symbols = request.getParameter("symbols");

        User user = new User(username, password, email, fullname, preferences, updates, stockExchange, symbols);

        ApplicationDao dao = new ApplicationDao();

        boolean valid;
        int rows;
        String errorMessage;

        valid = dao.existingUser(username);

        if (valid) {
            errorMessage = "This user all ready exist, please log in.";
            session.setAttribute("errorMessage", errorMessage);
            RequestDispatcher dispatcher = request.getRequestDispatcher(destpage);
            dispatcher.forward(request, response);
            //  request.getRequestDispatcher("/login,jsp" + errorMessage).forward(request, response);
        } else {
            rows = dao.registerUser(user);
            if (rows == 0) {
                destpage = "/jsps/registration.jsp";
                errorMessage = "Sorry, an error has occurred! Please retry to register.";
                session.setAttribute("errorMessage", errorMessage);
            } else {
                String createJob = new JobCreator().jobCreator(username, updates, preferences, stockExchange, symbols, email);

                String[] jobInfo;
                jobInfo = createJob.split(",");
                String jobPref = jobInfo[0];
                String jobEmail = jobInfo[1];
                String jobSubject = jobInfo[2];
                String jobEmailBody = jobInfo[3];
                int jobFrequency = Integer.parseInt(jobInfo[4]);

                boolean scheduled = new JobCreator().jobScheduler(jobPref, jobEmail, jobSubject, jobEmailBody, jobFrequency);
                if(scheduled) {
                    errorMessage = "Success, you are registered!";
                    session.setAttribute("errorMessage", errorMessage);
                }else {
                    errorMessage = "We were unable to schedule your request. ";
                    session.setAttribute("errorMessage", errorMessage);
                }
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher(destpage);
            dispatcher.forward(request, response);
        }
    }
}