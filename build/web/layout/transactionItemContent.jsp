<%-- 
    Document   : content
    Created on : 2016/4/8, 下午 01:34:29
    Author     : Mesong
--%>

<%@page import="bean.TransactionItem"%>
<%@page import="db.TransactionDB"%>
<%@page import="bean.TransactionHeader"%>
<%@page import="bean.Category"%>
<%@page import="bean.SecondHand"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.Toy"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! int pageNumber = 1;
    int total = 0;
%>
<%

    TransactionDB tranItemDB = new TransactionDB();
    ArrayList<TransactionItem> items = null;
    int temp = 0;
    if (request.getParameter("transactionID") != null) {
        temp = Integer.parseInt(request.getParameter("transactionID"));
        items = tranItemDB.listTransactionItem(temp);
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

                <h3 class="box-title">Transaction Header Table</h3>

                <div class="box-tools">

                    <div class="input-group input-group-sm" style="width: 150px;">

                        <!--<input type="text" name="table_search" class="form-control pull-right" placeholder="Search">-->
                        <input type="search" class="form-control light-table-filter" data-table="order-table" placeholder="Filter">

                        <span class="input-group-addon"><i class="fa fa-search"></i></span>

                    </div>
                </div>
            </div>



            <!-- /.box-header -->
            <div class='box-body table-responsive no-padding' style="min-height:170px">
                <table class='table table-hover order-table'>
                    <thead>
                        <tr>
                            <th>Toy ID</th>
                            <th>Toy Name</th>
                            <th>Toy Cashpoint</th>
                            <th>QTY</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%                            int k = 0;


                        %>

                        <%                        for (k = 0; k < items.size(); k++) {
                                TransactionItem tranItem = items.get(k);

                                out.println("<tr>");

                                out.print(String.format("<td>%s</td>", tranItem.getToyID()));

                                out.print(String.format("<td>%s</td>", tranItem.getToyName()));

                                out.print(String.format("<td>%s</td>", tranItem.getCashPoint()));
                                out.print(String.format("<td>%s</td>", tranItem.getQTY()));

                                //String createUrl = "/toy/doCreateCategory?categoryID=" + cat.getCategoryID();
                                 String viewUrl = "/toy/managerPage/viewToy.jsp?id=" + tranItem.getToyID();
                                //String updateUrl = "/toy/managerPage/updateTransactionHeader.jsp?transactionID=" + tran.getTRANSACTIONID();
                                String disabled = "";
                                //                            if (session.getAttribute(cat.getCategoryID() + ".isvalid").equals("true")) {
                                //                                disabled = "disabled";
                                //                            }
                                out.println("<td>");
//                             
                                out.println("<div class='btn-group-vertical'>"
                                        + "<button type='button' onclick='javascript:location.href=\"" + viewUrl + "\"' class='btn btn-success'><i class='fa fa-search'></i></button>"
                                       
                                        + "</div>");
                                out.println("</td>");
                                out.println("</tr>");
                            }

                        %>

                    </tbody></table>



            </div>

            <!-- /.box-body -->
        </div>
        <!-- /.box -->
    </div>
</section>

