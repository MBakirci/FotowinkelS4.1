<%-- 
    Document   : index
    Created on : 9-mrt-2015, 11:03:40
    Author     : Gebruiker
--%>


<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Test.NewClass" %>
<jsp:include page="Masterpage_final.jsp"/>
<%@include file="TaalSettings.jsp" %>
<%
    if (session.getAttribute("Role").equals("admin")) {
        response.sendRedirect("Adminpage.jsp");
    } else if (session.getAttribute("Role").equals("fotograaf")) {
        response.sendRedirect("Upload.jsp");
    } else if (session.getAttribute("Role").equals("klant")) {
        response.sendRedirect("PhotogalleryCategoryCustomer.jsp");
    } else if (session.getAttribute("Role") == null) {
        response.sendRedirect("Login.jsp");
    } else {
        response.sendRedirect("Login.jsp");
    }
%>