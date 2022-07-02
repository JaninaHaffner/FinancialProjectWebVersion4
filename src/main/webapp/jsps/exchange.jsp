<%--
  Created by IntelliJ IDEA.
  User: janin
  Date: 2022/06/05
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/style2.css">
    <title>Exchange</title>
</head>
<body>
<div class="header">
    <h1>The Financial Curation</h1>
</div>
<div class="navbar">
    <a href="homepage.jsp">Home</a>
    <a href="newsPage.jsp">News</a>
    <a href="markets.jsp">Markets</a>
    <a href="exchange.jsp">Exchanges</a>
    <a href="${pageContext.request.contextPath}/Logout" class="right">Logout</a>
</div>
<script>
    if (typeof(stockdio_events) == "undefined") {
        stockdio_events = true;
        const stockdio_eventMethod = window.addEventListener ? "addEventListener" : "attachEvent";
        const stockdio_eventer = window[stockdio_eventMethod];
        const stockdio_messageEvent = stockdio_eventMethod === "attachEvent" ? "onmessage" : "message";
        stockdio_eventer(stockdio_messageEvent, function (e) {
            if (typeof(e.data) != "undefined" && typeof(e.data.method) != "undefined") {
                eval(e.data.method);
            }
        },false);
    }
</script>
<iframe id='st_c66d06603b3c45a793a42aeb2f573fb5' width='600' height='100%'
        src='https://api.stockdio.com/visualization/financial/charts/v1/QuoteBoard?app-key=7F5CA262046A4B63B327718307695CF1&stockExchange=${stockExchange}&symbols=${symbols};&includeVolume=true&palette=Financial-Light&title=Watch%20List&onload=st_c66d06603b3c45a793a42aeb2f573fb5'>

</iframe>

<div class="footer">
    <p>Copyright 2022 The Finance Curation. All rights reserved</p>
    <p>Terms of Service | Privacy Policy</p>
</div>


</body>
</html>
