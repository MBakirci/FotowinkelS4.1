package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class CurrenciesExample_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Currency Conversion Tutorial</title>\n");
      out.write("        <script type=\"text/javascript\" src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.7.0/jquery.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/money.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/accounting.js\"></script>\n");
      out.write("        ");
double i = 9.99;
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <select id=\"ddlCurr\" name=\"ddlCurr\">\n");
      out.write("            <option value=\"EUR\">EURO €</option>\n");
      out.write("            <option value=\"USD\">DOLLAR $</option>\n");
      out.write("            <option value=\"GBP\">POUND £</option>\n");
      out.write("            <option value=\"TRY\">LIRA &#8378;</option>\n");
      out.write("        </select>\n");
      out.write("        <h1 id=\"Money\"></h1>\n");
      out.write("        <p></p>\n");
      out.write("        <ul class=\"currencies\"></ul>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            $(document).ready(function () {\n");
      out.write("\n");
      out.write("                fx.base = \"EUR\";\n");
      out.write("                fx.settings = {\n");
      out.write("                    from: \"EUR\"\n");
      out.write("                };\n");
      out.write("                var amount = 9.99;\n");
      out.write("                \n");
      out.write("                var EUR = fx.convert(amount, {to: \"EUR\"});\n");
      out.write("                EUR = accounting.formatMoney(EUR, \"€ \", 2, \".\", \",\");\n");
      out.write("                $(\"#Money\").text(EUR);\n");
      out.write("                \n");
      out.write("                $(\"#ddlCurr\").change(function () {\n");
      out.write("\n");
      out.write("                    $.getJSON(\n");
      out.write("                            'latest.json',\n");
      out.write("                            function (data) {\n");
      out.write("                                // Check money.js has finished loading:\n");
      out.write("                                if (typeof fx !== \"undefined\" && fx.rates) {\n");
      out.write("                                    fx.rates = data.rates;\n");
      out.write("                                    fx.base = data.base;\n");
      out.write("                                } else {\n");
      out.write("                                    // If not, apply to fxSetup global:\n");
      out.write("                                    var fxSetup = {\n");
      out.write("                                        rates: data.rates,\n");
      out.write("                                        base: data.base\n");
      out.write("                                    }\n");
      out.write("                                }\n");
      out.write("\n");
      out.write("                                // now that we have exchange rates, add a few to our page\n");
      out.write("                                var USD = fx.convert(amount, {to: \"USD\"}); //13.22784197768393\n");
      out.write("                                var GBP = fx.convert(amount, {to: \"GBP\"}); //8.567532636985659\n");
      out.write("                                var TRY = fx.convert(amount, {to: \"TRY\"}); //1028.1670562349989\n");
      out.write("\n");
      out.write("                                // we can now use the accounting.js library to format the numbers properly\n");
      out.write("                                USD = accounting.formatMoney(USD, \"$ \", 2, \",\", \".\");\n");
      out.write("                                GBP = accounting.formatMoney(GBP, \"£ \", 2, \",\", \".\");\n");
      out.write("                                TRY = accounting.formatMoney(TRY, \"&#8378; \", 2, \".\", \",\");\n");
      out.write("                                \n");
      out.write("                                if ($(\"#ddlCurr\").val() == 'USD'){\n");
      out.write("                                    $(\"#Money\").text(USD);\n");
      out.write("                                }\n");
      out.write("                                else if ($(\"#ddlCurr\").val() == 'GBP'){\n");
      out.write("                                    $(\"#Money\").text(GBP);\n");
      out.write("                                }\n");
      out.write("                                else if ($(\"#ddlCurr\").val() == 'EUR'){\n");
      out.write("                                    $(\"#Money\").text(EUR);\n");
      out.write("                                }\n");
      out.write("                                else if ($(\"#ddlCurr\").val() == 'TRY'){\n");
      out.write("                                    $(\"#Money\").text(TRY);\n");
      out.write("                                }\n");
      out.write("                            }\n");
      out.write("                    );\n");
      out.write("\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
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
