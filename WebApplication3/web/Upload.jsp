<%-- 
    Document   : Upload
    Created on : 18-mrt-2015, 14:15:34
    Author     : asror
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.commons.net.ftp.FTPClient"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.net.URLConnection"%>
<%@page import="java.net.URL"%>
<%@page import ="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Test.FTPUpload" %>
<%@page import="Test.Categorieën" %>
<%@page import="Test.Databaseconnecter" %>
<%@page import="Test.Categorie" %>
<!DOCTYPE html>
<jsp:include page="Masterpage_final.jsp"></jsp:include>
<%@include file="TaalSettings.jsp" %>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>
        <% Test.FTPUpload ftpload = new Test.FTPUpload(); %>
        <% Test.Categorie categorie = new Test.Categorie(); %>
        <% Test.Categorieën categorieën = new Test.Categorieën(); %>
        <% Test.Databaseconnecter dbconnect = new Test.Databaseconnecter(); %>

        <title><fmt:message key="Upload_Title"/></title>

        <!-- Bootstrap core CSS -->
        <link href="CSS/bootstrap.min.css" rel="stylesheet" type="text/css"/>

        <!-- Custom styles for this template -->
        <link href="CSS/justified-nav.css" rel="stylesheet">

        <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
        <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
        <script src="js/ie-emulation-modes-warning.js"></script>
        <link href="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
        <script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
        <link href="CSS/newcss.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/fileinput.css" rel="stylesheet" type="text/css"/>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="js/fileinput.min.js" type="text/javascript"></script>
        <script src="js/fileinput_locale_nl.js" type="text/javascript"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js" type="text/javascript"></script>

    </head>
    <body>
        <% ArrayList<String> files = new ArrayList<String>();
            if (request.getAttribute("fileslist") != null) {
                files = (ArrayList<String>) request.getAttribute("fileslist");
            }
        %>

        <% String progress = "";
            if (request.getAttribute("bla") != null) {
                progress = (String) request.getAttribute("bla");
            }
        %>


        <%
            if (request.getParameter("cat") != null) {
                if (session.getAttribute("Name") != null) {
                    String user = session.getAttribute("Name").toString();
                    Test.StaticValues.setMyStaticMember(request.getParameter("cat"), user);
                }
            } %>



        <div class="container">


            <h2><fmt:message key="Upload_H2"/></h2>
            <hr>
            <div>
                <ul class='nav nav-wizard'>
                    <%
                        if (request.getParameter("cat") != null && request.getAttribute("bla") == null) {
                    %>
                    <li><a href='#step1' data-toggle="tab" class="not-active">Select folder</a></li>
                    <li  class='active'><a href='#step2' data-toggle="tab" class="not-active">Upload images</a></li>
                    <li><a href='#step3' data-toggle="tab" class="not-active">Preview</a></li>

                </ul>

                <div id="myTabContent" class="tab-content">
                    <div class="tab-pane fade" id="step1">
                        <%
                        } else if (request.getParameter("cat") == null && request.getAttribute("bla") == null) {
                        %>
                        <li  class='active'><a href='#step1' data-toggle="tab" class="not-active"><fmt:message key="Upload_Select"/></a></li>
                        <li><a href='#step2' data-toggle="tab" class="not-active"><fmt:message key="Upload_Upload"/></a></li>
                        <li><a href='#step3' data-toggle="tab" class="not-active"><fmt:message key="Upload_Preview"/></a></li>
                        </ul>
                        <div id="myTabContent" class="tab-content">
                            <div class="tab-pane fade active in" id="step1">
                                <% } else if (progress != null || progress != "") {
                                    if (progress.length() > 5) {%>
                                <li><a href='#step1' data-toggle="tab" class="not-active"><fmt:message key="Upload_Select"/></a></li>
                                <li><a href='#step2' data-toggle="tab" class="not-active"><fmt:message key="Upload_Upload"/></a></li>
                                <li  class='active'><a href='#step3' data-toggle="tab" class="not-active"><fmt:message key="Upload_Preview"/></a></li>
                                </ul> 
                                <div id="myTabContent" class="tab-content">
                                    <div class="tab-pane fade" id="step1">
                                        <%
                                                }
                                            } %>

                                        <div class="row">
                                            <div class="col-lg-12">
                                            </div>
                                            <%
                                                //session.setAttribute("Name", session.getAttribute("Name").toString());
                                                ArrayList<String> photoList = new ArrayList<String>();
                                                Test.Photo tp = new Test.Photo();
                                                if (session.getAttribute("Name") != null) {
                                                    photoList = tp.getCategoriesPhotographer(session.getAttribute("Name").toString()); //FOR DEBUG
                                                }
                                                //photoList = tp.getPhotos(session.getAttribute("Name").toString());     // FINAL get session name

                                                for (String es : photoList) {

                                            %>
                                            <div class="col-lg-3 col-md-4 col-xs-6 thumb" style="position: relative">
                                                <a class="thumbnail" href="Upload.jsp?cat=<%=es%>">
                                                    <img class="img-responsive" style="position: relative; top: 0; left: 0;" alt="test" width="100" height="100" style="z-index: -1" src="http://png-3.findicons.com/files/icons/2770/ios_7_icons/100/folder.png" > 
                                                </a>
                                                <!--top:120px;left: 230px;-->
                                                <a id="<%=es%>" type="submit" href="Upload.jsp?cat=<%=es%>" style="position: absolute; text-align:center; top:115px;">
                                                    <b><%=es%></b>
                                                </a>
                                            </div>
                                            <%
                                                }
                                            %>
                                        </div>
                                    </div>

                                    <% if (request.getParameter("cat") != null) { %>
                                    <div class="tab-pane fade active in" id="step2">
                                        <form name="form1" id="form1" action="test" method="post" enctype="multipart/form-data">
                                            <input type="hidden" name="hiddenfield1" value="ok">
                                            <fieldset>
                                                <h2><fmt:message key="Upload_ToUpload"/></h2>
                                            </fieldset>
                                            <br/>
                                            <input type="file" class="file" name="file1" accept="image/*" multiple >
                                            <div id="buttonreplacement" style="display:none;">
                                                <h3>
                                                    <img src="Images/spinner.gif" width="50" alt=""/>
                                                    <fmt:message key="Upload_Uploading"/>
                                                </h3>
                                            </div>
                                        </form>
                                        <br/>
                                        <br/>
                                        <hr>

                                        <div class="form-group">
                                            <form action="NewCategoryUploaded" method="post">
                                                <fieldset>
                                                    <h2><fmt:message key="Upload_NewCat"/></h2>
                                                </fieldset>
                                                <input type="text" class="file" name="FolderCategory" value=""/>    
                                                <input type="submit" class="btn btn-primary" value="Categorie Toevoegen!" name="btnCategory" />
                                            </form>
                                        </div>
                                        <%
                                            String user = "";
                                            if (request.getParameter("btnCategory") != null) {
                                                if (session.getAttribute("Name") != null) {
                                                    user = session.getAttribute("Name").toString();
                                                }
                                                ftpload.uploadDiretory(request.getParameter("FolderCategory").toString(), user);
                                                //session.removeAttribute("cat");
                                                // session.invalidate();
                                                response.sendRedirect("Upload.jsp");
                                            }
                                        %>

                                    </div>
                                    <%
                                        progress = (String) request.getAttribute("bla"); %>
                                    <br/>
                                    <br/>          
                                    <% } else {
                                    %>
                                    <div class="tab-pane fade" id="step2">

                                    </div>
                                    <% } %>  
                                    <%   if (request.getAttribute("bla") != null) {
                                            if (progress.length() > 5) {
                                    %>
                                    <div class="tab-pane fade active in" id="step3">
                                        <%
                                            for (String es : files) {

                                        %>
                                        <div class="col-lg-3 col-md-4 col-xs-6 thumb" style="position: relative">
                                            <a class="thumbnail" href="ftp://asror:asror@212.64.126.219:9942/<%=es%>">
                                                <img id="<%=es.substring(es.lastIndexOf("/") + 1, es.lastIndexOf("."))%>" class="img-responsive" style="position: relative; top: 0; left: 0;" alt="test" width="100" height="100" style="z-index: -1" src="ftp://asror:asror@212.64.126.219:9942/Thumb/<%=es.substring(es.lastIndexOf("/") + 1, es.lastIndexOf(".") + 4)%>"> 

                                            </a>
                                            <b style="position: absolute; text-align:center; top:115px;"><%=es.substring(es.lastIndexOf("/") + 1, es.lastIndexOf("."))%></b>
                                        </div>

                                        <%

                                            } %>

                                        <% }
                                        } else { %>   
                                        <div class="tab-pane fade" id="step3">
                                            <% }%>    
                                        </div>
                                    </div>



                                    </body>

                                    <script>
                                        $("#file-0").fileinput({
                                            uploadUrl: '#', // you must set a valid URL here else you will get an error
                                            allowedFileExtensions: ['jpg', 'png', 'gif'],
                                            overwriteInitial: false,
                                            maxFileSize: 1000,
                                            maxFilesNum: 10,
                                            //allowedFileTypes: ['image', 'video', 'flash'],
                                            slugCallback: function (filename) {
                                                return filename.replace('(', '_').replace(']', '_');
                                            }
                                        });


                                        $(document).ready(function() {
                                        $("#test-upload").fileinput({
                                        'showPreview' : false,
                                                'allowedFileExtensions' : ['jpg', 'png', 'gif'],
                                                'elErrorContainer': '#errorBlock'
                                        });                                    </script>

                                    <script type="text/javascript">
                                                function ButtonClicked()
                                                {
                                                //document.getElementById("UploadBTN").style.display = "none"; // to undisplay
                                                        document.getElementById("buttonreplacement").style.display = ""; // to display
                                                        return true;
                                                }
                                    </script>

                                    </html>
