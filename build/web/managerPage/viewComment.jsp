<%-- 
    Document   : updateToy
    Created on : 2016/4/10, 上午 12:53:02
    Author     : Mesong
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script>
        function getContent(e)
        {
            if (e.keyCode != 13) {
                var placeholder = document.getElementById("commentPlace");
                var content = document.getElementById("commentContent");
                content.value = placeholder.value;
                // alert(content.value);
            }
        }


        function checkSubmit(e)
        {
            if (e && e.keyCode == 13)
            {

                var form = document.getElementById("leaveComment");
                // alert(3);
                form.submit();
                // document.forms[0].submit();
            }
        }
        function getReplyData(msgID,transID, custID, custName)
        {
            var tran = document.getElementById("transactionID");
            var cust = document.getElementById("custID");
            messageID
            var msg = document.getElementById("messageID");
            var replyHeader = document.getElementById("replyHeader");

            replyHeader.style.visibility = "visible";
            msg.value = msgID;
            tran.value = transID;
            cust.value = custID;
            replyHeader.innerHTML = "Reply " + custName + ":";
            var placeholder = document.getElementById("commentPlace");
            placeholder.disabled = false;
            //alert(tran.value+":"+cust.value);
        }

        function disableReply(id)
        {
            var reply = document.getElementById("reply"+id);
            reply.style.visibility = "hidden";
        }

    </script>

</script>
<body class="hold-transition skin-blue sidebar-mini">
    <div class="wrapper">

        <jsp:include page="/layout/header.jsp"/>
        <!-- Left side column. contains the logo and sidebar -->
        <jsp:include page="/layout/slider.jsp"/>

        <!-- Content Wrapper. Contains page content -->
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <jsp:include page="/layout/contentHeader.jsp"/>
            <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
            <%
                userDB userdb = new userDB();


            %>

            <%                    //int custID = 0;
//                    if (request.getParameter("custID") != null) {
//                        custID = Integer.parseInt(request.getParameter("custID"));
//                    }
//                    User user = userdb.searchUserByID(custID);
%>
            <!-- Main content -->
            <div class="box box-danger">
                <div class="box-header ">
                    <h3 class="box-title">View Comments</h3>
                </div>
                <!-- /.box-header -->


                <img class="img-responsive"  src="data:image/jpeg;base64,${toylist[0].photo}" alt="Photo">
                <label>${toylist[0].toyName}</label>
                <hr/>
                <label>Response</label>
                <div class="box-body row-sm-8">


                    <div class="tab-content">
                        <div class="active tab-pane" id="activity">


                            <!-- Post -->
                            <c:set var="index" value="0" scope="page"/>

                            <c:forEach items="${messagelist}" var="msg">
                                
                                <c:choose>
                                    <c:when test="${msg.replyMsgID==0}">
                                        <div class="post clearfix">
                                            <div class="user-block">
                                                <img class="img-circle" src="data:image/jpeg;base64,${userlist[index].photo}" alt="User Image">


                                                <span class="username">
                                                    <c:choose>
                                                        <c:when test="${userlist[index].typeID==4}">
                                                            <a  onclick="location.href = 'viewCustomerProfile.jsp?custID=${userlist[index].userID}'" href="javascript:void(0)">${userlist[index].userName}</a>

                                                        </c:when>
                                                        <c:otherwise>
                                                            <a disabled href="javascript:void(0)">${userlist[index].userName}</a>
                                                        </c:otherwise>
                                                    </c:choose>


                                                    <a  href="javascript:void(0)"  onclick="location.href = '/toy/doDeleteComment?toyID=${toylist[0].toyID}&msgID=${msg.messageID}'"  class="pull-right btn-box-tool"><i class="fa fa-times"></i></a>

                                                </span>


                                                <span class="description">Leave a comment - ${msg.relativeTime}</span>

                                                <a href="javasciprt:void(0)" id="reply${index}" onclick="getReplyData(${msg.messageID},${msg.transactionID},${msg.custID}, '${userlist[index].userName}')" class="link-black text-sm"><i class="fa fa-share margin-r-5"></i> Reply</a>


                                            </div>
                                            <!-- /.user-block -->
                                            <p>
                                                ${msg.content}
                                            </p>
                                            <c:set var="y" value="0" scope="page"/>
                                          
                                            
                                            <c:forEach items="${replylist}" var="reply">
                                              
                                                <c:choose>
                                                    <c:when test="${(reply.replyMsgID==msg.messageID)}">
                                                        <script>disableReply(${index});</script>
                                                        <div class="box-footer box-comments">
                                                            <div class="box-comment">
                                                                <!-- User image -->
                                                                <img class="img-circle img-sm" src="data:image/jpeg;base64,${reply.icon}" alt="User Image">
                                                               
                                                                <div class="comment-text">
                                                                    <span class="username">
                                                                        
                                                                       
                                                                                ${reply.custName}
                                                                           
                                                                        
                                                                        <span class="text-muted pull-right">${reply.relativeTime}</span>
                                                                    </span><!-- /.username -->
                                                                    ${reply.content}
                                                                </div>
                                                                <!-- /.comment-text -->
                                                            </div>
                                                            <!-- /.box-comment -->

                                                        </div>

                                                    </c:when>
                                                </c:choose>
                                                <c:set var="y" value="${y+1}" scope="page"/>
                                            </c:forEach>
                                        </div>
                                    </c:when>                                    
                                </c:choose>

                                <c:set var="index" value="${index+1}"/>

                            </c:forEach>
                            <hr/>
                            <span>
                                <label id='replyHeader' class="row-sm-12" style="visibility:hidden"></label>
                                <br/>
                                <img class="img-circle img-sm " src="data:image/jpeg;base64,${userPhoto}" alt="User Image">
                                <input disabled class="form-control  input-sm pull-right" style='width:90%' id="commentPlace" placeholder="Reply" onchange="getContent(event)"  onkeyup="checkSubmit(event)">
                            </span>
                            <form class="form-horizontal" method="post" action="/toy/doReplyComment" id="leaveComment">

                                <div class="form-group margin-bottom-none">


                                    <input type="hidden" id="toyID" name="toyID" value="${toylist[0].toyID}"/>
                                    <input type="hidden" id="messageID" name="messageID" value=""/>
                                    <input type="hidden" id="custID" name="custID" value=""/>
                                    <input type="hidden" id="transactionID" name="transactionID" value=""/>
                                    <input type="hidden" id="commentContent" name="commentContent" value=""/>
                                    <input type="submit" style="visibility:hidden" class="btn btn-danger pull-right btn-block btn-sm"/>

                                </div>
                            </form>
                            <!-- /.post -->
                            
                        </div>
                                    
                        <!-- /.tab-pane -->
                        <div class="tab-pane" id="timeline">
                            <!-- The timeline -->
                            <ul class="timeline timeline-inverse">
                                <!-- timeline time label -->
                                <li class="time-label">
                                    <span class="bg-red">
                                        10 Feb. 2014
                                    </span>
                                </li>
                                <!-- /.timeline-label -->
                                <!-- timeline item -->
                                <li>
                                    <i class="fa fa-envelope bg-blue"></i>

                                    <div class="timeline-item">
                                        <span class="time"><i class="fa fa-clock-o"></i> 12:05</span>

                                        <h3 class="timeline-header"><a href="#">Support Team</a> sent you an email</h3>

                                        <div class="timeline-body">
                                            Etsy doostang zoodles disqus groupon greplin oooj voxy zoodles,
                                            weebly ning heekya handango imeem plugg dopplr jibjab, movity
                                            jajah plickers sifteo edmodo ifttt zimbra. Babblely odeo kaboodle
                                            quora plaxo ideeli hulu weebly balihoo...
                                        </div>
                                        <div class="timeline-footer">
                                            <a class="btn btn-primary btn-xs">Read more</a>
                                            <a class="btn btn-danger btn-xs">Delete</a>
                                        </div>
                                    </div>
                                </li>
                                <!-- END timeline item -->
                                <!-- timeline item -->
                                <li>
                                    <i class="fa fa-user bg-aqua"></i>

                                    <div class="timeline-item">
                                        <span class="time"><i class="fa fa-clock-o"></i> 5 mins ago</span>

                                        <h3 class="timeline-header no-border"><a href="#">Sarah Young</a> accepted your friend request
                                        </h3>
                                    </div>
                                </li>
                                <!-- END timeline item -->
                                <!-- timeline item -->
                                <li>
                                    <i class="fa fa-comments bg-yellow"></i>

                                    <div class="timeline-item">
                                        <span class="time"><i class="fa fa-clock-o"></i> 27 mins ago</span>

                                        <h3 class="timeline-header"><a href="#">Jay White</a> commented on your post</h3>

                                        <div class="timeline-body">
                                            Take me to your leader!
                                            Switzerland is small and neutral!
                                            We are more like Germany, ambitious and misunderstood!
                                        </div>
                                        <div class="timeline-footer">
                                            <a class="btn btn-warning btn-flat btn-xs">View comment</a>
                                        </div>
                                    </div>
                                </li>
                                <!-- END timeline item -->
                                <!-- timeline time label -->
                                <li class="time-label">
                                    <span class="bg-green">
                                        3 Jan. 2014
                                    </span>
                                </li>
                                <!-- /.timeline-label -->
                                <!-- timeline item -->
                                <li>
                                    <i class="fa fa-camera bg-purple"></i>

                                    <div class="timeline-item">
                                        <span class="time"><i class="fa fa-clock-o"></i> 2 days ago</span>

                                        <h3 class="timeline-header"><a href="#">Mina Lee</a> uploaded new photos</h3>

                                        <div class="timeline-body">
                                            <img src="http://placehold.it/150x100" alt="..." class="margin">
                                            <img src="http://placehold.it/150x100" alt="..." class="margin">
                                            <img src="http://placehold.it/150x100" alt="..." class="margin">
                                            <img src="http://placehold.it/150x100" alt="..." class="margin">
                                        </div>
                                    </div>
                                </li>
                                <!-- END timeline item -->
                                <li>
                                    <i class="fa fa-clock-o bg-gray"></i>
                                </li>
                            </ul>
                        </div>
                        <!-- /.tab-pane -->
                        
                        <div class="tab-pane" id="settings">
                            <form class="form-horizontal">
                                <div class="form-group">
                                    <label for="inputName" class="col-sm-2 control-label">Name</label>

                                    <div class="col-sm-10">
                                        <input type="email" class="form-control" id="inputName" placeholder="Name">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="inputEmail" class="col-sm-2 control-label">Email</label>

                                    <div class="col-sm-10">
                                        <input type="email" class="form-control" id="inputEmail" placeholder="Email">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="inputName" class="col-sm-2 control-label">Name</label>

                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="inputName" placeholder="Name">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="inputExperience" class="col-sm-2 control-label">Experience</label>

                                    <div class="col-sm-10">
                                        <textarea class="form-control" id="inputExperience" placeholder="Experience"></textarea>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="inputSkills" class="col-sm-2 control-label">Skills</label>

                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="inputSkills" placeholder="Skills">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-offset-2 col-sm-10">
                                        <div class="checkbox">
                                            <label>
                                                <input type="checkbox"> I agree to the <a href="#">terms and conditions</a>
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-offset-2 col-sm-10">
                                        <button type="submit" class="btn btn-danger">Submit</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <!-- /.tab-pane -->
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

        var slider = document.getElementById("cust");
        slider.className += " active";
        var menu = document.getElementById("commentMenu");
        menu.className += "active";
        //alert(slider.className);
    </script>


</body>
</html>


