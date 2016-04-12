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
import java.util.ArrayList;

/**
 *
 * @author ted
 */
public class Category extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        toyDB tdb = new toyDB();
        Toys toys = new Toys();
        if (request.getParameter("search") == null) {
            toys.setToys(tdb.listToy());
            request.setAttribute("pageFor", "Toys on SALE");
        } else {
            toys.setToys(tdb.searchToy(request.getParameter("search")));
            request.setAttribute("pageFor", "Search for "+request.getParameter("search"));
        }
        request.setAttribute("toys", toys);
        request.getRequestDispatcher("category.jsp").forward(request, response);
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
