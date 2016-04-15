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
            <div class="row">
                <div class="grid_8">
                    <ul id="accordion2" class="accordion">
                        <li>
                            <a href="javascript:;"><i></i>My Account</a>
                            <div class="accordion_content pad1">
                                <ul class="list2">
                                    <li><a href="#">User Name: <%=user.getUserName()%></a></li>
                                    <li><a href="#">Cash Point: <%=user.getCashpoint()%></a></li>
                                    <li><a href="#">Email: <%=user.getEmail()%></a></li>
                                    <li><a href="#">Telephone: <%=user.getUserPhone()%></a></li>
                                    <li><a href="#">Address: <%=user.getUserAddress()%></a></li>
                                    <li><a href="#">Gender: <%=user.getUserSex()%></a></li>
                                </ul>
                            </div>
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
                <li><a href="/toy/Logout">Wishlist</a></li>

                <li class="last_item"><a href="/toy/Logout">Logout</a></li>
            </ul>
        </article>
    </div>
</section>
</div>
<!--==============================footer=================================-->
<jsp:include page="footer.jsp"/>