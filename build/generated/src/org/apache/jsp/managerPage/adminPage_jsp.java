package org.apache.jsp.managerPage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import bean.Toy;

public final class adminPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 int pageNumber = 1;
    int total = 0;

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/layout/style.jsp");
    _jspx_dependants.add("/layout/toyContent.jsp");
    _jspx_dependants.add("/layout/library.jsp");
  }

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

      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("       \n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <title>AdminLTE 2 | Dashboard</title>\n");
      out.write("        <!-- Tell the browser to be responsive to screen width -->\n");
      out.write("        <meta content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\" name=\"viewport\">\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<//jsp:include page=\"setting.jsp\"/>\n");
      out.write("\n");
      out.write("<!-- Bootstrap 3.3.6 -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"/toy/backend/bootstrap/css/bootstrap.min.css\">\n");
      out.write("  <!-- Font Awesome -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css\">\n");
      out.write("  <!-- Ionicons -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css\">\n");
      out.write("  <!-- Theme style -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"/toy/backend/dist/css/AdminLTE.min.css\">\n");
      out.write("  <!-- AdminLTE Skins. Choose a skin from the css/skins\n");
      out.write("       folder instead of downloading all of them to reduce the load. -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"/toy/backend/dist/css/skins/_all-skins.min.css\">\n");
      out.write("  <!-- iCheck -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"/toy/backend/plugins/iCheck/flat/blue.css\">\n");
      out.write("  <!-- Morris chart -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"/toy/backend/plugins/morris/morris.css\">\n");
      out.write("  <!-- jvectormap -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"/toy/backend/plugins/jvectormap/jquery-jvectormap-1.2.2.css\">\n");
      out.write("  <!-- Date Picker -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"/toy/backend/plugins/datepicker/datepicker3.css\">\n");
      out.write("  <!-- Daterange picker -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"/toy/backend/plugins/daterangepicker/daterangepicker-bs3.css\">\n");
      out.write("  <!-- bootstrap wysihtml5 - text editor -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"/toy/backend/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css\">\n");
      out.write("\n");
      out.write("        \n");
      out.write("        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->\n");
      out.write("        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\n");
      out.write("        <!--[if lt IE 9]>\n");
      out.write("        <script src=\"C:/temp/layout/https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js\"></script>\n");
      out.write("        <script src=\"C:/temp/layout/https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\n");
      out.write("        <![endif]-->\n");
      out.write("    </head>\n");
      out.write("    <body class=\"hold-transition skin-blue sidebar-mini\">\n");
      out.write("        <div class=\"wrapper\">\n");
      out.write("\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/layout/header.jsp", out, false);
      out.write("\n");
      out.write("            <!-- Left side column. contains the logo and sidebar -->\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/layout/slider.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("            <!-- Content Wrapper. Contains page content -->\n");
      out.write("            <div class=\"content-wrapper\">\n");
      out.write("                <!-- Content Header (Page header) -->\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/layout/contentHeader.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("                <!-- Main content -->\n");
      out.write("                <//jsp:include page=\"/layout/toyContent.jsp\"/>\n");
      out.write("                ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write('\n');
  if (request.getParameter("page") != null) {
        pageNumber = Integer.parseInt(request.getParameter("page"));
    } else {
        pageNumber = 1;
    }

      out.write("\n");
      out.write("<script>\n");
      out.write("    (function (document) {\n");
      out.write("        'use strict';\n");
      out.write("        var LightTableFilter = (function (Arr) {\n");
      out.write("\n");
      out.write("            var _input;\n");
      out.write("            function _onInputEvent(e) {\n");
      out.write("                _input = e.target;\n");
      out.write("                var tables = document.getElementsByClassName(_input.getAttribute('data-table'));\n");
      out.write("                Arr.forEach.call(tables, function (table) {\n");
      out.write("                    Arr.forEach.call(table.tBodies, function (tbody) {\n");
      out.write("                        Arr.forEach.call(tbody.rows, _filter);\n");
      out.write("                    });\n");
      out.write("                });\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function _filter(row) {\n");
      out.write("                var text = row.textContent.toLowerCase(),\n");
      out.write("                        val = _input.value.toLowerCase();\n");
      out.write("                row.style.display = text.indexOf(val) === -1 ? 'none' : 'table-row';\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            return {\n");
      out.write("                init: function () {\n");
      out.write("                    var inputs = document.getElementsByClassName('light-table-filter');\n");
      out.write("                    Arr.forEach.call(inputs, function (input) {\n");
      out.write("                        input.oninput = _onInputEvent;\n");
      out.write("                    });\n");
      out.write("                }\n");
      out.write("            };\n");
      out.write("        })(Array.prototype);\n");
      out.write("        document.addEventListener('readystatechange', function () {\n");
      out.write("            if (document.readyState === 'complete') {\n");
      out.write("                LightTableFilter.init();\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("    })(document);</script>\n");
      out.write("<section class=\"content\">\n");
      out.write("    <div class=\"col-xs-15\">\n");
      out.write("        <div class=\"box\">\n");
      out.write("            <div class=\"box-header\">\n");
      out.write("\n");
      out.write("                <h3 class=\"box-title\">Toy Table</h3>\n");
      out.write("\n");
      out.write("                <div class=\"box-tools\">\n");
      out.write("                    <span class='pull-left' style=\"margin-right:5px\">\n");
      out.write("                        <button type=\"button\"  onclick='javascript:location.href = \"/toy/managerPage/createToy.jsp\"' class=\"btn btn-block btn-info\"  >Create toy</button>\n");
      out.write("                    </span>\n");
      out.write("                    <span class='pull-left' style=\"margin-right:5px\">\n");
      out.write("                        <button type=\"button\"  onclick='javascript:location.href = \"/toy/managerPage/updateDiscount.jsp\"' class=\"btn btn-block  bg-orange \"  >Update Discount by Category</button>\n");
      out.write("                    </span>\n");
      out.write("                    <div class=\"input-group input-group-sm\" style=\"width: 150px;\">\n");
      out.write("\n");
      out.write("                        <!--<input type=\"text\" name=\"table_search\" class=\"form-control pull-right\" placeholder=\"Search\">-->\n");
      out.write("                        <input type=\"search\" class=\"form-control light-table-filter\" data-table=\"order-table\" placeholder=\"Filter\">\n");
      out.write("\n");
      out.write("                        <span class=\"input-group-addon\"><i class=\"fa fa-search\"></i></span>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            ");
      java.util.ArrayList<Toy> toyList = null;
      toyList = (java.util.ArrayList<Toy>) _jspx_page_context.getAttribute("toyList", PageContext.SESSION_SCOPE);
      if (toyList == null){
        throw new java.lang.InstantiationException("bean toyList not found within scope");
      }
      out.write("\n");
      out.write("\n");
      out.write("            ");
   total = pageNumber * 15;
      out.write("\n");
      out.write("            <!-- /.box-header -->\n");
      out.write("\n");
      out.write("            <div class='box-body table-responsive no-padding' style=\"min-height:170px;\">\n");
      out.write("                <table class='table table-hover order-table' >\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>ID</th>\n");
      out.write("                            <th>Name</th>\n");
      out.write("                            <th>Category</th>\n");
      out.write("                            <th>Cashpoint</th>                           \n");
      out.write("                            <th>Qty</th>\n");
      out.write("                            <th>Discount</th>\n");
      out.write("                            <th>Action</th>\n");
      out.write("                        </tr></thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        ");

                            int k = 0;
//                            for (k = (pageNumber - 1) * 15; k < toyList.size() && k < (pageNumber) * 15; k++) {
//                                Toy t = toyList.get(k);
//                              out.println("<tr>");
//                                out.print(String.format("<td>%s</td>", t.getToyID()));
//                                out.print(String.format("<td>%s</td>", t.getToyName()));
//                                out.print("<td>");
//                                out.print(session.getAttribute(t.getToyID() + ".categoryInfo"));
//                                // out.print(t.getToyID());
//                                out.print("</td>");
//                                out.print(String.format("<td>%s</td>", t.getCashpoint()));
//                                out.print(String.format("<td>%s</td>", t.getQTY()));
//                                out.print(String.format("<td>%s</td>", t.getDiscount()));
//
//                                String viewUrl = "viewToy.jsp?id=" + t.getToyID();
//                                String updateUrl = "updateToy.jsp?id=" + t.getToyID();
//                                String deleteUrl = "deleteToy.jsp?id=" + t.getToyID();
//                                out.print(String.format("<td>%s</td>", "<button type='button' onclick='javascript:location.href=\"" + viewUrl + "\"' class='btn btn-block btn-success'>View</button>"
//                                        + "<button type='button' onclick='javascript:location.href=\"" + updateUrl + "\"' class='btn btn-block btn-primary'>Update</button>"
//                                        + "<button type='button' onclick='javascript:location.href=\"" + deleteUrl + "\"' class='btn btn-block btn-danger'>Delete</button>"));
//                                out.println("</tr>");
//                            }

                            for (k = 0; k < toyList.size(); k++) {
                                Toy t = toyList.get(k);
                                if(k > (pageNumber) * 15 || k < (pageNumber-1) * 15)
                                     out.println("<tr style='display:none'>");
                                else
                                    out.println("<tr>");
                                out.print(String.format("<td>%s</td>", t.getToyID()));
                                out.print(String.format("<td>%s</td>", t.getToyName()));
                                out.print("<td>");
                                out.print(session.getAttribute(t.getToyID() + ".categoryInfo"));
                                // out.print(t.getToyID());
                                out.print("</td>");
                                out.print(String.format("<td>%s</td>", t.getCashpoint()));
                                out.print(String.format("<td>%s</td>", t.getQTY()));
                                out.print(String.format("<td>%s</td>", t.getDiscount()));

                                String viewUrl = "/toy/managerPage/viewToy.jsp?id=" + t.getToyID();
                                String updateUrl = "/toy/managerPage/updateToy.jsp?id=" + t.getToyID();
                                String deleteUrl = "/toy/managerPage/deleteToy.jsp?id=" + t.getToyID();
                                out.print(String.format("<td>%s</td>", "<button type='button' onclick='javascript:location.href=\"" + viewUrl + "\"' class='btn btn-block btn-success'>View</button>"
                                        + "<button type='button' onclick='javascript:location.href=\"" + updateUrl + "\"' class='btn btn-block btn-primary'>Update</button>"
                                        + "<button type='button' onclick='javascript:location.href=\"" + deleteUrl + "\"' class='btn btn-block btn-danger'>Delete</button>"));
                                out.println("</tr>");
                            }

      out.write("\n");
      out.write("                 \n");
      out.write("                     \n");
      out.write("                    \n");
      out.write("\n");
      out.write("                    </tbody></table>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-sm-5\">\n");
      out.write("                    <div class=\"dataTables_info\" id=\"example2_info\" role=\"status\" aria-live=\"polite\">\n");
      out.write("                        Showing ");
      out.print( ((pageNumber - 1) * 15 + 1));
      out.write(" to ");
      out.print(total);
      out.write(" of ");
      out.print(toyList.size());
      out.write(" entries\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-sm-7\">\n");
      out.write("                    <div class=\"dataTables_paginate paging_simple_numbers\" id=\"example2_paginate\">\n");
      out.write("                        <ul class=\"pagination\">\n");
      out.write("                            <li class=\"paginate_button previous ");
 if (pageNumber == 1) {
                                    out.println("disabled");
                                }
      out.write("\" id=\"example2_previous\">\n");
      out.write("                                <a href=\"toy/managerPage/adminPage.jsp?page=");
 pageNumber = (pageNumber > 1) ? --pageNumber : pageNumber;
                                    out.print(pageNumber);
      out.write("\" aria-controls=\"example2\" data-dt-idx=\"0\" tabindex=\"0\">Previous</a>\n");
      out.write("                            </li>\n");
      out.write("                            ");
 int index = toyList.size() / 15 + 1;
                                int i = 1;
                            
      out.write("\n");
      out.write("                            ");
 for (i = 1; i <= index; i++) {
                                    out.println("<li class='paginate_button'>");
                                    String url = String.format("/toy/managerPage/adminPage.jsp?page=%s", i);
                                    out.println(String.format("<a href='%s' aria-controls='example2' data-dt-idx='%s' tabindex='0'> %s </a>", url, i, i));

                                    out.println("</li>");
                                }
                            
      out.write("\n");
      out.write("                            <li class=\"paginate_button next ");
 if (total >= toyList.size()) {
                                    out.println("disabled");
                                }
      out.write("\" id=\"example2_next\">\n");
      out.write("                                <a href=\"/toy/managerPage/adminPage.jsp?page=");
 pageNumber = (pageNumber < index) ? ++pageNumber : pageNumber;
                                    out.println(pageNumber);
      out.write("\" aria-controls=\"example2\" data-dt-idx=\"7\" tabindex=\"0\">Next</a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- /.box-body -->\n");
      out.write("        </div>\n");
      out.write("        <!-- /.box -->\n");
      out.write("    </div>\n");
      out.write("</section>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <!-- /.content -->\n");
      out.write("            </div>\n");
      out.write("            <!-- /.content-wrapper -->\n");
      out.write("            <//jsp:include page=\"layout/footer.jsp\"/>\n");
      out.write("\n");
      out.write("            <!-- Control Sidebar -->\n");
      out.write("            <aside class=\"control-sidebar control-sidebar-dark\">\n");
      out.write("                <!-- Create the tabs -->\n");
      out.write("                <ul class=\"nav nav-tabs nav-justified control-sidebar-tabs\">\n");
      out.write("                    <li><a href=\"#control-sidebar-home-tab\" data-toggle=\"tab\"><i class=\"fa fa-home\"></i></a></li>\n");
      out.write("                    <li><a href=\"#control-sidebar-settings-tab\" data-toggle=\"tab\"><i class=\"fa fa-gears\"></i></a></li>\n");
      out.write("                </ul>\n");
      out.write("                <!-- Tab panes -->\n");
      out.write("                <div class=\"tab-content\">\n");
      out.write("                    <!-- Home tab content -->\n");
      out.write("                    <div class=\"tab-pane\" id=\"control-sidebar-home-tab\">\n");
      out.write("                        <h3 class=\"control-sidebar-heading\">Recent Activity</h3>\n");
      out.write("                        <ul class=\"control-sidebar-menu\">\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"javascript:void(0)\">\n");
      out.write("                                    <i class=\"menu-icon fa fa-birthday-cake bg-red\"></i>\n");
      out.write("\n");
      out.write("                                    <div class=\"menu-info\">\n");
      out.write("                                        <h4 class=\"control-sidebar-subheading\">Langdon's Birthday</h4>\n");
      out.write("\n");
      out.write("                                        <p>Will be 23 on April 24th</p>\n");
      out.write("                                    </div>\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"javascript:void(0)\">\n");
      out.write("                                    <i class=\"menu-icon fa fa-user bg-yellow\"></i>\n");
      out.write("\n");
      out.write("                                    <div class=\"menu-info\">\n");
      out.write("                                        <h4 class=\"control-sidebar-subheading\">Frodo Updated His Profile</h4>\n");
      out.write("\n");
      out.write("                                        <p>New phone +1(800)555-1234</p>\n");
      out.write("                                    </div>\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"javascript:void(0)\">\n");
      out.write("                                    <i class=\"menu-icon fa fa-envelope-o bg-light-blue\"></i>\n");
      out.write("\n");
      out.write("                                    <div class=\"menu-info\">\n");
      out.write("                                        <h4 class=\"control-sidebar-subheading\">Nora Joined Mailing List</h4>\n");
      out.write("\n");
      out.write("                                        <p>nora@example.com</p>\n");
      out.write("                                    </div>\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"javascript:void(0)\">\n");
      out.write("                                    <i class=\"menu-icon fa fa-file-code-o bg-green\"></i>\n");
      out.write("\n");
      out.write("                                    <div class=\"menu-info\">\n");
      out.write("                                        <h4 class=\"control-sidebar-subheading\">Cron Job 254 Executed</h4>\n");
      out.write("\n");
      out.write("                                        <p>Execution time 5 seconds</p>\n");
      out.write("                                    </div>\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                        <!-- /.control-sidebar-menu -->\n");
      out.write("\n");
      out.write("                        <h3 class=\"control-sidebar-heading\">Tasks Progress</h3>\n");
      out.write("                        <ul class=\"control-sidebar-menu\">\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"avascript:void(0)\">\n");
      out.write("                                    <h4 class=\"control-sidebar-subheading\">\n");
      out.write("                                        Custom Template Design\n");
      out.write("                                        <span class=\"label label-danger pull-right\">70%</span>\n");
      out.write("                                    </h4>\n");
      out.write("\n");
      out.write("                                    <div class=\"progress progress-xxs\">\n");
      out.write("                                        <div class=\"progress-bar progress-bar-danger\" style=\"width: 70%\"></div>\n");
      out.write("                                    </div>\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"javascript:void(0)\">\n");
      out.write("                                    <h4 class=\"control-sidebar-subheading\">\n");
      out.write("                                        Update Resume\n");
      out.write("                                        <span class=\"label label-success pull-right\">95%</span>\n");
      out.write("                                    </h4>\n");
      out.write("\n");
      out.write("                                    <div class=\"progress progress-xxs\">\n");
      out.write("                                        <div class=\"progress-bar progress-bar-success\" style=\"width: 95%\"></div>\n");
      out.write("                                    </div>\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"javascript:void(0)\">\n");
      out.write("                                    <h4 class=\"control-sidebar-subheading\">\n");
      out.write("                                        Laravel Integration\n");
      out.write("                                        <span class=\"label label-warning pull-right\">50%</span>\n");
      out.write("                                    </h4>\n");
      out.write("\n");
      out.write("                                    <div class=\"progress progress-xxs\">\n");
      out.write("                                        <div class=\"progress-bar progress-bar-warning\" style=\"width: 50%\"></div>\n");
      out.write("                                    </div>\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"javascript:void(0)\">\n");
      out.write("                                    <h4 class=\"control-sidebar-subheading\">\n");
      out.write("                                        Back End Framework\n");
      out.write("                                        <span class=\"label label-primary pull-right\">68%</span>\n");
      out.write("                                    </h4>\n");
      out.write("\n");
      out.write("                                    <div class=\"progress progress-xxs\">\n");
      out.write("                                        <div class=\"progress-bar progress-bar-primary\" style=\"width: 68%\"></div>\n");
      out.write("                                    </div>\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                        <!-- /.control-sidebar-menu -->\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <!-- /.tab-pane -->\n");
      out.write("                    <!-- Stats tab content -->\n");
      out.write("                    <div class=\"tab-pane\" id=\"control-sidebar-stats-tab\">Stats Tab Content</div>\n");
      out.write("                    <!-- /.tab-pane -->\n");
      out.write("                    <!-- Settings tab content -->\n");
      out.write("                    <div class=\"tab-pane\" id=\"control-sidebar-settings-tab\">\n");
      out.write("                        <form method=\"post\">\n");
      out.write("                            <h3 class=\"control-sidebar-heading\">General Settings</h3>\n");
      out.write("\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label class=\"control-sidebar-subheading\">\n");
      out.write("                                    Report panel usage\n");
      out.write("                                    <input type=\"checkbox\" class=\"pull-right\" checked>\n");
      out.write("                                </label>\n");
      out.write("\n");
      out.write("                                <p>\n");
      out.write("                                    Some information about this general settings option\n");
      out.write("                                </p>\n");
      out.write("                            </div>\n");
      out.write("                            <!-- /.form-group -->\n");
      out.write("\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label class=\"control-sidebar-subheading\">\n");
      out.write("                                    Allow mail redirect\n");
      out.write("                                    <input type=\"checkbox\" class=\"pull-right\" checked>\n");
      out.write("                                </label>\n");
      out.write("\n");
      out.write("                                <p>\n");
      out.write("                                    Other sets of options are available\n");
      out.write("                                </p>\n");
      out.write("                            </div>\n");
      out.write("                            <!-- /.form-group -->\n");
      out.write("\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label class=\"control-sidebar-subheading\">\n");
      out.write("                                    Expose author name in posts\n");
      out.write("                                    <input type=\"checkbox\" class=\"pull-right\" checked>\n");
      out.write("                                </label>\n");
      out.write("\n");
      out.write("                                <p>\n");
      out.write("                                    Allow the user to show his name in blog posts\n");
      out.write("                                </p>\n");
      out.write("                            </div>\n");
      out.write("                            <!-- /.form-group -->\n");
      out.write("\n");
      out.write("                            <h3 class=\"control-sidebar-heading\">Chat Settings</h3>\n");
      out.write("\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label class=\"control-sidebar-subheading\">\n");
      out.write("                                    Show me as online\n");
      out.write("                                    <input type=\"checkbox\" class=\"pull-right\" checked>\n");
      out.write("                                </label>\n");
      out.write("                            </div>\n");
      out.write("                            <!-- /.form-group -->\n");
      out.write("\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label class=\"control-sidebar-subheading\">\n");
      out.write("                                    Turn off notifications\n");
      out.write("                                    <input type=\"checkbox\" class=\"pull-right\">\n");
      out.write("                                </label>\n");
      out.write("                            </div>\n");
      out.write("                            <!-- /.form-group -->\n");
      out.write("\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label class=\"control-sidebar-subheading\">\n");
      out.write("                                    Delete chat history\n");
      out.write("                                    <a href=\"javascript:void(0)\" class=\"text-red pull-right\"><i class=\"fa fa-trash-o\"></i></a>\n");
      out.write("                                </label>\n");
      out.write("                            </div>\n");
      out.write("                            <!-- /.form-group -->\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- /.tab-pane -->\n");
      out.write("                </div>\n");
      out.write("            </aside>\n");
      out.write("            <!-- /.control-sidebar -->\n");
      out.write("            <!-- Add the sidebar's background. This div must be placed\n");
      out.write("                 immediately after the control sidebar -->\n");
      out.write("            <div class=\"control-sidebar-bg\"></div>\n");
      out.write("        </div>\n");
      out.write("        <!-- ./wrapper -->\n");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- jQuery 2.2.0 -->\n");
      out.write("<script src=\"/toy/backend/plugins/jQuery/jQuery-2.2.0.min.js\"></script>\n");
      out.write("<!-- jQuery UI 1.11.4 -->\n");
      out.write("<script src=\"https://code.jquery.com/ui/1.11.4/jquery-ui.min.js\"></script>\n");
      out.write("<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->\n");
      out.write("<script>\n");
      out.write("    $.widget.bridge('uibutton', $.ui.button);\n");
      out.write("</script>\n");
      out.write("<!-- Bootstrap 3.3.6 -->\n");
      out.write("<script src=\"/toy/backend/bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("<!-- Morris.js charts -->\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js\"></script>\n");
      out.write("<script src=\"/toy/backend/plugins/morris/morris.min.js\"></script>\n");
      out.write("<!-- Sparkline -->\n");
      out.write("<script src=\"/toy/backend/plugins/sparkline/jquery.sparkline.min.js\"></script>\n");
      out.write("<!-- jvectormap -->\n");
      out.write("<script src=\"/toy/backend/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js\"></script>\n");
      out.write("<script src=\"/toy/backend/plugins/jvectormap/jquery-jvectormap-world-mill-en.js\"></script>\n");
      out.write("<!-- jQuery Knob Chart -->\n");
      out.write("<script src=\"/toy/backend/plugins/knob/jquery.knob.js\"></script>\n");
      out.write("<!-- daterangepicker -->\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js\"></script>\n");
      out.write("<script src=\"/toy/backend/plugins/daterangepicker/daterangepicker.js\"></script>\n");
      out.write("<!-- datepicker -->\n");
      out.write("<script src=\"/toy/backend/plugins/datepicker/bootstrap-datepicker.js\"></script>\n");
      out.write("<!-- Bootstrap WYSIHTML5 -->\n");
      out.write("<script src=\"/toy/backend/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js\"></script>\n");
      out.write("<!-- Slimscroll -->\n");
      out.write("<script src=\"/toy/backend/plugins/slimScroll/jquery.slimscroll.min.js\"></script>\n");
      out.write("<!-- FastClick -->\n");
      out.write("<script src=\"/toy/backend/plugins/fastclick/fastclick.js\"></script>\n");
      out.write("<!-- AdminLTE App -->\n");
      out.write("<script src=\"/toy/backend/dist/js/app.min.js\"></script>\n");
      out.write("<!-- AdminLTE dashboard demo (This is only for demo purposes) -->\n");
      out.write("<script src=\"/toy/backend/dist/js/pages/dashboard.js\"></script>\n");
      out.write("<!-- AdminLTE for demo purposes -->\n");
      out.write("<script src=\"/toy/backend/dist/js/demo.js\"></script>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            \n");
      out.write("            var slider = document.getElementById(\"toy\");\n");
      out.write("            slider.className+= \" active\";\n");
      out.write("            var menu = document.getElementById(\"toyMenu\");\n");
      out.write("            menu.className+= \"active\";\n");
      out.write("            //alert(slider.className);\n");
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