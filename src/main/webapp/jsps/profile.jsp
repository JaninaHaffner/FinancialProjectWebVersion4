<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/style2.css">
    <script src="data.js"></script>
    <title>Profile</title>
</head>
<body onload="javascript:hideForm()">
    <div class="header">
        <h1>The Financial Curation</h1>
    </div>
    <div class="navbar">
        <a href="${pageContext.request.contextPath}/jsps/homepage.jsp">Home</a>
        <a href="${pageContext.request.contextPath}/jsps/newsPage.jsp">News</a>
        <a href="${pageContext.request.contextPath}/jsps/markets.jsp">Markets</a>
        <a href="${pageContext.request.contextPath}/jsps/profile.jsp">Profile</a>
        <a href="${pageContext.request.contextPath}/Logout" class="right">Logout</a>
        <a href="${pageContext.request.contextPath}/UnsubscribeServlet" class="right">Unsubscribe</a>
    </div>
    <br>
    ${errorMessage}
    <br>
    <div class="row">
        <div class="side">
            <div class="card">
                <h1>User Profile</h1>
                <img src="../images/usericon.png" alt="" style="width:100%">
                <h3>Username: ${username}</h3>
                <h3>Password: ${password}</h3>
                <h3>Email Address: ${email}</h3>
                <h3>Full Name: ${fullname} </h3>
                <h3>Preferences: ${preference}</h3>
                <h3>Update Frequency: ${updates}</h3>
                <h3>Stock Exchange: ${stockExchange}</h3>
                <h3>Symbols: ${symbols}</h3>
                <button onClick="showForm()">Update Profile</button>
            </div>
        </div>

        <div class="main">
            <div class="container">
                <form id="form" action="${pageContext.request.contextPath}/UpdateServlet" method="post" style=>
                    <h1>Update User Profile</h1>
                      <div class="row">
                        <div class="col-25">
                          <label for="emailAddress">Email Address</label>
                        </div>
                        <div class="col-75">
                          <input type="text" id="emailAddress" name="email" placeholder=${email}>
                        </div>
                      </div>
                      <div class="row">
                        <div class="col-25">
                          <label for="fullname">Full name</label>
                        </div>
                        <div class="col-75">
                          <input type="text" id="fullname" name="fullname" placeholder=${fullname}>
                        </div>
                      </div>
                      <div class="row">
                        <div class="col-25">
                          <label for="browser">Preferences</label>
                        </div>
                        <div class="col-75">
                          <input type="radio" id="browser" name="preference" value="browser">
                          <label for="browser">Browser</label>
                          <input type="radio" id="email" name="preference" value="email">
                          <label for="email">Email</label>
                        </div>
                      </div>
                      <div class="row">
                        <div class="col-25">
                          <label for="daily">Update Frequency</label>
                        </div>
                        <div class="col-75">
                          <input type="radio" id="daily" name="updates" value="daily">
                          <label for="daily">Daily</label>
                          <input type="radio" id="weekly" name="updates" value="weekly">
                          <label for="weekly">Weekly</label>
                          <input type="radio" id="monthly" name="updates" value="monthly">
                          <label for="monthly">Monthly</label>
                        </div>
                      </div>
                      <div class="row">
                        <div class="col-25">
                          <label for="stockExchange">Stock Exchange</label>
                        </div>
                        <div class="col-75">
                            <select name="stockExchange" id="stockExchange" onchange="getStockExchange()">
                                
                            </select>
                        </div>
                      </div>
                      <div class="row">
                        <div class="col-25">
                          <label for="symbols">Symbols</label>
                        </div>
                        <div class="col-75">
                          <textarea id="symbols"></textarea>
                         
                        </div>
                      </div>
                      <br>
                      <div class="row">
                          <input type="submit" value="Update">
                      </div>
                </form>
            </div>



        </div>
    </div>
    <div class="footer">
        <p>Copyright 2022 The Finance Curation. All rights reserved</p>
        <p>Terms of Service | Privacy Policy</p>
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
            let symbols = '';
            symbols = mydata[exchange].symbols;
            textarea.value = symbols;

        }

        function hideForm(){
            document.getElementById("form").style.display = "none";
        }

        function showForm(){
            document.getElementById("form").style.display = "block";
        }
        
    </script>

</body>
</html>
