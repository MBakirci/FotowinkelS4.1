        <%@page import="Test.StaticValues"%>
<%-- 
    Document   : testVerkoopstat
    Created on : 10-Jun-2015, 14:14:59
    Author     : Coen
--%>

<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Test.VerkoopStatestieken"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%Calendar cal = Calendar.getInstance();
        cal.set(2015, 6, 20);
        VerkoopStatestieken.MaandVerkoop(cal);
        VerkoopStatestieken.JaarVerkoop(cal);
        VerkoopStatestieken.FotograafMaandVerkoop(cal, "Henk@yolo.nl");
        VerkoopStatestieken.FotograafJaarVerkoop(cal, "Henk@yolo.nl");
        %>
        <h1>Hello World!</h1>
    </body>
</html>
