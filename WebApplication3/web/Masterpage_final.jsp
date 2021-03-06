<%-- 
    Document   : Masterpage
    Created on : 16-mei-2015, 10:56:24
    Author     : Dennis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="TaalSettings.jsp" %>
<%@include file="TaalToggle.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- Bootstrap Core CSS -->
        <link href="CSS/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="CSS/thumbnail-gallery.css" rel="stylesheet">

        <link href="CSS/justified-nav.css" rel="stylesheet">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- <title>JSP Page</title> -->
    </head>
    <body>
        <div class="container">

            <div class="masthead">
                <h3 class="text-muted"><img class="img-responsive" width="300" src="Images/professional-camera-logo-for-company-vector-217607-[Converted].gif" alt=""/></h3>
                    <%if (session.getAttribute("Name") != null && session.getAttribute("Role").equals("admin")) {%>
                <div class="row"><p class="col-md-3 col-md-offset-9" align="right">Ingelogd als <font color="green">admin</font></p></div>
                <nav class="navbar navbar-default">
                    <ul class="nav navbar-nav">
                        <li><a href="index.jsp"><fmt:message key="Menu_index"/></a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"><fmt:message key="MasterPage_Administrator"/><span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="FotograafRegister.jsp"><fmt:message key="Menu_FotograafRegister"/></a></li>
                                <li><a href="Adminpage.jsp"><fmt:message key="Menu_Activatie"/></a></li>
                                <li><a href="Price.jsp"><fmt:message key="Menu_Price"/></a><li>
                                <li><a href="adminVerkoopStatestieken.jsp"><fmt:message key="Menu_VerkoopStat"/></a></li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="logout.jsp"><fmt:message key="Menu_Logout"/></a></li>
                        <li><a></a></li>
                    </ul>
                </nav>
                <%
                    }
                    if (session.getAttribute("Name") != null && session.getAttribute("Role").equals("fotograaf")) {%>
                <div class="row"><p class="col-md-3 col-md-offset-9" align="right">Ingelogd als <font color="green">fotograaf</font></p></div>
                <nav class="navbar navbar-default">
                    <ul class="nav navbar-nav">
                        <li><a href="index.jsp"><fmt:message key="Menu_index"/></a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"><fmt:message key="MasterPage_profiel"/><span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="AccountInformation.jsp"><fmt:message key="Menu_AccountInformation"/></a></li>
                                <li><a href="PhotogalleryCategory.jsp"><fmt:message key="Menu_Photogallery"/></a></li>
                                <li><a href="FotograafVerkoopStatestieken.jsp"><fmt:message key="Menu_VerkoopStat"/></a></li>
                            </ul>
                        </li>
                        <li><a href="Upload.jsp"><fmt:message key="Menu_Upload"/></a></li>                        
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <%  Test.WinkelWagen winkelwagen = new Test.WinkelWagen();%>
                        <li><a href="Winkelwagen.jsp"><span class="glyphicon glyphicon-shopping-cart"></span> <fmt:message key="MasterPage_Item"/> : <%= winkelwagen.AantalItems()%></a></li>
                        <li><a href="logout.jsp"><fmt:message key="Menu_Logout"/></a></li>
                        <li><a></a></li>
                    </ul>
                </nav>


                <%
                    }
                    if (session.getAttribute("Name") != null && session.getAttribute("Role").equals("klant")) {
                %>
                <div class="row"><p class="col-md-3 col-md-offset-9" align="right">Ingelogd als <font color="green">klant</font></p></div>
                <nav class="navbar navbar-default">
                    <ul class="nav navbar-nav">
                        <li><a href="index.jsp"><fmt:message key="Menu_index"/></a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"><fmt:message key="MasterPage_profiel"/><span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="AccountInformation.jsp"><fmt:message key="Menu_AccountInformation"/></a></li>
                                <li><a href="CustomerOrders.jsp">Mijn Bestellingen</a></li>
                            </ul>
                        </li>
                        <li><a href="PhotogalleryCategoryCustomer.jsp"><fmt:message key="Menu_Photogallery"/></a></li>
                        <li><a href="klantcodepagina_1.jsp"><fmt:message key="Menu_Klantcodepagina"/></a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <%  Test.WinkelWagen winkelwagen = new Test.WinkelWagen();%>
                        <li><a href="Winkelwagen.jsp"><span class="glyphicon glyphicon-shopping-cart"></span> <fmt:message key="MasterPage_Item"/> : <%= winkelwagen.AantalItems()%></a></li>
                        <li><a href="logout.jsp"><fmt:message key="Menu_Logout"/></a></li>
                        <li><a></a></li>
                    </ul>
                </nav>
                <%
                    }
                    if (session.getAttribute("Name") == null) {
                %>
                <nav class="navbar navbar-default">
                    <ul class="nav navbar-nav">
                        <li><a href="index.jsp"><fmt:message key='Menu_index'/></a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="Registreren.jsp"><fmt:message key='Menu_Registreren'/></a></li>
                        <li><a href="Inlogscherm.jsp"><fmt:message key='Menu_Inlogscherm'/></a></li>
                        <li><a></a></li>
                    </ul>
                </nav>
                <%
                    }%>
            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>

    </body>
</html>
