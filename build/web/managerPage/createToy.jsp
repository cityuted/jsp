<%-- 
    Document   : updateToy
    Created on : 2016/4/10, 上午 12:53:02
    Author     : Mesong
--%>

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
                <% toyDB toyDb = new toyDB();
                    categoryDB categorydb = new categoryDB();
                    toyCategoryDB toyCatdb = new toyCategoryDB();
                    userDB userdb = new userDB();
                    secondHandDB secondHanddb = new secondHandDB();
                    
                %>
                <% 
                    ArrayList<Category> categoryList = categorydb.listToyCategory();
                    ArrayList<ToyCategory> toyCatList = toyCatdb.listToyCategory();
                    ArrayList<SecondHand> secondHandList = secondHanddb.listApprovedSecondHand();
                %>
                <!-- Main content -->
                <div class="box box-warning">
                    <div class="box-header with-border">
                        <h3 class="box-title">Update Toy</h3>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body">
                        <form  method='post' action='/toy/doCreateToy'  enctype="multipart/form-data">
                            <div class="form-group">
                                <label>Toy ID</label>
                                <% int lastIndex = toyDb.getNextAvailableID();%>
                                <input type="text" class="form-control" value="<%= lastIndex %>" disabled="">
                                <input type="hidden" name='toyID' id='toyID' value="<%= lastIndex %>" >
                            </div>
                            <!-- text input -->
                            <div class="form-group">
                                <label>Toy Name</label>
                                <input type="text" name='toyName'   id='toyName' class="form-control" required value=''>
                            </div>

                            <!-- textarea -->
                            <div class="form-group">
                                <label>Description</label>
                                <textarea class="form-control" name='description'  id='description' rows="3" ></textarea>
                            </div>
                            
                            <div class="form-group">
                                <label>Toy Icon</label>
                                <input id="uploadImage" type="file" name="myPhoto" onchange="" accept=".png" />
                                <input id="uploadString" type="hidden" name="uploadString"  value=""   />
                            </div>

                            <div class="form-group">
                                <label>Cashpoint</label>
                                <input type="number" class="form-control" name='cashpoint' min="0" required value="">
                            </div>

                            <div class="form-group">
                                <label>QTY</label>
                                <input type="number" class="form-control" name='qty'  min="0" required value="">
                            </div>

                            <div class="form-group">
                                <label>Discount(%)</label>
                                <input type="number" class="form-control" name='discount' min="0" required value="">
                            </div>


                            <!-- select -->
                            <div class="form-group">
                                <label>Second-Hand</label>
                                <select class="form-control" id="secondHand" name="secondHand">
                                    <option value="" selected> </option>
                                    <% 
                                        for (SecondHand sc : secondHandList) {
                                            
                                           String custName =  userdb.searchUserByID(sc.getCustID()).getUserName();
                                          
                                               out.println(String.format("<option value='%s' >%s</option>", sc.getID(), custName + "-" + sc.getName()));
                                        }
                                    %>
                                </select>
                            </div>


                            <!-- Select multiple-->
                            <div class="form-group">
                                <label>Category</label>
                                
                                <select multiple="" name="category" id="category" class="form-control" required>
                                    
                                    <% 
                                         int index = 0;
                                        String separator = ";";
                                        for (Category c : categoryList) {
                                            boolean isSelected = false;
                                            for (ToyCategory ct : toyCatList) {
                                                if (ct.getCategoryID() == c.getCategoryID()) {
                                                    isSelected = true;
                                                }
                                            }
                                             if (index == categoryList.size() - 1) {
                                                separator = "";
                                            }
                                                out.println(String.format("<option value='%s'>%s</option>", c.getCategoryID()+separator, c.getCategoryID() + "-" + c.getCategoryName()));
                                            
                                        }
                                    %>


                                </select>
                            </div>
                            <div class="box-footer">
                                <button class="btn btn-danger " type ='button' onclick="javascript:location.href = '/toy/doSearchToy'">Back</button>
                                <input type="submit" class="btn btn-primary pull-right" value='Submit'>

                            </div>  

                        </form>
                    </div>


                    <!-- /.box-body -->
                </div>

                <!-- /.content -->
                <%@include  file="/layout/footer.jsp" %>
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

            var slider = document.getElementById("toy");
            slider.className += " active";
            var menu = document.getElementById("toyMenu");
            menu.className += "active";
            //alert(slider.className);
        </script>
    </body>
</html>


