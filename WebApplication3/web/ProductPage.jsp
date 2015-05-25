<%-- 
    Document   : ProductPage
    Created on : 24-mei-2015, 13:39:08
    Author     : Dennis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="Masterpage_final.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/productPage.css" rel="stylesheet">
        <script src="js/productpage.js"></script>

        <title>Product Page</title>
    </head>
    <body>
        <%
            //String QString = request.getParameter("fotoid").toString();
            String QString = "213"; //For Debug
            Test.Photo photo = new Test.Photo();
            String link = "";
            if (!QString.equals("") && !QString.equals(null)) {
                link = photo.convertCodeToLink(QString);
            }
        %>
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
                                    <div class="product-title">Productsoort:</div>
                                    <select id="Soort" name="Soort" class="btn btn-default" onchange="updatePrice()">
                                        <option value="1">Foto</option>
                                        <option value="2">Beker</option>
                                        <option value="3">T-shirt</option>
                                        <option value="3">Muismat</option>
                                    </select>
                                    <div class="product-title" style="margin-top: 10px">Fotokleur: </div>
                                    <select id="Type" name="Type" class="btn btn-default" onchange="changeColor()">
                                        <option value="1">Normaal</option>
                                        <option value="2">Zwart-Wit</option>
                                        <option value="3">Sepia</option>
                                    </select>
                                    <div class="product-title" style="margin-top: 10px;">Afbeelding aanpassen</div>
                                    <button class="btn btn-default">Afbeelding bijnsnijden</button>
                                    <hr>
                                    <div id="Prijs" class="product-price">$ 0,00</div>
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
