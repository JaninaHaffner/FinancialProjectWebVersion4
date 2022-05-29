<%--
  Created by IntelliJ IDEA.
  User: janin
  Date: 2022/05/28
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="../css/logStyle.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Login</title>
</head>
<body>
<div class="container">
    <a href="../index.jsp"><i class="fa fa-home"></i></a>
    <div class="title">Login</div>
    <form action="servlet/Login">
        <div class="user-details">
            <div class="input-box">
                <span class="details">Username</span>
                <input aria-label="username" type="text" placeholder="Enter your username" required>
            </div>
            <div class="input-box">
                <span class="details">Password</span>
                <input aria-label="password" type="password" placeholder="Enter your password" required>
            </div>
        </div>
        <div class="button">
            <input type="submit" value="Login">
        </div>
        <div class="link">
            <p>Don't have an account <a href="registration.jsp">Register now</a></p>
        </div>
    </form>
</div>


</body>
</html>
