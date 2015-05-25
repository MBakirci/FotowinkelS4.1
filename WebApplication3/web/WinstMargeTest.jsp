<%-- 
    Document   : WinstMargeTest
    Created on : 25-mei-2015, 13:28:54
    Author     : Coen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Test.User"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% User u = new User("Henk@yolo.nl"); %>
        <% u.geteMail(); %>
        <% u.GetProfitMargin();%>
        <button type="submit" on-click = <% u.SetProfitMargin(25); %>>Submit</button>
        </form>
    </body>
</html>
