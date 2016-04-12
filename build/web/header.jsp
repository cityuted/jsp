<!DOCTYPE html>
<%@ page import="bean.Toy" %>
<%@ page import="bean.Template" %>
<jsp:useBean id="user" class="bean.User" scope="session"/>
<jsp:useBean id="cart" class="bean.Cart" scope="session"/>

<html>
    <head>

        <title><jsp:getProperty name="user" property="userName"/></title>

        <meta charset="utf-8">

        <link rel="icon" href="images/favicon.html" type="image/x-icon">

        <link rel="shortcut icon" href="images/favicon.html" type="image/x-icon" />

        <link rel="stylesheet" type="text/css" media="screen" href="css/style.css">

        <script type="text/javascript" src="js/jquery.js"></script>

        <script src="js/script.js"></script>
        <script type="text/javascript">
            function get_form(element)
            {
                while (element)
                {
                    element = element.parentNode
                    if (element.tagName.toLowerCase() == "form")
                    {
                        //alert( element ) //debug/test
                        return element
                    }
                }
                return 0; //error: no form found in ancestors
            }
        </script>
    </head>

    <body>
        <div class="main">

            <!--==============================header=================================-->

            <header>



                <div class="container">

                    <div class="header_bottom">

                        <h1><a class="logo" href="/toy/"></a></h1>

                        <div class="call_us">

                            Contact: <span>+852 34428580</span>

                        </div>

                        <div id="shopping_cart">

                            <span class="cart_icon"></span>

                            <span class="cart_items"><%=cart.getSize()%> items</span>

                            <div class="cart_content">

                                <div class="cart_inner">

                                    <ul class="cart_list">

                                       <%
                                           for(int i=0;i<cart.getToys().size();i++){
                                               Toy toy = cart.getToys().get(i);
                                               out.println(Template.cartInHeader(toy.getToyIcon(), toy.getToyName(), toy.getCashpoint(), toy.getQTY()));
                                           }
                                       
                                       %>

                            

                                    </ul>

                                    <div class="total">

                                        Total: <span>$<%=cart.getTotal()%></span>

                                    </div>

                                    <div class="cart_buttons">

                                        <a href="/toy/Checkout" class="checkout">Checkout</a><a href="/toy/Cart" class="view_cart">View Cart</a>

                                    </div>

                                </div>

                            </div>

                        </div>

                        <div class="clear"></div>

                    </div>

                </div>

            </header>

            <div class="container">

                <nav class="main-menu">

                    <div id="menu-icon">Menu</div>

                    <ul class="sf-menu">

                        <li class="first_item current"><a href="/toy/">Home</a>



                        </li>

                        <li><a href="/toy/Category">Shop</a>

                            <ul>

                                <li class="first_item"><a href="/toy/Category">Toys on SALE</a></li>

                                <li><a href="/toy/Category?type=age">Toys by Age</a>

                                    <ul>

                                        <li class="first_item"><a href="category.html">Toys on SALE</a></li>

                                        <li><a href="category.html">Toys by Age</a></li>

                                        <li><a href="category.html">Toys for Boys</a></li>

                                        <li><a href="category.html">Toys for Girls</a></li>

                                        <li class="last_item"><a href="category.html">Neutral Toys</a></li>

                                    </ul>

                                </li>

                                <li><a href="category.html">Toys for Boys</a>

                                    <ul>

                                        <li class="first_item"><a href="category.html">Toys on SALE</a></li>

                                        <li><a href="category.html">Toys by Age</a></li>

                                        <li><a href="category.html">Toys for Boys</a></li>

                                        <li><a href="category.html">Toys for Girls</a></li>

                                        <li class="last_item"><a href="category.html">Neutral Toys</a></li>

                                    </ul>

                                </li>

                                <li><a href="category.html">Toys for Girls</a></li>

                                <li class="last_item"><a href="category.html">Neutral Toys</a></li>

                            </ul>

                        </li>



                        <li><a href="/toy/Contact">Contact</a></li>

                        <li><a href="/toy/Register">Register</a></li>

                        <li><a href="/toy/Login">Login</a></li>

                    </ul>

                    <form id="search" method="get" action="/toy/Category">

                        <label>

                            <input name="search" type="text" value="Search" onBlur="if (this.value == '')
                                        this.value = 'Search'" onFocus="if (this.value == 'Search')
                                                    this.value = ''">

                            
                        <a href="javascript:;" onclick="get_form(this).submit(); return false" ></a>
                        </label>

                    </form>

                    <div class="clear"></div>

                </nav>
