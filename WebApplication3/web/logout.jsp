<%-- 
    Document   : logout
    Created on : 14-mrt-2015, 16:01:27
    Author     : Gebruiker
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="TaalSettings.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        session.removeAttribute("Name");
        session.invalidate();
        response.sendRedirect("Login.jsp");
        %>
</html>
