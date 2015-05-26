<%-- 
    Document   : ProductPage
    Created on : 24-mei-2015, 13:39:08
    Author     : Dennis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Test.ProductPage"%>
<jsp:include page="Masterpage_final.jsp"/>
<%@include file="TaalSettings.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/productPage.css" rel="stylesheet">
        <script src="js/productpage.js"></script>

        <title>Product Page</title>
    </head>
    <body onload="updatePrice()">
        <%
            String QString = request.getParameter("fotoid").toString();
            // String QString = "213"; //For Debug
            Test.Photo photo = new Test.Photo();
            String link = "";
            Test.ProductPage pp = new Test.ProductPage();
            ArrayList<Double> typePrices = new ArrayList<Double>();
            ArrayList<String> typeNames = new ArrayList<String>();
            String basePrice = "";
            ArrayList<String> colorNames = new ArrayList<String>();
            ArrayList<Double> colorPrices = new ArrayList<Double>();

            if (!QString.equals("") && !QString.equals(null)) {
                link = photo.convertCodeToLink(QString); //Get http link for image source
                typePrices = pp.getTypePrice(); //Get current type prices
                typeNames = pp.getTypeName();
                basePrice = pp.getBasePrice(QString);
                colorNames = pp.getColorName();
                colorPrices = pp.getColorPrice();
            }
        %>
        <script>
            function updatePrice() {
                var type = document.getElementById("Soort2");
                var selType = type.options[type.selectedIndex].text;
                var type2 = selType.substring(selType.indexOf("+") + 1);

                var price = document.getElementById("Prijs");

                var newPrice = document.getElementById("Type");
                var selPrice = newPrice.options[newPrice.selectedIndex].text;
                var price2 = selPrice.substring(selPrice.indexOf("+") + 1);



                var a = parseFloat(price2);
                var b = parseFloat(type2);

                var sum = a + b;
                price.innerHTML = "€" + sum;
            }


        </script>
        <div class="container-fluid">
            <div class="content-wrapper">	
                <div class="item-container">
                    <form>
                        <div class="container">	
                            <div class="col-md-4">
                                <div class="product col-md-8 service-image-left">
                                    <center>
                                        <img height="200" width="200" id="productFoto" src="<%=link%>"/>
                                    </center>
                                </div>
                            </div>
                            <form>
                                <div class="col-md-8">
                                    <div class="product-title">Foto: </div>
                                    <div class="product-desc">U kan hier uw foto's aanpassen, en vervolgens in uw winkelwagen stoppen.</div>
                                    <hr>
                                    <div class="product-title">Productsoort</div>
                                    <select id="Soort2" name="Soort2" class="btn btn-default" onchange="updatePrice()">
                                        <%for (Double es : typePrices) {%>
                                        <option value="<%=typePrices.indexOf(es)%>"><%=typeNames.get(typePrices.indexOf(es)).toString()%> + <%=es.toString()%></option>
                                        <%
                                            }%>
                                    </select>
                                    <div class="product-title" style="margin-top: 10px">Fotokleur</div>
                                    <select id="Type" name="Type" class="btn btn-default" onchange="changeColor();
                                            updatePrice();">
                                        <%for (Double num : colorPrices) {
                                        %>
                                        <option value="<%=colorPrices.indexOf(num)%>"><%=colorNames.get(colorPrices.indexOf(num))%> + <%=num.toString()%></option>
                                        <%
                                            }
                                        %>
                                    </select>
                                    <div class="product-title" style="margin-top: 10px;">Afbeelding aanpassen</div>
                                    <button class="btn btn-default">Afbeelding bijnsnijden</button>
                                    <hr>
                                    <div class="product-title" style="margin-top: 10px;">Aantal</div>
                                    <input type="number" required=""/>
                                    <hr>
                                    <div id="Prijs" class="product-price">$ <%=basePrice%></div>
                                    <div class="product-stock">In Voorraad</div>
                                    <hr>
                                    <div class="btn-group cart">
                                        <button type="button" class="btn btn-success">
                                            Aan winkelwagen toevoegen 
                                        </button>
                                    </div>
                                </div>
                        </div> 
                </div>
                <div class="container-fluid">		
                    <div class="col-md-12 product-info">
                        <ul id="myTab" class="nav nav-tabs nav_tabs">

                            <li class="active"><a href="#service-one" data-toggle="tab">DESCRIPTION</a></li>
                            <li><a href="#service-two" data-toggle="tab">PRODUCT INFO</a></li>
                            <li><a href="#service-three" data-toggle="tab">REVIEWS</a></li>

                        </ul>
                        <div id="myTabContent" class="tab-content">
                            <div class="tab-pane fade in active" id="service-one">

                                <section class="container product-info">

                                </section>

                            </div>
                            <div class="tab-pane fade" id="service-two">

                                <section class="container">

                                </section>

                            </div>
                            <div class="tab-pane fade" id="service-three">

                            </div>
                        </div>
                        <hr>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
