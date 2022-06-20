<%--
  Created by IntelliJ IDEA.
  User: janin
  Date: 2022/06/12
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style2.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/1.4.1/html2canvas.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/FileSaver.js/2.0.0/FileSaver.min.js"></script>
    <title>EmailHomepage</title>

</head>
<body>
<script>
    const canvas = document.getElementById('myCanvas', 'st_d51489f83c2947cb847dc3186c5df69d', 'st_726f2915c60a4930b73d054a3c013725', 'st_89d5f55da3d0437b824fe93458dc161a' ),
        ctx = canvas.getContext('2d'),
        image = new Image();

    image.onload = function (){
Promise.all([
    createImageBitmap(image, 0, 0, 32, 32),
    createImageBitmap(image, 32, 0, 32, 32)
]).then(function (sprites) {

    ctx.drawImage(sprites[0], 0, 0);
    ctx.drawImage(sprites[1], 32, 32);
});
    }

    image.src = 'sprites.png'; </script>

<div class="header">
    <h1>The Financial Curation</h1>
    <form hidden="hidden" >
        ${username}
        ${fullname}
        ${email}
        ${preference}
        ${updates}
        ${stockExchange}
        ${symbols}
        ${subject}
    </form>
</div>

<div class="navbar">
    <a href="${pageContext.request.contextPath}/jsps/emailHomePage.jsp">Home</a>
    <a href="${pageContext.request.contextPath}/jsps/profile.jsp">Profile</a>
    <a href="${pageContext.request.contextPath}/Logout" class="right">Logout</a>
    <a href="${pageContext.request.contextPath}/UnsubscribeServlet" class="right">Unsubscribe</a>
</div>
<iframe id="myCanvas">
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
</iframe>

<div class="footer">
    <p>Copyright 2022 The Finance Curation. All rights reserved</p>
    <p>Terms of Service | Privacy Policy</p>
</div>

</body>
  <script>
    window.addEventListener('load', (event) => {
        html2canvas(document.getElementsByTagName("iframe")).then(canvas => {
            canvas.toBlob(function(blob){
                window.saveAs(blob, "screenshot.png");
            })
        });

    });
</script>
</html>
