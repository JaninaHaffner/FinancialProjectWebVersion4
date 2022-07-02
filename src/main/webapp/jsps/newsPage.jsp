<%--
  Created by IntelliJ IDEA.
  User: janin
  Date: 2022/06/05
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/style2.css">
    <title>News Page</title>
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

<iframe id='st_084ee0a9a27d4bd9b9aefd01bbf95b1a' width='100%' height='100%' src='https://api.stockdio.com/visualization/financial/charts/v1/News?app-key=3F3765F6FF284467B14A9241127AF282&stockExchange=${stockExchange}&symbol=${firstSymbol}&includeDescription=false&imageWidth=40&imageHeight=40&palette=Financial-Light&title=News&onload=st_084ee0a9a27d4bd9b9aefd01bbf95b1a'></iframe>

<div class="footer">
    <p>Copyright 2022 The Finance Curation. All rights reserved</p>
    <p>Terms of Service | Privacy Policy</p>
</div>

</body>
</html>
