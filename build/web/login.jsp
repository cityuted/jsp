<jsp:include page="header.jsp"/>
<!--==============================content================================-->
<section id="content" class="cont_pad">
    <div class="breadcrump">
        <ul>
            <li><a href="#">Home</a></li>
            <li><a href="#">Features</a></li>
            <li><a href="#">Pages</a></li>
            <li>Create an Account</li>
        </ul>
    </div>
    <div class="row">
        <article class="grid_8">
            <h2 class="blue ind1">Login</h2>
            <form id="create_account" method="post" action="/toy/Login">
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