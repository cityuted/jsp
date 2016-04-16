/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import bean.SecondHands;
import bean.Template;
import bean.User;
import db.secondHandDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ted
 */
public class SecondHandToy extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("my_second_hand.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(!checkLogin(request,response)){
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        secondHandDB sdb = new secondHandDB();
        SecondHands shs = new SecondHands();
        if (request.getParameter("action") != null && request.getParameter("action").equals("submit")) {
            request.setAttribute("action", "submit");
        } else {
            int custID = ((User) request.getSession().getAttribute("user")).getUserID();
            shs.setShs(sdb.listSecondHandByCustomer(custID));
            request.setAttribute("shs", shs);
        }
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String error = "";
        error = getCheckInput(request.getParameter("toyName").isEmpty(), "Toy Name", error);
        error = getCheckInput(request.getParameter("cashPoint").isEmpty(), "Cash Point", error);
        if (!error.equals("")) {
            request.setAttribute("alert", Template.getErrorAlert(error, true));
            request.setAttribute("action", "submit");
        } else {
            int custID = ((User) request.getSession().getAttribute("user")).getUserID();
            String toyName = request.getParameter("toyName");
            int cashPoint = Integer.parseInt(request.getParameter("cashPoint"));
            secondHandDB sdb = new secondHandDB();
            if (sdb.createSecondHand(custID, toyName, cashPoint) != null) {
                request.setAttribute("alert", Template.getSuccessAlert("Submit Second Hand Toy succeed"));
                SecondHands shs = new SecondHands();
                shs.setShs(sdb.listSecondHandByCustomer(custID));
                request.setAttribute("shs", shs);
            } else {
                request.setAttribute("action", "submit");
                request.setAttribute("alert", Template.getErrorAlert("Submit Second Hand Toy failed, Plase try again later", false));
            }
        }
        processRequest(request, response);
    }

    public String getCheckInput(Boolean check, String input, String error) {
        if (check) {
            error += input + " is required.</br>";
        }
        return error;
    }

    public Boolean checkLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            user = new User();
        }
        if (user.getUserID() == 0) {
            request.setAttribute("alert", Template.getErrorAlert("Please Login First", false));
            return false;
        }
        return true;
    }

}
