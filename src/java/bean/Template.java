/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import db.TransactionDB;
import db.messageDB;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import db.toyDB;

/**
 *
 * @author ted
 */
public class Template {

    public static String getRecently(String id) throws UnsupportedEncodingException {
        toyDB tdb = new toyDB();
        Toy toy = tdb.searchToyByID(id);
        System.out.println(toy==null);
        if (toy != null) {
            return "                    <li>\n"
                    + "                        <figure><a href=\"/toy/ProductDetail?id="+toy.getToyID()+"\"><img width='98' height='97' src=\"" + toy.encodedImage() + "\" alt=\"\"></a></figure>\n"
                    + "                        <div>\n"
                    + "                            <h4 class=\"blue\"><a href=\"/toy/ProductDetail?id="+toy.getToyID()+"\">" + toy.getToyName() + "</a></h4>\n"
                    + "                            <div class=\"price\">$" + toy.getCashpoint() + "</div>\n"
                    + "                        </div>\n"
                    + "                    </li>";
        } else {
            return "";
        }
    }

    public static String getSubmitSecondHand() {
        return "            <form id=\"create_account\" method=\"post\" action=\"/toy/SecondHandToy\">\n"
                + "                <div class=\"account_box\">\n"
                + "                    <div class=\"form_title\">Submit Second Hand Toy</div>\n"
                + "                    <div class=\"inner\">\n"
                + "                        <label>\n"
                + "                            <span>Second Hand Toy Name <sup class=\"red\">*</sup></span>\n"
                + "                            <input type=\"text\" name=\"toyName\">\n"
                + "                        </label>\n"
                + "                        <label>\n"
                + "                            <span>Prefered Cash Point <sup class=\"red\">*</sup></span>\n"
                + "                            <input type=\"text\" name=\"cashPoint\">\n"
                + "                        </label>\n"
                + "                        <a href=\"javascript:;\" onclick=\"get_form(this).submit(); return false\" class=\"form_btn log_in\">Submit</a>\n"
                + "                    </div>\n"
                + "                </div>\n"
                + "            </form>";
    }

    public static String getAddReview(int transID, int toyID, int custID) {
        messageDB mdb = new messageDB();
        if (!mdb.checkAddMessage(transID, toyID, custID)) {
            return "";
        }
        return "                    <div id='reviewpos' class=\"rating\"> Rating Star(s):\n"
                + "                        <ul id='commentStar' class=\"ext_list review_list\">\n"
                + "                            <span class='active' onclick=\"changeRate(1)\"></span><span onclick=\"changeRate(2)\"></span><span onclick=\"changeRate(3)\"></span><span onclick=\"changeRate(4)\"></span><span onclick=\"changeRate(5)\"></span></ul></div><br/>\n"
                + "                    <form class=\"checkout_form\" action='/toy/ProductDetail' method=\"post\">\n"
                + "                        <textarea placeholder=\"Add Comment here...\" name='comment' ></textarea>\n"
                + "                        <input type='hidden' name='rating' id='rating' value='1' />\n"
                + "                        <input type='hidden' name='transID' id='transID' value='" + transID + "' />\n"
                + "                        <input type='hidden' name='toyID' id='toyID' value='" + toyID + "' />\n"
                + "                        <input type='hidden' name='id' id='id' value='" + toyID + "' />\n"
                + "                        <a href=\"javascript:;\" onclick=\"get_form(this).submit(); return false\" class=\"add_review button\">Submit review</a>\n"
                + "                    </form>\n"
                + "                    <script>\n"
                + "                        function changeRate(num) {\n"
                + "                            document.getElementById('rating').value = num;\n"
                + "                            var l = document.getElementById('commentStar').childNodes.length;\n"
                + "                            for (var i = 0; i < l; i++) {\n"
                + "                                if (i < num) {\n"
                + "                                    document.getElementById('commentStar').childNodes[i + 1].className = 'active';\n"
                + "                                } else {\n"
                + "                                    document.getElementById('commentStar').childNodes[i + 1].className = '';\n"
                + "                                }\n"
                + "\n"
                + "                            }\n"
                + "                        }\n"
                + "\n"
                + "                    </script><script>\n"
                + "                            $(document).ready(function () {\n"
                + "                                $('html, body').animate({\n"
                + "                                    scrollTop: $(\"#reviewpos\").offset().top\n"
                + "                                }, 2000);\n"
                + "\n"
                + "                            });\n"
                + "</script>";
    }

    public static String getOrder(TransactionHeader th) {
        return "                    <ul id=\"accordion2\" class=\"accordion\">\n"
                + "                        <li>\n"
                + "                            <a href=\"javascript:;\"><i></i>Order ID: " + th.getTRANSACTIONID() + "</a>\n"
                + "                            <div class=\"accordion_content pad1\">\n"
                + "                                <ul class=\"list2\">\n"
                + "                                    <li><a href=\"#\">Addressee: " + th.getDELIVERYAddressee() + "</a></li>\n"
                + "                                    <li><a href=\"#\">TelePhone: " + th.getDELIVERYAddresseePhone() + "</a></li>\n"
                + "                                    <li><a href=\"#\">Delivery Method: " + th.getDELIVERYOPTION() + "</a></li>\n"
                + "                                    <li><a href=\"#\">Delivery Address: " + th.getDELIVERYADDRESS() + "</a></li>\n"
                + "                                    <li><a href=\"#\">Delivery Time: " + th.getDELIVERYTIME() + "</a></li>\n"
                + "                                    <li><a href=\"#\">Payment Method: " + th.getPayment() + "</a></li>\n"
                + "                                    <li><a href=\"#\">Progress: <red>" + th.getDELIVERYPROGRSS() + "</red></a></li>\n"
                + "                                </ul>\n" + getOrderItem(th.getTRANSACTIONID(), th.getCUSTID())
                + "                            </div>\n"
                + "                        </li>\n"
                + "                    </ul> ";
    }

    public static String getOrderItem(int transID, int custID) {
        TransactionDB tdb = new TransactionDB();
        ArrayList<TransactionItem> tempList = tdb.listTransactionItem(transID);
        String cartString = "";
        if (tempList != null) {
            for (int i = 0; i < tempList.size(); i++) {
                TransactionItem ti = tempList.get(i);
                cartString += Template.getOrderItem(ti.getToyName(), ti.getCashPoint(), ti.getQTY(), ti.getToyID(), transID, custID);
            }
        }
        return "<div class=\"pad_box5\">\n"
                + "                            <div class=\"table_wrap\">\n"
                + "                                <table class=\"order_table confirm\">\n"
                + "                                    <tbody><tr>\n"
                + "                                        <th class=\"width_7\">Product Name</th>\n"
                + "                                        <th class=\"width_4\">Model</th>\n"
                + "                                        <th class=\"width_8\">Quantity</th>\n"
                + "                                        <th class=\"width_8\">Cash Point</th>\n"
                + "                                        <th>Total</th>\n"
                + "                                        <th></th>\n"
                + "                                    </tr>\n"
                + cartString
                + "                    </tr>                                </tbody></table>\n"
                + "                            </div>\n"
                + "                        </div>";
    }

    public static String getOrderItem(String name, int cashPoint, int qty, int id, int transID, int custID) {
        messageDB mdb = new messageDB();
        String review = "<td></td>";
        if (mdb.checkAddMessage(transID, id, custID)) {
            review = "<td><a href=\"/toy/ProductDetail?id=" + id + "&transID=" + transID + "\"  class=\"button\">Add a Review</a></td>";
        }
        int total = qty * cashPoint;
        return "                    <tr>\n"
                + "                        <td>\n"
                + "                            <div class=\"ext_box confirm_product\">\n"
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
                + review
                + "                    </tr>";
    }

    public static String getSecondHand(SecondHand sh) {
        return "                    <ul id=\"accordion2\" class=\"accordion\">\n"
                + "                        <li>\n"
                + "                            <a href=\"javascript:;\"><i></i>Second Hand Submission ID: " + sh.getID() + "</a>\n"
                + "                            <div class=\"accordion_content pad1\">\n"
                + "                                <ul class=\"list2\">\n"
                + "                                    <li><a href=\"#\">Second Hand Toy Name: " + sh.getName() + "</a></li>\n"
                + "                                    <li><a href=\"#\">Prefered Cash Point: " + sh.getCashpoint() + "</a></li>\n"
                + "                                    <li><a href=\"#\">Status: " + sh.getApproval() + "</a></li>\n"
                + "                                </ul>\n"
                + "                            </div>\n"
                + "                        </li>\n"
                + "                    </ul> ";
    }

    public static String getHref(String title, String link) {
        return "<a href='" + link + "' >" + title + "</a>";
    }

    public static String getSuccessAlert(String msg) {
        return "            <div class=\"alert alert-success\">\n"
                + "                <strong>Success!</strong> " + msg + ".\n"
                + "            </div>";
    }

    public static String getInfoAlert(String msg) {
        return "            <div class=\"alert alert-info\">\n"
                + "                <strong>Go To </strong> " + msg + ".\n"
                + "            </div>";
    }

    public static String getErrorAlert(String msg, Boolean br) {
        String brString = "";
        if (br) {
            brString = "</br>";
        }
        return "            <div class=\"alert alert-error\">\n"
                + "                <strong>Warning!</strong> " + brString + msg + ".\n"
                + "            </div>";
    }

    public static String getToyTemplate(String img, String name, String cashPoint, String id) {
        if (name.length() > 20) {
            name = name.substring(0, 19);
        }
        return "              <li >\n"
                + "                  <div>\n"
                + "                    <figure><a href=\"#\"><img width=\"150\" height=\"150\" src=\"" + img + "\" alt=\"\"></a></figure>\n"
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

    public static String getMessageTemplate(int custID, String name, String content, String Date, int rate) {
        messageDB mdb = new messageDB();
        ArrayList<Message> ma = mdb.listMessageReply(custID);
        String reply = "";
        if (ma != null && ma.size() > 0) {
            reply = "</br>---reply from Staff(" + ma.get(0).getCustName() + ") - " + ma.get(0).getDate() + ":"
                    + "</br>(" + ma.get(0).getContent() + ")";
        } else {
            reply = "";
        }
        return "                    <li>\n"
                + "                      <figure><img src=\"images/ava.jpg\" alt=\"\"></figure>\n"
                + "                      <div>\n"
                + "                        <div class=\"author\"><strong>" + name + "</strong> - " + Date + ":</div>\n"
                + "                        " + content + "</br>" + reply + "\n"
                + "                      </div>\n"
                + "                      <div class=\"rating\">\n"
                + getRate(rate)
                + "                      </div>\n"
                + "                    </li>";
    }

    public static String getRate(int rate) {
        String s = "";
        for (int i = 0; i < rate; i++) {
            s += "<span class=\"active\"></span>";
        }
        if (rate < 5) {
            for (int i = 0; i < 5 - rate; i++) {
                s += "<span></span>";
            }
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
                + "                                                        <img width=\"60\" height=\"60\" src=\"" + image + "\" alt=\"\">\n"
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

    public static String getCart(String image, String name, int cashPoint, int qty, int id, int sid) {
        String dis = "";
        String change = "                                <a href=\"javascript:;\" onclick=\"get_form(this).submit(); return false\" class=\"done\"></a>\n";
        if (sid > 0) {
            change = "";
            dis = "disabled=\"disabled\"";
        }
        int total = qty * cashPoint;
        return "                    <tr>\n"
                + "                        <td>\n"
                + "                            <div class=\"ext_box confirm_product\">\n"
                + "                                <figure><img width=\"60\" height=\"60\" src=\"" + image + "\" alt=\"\"></figure>\n"
                + "                                <div>\n"
                + "                                    <a href=\"#\">" + name + "</a>\n"
                + "                                </div>\n"
                + "                            </div> \n"
                + "                        </td>\n"
                + "                        <td>" + id + "</td>\n"
                + "                        <td>\n"
                + "                            <form class=\"confirm_quantity\" action='/toy/Cart' method='post' ><input type='hidden' name='action' value='change' />\n"
                + "                                <input type='hidden' name='id' value='" + id + "' /><input " + dis + " name='qty'type=\"text\" value=\"" + qty + "\" onBlur=\"if (this.value == '' || this.value == 0)\n"
                + "                                            this.value = '1'\" onFocus=\"if (this.value == '1')\n"
                + "                                                        this.value = ''\">\n"
                + change
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
                + "                                <figure><img width=\"60\" height=\"60\" src=\"" + image + "\" alt=\"\"></figure>\n"
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
                + "                    <a href=\"javascript:;\"><i></i>Step 1: Addressee</a>\n"
                + "\n"
                + "                    <div class=\"accordion_content \">\n"
                + "                        <form action=\"/toy/Checkout\" method=\"post\" class=\"row checkout_form\">\n"
                + "                            <article class=\"grid_8\">\n"
                + "                                <input type=\"hidden\" name=\"step\" value=\"1\"/>\n"
                + "                                <div class=\"pad_box3\">\n"
                + "                                    <p class=\"p2\">Please select the preferred Addressee to use on this order.</p>\n"
                + "                                    <ul class=\"radioblock\">\n"
                + "                                        <li id='rdFalse' class=\"radio\" onclick=\"hf()\">Account owner</li>\n"
                + "                                        <li id='rdTrue' class=\"radio\" onclick=\"sf()\">Other one</li>\n"
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
                + "                                    <a href=\"javascript:;\" onclick=\"get_form(this).submit(); return false\" class=\"form_btn log_in\">Continue</a>\n"
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
                + "                                    <li id='rdFalse' class=\"radio\" onclick=\"hf()\">Account Address</li>\n"
                + "                                    <li id='rdTrue' class=\"radio\" onclick=\"sf()\">New Address</li>\n"
                + "                                    <input name=\"type\" type=\"hidden\" id=\"radion1\" />\n"
                + "                                </ul>\n"
                + "                                    <label>\n"
                + "                                        <span id=\"newAddressS\">New Address<sup>*</sup></span>\n"
                + "                                        <input name=\"newAddress\" id=\"newAddress\" type=\"text\">\n"
                + "                                    </label>\n"
                + "                                    <input name=\"goStep\" type=\"hidden\" id=\"goStep\"/>\n"
                + "                                <a href=\"javascript:;\" onclick=\"document.getElementById('goStep').value='2'; get_form(this).submit();\n"
                + "                                     return false\" class=\"button\">Go back</a>\n"
                + "                                <a href=\"javascript:;\" onclick=\"get_form(this).submit();\n"
                + "                                     return false\" class=\"form_btn log_in\">Continue</a>\n"
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
                + "                                <p class=\"p2\">Please select the preferred delivery method to use on this order.</p>\n"
                + "                                <ul class=\"radioblock\">\n"
                + "                                    <li id='rdFalse' class=\"radio\">Sea Freight</li>\n"
                + "                                    <li id='rdTrue' class=\"radio\">Air Freight</li>\n"
                + "                                    <input name=\"type\" type=\"hidden\" id=\"radion1\" />\n"
                + "                                </ul>\n"
                + "                                    <input name=\"goStep\" type=\"hidden\" id=\"goStep\"/>\n"
                + "                                <a href=\"javascript:;\" onclick=\"document.getElementById('goStep').value='3'; get_form(this).submit();\n"
                + "                                     return false\" class=\"button\">Go back</a>\n"
                + "                                <a href=\"javascript:;\" onclick=\"get_form(this).submit(); return false\" class=\"form_btn log_in\">Continue</a>\n"
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
                + "                                <p class=\"p2\">Please select the preferred payment method to use on this order.</p>\n"
                + "                                <ul class=\"radioblock\">\n"
                + "                                    <li id='rdFalse' class=\"radio\" onclick='hf()' >Cash Point</li>\n"
                + "                                    <li id='rdTrue' class=\"radio\" onclick='sf()'>Credit Card</li>\n"
                + "                                    <input name=\"type\" type=\"hidden\" id=\"radion2\" />\n"
                + "                                </ul>\n"
                + "                                    <label>\n"
                + "                                        <span id=\"creditcardS\">Crdit Card ID<sup>*</sup></span>\n"
                + "                                <input id='creditcard' name='creditcard' /></label>"
                + "                                    <input name=\"goStep\" type=\"hidden\" id=\"goStep\"/>\n"
                + "                                <a href=\"javascript:;\" onclick=\"document.getElementById('goStep').value='4'; get_form(this).submit();\n"
                + "                                     return false\" class=\"button\">Go back</a>\n"
                + "                                <a href=\"javascript:;\" onclick=\"get_form(this).submit(); return false\" class=\"form_btn log_in\">Continue</a>\n"
                + "\n"
                + "                            </form>\n"
                + "                        </div>\n"
                + "                    </div>\n"
                + "                </li>"
                + "                <script>    function hf() {\n"
                + "                        document.getElementById(\"creditcardS\").style.display = \"none\";\n"
                + "                        document.getElementById(\"creditcard\").style.display = \"none\";\n"
                + "                    }\n"
                + "                    function sf() {\n"
                + "                        document.getElementById(\"creditcardS\").style.display = \"inline\";\n"
                + "                        document.getElementById(\"creditcard\").style.display = \"inline\";\n"
                + "                    }\n"
                + "                    hf()</script>";
    }

    public static String getCheckoutStep5(bean.Cart cart) throws UnsupportedEncodingException {
        String cartString = "";
        for (int i = 0; i < cart.getToys().size(); i++) {
            Toy toy = cart.getToys().get(i);
            cartString += Template.getCartCheckout(toy.encodedImage(), toy.getToyName(), toy.getCashpoint(), toy.getQTY(), toy.getToyID());
        }

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
                + cartString
                + "                                </table>\n"
                + "                            </div>\n"
                + "                            <form action='/toy/Checkout' method='post' ><input type='hidden' name='step' value='5' />"
                + "                                    <input name=\"goStep\" type=\"hidden\" id=\"goStep\"/>\n"
                + "                                <a href=\"javascript:;\" onclick=\"document.getElementById('goStep').value='5'; get_form(this).submit();\n"
                + "                                     return false\" class=\"button\">Go back</a>\n"
                + "                            <a href=\"javascript:;\" onclick=\"get_form(this).submit(); return false\" class=\"form_btn log_in\">Confirm</a></form>\n"
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

    public static String getBestSell(Toy toy) throws UnsupportedEncodingException {
        return "                    <li>\n"
                + "\n"
                + "                        <div class=\"bestseller\">\n"
                + "\n"
                + "                            <div class=\"inner\">\n"
                + "\n"
                + "                                <figure><img width=\"150\" height=\"150\" src=\"" + toy.encodedImage() + "\" alt=\"\"></figure>\n"
                + "\n"
                + "                                <h4><a href=\"product_fullwidth.html\">" + toy.getToyName() + "</a></h4>\n"
                + "\n"
                + "                                <div class=\"price\">$" + toy.getCashpoint() + "</div>\n"
                + "\n"
                + "                                <div class=\"product_buttons\" >\n"
                + "\n"
                + "                        <form method=\"post\" action=\"/toy/Cart\"> <input type=\"hidden\" name=\"id\" value=\"" + toy.getToyID() + "\" /><a  href=\"javascript:;\" onclick=\"get_form(this).submit(); return false\" class=\"add_to_cart\"></a> </form>\n"
                + "\n"
                + "                                    <a href=\"/toy/ProductDetail?id=" + toy.getToyID() + "\" class=\"detail_view\">Details</a>\n"
                + "\n"
                + "                                </div>\n"
                + "\n"
                + "                            </div>\n"
                + "\n"
                + "                        </div>\n"
                + "\n"
                + "                    </li>";
    }

    public static String getCheckoutStep1Session(CheckoutStatus checkoutStatus) {
        String out = "<script>";
        if (checkoutStatus.boolAddressee) {
            out += "document.getElementById('rdTrue').className +=' active';";
            out += "document.getElementById('rdTrue').click();";
            out += "document.getElementById('radion1').value='Other one';";
            out += "document.getElementById('firstName').value='" + checkoutStatus.firstName + "';";
            out += "document.getElementById('lastName').value='" + checkoutStatus.lastName + "';";
            out += "document.getElementById('tel').value='" + checkoutStatus.tel + "';";
        } else {
            out += "document.getElementById('rdFalse').className +=' active';";
            out += "document.getElementById('rdFalse').click();";
            out += "document.getElementById('radion1').value='Account owner';";
        }
        return out + "</script>";
    }

    public static String getCheckoutStep2Session(CheckoutStatus checkoutStatus) {
        String out = "<script>";
        if (checkoutStatus.boolAddress) {
            out += "document.getElementById('rdTrue').className +=' active';";
            out += "document.getElementById('rdTrue').click();";
            out += "document.getElementById('newAddress').value='" + checkoutStatus.address + "';";
            out += "document.getElementById('radion1').value='New Address';";
        } else {
            out += "document.getElementById('rdFalse').className +=' active';";
            out += "document.getElementById('rdFalse').click();";
            out += "document.getElementById('radion1').value='Account Address';";
        }
        return out + "</script>";
    }

    public static String getCheckoutStep3Session(CheckoutStatus checkoutStatus) {
        String out = "<script>";
        if (checkoutStatus.boolDelivery) {
            out += "document.getElementById('rdTrue').className +=' active';";
            out += "document.getElementById('rdTrue').click();";
            out += "document.getElementById('radion1').value='Air Freight';";
        } else {
            out += "document.getElementById('rdFalse').className +=' active';";
            out += "document.getElementById('rdFalse').click();";
            out += "document.getElementById('radion1').value='Sea Freight';";
        }
        return out + "</script>";
    }

    public static String getCheckoutStep4Session(CheckoutStatus checkoutStatus) {
        String out = "<script>";
        if (checkoutStatus.boolPayment) {
            out += "document.getElementById('rdTrue').className +=' active';";
            out += "document.getElementById('rdTrue').click();";
            out += "document.getElementById('radion2').value='Credit Card';";
            out += "document.getElementById('creditcard').value='" + checkoutStatus.creditCardID + "';";
        } else {
            out += "document.getElementById('rdFalse').className +=' active';";
            out += "document.getElementById('rdFalse').click();";
            out += "document.getElementById('radion2').value='Cash Point';";
        }
        return out + "</script>";
    }
}
