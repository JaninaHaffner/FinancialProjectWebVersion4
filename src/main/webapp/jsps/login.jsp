
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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/logStyle.css"/>
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <script src="${pageContext.request.contextPath}/css/logStyle.css"></script>

<%--    <br>${errorMessage}
    <br><br>--%>

    <title>Login</title>
</head>
<body>

<div class="container">
    <a href="${pageContext.request.contextPath}/index.jsp"><i class="fa fa-home"></i></a>
    <div class="title">Login</div>
    <br>
    <div>
    ${loginMessage}
    </div>
    <form action="${pageContext.request.contextPath}/LoginServlet" method="post">
        <div class="user-details">
            <div class="input-box">
                <span class="details">Username</span>
                <label>
                    <input name="username" type="text" placeholder="Enter your username" required>
                </label>
            </div>
            <div class="input-box">
                <span class="details">Password</span>
                <label>
                    <input name="password" type="password" placeholder="Enter your password" required>
                </label>
            </div>
        </div>

        <div class="button">
            <input type="submit" value="Login">
        </div>
        <div class="link">
            <p>Don't have an account <a href="${pageContext.request.contextPath}/jsps/registration.jsp">Register now</a></p>
        </div>
    </form>
</div>
</body>

</html>
