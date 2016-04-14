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
import java.io.UnsupportedEncodingException;

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
        if (!checkLogin(request, response)) {
            return;
        }
        request.setAttribute("stepString", getStep("0", request));

        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!checkLogin(request, response)) {
            return;
        }
        if (request.getParameter("goStep")!=null && !request.getParameter("goStep").equals("")) {
            request.setAttribute("stepString", goStep(request.getParameter("goStep"), request));
        } else {
            request.setAttribute("stepString", getStep(request.getParameter("step"), request));
        }
        processRequest(request, response);
    }

    public String goStep(String stepString, HttpServletRequest request) {
        CheckoutStatus checkoutStatus = (CheckoutStatus) request.getSession().getAttribute("checkoutStatus");
        int step = Integer.parseInt(stepString);
        switch (step) {
            case 2:
                return Template.getCheckoutStep1() + Template.getCheckoutStep1Session(checkoutStatus);
            case 3:
                return Template.getCheckoutStep2() + Template.getCheckoutStep2Session(checkoutStatus);
            case 4:
                return Template.getCheckoutStep3() + Template.getCheckoutStep3Session(checkoutStatus);
            case 5:
                return Template.getCheckoutStep4() + Template.getCheckoutStep4Session(checkoutStatus);
        }
        return "";
    }

    public String getStep(String stepString, HttpServletRequest request) throws UnsupportedEncodingException {
        CheckoutStatus checkoutStatus = (CheckoutStatus) request.getSession().getAttribute("checkoutStatus");
        if (checkoutStatus == null) {
            checkoutStatus = new CheckoutStatus();
        }
        User user = (User) request.getSession().getAttribute("user");
        bean.Cart cart = (bean.Cart) request.getSession().getAttribute("cart");
        int step = Integer.parseInt(stepString);
        String error = "";
        switch (step) {
            case 1:
                if (request.getParameter("type").equals("Account owner")) {
                    checkoutStatus.setBoolAddressee(false);
                    checkoutStatus.setAddressee(user.getUserName());
                    checkoutStatus.setTel(user.getUserPhone());
                } else {
                    checkoutStatus.setBoolAddressee(true);
                    error = getCheckInput(request.getParameter("firstName").isEmpty(), "First Name", error);
                    error = getCheckInput(request.getParameter("lastName").isEmpty(), "Last Name", error);
                    error = getCheckInput(request.getParameter("tel").isEmpty(), "Telephone", error);
                    
                    checkoutStatus.setFirstName(request.getParameter("firstName"));
                    checkoutStatus.setLastName(request.getParameter("lastName"));
                    
                    checkoutStatus.setTel(request.getParameter("tel"));
                    if (!error.equals("")) {
                        request.setAttribute("alert", Template.getErrorAlert(error, true));
                        return Template.getCheckoutStep1() + Template.getCheckoutStep1Session(checkoutStatus);
                    }
                    checkoutStatus.setAddressee(request.getParameter("firstName") + request.getParameter("lastName"));
                }
                return Template.getCheckoutStep2() + Template.getCheckoutStep2Session(checkoutStatus);
            case 2:
                if (request.getParameter("type").equals("Account Address")) {
                    checkoutStatus.setBoolAddress(false);
                    checkoutStatus.setAddress(user.getUserAddress());
                } else {
                    checkoutStatus.setBoolAddress(true);
                    error = getCheckInput(request.getParameter("newAddress").isEmpty(), "New Address", error);
                    checkoutStatus.setAddress(request.getParameter("newAddress"));
                    if (!error.equals("")) {
                        request.setAttribute("alert", Template.getErrorAlert(error, true));
                        return Template.getCheckoutStep2() + Template.getCheckoutStep2Session(checkoutStatus);
                    }
                }
                return Template.getCheckoutStep3() + Template.getCheckoutStep3Session(checkoutStatus);
            case 3:
                if (request.getParameter("type").equals("Sea Freight")) {
                    checkoutStatus.setBoolDelivery(false);
                } else {
                    checkoutStatus.setBoolDelivery(true);
                }
                checkoutStatus.setDelivery(request.getParameter("type"));
                return Template.getCheckoutStep4() + Template.getCheckoutStep4Session(checkoutStatus);
            case 4:
                if (request.getParameter("type").equals("Cash Point")) {
                    checkoutStatus.setBoolPayment(false);
                    if (user.getUserID() <= cart.getTotal()) {
                        System.out.println("Not enough");
                        request.setAttribute("alert", Template.getErrorAlert("Not Enough Cash Point!", false));
                        return Template.getCheckoutStep4() + Template.getCheckoutStep4Session(checkoutStatus);
                    }
                    checkoutStatus.setPayment("Cash Point-" + cart.getTotal());
                } else {
                    checkoutStatus.setBoolPayment(true);
                    error = getCheckInput(request.getParameter("creditcard").isEmpty(), "Credit Card ID", error);
                    checkoutStatus.setPayment("Credit Card-" + request.getParameter("creditcard"));
                    if (!error.equals("")) {
                        request.setAttribute("alert", Template.getErrorAlert(error, true));
                        return Template.getCheckoutStep4() + Template.getCheckoutStep4Session(checkoutStatus);
                    }
                    checkoutStatus.setCreditCardID(request.getParameter("creditcard"));
                }

                return Template.getCheckoutStep5(cart);
            case 5:
                TransactionDB tdb = new TransactionDB();
                if (tdb.createTransaction(user.getUserID(), checkoutStatus, cart)) {
                    cart.clear();
                    request.getSession().setAttribute("cart", cart);
                    request.setAttribute("alert", Template.getSuccessAlert("Transaction Scucceed") + Template.getInfoAlert(Template.getHref("My Account", "/toy/MyAccount")));
                } else {
                    request.setAttribute("alert", Template.getErrorAlert("Transaction Failed, Please try again later!", false));
                }
                return "";
            default:

                request.getSession().setAttribute("checkoutStatus", checkoutStatus);

                return Template.getCheckoutStep1() + Template.getCheckoutStep1Session(checkoutStatus);
        }

    }

    public String getCheckInput(Boolean check, String input, String error) {
        if (check) {
            error += input + " is required.</br>";
        }
        return error;
    }

    public Boolean checkLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user.getUserID() == 0) {
            request.setAttribute("alert", Template.getErrorAlert("Please Login First", false) + Template.getInfoAlert(Template.getHref("Login", "/toy/Login")));
            processRequest(request, response);
            return false;
        }
        return true;
    }
}
