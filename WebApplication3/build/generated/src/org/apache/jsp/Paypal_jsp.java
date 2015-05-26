package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;

public final class Paypal_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Masterpage_final.jsp", out, false);
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("<!--    <script language=\"javascript\">\r\n");
      out.write("        function Payment()\r\n");
      out.write("        {\r\n");
      out.write("            if(request.getattribute(\"return\")!== null)\r\n");
      out.write("            {\r\n");
      out.write("            out.print(\"hoi\");\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("            \r\n");
      out.write("        </script>-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!--    Paypal Test Account\r\n");
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
      out.write("    <input type=\"hidden\" name=\"currency_code\" value=\"USD\">\r\n");
      out.write("    <input type=\"hidden\" name=\"lc\" value=\"AU\">\r\n");
      out.write("    <input type=\"hidden\" name=\"bn\" value=\"PP-BuyNowBF\">\r\n");
      out.write("    <input type=\"hidden\" name=\"rm\" value=\"2\">\r\n");
      out.write("    <!--Items will be shown in the shopping cart-->\r\n");
      out.write("    <!--TODO: Gather items from a list:-->\r\n");
      out.write("    ");
  
    int productnummer=1;
    ArrayList<String> Productlist = new ArrayList<String>();
    Productlist.add("Book/0.01/2");
    Productlist.add("Cat/0.01/1");
                        
    for(String s : Productlist)
    {
    
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    <input type=\"hidden\" name=\"item_name_");
      out.print(productnummer);
      out.write("\" value=");
      out.print(s.substring(0,s.indexOf("/")));
      out.write(">  \r\n");
      out.write("    <input type=\"hidden\" name=\"amount_");
      out.print(productnummer);
      out.write("\" value=");
      out.print(s.substring(s.indexOf("/")+1,s.lastIndexOf("/")));
      out.write(">\r\n");
      out.write("    <input type=\"hidden\" name=\"quantity_");
      out.print(productnummer);
      out.write("\" value=");
      out.print(s.substring(s.lastIndexOf("/")+1));
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
      out.write("\r\n");
      out.write("    <input type=\"image\" src=\"https://www.paypalobjects.com/en_US/i/btn/x-click-but6.gif\" border=\"0\" name=\"submit\" alt=\"PayPal - The safer, easier way to pay online.\">\r\n");
      out.write("<!--    <img alt=\"\" border=\"0\" src=\"https://www.paypal.com/en_AU/i/scr/pixel.gif\" width=\"1\" height=\"1\">-->\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("</form>\r\n");
      out.write("        \r\n");
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
