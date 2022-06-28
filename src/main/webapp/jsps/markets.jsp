<%--
  Created by IntelliJ IDEA.
  User: janin
  Date: 2022/06/05
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/style2.css">
    <title>Markets</title>
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
<iframe id='st_e7e61cede00a4bdeb70b16983943ec25' width='800' height='100%'
        src='https://api.stockdio.com/visualization/financial/charts/v1/MarketOverviewChart?app-key=7F5CA262046A4B63B327718307695CF1&palette=Financial-Light&title=Market%20Overview&onload=st_e7e61cede00a4bdeb70b16983943ec25'>

</iframe>

<div class="footer">
    <p>Copyright 2022 The Finance Curation. All rights reserved</p>
    <p>Terms of Service | Privacy Policy</p>
</div>


</body>
</html>
