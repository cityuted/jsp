<jsp:include page="header.jsp"/>
<%@page import="bean.Template"%>
<!--==============================content================================-->
<section id="content" class="cont_pad">
    <div class="breadcrump">
        <ul>
            <li>Create an Account</li>
        </ul>
    </div>
    <div class="row">
        <article class="grid_8">
            <h2 class="blue ind1">Create an Account</h2>
            <form id="create_account" method="post" action="/toy/Register">
                <%
                    if (request.getAttribute("alert") != null) {
                        out.print(request.getAttribute("alert"));
                    }
                %>
                <div class="account_box">
                    <div class="form_title">Your Personal Details</div>
                    <div class="inner">
                        <label>
                            <span>First Name <sup class="red">*</sup></span>
                            <input type="text" name="firstName">
                        </label>
                        <label>
                            <span>Last Name <sup class="red">*</sup></span>
                            <input type="text" name="lastName">
                        </label>
                        <label>
                            <span>Login Name <sup class="red">*</sup></span>
                            <input type="text" name="loginName">
                        </label>
                        <label>
                            <span>E-Mail <sup class="red">*</sup></span>
                            <input type="text" name="email">
                        </label>
                        <label>
                            <span>Telephone <sup class="red">*</sup></span>
                            <input type="text" name="phone">
                        </label>
                    </div>
                </div>
                <div class="account_box">
                    <div class="form_title">Your Contact Details</div>
                    <div class="inner">
                        <label>
                            <span>Address<sup class="red">*</sup></span>
                            <input type="text" name="address">
                        </label>
                    </div>
                </div>
                <div class="account_box">
                    <div class="form_title">Your Password</div>
                    <div class="inner">
                        <label>
                            <span>Password<sup class="red">*</sup></span>
                            <input type="password" name="password">
                        </label>
                        <label class="last">
                            <span>Password Confirm<sup class="red">*</sup></span>
                            <input type="password" name="password2">
                        </label>
                    </div>
                </div>
                <div class="account_box">
                    <div class="form_title">Gender</div>
                    <div class="inner">
                        <ul class="radioblock last">
                            <li class="radio">Male</li>
                            <li class="separate_li"></li>
                            <li class="radio last">Female</li>
                            <input name="sex" type="hidden" id="radion" />
                        </ul>
                    </div>
                </div>
                <label class="checkboxes last">
                    <div class="check">
                        I have read and agree to the <a href="#" class="link2">Privacy Policy</a>
                        <input type="checkbox" value="Remember Me" />
                    </div>
                </label><br>
                <a href="javascript:;" onclick="get_form(this).submit(); return false" class="button">Register</a>
            </form>
        </article>
        <article class="grid_4">
            <div class="top_rated_block p_top_zero">
                <h3 class="blue bg_none">Recently Viewed</h3>
                <ul class="ext_list">

                    <%
                        Cookie[] cookies = null;
                        cookies = request.getCookies();
                        if (cookies != null) {
                            int k = 0;
                            for (int i = cookies.length - 1; i > 0; i--) {
                                if (k >= 8) {
                                    break;
                                }
                                Cookie cookie = cookies[i];
                                out.print(Template.getRecently(cookie.getValue()));
                                k++;
                            }
                        }
                    %>

                </ul>
            </div>
        </article>
    </div>
</section>
</div>
<!--==============================footer=================================-->
<jsp:include page="footer.jsp"/>