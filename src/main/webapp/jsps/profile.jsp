<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/style2.css">
    <title>Profile</title>
</head>
<body onload="javascript:hideForm()">
    <div class="header">
        <h1>The Financial Curation</h1>
    </div>
    <div class="navbar">
        <a href="homepage.jsp">Home</a>
        <a href="newsPage.jsp">News</a>
        <a href="markets.jsp">Markets</a>
        <a href="profile.jsp">Profile</a>
        <a href="${pageContext.request.contextPath}/Logout" class="right">Logout</a>
    </div>
    <div class="row">
        <div class="side">
            <div class="card">
                <h1>User Profile</h1>
                <img src="../images/usericon.png" alt="" style="width:100%">
                <h3>Full Name</h3>
                <h3>Username</h3>
                <h3>Email Address</h3>
                <h3>Password</h3>
                <h3>Update Frequency</h3>
                <h3>Preferences</h3>
                <h3>Stock Exchange</h3>
                <h3>Symbols</h3>
                <button onClick="showForm()">Update Profile</button>
            </div>
        </div>

        <div class="main">
            <div class="container">
                <form id="form" action="${pageContext.request.contextPath}/UpdateServlet" method="get" style=>
                    <h1>Update User Profile</h1>
                    <div class="row">
                        <div class="col-25">
                          <label for="fullname">Full Name</label>
                        </div>
                        <div class="col-75">
                          <input type="text" id="fullname" name="fulltname" placeholder=${fullname}>
                        </div>
                      </div>
                      <div class="row">
                        <div class="col-25">
                          <label for="username">Username</label>
                        </div>
                        <div class="col-75">
                          <input type="text" id="username" name="username" placeholder="Your username..">
                        </div>
                      </div>
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
                          <label for="password">Password</label>
                        </div>
                        <div class="col-75">
                          <input type="password" id="password" name="password" placeholder="Your password..">
                        </div>
                      </div>
                      <div class="row">
                        <div class="col-25">
                          <label for="daily">Update Frequency - Your current setting is ${updates}</label>
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
                          <label for="browser">Preferences - Your current setting is ${preference}</label>
                        </div>
                        <div class="col-75">
                          <input type="radio" id="browser" name="preferences" value="browser">
                          <label for="browser">Browser</label>
                          <input type="radio" id="email" name="preferences" value="email">
                          <label for="email">Email</label>
                        </div>
                      </div>
                      <div class="row">
                        <div class="col-25">
                          <label for="stockExchange">Stock Exchange - Your current preference is ${stockExchange}</label>
                        </div>
                        <div class="col-75">
                            <select name="stockExchange" id="stockExchange">
                                <option value="currencies trading">Currencies Trading</option>
                                <option value="commodities trading">Commodities Trading</option>
                                <option value="crypto">Crypto</option>
                                <option value="futures">Futures</option>
                                <option value="Bonds">Bonds</option>
                            </select>
                        </div>
                      </div>
                      <div class="row">
                        <div class="col-25">
                          <label for="symbols">Symbols</label>
                        </div>
                        <div class="col-75">
                            <select id="symbols" name="symbols" multiple>

                            </select>
                        </div>
                      </div>
                      <br>
                      <div class="row">
                          <input formaction="/UpdateServlet" formmethod="post" type="submit" value="Update">
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
        let dropdown = document.getElementById('symbols');
        dropdown.length = 0;

        let defaultOption = document.createElement('option');
        defaultOption.text = 'Choose symbols';

        dropdown.add(defaultOption);
        dropdown.selectedIndex = 0;

        const url = 'https://financialmodelingprep.com/api/v3/financial-statement-symbol-lists?apikey=9b0d24686886ebb2d95340f1c567e26f';

        const request = new XMLHttpRequest();
        request.open('GET', url, true);

        request.onload = function(){
            if(request.status === 200){
                const data = JSON.parse(request.responseText);
                let option;
                for(let i = 0; i < data.length; i++){
                    option = document.createElement('option');
                    option.text = data[i];
                    option.value = data[i];
                    dropdown.add(option);

                }
            } else {

            }
        }

        request.onerror = function(){
            console.log('An error occured fetching JSON from ' + url);
        };

        request.send();

        function hideForm(){
            document.getElementById("form").style.display = "none";
        }

        function showForm(){
            document.getElementById("form").style.display = "block";
        }
        
    </script>

</body>
</html>
