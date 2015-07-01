<%-- 
    Document   : CustomerOrders
    Created on : 24-jun-2015, 10:37:27
    Author     : asror
--%>

<%@page import="java.lang.String"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="TaalSettings.jsp" %>
<jsp:include page="Masterpage_final.jsp"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="CSS/CustomerOrders.css" rel="stylesheet" type="text/css"/>
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
        <link href="CSS/TableFactuurs.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <table id="cart" class="table table-hover table-condensed">
                <thead>
                    <tr>
                        <th style="width:50%">Bestelling ID</th>
                        <th style="width:10%">Datum</th>
                        <th style="width:10%">Prijs</th>
                    </tr>
                </thead>
                <tbody>
                    <% Test.CustomerOrders custord = new Test.CustomerOrders();

                        ArrayList<Test.Order> orderlist = custord.getAllOrders("Dennnis@dennis.nl");

                        for (Test.Order es : orderlist) {
                    %>
                    <tr class='clickable-row'>
                        <td class ="orderid" data-th="Product">
                            <div class="row">
                                <div class="col-sm-2 hidden-xs"><%= es.getBestellingid() %></div>
                                <div class="col-sm-10">
                                </div>
                            </div>
                        </td>
                        <td data-th="Datum" class="text-center"><%= es.getDatum() %></td>

                        <td data-th="Prijs" class="text-center"><%=  es.getPrijs() + " " + es.getValuta() %></td>

                    </tr>
                    <% }%>





                </tbody>
            </table>
            <script>
                jQuery(document).ready(function ($) {
                    $(".clickable-row").click(function () {
                        var item = $(this).closest("tr")   // Finds the closest row <tr> 
                                .find(".orderid")     // Gets a descendent with class="nr"
                                .text();
                        var orderId = item.replace(/\s/g, '');
                        
                        window.location.href = "Factuur.jsp?BestellingID=" + orderId;
                    });
                });
            </script>
        </div>
    </body>
</html>
