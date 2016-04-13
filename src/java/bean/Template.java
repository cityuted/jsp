/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author ted
 */
public class Template {

    public static String getToyTemplate(String img, String name, String cashPoint, String id) {
        return "              <li>\n"
                + "                  <div>\n"
                + "                    <figure><a href=\"#\"><img src=\"images/" + img + "\" alt=\"\"></a></figure>\n"
                + "                    <div>\n"
                + "                      <h4><a href=\"#\">" + name + "</a></h4>\n"
                + "                      <div class=\"price\">$" + cashPoint + "</div>\n"
                + "                      <div class=\"product_buttons\">\n"
                + "                        <form method=\"post\" action=\"/toy/Cart\"> <input type=\"hidden\" name=\"id\" value=\"" + id + "\" /><a  href=\"javascript:;\" onclick=\"get_form(this).submit(); return false\" class=\"add_to_cart\"></a> </form>\n"
                + "                        <a href=\"/toy/ProductDetail?id=" + id + "\" class=\"detail_view\">Details</a>\n"
                + "                      </div>  \n"
                + "                    </div>\n"
                + "                  </div>\n"
                + "                </li>";
    }

    public static String getMessageTemplate(String name, String content, String Date, int rate) {
        Date = "Jan 29th 2013";
        return "                    <li>\n"
                + "                      <figure><img src=\"images/ava.jpg\" alt=\"\"></figure>\n"
                + "                      <div>\n"
                + "                        <div class=\"author\"><strong>" + name + "</strong> - " + Date + ":</div>\n"
                + "                        " + content + "\n"
                + "                      </div>\n"
                + "                      <div class=\"rating\">\n"
                + getRate(rate)
                + "                        <span></span>\n"
                + "                        <span></span>\n"
                + "                      </div>\n"
                + "                    </li>";
    }

    public static String getRate(int rate) {
        String s = "";
        for (int i = 0; i < rate; i++) {
            s += "<span class=\"active\"></span>";
        }
        return s;
    }

    public static String cartInHeader(String image, String name, int cashPoint, int qty) {
        int total = qty * cashPoint;
        return " <li>\n"
                + "\n"
                + "                                            <table>\n"
                + "\n"
                + "                                                <tr>\n"
                + "\n"
                + "                                                    <td class=\"product_image\">\n"
                + "\n"
                + "                                                        <img src=\"images/cart1.jpg\" alt=\"\">\n"
                + "\n"
                + "                                                    </td>\n"
                + "\n"
                + "                                                    <td class=\"product_desc\">\n"
                + "\n"
                + "                                                        <a href=\"#\">" + name + "</a>\n"
                + "\n"
                + "                                                    </td>\n"
                + "\n"
                + "                                                    <td class=\"product_quantity\">\n"
                + "\n"
                + "                                                        " + qty + " x <span>$" + cashPoint + "</span>\n"
                + "\n"
                + "                                                    </td>\n"
                + "\n"
                + "\n"
                + "                                                </tr>\n"
                + "\n"
                + "                                            </table>\n"
                + "\n"
                + "                                        </li>";
    }

    public static String getCart(String image, String name, int cashPoint, int qty, int id) {
        int total = qty * cashPoint;
        return "                    <tr>\n"
                + "                        <td>\n"
                + "                            <div class=\"ext_box confirm_product\">\n"
                + "                                <figure><img width=\"60\" height=\"60\" src=\"images/" + image + "\" alt=\"\"></figure>\n"
                + "                                <div>\n"
                + "                                    <a href=\"#\">" + name + "</a>\n"
                + "                                </div>\n"
                + "                            </div> \n"
                + "                        </td>\n"
                + "                        <td>" + id + "</td>\n"
                + "                        <td>\n"
                + "                            <form class=\"confirm_quantity\" action='/toy/Cart' method='post' ><input type='hidden' name='action' value='change' />\n"
                + "                                <input type='hidden' name='id' value='" + id + "' /><input name='qty'type=\"text\" value=\"" + qty + "\" onBlur=\"if (this.value == '' || this.value == 0)\n"
                + "                                            this.value = '1'\" onFocus=\"if (this.value == '1')\n"
                + "                                                        this.value = ''\">\n"
                + "                                <a href=\"javascript:;\" onclick=\"get_form(this).submit(); return false\" class=\"done\"></a>\n"
                + "                                </form>"
                + "                            \n"
                + "                        </td>\n"
                + "                        <td>$" + cashPoint + "</td>\n"
                + "                        <td>$" + total + "</td>\n"
                + "                        <td><form class=\"confirm_quantity\" method='post' action='/toy/Cart'><input type='hidden' name='action' value='change' /><input type='hidden' name='id' value='" + id + "'/><input type='hidden' name='qty' value='0' /><a href=\"javascript:;\" onclick=\"get_form(this).submit(); return false\" class=\"delete\"></a></form></td>\n"
                + "                    </tr>";
    }

    public static String getCartCheckout(String image, String name, int cashPoint, int qty, int id) {
        int total = qty * cashPoint;
        return "                    <tr>\n"
                + "                        <td>\n"
                + "                            <div class=\"ext_box confirm_product\">\n"
                + "                                <figure><img width=\"60\" height=\"60\" src=\"images/" + image + "\" alt=\"\"></figure>\n"
                + "                                <div>\n"
                + "                                    <a href=\"#\">" + name + "</a>\n"
                + "                                </div>\n"
                + "                            </div> \n"
                + "                        </td>\n"
                + "                        <td>" + id + "</td>\n"
                + "                        <td>\n"
                + "                            <form class=\"confirm_quantity\" action='/toy/Cart' method='post' >\n"
                + "                                <input type='hidden' name='id' value='" + id + "' /><input disabled=\"disabled\" name='qty'type=\"text\" value=\"" + qty + "\" onBlur=\"if (this.value == '' || this.value == 0)\n"
                + "                                            this.value = '1'\" onFocus=\"if (this.value == '1')\n"
                + "                                                        this.value = ''\">\n"
                + "                                </form>"
                + "                            </form>\n"
                + "                        </td>\n"
                + "                        <td>$" + cashPoint + "</td>\n"
                + "                        <td>$" + total + "</td>\n"
                + "                    </tr>";
    }

    public static String getCheckoutStep1() {
        return "                <li id=\"billind_block\">\n"
                + "                    <a href=\"javascript:;\"><i></i>Step 1: Billing Details</a>\n"
                + "\n"
                + "                    <div class=\"accordion_content \">\n"
                + "                        <form action=\"/toy/Checkout\" method=\"post\" class=\"row checkout_form\">\n"
                + "                            <article class=\"grid_8\">\n"
                + "                                <input type=\"hidden\" name=\"step\" value=\"1\"/>\n"
                + "                                <div class=\"pad_box3\">\n"
                + "                                    <p class=\"p2\">Please select the preferred reciever to use on this order.</p>\n"
                + "                                    <ul class=\"radioblock\">\n"
                + "                                        <li class=\"radio\" onclick=\"hf()\">Account owner</li>\n"
                + "                                        <li class=\"radio\" onclick=\"sf()\">Other one</li>\n"
                + "                                        <input name=\"type\" type=\"hidden\" id=\"radion1\" />\n"
                + "                                    </ul>\n"
                + "                                    <label>\n"
                + "                                        <span id=\"firstNameS\">First Name<sup>*</sup></span>\n"
                + "                                        <input name=\"firstName\" id=\"firstName\" type=\"text\">\n"
                + "                                    </label>\n"
                + "                                    <label>\n"
                + "                                        <span id=\"lastNameS\">Last Name<sup>*</sup></span>\n"
                + "                                        <input name=\"lastName\" id=\"lastName\" type=\"text\">\n"
                + "                                    </label>\n"
                + "                                    <label>\n"
                + "                                        <span id=\"telS\">Telephone<sup>*</sup></span>\n"
                + "                                        <input name=\"tel\" id=\"tel\" type=\"text\">\n"
                + "                                    </label>\n"
                + "                                    <a href=\"javascript:;\" onclick=\"get_form(this).submit(); return false\" class=\"button\">Continue</a>\n"
                + "                                </div>\n"
                + "\n"
                + "                            </article>\n"
                + "\n"
                + "                        </form>\n"
                + "                    </div>\n"
                + "                </li>\n"
                + "                <script>    function hf() {\n"
                + "                        document.getElementById(\"firstName\").style.display = \"none\";\n"
                + "                        document.getElementById(\"lastName\").style.display = \"none\";\n"
                + "                        document.getElementById(\"tel\").style.display = \"none\";\n"
                + "                        document.getElementById(\"firstNameS\").style.display = \"none\";\n"
                + "                        document.getElementById(\"lastNameS\").style.display = \"none\";\n"
                + "                        document.getElementById(\"telS\").style.display = \"none\";\n"
                + "                    }\n"
                + "                    function sf() {\n"
                + "                        document.getElementById(\"firstName\").style.display = \"inline\";\n"
                + "                        document.getElementById(\"lastName\").style.display = \"inline\";\n"
                + "                        document.getElementById(\"tel\").style.display = \"inline\";\n"
                + "                        document.getElementById(\"firstNameS\").style.display = \"inline\";\n"
                + "                        document.getElementById(\"lastNameS\").style.display = \"inline\";\n"
                + "                        document.getElementById(\"telS\").style.display = \"inline\";\n"
                + "                    }\n"
                + "                    hf()</script>";
    }

    public static String getCheckoutStep2() {
        return "                <li id=\"delivery_block\">\n"
                + "                    <a href=\"javascript:;\"><i></i>Step 2: Delivery Details</a>\n"
                + "                    <div class=\"accordion_content\">\n"
                + "                        <div class=\"pad_box5\">\n"
                + "                            <form action=\"/toy/Checkout\" method=\"post\" class=\"checkout_form\">\n"
                + "                                <input type=\"hidden\" name=\"step\" value=\"2\"/>\n"
                + "                                <p class=\"p2\">Please select the preferred address to use on this order.</p>\n"
                + "\n"
                + "                                <ul class=\"radioblock\">\n"
                + "                                    <li class=\"radio\" onclick=\"hf()\">Account Address</li>\n"
                + "                                    <li class=\"radio\" onclick=\"sf()\">New Address</li>\n"
                + "                                    <input name=\"type\" type=\"hidden\" id=\"radion1\" />\n"
                + "                                </ul>\n"
                + "                                    <label>\n"
                + "                                        <span id=\"newAddressS\">New Address<sup>*</sup></span>\n"
                + "                                        <input name=\"newAddress\" id=\"newAddress\" type=\"text\">\n"
                + "                                    </label>\n"
                + "                                <a href=\"javascript:;\" onclick=\"get_form(this).submit();\n"
                + "                                     return false\" class=\"button\">Continue</a>\n"
                + "                            </form>\n"
                + "                        </div>\n"
                + "                    </div>\n"
                + "                </li>"
                + "                <script>    function hf() {\n"
                + "                        document.getElementById(\"newAddressS\").style.display = \"none\";\n"
                + "                        document.getElementById(\"newAddress\").style.display = \"none\";\n"
                + "                    }\n"
                + "                    function sf() {\n"
                + "                        document.getElementById(\"newAddressS\").style.display = \"inline\";\n"
                + "                        document.getElementById(\"newAddress\").style.display = \"inline\";\n"
                + "                    }\n"
                + "                    hf()</script>";
    }

    public static String getCheckoutStep3() {
        return "                <li id=\"del_method_block\">\n"
                + "                    <a href=\"javascript:;\"><i></i>Step 3: Delivery Method</a>\n"
                + "                    <div class=\"accordion_content\">\n"
                + "                        <div class=\"pad_box5\">\n"
                + "                            <form action=\"/toy/Checkout\" method=\"post\" class=\"checkout_form\">\n"
                + "                                <input type=\"hidden\" name=\"step\" value=\"3\"/>\n"
                + "                                <p class=\"p2\">Please select the preferred shipping method to use on this order.</p>\n"
                + "                                <ul class=\"radioblock\">\n"
                + "                                    <li class=\"radio\">SELF-PICKUP</li>\n"
                + "                                    <li class=\"radio\">DELIVERY</li>\n"
                + "                                    <input name=\"type\" type=\"hidden\" id=\"radion1\" />\n"
                + "                                </ul>\n"
                + "                                <a href=\"javascript:;\" onclick=\"get_form(this).submit(); return false\" class=\"button\">Continue</a>\n"
                + "                            </form>\n"
                + "                        </div>\n"
                + "                    </div>\n"
                + "                </li>";
    }

    public static String getCheckoutStep4() {
        return "                <li id=\"payment_block\">\n"
                + "                    <a href=\"javascript:;\"><i></i>Step 4: Payment Method</a> \n"
                + "                    <div class=\"accordion_content\">\n"
                + "                        <div class=\"pad_box5\">\n"
                + "                            <form action=\"/toy/Checkout\" method=\"post\" class=\"checkout_form\">\n"
                + "                                <input type=\"hidden\" name=\"step\" value=\"4\"/>\n"
                + "                                <p class=\"p2\">Please select the preferred shipping method to use on this order.</p>\n"
                + "                                <ul class=\"radioblock\">\n"
                + "                                    <li class=\"radio\">Cash Point</li>\n"
                + "                                    <li class=\"radio\">Credit Card</li>\n"
                + "                                    <input name=\"type\" type=\"hidden\" id=\"radion2\" />\n"
                + "                                </ul>\n"
                + "                                <a href=\"javascript:;\" onclick=\"get_form(this).submit(); return false\" class=\"button\">Continue</a>\n"
                + "\n"
                + "                            </form>\n"
                + "                        </div>\n"
                + "                    </div>\n"
                + "                </li>";
    }

    public static String getCheckoutStep5() {
        return "                <li>\n"
                + "                    <a href=\"javascript:;\"><i></i>Step 5: Confirm Order</a> \n"
                + "                    <div class=\"accordion_content\">\n"
                + "                        <div class=\"pad_box5\">\n"
                + "                            <div class=\"table_wrap\">\n"
                + "                                <table class=\"order_table confirm\">\n"
                + "                                    <tr>\n"
                + "                                        <th class=\"width_7\">Product Name</th>\n"
                + "                                        <th class=\"width_4\">Model</th>\n"
                + "                                        <th class=\"width_8\">Quantity</th>\n"
                + "                                        <th class=\"width_8\">Price</th>\n"
                + "                                        <th>Total</th>\n"
                + "                                    </tr>\n"
                + "                                    <%                        for (int i = 0; i < cart.getToys().size(); i++) {\n"
                + "                                            Toy toy = cart.getToys().get(i);\n"
                + "                                            out.println(Template.getCartCheckout(toy.getToyIcon(), toy.getToyName(), toy.getCashpoint(), toy.getQTY(), toy.getToyID()));\n"
                + "                                        }\n"
                + "\n"
                + "                                    %>\n"
                + "                                </table>\n"
                + "                            </div>\n"
                + "                            <a href=\"/toy/Cart\" class=\"button continue\">Go Back</a>&nbsp;\n"
                + "                            <a href=\"\" class=\"form_btn log_in\">Confirm</a>\n"
                + "                        </div>\n"
                + "                    </div>\n"
                + "                </li>";
    }

    public static String getLatest() {
        return "                        <li class=\"item\">\n"
                + "\n"
                + "                            <div class=\"lat_product\">\n"
                + "\n"
                + "                                <div class=\"inner\">\n"
                + "\n"
                + "                                    <figure><img src=\"images/lat_product1.jpg\" alt=\"\"></figure>\n"
                + "\n"
                + "                                    <h4><a href=\"product_sidebar.html\">Xylophone toy</a></h4>\n"
                + "\n"
                + "                                    <div class=\"price\">$25</div>\n"
                + "\n"
                + "                                    <div class=\"product_buttons\">\n"
                + "\n"
                + "                                        <a href=\"/toy/Cart\" class=\"add_to_cart\"></a>\n"
                + "\n"
                + "                                        <a href=\"/toy/ProductInfo\" class=\"detail_view\">Details</a>\n"
                + "\n"
                + "                                    </div>\n"
                + "\n"
                + "                                </div>\n"
                + "\n"
                + "                            </div>\n"
                + "\n"
                + "                        </li>";
    }

    public static String getBestSell() {
        return "                    <li>\n"
                + "\n"
                + "                        <div class=\"bestseller\">\n"
                + "\n"
                + "                            <div class=\"inner\">\n"
                + "\n"
                + "                                <figure><img src=\"images/bestsell1.jpg\" alt=\"\"></figure>\n"
                + "\n"
                + "                                <h4><a href=\"product_fullwidth.html\">Bear soft toy</a></h4>\n"
                + "\n"
                + "                                <div class=\"price\">$25</div>\n"
                + "\n"
                + "                                <div class=\"product_buttons\">\n"
                + "\n"
                + "                                    <a href=\"#\" class=\"add_to_cart\"></a>\n"
                + "\n"
                + "                                    <a href=\"product_fullwidth.html\" class=\"detail_view\">Details</a>\n"
                + "\n"
                + "                                </div>\n"
                + "\n"
                + "                            </div>\n"
                + "\n"
                + "                        </div>\n"
                + "\n"
                + "                    </li>";
    }
}
