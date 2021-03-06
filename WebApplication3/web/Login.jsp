<%-- 
    Document   : Login
    Created on : 9-jun-2015, 23:40:12
    Author     : Gebruiker
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
        <title><fmt:message key='Inlogscherm_Title'/></title>
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
            <form id="frmLogin" class="form-signin" action="LoginController">       
                <h2 class="form-signin-heading"><fmt:message key='Inlogscherm_H2'/></h2>
                <input type="text" class="form-control" id="Email" name="username" placeholder="<fmt:message key='Inlogscherm_email'/>" required="" autofocus="" />
                <input type="password" class="form-control" id="Password" name="password" placeholder="<fmt:message key='Inlogscherm_Password'/>" required=""/>      
                <label for="rememberMe" class="checkbox"></label>
                <input type="checkbox" value="remember-me" id="rememberMe" name="rememberMe"><fmt:message key='Inlogscherm_Remember'/>
                <br/>
                <br/>
                <button type="submit" name="btnLogin" id="btnLogin" class="btn btn-primary">Login</button>
                <div id="loginAlert" style="display: none;" class="alert alert-danger" role="alert"><fmt:message key='Login_error'/></div>
                <br/>
                <br/>
                <p><fmt:message key='Login_to_register'/><a href="Registreren.jsp"><fmt:message key='Login_to_register_link'/></a></p>
            </form>
            <%                int b = 0;
                Integer count = new Integer(0);

                try {

                    String url = "jdbc:oracle:thin:@212.64.126.219:1994:xe";
                    String driver = "oracle.jdbc.OracleDriver";
                    String userName = "proftaak";
                    String password = "Mehmet001";

                    Class.forName(driver);
                    Connection conn = DriverManager.getConnection(url, userName, password);

                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery("select AANTAL from FW_BEZOEKERS");
                    while (rs.next()) {
                        count = rs.getInt("AANTAL");
                    }
                    if (session.isNew()) {

                        //   st.executeUpdate("insert into aantal values (" + count + ") ");
                        Integer oldcount = (Integer) session.getAttribute("count");
                        if (oldcount != null) {

                            count = new Integer(oldcount.intValue() - 1);
                        }

                        session.setAttribute("count", count);

                        count = count + 1;
                        st.executeUpdate("update FW_BEZOEKERS set AANTAL=" + count + " ");
                        ResultSet rs1 = st.executeQuery("select AANTAL from FW_BEZOEKERS");
                        while (rs1.next()) {
                            b = rs1.getInt("AANTAL");
                            //  out.println(a);
                        }

                    } else {

                        b = 0;

                    }
                } //}
                catch (Exception e) {

                }

            %>
            
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/Login.js" type="text/javascript"></script>
    </body>
</html>
