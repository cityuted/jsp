package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\r\n");
      out.write("<!--==============================content================================-->\r\n");
      out.write("<section id=\"content\" class=\"cont_pad\">\r\n");
      out.write("    <div class=\"breadcrump\">\r\n");
      out.write("        <ul>\r\n");
      out.write("            <li>Login</li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"row\">\r\n");
      out.write("        <article class=\"grid_8\">\r\n");
      out.write("            <h2 class=\"blue ind1\">Login</h2>\r\n");
      out.write("            <form id=\"create_account\" method=\"post\" action=\"/toy/Login\">\r\n");
      out.write("                                        ");

                            if (request.getAttribute("alert") != null) {
                                out.print(request.getAttribute("alert"));
                            }
                        
      out.write("\r\n");
      out.write("                <div class=\"account_box\">\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"inner\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"pad_box2\">\r\n");
      out.write("                            <h3 class=\"pink1 ind bg_none\">Welcome back</h3>\r\n");
      out.write("                            <label>\r\n");
      out.write("                                <span>Login Name</span>\r\n");
      out.write("                                <input name=\"loginName\" type=\"text\">\r\n");
      out.write("                            </label>\r\n");
      out.write("                            <label>\r\n");
      out.write("                                <span>Password</span>\r\n");
      out.write("                                <input name=\"password\" type=\"password\">\r\n");
      out.write("                            </label>\r\n");
      out.write("                            <label class=\"checkboxes last\">\r\n");
      out.write("                                <div class=\"check\">\r\n");
      out.write("                                    Remember Me\r\n");
      out.write("                                    <input type=\"checkbox\" value=\"Remember Me\" />\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </label>\r\n");
      out.write("                            <div class=\"rel\">\r\n");
      out.write("                                <a href=\"javascript:;\" onclick=\"get_form(this).submit(); return false\" class=\"form_btn log_in\">Log In</a>\r\n");
      out.write("                                <ul class=\"forgot\">\r\n");
      out.write("                                    <li><a href=\"#\">Forgot your password?</a></li>\r\n");
      out.write("                                    <li><a href=\"#\">Forgot your username?</a></li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("            </form>\r\n");
      out.write("\r\n");
      out.write("        </article>\r\n");
      out.write("        <article class=\"grid_4\">\r\n");
      out.write("            <div class=\"top_rated_block p_top_zero\">\r\n");
      out.write("                <h3 class=\"blue bg_none\">Recently Viewed</h3>\r\n");
      out.write("                <ul class=\"ext_list\">\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <figure><a href=\"#\"><img src=\"images/top_rated1.jpg\" alt=\"\"></a></figure>\r\n");
      out.write("                        <div>\r\n");
      out.write("                            <h4 class=\"blue\"><a href=\"#\">Children soft toy</a></h4>\r\n");
      out.write("                            <div class=\"price\">$15</div>\r\n");
      out.write("                            <div class=\"rating\">\r\n");
      out.write("                                <span class=\"active\"></span>\r\n");
      out.write("                                <span class=\"active\"></span>\r\n");
      out.write("                                <span class=\"active\"></span>\r\n");
      out.write("                                <span class=\"active\"></span>\r\n");
      out.write("                                <span></span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <figure><a href=\"#\"><img src=\"images/top_rated2.jpg\" alt=\"\"></a></figure>\r\n");
      out.write("                        <div>\r\n");
      out.write("                            <h4 class=\"blue\"><a href=\"#\">Toy dinosaur</a></h4>\r\n");
      out.write("                            <div class=\"price\">$9</div>\r\n");
      out.write("                            <div class=\"rating\">\r\n");
      out.write("                                <span class=\"active\"></span>\r\n");
      out.write("                                <span class=\"active\"></span>\r\n");
      out.write("                                <span class=\"active\"></span>\r\n");
      out.write("                                <span class=\"active\"></span>\r\n");
      out.write("                                <span class=\"active\"></span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"bg_none\">\r\n");
      out.write("                        <figure><a href=\"#\"><img src=\"images/top_rated3.jpg\" alt=\"\"></a></figure>\r\n");
      out.write("                        <div>\r\n");
      out.write("                            <h4 class=\"blue\"><a href=\"#\">Toy horse</a></h4>\r\n");
      out.write("                            <div class=\"price\">$124</div>\r\n");
      out.write("                            <div class=\"rating\">\r\n");
      out.write("                                <span class=\"active\"></span>\r\n");
      out.write("                                <span class=\"active\"></span>\r\n");
      out.write("                                <span class=\"active\"></span>\r\n");
      out.write("                                <span></span>\r\n");
      out.write("                                <span></span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </article>\r\n");
      out.write("    </div>\r\n");
      out.write("</section>\r\n");
      out.write("</div>\r\n");
      out.write("<!--==============================footer=================================-->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
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
