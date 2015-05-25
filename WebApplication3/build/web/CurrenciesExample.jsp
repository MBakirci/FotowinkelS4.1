<%-- 
    Document   : Currencies
    Created on : 23-mei-2015, 0:33:50
    Author     : Gebruiker
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <title>Currency Conversion Tutorial</title>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.0/jquery.min.js"></script>
        <script type="text/javascript" src="js/money.js"></script>
        <script type="text/javascript" src="js/accounting.js"></script>
        <%double i = 9.99;%>
    </head>
    <body>
        <select id="ddlCurr" name="ddlCurr">
            <option value="EUR">EURO €</option>
            <option value="USD">DOLLAR $</option>
            <option value="GBP">POUND £</option>
            <option value="TRY">LIRA &#8378</option>
        </select>
        <h1 id="Money"></h1>
        <p></p>
        <ul class="currencies"></ul>

        <script>
            $(document).ready(function () {

                fx.base = "EUR";
                fx.settings = {
                    from: "EUR"
                };
                var amount = <%=i%>;
                
                var EUR = fx.convert(amount, {to: "EUR"});
                EUR = accounting.formatMoney(EUR, "€ ", 2, ".", ",");
                $("#Money").text(EUR);
                
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

                                // we can now use the accounting.js library to format the numbers properly
                                USD = accounting.formatMoney(USD, "$ ", 2, ",", ".");
                                GBP = accounting.formatMoney(GBP, "£ ", 2, ",", ".");
                                TRY = accounting.formatMoney(TRY, "\u20BA " , 2, ".", ",");
                                
                                if ($("#ddlCurr").val() == 'USD'){
                                    $("#Money").text(USD);
                                }
                                else if ($("#ddlCurr").val() == 'GBP'){
                                    $("#Money").text(GBP);
                                }
                                else if ($("#ddlCurr").val() == 'EUR'){
                                    $("#Money").text(EUR);
                                }
                                else if ($("#ddlCurr").val() == 'TRY'){
                                    $("#Money").text(TRY);
                                }
                            }
                    );

                });
            });
        </script>
    </body>
</html>
