package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.net.aso.a;
import Test.Foto_klant;
import Test.Photo;

public final class klantcodepagina_005f1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!-- \r\n");
      out.write("    Document   : klantcodepagina_1\r\n");
      out.write("    Created on : 8-apr-2015, 11:11:12\r\n");
      out.write("    Author     : Dennis\r\n");
      out.write("-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Masterpage_final.jsp", out, false);
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Klant Pagina</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <form>\r\n");
      out.write("            <div class=\"col-lg-6 col-md-offset-3\">\r\n");
      out.write("                <h4 style=\"margin-top: 50px;\">Vult hier uw persoonlijke code voor de foto's in die u wilt bekijken</h4>\r\n");
      out.write("                <hr>\r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                    <label for=\"inputvoornaam\" class=\"sr-only\">Code</label>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-lg-6\">\r\n");
      out.write("                        <div class=\"input-group\">\r\n");
      out.write("                            <input type=\"text\" name=\"Code\" class=\"form-control\" placeholder=\"Code\">\r\n");
      out.write("                            <span class=\"input-group-btn\">\r\n");
      out.write("                                <button class=\"btn btn-default\" type=\"submit\" name=\"btnCode\">Bekijk uw foto's!</button>\r\n");
      out.write("                            </span>\r\n");
      out.write("                        </div><!-- /input-group -->\r\n");
      out.write("                    </div><!-- /.col-lg-6 -->\r\n");
      out.write("                </div>\r\n");
      out.write("                ");

                    String code = request.getParameter("Code");
                    String error = "";
                    Test.Foto_klant FotoCode = new Test.Foto_klant();
                    String src = FotoCode.VraagFoto(code);
                    request.setAttribute("image", src);
                    if (request.getParameter("btnCode") != null) {

                        // Test.Controleercode reg = new Test.Controleercode(code);
                        if (src.equals("")) {
                            //error = "De code bestaat niet controleer deze en probeer het opnieuw";
                
      out.write("\r\n");
      out.write("                <div style=\"margin-top: 10px\" class=\"alert alert-danger\" role=\"alert\"><b><i>");
      out.print(code);
      out.write("</i></b> - Deze code bestaat niet, controleer deze en probeer het opnieuw</div>\r\n");
      out.write("\r\n");
      out.write("                ");

                    //response.addHeader("labelmislukt", "inloggen is mislukt");
                } //response.sendRedirect("Inlogscherm.jsp");}
                else {

                    request.setAttribute("image", src);
                    //out.print("het is gelukt");
                    Test.Photo idcode = new Test.Photo();
                    String a = idcode.getID(session.getAttribute("Name").toString());
                    int b = Integer.parseInt(a);
                    Test.SQL sql = new Test.SQL();
                    sql.koppeling(b, code);
                
      out.write("\r\n");
      out.write("                <div style=\"margin-top: 10px\" class=\"alert alert-success\" role=\"alert\">");
      out.print(code);
      out.write(" is succesvol toegevoegd aan uw foto's</div>\r\n");
      out.write("                ");


                            //   response.sendRedirect("index.jsp");                     }
                        }
                    }
                    // if(request.getParameter("Code") != null)   
                    // {
                    //      response.sendRedirect("Inlogscherm.jsp");
                    // }

      out.write("\r\n");
      out.write("                <img src=\"");
      out.print(request.getAttribute("image"));
      out.write("\">\r\n");
      out.write("            </div>\r\n");
      out.write("        </form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <font color=\"red\">");
      out.print(error);
      out.write("</font>\r\n");
      out.write("\r\n");
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
