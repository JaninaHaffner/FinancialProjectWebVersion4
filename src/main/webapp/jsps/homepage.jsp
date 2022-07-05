<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style2.css"/>
    <script src="${pageContext.request.contextPath}/css/style2.css"></script>
    <title>Homepage</title>
</head>
<body>
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

<div class="row">
    <div class="side">
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
        <iframe id='st_084ee0a9a27d4bd9b9aefd01bbf95b1a' width='100%' height='100%' src='https://api.stockdio.com/visualization/financial/charts/v1/News?app-key=3F3765F6FF284467B14A9241127AF282&stockExchange=${stockExchange}&symbol=${firstSymbol}&includeDescription=false&imageWidth=40&imageHeight=40&palette=Financial-Light&title=News&onload=st_084ee0a9a27d4bd9b9aefd01bbf95b1a'>
        </iframe>

    </div>
    <div class="main">
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
        <iframe id='st_726f2915c60a4930b73d054a3c013725' width='100%' height='100%'
                src='https://api.stockdio.com/visualization/financial/charts/v1/Ticker?app-key=7F5CA262046A4B63B327718307695CF1&stockExchange=${stockExchange}&symbols=${symbols};GLN&palette=Financial-Light&layoutType=10&onload=st_726f2915c60a4930b73d054a3c013725'>

        </iframe>
        <br>

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
        <iframe id='st_89d5f55da3d0437b824fe93458dc161a' width='100%' height='100%'
                src='https://api.stockdio.com/visualization/financial/charts/v1/QuoteBoard?app-key=7F5CA262046A4B63B327718307695CF1&stockExchange=${stockExchange}&symbols=${symbols};&includeVolume=true&palette=Financial-Light&title=Watch%20List&onload=st_89d5f55da3d0437b824fe93458dc161a'>

        </iframe>
        


    </div>
</div>

<div class="footer">
    <p>Copyright 2022 The Finance Curation. All rights reserved</p>
    <p>Terms of Service | Privacy Policy</p>
</div>

</body>
</html>
