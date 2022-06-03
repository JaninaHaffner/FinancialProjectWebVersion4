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
    <iframe id='st_726f2915c60a4930b73d054a3c013725' width='100%' height='100%' src='https://api.stockdio.com/visualization/financial/charts/v1/Ticker?app-key=7F5CA262046A4B63B327718307695CF1&stockExchange=JSE&symbols=NPN;HAR;BTI;SBK;GLN&palette=Financial-Light&layoutType=10&onload=st_726f2915c60a4930b73d054a3c013725'>

    </iframe>

    <h1>The Finance Curation</h1>
    <p>Welcome to The Finance Curation. The ultimate destination for financial news and market updates</p>
    <a href="jsps/login.jsp" class="button">Login</a>
    <a href="jsps/registration.jsp" class="button">Register</a>

</header>

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
