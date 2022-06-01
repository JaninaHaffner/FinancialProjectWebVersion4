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
    <aside>
    <script>
        if (typeof(stockdio_events) == "undefined") {
            stockdio_events = true;
            var stockdio_eventMethod = window.addEventListener ? "addEventListener" : "attachEvent";
            var stockdio_eventer = window[stockdio_eventMethod];
            var stockdio_messageEvent = stockdio_eventMethod == "attachEvent" ? "onmessage" : "message";
            stockdio_eventer(stockdio_messageEvent, function (e) {
                if (typeof(e.data) != "undefined" && typeof(e.data.method) != "undefined") {
                    eval(e.data.method);
                }
            },false);
        }
    </script>
    <iframe id='st_d595a84bc4534e2fb156c3a2f5429e25' frameBorder='0' scrolling='no' width='400' height='100%'
            src='https://api.stockdio.com/visualization/financial/charts/v1/MarketOverview?app-key=7F5CA262046A4B63B327718307695CF1&stockExchange=JSE&showCurrency=true&palette=Financial-Light&onload=st_d595a84bc4534e2fb156c3a2f5429e25'>

    </iframe>
    </aside>

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
