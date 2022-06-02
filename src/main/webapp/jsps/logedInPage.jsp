<%--
  Created by IntelliJ IDEA.
  User: janin
  Date: 2022/05/29
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>You are successfully logged in</title>
</head>
<body>
<p aria-label="logedInPage" >You are successfully logged in!</p>

<%--I need a list here with the following options for the user to select one of the stock markets they would like to receive information on
 in the form of a variable:  variable stockExchangeSelection = one item from the list below
1. Currencies Trading(Forex)
2. Commodities Trading
3. Crypto
4. Futures
5. Bonds--%>

<P>Please select the exchange you would like to view.</P>
<jsp:element name="var">
<div class="radio-details">
    <input type="radio" name="exchange" id="dot-1" value="Currencies Trading(Forex)">
    <input type="radio" name="exchange" id="dot-2" value="Commodities Trading">
    <input type="radio" name="exchange" id="dot-3" value="Crypto">
    <input type="radio" name="exchange" id="dot-4" value="Futures">
    <input type="radio" name="exchange" id="dot-5" value="Bonds">
    <span class="radio-title">Stock Exchange to be viewed: </span>
    <div class="category">
        <label for="dot-1">
            <span class="dot one"></span>
            <span class="radio">Currencies Trading(Forex)</span>
        </label>
        <label for="dot-2">
            <span class="dot two"></span>
            <span class="radio">Commodities Trading</span>
        </label>
        <label for="dot-3">
            <span class="dot three"></span>
            <span class="radio">Crypto</span>
        </label>
        <label for="dot-4">
            <span class="dot four"></span>
            <span class="radio">Futures</span>
        </label>
        <label for="dot-5">
            <span class="dot five"></span>
            <span class="radio">Bonds</span>
        </label>
    </div>
</div>

<%--
Then we need a variable text box where the user can enter the symbols of the stock they would like to have displayed to them or emailed to them.

--%>

</jsp:element>
<jsp:forward page="userSpesificInformationDisplay.jsp">jsp:element name=var</jsp:forward>
</body>
</html>
