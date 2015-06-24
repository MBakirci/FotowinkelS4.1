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
        <title>Registreren</title>
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
            <form id="frmRegist" class="form-signup" action="LoginController">       
                <h2 class="form-signin-heading">Please register</h2>
                <input type="email" id="Name" name="username" class="form-control" placeholder="<fmt:message key='Inlogscherm_email'/>" required autofocus>
                <input type="password" id="inputPassword" name="password" class="form-control" placeholder="<fmt:message key='Inlogscherm_Password'/>" required>
                <br/>
                <input type="text" id="inputVoornaam" name="voornaam" class="form-control" placeholder="<fmt:message key='FotograafRegister_Naam'/>" required>
                <input type="text" id="inputTussenvoegsel" name="tussenvoegsel" class="form-control" placeholder="<fmt:message key='FotograafRegister_Tussenvoegsel'/>">
                <input type="text" id="inputAchternaam" name="achternaam" class="form-control" placeholder="<fmt:message key='FotograafRegister_Achternaam'/>" required>
                <br/>
                <button class="btn btn-primary " type="submit" name="btnRegister"><fmt:message key='Registreren_registreer'/></button>
                <div id="RegisterAlert" style="display: none;" class="alert alert-danger" role="alert"><fmt:message key='Registreren_error'/></div>
                <br/>
                <p><fmt:message key='Register_to_login'/><a href="Login.jsp"><fmt:message key='Register_to_login_link'/></a></p>
            </form>
        </div>
        <div class="modal fade" id="Modal_Register" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">
                    <div class="modal-header">
                        <h3>Vul uw gegevens in</h3>
                    </div>
                    <div class="modal-body">
                    </div>
                    <div class="modal-footer" id="CustDetails">
                    </div>
                </div>
            </div>
        </div>  

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/Login.js" type="text/javascript"></script>
    </body>
</html>
