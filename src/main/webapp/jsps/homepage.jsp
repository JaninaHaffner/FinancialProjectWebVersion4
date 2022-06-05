<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style2.css">
    <title>Homepage</title>
</head>
<body>
    <div class="header">
       <h1>The Financial Curation</h1>
    </div>
    <div class="navbar">
        <a href="#">Home</a>
        <a href="#">News</a>
        <a href="#">Markets</a>
        <a href="#">Exchanges</a>
        <a href="LogOutServlet" class="right">Logout</a>
    </div>
    <div class="row">
        <div class="side"></div>
        <div class="main">
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
            <iframe id='st_726f2915c60a4930b73d054a3c013725' frameBorder='0' scrolling='no' width='100%' height='100%' src='https://api.stockdio.com/visualization/financial/charts/v1/Ticker?app-key=7F5CA262046A4B63B327718307695CF1&stockExchange=JSE&symbols=NPN;HAR;BTI;SBK;GLN&palette=Financial-Light&layoutType=10&onload=st_726f2915c60a4930b73d054a3c013725'>
        
            </iframe>
            <br>

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
            <iframe id='st_d595a84bc4534e2fb156c3a2f5429e25' frameBorder='0' scrolling='no' width='800' height='100%'
                    src='https://api.stockdio.com/visualization/financial/charts/v1/MarketOverview?app-key=7F5CA262046A4B63B327718307695CF1&stockExchange=JSE&showCurrency=true&palette=Financial-Light&onload=st_d595a84bc4534e2fb156c3a2f5429e25'>
        
            </iframe>




        </div>
    </div>

    <div class="footer">
        <p>Copyright 2022 The Finance Curation. All rights reserved</p>
        <p>Terms of Service | Privacy Policy</p>
    </div>
    
</body>
</html>
