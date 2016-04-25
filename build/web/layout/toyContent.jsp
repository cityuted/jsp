<%-- 
    Document   : content
    Created on : 2016/4/8, 下午 01:34:29
    Author     : Mesong
--%>

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
    })(document);</script>
<section class="content">
    <div class="col-xs-15">
        <div class="box">
            <div class="box-header">

                <h3 class="box-title">Toy Table</h3>

                <div class="box-tools">
                    <span class='pull-left' style="margin-right:5px">
                        <button type="button"  onclick='javascript:location.href = "/toy/managerPage/createToy.jsp"' class="btn btn-block btn-info"  >Create toy</button>
                    </span>
                    <span class='pull-left' style="margin-right:5px">
                        <button type="button"  onclick='javascript:location.href = "/toy/managerPage/updateDiscount.jsp"' class="btn btn-block  bg-orange "  >Update Discount by Category</button>
                    </span>
                    <div class="input-group input-group-sm  pull-right" style="width: 150px;">

                        <!--<input type="text" name="table_search" class="form-control pull-right" placeholder="Search">-->
                        <input type="search" class="form-control light-table-filter" data-table="order-table" placeholder="Filter">

                        <span class="input-group-addon"><i class="fa fa-search"></i></span>

                    </div>
                </div>
                
            </div>
            
            <jsp:useBean id="toyList"  type="java.util.ArrayList<Toy>" scope="session"/>

            <%   total = pageNumber * 15;%>
            <!-- /.box-header -->

            <div class='box-body table-responsive no-padding' style="min-height:170px;">
                <table class='table table-hover order-table' >
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Category</th>
                            <th>Cashpoint</th>                           
                            <th>Qty</th>
                            <th>Discount</th>
                            <th>Action</th>
                        </tr></thead>
                    <tbody>
                        <%
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
%>
                 
                     
                    

                    </tbody></table>






            </div>
            <div class="row">
                <div class="col-sm-5">
                    <div class="dataTables_info" id="example2_info" role="status" aria-live="polite">
                        Showing <%= ((pageNumber - 1) * 15 + 1)%> to <%=total%> of <%=toyList.size()%> entries
                    </div>
                </div>
                <div class="col-sm-7">
                    <div class="dataTables_paginate paging_simple_numbers" id="example2_paginate">
                        <ul class="pagination">
                            <li class="paginate_button previous <% if (pageNumber == 1) {
                                    out.println("disabled");
                                }%>" id="example2_previous">
                                <a href="toy/managerPage/adminPage.jsp?page=<% pageNumber = (pageNumber > 1) ? --pageNumber : pageNumber;
                                    out.print(pageNumber);%>" aria-controls="example2" data-dt-idx="0" tabindex="0">Previous</a>
                            </li>
                            <% int index = toyList.size() / 15 + 1;
                                int i = 1;
                            %>
                            <% for (i = 1; i <= index; i++) {
                                    out.println("<li class='paginate_button'>");
                                    String url = String.format("/toy/managerPage/adminPage.jsp?page=%s", i);
                                    out.println(String.format("<a href='%s' aria-controls='example2' data-dt-idx='%s' tabindex='0'> %s </a>", url, i, i));

                                    out.println("</li>");
                                }
                            %>
                            <li class="paginate_button next <% if (total >= toyList.size()) {
                                    out.println("disabled");
                                }%>" id="example2_next">
                                <a href="/toy/managerPage/adminPage.jsp?page=<% pageNumber = (pageNumber < index) ? ++pageNumber : pageNumber;
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

