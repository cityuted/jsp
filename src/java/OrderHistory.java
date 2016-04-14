/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import bean.TransactionHeaders;
import bean.User;
import db.TransactionDB;
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
public class OrderHistory extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TransactionDB tdb = new TransactionDB();
        int custID = ((User) request.getSession().getAttribute("user")).getUserID();
        TransactionHeaders ths = new TransactionHeaders();
        ths.setThs(tdb.listTransactionHeader(custID));
        request.setAttribute("ths", ths);
        request.getRequestDispatcher("order_history.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
