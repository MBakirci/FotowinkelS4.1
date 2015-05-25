

<%-- 
    Document   : Inlogscherm
    Created on : 11-mrt-2015, 10:56:11
    Author     : hsm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "java.util.*"%>

<jsp:include page="Masterpage_final.jsp"/>
<%@include file="TaalSettings.jsp" %>

<%--<%@page import= "Test.Databaseconnector"%>--%>
<%@page import="Test.Login" %>
<%@page import="java.sql.*"%>
<%@page import= "Test.Databaseconnector"%>
<%@page import = "Test.registreer"%>
<%@page import = "Test.Verwijderaccount"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registreren</title>
</head>

<body>

    <div class="container">
        <h1>Registeer </h1>
        <hr>
    </div>
    <div class="container">
        <div class="row">
            <form class="form-signin" method="post">

                <div class="col-md-6 col-md-offset-3 col-sm-6 col-xs-12">
                    <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Required Field</strong>
                    </div>
                    <div class="form-group col-md-12">
                        <label for="username">Email address</label>
                        <div class="input-group col-md-12">
                            <input type="email" id="Name" name="username" class="form-control" placeholder="Email" required autofocus>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        </div>
                    </div>
                    <div class="form-group col-md-12">
                        <label for="password">Wachtwoord</label>
                        <div class="input-group col-md-12">
                            <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        </div>
                    </div>

                    <div class="form-group col-md-12">
                        <label for="voornaam">Voornaam</label>
                        <div class="input-group col-md-12">
                            <input type="text" id="inputVoornaam" name="voornaam" class="form-control" placeholder="Voornaam" required>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        </div>
                    </div>

                    <div class="form-group col-md-4">
                        <label for="tussenvoegsel">Tussenvoegsel</label>
                        <div class="input-group col-md-12">
                            <input type="text" id="inputTussenvoegsel" name="tussenvoegsel" class="form-control" placeholder="Tussenvoegsel">
                        </div>
                    </div>

                    <div class="form-group col-md-8">
                        <label for="achternaam">Achternaam</label>
                        <div class="input-group col-md-12">
                            <input type="text" id="inputAchternaam" name="achternaam" class="form-control" placeholder="Achternaam" required>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        </div>
                    </div>

                    <div class="col-md-12">
                        <br/>
                        <button class="btn btn-lg btn-primary " type="submit" name="btnregistreer">registreer</button>
                    </div>
            </form>
                        <%
                            //  int id = 1;
                            String naam = request.getParameter("username");
                            String pass = request.getParameter("password");
                            String voornaam = request.getParameter("voornaam");
                            String tussenvoegsel = request.getParameter("tussenvoegsel");
                            String achternaam = request.getParameter("achternaam");
                            int actief = 1;
                            String error = "";
                            if (request.getParameter("btnregistreer") != null) {
                                Test.registreer reg = new Test.registreer(naam, pass, voornaam, tussenvoegsel, achternaam, actief);

                                if (!reg.Verbind()) {
                                    error = "registeren is mislukt uw email adres is al bekend bij ons";
                                    //response.addHeader("labelmislukt", "inloggen is mislukt");
                                } //response.sendRedirect("Inlogscherm.jsp");}
                                else {
                                    Test.Login login = new Test.Login(naam, pass);
                                    if (login.Verbind()) {
                                     session.setAttribute("Name", naam);
                                     session.setAttribute("Role", login.getRole());
                                     response.sendRedirect("klantcodepagina_1.jsp");
                            }
                                }

                            }

                        %>
                        <font color="red"><%=error%></font>

            </div>
        </div>
        <footer class="footer">
            <p>&copy; Company 2014</p>
        </footer>
    </div>

</body>

</html>

