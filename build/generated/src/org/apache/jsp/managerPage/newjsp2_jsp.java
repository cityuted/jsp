package org.apache.jsp.managerPage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class newjsp2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <title>Working with JavaScript Dates: Moment Object vs. JavaScript Date Object</title>\n");
      out.write("        \n");
      out.write("     \n");
      out.write("        <!--[if lt IE 9]>\n");
      out.write("        <script src=\"//cdn.jsdelivr.net/html5shiv/3.7.2/html5shiv.min.js\"></script>\n");
      out.write("        <script src=\"//cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js\"></script>\n");
      out.write("        <![endif]-->\n");
      out.write("     \n");
      out.write("        <!-- Reference Moment.js library -->\n");
      out.write("        <script src=\"//cdnjs.cloudflare.com/ajax/libs/moment.js/2.7.0/moment.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    </head>\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- jQuery 2.2.0 -->\r\n");
      out.write("<script src=\"/toy/backend/plugins/jQuery/jQuery-2.2.0.min.js\"></script>\r\n");
      out.write("<!-- jQuery UI 1.11.4 -->\r\n");
      out.write("<script src=\"https://code.jquery.com/ui/1.11.4/jquery-ui.min.js\"></script>\r\n");
      out.write("<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->\r\n");
      out.write("<script>\r\n");
      out.write("    $.widget.bridge('uibutton', $.ui.button);\r\n");
      out.write("</script>\r\n");
      out.write("<!-- Bootstrap 3.3.6 -->\r\n");
      out.write("<script src=\"/toy/backend/bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("<!-- Morris.js charts -->\r\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js\"></script>\r\n");
      out.write("<script src=\"/toy/backend/plugins/morris/morris.min.js\"></script>\r\n");
      out.write("<!-- Sparkline -->\r\n");
      out.write("<script src=\"/toy/backend/plugins/sparkline/jquery.sparkline.min.js\"></script>\r\n");
      out.write("<!-- jvectormap -->\r\n");
      out.write("<script src=\"/toy/backend/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js\"></script>\r\n");
      out.write("<script src=\"/toy/backend/plugins/jvectormap/jquery-jvectormap-world-mill-en.js\"></script>\r\n");
      out.write("<!-- jQuery Knob Chart -->\r\n");
      out.write("<script src=\"/toy/backend/plugins/knob/jquery.knob.js\"></script>\r\n");
      out.write("<script src=\"/toy/backend/plugins/timedifference/livestamp.js\"></script>\r\n");
      out.write("\r\n");
      out.write("  <script src=\"//cdnjs.cloudflare.com/ajax/libs/moment.js/2.7.0/moment.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<!-- daterangepicker -->\r\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js\"></script>\r\n");
      out.write("<script src=\"/toy/backend/plugins/daterangepicker/daterangepicker.js\"></script>\r\n");
      out.write("<!-- datepicker -->\r\n");
      out.write("<script src=\"/toy/backend/plugins/datepicker/bootstrap-datepicker.js\"></script>\r\n");
      out.write("<!-- Bootstrap WYSIHTML5 -->\r\n");
      out.write("<script src=\"/toy/backend/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js\"></script>\r\n");
      out.write("<!-- Slimscroll -->\r\n");
      out.write("<script src=\"/toy/backend/plugins/slimScroll/jquery.slimscroll.min.js\"></script>\r\n");
      out.write("<!-- FastClick -->\r\n");
      out.write("<script src=\"/toy/backend/plugins/fastclick/fastclick.js\"></script>\r\n");
      out.write("<!-- AdminLTE App -->\r\n");
      out.write("<script src=\"/toy/backend/dist/js/app.min.js\"></script>\r\n");
      out.write("<!-- AdminLTE dashboard demo (This is only for demo purposes) -->\r\n");
      out.write("<script src=\"/toy/backend/dist/js/pages/dashboard.js\"></script>\r\n");
      out.write("<!-- AdminLTE for demo purposes -->\r\n");
      out.write("<script src=\"/toy/backend/dist/js/demo.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("            \r\n");
      out.write("            var handleFileSelect = function (evt) {\r\n");
      out.write("                var files = evt.target.files;\r\n");
      out.write("                var file = files[0];\r\n");
      out.write("\r\n");
      out.write("                if (files && file) {\r\n");
      out.write("                    var reader = new FileReader();\r\n");
      out.write("\r\n");
      out.write("                    reader.onload = function (readerEvt) {\r\n");
      out.write("                        var binaryString = readerEvt.target.result;\r\n");
      out.write("                        //document.getElementById(\"base64textarea\").value = btoa(binaryString);\r\n");
      out.write("                        document.getElementById(\"uploadString\").value = btoa(binaryString);\r\n");
      out.write("                       // alert(btoa(binaryString));\r\n");
      out.write("                    };\r\n");
      out.write("\r\n");
      out.write("                    reader.readAsBinaryString(file);\r\n");
      out.write("                }\r\n");
      out.write("            };\r\n");
      out.write("\r\n");
      out.write("            if (window.File && window.FileReader && window.FileList && window.Blob) {\r\n");
      out.write("                document.getElementById('uploadImage').addEventListener('change', handleFileSelect, false);\r\n");
      out.write("            } else {\r\n");
      out.write("                alert('The File APIs are not fully supported in this browser.');\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            //EL(\"uploadImage\").addEventListener(\"change\", readFile, false);\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\n");
      out.write("    <body onload=\"change(0)\">\n");
      out.write("        <h1>Moment.js here now: <span  id=\"then0\" data-date=\"2016-04-17 03:14:27.0\"  ></span></h1>\n");
      out.write("         <h1>Moment.js here now2: <span id=\"then1\"  data-date=\"2016-04-09 03:14:27.0\"></span></h1>\n");
      out.write("        \n");
      out.write("        <script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            function change(id) {\n");
      out.write("       \n");
      out.write("              var then2;\n");
      out.write("              var date2;\n");
      out.write("              for( i = 0 ; i < 2 ; i++) {\n");
      out.write("                 then2= $('#then'+i);\n");
      out.write("                 date2= moment(new Date(then2.attr('data-date')));\n");
      out.write("                    then2.html(date2.fromNow());\n");
      out.write("              }\n");
      out.write("             // update2();\n");
      out.write("               //setInterval(update2, 60000);\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        <script>\n");
      out.write("        function updateDate()\n");
      out.write("        {\n");
      out.write("           // alert(2);\n");
      out.write("           // \n");
      out.write("//           var items = document.getElementById(\"then0\");\n");
      out.write("//            var date =  moment(new Date(items.attr('data-date')));\n");
      out.write("//            items.html(date.fromNow());\n");
      out.write("        }\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
