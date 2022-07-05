<%--
  Created by IntelliJ IDEA.
  User: janin
  Date: 2022/05/22
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/regStyle.css">
    <script src="${pageContext.request.contextPath}/css/regStyle.css"></script>
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="data.js"></script>
    <title>Register</title>
</head>
<body>
<div class="container">
  <a href="${pageContext.request.contextPath}/index.jsp"><i class="fa fa-home"></i></a>

    <div class="title">Registration</div>
    <br>
    <div>${registerMessage}
    </div>
    <form action="<%= request.getContextPath() %>/UserRegistrationServlet" method="post">

        <div class="user-details">
            <div class="input-box">
                <span class="details">Username</span>
                <label>
                    <input type="text" name="username" placeholder="Enter your username" required>
                </label>
            </div>
            <div class="input-box">
                <span class="details">Password</span>
                <label>
                    <input type="password" name="password" placeholder="Enter your password" required>
                </label>
            </div>
            <div class="input-box">
                <span class="details">Email Address</span>
                <label>
                    <input type="text" name="email" placeholder="Enter your email" required>
                </label>
            </div>
            <div class="input-box">
                <span class="details">Full name</span>
                <label>
                    <input type="text" name="fullname" placeholder="Enter your name" required>
                </label>
            </div>
        </div>
        <div class="radio-details">
            <input type="radio" name="preferences" id="dot-4" value="Browser">
            <input type="radio" name="preferences" id="dot-5" value="Email">
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
        <div class="radio-details">
            <input type="radio" name="updates" id="dot-1" value="Daily">
            <input type="radio" name="updates" id="dot-2" value="Weekly">
            <input type="radio" name="updates" id="dot-3" value="Monthly">
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
      <div class="input-box">
        <span class="details">Stock Exchange</span>
          <label for="stockExchange"></label><select name="stockExchange" id="stockExchange" onchange="getStockExchange()">
        
         </select>
      </div>
      <div class="input-box">
        <span class="details">Symbols</span>
          <label for="symbols"></label><textarea name="symbols" id="symbols"></textarea>
         </div>
        

        <div class="button">
            <input type="submit" value="Register">

        </div>
        <p>Already have an account <a href="${pageContext.request.contextPath}/jsps/login.jsp">Login now</a></p>
    </form>
</div>
  <script>
        let dropdown = document.getElementById('stockExchange');
        dropdown.length = 0;

        let defaultOption = document.createElement('option');
        defaultOption.text = 'Choose stock exchange';

        dropdown.add(defaultOption);
        dropdown.selectedIndex = 0;
        
        const mydata = data;
        let option;
        for(let i = 0; i < mydata.length; i++){
          option = document.createElement('option');
          option.text = mydata[i].stockExchange;
          option.value = mydata[i].stockExchange;
          dropdown.add(option);
        }

       
        function getStockExchange(){
            let list1 = document.getElementById('stockExchange');
            let textarea = document.getElementById('symbols');
            let exchange = list1.selectedIndex-1;

            const mydata = data;
            let symbols;
            symbols = mydata[exchange].symbols;
            textarea.value = symbols;

        }
    
    </script>

<a href="${pageContext.request.contextPath}/jsps/homepage.jsp"></a>
</body>
</html>
