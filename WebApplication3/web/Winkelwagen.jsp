<%-- 
    Document   : Winkelwagen
    Created on : 7-apr-2015, 18:49:12
    Author     : Gebruiker
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="TaalSettings.jsp" %>
<!DOCTYPE html>
<jsp:include page="Masterpage_final.jsp"></jsp:include>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>  
            <script type="text/javascript" src="js/money.js"></script>
            <script type="text/javascript" src="js/accounting.js"></script>
        </head>

    <%

        if (request.getParameter("valuta") != null) {
            session.setAttribute("valuta", request.getParameter("valuta"));
        } else {
            if (session.getAttribute("valuta") != null) {

                response.sendRedirect("Winkelwagen.jsp?valuta=" + session.getAttribute("valuta"));
            }
        }


    %>

    <script>
        function getUrlParameter(sParam)
        {
            var sPageURL = window.location.search.substring(1);
            var sURLVariables = sPageURL.split('&');
            for (var i = 0; i < sURLVariables.length; i++)
            {
                var sParameterName = sURLVariables[i].split('=');
                if (sParameterName[0] == sParam)
                {
                    return sParameterName[1];
                }
            }
        }
    </script>
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="col-md-10 col-lg-offset-1">
                <fieldset>
                    <legend><fmt:message key="Winkelwagen_legend"/>Prijzen Instellen</legend>
                    <%                        Double prijs = 0.0;

                        Test.WinkelWagen winkelwagen = new Test.WinkelWagen();

                        ArrayList<Test.WinkelWagenItem> itemlist = winkelwagen.WinkelList();

                    %>
                    <table class="table table-bordered">
                        <tr>
                            <th><fmt:message key="Winkelwagen_Foto"/></th>
                            <th><fmt:message key="Winkelwagen_Aantal"/></th>
                            <th><fmt:message key="Winkelwagen_Prijs"/></th>
                            <th></th>
                        </tr>
                        <%                            int i = 0;
                            for (Test.WinkelWagenItem es : itemlist) {
                                i++;
                        %>
                        <tr>
                            <td width="150px">

                                <%  if (es.getWamnt() != 0) {%>


                                <%
                                    String url = "ProductPage.jsp?fotoid=" + es.getFotocode() + "&cropid=" + es.getProductnaam() + "&xcor=" + es.getXcor() + "&ycor=" + es.getYcor() + "&wamnt=" + es.getWamnt() + "&hamnt=" + es.getHamnt();
                                %>

                                <a class="thumbnail" href=<%= url%>>
                                    <img id="<%= es.getFotocode()%>" class="img-responsive" style="position: relative; top: 0; left: 0;" alt="test" width="100" height="100" style="z-index: -1" src="ftp://asror:asror@212.64.126.219:9942/<%= es.getProductnaam()%>" > 

                                </a>
                                <% } else {%>
                                <%
                                    String url = "ProductPage.jsp?fotoid=" + es.getFotocode();
                                %>
                                <a class="thumbnail" href=<%= url%>>
                                    <img id="<%= es.getFotocode()%>" class="img-responsive" style="position: relative; top: 0; left: 0;" alt="test" width="100" height="100" style="z-index: -1" src="ftp://asror:asror@212.64.126.219:9942/THUMB/<%= es.getfoto().substring(es.getfoto().lastIndexOf("/") + 1, es.getfoto().lastIndexOf(".") + 4)%>" > 
                                </a>
                                <% }%>

                            </td>
                        <form>
                            <td id="details">

                                <div class="input-group">
                                    <span class="input-group-btn">
                                        <button type="button" class="btn btn-danger btn-number"  data-type="minus" data-field="<%= i%>">
                                            <span class="glyphicon glyphicon-minus"></span>
                                        </button>
                                    </span>
                                    <input type="text" name="amount" id="<%= i%>" class="form-control input-number" value="<%= es.getAantal()%>" min="1">
                                    <span class="input-group-btn">
                                        <button type="button" class="btn btn-success btn-number" data-type="plus" data-field="<%= i%>">
                                            <span class="glyphicon glyphicon-plus"></span>
                                        </button>
                                    </span>
                                </div>

                            </td>

                            <input type="hidden" name="Soort2<%= i%>" value="<%= es.getProducttype()%>">
                            <input type="hidden" name="Type<%= i%>" value="<%= es.getKleurtype()%>">
                            <input type="hidden" name="xcor<%= i%>" value="<%= es.getXcor()%>">
                            <input type="hidden" name="ycor<%= i%>" value="<%= es.getYcor()%>">
                            <input type="hidden" name="wamnt<%= i%>" value="<%= es.getWamnt()%>">
                            <input type="hidden" name="hamnt<%= i%>" value="<%= es.getHamnt()%>">
                            <input type="hidden" name="fotocod<%= i%>" value="<%= es.getFotocode()%>">
                            <input type="hidden" name="price1<%= i%>" value="<%= es.getPrijs()%>">
                        </form>



                        <td id="prijs"><%= es.getPrijs()%></td>
                        <%  prijs = prijs + es.getPrijs() * es.getAantal();
                            prijs = Math.round(prijs * 100.0) / 100.0;%>
                        <td>
                            <form action="ShoppingCart" method="post">
                                <!-- Verwijder button met request naar servlet -->
                                <input type="hidden" name="Soort2" value="<%= es.getProducttype()%>">
                                <input type="hidden" name="Type" value="<%= es.getKleurtype()%>">
                                <input type="hidden" name="xcor" value="<%= es.getXcor()%>">
                                <input type="hidden" name="ycor" value="<%= es.getYcor()%>">
                                <input type="hidden" name="wamnt" value="<%= es.getWamnt()%>">
                                <input type="hidden" name="hamnt" value="<%= es.getHamnt()%>">
                                <button type="submit" class="btn btn-default btn-sm btn-danger">
                                    <span class="glyphicon glyphicon-trash"></span>
                                </button>                                        
                                <input type="hidden" name="typeID" value="<%= es.getFotocode()%>" />
                            </form>
                        </td>
                        </tr>    	
                        <%
                            }%>
                    </table>


                    <table class="table table-bordered">
                        <tr>
                            <td align="left">Totaal prijs :</td> 
                            <td id="price" align="right">
                                <p id="Prijs" align="right"><%= prijs%></p> 

                                <div>
                                    <select id="ddlCurr" name="ddlCurr">
                                        <option value="EUR">EURO €</option>
                                        <option value="USD">DOLLAR $</option>
                                        <option value="GBP">POUND £</option>
                                        <option value="TRY">LIRA &#8378</option>
                                    </select>
                                </div>

                            </td>   
                        </tr>
                    </table>

                </fieldset>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="row">
            <hr>

        </div>            
        <div class="row">
            <div class="col-md-12">
                <!--    Paypal Test Account
    Email:      JantjeContantje@Sandbox.nl  
    Password:   Sandbox013-->

                <!--Paypal information-->
                <form name="_xclick" target="paypal" action="https://www.sandbox.paypal.com/us/cgi-bin/webscr" method="post" >
                    <input type="hidden" name="cmd" value="_cart">
                    <input type="hidden" name="upload" value="1">
                    <input type="hidden" name="business" value="Townofsalem@Sandbox.nl">
                    <input name="return" type="hidden" value="http://localhost:8080/WebApplication3/SuccesfulPayment.jsp"  ><!-- Return URL -->
                    <input name="cancel_return" type="hidden" value="http://localhost:8080/WebApplication3/index.jsp"> <!-- Return URL on cancelling payment --> 
                    <input type="hidden" name="no_shipping" value="0">
                    <input type="hidden" name="no_note" value="1">
                    <input type="hidden" name="currency_code" value="<%= (String) session.getAttribute("valuta")%>">
                    <input type="hidden" name="lc" value="AU">
                    <input type="hidden" name="bn" value="PP-BuyNowBF">
                    <input type="hidden" name="rm" value="2">
                    <!--Items will be shown in the shopping cart-->
                    <!--TODO: Gather items from a list:-->
                    <%
                        int productnummer = 1;
                        //ArrayList<String> Productlist = new ArrayList<String>();
                        //  Productlist.add("Book/0.01/2");
                        //    Productlist.add("Cat/0.01/1");

                        for (Test.WinkelWagenItem s : winkelwagen.GetWinkelWageValuta((String) session.getAttribute("valuta"))) {
                    %>

                    <input type="hidden" name="item_name_<%=productnummer%>" value=<%= s.getFotocode()%>>  
                    <input type="hidden" name="amount_<%=productnummer%>" value=<%= Math.round(s.getPrijs() * 100.0) / 100.0%>>
                    <input type="hidden" name="quantity_<%=productnummer%>" value=<%= s.getAantal().toString()%>>

                    <!--<input type="hidden" name="item_name_1" value="HTML book">  
                        <input type="hidden" name="amount_1" value="24.99">
                        <input type="hidden" name="quantity_1" value="2">-->

                    <!--<input type="hidden" name="item_name_2" value="Cat">
                        <input type="hidden" name="amount_2" value="19.99">
                        <input type="hidden" name="quantity_2" value="2">-->
                    <% productnummer++;

                            //  Check if form has been submitted (Check if paid)
                        }%>

                    <input type="image" src="https://www.paypalobjects.com/en_US/i/btn/x-click-but6.gif" border="0" name="submit" alt="PayPal - The safer, easier way to pay online.">
                </form>
            </div>
        </div>
    </div>  

    <script>
        //plugin bootstrap minus and plus
//http://jsfiddle.net/laelitenetwork/puJ6G/
        $('.btn-number').click(function (e) {
            e.preventDefault();

            fieldName = $(this).attr('data-field');
            type = $(this).attr('data-type');
            var input = $("input[id='" + fieldName + "']");
            var currentVal = parseInt(input.val());
            if (!isNaN(currentVal)) {
                if (type == 'minus') {

                    if (currentVal > input.attr('min')) {
                        input.val(currentVal - 1).change();
                    }
                    if (parseInt(input.val()) == input.attr('min')) {
                        $(this).attr('disabled', true);
                    }

                } else if (type == 'plus') {
                    input.val(currentVal + 1).change();
                }
            } else {
                input.val(0);
            }
        });
        $('.input-number').focusin(function () {
            $(this).data('oldValue', $(this).val());
        });
        $('.input-number').change(function () {

            minValue = parseInt($(this).attr('min'));
            maxValue = parseInt($(this).attr('max'));
            valueCurrent = parseInt($(this).val());

            name = $(this).attr('name');
            if (valueCurrent >= minValue) {
                $(".btn-number[data-type='minus'][data-field='" + name + "']").removeAttr('disabled')
            } else {
                alert('Sorry, the minimum value was reached');
                $(this).val($(this).data('oldValue'));
            }

        });
        $(".input-number").keydown(function (e) {
            // Allow: backspace, delete, tab, escape, enter and .
            if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 190]) !== -1 ||
                    // Allow: Ctrl+A
                            (e.keyCode == 65 && e.ctrlKey === true) ||
                            // Allow: home, end, left, right
                                    (e.keyCode >= 35 && e.keyCode <= 39)) {
                        // let it happen, don't do anything
                        return;
                    }
                    // Ensure that it is a number and stop the keypress
                    if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
                        e.preventDefault();
                    }
                });
    </script>
    <script>

        $("input[name=amount]").change(function () {
            //pairno tis times ap tin forma
            var i = $(this).attr('id');
            var Soort2 = $("input[name=Soort2" + i + "]").val();
            var Type = $("input[name=Type" + i + "]").val();
            var price = $("input[name=price1" + i + "]").val();
            var amount = $("input[id=" + i + "]").val();
            var xcor = $("input[name=xcor" + i + "]").val();
            var ycor = $("input[name=ycor" + i + "]").val();
            var wamnt = $("input[name=wamnt" + i + "]").val();
            var hamnt = $("input[name=hamnt" + i + "]").val();
            var fotocod = $("input[name=fotocod" + i + "]").val();
            //kano ta dedomena ena koino string
            var dataString = "Soort2=" + Soort2 + "&Type=" + Type + "&amount=" + amount + "&xcor=" + xcor + "&ycor=" + ycor + "&wamnt=" + wamnt + "&hamnt=" + hamnt + "&fotocod=" + fotocod;
            $.ajax({
                type: "POST",
                url: "ShoppingCartAmount",
                data: dataString,
                success: function (data) {

                    $('#results').show();
                    $('#results').html(data);
                    if (getUrlParameter('valuta') != null)
                    {
                        var valuta = getUrlParameter('valuta');
                        window.location.replace("Winkelwagen.jsp?valuta=" + getUrlParameter('valuta'));
                    }
                    else
                    {
                        window.location.replace("Winkelwagen.jsp");
                    }
                },
                error: function (ts) {
                    alert(ts.responseText)
                }
            });
        });</script>
    <script>
        $(document).ready(function () {
            $(window).keydown(function (event) {
                if (event.keyCode == 13) {
                    event.preventDefault();
                    return false;
                }
            });
        });
    </script>
    <script>


        $(document).ready(function () {
            var valuta = getUrlParameter('valuta');
            fx.base = "EUR";
            fx.settings = {
                from: "EUR"
            };
            var amount = $("#Prijs").text();
            var EUR;
            if (valuta != null)
            {
                $("#ddlCurr").val(valuta);
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
                            if (valuta == 'USD') {
                                $("#Prijs").text(USD);
                            }
                            else if (valuta == 'GBP') {
                                $("#Prijs").text(GBP);
                            }
                            else if (valuta == 'EUR') {
                                $("#Prijs").text(EUR);
                            }
                            else if (valuta == 'TRY') {
                                $("#Prijs").text(TRY);
                            }
                        }
                );
            }
            else
            {
                EUR = fx.convert(amount, {to: "EUR"});
            }
            EUR = accounting.formatMoney(EUR, "€", 2, ".", ",");
            $("#Prijs").text(EUR);
            $("#ddlCurr").change(function () {
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

                            window.location.replace("Winkelwagen.jsp?valuta=" + $("#ddlCurr").val());
                        }
                );
            });
        });</script>


</body>
</html>
