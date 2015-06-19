<%-- 
    Document   : CustomerInfoDetails
    Created on : 18-jun-2015, 10:22:51
    Author     : Gebruiker
--%>

<%@page import="Test.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="TaalSettings.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <%
            User user = (User) request.getSession().getAttribute("CurrentUser");
        %>

        <div>
            <form>
                <div class="col-md-6">
                    <div class="form-group col-md-12 col-sm-12 col-xs-12">
                        <label for="Voornaam"><fmt:message key='AccountInformation_firstname'/></label>
                        <input type="text" name="fname" class="form-control" id="Voornaam" value="<%=user.getVoornaam()%>" required>
                    </div>
                    <div class="form-group col-md-6 col-sm-6 col-xs-12">
                        <label for="Tussenvoegsel"><fmt:message key='AccountInformation_Tussenvoegsel'/></label>
                        <input type="text" name="tname" class="form-control" id="Tussenvoegsel" value="<%=user.getTussenvoegsel()%> " >
                    </div>
                    <div class="form-group col-md-6 col-sm-6 col-xs-12">
                        <label for="Achternaam"><fmt:message key='AccountInformation_Lastname'/></label>
                        <input type="text" name="lname" class="form-control" id="Achternaam" value="<%=user.getAchternaam()%> " required >
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group col-md-6 col-sm-6 col-xs-12">
                        <label for="Straat"><fmt:message key='AccountInformation_Street'/></label>
                        <input type="text" name="street" class="form-control" id="Straat" value="<%=user.getStraat()%> " >
                    </div>
                    <div class="form-group col-md-6 col-sm-6 col-xs-12">
                        <label for="Huisnr"><fmt:message key='AccountInformation_Housenumber'/></label>
                        <input type="text" name="housenumber" class="form-control" id="Huisnr" value="<%=user.getHuisnr()%> " >
                    </div>
                    <div class="form-group col-md-6 col-sm-6 col-xs-12">
                        <label for="Postcode"><fmt:message key='AccountInformation_Zipcode'/></label>
                        <input type="text" name="zipcode" class="form-control" id="Postcode" value="<%=user.getPostcode()%>" >
                    </div>
                    <div class="form-group col-md-6 col-sm-6 col-xs-12">
                        <label for="Stad"><fmt:message key='AccountInformation_City'/></label>
                        <input type="text" name="city" class="form-control" id="Stad" value="<%=user.getStad()%> ">
                    </div>

                    <div class="form-group col-md-12 col-sm-12 col-xs-12">
                        <label for="Telefoon"><fmt:message key='AccountInformation_Telefoonnummer'/></label>
                        <input type="tel" name="telnr" class="form-control bfh-phone" id="Telefoon" value="<%=user.getTelefoon()%>"  data-format="+31 (ddd) dddddd" required>
                    </div>

                    <div class="col-md-6 col-sm-6 col-xs-12"> 
                        <button type="button" name="btnSave" id="btnSave" class="btn btn-default"><fmt:message key='AccountInformation_Save'/></button>
                    </div>
                </div>
            </form>
        </div>
                    
        <script src="js/CustInfo.js" type="text/javascript"></script>
    </body>
</html>
