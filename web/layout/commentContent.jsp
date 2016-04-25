<%-- 
    Document   : content
    Created on : 2016/4/8, 下午 01:34:29
    Author     : Mesong
--%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="bean.Message"%>
<%@page import="bean.TransactionHeader"%>
<%@page import="bean.Category"%>
<%@page import="bean.SecondHand"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.Toy"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! int pageNumber = 1;
    int total = 0;
    String keywords = "";
%>
<%  if (request.getParameter("page") != null) {
        pageNumber = Integer.parseInt(request.getParameter("page"));
    } else {
        pageNumber = 1;
       
    }


%>
<c:choose>
    <c:when test="${param.page==null || param.page ==0 }">
        <c:set var="pageNumber" scope="page" value="1"/>
    </c:when>

    <c:otherwise>
         <c:set var="pageNumber" scope="page" value="${param.page}"/>
    </c:otherwise>
</c:choose>     


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
    function search()
    {
        var filter = document.getElementById("filter");
         var url = document.getElementById("searchUrl");
        url.href ="/toy/doSearchComment?toyName=" + filter.value;
        
    }
</script>
<section class="content">
    <div class="col-xs-15">
        <div class="box">
            <div class="box-header">

                <h3 class="box-title">Comment Table</h3>

                <div class="box-tools">

                    <div class="input-group input-group-sm" style="width: 150px;">

                        <!--<input type="text" name="table_search" class="form-control pull-right" placeholder="Search">-->
                        <input type="search" class="form-control light-table-filter" onkeyup="search()" id="filter" data-table="order-table" placeholder="Filter">

                        <span class="input-group-addon"><a href="#" id="searchUrl"><i class="fa fa-search"></i></a></span>

                    </div>
                </div>
            </div>
            <jsp:useBean id="messagelist"  type="java.util.ArrayList<Message>" scope="session"/>

            <%   total = pageNumber * 15;%>
            <!-- /.box-header -->
            <div class='box-body table-responsive no-padding' style="min-height:170px">
                <table class='table table-hover order-table'>
                    <thead>
                        <tr>
                            <th>Message ID</th>                            
                            <th>Toy ID</th>
                            <th>Toy Name</th>
                            <th>User ID</th>
                            <th>User Name</th>
                            <th>Content</th>
                            <th>Date</th>                         
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                      
                        <c:set var="k" scope="page" value="0"/>
                        

                        <c:forEach items="${messagelist}" var="msg">

                            <c:choose>
                                <c:when test="${k > (pageNumber) * 15 || k < (pageNumber - 1) * 15}">
                                       <tr style='display:none'>
                               
                                </c:when>
                                
                                <c:otherwise>
                                        <tr>
                                           
                                </c:otherwise>
                            </c:choose>      
                                <td>${msg.messageID} </td>
                                <td>${msg.toyID}</td>
                                <td>${toylist[k].toyName}</td>
                                <td>${msg.custID}</td>
                                <td>${userlist[k].userName}</td>
                                <td>${msg.content}</td>
                                <td>${msg.date}</td>
                                <c:set var="viewUrl" scope="page" value="/toy/doSearchAllComments?ID=${msg.toyID}"/>
                                <td>
                                    <button type='button' onclick='javascript:location.href="${viewUrl}"' class='btn btn-success'>
                                        <i class='fa fa-search'></i>
                                    </button>
                                </td>
                               
                            </tr>
                            <c:set var="k" scope="page" value="${k+1}"/>
                        </c:forEach>
                        


                   


                    </tbody></table>



            </div>
            <div class="row">
                <div class="col-sm-5">
                    <div class="dataTables_info" id="example2_info" role="status" aria-live="polite">
                        Showing <%= ((pageNumber - 1) * 15 + 1)%> to <%=total%> of <%=messagelist.size()%> entries
                    </div>
                </div>
                <div class="col-sm-7">
                    <div class="dataTables_paginate paging_simple_numbers" id="example2_paginate">
                        <ul class="pagination">
                            <li class="paginate_button previous <% if (pageNumber == 1) {
                                    out.println("disabled");
                                }%>" id="example2_previous">
                                <a href="/toy/managerPage/commentAdminPage.jsp?page=<% pageNumber = (pageNumber > 1) ? --pageNumber : pageNumber;
                                    out.print(pageNumber);%>" aria-controls="example2" data-dt-idx="0" tabindex="0">Previous</a>
                            </li>
                            <% int index = messagelist.size() / 15 + 1;
                                int i = 1;
                            %>
                            <% for (i = 1; i <= index; i++) {
                                    out.println("<li class='paginate_button'>");
                                    String url = String.format("/toy/managerPage/commentAdminPage.jsp?page=%s", i);
                                    out.println(String.format("<a href='%s' aria-controls='example2' data-dt-idx='%s' tabindex='0'> %s </a>", url, i, i));

                                    out.println("</li>");
                                }
                            %>
                            <li class="paginate_button next <% if (total >= messagelist.size()) {
                                    out.println("disabled");
                                }%>" id="example2_next">
                                <a href="/toy/managerPage/commentAdminPage.jsp?page=<% pageNumber = (pageNumber < index) ? ++pageNumber : pageNumber;
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

