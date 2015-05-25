

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
<%@include file="TaalSettings.jsp" %>

<!DOCTYPE html>
<html>
     <head>
         
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">

    <title><fmt:message key='AccountDeactiveren_Title'/></title>

    <!-- Bootstrap core CSS -->
    <link href="CSS/bootstrap.min.css" rel="stylesheet" type="text/css"/>

    <!-- Custom styles for this template -->
    <link href="CSS/justified-nav.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
    <body>
     
        
         <div class="container">

            <div class="masthead">
                <h3 class="text-muted">Project name</h3>
                <nav>
                    <ul class="nav nav-justified">
                        <li class="active"><a href="index.jsp"><fmt:message key='Menu_index'/></a></li>
                        <li><a href="Adminpage.jsp"><fmt:message key='Menu_Adminpage'/></a></li>
                        <li><a href="fotograafProfiel.jsp"><fmt:message key='Menu_fotograafProfiel'/></a></li>
                        <li><a href="Registreren.jsp"><fmt:message key='Menu_Registreren'/></a></li>
                        <li><a href="Inlogscherm.jsp"><fmt:message key='Menu_Inlogscherm'/></a></li>
                        <li><a href="logout.jsp"><fmt:message key='Menu_Logout'/></a></li>
                        <li><a href="Upload.jsp"><fmt:message key='Menu_Upload'/></a></li>
                    </ul>
                </nav>
            </div>
             
<!--             <form id="loginform" autocomplete="on" method="POST">
         <div class="input-group">
  <span class="input-group-addon">username</span>
  <input type="text" class="form-control" id="username" required="required" name="username" placeholder="Username" aria-describedby="basic-addon1">
</div>    

                    <div class="input-group">
  <span class="input-group-addon" id="basic-addon1">password</span>
  <input type="password"  name="password" class="form-control" required="required" placeholder="Wachtwoord" aria-describedby="basic-addon1">
</div>   
<<<<<<< HEAD
                 
                 <input  type="submit" value="Sign in" name="btnLogin" id="testen1" class="btn btn-default navbar-btn" >                
             </form>  -->

   <div class="container">

       <form class="form-signin" method="post">
        <h2 class="form-signin-heading"><fmt:message key='AccountDeactiveren_h2'/></h2>
        <label for="inputName" class="sr-only"><fmt:message key='AccountDeactiveren_label'/></label>
        <input type="email" id="Name" name="Email" class="form-control" placeholder="Email" required autofocus>
        
       
        <button class="btn btn-lg btn-primary btn-block" type="submit" name="btnNonactief"><fmt:message key='AccountDeactiveren_button_deactiveren'/></button>
         <button class="btn btn-lg btn-primary btn-block" type="submit" name="btnActief"><fmt:message key='AccountDeactiveren_button_activeren'/></button>
         
      </form>

    </div>

                     
             <%
               // de email
                String naam = request.getParameter("Email");
                
              
                //als iemand op de btn non actief drukt van roep je de methode
                //uit verwijder acccount aan die de status op non actief zet\
                //als het goed is dan ga je weer naar de start pagina
                //als het niet goed dan krijg en een waarschuwing
                 if(request.getParameter("btnNonactief")!= null){
                     Test.Verwijderaccount nonactief = new Test.Verwijderaccount(naam);
                     if(nonactief.Zetstatusnonactief()){
                         out.print("Account op non-actief zetten gelukt");
                         
                         response.sendRedirect("index.jsp");
                     }
                     else{
                         out.print("niet op non-actief , controleer of u een goede email heeft ingevult");
                     }
                 
                 }
                //als iemand op de btn actief drukt van roep je de methode
                //uit verwijderacccount aan die de status op actief zet\
                //als het goed is dan ga je weer naar de start pagina
                //als het niet goed dan krijg en een waarschuwing
                     if(request.getParameter("btnActief")!= null){
                     Test.Verwijderaccount actief = new Test.Verwijderaccount(naam);
                     if(actief.Zetstatusactief()){
                         out.print("Account is nu weer actief");
                        
                         response.sendRedirect("index.jsp");
                     }
                     else{
                         out.print("account is niet actief, controleer of u het goede email adres heeft ingevult");
                     }
                 }
                     
           
                 %>
    </body>
</html>

