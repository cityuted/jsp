<%-- 
    Document   : updateToy
    Created on : 2016/4/10, 上午 12:53:02
    Author     : Mesong
--%>

<%@page import="bean.User"%>
<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="bean.SecondHand"%>
<%@page import="db.secondHandDB"%>
<%@page import="db.userDB"%>
<%@page import="bean.ToyCategory"%>
<%@page import="db.toyCategoryDB"%>
<%@page import="bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="db.categoryDB"%>
<%@page import="bean.Toy"%>
<%@page import="db.toyDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>AdminLTE 2 | Dashboard</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <%@ include file="/layout/style.jsp"%>

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="C:/temp/layout/https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="C:/temp/layout/https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <div class="wrapper">

            <jsp:include page="/layout/header.jsp"/>
            <!-- Left side column. contains the logo and sidebar -->
            <jsp:include page="/layout/slider.jsp"/>

            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <jsp:include page="/layout/contentHeader.jsp"/>
                <% 
                    userDB userdb = new userDB();
                    

                %>
              
                <%
                    int custID = 0;
                    if(request.getParameter("custID")!=null) {
                        custID = Integer.parseInt(request.getParameter("custID"));
                    }
                     User user = userdb.searchUserByID(custID);
                %>
                <!-- Main content -->
                <div class="box box-warning">
                    <div class="box-header with-border">
                        <h3 class="box-title">View Customer</h3>
                    </div>
                    <!-- /.box-header -->
               
                   
                    <div class="box-body row-sm-8">

                        <form  method='post' action='/toy/doSearchCustomer'  >

                            <div class="form-group">
                                <label>User ID</label>
                                <input type="text" class="form-control" value="${param.custID}" disabled="">
                                <input type="hidden" name='custID' id='custID' value="${param.custID}" >
                            </div>
                            <!-- text input -->
                            <div class="form-group">
                                <label>User Name</label>
                                <input type="text" name='custName'  disabled  id='custName' class="form-control" required value='<%= user.getUserName() %>'>
                            </div>
                            
                            
                            
                             <div class="form-group">
                                <label>Sex</label>
                                <input type="text" name='custSex'   id='custSex' disabled class="form-control" required value='<%= user.getUserSex() %>'>
                            </div>
                            
                             <div class="form-group">
                                <label>Address</label>
                                <textarea type="text" name='custAddress'  disabled id='custAddress' class="form-control" required ><%= user.getUserAddress()%></textarea>
                            </div>
                            
                             <div class="form-group">
                                <label>Phone</label>
                                <input type="text" name='custPhone' disabled  id='custPhone' class="form-control" required value='<%= user.getUserPhone()%>'>
                            </div>
                            
                             <div class="form-group">
                                <label>Email</label>
                                <input type="text" name='custEmail'  disabled  id='custEmail' class="form-control" required value='<%= user.getEmail() %>'>
                            </div>
                            
                             <div class="form-group">
                                <label>Cashpoint</label>
                                <input type="text" name='cashpoint'  disabled  id='cashpoint' class="form-control" required value='<%= user.getCashpoint()%>'>
                            </div>

                         



                          


                            <!-- Select multiple-->
                            
                            <div class="box-footer">
                                <button class="btn btn-danger " type='button' onclick="javascript:location.href = '/toy/doSearchCustomer'">Back</button>
                              

                            </div>  

                        </form>
                           
                    </div>


                    <!-- /.box-body -->
                </div>
                             <%@include  file="/layout/footer.jsp" %>
                <!-- /.content -->
            </div>
            <!-- /.content-wrapper -->
            <//jsp:include page="layout/footer.jsp"/>

            <!-- Control Sidebar -->
            <aside class="control-sidebar control-sidebar-dark">
                <!-- Create the tabs -->
                <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
                    <li><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
                    <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
                </ul>
                <!-- Tab panes -->
                <div class="tab-content">
                    <!-- Home tab content -->
                    <div class="tab-pane" id="control-sidebar-home-tab">
                        <h3 class="control-sidebar-heading">Recent Activity</h3>
                        <ul class="control-sidebar-menu">
                            <li>
                                <a href="javascript:void(0)">
                                    <i class="menu-icon fa fa-birthday-cake bg-red"></i>

                                    <div class="menu-info">
                                        <h4 class="control-sidebar-subheading">Langdon's Birthday</h4>

                                        <p>Will be 23 on April 24th</p>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="javascript:void(0)">
                                    <i class="menu-icon fa fa-user bg-yellow"></i>

                                    <div class="menu-info">
                                        <h4 class="control-sidebar-subheading">Frodo Updated His Profile</h4>

                                        <p>New phone +1(800)555-1234</p>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="javascript:void(0)">
                                    <i class="menu-icon fa fa-envelope-o bg-light-blue"></i>

                                    <div class="menu-info">
                                        <h4 class="control-sidebar-subheading">Nora Joined Mailing List</h4>

                                        <p>nora@example.com</p>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="javascript:void(0)">
                                    <i class="menu-icon fa fa-file-code-o bg-green"></i>

                                    <div class="menu-info">
                                        <h4 class="control-sidebar-subheading">Cron Job 254 Executed</h4>

                                        <p>Execution time 5 seconds</p>
                                    </div>
                                </a>
                            </li>
                        </ul>
                        <!-- /.control-sidebar-menu -->

                        <h3 class="control-sidebar-heading">Tasks Progress</h3>
                        <ul class="control-sidebar-menu">
                            <li>
                                <a href="avascript:void(0)">
                                    <h4 class="control-sidebar-subheading">
                                        Custom Template Design
                                        <span class="label label-danger pull-right">70%</span>
                                    </h4>

                                    <div class="progress progress-xxs">
                                        <div class="progress-bar progress-bar-danger" style="width: 70%"></div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="javascript:void(0)">
                                    <h4 class="control-sidebar-subheading">
                                        Update Resume
                                        <span class="label label-success pull-right">95%</span>
                                    </h4>

                                    <div class="progress progress-xxs">
                                        <div class="progress-bar progress-bar-success" style="width: 95%"></div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="javascript:void(0)">
                                    <h4 class="control-sidebar-subheading">
                                        Laravel Integration
                                        <span class="label label-warning pull-right">50%</span>
                                    </h4>

                                    <div class="progress progress-xxs">
                                        <div class="progress-bar progress-bar-warning" style="width: 50%"></div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="javascript:void(0)">
                                    <h4 class="control-sidebar-subheading">
                                        Back End Framework
                                        <span class="label label-primary pull-right">68%</span>
                                    </h4>

                                    <div class="progress progress-xxs">
                                        <div class="progress-bar progress-bar-primary" style="width: 68%"></div>
                                    </div>
                                </a>
                            </li>
                        </ul>
                        <!-- /.control-sidebar-menu -->

                    </div>
                    <!-- /.tab-pane -->
                    <!-- Stats tab content -->
                    <div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab Content</div>
                    <!-- /.tab-pane -->
                    <!-- Settings tab content -->
                    <div class="tab-pane" id="control-sidebar-settings-tab">
                        <form method="post">
                            <h3 class="control-sidebar-heading">General Settings</h3>

                            <div class="form-group">
                                <label class="control-sidebar-subheading">
                                    Report panel usage
                                    <input type="checkbox" class="pull-right" checked>
                                </label>

                                <p>
                                    Some information about this general settings option
                                </p>
                            </div>
                            <!-- /.form-group -->

                            <div class="form-group">
                                <label class="control-sidebar-subheading">
                                    Allow mail redirect
                                    <input type="checkbox" class="pull-right" checked>
                                </label>

                                <p>
                                    Other sets of options are available
                                </p>
                            </div>
                            <!-- /.form-group -->

                            <div class="form-group">
                                <label class="control-sidebar-subheading">
                                    Expose author name in posts
                                    <input type="checkbox" class="pull-right" checked>
                                </label>

                                <p>
                                    Allow the user to show his name in blog posts
                                </p>
                            </div>
                            <!-- /.form-group -->

                            <h3 class="control-sidebar-heading">Chat Settings</h3>

                            <div class="form-group">
                                <label class="control-sidebar-subheading">
                                    Show me as online
                                    <input type="checkbox" class="pull-right" checked>
                                </label>
                            </div>
                            <!-- /.form-group -->

                            <div class="form-group">
                                <label class="control-sidebar-subheading">
                                    Turn off notifications
                                    <input type="checkbox" class="pull-right">
                                </label>
                            </div>
                            <!-- /.form-group -->

                            <div class="form-group">
                                <label class="control-sidebar-subheading">
                                    Delete chat history
                                    <a href="javascript:void(0)" class="text-red pull-right"><i class="fa fa-trash-o"></i></a>
                                </label>
                            </div>
                            <!-- /.form-group -->
                        </form>
                    </div>
                    <!-- /.tab-pane -->
                </div>
            </aside>
            <!-- /.control-sidebar -->
            <!-- Add the sidebar's background. This div must be placed
                 immediately after the control sidebar -->
            <div class="control-sidebar-bg"></div>
        </div>
        <!-- ./wrapper -->

        <%@include file="/layout/library.jsp" %>
        <script>

          var slider = document.getElementById("cust");
            slider.className+= " active";
            var menu = document.getElementById("customerMenu");
            menu.className+= "active";
            //alert(slider.className);
        </script>
        
        
    </body>
</html>


