<%@include file="header.jsp" %>
<!--==============================content================================-->
<section id="content" class="cont_pad">
    <div class="breadcrump">
        <ul>
            <li><a href="#">Home</a></li>
            <li><a href="#">Features</a></li>
            <li><a href="#">Pages</a></li>
            <li>Checkout</li>
        </ul>
    </div>
    <div class="row">
        <article class="grid_8">
            <h2 class="blue ind1">Checkout</h2>
            <ul id="accordion2" class="accordion checkout">
                <li id="checkout_block">
                    <a href="javascript:;"><i></i>Step 1: Checkout Options</a>
                    <div class="accordion_content">
                        <form class="row checkout_form">
                            <div class="grid_4">
                                <div class="pad_box1 separate">
                                    <h3 class="green2 bg_none">New Customer?</h3>
                                    <ul class="radioblock">
                                        <li class="radio active">Register Account</li>
                                        <li class="radio">Guest Checkout</li>
                                        <input type="hidden" id="radion" />
                                    </ul>
                                    <div class="gray">By creating an account you will be able to shop faster, be up to date on an order's status, and keep track of the orders you have previously made.</div>
                                    <a href="#" class="button">Continue</a>
                                </div>
                            </div>
                            <div class="grid_4">
                                <div class="pad_box2">
                                    <h3 class="pink1 ind bg_none">Returning Customer</h3>
                                    <label>
                                        <span>Username</span>
                                        <input type="text">
                                    </label>
                                    <label>
                                        <span>Password</span>
                                        <input type="text">
                                    </label>
                                    <label class="checkboxes last">
                                        <div class="check">
                                            Remember Me
                                            <input type="checkbox" value="Remember Me" />
                                        </div>
                                    </label>
                                    <div class="rel">
                                        <a href="#" class="form_btn log_in">Log In</a>
                                        <ul class="forgot">
                                            <li><a href="#">Forgot your password?</a></li>
                                            <li><a href="#">Forgot your username?</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </li>
                <li id="billind_block">
                    <a href="javascript:;"><i></i>Step 2: Billing Details</a>
                    <div class="accordion_content ">
                        <form class="row checkout_form">
                            <article class="grid_8">

                                <div class="pad_box3">
                                    <p class="p2">Please select the preferred reciever to use on this order.</p>
                                    <ul class="radioblock">
                                        <li class="radio active">Account owner</li>
                                        <li class="radio">Other one</li>
                                        <input type="hidden" id="radion1" />
                                    </ul>
                                    <label>
                                        <span>First Name<sup>*</sup></span>
                                        <input type="text">
                                    </label>
                                    <label>
                                        <span>Last Name<sup>*</sup></span>
                                        <input type="text">
                                    </label>
                                    <label>
                                        <span>E-mail<sup>*</sup></span>
                                        <input type="text">
                                    </label>
                                    <label>
                                        <span>Telephone<sup>*</sup></span>
                                        <input type="text">
                                    </label>
                                    <a href="#" class="button">Continue</a>
                                </div>
                            </article>
                        </form>
                    </div>
                </li>
                <li id="delivery_block">
                    <a href="javascript:;"><i></i>Step 3: Delivery Details</a>
                    <div class="accordion_content">
                        <div class="pad_box5">
                            <form class="checkout_form">
                                <p class="p2">Please select the preferred address to use on this order.</p>
                                <ul class="radioblock">
                                    <li class="radio active">Account Address</li>
                                    <li class="radio">New Address</li>
                                    <input type="hidden" id="radion1" />
                                </ul>
                                <textarea>Add Comment here...</textarea>
                                <a href="#" class="button">Continue</a>
                            </form>
                        </div>
                    </div>
                </li>
                <li id="del_method_block">
                    <a href="javascript:;"><i></i>Step 4: Delivery Method</a>
                    <div class="accordion_content">
                        <div class="pad_box5">
                            <form class="checkout_form">
                                <p class="p2">Please select the preferred shipping method to use on this order.</p>
                                <ul class="radioblock">
                                    <li class="radio active">Flat Shipping Rate</li>
                                    <li class="radio">Air freight</li>
                                    <input type="hidden" id="radion1" />
                                </ul>
                                <textarea>Add Comment here...</textarea>
                                <a href="#" class="button">Continue</a>
                            </form>
                        </div>
                    </div>
                </li>
                <li id="payment_block">
                    <a href="javascript:;"><i></i>Step 5: Payment Method</a> 
                    <div class="accordion_content">
                        <div class="pad_box5">
                            <form class="checkout_form">
                                <p class="p2">Please select the preferred shipping method to use on this order.</p>
                                <ul class="radioblock">
                                    <li class="radio active">Cash Point On Delivery</li>
                                    <li class="radio active">Credit Card On Delivery</li>
                                    <input type="hidden" id="radion2" />
                                </ul>
                                <textarea>Add Comment here...</textarea>
                                <label class="checkboxes">
                                    <div class="check">
                                        I have read and agree to the <a href="#" class="link2">Privacy Policy</a>
                                        <input type="checkbox" value="Remember Me" />
                                    </div>
                                </label><br>
                                <a href="#" class="button">Continue</a>
                            </form>
                        </div>
                    </div>
                </li>
                <li>
                    <a href="javascript:;"><i></i>Step 6: Confirm Order</a> 
                    <div class="accordion_content">
                        <div class="pad_box5">
                            <div class="table_wrap">
                                <table class="order_table confirm">
                                    <tr>
                                        <th class="width_7">Product Name</th>
                                        <th class="width_4">Model</th>
                                        <th class="width_8">Quantity</th>
                                        <th class="width_8">Price</th>
                                        <th>Total</th>
                                    </tr>
                                    <%                        for (int i = 0; i < cart.getToys().size(); i++) {
                                            Toy toy = cart.getToys().get(i);
                                            out.println(Template.getCart(toy.getToyIcon(), toy.getToyName(), toy.getCashpoint(), toy.getQTY(), toy.getToyID()));
                                        }

                                    %>
                                </table>
                            </div>
                            <a href="#" class="button continue">Continue Shopping</a>&nbsp;
                            <a href="#" class="form_btn log_in">Checkout</a>
                        </div>
                    </div>
                </li>
            </ul>
        </article>

    </div>
</section>
</div>
<!--==============================footer=================================-->
<%@include file="footer.jsp" %>