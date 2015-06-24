<%-- 
    Document   : Inlogscherm
    Created on : 11-mrt-2015, 10:56:11
    Author     : hsm
--%>


<%@page import="Test.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="TaalSettings.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <%
            User user = (User) request.getSession().getAttribute("RegistUser");
        %>
        <form id="frmRegister" class="form-signup" action="LoginController"> 
            <input type="hidden" id="eMail" name="eMail" class="form-control" value="<%=user.geteMail()%>"/>
            <input type="text" id="straat" name="straat" class="form-control" placeholder="<fmt:message key='FotograafRegister_Straat'/>" required autofocus>
            <input type="text" id="huisnr" name="huisnr" class="form-control" placeholder="<fmt:message key='FotograafRegister_Huisnummer'/>" required>
            <input type="text" id="postcode" name="postcode" class="form-control" placeholder="<fmt:message key='FotograafRegister_Postcode'/>" required>
            <input type="text" id="stad" name="stad" class="form-control" placeholder="<fmt:message key='FotograafRegister_Stad'/>" required>
            <br/>
            <input type="number" id="telefoon" name="telefoon" class="form-control" placeholder="<fmt:message key='FotograafRegister_Telefoon'/>">
            <button class="btn btn-primary " type="submit" name="btnRegisterAddInfo"><fmt:message key='Registreren_registreer'/></button>
            <div id="RegisterAlert" style="display: none;" class="alert alert-danger" role="alert"><fmt:message key='Registreren_error'/></div>
            <div id="RegisterAlertSuccess" style="display: none;" class="alert alert-success" role="alert"><fmt:message key='Registreren_success'/></div>
        </form>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="js/Login.js" type="text/javascript"></script>
    </body>
</html>
