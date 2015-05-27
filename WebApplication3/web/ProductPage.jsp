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
        <link href="CSS/cropper.css" rel="stylesheet">
        <link href="CSS/main.css" rel="stylesheet">
        <script src="js/productpage.js"></script>
        <script type="text/javascript" src="js/money.js"></script>
        <script type="text/javascript" src="js/accounting.js"></script>

        <title>Product Page</title>
    </head>
    <body>
        <%
            String link;
            String QString;
            Test.Photo photo = new Test.Photo();
            Test.ProductPage pp = new Test.ProductPage();
            ArrayList<Double> typePrices = new ArrayList<Double>();
            ArrayList<String> typeNames = new ArrayList<String>();
            String basePrice = "";
            ArrayList<String> colorNames = new ArrayList<String>();
            ArrayList<Double> colorPrices = new ArrayList<Double>();
            
            if (request.getParameter("cropid") != null) {
                QString = request.getParameter("fotoid").toString();
                link = "";

                if (!QString.equals("") && !QString.equals(null)) {
                    link = photo.convertCodeToLink(QString); //Get http link for image source
                    typePrices = pp.getTypePrice(); //Get current type prices
                    typeNames = pp.getTypeName();
                    basePrice = pp.getBasePrice(QString);
                    colorNames = pp.getColorName();
                    colorPrices = pp.getColorPrice();
                }
            } else {
                QString = request.getParameter("fotoid").toString();
                link = "";

                if (!QString.equals("") && !QString.equals(null)) {
                    link = photo.convertCodeToLink(QString); //Get http link for image source
                    typePrices = pp.getTypePrice(); //Get current type prices
                    typeNames = pp.getTypeName();
                    basePrice = pp.getBasePrice(QString);
                    colorNames = pp.getColorName();
                    colorPrices = pp.getColorPrice();
                }
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
                return sum;
            }



        </script>

        <div class="modal fade" id="cropper-example-2-modal">
            <div class="modal-dialog">
                <div class="modal-content">

                    <div class="modal-body">
                        <div id="cropper-example-2">
                            <div class="img-container">
                                <img src="<%=link%>" alt="Picture">
                            </div>
                            <form action="Cropper" method="get">      
                                <input type="hidden" value="<%= QString%>" name="photoid">
                                <!-- <h3 class="page-header">Data:</h3> -->                            
                                <input class="form-control" id="dataX" name="dataX" type="hidden">
                                <input class="form-control" id="dataY" name="dataY" type="hidden" >
                                <input class="form-control" id="dataWidth" name="dataWidht" type="hidden">
                                <input class="form-control" id="dataHeight" name="dataHeight" type="hidden">
                                <input class="form-control" id="file" name="file" type="hidden" value="<%=link%>">
                                <input type="submit" class="btn btn-success" value="Crop">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div><!--<button class="btn btn-primary" data-toggle="modal" data-target="#cropper-example-2-modal" type="button">Launch the demo</button>-->
        <script>
            var $image = $('#cropper-example-2 > img'),
                    cropBoxData,
                    canvasData;

            $('#cropper-example-2-modal').on('shown.bs.modal', function () {
                $image.cropper({
                    autoCropArea: 0.5,
                    built: function () {
                        // Strict mode: set crop box data first
                        $image.cropper('setCropBoxData', cropBoxData);
                        $image.cropper('setCanvasData', canvasData);
                    }
                });
            }).on('hidden.bs.modal', function () {
                cropBoxData = $image.cropper('getCropBoxData');
                canvasData = $image.cropper('getCanvasData');
                $image.cropper('destroy');
            });
        </script>

        <div class="container-fluid">
            <div class="content-wrapper">	
                <div class="item-container">
                    <div class="container">	
                        <div class="col-md-4">
                            <div class="product col-md-8 service-image-left">
                                <center>
                                    <% if (request.getParameter("cropid") != null) {%>
                                    <img height="200" width="200" id="productFoto" src="ftp://212.64.126.219:9942/<%= request.getParameter("cropid") %>"/>
                                    <% } else {%>
                                    <img height="200" width="200" id="productFoto" src="<%=link%>"/>
                                    <% } %>
                                </center>
                            </div>
                        </div>
                        <div class="col-md-8">
                            <div class="product-title">Foto: </div>
                            <div class="product-desc">U kan hier uw foto's aanpassen, en vervolgens in uw winkelwagen stoppen.</div>
                            <hr>
                            <form action="ShoppingCart" method="POST">
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
                                <button class="btn btn-default" data-toggle="modal" data-target="#cropper-example-2-modal" type="button">Afbeelding bijnsnijden</button>
                                <hr>
                                <div class="product-title" style="margin-top: 10px;">Aantal</div>
                                <input type="number" name="aantalitems" required="" value="1"/>
                                <hr>
                                <div id="Prijs" name="price" class="product-price"></div>
                                <div>
                                    <select id="ddlCurr" name="ddlCurr">
                                        <option value="EUR">EURO €</option>
                                        <option value="USD">DOLLAR $</option>
                                        <option value="GBP">POUND £</option>
                                        <option value="TRY">LIRA &#8378</option>
                                    </select>
                                </div>
                                <div class="product-stock">In Voorraad</div>
                                <hr>
                                <div class="btn-group cart">
                                    <input type="hidden" class="form-control" name="fotoimage" value="<%= request.getParameter("fotoid")%>" id="fotoimage">
                                    <input type="hidden" class="form-control" name="xcor" value="<%= request.getParameter("xcor")%>" id="xcor">
                                    <input type="hidden" class="form-control" name="ycor" value="<%= request.getParameter("ycor")%>" id="ycor">
                                    <input type="hidden" class="form-control" name="wamnt" value="<%= request.getParameter("wamnt")%>" id="wamnt">
                                    <input type="hidden" class="form-control" name="hamnt" value="<%= request.getParameter("hamnt")%>" id="hamnt">
                                    
                                    <button type="submit" class="btn btn-success">
                                        Aan winkelwagen toevoegen 
                                    </button>
                                </div>
                            </form>
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

        <script>


            $(document).ready(function () {
                updatePrice();

                fx.base = "EUR";
                fx.settings = {
                    from: "EUR"
                };

                var amountje = $("#Prijs").text();
                var str = amountje.substring(1);
                var amount = parseFloat(str);

                var EUR = fx.convert(amount, {to: "EUR"});
                EUR = accounting.formatMoney(EUR, "€", 2, ".", ",");
                $("#Prijs").text(EUR);


                $("#ddlCurr").change(function () {
                    amount = updatePrice();

                    $.getJSON(
                            'latest.json',
                            function (data) {
                                // Check money.js has finished loading:
                                if (typeof fx !== "undefined" && fx.rates) {
                                    fx.rates = data.rates;
                                    fx.base = data.base;
                                } else {
                                    // If not, apply to fxSetup global:
                                    var fxSetup = {
                                        rates: data.rates,
                                        base: data.base
                                    }
                                }

                                // now that we have exchange rates, add a few to our page
                                var USD = fx.convert(amount, {to: "USD"}); //13.22784197768393
                                var GBP = fx.convert(amount, {to: "GBP"}); //8.567532636985659
                                var TRY = fx.convert(amount, {to: "TRY"}); //1028.1670562349989
                                var EUR = fx.convert(amount, {to: "EUR"});

                                // we can now use the accounting.js library to format the numbers properly
                                USD = accounting.formatMoney(USD, "$", 2, ",", ".");
                                GBP = accounting.formatMoney(GBP, "£", 2, ",", ".");
                                TRY = accounting.formatMoney(TRY, "\u20BA", 2, ".", ",");
                                EUR = accounting.formatMoney(EUR, "€", 2, ".", ",");

                                if ($("#ddlCurr").val() == 'USD') {
                                    $("#Prijs").text(USD);
                                }
                                else if ($("#ddlCurr").val() == 'GBP') {
                                    $("#Prijs").text(GBP);
                                }
                                else if ($("#ddlCurr").val() == 'EUR') {
                                    $("#Prijs").text(EUR);
                                }
                                else if ($("#ddlCurr").val() == 'TRY') {
                                    $("#Prijs").text(TRY);
                                }
                            }
                    );

                });
            });

        </script>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/cropper.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>
