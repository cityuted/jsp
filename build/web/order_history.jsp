<%@include file="header.jsp" %>
<%@ page import="bean.*" %>
<jsp:useBean id="ths" class="bean.TransactionHeaders" scope="request"/>
<!--==============================content================================-->
<section id="content" class="cont_pad">
    <div class="breadcrump">
        <ul>
            <li>My Account</li>
            <li>Order History</li>
        </ul>
    </div>
    <div class="row">
        <article class="grid_8">
            <h2 class="blue ind1">Order History</h2>
            <div class="row">
                <div class="grid_8">
                    <%
                        for(int i=0;i<ths.getThs().size();i++){
                            out.print(Template.getOrder(ths.getThs().get(i)));
                        }
                    %>

                </div>
            </div>
        </article>
        <article class="grid_4">
            <h3 class="ind">My Account</h3>
            <ul class="categories sf-menu">
                <li><a href="/toy/MyAccount">My Account</a></li>
                <li><a href="/toy/EditAccount">Edit Account</a></li>
                <li><a href="/toy/SecondHandToy">My Second Hand Toy</a></li>
                <li><a href="/toy/OrderHistory">Order History</a></li>

                <li class="last_item"><a href="/toy/Logout">Logout</a></li>
            </ul>
        </article>
    </div>
</section>
</div>
<!--==============================footer=================================-->
<jsp:include page="footer.jsp"/>