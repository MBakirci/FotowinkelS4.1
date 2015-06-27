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

                        ArrayList<String> orderlist = custord.getAllOrders("Dennnis@dennis.nl");

                        for (String es : orderlist) {
                    %>
                    <tr class='clickable-row'>
                        <td data-th="Product">
                            <div class="row">
                                <div class="col-sm-2 hidden-xs"><%= es%></div>
                                <div class="col-sm-10">
                                </div>
                            </div>
                        </td>
                        <td data-th="Datum" class="text-center"><%= custord.getOrderDatum(es)%></td>

                        <td data-th="Prijs" class="text-center"><%=  custord.getOrderPrice(es) + " " + custord.getOrderValuta(es)%></td>

                    </tr>
                    <% }%>





                </tbody>
            </table>
            <script>
                jQuery(document).ready(function ($) {
                    $(".clickable-row").click(function () {
                        alert("eyey");
                    });
                });
            </script>
        </div>
    </body>
</html>
