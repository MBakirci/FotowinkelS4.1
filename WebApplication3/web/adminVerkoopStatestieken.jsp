<%-- 
    Document   : adminVerkoopStatestieken
    Created on : 17-Jun-2015, 09:46:46
    Author     : Coen
--%>
<%@page import="java.util.List"%>
<%@page import="Test.Verwijderaccount"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Date"%>
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
        <script>
            function setSelectedIndex(s, valsearch)
            {
            // Loop through all the items in drop down list
                for (i = 0; i < s.options.length; i++)
                {
                    if (s.options[i].value == valsearch)
                    {
                    // Item is found. Set its property and exit
                        s.options[i].selected = true;
                        break;
                    }
                }
                return;
            }
        </script>
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
                            <select id="maandMenu" name="maandMenu">
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
                            <% String maand;
                            if (request.getParameter("maand") == null) {
                                java.util.Date today = new Date();
                                Integer m = today.getMonth() + 1;
                                maand = m.toString();
                            } else {
                                maand = request.getParameter("maand");
                            }%>
                        <script>
                            setSelectedIndex(document.getElementById("maandMenu"), <%=maand%>);
                        </script>
                        </div>
                    </div>
                    <div class="col-xs-3">
                        <div class="container">
                            <fmt:message key="AdminOverzicht_Select_Jaar"/>
                        </div>
                        <div class="container">
                            <select id="jaarMenu" name="jaarMenu">
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
                            <% String jaar;
                            if (request.getParameter("maand") == null) {
                                Integer j = (Integer) eJaar;
                                jaar = j.toString();
                            } else {
                                jaar = request.getParameter("jaar");
                            }%>
                        <script>
                            setSelectedIndex(document.getElementById("jaarMenu"), <%=eJaar%>);
                        </script>
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
                    <div class="col-xs-3">
                    <select id="username" name="username">
                        <% List<String> fotografen = VerkoopStatestieken.getAlleFotograven();
                        for(String fotograaf : fotografen){
                        %>
                        <option value="<%=fotograaf%>"><%=fotograaf%></option>
                        <%
                        }
                        %>
                    </select>
                    <%if (request.getParameter("fotograaf") != null){
                    String huidigeFotograaf = request.getParameter("fotograaf");
                    %>
                    <script>
                        setSelectedIndex(document.getElementById("username"), "<%=huidigeFotograaf%>");
                    </script>
                    <%
                    }
                    %>
                    </div>
                    <div class="col-xs-3">
                    <button class="btn btn-default" name="fotograafmaandbtn"><fmt:message key="AdminOverzicht_Get_Fotograaf_Maand"/></button>
                    <%if (request.getParameter("fotograafmaandbtn") != null) {
                            response.sendRedirect("adminVerkoopStatestieken.jsp?maand=" + request.getParameter("maandMenu") + "&jaar=" + request.getParameter("jaarMenu") + "&fotograaf=" + request.getParameter("username"));
                        }

                    %>
                    </div>
                    <div class="col-xs-3">
                    <button class="btn btn-default" name="fotograafjaarbtn"><fmt:message key="AdminOverzicht_Get_Fotograaf_Jaar"/></button>
                    <%if (request.getParameter("fotograafjaarbtn") != null) {
                            response.sendRedirect("adminVerkoopStatestieken.jsp?jaar=" + request.getParameter("jaarMenu") + "&fotograaf=" + request.getParameter("username"));
                        }

                    %>
                    </div>
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
                Double omzet = (Double) JaarData.get("omzet");
                String strOmzet = String.format("%.2f", omzet);
                Double btw = (Double) JaarData.get("btw");
                String strBtw = String.format("%.2f", btw);
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
                    <td><%=strOmzet%></td>
                    <td><%=strBtw%></td>
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
                Double omzet = (Double) MaandData.get("omzet");
                String strOmzet = String.format("%.2f", omzet);
                Double btw = (Double) MaandData.get("btw");
                String strBtw = String.format("%.2f", btw);
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
                    <td><%=strOmzet%></td>
                    <td><%=strBtw%></td>
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