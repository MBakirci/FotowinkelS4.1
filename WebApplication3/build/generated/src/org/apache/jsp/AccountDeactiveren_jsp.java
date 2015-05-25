package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import Test.Login;
import java.sql.*;
import Test.Databaseconnector;
import Test.registreer;
import Test.Verwijderaccount;

public final class AccountDeactiveren_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("     <head>\r\n");
      out.write("         \r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <meta name=\"description\" content=\"\">\r\n");
      out.write("    <meta name=\"author\" content=\"\">\r\n");
      out.write("    <link rel=\"icon\" href=\"favicon.ico\">\r\n");
      out.write("\r\n");
      out.write("    <title>Account gegevens verwerken</title>\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap core CSS -->\r\n");
      out.write("    <link href=\"CSS/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("\r\n");
      out.write("    <!-- Custom styles for this template -->\r\n");
      out.write("    <link href=\"CSS/justified-nav.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->\r\n");
      out.write("    <!--[if lt IE 9]><script src=\"../../assets/js/ie8-responsive-file-warning.js\"></script><![endif]-->\r\n");
      out.write("    <script src=\"js/ie-emulation-modes-warning.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->\r\n");
      out.write("    <!--[if lt IE 9]>\r\n");
      out.write("      <script src=\"https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js\"></script>\r\n");
      out.write("      <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\r\n");
      out.write("    <![endif]-->\r\n");
      out.write("  </head>\r\n");
      out.write("    <body>\r\n");
      out.write("     \r\n");
      out.write("        \r\n");
      out.write("         <div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("            <div class=\"masthead\">\r\n");
      out.write("                <h3 class=\"text-muted\">Project name</h3>\r\n");
      out.write("                <nav>\r\n");
      out.write("                    <ul class=\"nav nav-justified\">\r\n");
      out.write("                        <li class=\"active\"><a href=\"index.jsp\">Home</a></li>\r\n");
      out.write("                        <li><a href=\"Adminpage.jsp\">Accountinformatie</a></li>\r\n");
      out.write("                        <li><a href=\"fotograafProfiel.jsp\">Profiel</a></li>\r\n");
      out.write("                        <li><a href=\"Registreren.jsp\">Registreren</a></li>\r\n");
      out.write("                        <li><a href=\"Inlogscherm.jsp\">login</a></li>\r\n");
      out.write("                        <li><a href=\"logout.jsp\">Logout</a></li>\r\n");
      out.write("                        <li><a href=\"Upload.jsp\">Upload</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </nav>\r\n");
      out.write("            </div>\r\n");
      out.write("             \r\n");
      out.write("<!--             <form id=\"loginform\" autocomplete=\"on\" method=\"POST\">\r\n");
      out.write("         <div class=\"input-group\">\r\n");
      out.write("  <span class=\"input-group-addon\">username</span>\r\n");
      out.write("  <input type=\"text\" class=\"form-control\" id=\"username\" required=\"required\" name=\"username\" placeholder=\"Username\" aria-describedby=\"basic-addon1\">\r\n");
      out.write("</div>    \r\n");
      out.write("\r\n");
      out.write("                    <div class=\"input-group\">\r\n");
      out.write("  <span class=\"input-group-addon\" id=\"basic-addon1\">password</span>\r\n");
      out.write("  <input type=\"password\"  name=\"password\" class=\"form-control\" required=\"required\" placeholder=\"Wachtwoord\" aria-describedby=\"basic-addon1\">\r\n");
      out.write("</div>   \r\n");
      out.write("<<<<<<< HEAD\r\n");
      out.write("                 \r\n");
      out.write("                 <input  type=\"submit\" value=\"Sign in\" name=\"btnLogin\" id=\"testen1\" class=\"btn btn-default navbar-btn\" >                \r\n");
      out.write("             </form>  -->\r\n");
      out.write("\r\n");
      out.write("   <div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("       <form class=\"form-signin\" method=\"post\">\r\n");
      out.write("        <h2 class=\"form-signin-heading\">Please sign in</h2>\r\n");
      out.write("        <label for=\"inputName\" class=\"sr-only\">Email address</label>\r\n");
      out.write("        <input type=\"email\" id=\"Name\" name=\"Email\" class=\"form-control\" placeholder=\"Email\" required autofocus>\r\n");
      out.write("        \r\n");
      out.write("       \r\n");
      out.write("        <button class=\"btn btn-lg btn-primary btn-block\" type=\"submit\" name=\"btnNonactief\">Account op non actief </button>\r\n");
      out.write("         <button class=\"btn btn-lg btn-primary btn-block\" type=\"submit\" name=\"btnActief\">Account naar actief </button>\r\n");
      out.write("         \r\n");
      out.write("      </form>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("                     \r\n");
      out.write("             ");

               // de email
                String naam = request.getParameter("Email");
                
              
                //als iemand op de btn non actief drukt van roep je de methode
                //uit verwijder acccount aan die de status op non actief zet\
                //als het goed is dan ga je weer naar de start pagina
                //als het niet goed dan krijg en een waarschuwing
                 if(request.getParameter("btnNonactief")!= null){
                     Test.Verwijderaccount nonactief = new Test.Verwijderaccount(naam);
                     if(nonactief.Zetstatusnonactief()){
                         out.print("Account op non-actief zetten gelukt");
                         
                         response.sendRedirect("index.jsp");
                     }
                     else{
                         out.print("niet op non-actief , controleer of u een goede email heeft ingevult");
                     }
                 
                 }
                //als iemand op de btn actief drukt van roep je de methode
                //uit verwijderacccount aan die de status op actief zet\
                //als het goed is dan ga je weer naar de start pagina
                //als het niet goed dan krijg en een waarschuwing
                     if(request.getParameter("btnActief")!= null){
                     Test.Verwijderaccount actief = new Test.Verwijderaccount(naam);
                     if(actief.Zetstatusactief()){
                         out.print("Account is nu weer actief");
                        
                         response.sendRedirect("index.jsp");
                     }
                     else{
                         out.print("account is niet actief, controleer of u het goede email adres heeft ingevult");
                     }
                 }
                     
           
                 
      out.write("\r\n");
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
