package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import Test.ProductPage;

public final class ProductPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Masterpage_final.jsp", out, false);
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"CSS/productPage.css\" rel=\"stylesheet\">\n");
      out.write("        <script src=\"js/productpage.js\"></script>\n");
      out.write("\n");
      out.write("        <title>Product Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            String QString = request.getParameter("fotoid").toString();
           // String QString = "213"; //For Debug
            Test.Photo photo = new Test.Photo();
            String link = "";
            Test.ProductPage pp = new Test.ProductPage();
            ArrayList<Double> typePrices = new ArrayList<Double>();
            
            
            if (!QString.equals("") && !QString.equals(null)) {
                link = photo.convertCodeToLink(QString); //Get http link for image source
                typePrices = pp.getTypePrice(); //Get current type prices
            }
        
      out.write("\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <div class=\"content-wrapper\">\t\n");
      out.write("                <div class=\"item-container\">\n");
      out.write("                    <form>\n");
      out.write("                        <div class=\"container\">\t\n");
      out.write("                            <div class=\"col-md-4\">\n");
      out.write("                                <div class=\"product col-md-8 service-image-left\">\n");
      out.write("                                    <center>\n");
      out.write("                                        <img height=\"200\" width=\"200\" id=\"productFoto\" src=\"");
      out.print(link);
      out.write("\"/>\n");
      out.write("                                    </center>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <form>\n");
      out.write("                                <div class=\"col-md-8\">\n");
      out.write("                                    <div class=\"product-title\">Foto: </div>\n");
      out.write("                                    <div class=\"product-desc\">U kan hier uw foto's aanpassen, en vervolgens in uw winkelwagen stoppen.</div>\n");
      out.write("                                    <hr>\n");
      out.write("                                    <div class=\"product-title\">Productsoort:</div>\n");
      out.write("                                    <select id=\"Soort\" name=\"Soort\" class=\"btn btn-default\" onchange=\"updatePrice()\">\n");
      out.write("                                        \n");
      out.write("                                        <option value=\"1\">Foto +");
typePrices.get(1).toString();
      out.write("</option>\n");
      out.write("                                        \n");
      out.write("                                    </select>\n");
      out.write("                                    <div class=\"product-title\" style=\"margin-top: 10px\">Fotokleur: </div>\n");
      out.write("                                    <select id=\"Type\" name=\"Type\" class=\"btn btn-default\" onchange=\"changeColor()\">\n");
      out.write("                                        <option value=\"1\">Normaal</option>\n");
      out.write("                                        <option value=\"2\">Zwart-Wit</option>\n");
      out.write("                                        <option value=\"3\">Sepia</option>\n");
      out.write("                                    </select>\n");
      out.write("                                    <div class=\"product-title\" style=\"margin-top: 10px;\">Afbeelding aanpassen</div>\n");
      out.write("                                    <button class=\"btn btn-default\">Afbeelding bijnsnijden</button>\n");
      out.write("                                    <hr>\n");
      out.write("                                    <div id=\"Prijs\" class=\"product-price\">$ 0,00</div>\n");
      out.write("                                    <div class=\"product-stock\">In Voorraad</div>\n");
      out.write("                                    <hr>\n");
      out.write("                                    <div class=\"btn-group cart\">\n");
      out.write("                                        <button type=\"button\" class=\"btn btn-success\">\n");
      out.write("                                            Aan winkelwagen toevoegen \n");
      out.write("                                        </button>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                        </div> \n");
      out.write("                </div>\n");
      out.write("                <div class=\"container-fluid\">\t\t\n");
      out.write("                    <div class=\"col-md-12 product-info\">\n");
      out.write("                        <ul id=\"myTab\" class=\"nav nav-tabs nav_tabs\">\n");
      out.write("\n");
      out.write("                            <li class=\"active\"><a href=\"#service-one\" data-toggle=\"tab\">DESCRIPTION</a></li>\n");
      out.write("                            <li><a href=\"#service-two\" data-toggle=\"tab\">PRODUCT INFO</a></li>\n");
      out.write("                            <li><a href=\"#service-three\" data-toggle=\"tab\">REVIEWS</a></li>\n");
      out.write("\n");
      out.write("                        </ul>\n");
      out.write("                        <div id=\"myTabContent\" class=\"tab-content\">\n");
      out.write("                            <div class=\"tab-pane fade in active\" id=\"service-one\">\n");
      out.write("\n");
      out.write("                                <section class=\"container product-info\">\n");
      out.write("                                    \n");
      out.write("                                </section>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"tab-pane fade\" id=\"service-two\">\n");
      out.write("\n");
      out.write("                                <section class=\"container\">\n");
      out.write("\n");
      out.write("                                </section>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"tab-pane fade\" id=\"service-three\">\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <hr>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
