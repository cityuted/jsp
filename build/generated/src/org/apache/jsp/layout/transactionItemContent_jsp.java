package org.apache.jsp.layout;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import bean.TransactionItem;
import db.TransactionDB;
import bean.TransactionHeader;
import bean.Category;
import bean.SecondHand;
import java.util.ArrayList;
import bean.Toy;

public final class transactionItemContent_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 int pageNumber = 1;
    int total = 0;

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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');
  if (request.getParameter("page") != null) {
        pageNumber = Integer.parseInt(request.getParameter("page"));
    } else {
        pageNumber = 1;
    }

    TransactionDB tranDB = new TransactionDB();
    int tranID = 0;
    if (request.getParameter("transactionID") != null) {
        tranID = Integer.parseInt(request.getParameter("transactionID"));
    }
    ArrayList<TransactionItem> items = tranDB.listTransactionItem(tranID);

      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    (function (document) {\r\n");
      out.write("        'use strict';\r\n");
      out.write("\r\n");
      out.write("        var LightTableFilter = (function (Arr) {\r\n");
      out.write("\r\n");
      out.write("            var _input;\r\n");
      out.write("\r\n");
      out.write("            function _onInputEvent(e) {\r\n");
      out.write("                _input = e.target;\r\n");
      out.write("                var tables = document.getElementsByClassName(_input.getAttribute('data-table'));\r\n");
      out.write("                Arr.forEach.call(tables, function (table) {\r\n");
      out.write("                    Arr.forEach.call(table.tBodies, function (tbody) {\r\n");
      out.write("                        Arr.forEach.call(tbody.rows, _filter);\r\n");
      out.write("                    });\r\n");
      out.write("                });\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            function _filter(row) {\r\n");
      out.write("                var text = row.textContent.toLowerCase(),\r\n");
      out.write("                        val = _input.value.toLowerCase();\r\n");
      out.write("                row.style.display = text.indexOf(val) === -1 ? 'none' : 'table-row';\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            return {\r\n");
      out.write("                init: function () {\r\n");
      out.write("                    var inputs = document.getElementsByClassName('light-table-filter');\r\n");
      out.write("                    Arr.forEach.call(inputs, function (input) {\r\n");
      out.write("                        input.oninput = _onInputEvent;\r\n");
      out.write("                    });\r\n");
      out.write("                }\r\n");
      out.write("            };\r\n");
      out.write("        })(Array.prototype);\r\n");
      out.write("\r\n");
      out.write("        document.addEventListener('readystatechange', function () {\r\n");
      out.write("            if (document.readyState === 'complete') {\r\n");
      out.write("                LightTableFilter.init();\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("    })(document);\r\n");
      out.write("  \r\n");
      out.write("</script>\r\n");
      out.write("<section class=\"content\">\r\n");
      out.write("    <div class=\"col-xs-15\">\r\n");
      out.write("        <div class=\"box\">\r\n");
      out.write("            <div class=\"box-header\">\r\n");
      out.write("\r\n");
      out.write("                <h3 class=\"box-title\">Transaction Header Table</h3>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"box-tools\">\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"input-group input-group-sm\" style=\"width: 150px;\">\r\n");
      out.write("\r\n");
      out.write("                        <!--<input type=\"text\" name=\"table_search\" class=\"form-control pull-right\" placeholder=\"Search\">-->\r\n");
      out.write("                        <input type=\"search\" class=\"form-control light-table-filter\" data-table=\"order-table\" placeholder=\"Filter\">\r\n");
      out.write("\r\n");
      out.write("                        <span class=\"input-group-addon\"><i class=\"fa fa-search\"></i></span>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            ");
      java.util.ArrayList<TransactionHeader> transactionlist = null;
      transactionlist = (java.util.ArrayList<TransactionHeader>) _jspx_page_context.getAttribute("transactionlist", PageContext.SESSION_SCOPE);
      if (transactionlist == null){
        throw new java.lang.InstantiationException("bean transactionlist not found within scope");
      }
      out.write("\r\n");
      out.write("\r\n");
      out.write("            ");
   total = pageNumber * 15;
      out.write("\r\n");
      out.write("            <!-- /.box-header -->\r\n");
      out.write("            <div class='box-body table-responsive no-padding' style=\"min-height:170px\">\r\n");
      out.write("                <table class='table table-hover order-table'>\r\n");
      out.write("                    <thead>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <th>Toy ID</th>\r\n");
      out.write("                            <th>Toy Name</th>\r\n");
      out.write("                            <th>Toy Cashpoint</th>\r\n");
      out.write("                            <th>QTY</th>\r\n");
      out.write("\r\n");
      out.write("                        </tr>\r\n");
      out.write("                    </thead>\r\n");
      out.write("                    <tbody>\r\n");
      out.write("                        ");

                            int k = 0;


                        
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        ");
                        for (k = 0; k < items.size(); k++) {
                                TransactionItem tranItem = items.get(k);
                                if (k > (pageNumber) * 15 || k < (pageNumber - 1) * 15) {
                                    out.println("<tr style='display:none'>");
                                } else {
                                    out.println("<tr>");
                                }
                                out.print(String.format("<td>%s</td>", tranItem.getToyID()));

                                out.print(String.format("<td>%s</td>", tranItem.getToyName()));

                                out.print(String.format("<td>%s</td>", tranItem.getCashPoint()));
                                out.print(String.format("<td>%s</td>", tranItem.getQTY()));

                                //String createUrl = "/toy/doCreateCategory?categoryID=" + cat.getCategoryID();
                                // String viewUrl = "/toy/managerPage/viewTransactionItem.jsp?transactionID=" + tran.getTRANSACTIONID();
                                //String updateUrl = "/toy/managerPage/updateTransactionHeader.jsp?transactionID=" + tran.getTRANSACTIONID();
                                String disabled = "";
                                //                            if (session.getAttribute(cat.getCategoryID() + ".isvalid").equals("true")) {
                                //                                disabled = "disabled";
                                //                            }

                                out.println("</tr>");
                            }

                        
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    </tbody></table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-sm-5\">\r\n");
      out.write("                    <div class=\"dataTables_info\" id=\"example2_info\" role=\"status\" aria-live=\"polite\">\r\n");
      out.write("                        Showing ");
      out.print( ((pageNumber - 1) * 15 + 1));
      out.write(" to ");
      out.print(total);
      out.write(" of ");
      out.print(transactionlist.size());
      out.write(" entries\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-sm-7\">\r\n");
      out.write("                    <div class=\"dataTables_paginate paging_simple_numbers\" id=\"example2_paginate\">\r\n");
      out.write("                        <ul class=\"pagination\">\r\n");
      out.write("                            <li class=\"paginate_button previous ");
 if (pageNumber == 1) {
                                    out.println("disabled");
                                }
      out.write("\" id=\"example2_previous\">\r\n");
      out.write("                                <a href=\"/toy/managerPage/secondHandAdminPage.jsp?page=");
 pageNumber = (pageNumber > 1) ? --pageNumber : pageNumber;
                                    out.print(pageNumber);
      out.write("\" aria-controls=\"example2\" data-dt-idx=\"0\" tabindex=\"0\">Previous</a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            ");
 int index = transactionlist.size() / 15 + 1;
                                int i = 1;
                            
      out.write("\r\n");
      out.write("                            ");
 for (i = 1; i <= index; i++) {
                                    out.println("<li class='paginate_button'>");
                                    String url = String.format("/toy/managerPage/transactionAdminPage.jsp?page=%s", i);
                                    out.println(String.format("<a href='%s' aria-controls='example2' data-dt-idx='%s' tabindex='0'> %s </a>", url, i, i));

                                    out.println("</li>");
                                }
                            
      out.write("\r\n");
      out.write("                            <li class=\"paginate_button next ");
 if (total >= transactionlist.size()) {
                                    out.println("disabled");
                                }
      out.write("\" id=\"example2_next\">\r\n");
      out.write("                                <a href=\"/toy/managerPage/transactionAdminPage.jsp?page=");
 pageNumber = (pageNumber < index) ? ++pageNumber : pageNumber;
                                    out.println(pageNumber);
      out.write("\" aria-controls=\"example2\" data-dt-idx=\"7\" tabindex=\"0\">Next</a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- /.box-body -->\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /.box -->\r\n");
      out.write("    </div>\r\n");
      out.write("</section>\r\n");
      out.write("\r\n");
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
