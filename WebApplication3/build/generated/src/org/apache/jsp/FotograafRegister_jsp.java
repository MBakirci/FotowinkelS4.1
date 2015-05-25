package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class FotograafRegister_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Masterpage_final.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <h1>Registeer fotograaf</h1>\r\n");
      out.write("            <hr>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <form role=\"form\">\r\n");
      out.write("                    <div class=\"well well-sm\"><strong><span class=\"glyphicon glyphicon-asterisk\"></span>Required Field</strong></div>\r\n");
      out.write("                    <div class=\"col-md-6 col-sm-6 col-xs-12\">\r\n");
      out.write("                        <div class=\"form-group col-md-12\">\r\n");
      out.write("                            <label for=\"voornaam\">Naam</label>\r\n");
      out.write("                            <div class=\"input-group col-md-12\">\r\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"voornaam\" name=\"voornaam\" placeholder=\"Naam\" required>\r\n");
      out.write("                                <span class=\"input-group-addon\"><span class=\"glyphicon glyphicon-asterisk\"></span></span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"form-group col-md-4\">\r\n");
      out.write("                            <label for=\"tussenvoegsel\">Tussenvoegsel</label>\r\n");
      out.write("                            <div class=\"input-group\">\r\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"tussenvoegsel\" name=\"tussenvoegsel\" placeholder=\"Tussenvoegsel\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"form-group col-md-8\">\r\n");
      out.write("                            <label for=\"achternaam\">Achternaam</label>\r\n");
      out.write("                            <div class=\"input-group\">\r\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"achternaam\" name=\"achternaam\" placeholder=\"Achternaam\" required>\r\n");
      out.write("                                <span class=\"input-group-addon\"><span class=\"glyphicon glyphicon-asterisk\"></span></span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"form-group col-md-12\">\r\n");
      out.write("                            <label for=\"username\">Enter Email</label>\r\n");
      out.write("                            <div class=\"input-group\">\r\n");
      out.write("                                <input type=\"email\" class=\"form-control\" id=\"username\" name=\"username\" placeholder=\"Email\" required>\r\n");
      out.write("                                <span class=\"input-group-addon\"><span class=\"glyphicon glyphicon-asterisk\"></span></span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"form-group col-md-12\">\r\n");
      out.write("                            <label for=\"password\">Confirm Email</label>\r\n");
      out.write("                            <div class=\"input-group\">\r\n");
      out.write("                                <input type=\"password\" class=\"form-control\" id=\"password\" name=\"password\" placeholder=\"Password\" required>\r\n");
      out.write("                                <span class=\"input-group-addon\"><span class=\"glyphicon glyphicon-asterisk\"></span></span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"col-md-6 col-sm-6 col-xs-12\">\r\n");
      out.write("                        <div class=\"form-group col-md-8\">\r\n");
      out.write("                            <label for=\"straat\">Straat</label>\r\n");
      out.write("                            <div class=\"input-group\">\r\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"straat\" name=\"straat\" placeholder=\"Straat\" required>\r\n");
      out.write("                                <span class=\"input-group-addon\"><span class=\"glyphicon glyphicon-asterisk\"></span></span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"form-group col-md-4\">\r\n");
      out.write("                            <label for=\"huisnummer\">Huisnummer</label>\r\n");
      out.write("                            <div class=\"input-group\">\r\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"huisnummer\" name=\"huisnummer\" placeholder=\"Huisnummer\" required>\r\n");
      out.write("                                <span class=\"input-group-addon\"><span class=\"glyphicon glyphicon-asterisk\"></span></span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"form-group col-md-4\">\r\n");
      out.write("                            <label for=\"postcode\">Postcode</label>\r\n");
      out.write("                            <div class=\"input-group\">\r\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"postcode\" name=\"postcode\" placeholder=\"Postcode\" required>\r\n");
      out.write("                                <span class=\"input-group-addon\"><span class=\"glyphicon glyphicon-asterisk\"></span></span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"form-group col-md-8\">\r\n");
      out.write("                            <label for=\"stad\">Stad</label>\r\n");
      out.write("                            <div class=\"input-group\">\r\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"stad\" name=\"stad\" placeholder=\"Stad\" required>\r\n");
      out.write("                                <span class=\"input-group-addon\"><span class=\"glyphicon glyphicon-asterisk\"></span></span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"form-group col-md-12\">\r\n");
      out.write("                            <label for=\"voornaam\">Telefoon</label>\r\n");
      out.write("                            <div class=\"input-group col-md-12\">\r\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"telefoon\" name=\"telefoon\" placeholder=\"Telefoon\" required>\r\n");
      out.write("                                <span class=\"input-group-addon\"><span class=\"glyphicon glyphicon-asterisk\"></span></span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-md-12\">\r\n");
      out.write("                        <input type=\"submit\" name=\"btnregistreer\" id=\"btnregistreer\" value=\"Registreer\" class=\"btn btn-primary pull-right\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </form>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        ");

            //  int id = 1;
            String email = request.getParameter("username");
            String pass = request.getParameter("password");
            String voornaam = request.getParameter("voornaam");
            String tussenvoegsel = request.getParameter("tussenvoegsel");
            String achternaam = request.getParameter("achternaam");
            int actief = 1;
            String error = "";
            String telefoon = request.getParameter("telefoon");
            String straat = request.getParameter("straat");
            String huisnr = request.getParameter("huisnummer");
            String postcode = request.getParameter("postcode");
            String stad = request.getParameter("stad");

            if (request.getParameter("btnregistreer") != null) {
                Test.User newUser = new Test.User(email, pass, voornaam, tussenvoegsel, achternaam, "fotograaf");
                if (newUser.Fotograaf(telefoon, straat, huisnr, postcode, stad)) {
                    out.print("<div class=\"alert alert-success col-md-8 col-md-offset-2\">registeren gelukt</div>");
                } else {
                    out.print("<div class=\"alert alert-danger col-md-8 col-md-offset-2\">registeren mislukt</div>");
                }
            }
        
      out.write("\r\n");
      out.write("                    <footer class=\"footer\">\r\n");
      out.write("                <p>&copy; Company 2014</p>\r\n");
      out.write("            </footer>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
