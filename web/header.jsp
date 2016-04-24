<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<%@ page import="bean.*" %>
<%@ page import="db.categoryDB" %>
<%@ page import="bean.Template" %>
<jsp:useBean id="user" class="bean.User" scope="session"/>
<jsp:useBean id="cart" class="bean.Cart" scope="session"/>

<html>
    <head>

        <title>Online Toy Shopping</title>

        <meta charset="utf-8">

        <link rel="icon" href="images/favicon.html" type="image/x-icon">

        <link rel="shortcut icon" href="images/favicon.html" type="image/x-icon" />
        <link rel="stylesheet" type="text/css" href="css/alerts.css">
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

                <div class="header_top">
                    <div class="container">

                        <ul class="block_headerlinks">
                            <%
                                if (user.getUserID() == 0) {
                                    out.print("<li><a href=\"/toy/Register\">Create account</a></li>\n"
                                            + "                            <li><a href=\"/toy/Login\" class=\"modal-toggle-1\">Login</a></li>");
                                } else {
                                    out.print("<li><a href=\"/toy/MyAccount\" class=\"modal-toggle-1\">My Account</a></li><li><a href=\"/toy/Logout\" class=\"modal-toggle-1\">Logout</a></li>");
                                }
                            %>

                        </ul>
                        <div class="clear"></div>
                    </div>
                </div>

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
                                            for (int i = 0; i < cart.getToys().size(); i++) {
                                                Toy toy = cart.getToys().get(i);
                                                out.println(Template.cartInHeader(toy.encodedImage(), toy.getToyName(), toy.getCashpoint(), toy.getQTY()));
                                            }

                                        %>



                                    </ul>

                                    <div class="total">

                                        Total: <span>$<%=cart.getTotal()%></span>

                                    </div>

                                    <div class="cart_buttons">
                                        <%
                                            if (cart.getSize() > 0) {
                                                out.println("<a href=\"/toy/Checkout\" class=\"checkout\" >Checkout</a>");
                                            }
                                        %>
                                        <a href="/toy/Cart" class="view_cart">View Cart</a>

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

                        <li id="lihome" class="first_item"><a href="/toy/">Home</a>



                        </li>

                        <li id="lishop"><a href="/toy/Category?order=asc&sort=TOYNAME">Shop</a>

                            <ul>

                                <%
                                    categoryDB catedb = new categoryDB();
                                    ArrayList<bean.Category> listCate = catedb.listToyCategory();
                                    for (int i = 0; i < listCate.size(); i++) {
                                        
//                                            if (!listCate.get(i).getCategoryName().toLowerCase().contains("age")) {
//                                                out.print("<li><a href=\"/toy/Category?order=asc&sort=TOYNAME&cate=" + listCate.get(i).getCategoryID() + "\">" + listCate.get(i).getCategoryName() + "</a></li>");
//                                            }
                                        if (!listCate.get(i).getCategoryName().toLowerCase().matches(".*age.*")) {
                                                out.print("<li><a href=\"/toy/Category?order=asc&sort=TOYNAME&cate=" + listCate.get(i).getCategoryID() + "\">" + listCate.get(i).getCategoryName() + "</a></li>");
                                            }
                                        
                                    }
                                %>

                                <li><a>Toys by Age</a>

                                    <ul>

                                        <%
                                            for (int i = 0; i < listCate.size(); i++) {
                                                
                                                //    if (listCate.get(i).getCategoryName().toLowerCase().contains("age")) {
                                               //         out.print("<li><a href=\"/toy/Category?order=desc&sort=TOYNAME&cate=" + listCate.get(i).getCategoryID() + "\">" + listCate.get(i).getCategoryName() + "</a></li>");
                                                 //   }
                                                 if (listCate.get(i).getCategoryName().toLowerCase().matches(".*age.*")) {
                                                        out.print("<li><a href=\"/toy/Category?order=desc&sort=TOYNAME&cate=" + listCate.get(i).getCategoryID() + "\">" + listCate.get(i).getCategoryName() + "</a></li>");
                                                    }
                                                
                                            }
                                        %>



                                    </ul>

                                </li>
                            </ul>

                        </li>



                        <li id="licontact"><a href="/toy/Contact">Contact</a></li>



                    </ul>

                    <form id="search" method="get" action="/toy/Category">

                        <label>
                            <input type="hidden" name="order" value="Asc" />
                            <input type="hidden" name="sort" value="ToyName" />
                            <input name="search" type="text" value="Search" onBlur="if (this.value == '')
                                        this.value = 'Search'" onFocus="if (this.value == 'Search')
                                                    this.value = ''">


                            <a href="javascript:;" onclick="get_form(this).submit(); return false" ></a>
                        </label>

                    </form>

                    <div class="clear"></div>

                </nav>
