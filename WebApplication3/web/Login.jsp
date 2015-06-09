<%-- 
    Document   : Login
    Created on : 9-jun-2015, 23:40:12
    Author     : Gebruiker
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="TaalSettings.jsp" %>
<%@include file="TaalToggle.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="CSS/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <style>
            body {
                background: url("Images/groepsfotografie-3.jpg")no-repeat center center fixed; 
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;
                background-size: cover;
            }

            .wrapper {
                margin-top: 40px;
                margin-bottom: 20px;
            }

            .form-signin {
                max-width: 380px;
                padding: 15px 35px 45px;
                margin: 0 auto;
                background-color: #fff;
                border: 1px solid rgba(0, 0, 0, 0.1);
            }
            .form-signin .form-signin-heading,
            .form-signin .checkbox {
                margin-bottom: 30px;
            }
            .form-signin .checkbox {
                font-weight: normal;
            }
            .form-signin .form-control {
                position: relative;
                font-size: 16px;
                height: auto;
                padding: 10px;
                -webkit-box-sizing: border-box;
                -moz-box-sizing: border-box;
                box-sizing: border-box;
            }
            .form-signin .form-control:focus {
                z-index: 2;
            }
            .form-signin input[type="text"] {
                margin-bottom: -1px;
                border-bottom-left-radius: 0;
                border-bottom-right-radius: 0;
            }
            .form-signin input[type="password"] {
                margin-bottom: 20px;
                border-top-left-radius: 0;
                border-top-right-radius: 0;
            }
        </style>
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
            <form class="form-signin" method="post">       
                <h2 class="form-signin-heading">Please login</h2>
                <input type="text" class="form-control" name="username" placeholder="Email Address" required="" autofocus="" />
                <input type="password" class="form-control" name="password" placeholder="Password" required=""/>      
                <label class="checkbox">
                    <input type="checkbox" value="remember-me" id="rememberMe" name="rememberMe"> Remember me
                </label>
                <button class="btn btn-lg btn-primary btn-block" type="submit" name="btnLogin">Login</button>   
                <br/>
                <br/>
                <p>Nieuw bij FotoWinkelS4?   <a href="Registreren.jsp">Nu registreren.</a></p>
            </form>
            <%

                //  int id = 7;
                String naam = request.getParameter("username");
                String pass = request.getParameter("password");
                //int id = request.getParameter("inputid".);

                if (request.getParameter("btnLogin") != null) {
                    Test.Login login = new Test.Login(naam, pass);
                    if (login.Verbind()) {
                        String s = login.getRole();
                        out.print("Login Gelukt");
                        session.setAttribute("Name", naam);
                        session.setAttribute("Role", login.getRole());
                        response.sendRedirect("index.jsp");
                    } else {
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
        </div>
    </body>
</html>
