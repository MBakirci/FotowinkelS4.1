<%-- 
    Document   : Winkelwagen
    Created on : 7-apr-2015, 18:49:12
    Author     : Gebruiker
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="Masterpage_final.jsp"></jsp:include>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>  
    </head>
        <form action="ShoppingCart" method="POST">
            <input type="text" name="naam" value="" />
            <input type="text" name="aantal" value="" />
            <input type="text" name="prijs" value="" />
            <input type="text" name="kleur" value="" />
            <input type="text" name="product" value="" />
            <input type="text" name="foto" value="" />
            <input type="submit" value="sgdsfsd" />
        </form>
    
    
    <div class="container-fluid">
                <div class="row-fluid">
                    <div class="col-md-10 col-lg-offset-1">
                        <fieldset>
                            <legend>Prijzen Instellen</legend>
                        <%
        Test.WinkelWagen winkelwagen = new Test.WinkelWagen();
            
        ArrayList<Test.WinkelWagenItem> itemlist = winkelwagen.WinkelList();
         
                        %>
                        <table class="table table-bordered">
                            <tr>
                                <th>Foto</th>
                                <th>Fotocode</th>
                                <th>Product Naam</th>
                                <th>Aantal</th>
                                <th>Prijs €</th>
                                <th></th>
                                <th></th>
                            </tr>
                            <%
                                for (Test.WinkelWagenItem es : itemlist) {
                            %>
                            <tr>
                                <td width="150px">
                                    <a class="thumbnail" href=<%=es%>>
                                <img id="<%= es.getFotocode() %>" class="img-responsive" style="position: relative; top: 0; left: 0;" alt="test" width="100" height="100" style="z-index: -1" src="ftp://asror:asror@212.64.126.219:9942/THUMB/<%= es.getfoto().substring(es.getfoto().lastIndexOf("/") + 1, es.getfoto().lastIndexOf(".") + 4)%>" > 

                            </a>
                                
                                </td>
                                <td id="naam"><%= es.getFotocode() %></td>
                                <td id="beschrijing"><%= es.getProducttype() + " " + es.getKleurtype() %></td>
                                <td id="details"><%= es.getAantal() %></td>
                                <td id="prijs"><%= es.getPrijs() %></td>
                                <td>
                                    <form action="ShoppingCart" method="post">
                                        <!-- Verwijder button met request naar servlet -->
                                        <button type="submit" class="btn btn-default btn-sm btn-danger">
                                            <span class="glyphicon glyphicon-trash"></span>
                                        </button>                                        
                                        <input type="hidden" name="typeID" value="<%= es.getFotocode() %>" />
                                    </form>
                                </td>
                                <td>

                                    <!--Dit is de edit button
                                    <button type="button" class="btn btn-default btn-sm btn-primary" name="btnEdit" data-toggle="modal" data-target="#myModal">
                                        <span class="glyphicon glyphicon-edit"></span>
                                    </button> 
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
                    <a href="#" class="btn btn-primary"> Afrekenen <span class="glyphicon glyphicon-plus-sign"></span></a>
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
                        <h4 class="modal-title" id="myModalLabel">Product Aanpassen</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" id="editModal" action="ShoppingCart" method="Post">
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="id1">ID:</label>
                                <div class="col-sm-4">
                                    <input type="number" class="form-control" name="id1" id="id1" readonly >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="naam1">Fotocode:</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="naam1" id="naam1" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="details1">Aantal:</label>
                                <div class="col-sm-10">          
                                    <input type="text" class="form-control" name="details1" id="details1">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="prijs1">Prijs:</label>
                                <div class="col-sm-10">          
                                    <input type="number" step="0.01" class="form-control" name="prijs1" id="prijs1" required>
                                </div>
                            </div>
                            <div class="form-group">    
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="submit" name="btnBewerkt" class="btn btn-primary">Bewerk</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>        
                    
       
    </body>
</html>
