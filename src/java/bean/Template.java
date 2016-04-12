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
    public static String getToyTemplate(String img,String name,String cashPoint,String id){
        return "              <li>\n" +
"                  <div>\n" +
"                    <figure><a href=\"#\"><img src=\"images/"+img+"\" alt=\"\"></a></figure>\n" +
"                    <div>\n" +
"                      <h4><a href=\"#\">"+name+"</a></h4>\n" +
"                      <div class=\"price\">$"+cashPoint+"</div>\n" +
"                      <div class=\"product_buttons\">\n" +
"                        <form method=\"post\" action=\"/toy/Cart\"> <input type=\"hidden\" name=\"id\" value=\""+id+"\" /><a  href=\"javascript:;\" onclick=\"get_form(this).submit(); return false\" class=\"add_to_cart\"></a> </form>\n" +
"                        <a href=\"/toy/ProductDetail?id="+id+"\" class=\"detail_view\">Details</a>\n" +
"                      </div>  \n" +
"                    </div>\n" +
"                  </div>\n" +
"                </li>";
    }
    public static String getMessageTemplate(String name,String content,String Date,int rate){
        Date="Jan 29th 2013";
        return "                    <li>\n" +
"                      <figure><img src=\"images/ava.jpg\" alt=\"\"></figure>\n" +
"                      <div>\n" +
"                        <div class=\"author\"><strong>"+name+"</strong> - "+Date+":</div>\n" +
"                        "+content+"\n" +
"                      </div>\n" +
"                      <div class=\"rating\">\n" +
getRate(rate)+
"                        <span></span>\n" +
"                        <span></span>\n" +
"                      </div>\n" +
"                    </li>";
    }
    public static String getRate(int rate){
        String s="";
        for(int i=0;i<rate;i++){
            s+="<span class=\"active\"></span>";
        }
        return s;
    }
    
    public static String cartInHeader(String image,String name,int cashPoint,int qty){
        int total = qty * cashPoint;
        return " <li>\n" +
"\n" +
"                                            <table>\n" +
"\n" +
"                                                <tr>\n" +
"\n" +
"                                                    <td class=\"product_image\">\n" +
"\n" +
"                                                        <img src=\"images/cart1.jpg\" alt=\"\">\n" +
"\n" +
"                                                    </td>\n" +
"\n" +
"                                                    <td class=\"product_desc\">\n" +
"\n" +
"                                                        <a href=\"#\">"+name+"</a>\n" +
"\n" +
"                                                    </td>\n" +
"\n" +
"                                                    <td class=\"product_quantity\">\n" +
"\n" +
"                                                        "+qty+" x <span>$"+cashPoint+"</span>\n" +
"\n" +
"                                                    </td>\n" +
"\n" +
"                                                    <td class=\"delete_item\">\n" +
"\n" +
"                                                        <a href=\"#\" class=\"delete\"></a>\n" +
"\n" +
"                                                    </td>\n" +
"\n" +
"                                                </tr>\n" +
"\n" +
"                                            </table>\n" +
"\n" +
"                                        </li>";
    }
    
    public static String getCart(String image,String name,int cashPoint,int qty,int id){
        int total = qty * cashPoint;
        return "                    <tr>\n" +
"                        <td>\n" +
"                            <div class=\"ext_box confirm_product\">\n" +
"                                <figure><img width=\"60\" height=\"60\" src=\"images/"+image+"\" alt=\"\"></figure>\n" +
"                                <div>\n" +
"                                    <a href=\"#\">"+name+"</a>\n" +
"                                </div>\n" +
"                            </div> \n" +
"                        </td>\n" +
"                        <td>"+id+"</td>\n" +
"                        <td>\n" +
"                            <form class=\"confirm_quantity\">\n" +
"                                <input type=\"text\" value=\"1\" onBlur=\"if (this.value == '' || this.value == 0)\n" +
"                                            this.value = '1'\" onFocus=\"if (this.value == '1')\n" +
"                                                        this.value = ''\">\n" +
"                                <a href=\"/toy/Cart\" class=\"done\"></a>\n" +
"                                <a href=\"/toy/Cart\" class=\"delete\"></a>\n" +
"                            </form>\n" +
"                        </td>\n" +
"                        <td>$"+cashPoint+"</td>\n" +
"                        <td>$"+total+"</td>\n" +
"                    </tr>";
    }
}
