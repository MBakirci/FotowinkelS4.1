

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
<jsp:include page="Masterpage_final.jsp"></jsp:include><!DOCTYPE html>
<html>
     <head>
    <title>Log in</title>
  </head>
    <body>
     
        
         <div class="container">
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
        <h2 class="form-signin-heading">Please sign in</h2>
      <label for="inputName" class="sr-only">Email address</label>
        <input type="text" id="Name" name="username" class="form-control" placeholder="Username" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
   <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
          
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>

        <button class="btn btn-lg btn-primary btn-block" type="submit" name="btnLogin">Sign in</button>
      </form>

    </div>

                     
             <%
                
               //  int id = 7;
                  String naam = request.getParameter("username");
                String pass = request.getParameter("password");
                //int id = request.getParameter("inputid".);
                
                if(request.getParameter("btnLogin")!= null){ 
                    Test.Login login = new Test.Login(naam, pass);                     
                     if(login.Verbind()){
                         String s = login.getRole();
                         out.print("Login Gelukt");
                         session.setAttribute("Name", naam);
                         session.setAttribute("Role", login.getRole());
                        response.sendRedirect("index.jsp");
                     }
                     else{
                         out.print("Login mislukt, controleer of u uw gegeven goed hebt ingevult");
                     }
                 }
               // if(request.getParameter("btnregistreer") != null)
               // {
                     
                //     Test.registreer reg = new Test.registreer(naam, pass, id);
                    
                //     if(reg.Verbind()){
                //         out.print("registreer gelukt");
                         
                //         response.sendRedirect("index.jsp");
                //     }
                //         else {
                //                 out.print("registeren mislukt");
                //                 }
                // }
                 %>
    </body>
</html>

