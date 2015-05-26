package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Test.Product;
import java.util.ArrayList;
import Test.ProductPage;

public final class ProductPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/TaalSettings.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_scope_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_setBundle_basename_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_setLocale_value_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_set_var_value_scope_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_fmt_setBundle_basename_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_fmt_setLocale_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_set_var_value_scope_nobody.release();
    _jspx_tagPool_fmt_setBundle_basename_nobody.release();
    _jspx_tagPool_fmt_setLocale_value_nobody.release();
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
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Masterpage_final.jsp", out, false);
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_fmt_setLocale_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_fmt_setBundle_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <link href=\"CSS/productPage.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"CSS/cropper.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"CSS/main.css\" rel=\"stylesheet\">\r\n");
      out.write("        <script src=\"js/productpage.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"js/money.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"js/accounting.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <title>Product Page</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");

            String QString = request.getParameter("fotoid").toString();
            // String QString = "213"; //For Debug
            Test.Photo photo = new Test.Photo();
            String link = "";
            Test.ProductPage pp = new Test.ProductPage();
            ArrayList<Double> typePrices = new ArrayList<Double>();
            ArrayList<String> typeNames = new ArrayList<String>();
            String basePrice = "";
            ArrayList<String> colorNames = new ArrayList<String>();
            ArrayList<Double> colorPrices = new ArrayList<Double>();
            
            if (!QString.equals("") && !QString.equals(null)) {
                link = photo.convertCodeToLink(QString); //Get http link for image source
                typePrices = pp.getTypePrice(); //Get current type prices
                typeNames = pp.getTypeName();
                basePrice = pp.getBasePrice(QString);
                colorNames = pp.getColorName();
                colorPrices = pp.getColorPrice();
            }
        
      out.write("\r\n");
      out.write("        <script>\r\n");
      out.write("            function updatePrice() {\r\n");
      out.write("                var type = document.getElementById(\"Soort2\");\r\n");
      out.write("                var selType = type.options[type.selectedIndex].text;\r\n");
      out.write("                var type2 = selType.substring(selType.indexOf(\"+\") + 1);\r\n");
      out.write("                \r\n");
      out.write("                var price = document.getElementById(\"Prijs\");\r\n");
      out.write("                \r\n");
      out.write("                var newPrice = document.getElementById(\"Type\");\r\n");
      out.write("                var selPrice = newPrice.options[newPrice.selectedIndex].text;\r\n");
      out.write("                var price2 = selPrice.substring(selPrice.indexOf(\"+\") + 1);\r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("                var a = parseFloat(price2);\r\n");
      out.write("                var b = parseFloat(type2);\r\n");
      out.write("                \r\n");
      out.write("                var sum = a + b;\r\n");
      out.write("                price.innerHTML = \"€\" + sum;\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"modal fade\" id=\"cropper-example-2-modal\">\r\n");
      out.write("            <div class=\"modal-dialog\">\r\n");
      out.write("                <div class=\"modal-content\">\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"modal-body\">\r\n");
      out.write("                        <div id=\"cropper-example-2\">\r\n");
      out.write("                            <div class=\"img-container\">\r\n");
      out.write("                                <img src=\"");
      out.print(link);
      out.write("\" alt=\"Picture\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <form action=\"Cropper\" method=\"get\">             \r\n");
      out.write("                                <!-- <h3 class=\"page-header\">Data:</h3> -->                            \r\n");
      out.write("                                <input class=\"form-control\" id=\"dataX\" name=\"dataX\" type=\"hidden\">\r\n");
      out.write("                                <input class=\"form-control\" id=\"dataY\" name=\"dataY\" type=\"hidden\" >\r\n");
      out.write("                                <input class=\"form-control\" id=\"dataWidth\" name=\"dataWidht\" type=\"hidden\">\r\n");
      out.write("                                <input class=\"form-control\" id=\"dataHeight\" name=\"dataHeight\" type=\"hidden\">\r\n");
      out.write("                                <input class=\"form-control\" id=\"file\" name=\"file\" type=\"hidden\" value=\"");
      out.print(link);
      out.write("\">\r\n");
      out.write("                                <input type=\"submit\" class=\"btn btn-success\" value=\"Crop\">\r\n");
      out.write("                            </form>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-md-3\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div><!--<button class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#cropper-example-2-modal\" type=\"button\">Launch the demo</button>-->\r\n");
      out.write("        <script>\r\n");
      out.write("            var $image = $('#cropper-example-2 > img'),\r\n");
      out.write("                    cropBoxData,\r\n");
      out.write("                    canvasData;\r\n");
      out.write("            \r\n");
      out.write("            $('#cropper-example-2-modal').on('shown.bs.modal', function () {\r\n");
      out.write("                $image.cropper({\r\n");
      out.write("                    autoCropArea: 0.5,\r\n");
      out.write("                    built: function () {\r\n");
      out.write("                        // Strict mode: set crop box data first\r\n");
      out.write("                        $image.cropper('setCropBoxData', cropBoxData);\r\n");
      out.write("                        $image.cropper('setCanvasData', canvasData);\r\n");
      out.write("                    }\r\n");
      out.write("                });\r\n");
      out.write("            }).on('hidden.bs.modal', function () {\r\n");
      out.write("                cropBoxData = $image.cropper('getCropBoxData');\r\n");
      out.write("                canvasData = $image.cropper('getCanvasData');\r\n");
      out.write("                $image.cropper('destroy');\r\n");
      out.write("            });\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("            <div class=\"content-wrapper\">\t\r\n");
      out.write("                <div class=\"item-container\">\r\n");
      out.write("                    <div class=\"container\">\t\r\n");
      out.write("                        <div class=\"col-md-4\">\r\n");
      out.write("                            <div class=\"product col-md-8 service-image-left\">\r\n");
      out.write("                                <center>\r\n");
      out.write("                                    <img height=\"200\" width=\"200\" id=\"productFoto\" src=\"");
      out.print(link);
      out.write("\"/>\r\n");
      out.write("                                </center>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-md-8\">\r\n");
      out.write("                            <div class=\"product-title\">Foto: </div>\r\n");
      out.write("                            <div class=\"product-desc\">U kan hier uw foto's aanpassen, en vervolgens in uw winkelwagen stoppen.</div>\r\n");
      out.write("                            <hr>\r\n");
      out.write("                            <div class=\"product-title\">Productsoort</div>\r\n");
      out.write("                            <select id=\"Soort2\" name=\"Soort2\" class=\"btn btn-default\" onchange=\"updatePrice()\">\r\n");
      out.write("                                ");
for (Double es : typePrices) {
      out.write("\r\n");
      out.write("                                <option value=\"");
      out.print(typePrices.indexOf(es));
      out.write('"');
      out.write('>');
      out.print(typeNames.get(typePrices.indexOf(es)).toString());
      out.write(" + ");
      out.print(es.toString());
      out.write("</option>\r\n");
      out.write("                                ");

                                    }
      out.write("\r\n");
      out.write("                            </select>\r\n");
      out.write("                            <div class=\"product-title\" style=\"margin-top: 10px\">Fotokleur</div>\r\n");
      out.write("                            <select id=\"Type\" name=\"Type\" class=\"btn btn-default\" onchange=\"changeColor();\r\n");
      out.write("                                    updatePrice();\">\r\n");
      out.write("                                ");
for (Double num : colorPrices) {
                                
      out.write("\r\n");
      out.write("                                <option value=\"");
      out.print(colorPrices.indexOf(num));
      out.write('"');
      out.write('>');
      out.print(colorNames.get(colorPrices.indexOf(num)));
      out.write(" + ");
      out.print(num.toString());
      out.write("</option>\r\n");
      out.write("                                ");

                                    }
                                
      out.write("\r\n");
      out.write("                            </select>\r\n");
      out.write("                            <div class=\"product-title\" style=\"margin-top: 10px;\">Afbeelding aanpassen</div>\r\n");
      out.write("                            <button class=\"btn btn-default\" data-toggle=\"modal\" data-target=\"#cropper-example-2-modal\" type=\"button\">Afbeelding bijnsnijden</button>\r\n");
      out.write("                            <hr>\r\n");
      out.write("                            <div class=\"product-title\" style=\"margin-top: 10px;\">Aantal</div>\r\n");
      out.write("                            <input type=\"number\" required=\"\"/>\r\n");
      out.write("                            <hr>\r\n");
      out.write("                            <div id=\"Prijs\" class=\"product-price\"></div>\r\n");
      out.write("                            <div>\r\n");
      out.write("                                <select id=\"ddlCurr\" name=\"ddlCurr\">\r\n");
      out.write("                                    <option value=\"EUR\">EURO €</option>\r\n");
      out.write("                                    <option value=\"USD\">DOLLAR $</option>\r\n");
      out.write("                                    <option value=\"GBP\">POUND £</option>\r\n");
      out.write("                                    <option value=\"TRY\">LIRA &#8378</option>\r\n");
      out.write("                                </select>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"product-stock\">In Voorraad</div>\r\n");
      out.write("                            <hr>\r\n");
      out.write("                            <div class=\"btn-group cart\">\r\n");
      out.write("                                <button type=\"button\" class=\"btn btn-success\">\r\n");
      out.write("                                    Aan winkelwagen toevoegen \r\n");
      out.write("                                </button>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div> \r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"container-fluid\">\t\t\r\n");
      out.write("                    <div class=\"col-md-12 product-info\">\r\n");
      out.write("                        <ul id=\"myTab\" class=\"nav nav-tabs nav_tabs\">\r\n");
      out.write("\r\n");
      out.write("                            <li class=\"active\"><a href=\"#service-one\" data-toggle=\"tab\">DESCRIPTION</a></li>\r\n");
      out.write("                            <li><a href=\"#service-two\" data-toggle=\"tab\">PRODUCT INFO</a></li>\r\n");
      out.write("                            <li><a href=\"#service-three\" data-toggle=\"tab\">REVIEWS</a></li>\r\n");
      out.write("\r\n");
      out.write("                        </ul>\r\n");
      out.write("                        <div id=\"myTabContent\" class=\"tab-content\">\r\n");
      out.write("                            <div class=\"tab-pane fade in active\" id=\"service-one\">\r\n");
      out.write("\r\n");
      out.write("                                <section class=\"container product-info\">\r\n");
      out.write("\r\n");
      out.write("                                </section>\r\n");
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"tab-pane fade\" id=\"service-two\">\r\n");
      out.write("\r\n");
      out.write("                                <section class=\"container\">\r\n");
      out.write("\r\n");
      out.write("                                </section>\r\n");
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"tab-pane fade\" id=\"service-three\">\r\n");
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <hr>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        ");
    
            Product p = new Product();
            double i = 0.00;
            p.setPrice(i);
        
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script>\r\n");
      out.write("            $(document).ready(function () {\r\n");
      out.write("                updatePrice();\r\n");
      out.write("                \r\n");
      out.write("                fx.base = \"EUR\";\r\n");
      out.write("                fx.settings = {\r\n");
      out.write("                    from: \"EUR\"\r\n");
      out.write("                };\r\n");
      out.write("                \r\n");
      out.write("                var amountje = $(\"#Prijs\").text();\r\n");
      out.write("                var str = amountje.substring(1);\r\n");
      out.write("                var amount = parseFloat(str);\r\n");
      out.write("                alert(amount);\r\n");
      out.write("                \r\n");
      out.write("                var EUR = fx.convert(amount, {to: \"EUR\"});\r\n");
      out.write("                EUR = accounting.formatMoney(EUR, \"€\", 2, \".\", \",\");\r\n");
      out.write("                $(\"#Prijs\").text(EUR);\r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("                $(\"#ddlCurr\").change(function () {\r\n");
      out.write("                    var amountje = $(\"#Prijs\").text();\r\n");
      out.write("                    var str = amountje.substring(1);\r\n");
      out.write("                    ");
i =
      out.write(" parseFlout(str);\r\n");
      out.write("                            alert(");
      out.print(i);
      out.write(");\r\n");
      out.write("                    \r\n");
      out.write("                    $.getJSON(\r\n");
      out.write("                            'latest.json',\r\n");
      out.write("                            function (data) {\r\n");
      out.write("                                // Check money.js has finished loading:\r\n");
      out.write("                                if (typeof fx !== \"undefined\" && fx.rates) {\r\n");
      out.write("                                    fx.rates = data.rates;\r\n");
      out.write("                                    fx.base = data.base;\r\n");
      out.write("                                } else {\r\n");
      out.write("                                    // If not, apply to fxSetup global:\r\n");
      out.write("                                    var fxSetup = {\r\n");
      out.write("                                        rates: data.rates,\r\n");
      out.write("                                        base: data.base\r\n");
      out.write("                                    }\r\n");
      out.write("                                }\r\n");
      out.write("                                \r\n");
      out.write("                                // now that we have exchange rates, add a few to our page\r\n");
      out.write("                                var USD = fx.convert(amount, {to: \"USD\"}); //13.22784197768393\r\n");
      out.write("                                var GBP = fx.convert(amount, {to: \"GBP\"}); //8.567532636985659\r\n");
      out.write("                                var TRY = fx.convert(amount, {to: \"TRY\"}); //1028.1670562349989\r\n");
      out.write("                                var EUR = fx.convert(amount, {to: \"EUR\"});\r\n");
      out.write("                                \r\n");
      out.write("                                // we can now use the accounting.js library to format the numbers properly\r\n");
      out.write("                                USD = accounting.formatMoney(USD, \"$\", 2, \",\", \".\");\r\n");
      out.write("                                GBP = accounting.formatMoney(GBP, \"£\", 2, \",\", \".\");\r\n");
      out.write("                                TRY = accounting.formatMoney(TRY, \"\\u20BA\", 2, \".\", \",\");\r\n");
      out.write("                                EUR = accounting.formatMoney(EUR, \"€\", 2, \".\", \",\");\r\n");
      out.write("                                \r\n");
      out.write("                                if ($(\"#ddlCurr\").val() == 'USD') {\r\n");
      out.write("                                    $(\"#Prijs\").text(USD);\r\n");
      out.write("                                }\r\n");
      out.write("                                else if ($(\"#ddlCurr\").val() == 'GBP') {\r\n");
      out.write("                                    $(\"#Prijs\").text(GBP);\r\n");
      out.write("                                }\r\n");
      out.write("                                else if ($(\"#ddlCurr\").val() == 'EUR') {\r\n");
      out.write("                                    $(\"#Prijs\").text(EUR);\r\n");
      out.write("                                }\r\n");
      out.write("                                else if ($(\"#ddlCurr\").val() == 'TRY') {\r\n");
      out.write("                                    $(\"#Prijs\").text(TRY);\r\n");
      out.write("                                }\r\n");
      out.write("                            }\r\n");
      out.write("                    );\r\n");
      out.write("                    \r\n");
      out.write("                });\r\n");
      out.write("            });\r\n");
      out.write("            \r\n");
      out.write("        </script>\r\n");
      out.write("        <script src=\"js/jquery.min.js\"></script>\r\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("        <script src=\"js/cropper.js\"></script>\r\n");
      out.write("        <script src=\"js/main.js\"></script>\r\n");
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

  private boolean _jspx_meth_c_set_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_scope_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent(null);
    _jspx_th_c_set_0.setVar("language");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_set_0.setScope("session");
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_scope_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_scope_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }

  private boolean _jspx_meth_fmt_setLocale_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:setLocale
    org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag _jspx_th_fmt_setLocale_0 = (org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag) _jspx_tagPool_fmt_setLocale_value_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag.class);
    _jspx_th_fmt_setLocale_0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_setLocale_0.setParent(null);
    _jspx_th_fmt_setLocale_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${language}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_fmt_setLocale_0 = _jspx_th_fmt_setLocale_0.doStartTag();
    if (_jspx_th_fmt_setLocale_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_setLocale_value_nobody.reuse(_jspx_th_fmt_setLocale_0);
      return true;
    }
    _jspx_tagPool_fmt_setLocale_value_nobody.reuse(_jspx_th_fmt_setLocale_0);
    return false;
  }

  private boolean _jspx_meth_fmt_setBundle_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:setBundle
    org.apache.taglibs.standard.tag.rt.fmt.SetBundleTag _jspx_th_fmt_setBundle_0 = (org.apache.taglibs.standard.tag.rt.fmt.SetBundleTag) _jspx_tagPool_fmt_setBundle_basename_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.SetBundleTag.class);
    _jspx_th_fmt_setBundle_0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_setBundle_0.setParent(null);
    _jspx_th_fmt_setBundle_0.setBasename("talen.Berichten");
    int _jspx_eval_fmt_setBundle_0 = _jspx_th_fmt_setBundle_0.doStartTag();
    if (_jspx_th_fmt_setBundle_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_setBundle_basename_nobody.reuse(_jspx_th_fmt_setBundle_0);
      return true;
    }
    _jspx_tagPool_fmt_setBundle_basename_nobody.reuse(_jspx_th_fmt_setBundle_0);
    return false;
  }
}
