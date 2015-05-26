package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.ArrayList;

public final class Winkelwagen_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Masterpage_final.jsp", out, false);
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>JSP Page</title>  \r\n");
      out.write("    </head>\r\n");
      out.write("        <form action=\"ShoppingCart\" method=\"POST\">\r\n");
      out.write("            <input type=\"text\" name=\"naam\" value=\"\" />\r\n");
      out.write("            <input type=\"text\" name=\"aantal\" value=\"\" />\r\n");
      out.write("            <input type=\"text\" name=\"prijs\" value=\"\" />\r\n");
      out.write("            <input type=\"text\" name=\"kleur\" value=\"\" />\r\n");
      out.write("            <input type=\"text\" name=\"product\" value=\"\" />\r\n");
      out.write("            <input type=\"text\" name=\"foto\" value=\"\" />\r\n");
      out.write("            <input type=\"submit\" value=\"sgdsfsd\" />\r\n");
      out.write("        </form>\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    <div class=\"container-fluid\">\r\n");
      out.write("                <div class=\"row-fluid\">\r\n");
      out.write("                    <div class=\"col-md-10 col-lg-offset-1\">\r\n");
      out.write("                        <fieldset>\r\n");
      out.write("                            <legend>Prijzen Instellen</legend>\r\n");
      out.write("                        ");

        Test.WinkelWagen winkelwagen = new Test.WinkelWagen();
            
        ArrayList<Test.WinkelWagenItem> itemlist = winkelwagen.WinkelList();
         
                        
      out.write("\r\n");
      out.write("                        <table class=\"table table-bordered\">\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <th>Foto</th>\r\n");
      out.write("                                <th>Fotocode</th>\r\n");
      out.write("                                <th>Product Naam</th>\r\n");
      out.write("                                <th>Aantal</th>\r\n");
      out.write("                                <th>Prijs €</th>\r\n");
      out.write("                                <th></th>\r\n");
      out.write("                                <th></th>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            ");

                                for (Test.WinkelWagenItem es : itemlist) {
                            
      out.write("\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td width=\"150px\">\r\n");
      out.write("                                    <a class=\"thumbnail\" href=");
      out.print(es);
      out.write(">\r\n");
      out.write("                                <img id=\"");
      out.print( es.getFotocode() );
      out.write("\" class=\"img-responsive\" style=\"position: relative; top: 0; left: 0;\" alt=\"test\" width=\"100\" height=\"100\" style=\"z-index: -1\" src=\"ftp://asror:asror@212.64.126.219:9942/THUMB/");
      out.print( es.getfoto().substring(es.getfoto().lastIndexOf("/") + 1, es.getfoto().lastIndexOf(".") + 4));
      out.write("\" > \r\n");
      out.write("\r\n");
      out.write("                            </a>\r\n");
      out.write("                                \r\n");
      out.write("                                </td>\r\n");
      out.write("                                <td id=\"naam\">");
      out.print( es.getFotocode() );
      out.write("</td>\r\n");
      out.write("                                <td id=\"beschrijing\">");
      out.print( es.getProducttype() + " " + es.getKleurtype() );
      out.write("</td>\r\n");
      out.write("                                <td id=\"details\">");
      out.print( es.getAantal() );
      out.write("</td>\r\n");
      out.write("                                <td id=\"prijs\">");
      out.print( es.getPrijs() );
      out.write("</td>\r\n");
      out.write("                                <td>\r\n");
      out.write("                                    <form action=\"ShoppingCart\" method=\"post\">\r\n");
      out.write("                                        <!-- Verwijder button met request naar servlet -->\r\n");
      out.write("                                        <button type=\"submit\" class=\"btn btn-default btn-sm btn-danger\">\r\n");
      out.write("                                            <span class=\"glyphicon glyphicon-trash\"></span>\r\n");
      out.write("                                        </button>                                        \r\n");
      out.write("                                        <input type=\"hidden\" name=\"typeID\" value=\"");
      out.print( es.getFotocode() );
      out.write("\" />\r\n");
      out.write("                                    </form>\r\n");
      out.write("                                </td>\r\n");
      out.write("                                <td>\r\n");
      out.write("\r\n");
      out.write("                                    <!--Dit is de edit button\r\n");
      out.write("                                    <button type=\"button\" class=\"btn btn-default btn-sm btn-primary\" name=\"btnEdit\" data-toggle=\"modal\" data-target=\"#myModal\">\r\n");
      out.write("                                        <span class=\"glyphicon glyphicon-edit\"></span>\r\n");
      out.write("                                    </button> \r\n");
      out.write("                                    -->\r\n");
      out.write("                                    <a href=\"#\" class=\"btn btn-primary edit\"> <span class=\"glyphicon glyphicon-edit\"></span></a>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                </td>\r\n");
      out.write("                            </tr>    \t\r\n");
      out.write("                            ");

                                }
      out.write("\r\n");
      out.write("                        </table>\r\n");
      out.write("                    </fieldset>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("                                <div class=\"container\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-md-12\">\r\n");
      out.write("                    <!--    Paypal Test Account\r\n");
      out.write("        Email:      JantjeContantje@Sandbox.nl  \r\n");
      out.write("        Password:   Sandbox013-->\r\n");
      out.write("\r\n");
      out.write("    <!--Paypal information-->\r\n");
      out.write("     <form name=\"_xclick\" target=\"paypal\" action=\"https://www.sandbox.paypal.com/us/cgi-bin/webscr\" method=\"post\" >\r\n");
      out.write("    <input type=\"hidden\" name=\"cmd\" value=\"_cart\">\r\n");
      out.write("    <input type=\"hidden\" name=\"upload\" value=\"1\">\r\n");
      out.write("    <input type=\"hidden\" name=\"business\" value=\"Townofsalem@Sandbox.nl\">\r\n");
      out.write("    <input name=\"return\" type=\"hidden\" value=\"http://localhost:8080/PaypalTest/Paypal.jsp\"  ><!-- Return URL -->\r\n");
      out.write("    <input name=\"cancel_return\" type=\"hidden\" value=\"http://localhost:8080/PaypalTest/Paypal.jsp\"> <!-- Return URL on cancelling payment --> \r\n");
      out.write("    <input type=\"hidden\" name=\"no_shipping\" value=\"0\">\r\n");
      out.write("    <input type=\"hidden\" name=\"no_note\" value=\"1\">\r\n");
      out.write("    <input type=\"hidden\" name=\"currency_code\" value=\"EUR\">\r\n");
      out.write("    <input type=\"hidden\" name=\"lc\" value=\"AU\">\r\n");
      out.write("    <input type=\"hidden\" name=\"bn\" value=\"PP-BuyNowBF\">\r\n");
      out.write("    <input type=\"hidden\" name=\"rm\" value=\"2\">\r\n");
      out.write("    <!--Items will be shown in the shopping cart-->\r\n");
      out.write("    <!--TODO: Gather items from a list:-->\r\n");
      out.write("    ");
  
    int productnummer=1;
    //ArrayList<String> Productlist = new ArrayList<String>();
  //  Productlist.add("Book/0.01/2");
//    Productlist.add("Cat/0.01/1");
    
                        
    for(Test.WinkelWagenItem s : itemlist)
    {
    
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    <input type=\"hidden\" name=\"item_name_");
      out.print(productnummer);
      out.write("\" value=");
      out.print( s.getFotocode() );
      out.write(">  \r\n");
      out.write("    <input type=\"hidden\" name=\"amount_");
      out.print(productnummer);
      out.write("\" value=");
      out.print( s.getPrijs().toString() );
      out.write(">\r\n");
      out.write("    <input type=\"hidden\" name=\"quantity_");
      out.print(productnummer);
      out.write("\" value=");
      out.print( s.getAantal().toString() );
      out.write(">\r\n");
      out.write("    \r\n");
      out.write("<!--<input type=\"hidden\" name=\"item_name_1\" value=\"HTML book\">  \r\n");
      out.write("    <input type=\"hidden\" name=\"amount_1\" value=\"24.99\">\r\n");
      out.write("    <input type=\"hidden\" name=\"quantity_1\" value=\"2\">-->\r\n");
      out.write("    \r\n");
      out.write("<!--<input type=\"hidden\" name=\"item_name_2\" value=\"Cat\">\r\n");
      out.write("    <input type=\"hidden\" name=\"amount_2\" value=\"19.99\">\r\n");
      out.write("    <input type=\"hidden\" name=\"quantity_2\" value=\"2\">-->\r\n");
      out.write("    ");
 productnummer++;
    
//  Check if form has been submitted (Check if paid)
    if("POST".equalsIgnoreCase(request.getMethod()))
    {
        out.print("Ik ben hier geweest");
    }
    }
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    <input type=\"image\" src=\"https://www.paypalobjects.com/en_US/i/btn/x-click-but6.gif\" border=\"0\" name=\"submit\" alt=\"PayPal - The safer, easier way to pay online.\">\r\n");
      out.write("     </form>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>  \r\n");
      out.write("                        \r\n");
      out.write("        <script>\r\n");
      out.write("            $('a.edit').on('click', function () {\r\n");
      out.write("                var myModal = $('#myModal');\r\n");
      out.write("                // now get the values from the table\r\n");
      out.write("                var id = $(this).closest('tr').find('#id').html();\r\n");
      out.write("                var naam = $(this).closest('tr').find('#naam').html();\r\n");
      out.write("                var details = $(this).closest('tr').find('#details').html();\r\n");
      out.write("                var prijs = $(this).closest('tr').find('#prijs').html();\r\n");
      out.write("                // and set them in the modal:\r\n");
      out.write("                $(\".modal-body #id1\").val(id);\r\n");
      out.write("                $(\".modal-body #naam1\").val(naam);\r\n");
      out.write("                $(\".modal-body #details1\").val(details);\r\n");
      out.write("                $(\".modal-body #prijs1\").val(prijs);\r\n");
      out.write("                // and finally show the modal\r\n");
      out.write("                myModal.modal({show: true});\r\n");
      out.write("                return false;\r\n");
      out.write("            });\r\n");
      out.write("        </script>\r\n");
      out.write("        <!-- Modal -->\r\n");
      out.write("        <div class=\"modal fade\" id=\"myModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("            <div class=\"modal-dialog\">\r\n");
      out.write("                <div class=\"modal-content\">\r\n");
      out.write("                    <div class=\"modal-header\">\r\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\r\n");
      out.write("                        <h4 class=\"modal-title\" id=\"myModalLabel\">Product Aanpassen</h4>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"modal-body\">\r\n");
      out.write("                        <form class=\"form-horizontal\" id=\"editModal\" action=\"ShoppingCart\" method=\"Post\">\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label class=\"control-label col-sm-2\" for=\"id1\">ID:</label>\r\n");
      out.write("                                <div class=\"col-sm-4\">\r\n");
      out.write("                                    <input type=\"number\" class=\"form-control\" name=\"id1\" id=\"id1\" readonly >\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label class=\"control-label col-sm-2\" for=\"naam1\">Fotocode:</label>\r\n");
      out.write("                                <div class=\"col-sm-10\">\r\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" name=\"naam1\" id=\"naam1\" required>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label class=\"control-label col-sm-2\" for=\"details1\">Aantal:</label>\r\n");
      out.write("                                <div class=\"col-sm-10\">          \r\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" name=\"details1\" id=\"details1\">\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label class=\"control-label col-sm-2\" for=\"prijs1\">Prijs:</label>\r\n");
      out.write("                                <div class=\"col-sm-10\">          \r\n");
      out.write("                                    <input type=\"number\" step=\"0.01\" class=\"form-control\" name=\"prijs1\" id=\"prijs1\" required>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group\">    \r\n");
      out.write("                                <div class=\"col-sm-offset-2 col-sm-10\">\r\n");
      out.write("                                    <button type=\"submit\" name=\"btnBewerkt\" class=\"btn btn-primary\">Bewerk</button>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </form>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>        \r\n");
      out.write("                    \r\n");
      out.write("       \r\n");
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
