package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import org.apache.commons.net.ftp.FTPClient;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.net.URL;
import java.util.Map;
import Test.FTPUpload;
import Test.Categorieën;
import Test.Databaseconnecter;
import Test.Categorie;

public final class Upload_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Masterpage_final.jsp", out, false);
      out.write("\r\n");
      out.write("    <html>\r\n");
      out.write("        <head>\r\n");
      out.write("            <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("            <title>JSP Page</title>\r\n");
      out.write("        ");
 Test.FTPUpload ftpload = new Test.FTPUpload(); 
      out.write("\r\n");
      out.write("        ");
 Test.Categorie categorie = new Test.Categorie(); 
      out.write("\r\n");
      out.write("        ");
 Test.Categorieën categorieën = new Test.Categorieën(); 
      out.write("\r\n");
      out.write("        ");
 Test.Databaseconnecter dbconnect = new Test.Databaseconnecter(); 
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <title>Upload</title>\r\n");
      out.write("\r\n");
      out.write("        <!-- Bootstrap core CSS -->\r\n");
      out.write("        <link href=\"CSS/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("\r\n");
      out.write("        <!-- Custom styles for this template -->\r\n");
      out.write("        <link href=\"CSS/justified-nav.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->\r\n");
      out.write("        <!--[if lt IE 9]><script src=\"../../assets/js/ie8-responsive-file-warning.js\"></script><![endif]-->\r\n");
      out.write("        <script src=\"js/ie-emulation-modes-warning.js\"></script>\r\n");
      out.write("        <link href=\"https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("        <script src=\"http://code.jquery.com/jquery-1.10.2.min.js\"></script>\r\n");
      out.write("        <script src=\"https://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js\"></script>\r\n");
      out.write("        <link href=\"CSS/newcss.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("        <link href=\"CSS/fileinput.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("        <script src=\"http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js\"></script>\r\n");
      out.write("        <script src=\"js/fileinput.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        <script src=\"js/fileinput_locale_nl.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
 ArrayList<String> files = new ArrayList<String>();
            if (request.getAttribute("fileslist") != null) {
                files = (ArrayList<String>) request.getAttribute("fileslist");
            }
        
      out.write("\r\n");
      out.write("\r\n");
      out.write("        ");
 String progress = "";
            if (request.getAttribute("bla") != null) {
                progress = (String) request.getAttribute("bla");
            }
        
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        ");

            if (request.getParameter("cat") != null) {
                if (session.getAttribute("Name") != null) {
                    String user = session.getAttribute("Name").toString();
                    Test.StaticValues.setMyStaticMember(request.getParameter("cat"), user);
                }
            } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <h2>Upload</h2>\r\n");
      out.write("            <hr>\r\n");
      out.write("            <div>\r\n");
      out.write("                <ul class='nav nav-wizard'>\r\n");
      out.write("                    ");

                        if (request.getParameter("cat") != null && request.getAttribute("bla") == null) {
                    
      out.write("\r\n");
      out.write("                    <li><a href='#step1' data-toggle=\"tab\" class=\"not-active\">Select folder</a></li>\r\n");
      out.write("                    <li  class='active'><a href='#step2' data-toggle=\"tab\" class=\"not-active\">Upload images</a></li>\r\n");
      out.write("                    <li><a href='#step3' data-toggle=\"tab\" class=\"not-active\">Preview</a></li>\r\n");
      out.write("\r\n");
      out.write("                </ul>\r\n");
      out.write("\r\n");
      out.write("                <div id=\"myTabContent\" class=\"tab-content\">\r\n");
      out.write("                    <div class=\"tab-pane fade\" id=\"step1\">\r\n");
      out.write("                        ");

                        } else if (request.getParameter("cat") == null && request.getAttribute("bla") == null) {
                        
      out.write("\r\n");
      out.write("                        <li  class='active'><a href='#step1' data-toggle=\"tab\" class=\"not-active\">Select folder</a></li>\r\n");
      out.write("                        <li><a href='#step2' data-toggle=\"tab\" class=\"not-active\">Upload images</a></li>\r\n");
      out.write("                        <li><a href='#step3' data-toggle=\"tab\" class=\"not-active\">Preview</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                        <div id=\"myTabContent\" class=\"tab-content\">\r\n");
      out.write("                            <div class=\"tab-pane fade active in\" id=\"step1\">\r\n");
      out.write("                                ");
 } else if (progress != null || progress != "") {
                                    if (progress.length() > 5) {
      out.write("\r\n");
      out.write("                                <li><a href='#step1' data-toggle=\"tab\" class=\"not-active\">Select folder</a></li>\r\n");
      out.write("                                <li><a href='#step2' data-toggle=\"tab\" class=\"not-active\">Upload images</a></li>\r\n");
      out.write("                                <li  class='active'><a href='#step3' data-toggle=\"tab\" class=\"not-active\">Preview</a></li>\r\n");
      out.write("                                </ul> \r\n");
      out.write("                                <div id=\"myTabContent\" class=\"tab-content\">\r\n");
      out.write("                                    <div class=\"tab-pane fade\" id=\"step1\">\r\n");
      out.write("                                        ");

                                                }
                                            } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                        <div class=\"row\">\r\n");
      out.write("                                            <div class=\"col-lg-12\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            ");

                                                //session.setAttribute("Name", session.getAttribute("Name").toString());
                                                ArrayList<String> photoList = new ArrayList<String>();
                                                Test.Photo tp = new Test.Photo();
                                                if (session.getAttribute("Name") != null) {
                                                    photoList = tp.getCategoriesPhotographer(session.getAttribute("Name").toString()); //FOR DEBUG
                                                }
                                                //photoList = tp.getPhotos(session.getAttribute("Name").toString());     // FINAL get session name

                                                for (String es : photoList) {

                                            
      out.write("\r\n");
      out.write("                                            <div class=\"col-lg-3 col-md-4 col-xs-6 thumb\" style=\"position: relative\">\r\n");
      out.write("                                                <a class=\"thumbnail\" href=\"Upload.jsp?cat=");
      out.print(es);
      out.write("\">\r\n");
      out.write("                                                    <img class=\"img-responsive\" style=\"position: relative; top: 0; left: 0;\" alt=\"test\" width=\"100\" height=\"100\" style=\"z-index: -1\" src=\"http://png-3.findicons.com/files/icons/2770/ios_7_icons/100/folder.png\" > \r\n");
      out.write("                                                </a>\r\n");
      out.write("                                                <!--top:120px;left: 230px;-->\r\n");
      out.write("                                                <a id=\"");
      out.print(es);
      out.write("\" type=\"submit\" href=\"Upload.jsp?cat=");
      out.print(es);
      out.write("\" style=\"position: absolute; text-align:center; top:115px;\">\r\n");
      out.write("                                                    <b>");
      out.print(es);
      out.write("</b>\r\n");
      out.write("                                                </a>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            ");

                                                }
                                            
      out.write("\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("                                    ");
 if (request.getParameter("cat") != null) { 
      out.write("\r\n");
      out.write("                                    <div class=\"tab-pane fade active in\" id=\"step2\">\r\n");
      out.write("                                        <form name=\"form1\" id=\"form1\" action=\"test\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("                                            <input type=\"hidden\" name=\"hiddenfield1\" value=\"ok\">\r\n");
      out.write("                                            <fieldset>\r\n");
      out.write("                                                <h2>Files to upload:</h2>\r\n");
      out.write("                                            </fieldset>\r\n");
      out.write("                                            <br/>\r\n");
      out.write("                                            <input type=\"file\" class=\"file\" name=\"file1\" accept=\"image/*\" multiple >\r\n");
      out.write("                                            <div id=\"buttonreplacement\" style=\"margin-left:30px; display:none;\">\r\n");
      out.write("                                                <img src=\"ajax-loader.gif\" alt=\"\"/>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </form>\r\n");
      out.write("                                        <br/>\r\n");
      out.write("                                        <br/>\r\n");
      out.write("                                        <hr>\r\n");
      out.write("\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <form action=\"NewCategoryUploaded\" method=\"post\">\r\n");
      out.write("                                                <fieldset>\r\n");
      out.write("                                                    <h2>Maak nieuwe categorie aan:</h2>\r\n");
      out.write("                                                </fieldset>\r\n");
      out.write("                                                <input type=\"text\" class=\"file\" name=\"FolderCategory\" value=\"\"/>    \r\n");
      out.write("                                                <input type=\"submit\" class=\"btn btn-primary\" value=\"Categorie Toevoegen!\" name=\"btnCategory\" />\r\n");
      out.write("                                            </form>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        ");

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
                                        
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    ");

                                        progress = (String) request.getAttribute("bla"); 
      out.write("\r\n");
      out.write("                                    <br/>\r\n");
      out.write("                                    <br/>          \r\n");
      out.write("                                    ");
 } else {
                                    
      out.write("\r\n");
      out.write("                                    <div class=\"tab-pane fade\" id=\"step2\">\r\n");
      out.write("\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    ");
 } 
      out.write("  \r\n");
      out.write("                                    ");
   if (request.getAttribute("bla") != null) {
                                            if (progress.length() > 5) {
                                    
      out.write("\r\n");
      out.write("                                    <div class=\"tab-pane fade active in\" id=\"step3\">\r\n");
      out.write("                                        ");

                                            for (String es : files) {

                                        
      out.write("\r\n");
      out.write("                                        <div class=\"col-lg-3 col-md-4 col-xs-6 thumb\" style=\"position: relative\">\r\n");
      out.write("                                            <a class=\"thumbnail\" href=\"ftp://asror:asror@212.64.126.219:9942/");
      out.print(es);
      out.write("\">\r\n");
      out.write("                                                <img id=\"");
      out.print(es.substring(es.lastIndexOf("/") + 1, es.lastIndexOf(".")));
      out.write("\" class=\"img-responsive\" style=\"position: relative; top: 0; left: 0;\" alt=\"test\" width=\"100\" height=\"100\" style=\"z-index: -1\" src=\"ftp://asror:asror@212.64.126.219:9942/Thumb/");
      out.print(es.substring(es.lastIndexOf("/") + 1, es.lastIndexOf(".") + 4));
      out.write("\"> \r\n");
      out.write("\r\n");
      out.write("                                            </a>\r\n");
      out.write("                                            <b style=\"position: absolute; text-align:center; top:115px;\">");
      out.print(es.substring(es.lastIndexOf("/") + 1, es.lastIndexOf(".")));
      out.write("</b>\r\n");
      out.write("                                        </div>\r\n");
      out.write("\r\n");
      out.write("                                        ");


                                            } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                        ");
 }
                                        } else { 
      out.write("   \r\n");
      out.write("                                        <div class=\"tab-pane fade\" id=\"step3\">\r\n");
      out.write("                                            ");
 }
      out.write("    \r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                    </body>\r\n");
      out.write("\r\n");
      out.write("                                    <script>\r\n");
      out.write("                                        $(\"#file-0\").fileinput({\r\n");
      out.write("                                            uploadUrl: '#', // you must set a valid URL here else you will get an error\r\n");
      out.write("                                            allowedFileExtensions: ['jpg', 'png', 'gif'],\r\n");
      out.write("                                            overwriteInitial: false,\r\n");
      out.write("                                            maxFileSize: 1000,\r\n");
      out.write("                                            maxFilesNum: 10,\r\n");
      out.write("                                            //allowedFileTypes: ['image', 'video', 'flash'],\r\n");
      out.write("                                            slugCallback: function (filename) {\r\n");
      out.write("                                                return filename.replace('(', '_').replace(']', '_');\r\n");
      out.write("                                            }\r\n");
      out.write("                                        });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                        $(document).ready(function() {\r\n");
      out.write("                                        $(\"#test-upload\").fileinput({\r\n");
      out.write("                                        'showPreview' : false,\r\n");
      out.write("                                                'allowedFileExtensions' : ['jpg', 'png', 'gif'],\r\n");
      out.write("                                                'elErrorContainer': '#errorBlock'\r\n");
      out.write("                                        });                                    </script>\r\n");
      out.write("\r\n");
      out.write("                                    <script type=\"text/javascript\">\r\n");
      out.write("                                                function ButtonClicked()\r\n");
      out.write("                                                {\r\n");
      out.write("                                                document.getElementById(\"UploadBTN\").style.display = \"none\"; // to undisplay\r\n");
      out.write("                                                        document.getElementById(\"buttonreplacement\").style.display = \"\"; // to display\r\n");
      out.write("                                                        return true;\r\n");
      out.write("                                                }\r\n");
      out.write("                                        var FirstLoading = true;\r\n");
      out.write("                                                function RestoreSubmitButton()\r\n");
      out.write("                                                {\r\n");
      out.write("                                                if (FirstLoading)\r\n");
      out.write("                                                {\r\n");
      out.write("                                                FirstLoading = false;\r\n");
      out.write("                                                        return;\r\n");
      out.write("                                                }\r\n");
      out.write("                                                document.getElementById(\"formsubmitbutton\").style.display = \"\"; // to display\r\n");
      out.write("                                                        document.getElementById(\"buttonreplacement\").style.display = \"none\"; // to undisplay\r\n");
      out.write("                                                }\r\n");
      out.write("                                        // To disable restoring submit button, disable or delete next line.\r\n");
      out.write("                                        document.onfocus = RestoreSubmitButton;\r\n");
      out.write("                                    </script>\r\n");
      out.write("\r\n");
      out.write("                                    </html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
