<%-- 
    Document   : Price
    Created on : 19-mei-2015, 20:21:56
    Author     : Gebruiker
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="Test.PriceSettings"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="Masterpage_final.jsp"></jsp:include>
<%@include file="TaalSettings.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="Price_Titel"/></title>
    </head>
    <body>
        <div class="container">
            <div class="row-fluid">
                <div class="col-md-12">
                    <fieldset>
                        <legend><fmt:message key="Price_Legend"/></legend>
                        <%
                            PriceSettings opp = new PriceSettings();
                        %>
                        <table class="table table-bordered">
                            <tr>
                                <th></th>
                                <th><fmt:message key="Price_ProductNaam"/></th>
                                <th><fmt:message key="Price_Details"/></th>
                                <th><fmt:message key="Price_PrijsEUR"/></th>
                                <th></th>
                                <th></th>
                            </tr>
                            <%
                                for (Map.Entry<Integer, List<String>> productEntry : opp.getallProductTypes().entrySet()) {
                            %>
                            <tr>
                                <td id="id" style="color:grey;"><%= productEntry.getKey()%></td>
                                <td id="naam"><%= productEntry.getValue().get(0)%></td>
                                <td id="details"><%= productEntry.getValue().get(1)%></td>
                                <td id="prijs"><%= productEntry.getValue().get(2)%></td>
                                <td>
                                    <form action="PriceServlet" method="post">
                                        <!-- Verwijder button met request naar servlet -->
                                        <button type="submit" class="btn btn-default btn-sm btn-danger">
                                            <span class="glyphicon glyphicon-trash"></span>
                                        </button>                                        
                                        <input type="hidden" name="typeID" value="<%= productEntry.getKey()%>" />
                                    </form>
                                </td>
                                <td>

                                    <!--Dit is de edit button
                                    <button type="button" class="btn btn-default btn-sm btn-primary" name="btnEdit" data-toggle="modal" data-target="#myModal">
                                        <span class="glyphicon glyphicon-edit"></span>
                                    </button> 
                                    <!--<input type="hidden" name="type" value="<%= productEntry.getKey()%>" />
                                    -->
                                    <a href="#" class="btn btn-primary edit"> <span class="glyphicon glyphicon-edit"></span></a>


                                </td>
                            </tr>    	
                            <%
                                }%>
                        </table>
                    </fieldset>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <a href="#" class="btn btn-primary edit"><fmt:message key="Price_PrijsToevoegen"/><span class="glyphicon glyphicon-plus-sign"></span></a>
                </div>
            </div>
        </div>
        <script>
            $('a.edit').on('click', function () {
                var myModal = $('#myModal');
                // now get the values from the table
                var id = $(this).closest('tr').find('#id').html();
                var naam = $(this).closest('tr').find('#naam').html();
                var details = $(this).closest('tr').find('#details').html();
                var prijs = $(this).closest('tr').find('#prijs').html();
                // and check if you set a price to the item, then convert the comma to a point decimal.
                if (prijs != undefined) {
                    prijs = parseFloat(prijs.replace(",", "."));
                }
                // and set them in the modal:
                $(".modal-body #id1").val(id);
                $(".modal-body #naam1").val(naam);
                $(".modal-body #details1").val(details);
                $(".modal-body #prijs1").val(prijs);
                // and finally show the modal
                myModal.modal({show: true});
                return false;
            });
        </script>
        <!-- Modal -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel"><fmt:message key="Price_ProductAanpassen"/></h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" id="editModal">
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="id1"><fmt:message key="Price_ID"/>:</label>
                                <div class="col-sm-4">
                                    <input type="number" class="form-control" name="id1" id="id1" readonly >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="naam1">*<fmt:message key="Price_Naam"/>:</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="naam1" id="naam1" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="details1"><fmt:message key="Price_Details"/>:</label>
                                <div class="col-sm-10">          
                                    <input type="text" class="form-control" name="details1" id="details1">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="prijs1">*<fmt:message key="Price_Prijs"/>:</label>
                                <div class="col-sm-10">          
                                    <input type="number" step="0.01" class="form-control" name="prijs1" id="prijs1" required>
                                </div>
                            </div>
                            <div class="form-group">        
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="submit" name="btnBewerkt" class="btn btn-primary"><fmt:message key="Price_Bewerk"/></button>
                                </div>
                            </div>
                        </form>
                        <%
                            if (request.getParameter("btnBewerkt") != null) {
                                //Get Textbox
                                String sa = request.getParameter("id1");
                                if (sa.equals("")) {
                                    sa = null;
                                }
                                if (sa != null) {
                                    opp.setTypeNaam(request.getParameter("naam1"));
                                    opp.setTypeDetails(request.getParameter("details1"));
                                    opp.setPrijs(Double.parseDouble(request.getParameter("prijs1")));
                                    opp.setTypeID(Integer.parseInt(request.getParameter("id1")));
                                    int a = Integer.parseInt(request.getParameter("id1"));
                                    opp.EditProductType(a);
                                    response.sendRedirect("Price.jsp");
                                } else {
                                    opp.setTypeNaam(request.getParameter("naam1"));
                                    opp.setTypeDetails(request.getParameter("details1"));
                                    opp.setPrijs(Double.parseDouble(request.getParameter("prijs1")));
                                    opp.AddProductType();
                                    response.sendRedirect("Price.jsp");
                                }
                            }

                        %>
                    </div>
                </div>
            </div>
        </div>        
    </body>
</html>