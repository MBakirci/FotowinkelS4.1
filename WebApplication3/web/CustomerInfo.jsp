<%-- 
Document   : newjsp
Created on : 10-jun-2015, 9:26:56
Author     : Gebruiker
--%>

<%@page import="java.util.*"%>
<%@page import="Test.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="Masterpage_final.jsp"/>
<%@include file="TaalSettings.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            User Administration
        </title>
        <%
            User user = new User();
            Map<String, List<String>> userMap = user.getUsers("fotograaf");
        %>
    </head>
    <body>

        <div class="col-lg-10 col-lg-offset-1">
            <h1>
                <i class="fa fa-users">
                </i>
                User Administration
            </h1>
            <hr/>
            <div class="table-responsive">
                <table class="table table-bordered table-striped">
                    <thead>
                        <tr>
                            <th>
                                Email
                            </th>
                            <th>
                                Naam
                            </th>
                            <th>
                                Geactiveerd
                            </th>
                            <th>
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (Map.Entry<String, List<String>> userEntry : userMap.entrySet()) {
                        %>
                        <tr>
                            <td id="td_email"><%=userEntry.getValue().get(0)%></td>
                            <td id="td_naam">
                                <%= userEntry.getValue().get(1) + " " + userEntry.getValue().get(2) + " " + userEntry.getValue().get(3)%>
                            </td>
                            <td >
                                <%= userEntry.getValue().get(4)%>
                            </td>
                            <td>
                                <a href="" class="btn btn-info pull-left edit" style="margin-right: 3px;">
                                    Edit
                                </a>
                                <a href="" class="btn btn-info pull-left" style="margin-right: 3px;">
                                    Foto's
                                </a>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
            </div>
            <div class="modal fade" id="Modal_currUser" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        </div>
                        <div class="modal-body">
                        </div>
                    </div>
                </div>
            </div>  
            <div class="modal js-loading-bar">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-body">
                            <div class="progress progress-popup">
                                <div class="progress-bar"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--Jquery voor laadscherm en ajax response-->
        <script src="js/CustInfo.js" type="text/javascript"></script>
    </body>
</html>