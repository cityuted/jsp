<%-- 
    Document   : content
    Created on : 2016/4/8, 下午 01:34:29
    Author     : Mesong
--%>

<%@page import="bean.User"%>
<%@page import="bean.TransactionHeader"%>
<%@page import="bean.Category"%>
<%@page import="bean.SecondHand"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.Toy"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! int pageNumber = 1;
    int total = 0;
%>
<%  if (request.getParameter("page") != null) {
        pageNumber = Integer.parseInt(request.getParameter("page"));
    } else {
        pageNumber = 1;
    }

    
%>
<script>
    (function (document) {
        'use strict';

        var LightTableFilter = (function (Arr) {

            var _input;

            function _onInputEvent(e) {
                _input = e.target;
                var tables = document.getElementsByClassName(_input.getAttribute('data-table'));
                Arr.forEach.call(tables, function (table) {
                    Arr.forEach.call(table.tBodies, function (tbody) {
                        Arr.forEach.call(tbody.rows, _filter);
                    });
                });
            }

            function _filter(row) {
                var text = row.textContent.toLowerCase(),
                        val = _input.value.toLowerCase();
                row.style.display = text.indexOf(val) === -1 ? 'none' : 'table-row';
            }

            return {
                init: function () {
                    var inputs = document.getElementsByClassName('light-table-filter');
                    Arr.forEach.call(inputs, function (input) {
                        input.oninput = _onInputEvent;
                    });
                }
            };
        })(Array.prototype);

        document.addEventListener('readystatechange', function () {
            if (document.readyState === 'complete') {
                LightTableFilter.init();
            }
        });

    })(document);

</script>
<section class="content">
    <div class="col-xs-15">
        <div class="box">
            <div class="box-header">

                <h3 class="box-title">Customer Table</h3>

                <div class="box-tools">
                   
                    <div class="input-group input-group-sm" style="width: 150px;">

                        <!--<input type="text" name="table_search" class="form-control pull-right" placeholder="Search">-->
                        <input type="search" class="form-control light-table-filter" data-table="order-table" placeholder="Filter">

                        <span class="input-group-addon"><i class="fa fa-search"></i></span>

                    </div>
                </div>
            </div>
            <jsp:useBean id="userList"  type="java.util.ArrayList<User>" scope="session"/>

            <%   total = pageNumber * 15;%>
            <!-- /.box-header -->
            <div class='box-body table-responsive no-padding' style="min-height:170px">
                <table class='table table-hover order-table'>
                    <thead>
                        <tr>
                            <th>User ID</th>
                            <th>Name</th>
                            <th>Sex</th>
                            <th>Address</th>
                            <th>Phone</th>
                            <th>Email</th>
                            <th>Cashpoint</th>                   
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            int k = 0;


                        %>
                    
                    <%                        
                        for (k = 0; k < userList.size(); k++) {
                            User user = userList.get(k);
                            if (k > (pageNumber) * 15-1 || k < (pageNumber - 1) * 15) {
                                out.println("<tr style='display:none'>");
                            } else {
                                out.println("<tr>");
                            }
                            out.print(String.format("<td>%s</td>", user.getUserID()));
                            out.print(String.format("<td>%s</td>", user.getUserName()));                        
                            out.print(String.format("<td>%s</td>", user.getUserSex()));
                            out.print(String.format("<td>%s</td>", user.getUserAddress()));
                            out.print(String.format("<td>%s</td>", user.getUserPhone()));
                            out.print(String.format("<td>%s</td>", user.getEmail()));
                            out.print(String.format("<td>%s</td>" , user.getCashpoint()));
                      


                            //String createUrl = "/toy/doCreateCategory?categoryID=" + cat.getCategoryID();
                            String viewUrl = "/toy/managerPage/viewCustomerProfile.jsp?custID=" +  user.getUserID();
                            String updateUrl = "/toy/managerPage/updateCustomerProfile.jsp?custID=" +  user.getUserID();
                            
                            String disabled = "";
//                            if (session.getAttribute(cat.getCategoryID() + ".isvalid").equals("true")) {
//                                disabled = "disabled";
//                            }

                            out.println("<td>");
//                             
                            out.println("<div class='btn-group-vertical'>"
                                    + "<button type='button' onclick='javascript:location.href=\"" + viewUrl + "\"' class='btn btn-success'><i class='fa fa-search'></i></button>"
                                    + "<button type='button'" + disabled + " onclick='javascript:location.href=\"" + updateUrl + "\"' class='btn btn-primary'><i class='fa fa-edit'></i></button>"
                                    + "</div>");
                            out.println("</td>");

                            out.println("</tr>");
                        }

                    %>

                    </tbody></table>



            </div>
            <div class="row">
                <div class="col-sm-5">
                    <div class="dataTables_info" id="example2_info" role="status" aria-live="polite">
                        Showing <%= ((pageNumber - 1) * 15 + 1)%> to <%=total%> of <%=userList.size()%> entries
                    </div>
                </div>
                <div class="col-sm-7">
                    <div class="dataTables_paginate paging_simple_numbers" id="example2_paginate">
                        <ul class="pagination">
                            <li class="paginate_button previous <% if (pageNumber == 1) {
                                    out.println("disabled");
                                }%>" id="example2_previous">
                                <a href="/toy/managerPage/customerAdminPage.jsp?page=<% pageNumber = (pageNumber > 1) ? --pageNumber : pageNumber;
                                    out.print(pageNumber);%>" aria-controls="example2" data-dt-idx="0" tabindex="0">Previous</a>
                            </li>
                            <% int index = userList.size() / 15 + 1;
                                int i = 1;
                            %>
                            <% for (i = 1; i <= index; i++) {
                                    out.println("<li class='paginate_button'>");
                                    String url = String.format("/toy/managerPage/customerAdminPage.jsp?page=%s", i);
                                    out.println(String.format("<a href='%s' aria-controls='example2' data-dt-idx='%s' tabindex='0'> %s </a>", url, i, i));

                                    out.println("</li>");
                                }
                            %>
                            <li class="paginate_button next <% if (total >= userList.size()) {
                                    out.println("disabled");
                                }%>" id="example2_next">
                                <a href="/toy/managerPage/customerAdminPage.jsp?page=<% pageNumber = (pageNumber < index) ? ++pageNumber : pageNumber;
                                    out.println(pageNumber);%>" aria-controls="example2" data-dt-idx="7" tabindex="0">Next</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- /.box-body -->
        </div>
        <!-- /.box -->
    </div>
</section>

