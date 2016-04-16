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
import bean.*;
import db.*;

/**
 *
 * @author ted
 */
public class ProductDetail extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        toyDB tdb = new toyDB();
        Toy toy = tdb.searchToyByID(request.getParameter("id"));
        request.setAttribute("toy", toy);

        messageDB mdb = new messageDB();
        Messages messages = new Messages();
        messages.setMessages(mdb.listMessageFromID(request.getParameter("id")));
        request.setAttribute("messages", messages);
        request.getRequestDispatcher("product_detail.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(checkLogin(request,response)){
            messageDB mdb = new messageDB();
            int transID  = Integer.parseInt(request.getParameter("transID"));
            int toyID  = Integer.parseInt(request.getParameter("toyID"));
            int custID = ((User)request.getSession().getAttribute("user")).getUserID();
            if(mdb.checkAddMessage(transID, toyID, custID )){
                if (request.getParameter("rating") != null && request.getParameter("comment") != null) {
                    mdb.createMessage(transID, toyID, custID, request.getParameter("comment"), Integer.parseInt(request.getParameter("rating")));
                    
                }
            }
        }
        processRequest(request, response);
  
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
