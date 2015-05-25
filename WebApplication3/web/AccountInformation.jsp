<%-- 
    Document   : AccountInformation
    Created on : 11-mrt-2015, 11:06:43
    Author     : Dennis
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<jsp:include page="Masterpage_final.jsp"></jsp:include>
<%@include file="TaalSettings.jsp" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title><fmt:message key='AccountInformation_Title'/></title>
    </head>

    <body>
        
        <div class="container">
            <h1><fmt:message key='AccountInformation_H1'/></h1>
        <hr>
        </div>
        <div class="container">
            <%
                //if no button was pressed, this is the first time loading this page
                String SessionEmail = (String) session.getAttribute("Name");
                Test.User user = new Test.User(SessionEmail);
                if(session.getAttribute("Role").equals("fotograaf"))
                {
                user.AdditionalInfo();
                }
                
                 if (request.getParameter("btnSaveEmailPass") != null) {
                     if(request.getParameter("passv").length() > 4){
                     if(request.getParameter("passv").equals(request.getParameter("pass"))){
                        out.println("<script type=\"text/javascript\">");  
                        out.println("alert('Uw wachtwoord is veranderd.');");  
                        out.println("</script>");
                      user.changePass(request.getParameter("pass"));
                     }
                     }
                 }

                //if button was pressed, save changes
                if (request.getParameter("btnSave") != null) {
                    //Get Textbox values
                    user.setVoornaam(request.getParameter("fname"));
                    user.setTussenvoegsel(request.getParameter("tname"));
                    user.setAchternaam(request.getParameter("lname"));
                    user.setStraat(request.getParameter("street"));
                    user.setHuisnr(request.getParameter("housenumber"));
                    user.setPostcode(request.getParameter("zipcode"));
                    user.setStad(request.getParameter("city"));
                    user.setTelefoon(request.getParameter("telnr"));
                    user.UpdateUser();
                }
            %>
                
            <!--Inputform-->
            <div class="row vdivide">
                <form id="info-form">
                <div class="col-md-4 col-sm-6 col-xs-12">
                    <h3><fmt:message key='AccountInformation_H3_1'/></h3>
                    <div class="text-center">
                        <img src="http://simpleicon.com/wp-content/uploads/account.png" class="avatar img-circle img-thumbnail" alt="avatar">
                    </div>
                    <div class="form-group">
                        <label for="Email"><fmt:message key='AccountInformation_email'/></label>
                        <input type="email" name="email" class="form-control" id="Email" placeholder="<%=user.geteMail()%>" readonly>
                    </div>
                    <div class="form-group">
                        <label for="Wachtwoord"><fmt:message key='AccountInformation_password'/></label>
                        <input type="password" name="pass" class="form-control" id="Wachtwoord" placeholder="Nieuw wachtwoord" >
                    </div>
                    <div class="form-group">
                        <label for="VerifyWachtwoord"><fmt:message key='AccountInformation_password_ver'/></label>
                        <input type="password" name="passv" class="form-control" id="VerifyWachtwoord" placeholder="Verifieer Nieuw Wachtwoord" oninput="check(this)" >
                    </div>
                    <script language='javascript' type='text/javascript'>
                        function check(input) {
                            var pass = document.getElementById('Wachtwoord').value;
                            if (input.value != pass ) {
                                input.setCustomValidity('De wachtwoorden moeten overeenkomen!');
                            }
                            else if(pass.length < 5){
                                input.setCustomValidity('Uw wachtwoord moet minimaal 5 karakters bevatten!');
                            }
                            else {
                                // input is valid -- reset the error message
                                input.setCustomValidity('');
                           }
                        }
                    </script>
                    <button type="submit" name="btnSaveEmailPass" class="btn btn-default"><fmt:message key='AccountInformation_Save'/></button>
                </div>
                </form>
                    
                    <form>
                <div class="col-md-8 col-sm-6 col-xs-12">
                    <h3><fmt:message key='AccountInformation_H3_2'/></h3>
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
                    <%if(session.getAttribute("Role").equals("fotograaf")){%>
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
                    
                     <%}%>
                </div>
                   <div class="col-md-6 col-sm-6 col-xs-12"> 
                    <button type="submit" name="btnSave" class="btn btn-default"><fmt:message key='AccountInformation_Save'/></button>
                    </div>
                    
            </form>
            </div>

            <!-- Site footer -->
            <footer class="footer">
                <p><fmt:message key='footer'/></p>
            </footer>
        </div>
    </body>
</html>
