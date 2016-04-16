/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.*;
import db.*;
import java.util.HashMap;

/**
 *
 * @author ted
 */
public class Category extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        toyDB tdb = new toyDB();
        Toys toys = new Toys();
        categoryDB catedb = new categoryDB();
        String order = "order by "+request.getParameter("sort")+" "+request.getParameter("order");
        if (request.getParameter("cate") != null) {
            toys.setToys(tdb.listToyByCategory(Integer.parseInt(request.getParameter("cate")),order));
            
            
            bean.Category cate = catedb.searchCategory(Integer.parseInt(request.getParameter("cate")));
            if(cate!=null){
                request.setAttribute("pageFor", cate.getCategoryName());
            }else{
                request.setAttribute("pageFor", "Not found any toys");
            }

        }else if(request.getParameter("search")!=null){
            toys.setToys(tdb.searchToy(request.getParameter("search"),order));
            request.setAttribute("pageFor", "Search for "+request.getParameter("search"));
        }else{
            toys.setToys(tdb.listToy(order));
            request.setAttribute("pageFor", "All Toys");
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
