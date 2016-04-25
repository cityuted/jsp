<%@include file="header.jsp" %>
<%@ page import="bean.*" %>
<jsp:useBean id="shs" class="bean.SecondHands" scope="request"/>
<!--==============================content================================-->
<section id="content" class="cont_pad">
    <div class="breadcrump">
        <ul>
            <li>My Account</li>
            <li>Edit Account</li>
        </ul>
    </div>
    <div class="row">
        <article class="grid_8">
            <h2 class="blue ind1">Edit Account</h2>
            <%                if (request.getAttribute("alert") != null) {
                    out.print(request.getAttribute("alert"));
                }
            %>
            <div class="row">
                <div class="grid_8">
            <form id="create_account" method="post" action="/toy/EditAccount">
                <div class="account_box">
                    <div class="form_title">Your Personal Details</div>
                    <div class="inner">
                        <label>
                            <span>E-Mail <sup class="red">*</sup></span>
                            <input type="text" name="email" value="<%=user.getEmail()%>"/>
                        </label>
                        <label>
                            <span>Telephone <sup class="red">*</sup></span>
                            <input type="text" name="tel" value="<%=user.getUserPhone()%>"/>
                        </label>
                        <label>
                            <span>Address<sup class="red">*</sup></span>
                            <input type="text" name="address" value="<%=user.getUserAddress()%>">
                        </label>
                    </div>
                </div>
                <div class="account_box">
                    <div class="form_title">Change Password</div>
                    <div class="inner">
                        <label>
                            <span>New Password<sup class="red">*</sup></span>
                            <input type="password" name="password" >
                        </label>
                        <label>
                            <span>Password Confirm<sup class="red">*</sup></span>
                            <input type="password" name="password2" >
                        </label>
                    </div>
                </div>
                <a href="javascript:;" onclick="get_form(this).submit(); return false" class="form_btn log_in">Edit</a>
            </form>
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