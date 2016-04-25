<%-- 
    Document   : content
    Created on : 2016/4/8, 下午 01:34:29
    Author     : Mesong
--%>

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

                <h3 class="box-title">Toy Category Table</h3>

                <div class="box-tools">
                    <span class='pull-left' style="margin-right:5px">
                        <button type="button"  onclick='javascript:location.href = "/toy/managerPage/createToyCategory.jsp"' class="btn btn-block btn-info"  >Create Category</button>
                    </span>
                    <div class="input-group pull-right input-group-sm" style="width: 150px;">

                        <!--<input type="text" name="table_search" class="form-control pull-right" placeholder="Search">-->
                        <input type="search" class="form-control light-table-filter" data-table="order-table" placeholder="Filter">

                        <span class="input-group-addon"><i class="fa fa-search"></i></span>

                    </div>
                </div>
            </div>
            <jsp:useBean id="categoryList"  type="java.util.ArrayList<Category>" scope="session"/>

            <%   total = pageNumber * 15;%>
            <!-- /.box-header -->
            <div class='box-body table-responsive no-padding' style="min-height:170px">
                <table class='table table-hover order-table'>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Category Name</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            int k = 0;


                        %>
                    
                    <%                        
                        for (k = 0; k < categoryList.size(); k++) {
                            Category cat = categoryList.get(k);
                            if (k > (pageNumber) * 15-1 || k < (pageNumber - 1) * 15) {
                                out.println("<tr style='display:none'>");
                            } else {
                                out.println("<tr>");
                            }
                            out.print(String.format("<td>%s</td>", cat.getCategoryID()));

                            out.print(String.format("<td>%s</td>", cat.getCategoryName()));

                            //String createUrl = "/toy/doCreateCategory?categoryID=" + cat.getCategoryID();
                            String updateUrl = "/toy/managerPage/updateCategory.jsp?categoryID=" + cat.getCategoryID();
                            String deleteUrl = "/toy/managerPage/deleteCategory.jsp?categoryID=" + cat.getCategoryID();
                            String disabled = "";
                            if (session.getAttribute(cat.getCategoryID() + ".isvalid").equals("true")) {
                                disabled = "disabled";
                            }

                            out.println("<td>");
//                             
                            out.println("<div class='btn-group'>"
                                    + "<button type='button' onclick='javascript:location.href=\"" + updateUrl + "\"' class='btn btn-primary'><i class='fa fa-edit'></i></button>"
                                    + "<button type='button'" + disabled + " onclick='javascript:location.href=\"" + deleteUrl + "\"' class='btn btn-danger'><i class='fa fa-close'></i></button>"
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
                        Showing <%= ((pageNumber - 1) * 15 + 1)%> to <%=total%> of <%=categoryList.size()%> entries
                    </div>
                </div>
                <div class="col-sm-7">
                    <div class="dataTables_paginate paging_simple_numbers" id="example2_paginate">
                        <ul class="pagination">
                            <li class="paginate_button previous <% if (pageNumber == 1) {
                                    out.println("disabled");
                                }%>" id="example2_previous">
                                <a href="/toy/managerPage/categoryAdminPage.jsp?page=<% pageNumber = (pageNumber > 1) ? --pageNumber : pageNumber;
                                    out.print(pageNumber);%>" aria-controls="example2" data-dt-idx="0" tabindex="0">Previous</a>
                            </li>
                            <% int index = categoryList.size() / 15 + 1;
                                int i = 1;
                            %>
                            <% for (i = 1; i <= index; i++) {
                                    out.println("<li class='paginate_button'>");
                                    String url = String.format("/toy/managerPage/categoryAdminPage.jsp?page=%s", i);
                                    out.println(String.format("<a href='%s' aria-controls='example2' data-dt-idx='%s' tabindex='0'> %s </a>", url, i, i));

                                    out.println("</li>");
                                }
                            %>
                            <li class="paginate_button next <% if (total >= categoryList.size()) {
                                    out.println("disabled");
                                }%>" id="example2_next">
                                <a href="/toy/managerPage/categoryAdminPage.jsp?page=<% pageNumber = (pageNumber < index) ? ++pageNumber : pageNumber;
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

