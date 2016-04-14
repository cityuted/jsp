<%@include file="header.jsp" %>
<%@ page import="bean.CheckoutStatus" %>
<jsp:useBean id="checkoutStatus" class="bean.CheckoutStatus" scope="session"/>
<!--==============================content================================-->
<section id="content" class="cont_pad">
    <div class="breadcrump">
        <ul>
            <li><a href="#">Pages</a></li>
            <li>Checkout</li>
        </ul>
    </div>
    <div class="row">
        <article class="grid_8">

            <h2 class="blue ind1">Checkout</h2>
            <%                if (request.getAttribute("alert") != null) {
                    out.print(request.getAttribute("alert"));
                }
            %>
            <ul id="accordion2" class="accordion checkout">

                <%
                    if (request.getAttribute("stepString") != null) {
                        out.println(request.getAttribute("stepString"));
                    }
                %>



            </ul>
        </article>

    </div>
</section>
</div>

<!--==============================footer=================================-->
<%@include file="footer.jsp" %>