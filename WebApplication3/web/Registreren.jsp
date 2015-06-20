<%-- 
    Document   : Inlogscherm
    Created on : 11-mrt-2015, 10:56:11
    Author     : hsm
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="TaalSettings.jsp" %>
<%@include file="TaalToggle.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="CSS/LoginPage.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <header class="navbar" role="banner">
            <div class="container form-inline">
                <br/>
                <img width="300" class="img-responsive" src="Images/professional-camera-logo-for-company-vector-217607-[Converted].gif" alt=""/>
                <div class="pull-right padding-top">
                </div>              
            </div>
        </header>

        <div class="wrapper" >
            <form id="frmRegist" class="form-signin" action="LoginController">       
                <h2 class="form-signin-heading">Please register</h2>
                <input type="email" id="Name" name="username" class="form-control" placeholder="Email" required autofocus>
                <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
                <input type="text" id="inputVoornaam" name="voornaam" class="form-control" placeholder="Voornaam" required>
                <input type="text" id="inputTussenvoegsel" name="tussenvoegsel" class="form-control" placeholder="Tussenvoegsel">
                <input type="text" id="inputAchternaam" name="achternaam" class="form-control" placeholder="Achternaam" required>
                <br/>
                <button class="btn btn-primary " type="submit" name="btnRegister"><fmt:message key='Registreren_registreer'/></button>
                <div id="RegisterAlert" style="display: none;" class="alert alert-danger" role="alert"></div>
                <br/>
                <p>Al een account bij FotoWinkelS4?   <a href="Login.jsp">Nu inloggen.</a></p>
            </form>
        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/Login.js" type="text/javascript"></script>
    </body>
</html>
