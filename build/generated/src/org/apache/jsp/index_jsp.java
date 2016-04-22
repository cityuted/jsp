package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import bean.Template;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    document.getElementById(\"lihome\").className += \" current\";\r\n");
      out.write("</script>\r\n");
      out.write("<!--==============================content================================-->\r\n");
      out.write("\r\n");
      out.write("<section id=\"content\" class=\"cont_pad\">\r\n");
      out.write("\r\n");
      out.write("    <div class=\"row m_bot1 slider_row\">\r\n");
      out.write("\r\n");
      out.write("        <article class=\"grid_8\">\r\n");
      out.write("\r\n");
      out.write("            <div class=\"fluidHeight\">\r\n");
      out.write("\r\n");
      out.write("                <div class=\"sliderContainer\">\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"iosSlider\">\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"slider\">\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"item\">\r\n");
      out.write("\r\n");
      out.write("                                <img src=\"images/slide1.png\">\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"m-caption caption1\">\r\n");
      out.write("\r\n");
      out.write("                                    <span class=\"font1\">The</span>\r\n");
      out.write("\r\n");
      out.write("                                    <span class=\"font2\">GOOD</span>\r\n");
      out.write("\r\n");
      out.write("                                    <span class=\"font3\">Toys</span>\r\n");
      out.write("\r\n");
      out.write("                                    <span class=\"font4\">At The</span>\r\n");
      out.write("\r\n");
      out.write("                                    <span class=\"font5\">RIGHT</span>\r\n");
      out.write("\r\n");
      out.write("                                    <span class=\"font6\">Time!</span>\r\n");
      out.write("\r\n");
      out.write("                                    <a href=\"/toy/Category?order=asc&sort=TOYNAME\" class=\"slide_button\">Click Here</a>\r\n");
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                                <a href=\"#\"><img src=\"images/slide1_s.png\"></a>\r\n");
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"item\">\r\n");
      out.write("\r\n");
      out.write("                                <img src=\"images/slide2.png\">\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"m-caption caption2\">\r\n");
      out.write("\r\n");
      out.write("                                    <span class=\"font1\">Big</span>\r\n");
      out.write("\r\n");
      out.write("                                    <span class=\"font2\">sale</span>\r\n");
      out.write("\r\n");
      out.write("                                    <span class=\"font3\">up <span>to</span></span>\r\n");
      out.write("\r\n");
      out.write("                                    <span class=\"font4\">-50%</span>\r\n");
      out.write("\r\n");
      out.write("                                    <span class=\"font5\">on</span>\r\n");
      out.write("\r\n");
      out.write("                                    <span class=\"font6\">Second Hand Toy</span>\r\n");
      out.write("\r\n");
      out.write("                                   <a href=\"/toy/Category?order=asc&sort=TOYNAME\" class=\"slide_button\">Click Here</a>\r\n");
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                                <a href=\"/toy/Category\"><img src=\"images/slide2_s.png\"></a>\r\n");
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                        \r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class = 'prevContainer'>\r\n");
      out.write("\r\n");
      out.write("                            <div class = 'prev'></div>\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class = 'nextContainer'>\r\n");
      out.write("\r\n");
      out.write("                            <div class = 'next'></div>\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class = 'selectorsBlock'>\r\n");
      out.write("\r\n");
      out.write("                            <div class = 'selectors'>\r\n");
      out.write("\r\n");
      out.write("                                <div class = 'item selected'></div>\r\n");
      out.write("\r\n");
      out.write("                                <div class = 'item'></div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </article>\r\n");
      out.write("\r\n");
      out.write("        <article class=\"grid_4\">\r\n");
      out.write("\r\n");
      out.write("            <ul class=\"banners1\">\r\n");
      out.write("\r\n");
      out.write("                <li>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"banner1\">\r\n");
      out.write("\r\n");
      out.write("                        <a href=\"/toy/Category?order=asc&sort=TOYNAME&cate=1\"><img src=\"images/banner1.png\" alt=\"\"><span><img src=\"images/banner1_h.png\" alt=\"\"></span></a>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                </li>\r\n");
      out.write("\r\n");
      out.write("                <li>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"banner2\">\r\n");
      out.write("\r\n");
      out.write("                        <a href=\"/toy/Category?order=asc&sort=TOYNAME&cate=2\"><img src=\"images/banner2.png\" alt=\"\"><span><img src=\"images/banner2_h.png\" alt=\"\"></span></a>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                </li>\r\n");
      out.write("\r\n");
      out.write("                <li class=\"last\">\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"banner3\">\r\n");
      out.write("\r\n");
      out.write("                        <a href=\"/toy/Category?order=asc&sort=TOYNAME&cate=11\"><img src=\"images/banner3.png\" alt=\"\"><span><img src=\"images/banner3_h.png\" alt=\"\"></span></a>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                </li>\r\n");
      out.write("\r\n");
      out.write("            </ul>\r\n");
      out.write("\r\n");
      out.write("        </article>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"row latest_product_box\">\r\n");
      out.write("\r\n");
      out.write("        <article class=\"grid_12\">\r\n");
      out.write("\r\n");
      out.write("            <h2 class=\"ind pink\">Bestsellers</h2>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"carousel_box list_carousel responsive\">\r\n");
      out.write("\r\n");
      out.write("                <a class=\"carousel_btn car_prev\" id=\"car_prev\" href=\"#\"></a>\r\n");
      out.write("\r\n");
      out.write("                <a class=\"carousel_btn car_next\" id=\"car_next\" href=\"#\"></a>\r\n");
      out.write("\r\n");
      out.write("                <ul id=\"latest_products\">\r\n");
      out.write("\r\n");
      out.write("                    ");

                        out.print(Template.getLatest());
                        out.print(Template.getLatest());
                        out.print(Template.getLatest());
                        out.print(Template.getLatest());
                        out.print(Template.getLatest());
                        out.print(Template.getLatest());
                        out.print(Template.getLatest());
                    
      out.write("\r\n");
      out.write("\r\n");
      out.write("                </ul>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </article>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"row\">\r\n");
      out.write("\r\n");
      out.write("        <article class=\"grid_12\">\r\n");
      out.write("\r\n");
      out.write("            <h2 class=\"ind\">Second Hand Toy</h2>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"carousel_box list_carousel responsive last\">\r\n");
      out.write("\r\n");
      out.write("                <a class=\"carousel_btn car_prev\" id=\"car_prev1\" href=\"#\"></a>\r\n");
      out.write("\r\n");
      out.write("                <a class=\"carousel_btn car_next\" id=\"car_next1\" href=\"#\"></a>\r\n");
      out.write("\r\n");
      out.write("                <ul id=\"bestsellers\">\r\n");
      out.write("\r\n");

out.print(Template.getBestSell());
out.print(Template.getBestSell());
out.print(Template.getBestSell());
out.print(Template.getBestSell());
out.print(Template.getBestSell());

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                </ul>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </article>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("</section>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<!--==============================footer=================================-->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write('\r');
      out.write('\n');
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
