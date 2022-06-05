<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/style2.css">
    <title>Homepage</title>
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
        <iframe id='st_d51489f83c2947cb847dc3186c5df69d' width='100%' height='100%'
                src='https://api.stockdio.com/visualization/financial/charts/v1/EconomicNews?app-key=3F3765F6FF284467B14A9241127AF282&includeDescription=false&imageWidth=40&imageHeight=40&palette=Financial-Light&onload=st_d51489f83c2947cb847dc3186c5df69d'>

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
                src='https://api.stockdio.com/visualization/financial/charts/v1/Ticker?app-key=7F5CA262046A4B63B327718307695CF1&stockExchange=JSE&symbols=NPN;HAR;BTI;SBK;GLN&palette=Financial-Light&layoutType=10&onload=st_726f2915c60a4930b73d054a3c013725'>

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
        <iframe id='st_e7e61cede00a4bdeb70b16983943ec25' width='1005' height='150%'
                src='https://api.stockdio.com/visualization/financial/charts/v1/MarketOverviewChart?app-key=7F5CA262046A4B63B327718307695CF1&palette=Financial-Light&title=Market%20Overview&onload=st_e7e61cede00a4bdeb70b16983943ec25'>

        </iframe>




    </div>
</div>

<div class="footer">
    <p>Copyright 2022 The Finance Curation. All rights reserved</p>
    <p>Terms of Service | Privacy Policy</p>
</div>

</body>
</html>