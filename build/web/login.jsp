<%@page import="bean.Template"%>
<jsp:include page="header.jsp"/>
<!--==============================content================================-->
<section id="content" class="cont_pad">
    <div class="breadcrump">
        <ul>
            <li>Login</li>
        </ul>
    </div>
    <div class="row">
        <article class="grid_8">
            <h2 class="blue ind1">Login</h2>
            <form id="create_account" method="post" action="/toy/Login">
                <%
                    if (request.getAttribute("alert") != null) {
                        out.print(request.getAttribute("alert"));
                    }
                %>
                <div class="account_box">

                    <div class="inner">




                        <div class="pad_box2">
                            <h3 class="pink1 ind bg_none">Welcome back</h3>
                            <label>
                                <span>Login Name</span>
                                <input name="loginName" type="text">
                            </label>
                            <label>
                                <span>Password</span>
                                <input name="password" type="password">
                            </label>
                            <label class="checkboxes last">
                                <div class="check">
                                    Remember Me
                                    <input type="checkbox" value="Remember Me" />
                                </div>
                            </label>
                            <div class="rel">
                                <a href="javascript:;" onclick="get_form(this).submit(); return false" class="form_btn log_in">Log In</a>
                                <ul class="forgot">
                                    <li><a href="#">Forgot your password?</a></li>
                                    <li><a href="#">Forgot your username?</a></li>
                                </ul>
                            </div>
                        </div>

                    </div>

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
                                if (k >= 4) {
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