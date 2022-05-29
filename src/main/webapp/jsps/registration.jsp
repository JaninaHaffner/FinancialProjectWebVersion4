<%--
  Created by IntelliJ IDEA.
  User: janin
  Date: 2022/05/22
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%--<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>--%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/regStyle.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Register</title>
</head>
<body>
<div class="container">
  <a href="../index.jsp"><i class="fa fa-home"></i></a>

    <div class="title">Registration</div>
    <em>{0}</em>
    <form action="<%= request.getContextPath() %>/UserRegistrationServlet" method="post">

        <div class="user-details">
            <div class="input-box">
                <span class="details">Full name</span>
                <label>
                    <input type="text" name="fullname" placeholder="Enter your name" required>
                </label>
            </div>
            <div class="input-box">
                <span class="details">Username</span>
                <label>
                    <input type="text" name="username" placeholder="Enter your username" required>
                </label>
            </div>
            <div class="input-box">
                <span class="details">Email Address</span>
                <label>
                    <input type="text" name="email" placeholder="Enter your email" required>
                </label>
            </div>
            <div class="input-box">
                <span class="details">Password</span>
                <label>
                    <input type="password" name="password" placeholder="Enter your password" required>
                </label>
            </div>
        </div>
        <div class="radio-details">
            <input type="radio" name="updates" id="dot-1">
            <input type="radio" name="updates" id="dot-2">
            <input type="radio" name="updates" id="dot-3">
            <span class="radio-title">Update Frequency</span>
            <div class="category">
                <label for="dot-1">
                    <span class="dot one"></span>
                    <span class="radio">Daily</span>
                </label>
                <label for="dot-2">
                    <span class="dot two"></span>
                    <span class="radio">Weekly</span>
                </label>
                <label for="dot-3">
                    <span class="dot three"></span>
                    <span class="radio">Monthly</span>
                </label>
            </div>
        </div>
        <div class="radio-details">
            <input type="radio" name="preferences" id="dot-4">
            <input type="radio" name="preferences" id="dot-5">
            <span class="radio-title">Preferences</span>
            <div class="category">
                <label for="dot-4">
                    <span class="dot four"></span>
                    <span class="radio">Browser</span>
                </label>
                <label for="dot-5">
                    <span class="dot five"></span>
                    <span class="radio">Email</span>
                </label>
            </div>
        </div>
        <div class="button">
            <input type="submit" value="Register">

        </div>
        <p>Already have an account <a href="../jsps/login.jsp">Login now</a></p>
    </form>
</div>

</body>
</html>
