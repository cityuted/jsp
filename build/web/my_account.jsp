<%@include file="header.jsp" %>
<!--==============================content================================-->
<section id="content" class="cont_pad">
    <div class="breadcrump">
        <ul>
            <li>My Account</li>
        </ul>
    </div>
    <div class="row">
        <article class="grid_8">
            <h2 class="blue ind1">My Account</h2>
            <%                if (request.getAttribute("alert") != null) {
                    out.print(request.getAttribute("alert"));
                }
            %>
            <div class="row">
                <div class="grid_8">
                    <ul id="accordion2" class="accordion">
                        <li>
                            <%
                                if (user != null && user.getUserID() != 0) {
                                    out.print("<a href='javascript:;'><i></i>My Account</a>");
                                    out.print("<div class='accordion_content pad1'>");
                                    out.print("<ul class='list2'>");
                                    out.print("<li><a href='#'>User Name: " + user.getUserName() + "</a></li>");
                                    out.print("<li><a href='#'>Cash Point: " + user.getCashpoint() + "</a></li>");
                                    out.print("<li><a href='#'>Email: " + user.getEmail() + "</a></li>");
                                    out.print("<li><a href='#'>Telephone: " + user.getUserPhone() + "</a></li>");
                                    out.print("<li><a href='#'>Address: " + user.getUserAddress() + "</a></li>");
                                    out.print("<li><a href='#'>Gender: " + user.getUserSex() + "</a></li>");
                                    out.print("</ul>");
                                    out.print("</div>");
                                }
                            %>

                        </li>
                    </ul> 
                </div>
            </div>
        </article>
        <article class="grid_4">
            <h3 class="ind">My Account</h3>
            <ul class="categories sf-menu">
                <li><a href="/toy/MyAccount">My Account</a></li>
                <li><a href="/toy/EditAccount">Edit Account</a></li>
                <li><a href="/toy/SecondHandToy">MY Second Hand Toy</a></li>
                <li><a href="/toy/OrderHistory">Order History</a></li>

                <li class="last_item"><a href="/toy/Logout">Logout</a></li>
            </ul>
        </article>
    </div>
</section>
</div>
<!--==============================footer=================================-->
<jsp:include page="footer.jsp"/>