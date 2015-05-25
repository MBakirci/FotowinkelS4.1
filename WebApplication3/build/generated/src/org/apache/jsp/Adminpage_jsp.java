package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.persistence.Convert;
import java.util.*;
import Test.Login;
import java.sql.*;
import Test.Databaseconnector;
import Test.registreer;
import Test.Verwijderaccount;

public final class Adminpage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Masterpage_final.jsp", out, false);
      out.write('\r');
      out.write('\n');
if (session.getAttribute("Role") == null || !session.getAttribute("Role").equals("admin")) {
        response.sendRedirect("index.jsp");
    }

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>Account gegevens verwerken</title>\r\n");
      out.write("        <link href=\"CSS/chosen.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <h2 class=\"form-signin-heading\">Account (de)Activeren</h2>\r\n");
      out.write("            <hr>\r\n");
      out.write("\r\n");
      out.write("            <form class=\"col-md-6\" method=\"post\">\r\n");
      out.write("\r\n");
      out.write("                <div class=\"form-group col-md-12\">\r\n");
      out.write("                    <label for=\"inputName\" class=\"sr-only\">Email address</label>\r\n");
      out.write("                    ");

                        Verwijderaccount vw = new Verwijderaccount();
                        ResultSet rs = vw.getallUsers();
                    
      out.write("\r\n");
      out.write("                     <select  id=\"Email\" name=\"Email\" data-placeholder=\"Kies een account...\" class=\"chosen-select\" style=\"width:100%;\" tabindex=\"2\">\r\n");
      out.write("                         <option value=\"\"></option>\r\n");
      out.write("                         ");

                            while (rs.next()) {
                                String getActief = "Actief";
                                if (!rs.getString("ENABLED").equals("1")) {
                                    getActief = "Non-Actief";
                                    String non = "background: #009966; color: #FFF;";
                                }
                        
      out.write("\r\n");
      out.write("                        <option value=\"");
      out.print(rs.getString("EMAIL"));
      out.write("\">\r\n");
      out.write("                            ");
      out.print(rs.getString("EMAIL"));
      out.write(" | ");
      out.print(getActief);
      out.write("\r\n");
      out.write("                        </option>\r\n");
      out.write("                        ");

                            }
                        
      out.write("\r\n");
      out.write("                    </select>\r\n");
      out.write("                </div>\r\n");
      out.write("                    \r\n");
      out.write("                <div class=\"form-group col-md-6\">\r\n");
      out.write("                    <button class=\"btn btn-lg btn-primary btn-block\" type=\"submit\" name=\"btnNonactief\">Account op non actief </button>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"form-group col-md-6\">\r\n");
      out.write("                    <button class=\"btn btn-lg btn-primary btn-block\" type=\"submit\" name=\"btnActief\">Account naar actief </button>\r\n");
      out.write("                </div>\r\n");
      out.write("            </form>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        ");
                 // de email
            String naam = request.getParameter("Email");

            //als iemand op de btn non actief drukt van roep je de methode
            //uit verwijder acccount aan die de status op non actief zet\
            //als het goed is dan ga je weer naar de start pagina
            //als het niet goed dan krijg en een waarschuwing
            if (request.getParameter("btnNonactief") != null) {
                Test.Verwijderaccount nonactief = new Test.Verwijderaccount(naam);
                if (nonactief.Zetstatusnonactief()) {
                    out.print("<div class=\"alert alert-success col-md-8 col-md-offset-2\">Account succesvol gedeactiveerd!</div>");
                    response.setHeader("Refresh", "1;url=Adminpage.jsp");
                } else {
                    out.print("<div class=\"alert alert-danger col-md-8 col-md-offset-2\">Er is een fout opgetreden!</div>");
                }

            }
            //als iemand op de btn actief drukt van roep je de methode
            //uit verwijderacccount aan die de status op actief zet\
            //als het goed is dan ga je weer naar de start pagina
            //als het niet goed dan krijg en een waarschuwing
            if (request.getParameter("btnActief") != null) {
                Test.Verwijderaccount actief = new Test.Verwijderaccount(naam);
                if (actief.Zetstatusactief()) {
                    out.print("<div class=\"alert alert-success col-md-8 col-md-offset-2\">Account succesvol geactiveerd!</div>");
                    response.setHeader("Refresh", "1;url=Adminpage.jsp");
                } else {
                    out.print("<div class=\"alert alert-danger col-md-8 col-md-offset-2\">Er is een fout opgetreden!</div>");
                }
            }
        
      out.write("\r\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        <script src=\"js/chosen.jquery.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("            var config = {\r\n");
      out.write("                '.chosen-select': {},\r\n");
      out.write("                '.chosen-select-deselect': {allow_single_deselect: true},\r\n");
      out.write("                '.chosen-select-no-single': {disable_search_threshold: 10},\r\n");
      out.write("                '.chosen-select-no-results': {no_results_text: 'Oops, nothing found!'},\r\n");
      out.write("                '.chosen-select-width': {width: \"95%\"}\r\n");
      out.write("            }\r\n");
      out.write("            for (var selector in config) {\r\n");
      out.write("                $(selector).chosen(config[selector]);\r\n");
      out.write("            }\r\n");
      out.write("        </script>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
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
