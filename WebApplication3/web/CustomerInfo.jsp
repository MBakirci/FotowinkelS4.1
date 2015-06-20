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
            String type = request.getParameter("ddltype");
            if (type == null) {
                type = "all";
            }
            Map<String, List<String>> userMap = user.getUsers(type);
        %>
        <script src="js/list.min.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="col-lg-10 col-lg-offset-1">
            <h1>
                <i class="fa fa-users">
                </i>
                User Administration
            </h1>
            <hr/>
            <form name="formtype" onchange="submit()">
                <div class="form-group">
                    <label for="ddltype">Kies gebruikerstype:</label>
                    <select name="ddltype" class="form-control" id="ddltype">
                        <option value="x"></option>
                        <option value="all">All</option>
                        <option value="klant">Klant</option>
                        <option value="fotograaf">Fotograaf</option>
                    </select> 
                </div>
            </form>

            <div id="payload">
                <input id="search" class="search form-control" placeholder="Search" />
                <hr/>
                <div class="table-responsive">
                    <table class="table table-bordered table-striped">
                        <thead>
                        <th>Email</th>
                        <th>Naam</th>
                        <th>Geactiveerd</th>
                        <th></th>
                        </thead>
                        <tbody class="list">
                            <%for (Map.Entry<String, List<String>> userEntry : userMap.entrySet()) {%>
                            <tr>
                                <td class="email" id="td_email"><%=userEntry.getValue().get(0)%></td>
                                <td class="name" id="td_naam"><%= userEntry.getValue().get(1) + " " + userEntry.getValue().get(2) + " " + userEntry.getValue().get(3)%></td>
                                <td class="activated"><%= userEntry.getValue().get(4)%></td>
                                <td><a href="" class="btn btn-info edit">
                                        <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
                                        Edit
                                    </a>
                                    <a href="" class="btn btn-info" style="margin-right: 3px;">
                                        <span class="glyphicon glyphicon-camera" aria-hidden="true"></span>
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
            </div>
            <div class="modal fade" id="Modal_currUser" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h3><fmt:message key='AccountInformation_H3_1'/></h3>
                        </div>
                        <div class="modal-body">
                        </div>
                        <div class="modal-footer" id="CustDetails">
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