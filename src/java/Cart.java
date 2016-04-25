/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bean.*;
import db.*;

/**
 *
 * @author ted
 */
public class Cart extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String error ="";
        toyDB tdb = new toyDB();
        bean.Cart cart = (bean.Cart) request.getSession().getAttribute("cart");
        for (int i = 0; i < cart.getToys().size(); i++) {
            Toy cartToy = cart.getToys().get(i);
            Toy toy = tdb.checkStockByID(cartToy.getToyID());
            if(toy!=null&&toy.getQTY()<cartToy.getQTY()){
                cart.getToys().get(i).setQTY(toy.getQTY());
                if(toy.getQTY()==0){
                    error += "The toy of "+cart.getToys().get(i).getToyName()+" is out of stock, the toy be removed</br>";
                    cart.removeToy(cartToy);
                }else{
                    error += "The toy of "+cart.getToys().get(i).getToyName()+" 's quantity is out of stock, the maximum quantity is "+cartToy.getQTY()+"</br>";
                }
            }
           
        }
        request.getSession().setAttribute("cart", cart);
        if(!error.equals("")){
           request.setAttribute("alert", Template.getErrorAlert(error, Boolean.TRUE));
        }
       
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        toyDB tdb = new toyDB();
        if (request.getParameter("action") != null && request.getParameter("action").equals("change")) {
            int qty = Integer.parseInt(request.getParameter("qty"));
            bean.Cart cart = (bean.Cart) request.getSession().getAttribute("cart");
            int id = Integer.parseInt(request.getParameter("id"));
            for (int i = 0; i < cart.getSize(); i++) {
                if (cart.getToys().get(i).getToyID() == id) {
                    if (qty > 0) {
                        cart.getToys().get(i).setQTY(qty);
                    } else {
                        cart.getToys().remove(i);
                    }
                    break;
                }
            }
            request.getSession().setAttribute("cart", cart);
            processRequest(request, response);
            return;
        }

        if (request.getParameter("id") != null) {
            bean.Cart cart = (bean.Cart) request.getSession().getAttribute("cart");
            System.out.println(request.getParameter("id"));
            int id = Integer.parseInt(request.getParameter("id"));
            if (checkExist(cart, id)) {

            } else {
                Toy t = tdb.searchToyByID(request.getParameter("id"));
                if (t != null) {
                    if (request.getParameter("qty") != null) {
                        t.setQTY(Integer.parseInt(request.getParameter("qty")));
                    } else {
                        t.setQTY(1);
                    }
                    cart.addToy(t);
                }
                request.getSession().setAttribute("cart", cart);
            }
        }
        processRequest(request, response);
    }

    public Boolean checkExist(bean.Cart cart, int id) {
        for (int i = 0; i < cart.getSize(); i++) {
            if (cart.getToys().get(i).getToyID() == id) {
                cart.getToys().get(i).setQTY(cart.getToys().get(i).getQTY() + 1);
                return true;
            }
        }
        return false;
    }

}
