

<%@page import="javax.persistence.Convert"%>
<%-- 
    Document   : Inlogscherm
    Created on : 11-mrt-2015, 10:56:11
    Author     : hsm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "java.util.*"%>

<%--<%@page import= "Test.Databaseconnector"%>--%>
<%@page import="Test.Login" %>
<%@page import="java.sql.*"%>
<%@page import= "Test.Databaseconnector"%>
<%@page import = "Test.registreer"%>
<%@page import = "Test.Verwijderaccount"%>
<jsp:include page="Masterpage_final.jsp"></jsp:include>
    <%@include file="TaalSettings.jsp" %>
<%if (session.getAttribute("Role") == null || !session.getAttribute("Role").equals("admin")) {
        response.sendRedirect("index.jsp");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <title><fmt:message key='Adminpage_Title'/></title>
        <link href="CSS/chosen.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <h2 class="form-signin-heading"><fmt:message key='Adminpage_h2'/></h2>
            <hr>

            <form class="col-md-6" method="post">

                <div class="form-group col-md-12">
                    <label class="control-label"><fmt:message key='Adminpage_Account'/></label>
                    <%
                        Verwijderaccount vw = new Verwijderaccount();
                        ResultSet rs = vw.getallUsers();
                    %>
                     <select  id="Email" name="Email" data-placeholder="Kies een account..." class="chosen-select" style="width:85%;" tabindex="2">
                         <option value=""></option>
                         <%
                            while (rs.next()) {
                                String getActief = "Actief";
                                if (!rs.getString("ENABLED").equals("1")) {
                                    getActief = "Non-Actief";
                                    String non = "background: #009966; color: #FFF;";
                                }
                        %>
                        <option value="<%=rs.getString("EMAIL")%>">
                            <%=rs.getString("EMAIL")%> | <%=getActief%>
                        </option>
                        <%
                            }
                        %>
                    </select>
                </div>
                    
                <div class="form-group col-md-6">
                    <button class="btn btn-lg btn-primary btn-block" type="submit" name="btnNonactief"><fmt:message key='Adminpage_button_deactiveren'/></button>
                </div>
                <div class="form-group col-md-6">
                    <button class="btn btn-lg btn-primary btn-block" type="submit" name="btnActief"><fmt:message key='Adminpage_button_activeren'/></button>
                </div>
            </form>

        </div>

        <%                 // de email
            String naam = request.getParameter("Email");

            //als iemand op de btn non actief drukt van roep je de methode
            //uit verwijder acccount aan die de status op non actief zet\
            //als het goed is dan ga je weer naar de start pagina
            //als het niet goed dan krijg en een waarschuwing
            if (request.getParameter("btnNonactief") != null) {
                Test.Verwijderaccount nonactief = new Test.Verwijderaccount(naam);
                if (nonactief.Zetstatusnonactief()) {
                    out.print("<div class=\"alert alert-success col-md-8 col-md-offset-2\">Account succesvol gedeactiveerd!</div>");
                    response.setHeader("Refresh", "1;url=Adminpage.jsp");
                } else {
                    out.print("<div class=\"alert alert-danger col-md-8 col-md-offset-2\">Er is een fout opgetreden!</div>");
                }

            }
            //als iemand op de btn actief drukt van roep je de methode
            //uit verwijderacccount aan die de status op actief zet\
            //als het goed is dan ga je weer naar de start pagina
            //als het niet goed dan krijg en een waarschuwing
            if (request.getParameter("btnActief") != null) {
                Test.Verwijderaccount actief = new Test.Verwijderaccount(naam);
                if (actief.Zetstatusactief()) {
                    out.print("<div class=\"alert alert-success col-md-8 col-md-offset-2\">Account succesvol geactiveerd!</div>");
                    response.setHeader("Refresh", "1;url=Adminpage.jsp");
                } else {
                    out.print("<div class=\"alert alert-danger col-md-8 col-md-offset-2\">Er is een fout opgetreden!</div>");
                }
            }
        %>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js" type="text/javascript"></script>
        <script src="js/chosen.jquery.js" type="text/javascript"></script>
        <script type="text/javascript">
            var config = {
                '.chosen-select': {},
                '.chosen-select-deselect': {allow_single_deselect: true},
                '.chosen-select-no-single': {disable_search_threshold: 10},
                '.chosen-select-no-results': {no_results_text: 'Oops, nothing found!'},
                '.chosen-select-width': {width: "95%"}
            }
            for (var selector in config) {
                $(selector).chosen(config[selector]);
            }
        </script>
    </body>
</html>

