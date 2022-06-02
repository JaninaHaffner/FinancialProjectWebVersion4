<%--
  Created by IntelliJ IDEA.
  User: janin
  Date: 2022/06/01
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserSpecificPage</title>
</head>
<body>

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
<iframe id='st_b36160678d834ddd88397aa3c585d84c' frameBorder='0' scrolling='no' width='800' height='100%'
        src='https://api.stockdio.com/visualization/financial/charts/v1/historicalpricesboard?app-key=7F5CA262046A4B63B327718307695CF1&stockExchange={exchange}&symbols=BTC;ETH;XRP;BCH;LTC;DOGE;BTG&displayPrices=Area&dividends=true&splits=true&palette=Financial-Light&title=Watch%20List&onload=st_b36160678d834ddd88397aa3c585d84c'>

</iframe>

</body>
</html>
