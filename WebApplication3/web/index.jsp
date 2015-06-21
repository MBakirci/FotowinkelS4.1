<%-- 
    Document   : index
    Created on : 9-mrt-2015, 11:03:40
    Author     : Gebruiker
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String role = (String) session.getAttribute("Role");
    if(role == null){
        role = "";
    }
    if (role.equals("admin")) {
        response.sendRedirect("Adminpage.jsp");
    } else if (role.equals("fotograaf")) {
        response.sendRedirect("Upload.jsp");
    } else if (role.equals("klant")) {
        response.sendRedirect("PhotogalleryCategoryCustomer.jsp");
    } else if(role.equals("")) {
        response.sendRedirect("Login.jsp");
    }
%>