<%-- 
    Document   : adminVerkoopStatestieken
    Created on : 17-Jun-2015, 09:46:46
    Author     : Coen
--%>
<jsp:include page="Masterpage_final.jsp"/>
<%@include file="TaalSettings.jsp" %>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="Test.VerkoopStatestieken"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>adminVerkoopStatestieken</title>
    </head>
    <body>
        <%
            if (session.getAttribute("Role").equals("admin")) {
        %>
        <div class="container">
            <form>
                <div class="row">
                    <div class="col-xs-3">
                        <div class="container"> 
                            <fmt:message key="AdminOverzicht_Select_Maand"/>
                        </div>
                        <div class="container">
                            <select name="maandMenu">
                                <option value="1"><fmt:message key="Januari"/></option>
                                <option value="2"><fmt:message key="Februari"/></option>
                                <option value="3"><fmt:message key="Maart"/></option>
                                <option value="4"><fmt:message key="April"/></option>
                                <option value="5"><fmt:message key="Mei"/></option>
                                <option value="6"><fmt:message key="Juni"/></option>
                                <option value="7"><fmt:message key="Juli"/></option>
                                <option value="8"><fmt:message key="Augustus"/></option>
                                <option value="9"><fmt:message key="September"/></option>
                                <option value="10"><fmt:message key="Oktober"/></option>
                                <option value="11"><fmt:message key="November"/></option>
                                <option value="12"><fmt:message key="December"/></option>
                            </select>
                        </div>
                    </div>
                    <div class="col-xs-3">
                        <div class="container">
                            <fmt:message key="AdminOverzicht_Select_Jaar"/>
                        </div>
                        <div class="container">
                            <select name="jaarMenu">
                                <%
                                    int iJaar = 2000;
                                    java.util.Date today = new java.util.Date();
                                    int eJaar = 1900 + today.getYear();
                                    while (iJaar <= eJaar) {
                                %>
                                <option value="<%=iJaar%>"><%=iJaar%></option>
                                <%
                                        iJaar = iJaar + 1;
                                    }
                                %>
                            </select>
                        </div>
                    </div>
                    <div class="col-xs-3">
                        <button class="btn btn-default" name="maandbtn"><fmt:message key="AdminOverzicht_Get_Maand"/></button>
                        <%
                            if (request.getParameter("maandbtn") != null) {
                                response.sendRedirect("adminVerkoopStatestieken.jsp?maand=" + request.getParameter("maandMenu") + "&jaar=" + request.getParameter("jaarMenu"));
                            }

                        %>

                        <button class="btn btn-default" name="jaarbtn"><fmt:message key="AdminOverzicht_Get_Jaar"/></button>
                        <%if (request.getParameter("jaarbtn") != null) {
                                response.sendRedirect("adminVerkoopStatestieken.jsp?jaar=" + request.getParameter("jaarMenu"));
                            }

                        %>
                    </div>
                </div>
                <div class="row">
                    <input type="text" id="username" name="username" class="form-control" placeholder="fotograaf">
                    <button class="btn btn-default" name="fotograafmaandbtn"><fmt:message key="AdminOverzicht_Get_Fotograaf_Maand"/></button>
                    <%if (request.getParameter("fotograafmaandbtn") != null) {
                            response.sendRedirect("adminVerkoopStatestieken.jsp?maand=" + request.getParameter("maandMenu") + "&jaar=" + request.getParameter("jaarMenu") + "&fotograaf=" + request.getParameter("username"));
                        }

                    %>
                    <button class="btn btn-default" name="fotograafjaarbtn"><fmt:message key="AdminOverzicht_Get_Fotograaf_Jaar"/></button>
                    <%if (request.getParameter("fotograafjaarbtn") != null) {
                            response.sendRedirect("adminVerkoopStatestieken.jsp?jaar=" + request.getParameter("jaarMenu") + "&fotograaf=" + request.getParameter("username"));
                        }

                    %>
                </div>
            </form>
        </div>
        <%if (request.getParameter("maand") == null && request.getParameter("jaar") != null) {%>
        <div class="container">
            <% Calendar cal = new GregorianCalendar();
                cal.set(Integer.parseInt(request.getParameter("jaar")), 1, 1);
                HashMap<String, Object> JaarData = new HashMap<String, Object>();
                if (request.getParameter("fotograaf") != null) {
                    String fotegraaf = request.getParameter("fotograaf").toString();
                    JaarData = VerkoopStatestieken.FotograafJaarVerkoop(cal, fotegraaf);
                } else {
                    JaarData = VerkoopStatestieken.JaarVerkoop(cal);
                }
            %>
            <h3><fmt:message key="AdminOverzicht_Jaar"/><%=request.getParameter("jaar")%>
                <%if (request.getParameter("fotograaf") != null) {%>
                - <%=request.getParameter("fotograaf").toString()%>
                <%}%>
            </h3>
            <table class="table">
                <tr>
                    <td><b><fmt:message key="AdminOverzicht_TotaalVerkoop"/></b></td>
                    <td><b><fmt:message key="AdminOverzicht_Omzet"/></b></td>
                    <td><b><fmt:message key="AdminOverzicht_BTW"/></b></td>
                </tr>
                <tr>
                    <td><%=JaarData.get("items")%></td>
                    <td><%=JaarData.get("omzet")%></td>
                    <td><%=JaarData.get("btw")%></td>
                </tr>
            </table>
        </div>
        <%
        } else if (request.getParameter("maand") != null && request.getParameter("jaar") != null) {%>
        <div class="container">
            <%
                Calendar cal = new GregorianCalendar();
                cal.set(Integer.parseInt(request.getParameter("jaar")), Integer.parseInt(request.getParameter("maand")), 1);
                HashMap<String, Object> MaandData = new HashMap<String, Object>();
                if (request.getParameter("fotograaf") != null) {
                    String fotegraaf = request.getParameter("fotograaf").toString();
                    MaandData = VerkoopStatestieken.FotograafMaandVerkoop(cal, fotegraaf);
                } else {
                    MaandData = VerkoopStatestieken.MaandVerkoop(cal);
                }
            %>
            <h3><fmt:message key="AdminOverzicht_Maand"/><%=request.getParameter("maand")%> - <%=request.getParameter("jaar")%>
                <%if (request.getParameter("fotograaf") != null) {%>
                - <%=request.getParameter("fotograaf").toString()%>
                <%}%></h3>
            <table class="table">
                <tr>
                    <td><b><fmt:message key="AdminOverzicht_TotaalVerkoop"/></b></td>
                    <td><b><fmt:message key="AdminOverzicht_Omzet"/></b></td>
                    <td><b><fmt:message key="AdminOverzicht_BTW"/></b></td>
                </tr>
                <tr>
                    <td><%=MaandData.get("items")%></td>
                    <td><%=MaandData.get("omzet")%></td>
                    <td><%=MaandData.get("btw")%></td>
                </tr>
            </table>
        </div>
        <%
            }
        } else {
        %>
        <fmt:message key="NoPermsision"/>
        <%
            }
        %>
    </body>
</html>