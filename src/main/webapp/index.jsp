<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <title>The Finance Curation</title>
</head>
<body>
<header id="showcase">

    <h1>The Finance Curation</h1>
    <p>Welcome to The Finance Curation. The ultimate destination for financial news and market updates</p>
    <a href="jsps/login.jsp" class="button">Login</a>
    <a href="jsps/registration.jsp" class="button">Register</a>

</header>
     <div class="side">
        <h3>Recent News</h3>
        <script>
            if (typeof(stockdio_events) == "undefined") {
               stockdio_events = true;
               var stockdio_eventMethod = window.addEventListener ? "addEventListener" : "attachEvent";
               var stockdio_eventer = window[stockdio_eventMethod];
               var stockdio_messageEvent = stockdio_eventMethod === "attachEvent" ? "onmessage" : "message";
               stockdio_eventer(stockdio_messageEvent, function (e) {
                  if (typeof(e.data) != "undefined" && typeof(e.data.method) != "undefined") {
                     eval(e.data.method);
                  }
               },false);
            }
         </script>
         <iframe id='st_87ea7382535b4f9d82157b7900dedbc7' width='100%' height='100%' src='https://api.stockdio.com/visualization/financial/charts/v1/EconomicNews?app-key=3F3765F6FF284467B14A9241127AF282&includeDescription=false&includeImage=false&palette=Financial-Light&onload=st_87ea7382535b4f9d82157b7900dedbc7'></iframe>
    </div>
    <div class="main">
        <h3>Popular stocks</h3>
        <script>
            if (typeof(stockdio_events) == "undefined") {
               stockdio_events = true;
               var stockdio_eventMethod = window.addEventListener ? "addEventListener" : "attachEvent";
               var stockdio_eventer = window[stockdio_eventMethod];
               var stockdio_messageEvent = stockdio_eventMethod === "attachEvent" ? "onmessage" : "message";
               stockdio_eventer(stockdio_messageEvent, function (e) {
                  if (typeof(e.data) != "undefined" && typeof(e.data.method) != "undefined") {
                     eval(e.data.method);
                  }
               },false);
            }
         </script>
         <iframe id='st_6cb589336e50445fbf79f9411a696d91' width='400' height='100%' src='https://api.stockdio.com/visualization/financial/charts/v1/MarketOverview?app-key=3F3765F6FF284467B14A9241127AF282&showHeader=true&palette=Financial-Light&onload=st_6cb589336e50445fbf79f9411a696d91'></iframe>
    </div>
</body>
</html>






<%--
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>--%>
