<jsp:include page="header.jsp"/>
<!--==============================content================================-->
<section id="content" class="cont_pad">
    <div class="breadcrump">
        <ul>
            <li><a href="#">Pages</a></li>
            <li>Create an Account</li>
        </ul>
    </div>
    <div class="row">
        <article class="grid_8">
            <h2 class="blue ind1">Create an Account</h2>
            <form id="create_account" method="post" action="/toy/Register">
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
                    <div class="form_title">Newsletter Subscribe</div>
                    <div class="inner">
                        <ul class="radioblock last">
                            <li class="radio active">Yes</li>
                            <li class="separate_li"></li>
                            <li class="radio last">No</li>
                            <input type="radio" name="sex" value="MALE" checked> Male<br>
                            <input type="radio" name="sex" value="FEMALE"> Female<br>
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
            <h3 class="ind">Categories</h3>
            <ul class="categories sf-menu">
                <li><a href="#">Toys on SALE</a></li>
                <li><a href="#">Toys by Age</a></li>
                <li><a href="#">Animals &amp; Wildfire</a></li>
                <li><a href="#">Arts, Crafts &amp; Music</a></li>
                <li><a href="#">Bath Toys</a></li>
                <li><a href="#">Books</a>
                    <ul>
                        <li><a href="#">Plastic</a></li>
                        <li><a href="#">Rubber</a></li>
                        <li><a href="#">Soft</a></li>
                        <li><a href="#">Wooden</a></li>
                    </ul>
                </li>
                <li><a href="#">Building Blocks</a></li>
                <li><a href="#">Classic &amp; Retro</a></li>
                <li><a href="#">Cool Vehicles</a></li>
                <li><a href="#">Games</a></li>
                <li><a href="#">Outdoor Toys</a></li>
                <li class="last_item"><a href="#">Party Favors</a></li>
            </ul>
            <a href="#" class="link1">View All</a>
            <div class="banner5">
                <a href="#"><img src="images/banner3.png" alt=""><span><img src="images/banner3_h.png" alt=""></span></a>
            </div>
            <div class="top_rated_block p_top_zero">
                <h3 class="blue bg_none">Recently Viewed</h3>
                <ul class="ext_list">
                    <li>
                        <figure><a href="#"><img src="images/top_rated1.jpg" alt=""></a></figure>
                        <div>
                            <h4 class="blue"><a href="#">Children soft toy</a></h4>
                            <div class="price">$15</div>
                            <div class="rating">
                                <span class="active"></span>
                                <span class="active"></span>
                                <span class="active"></span>
                                <span class="active"></span>
                                <span></span>
                            </div>
                        </div>
                    </li>
                    <li>
                        <figure><a href="#"><img src="images/top_rated2.jpg" alt=""></a></figure>
                        <div>
                            <h4 class="blue"><a href="#">Toy dinosaur</a></h4>
                            <div class="price">$9</div>
                            <div class="rating">
                                <span class="active"></span>
                                <span class="active"></span>
                                <span class="active"></span>
                                <span class="active"></span>
                                <span class="active"></span>
                            </div>
                        </div>
                    </li>
                    <li class="bg_none">
                        <figure><a href="#"><img src="images/top_rated3.jpg" alt=""></a></figure>
                        <div>
                            <h4 class="blue"><a href="#">Toy horse</a></h4>
                            <div class="price">$124</div>
                            <div class="rating">
                                <span class="active"></span>
                                <span class="active"></span>
                                <span class="active"></span>
                                <span></span>
                                <span></span>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </article>
    </div>
</section>
</div>
<!--==============================footer=================================-->
<jsp:include page="footer.jsp"/>