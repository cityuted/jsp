<%@include file="header.jsp" %>
<!--==============================content================================-->
<section id="content" class="cont_pad">
    <div class="breadcrump">
        <ul>
            <li><a href="#">Pages</a></li>
            <li>Shopping Cart</li>
        </ul>
    </div>
    <div class="row">
        <article class="grid_12">
            <h2 class="blue ind2">Shopping Cart</h2>
            <div class="table_wrap p4">
                <table class="order_table confirm">
                    <tr>
                        <th class="width_7">Product Name</th>
                        <th class="width_4">Model</th>
                        <th class="width_8">Quantity</th>
                        <th class="width_9">Cash Point</th>
                        <th class="width_9 last_th">Total</th>
                        <th class="width_9 last_th">Delete</th>
                    </tr>
                    <%                        for (int i = 0; i < cart.getToys().size(); i++) {
                            Toy toy = cart.getToys().get(i);
                            out.println(Template.getCart(toy.encodedImage(), toy.getToyName(), toy.getCashpoint(), toy.getQTY(), toy.getToyID(),toy.getSecondHandID()));
                        }

                    %>

                </table>
            </div>
            <div class="total_wrap">
                <dl class="total_list var2">
                    <dd class="total_price"><span>Total:</span>$<%=cart.getTotal()%></dd>
                    
                </dl>
            </div>
            <a href="<%=request.getHeader("Referer")%>" class="button">Continue Shopping</a>&nbsp;
            <%
                if (cart.getSize() > 0) {
                    out.println("<a href=\"/toy/Checkout\" class=\"form_btn log_in\" >Checkout</a>");
                }
            %>

        </article>
    </div>
</section>
</div>
<!--==============================footer=================================-->
<jsp:include page="footer.jsp"/>