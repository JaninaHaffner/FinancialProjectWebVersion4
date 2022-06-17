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
<div class="row">
      <div class="side">
         <h3>Recent News</h3>
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
         <iframe id='st_d51489f83c2947cb847dc3186c5df69d' frameBorder='0' scrolling='no' width='100%' height='100%' src='https://api.stockdio.com/visualization/financial/charts/v1/EconomicNews?app-key=3F3765F6FF284467B14A9241127AF282&includeDescription=false&imageWidth=40&imageHeight=40&palette=Financial-Light&onload=st_d51489f83c2947cb847dc3186c5df69d'></iframe>
         </div>
         <div class="main">
            <h3>Popular Stocks</h3>
            <h5>Forex</h5>
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
            <iframe id='st_e0558d2416a4433b90957a90066f41c0' frameBorder='0' scrolling='no' width='600' height='100%' src='https://api.stockdio.com/visualization/financial/charts/v1/QuoteBoard?app-key=3F3765F6FF284467B14A9241127AF282&stockExchange=FOREX&symbols=EUR%2FUSD;GBP%2FUSD;USD%2FJPY;USD%2FCHF;AUD%2FUSD&palette=Financial-Light&title=Watch%20List&onload=st_e0558d2416a4433b90957a90066f41c0'></iframe>
            <br>
      
            <h5>Crypto</h5>
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
            <iframe id='st_dc24818a430446c0b3834252fed99120' frameBorder='0' scrolling='no' width='600' height='100%' src='https://api.stockdio.com/visualization/financial/charts/v1/QuoteBoard?app-key=3F3765F6FF284467B14A9241127AF282&stockExchange=CRYPTO&symbols=BTC;ETH;XRP;BCH;LTC;&palette=Financial-Light&title=Watch%20List&onload=st_dc24818a430446c0b3834252fed99120'></iframe>
            <br>
      
            <h5>Commodities</h5>
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
            <iframe id='st_0071e4b4f52a44d68ceded531f3005ce' frameBorder='0' scrolling='no' width='600' height='100%' src='https://api.stockdio.com/visualization/financial/charts/v1/QuoteBoard?app-key=3F3765F6FF284467B14A9241127AF282&stockExchange=COMMODITIES&symbols=GC;SI;CO;CL;CR&palette=Financial-Light&title=Watch%20List&onload=st_0071e4b4f52a44d68ceded531f3005ce'></iframe>
      </div>
    </div>
     
    <div class="footer">
      <p>Copyright 2022 The Finance Curation. All rights reserved</p>
      <p>Terms of Service | Privacy Policy</p>
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
