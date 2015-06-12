<%-- 
    Document   : Photogallery
    Created on : 8-apr-2015, 11:33:20
    Author     : Dennis
--%>

<%@page import="java.net.URL"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Test.Photo"%>
<jsp:include page="Masterpage_final.jsp"></jsp:include>
<%@include file="TaalSettings.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <title><fmt:message key='Photogallery_Title'/></title>
    </head>
    <body>
        <!-- <h1>Hello World!</h1>
         <img src="ftp://asror:asror@212.64.126.219:9942/Henk@yolo.nl/Portret/Exercise1.png"/> -->

        <!-- Page Content -->
        <form action="loadPhotos">
            <div class="container">

                <div class="row">
                    <% String cat = request.getParameter("cat").toString();%>
                    <div class="col-lg-12">
                        <h1 class="page-header"><a href="PhotogalleryCategory.jsp" style="color: #000"><fmt:message key='Photogallery_Gallery'/></a> / <%=cat%></h1>
                    </div>

                    <%
                        String category = request.getParameter("cat").toString();
                        String username = session.getAttribute("SelectedUser").toString();

                        if (category.equals(username) || category.equals("All")) {

                            ArrayList<String> photoList = new ArrayList<String>();
                            Test.Photo tp = new Test.Photo();
                            Test.PhotoCustomer p = new Test.PhotoCustomer();
                            String selUser = session.getAttribute("SelectedUser").toString();
                            if (session.getAttribute("SelectedUser") != null) {
                                if (tp.isPhotographer(selUser)) {
                                    photoList = tp.getPhotos(selUser); //FOR DEBUG
                                } else {
                                    photoList = p.getAllPhotosCustomer(selUser);
                                }
                            }

                            for (String es : photoList) {

                    %>
                    <div class="col-lg-3 col-md-4 col-xs-6 thumb" style="position: relative">
                        <a class="thumbnail" href=<%=es%>>
                            <img id="<%=es.substring(es.lastIndexOf("/") + 1, es.lastIndexOf("."))%>" class="img-responsive" style="position: relative; top: 0; left: 0;" alt="test" width="100" height="100" style="z-index: -1" src=<%=es%> > 

                        </a>
                        <b style="position: absolute; text-align:center; top:115px;"><%=es.substring(es.lastIndexOf("/") + 1, es.lastIndexOf("."))%></b>
                    </div>

                    <%

                        }
                    } else if (category != null) {
                        //Query for getting photos in a specific category
                        ArrayList<String> photoList = new ArrayList<String>();
                        Test.Photo tp = new Test.Photo();
                        Test.PhotoCustomer p = new Test.PhotoCustomer();
                        String selUser = session.getAttribute("SelectedUser").toString();
                        

                        if (tp.isPhotographer(selUser)) {
                            photoList = tp.getPhotosCategory(category);
                        }
                        else
                        {
                            photoList = p.getCatPhotosCustomer(selUser, category);
                        }

                        for (String es : photoList) {%>
                    <div class="col-lg-3 col-md-4 col-xs-6 thumb" style="position: relative">
                        <a class="thumbnail" href=<%=es%>>
                            <img id="<%=es.substring(es.lastIndexOf("/") + 1, es.lastIndexOf("."))%>" class="img-responsive" style="position: relative; top: 0; left: 0;" alt="test" width="100" height="100" style="z-index: -1" src=<%=es%> > 

                        </a>
                        <b style="position: absolute; text-align:center; top:115px;"><%=es.substring(es.lastIndexOf("/") + 1, es.lastIndexOf("."))%></b>

                    </div>
                    <%
                            }
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
                    <p><fmt:message key='footer2'/></p>
                </div>
            </div>
        </footer>

    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="JS/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="JS/bootstrap.min.js"></script>
</div>
</body>
</html>

