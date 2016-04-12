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
        HttpSession session = request.getSession();
        
        request.getRequestDispatcher("cart.jsp").forward(request,response);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        toyDB tdb =new toyDB();
        if (request.getParameter("id")!=null){
            bean.Cart cart = (bean.Cart)request.getSession().getAttribute("cart");
            System.out.println(request.getParameter("id"));
            Toy t = tdb.searchToyByID(request.getParameter("id"));
            if (t!=null){
                cart.addToy(t);
            }
            request.getSession().setAttribute("cart",cart);
        }
        processRequest(request, response);
    }
}
