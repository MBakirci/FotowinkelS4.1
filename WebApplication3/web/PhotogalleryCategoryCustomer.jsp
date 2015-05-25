<%-- 
    Document   : Photogallery
    Created on : 8-apr-2015, 11:33:20
    Author     : Dennis
--%>

<%@page import="java.util.HashSet"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Test.PhotoCustomer"%>

<jsp:include page="Masterpage_final.jsp"></jsp:include>
<%@include file="TaalSettings.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Fotogallerij</title>
    </head>
    <body>
        <!-- <h1>Hello World!</h1>
         <img src="ftp://asror:asror@212.64.126.219:9942/Henk@yolo.nl/Portret/Exercise1.png"/> -->

        <!--NAVIGATION-->
        <div class="container">

            <!-- Page Content -->
            <form>
                <div class="container">

                    <div class="row">

                        <div class="col-lg-12">
                            <h1 class="page-header">Gallery</h1>
                        </div>
                        <div class="col-lg-3 col-md-4 col-xs-6 thumb" style="position: relative">
                            <a class="thumbnail" href="PhotogalleryCatPhotosCustomer.jsp?cat=All">
                                <img class="img-responsive" style="position: relative; top: 0; left: 0;" alt="test" width="100" height="100" style="z-index: -1" src="http://png-3.findicons.com/files/icons/2770/ios_7_icons/100/folder.png" > 

                            </a>
                            <!--top:120px;left: 230px;-->
                            <a id="All" type="submit" href="PhotogalleryCatPhotosCustomer.jsp?cat=All" style="position: absolute; text-align:center; top:115px;">
                                <b>All</b>
                            </a>

                        </div>

                        <%
                            session.setAttribute("Name", "Dennis@dennis.nl");
                            HashSet<String> photoList = new HashSet<String>();
                            Test.PhotoCustomer tp = new Test.PhotoCustomer();
                            if (session.getAttribute("Name") != null) {
                                photoList = tp.getCategoriesCustomer("Dennis@dennis.nl"); //FOR DEBUG

                            }
                            //photoList = tp.getPhotos(session.getAttribute("Name").toString());     // FINAL get session name

                            for (String es : photoList) {

                        %>
                        <div class="col-lg-3 col-md-4 col-xs-6 thumb" style="position: relative">
                            <a class="thumbnail" href="PhotogalleryCatPhotosCustomer.jsp?cat=<%=es%>">
                                <img class="img-responsive" style="position: relative; top: 0; left: 0;" alt="test" width="100" height="100" style="z-index: -1" src="http://png-3.findicons.com/files/icons/2770/ios_7_icons/100/folder.png" > 

                            </a>
                            <!--top:120px;left: 230px;-->
                            <a id="<%=es%>" type="submit" href="PhotogalleryCatPhotosCustomer.jsp?cat=<%=es%>" style="position: absolute; text-align:center; top:115px;">
                                <b><%=es%></b>
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
                        <p>Copyright &copy; Your Website 2014</p>
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

