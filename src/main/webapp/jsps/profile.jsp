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
        <a href="${pageContext.request.contextPath}/jsps/homepage.jsp">Home</a>
        <a href="${pageContext.request.contextPath}/jsps/newsPage.jsp">News</a>
        <a href="${pageContext.request.contextPath}/jsps/markets.jsp">Markets</a>
        <a href="${pageContext.request.contextPath}/jsps/profile.jsp">Profile</a>
        <a href="${pageContext.request.contextPath}/LoginServlet" class="right">Logout</a>
    </div>
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
                          <select name="symbols" id="symbols" multiple>

                          </select>
                          <p>Hold the ctrl button to select your symbols</p>
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

        const url = 'https://eodhistoricaldata.com/api/exchanges-list/?api_token=62a3b3fbe45951.51740298&fmt=json';

        const request = new XMLHttpRequest();
        request.open('GET', url, true);

        request.onload = function(){
            if(request.status === 200){
                const data = JSON.parse(request.responseText);
                let option;
                for(let i = 0; i < data.length; i++){
                    option = document.createElement('option');
                    option.text = data[i].Name;
                    option.value = data[i].Code;
                    dropdown.add(option);

                }
            } else {

            }
        }

        request.onerror = function(){
            console.log('An error occurred fetching JSON from ' + url);
        };

        request.send();



        function getStockExchange(){
            let list1 = document.getElementById('stockExchange');
            let list2 = document.getElementById('symbols');
            let exchangeCode = list1.options[list1.selectedIndex].value;

            const url = `https://eodhistoricaldata.com/api/exchange-symbol-list/${exchangeCode}?fmt=json&api_token=62a1cee7bbc9e0.26407688`;

            const request = new XMLHttpRequest();
            request.open('GET', url, true);

            request.onload = function(){
            if(request.status === 200){
                const data = JSON.parse(request.responseText);
                let option;
                for(let i = 0; i < data.length; i++){
                  option = document.createElement('option');
                  option.text = data[i].Code;
                  option.value = data[i].Code;
                  list2.add(option);
                }
               
            } else {

            }
        }
        

        request.onerror = function(){
            console.log('An error occured fetching JSON from ' + url);
        };

        request.send();
        
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
