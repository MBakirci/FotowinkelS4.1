<%-- 
    Document   : Photogallery
    Created on : 8-apr-2015, 11:33:20
    Author     : Dennis
--%>

<%@page import="java.util.HashSet"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Test.Photo"%>
<jsp:include page="Masterpage_final.jsp"/>
<%@include file="TaalSettings.jsp" %>

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
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">       
            <!-- Page Content -->
            <form>
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header"><fmt:message key="PhotogalleryCat_H1"/>Gallery</h1>
                        </div>
                        <%
                            
                            //session.setAttribute("Name", "Henk@yolo.nl");
                            HashSet<String> ccatList = new HashSet<String>();
                            ArrayList<String> catList = new ArrayList<String>();
                            ArrayList<String> photoList;
                            Test.PhotoCustomer tp = new Test.PhotoCustomer();
                            Test.Photo p = new Test.Photo();
                            String parameter = request.getParameter("SelectedUser");
                            session.setAttribute("SelectedUser", parameter);
                            
                            
                            if(request.getParameter("SelectedUser") != null){
                                
                            }
                            if (session.getAttribute("SelectedUser") != null) {
                                if (p.isPhotographer(session.getAttribute("SelectedUser").toString())) {
                                    
                                    catList = p.getCategoriesPhotographer(session.getAttribute("SelectedUser").toString());
                                }//FOR DEBUG
                                else{
                                    %>
                        <div class="col-lg-3 col-md-4 col-xs-6 thumb" style="position: relative">
                            <a class="thumbnail" href="PhotogalleryCatPhotosAdmin.jsp?cat=All">
                                <img class="img-responsive" style="position: relative; top: 0; left: 0;" alt="test" width="100" height="100" style="z-index: -1" src="http://png-3.findicons.com/files/icons/2770/ios_7_icons/100/folder.png" > 
                            </a>
                            <!--top:120px;left: 230px;-->
                            <a id="All" href="PhotogalleryCatPhotosAdmin.jsp?cat=All" style="position: absolute; text-align:center; top:115px;">
                                <b>All</b>
                            </a>
                        </div>
                        <%
                                    ccatList = tp.getCategoriesCustomer(session.getAttribute("SelectedUser").toString());
                                }
                            }
                            //photoList = tp.getPhotos(session.getAttribute("Name").toString());     // FINAL get session name
                            if(ccatList.isEmpty() == false)
                            {
                                photoList = new ArrayList<String>(ccatList);
                            }
                            else
                            {
                                photoList = new ArrayList<String>(catList);
                            }
                            
                            for (String es : photoList) {

                        %>
                        <div class="col-lg-3 col-md-4 col-xs-6 thumb" style="position: relative">
                            <a class="thumbnail" href="PhotogalleryCatPhotosAdmin.jsp?cat=<%=es%>">
                                <img class="img-responsive" style="position: relative; top: 0; left: 0;" alt="test" width="100" height="100" style="z-index: -1" src="http://png-3.findicons.com/files/icons/2770/ios_7_icons/100/folder.png" > 
                            </a>
                            <!--top:120px;left: 230px;-->
                            <a id="<%=es%>" type="submit" href="PhotogalleryCatPhotosAdmin.jsp?cat=<%=es%>" style="position: absolute; text-align:center; top:115px;">
                                <%
                                    if (es.equals(session.getAttribute("SelectedUser").toString())) {%>
                                <b>All</b>
                                <% } %>
                                <% if (es.equals(session.getAttribute("SelectedUser").toString()) == false) {%>
                                <b><%=es%></b>
                                <% }%>
                            </a>
                        </div>
                        <%
                            }
                        %>
                    </div>
                </div>
            </form>
            <hr>
            <!-- Footer -->
            <footer>
                <div class="row">
                    <div class="col-lg-12">
                        <p><fmt:message key="footer2"/></p>
                    </div>
                </div>
            </footer>
        </div>
        <!-- /.container -->

        <!-- jQuery -->
        <script src="JS/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="JS/bootstrap.min.js"></script>
</body>
</html>

