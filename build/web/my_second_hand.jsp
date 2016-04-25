<%@include file="header.jsp" %>
<%@ page import="bean.*" %>
<jsp:useBean id="shs" class="bean.SecondHands" scope="request"/>
<!--==============================content================================-->
<section id="content" class="cont_pad">
    <div class="breadcrump">
        <ul>
            <li>My Account</li>
            <li>My Second Hand Toy</li>
        </ul>
    </div>
    <div class="row">
        <article class="grid_8">
            <h2 class="blue ind1">My Second Hand Toy</h2>
            <%                if (request.getAttribute("alert") != null) {
                    out.print(request.getAttribute("alert"));
                }
            %>
            <div class="row">
                <div class="grid_8">
                    <div class="alert alert-info"><strong>You can Click <a href="/toy/SecondHandToy?action=submit">Here</a> to submit a new Second Hand Toy!</strong></div>
                    <%
                        if (request.getAttribute("action") != null && request.getAttribute("action").equals("submit")) {
                            out.print(Template.getSubmitSecondHand());
                        } else {

                            for (int i = 0; i < shs.getShs().size(); i++) {
                                out.print(Template.getSecondHand(shs.getShs().get(i)));
                            }
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