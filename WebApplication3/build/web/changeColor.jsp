<%-- 
    Document   : changeColor
    Created on : 20-mei-2015, 9:44:58
    Author     : Dennis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="Masterpage_final.jsp"/>
<%@include file="TaalSettings.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/productpage.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <form class="col-md-6">

                <div class="form-group col-md-12">
                    <div class="row">
                        <select id="Type" name="Type" class="btn btn-default" onchange="changeColor()">
                            <option value="1"><fmt:message key='changeColor_Normaal'/></option>
                            <option value="2"><fmt:message key='changeColor_ZwartWit'/></option>
                            <option value="3"><fmt:message key='changeColor_Sepia'/></option>
                        </select>
                    </div>
                </div>
            </form>
            <img id="productFoto" height="200" width="200" src="http://www.teunstuinposters.nl/site/tuinposters/83/zoom/tuinposter_oude-knoestige-boom.jpg" class="">
        </div>
    </body>
</html>
