package org.apache.jsp.layout;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class slider_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<aside class=\"main-sidebar\">\n");
      out.write("    <!-- sidebar: style can be found in sidebar.less -->\n");
      out.write("    <section class=\"sidebar\">\n");
      out.write("      <!-- Sidebar user panel -->\n");
      out.write("      <div class=\"user-panel\">\n");
      out.write("        <div class=\"pull-left image\">\n");
      out.write("          <img src=\"/toy/backend/dist/img/avatar5.png\" class=\"img-circle\" alt=\"User Image\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"pull-left info\">\n");
      out.write("            <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("          <a href=\"/toy/backend/#\"><i class=\"fa fa-circle text-success\"></i> Online</a>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <!-- search form -->\n");
      out.write("      <form action=\"#\" method=\"get\" class=\"sidebar-form\">\n");
      out.write("        <div class=\"input-group\">\n");
      out.write("          <input type=\"text\" name=\"q\" class=\"form-control\" placeholder=\"Search...\">\n");
      out.write("              <span class=\"input-group-btn\">\n");
      out.write("                <button type=\"submit\" name=\"search\" id=\"search-btn\" class=\"btn btn-flat\"><i class=\"fa fa-search\"></i>\n");
      out.write("                </button>\n");
      out.write("              </span>\n");
      out.write("        </div>\n");
      out.write("      </form>\n");
      out.write("      <!-- /.search form -->\n");
      out.write("      <!-- sidebar menu: : style can be found in sidebar.less -->\n");
      out.write("      <ul class=\"sidebar-menu\">\n");
      out.write("        <li class=\"header\">MAIN NAVIGATION</li>\n");
      out.write("        <li class=\"treeview\" id=\"toy\">\n");
      out.write("          <a href=\"/toy/backend/#\">\n");
      out.write("            <i class=\"fa fa-folder\"></i> <span>Toy Records</span> <i class=\"fa fa-angle-left pull-right\"></i>\n");
      out.write("          </a>\n");
      out.write("          <ul class=\"treeview-menu\">\n");
      out.write("            <li id=\"toyMenu\"><a href=\"/toy/doSearchToy\"><i class=\"fa fa-circle-o\"></i> Toy</a></li>\n");
      out.write("            <li id=\"secondHandMenu\"><a href=\"/toy/doSearchSecondHand\"><i class=\"fa fa-circle-o\"></i> Second-hand toy</a></li>\n");
      out.write("              <li id=\"categoryMenu\"><a href=\"/toy/doSearchToyCategory\"><i class=\"fa fa-circle-o\"></i> Toy Category</a></li>\n");
      out.write("          </ul>\n");
      out.write("            \n");
      out.write("            <li><a href=\"#\"><i class=\"fa fa-user\"></i>Customer</a></li>\n");
      out.write("        </li>\n");
      out.write("\n");
      out.write("        <li class=\"header\">LABELS</li>\n");
      out.write("        <li><a href=\"/toy/backend/#\"><i class=\"fa fa-circle-o text-red\"></i> <span>Important</span></a></li>\n");
      out.write("        <li><a href=\"/toy/backend/#\"><i class=\"fa fa-circle-o text-yellow\"></i> <span>Warning</span></a></li>\n");
      out.write("        <li><a href=\"/toy/backend/#\"><i class=\"fa fa-circle-o text-aqua\"></i> <span>Information</span></a></li>\n");
      out.write("      </ul>\n");
      out.write("    </section>\n");
      out.write("    <!-- /.sidebar -->\n");
      out.write("  </aside>\n");
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
