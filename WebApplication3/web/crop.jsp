<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <%@include file="TaalSettings.jsp" %>
        <title><fmt:message key='Crop_Cropper'/></title>
        <link href="CSS/bootstrap.min.css" rel="stylesheet">
        <link href="CSS/cropper.css" rel="stylesheet">
        <link href="CSS/main.css" rel="stylesheet">

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <!-- Content -->
        <div class="container">
            <div class="row">
                <div class="col-md-9">
                    <!-- <h3 class="page-header">Demo:</h3> -->
                    <div class="img-container">
                        <img src="ftp://212.64.126.219:9942/Henk@yolo.nl/Groep/Hen4OH5L7ODR4.jpg" alt="Picture">
                    </div>
                </div>
                <div class="col-md-3">
                    <style> 
                        #previewDiv {
                            width: 300px;
                            height: 300px;
                        }
                    </style>
                    <!-- <h3 class="page-header">Preview:</h3> -->
                    <div id="previewDiv" class="docs-preview clearfix">
                        <div id="prev" class="img-preview preview-lg">
                        </div>
                    </div>

                    <select name="ddlProducten" id="ddlProducten" onchange="changeTheme()">
                        <option value="Images/Muismat.jpg"><fmt:message key='Crop_Muismat'/></option>
                        <option value="Images/cb-coffee-mug.png"><fmt:message key='Crop_KoffieMok'/></option>
                        <option value="Images/tshirt.jpg"><fmt:message key='Crop_TShirt'/></option>
                    </select>

                    <script>
                        function changeTheme() {
                            var e = document.getElementById("ddlProducten");
                            var prod = e.options[e.selectedIndex].value;
                            document.getElementById("previewDiv").style.backgroundImage = "url(" + prod + ")";
                        }
                    </script>

                    <form action="Cropper" method="get">             
                        <!-- <h3 class="page-header">Data:</h3> -->                            
                        <input class="form-control" id="dataX" name="dataX" type="hidden">
                        <input class="form-control" id="dataY" name="dataY" type="hidden" >
                        <input class="form-control" id="dataWidth" name="dataWidht" type="hidden">
                        <input class="form-control" id="dataHeight" name="dataHeight" type="hidden">
                        <input type="submit" value="Crop">
                    </form>
                </div>

                <!-- Alert -->
                <div class="docs-alert"><span class="warning message"></span></div>

                <!-- Scripts -->
                <script src="js/jquery.min.js"></script>
                <script src="js/bootstrap.min.js"></script>
                <script src="js/cropper.js"></script>
                <script src="js/main.js"></script>
                </body>
                </html>
