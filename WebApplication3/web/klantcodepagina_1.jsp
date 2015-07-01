
<%@page import="java.util.ArrayList"%>
<%@page import="oracle.net.aso.a"%>
<!-- 
    Document   : klantcodepagina_1
    Created on : 8-apr-2015, 11:11:12
    Author     : Dennis
-->

<%@page import = "Test.Foto_klant" %>
<%@page import = "Test.Photo" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="Masterpage_final.jsp"/>
<%@include file="TaalSettings.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="KlantPageTitle"/></title>
    </head>
    <body>
        <div class="container">
            <form>
                <div class="col-lg-6 col-md-offset-3">
                    <h4 style="margin-top: 50px;"><fmt:message key="codeInvoer"/></h4>
                    <hr>
                    <div class="form-group">
                        <label for="inputvoornaam" class="sr-only">Individuele code</label>
                    </div>
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="input-group">
                                <input type="text" name="Code" class="form-control" placeholder="Code">
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="submit" name="btnCode"><fmt:message key="btnSetCode"/></button>
                                </span>
                            </div><!-- /input-group -->
                        </div><!-- /.col-lg-6 -->
                    </div>
                    <%
                        String code = request.getParameter("Code");
                        String error = "";
                        Test.Foto_klant FotoCode = new Test.Foto_klant();
                        Test.Photo idcode = new Test.Photo();
                        String a = idcode.getID(session.getAttribute("Name").toString());
                        String src = FotoCode.VraagFoto(code);
                        int id = Integer.parseInt(a);
                        Test.SQL sql = new Test.SQL();
                        request.setAttribute("image", src);
                        if (request.getParameter("btnCode") != null) {

                            if (src.equals("")) {
                                if (!sql.koppelingGroepsCode(code, id)) {


                    %>
                    <div style="margin-top: 10px" class="alert alert-danger" role="alert"><b><i><%=code%></i></b> - Deze code bestaat niet, controleer deze en probeer het opnieuw</div>
                                <%
                                } else {
                                    //Succes groepscode
%>
                    <div style="margin-top: 10px" class="alert alert-success" role="alert"><%=code%> is succesvol toegevoegd aan uw foto's</div>

                    <%
                        ArrayList<String> Fotocodes = new ArrayList<String>();
                        Fotocodes = sql.getFotoCodes(code);
                        for (String fotocode : Fotocodes) {
                    %>
                    <img style="max-height: 400px; max-width: 400px; mar" alt="" src="<%=fotocode%>">

                    <%
                            }
                        }
                    } else {
                        if (sql.koppeling(id, code)) {


                    %>
                    <div style="margin-top: 10px" class="alert alert-success" role="alert"><%=code%> is succesvol toegevoegd aan uw foto's</div>
                    <img style="max-height: 400px; max-width: 400px; mar" alt="" src="<%=request.getAttribute("image")%>">

                    <%
                    } else {
                    %>
                    <div style="margin-top: 10px" class="alert alert-danger" role="alert"><b><i><%=code%></i></b> - Deze code bestaat niet, controleer deze en probeer het opnieuw</div>

                    <%
                                }
                                //   response.sendRedirect("index.jsp");                     }
                            }
                        }
                    %>

                </div>
            </form>
        </div>

        <font color="red"><%=error%></font>

    </body>
</html>
