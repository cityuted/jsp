/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import bean.User;
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
public class Checkout extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("checkout.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("stepString", getStep("0",request));
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("stepString", getStep(request.getParameter("step"),request));
        processRequest(request, response);
    }

    public String getStep(String stepString, HttpServletRequest request) {
        CheckoutStatus checkoutStatus = (CheckoutStatus)request.getSession().getAttribute("checkoutStatus");
        User user = (User)request.getSession().getAttribute("user");
        int step = Integer.parseInt(stepString);
        switch (step) {
            case 1:
                if(request.getParameter("type").equals("Account owner")){
                    checkoutStatus.setName(user.getUserName());
                }else{
                    checkoutStatus.setName(request.getParameter("firstName")+request.getParameter("lastName"));
                    checkoutStatus.setName(request.getParameter("tel"));
                }
                return Template.getCheckoutStep2();
            case 2:
                if(request.getParameter("type").equals("Account Address")){
                    checkoutStatus.setTel(user.getUserPhone());
                }else{
                    checkoutStatus.setTel(request.getParameter("newAddress"));
                }
                return Template.getCheckoutStep3();
            case 3:
                checkoutStatus.setDelivery(request.getParameter("type"));
                return Template.getCheckoutStep4();
            case 4:
                if(request.getParameter("type").equals("Cash Point")){
                    
                }else{
                    checkoutStatus.setPayment("Credit Card");
                }
                return Template.getCheckoutStep5();
            default:
                return Template.getCheckoutStep1();
        }
    }
}
