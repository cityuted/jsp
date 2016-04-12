/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import bean.SecondHand;
import bean.Toy;
import bean.ToyCategory;
import db.categoryDB;
import db.secondHandDB;
import db.toyCategoryDB;
import db.toyDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mesong
 */
public class doUpdateDiscount extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           toyDB toydb = new toyDB();
           toyCategoryDB toyCatdb = new toyCategoryDB();
           categoryDB catdb = new categoryDB();
          // out.println("s");
          
           int categoryID = Integer.parseInt(request.getParameter("category"));
           int discount = Integer.parseInt(request.getParameter("discount"));
           ArrayList<ToyCategory> toyCatList = toyCatdb.listToyCategory();
           for(ToyCategory tc: toyCatList)
           {
               
               
               if(tc.getCategoryID()==categoryID)
               {
                   ArrayList<Toy> toyList = toydb.listToy();
                   for(Toy t : toyList)
                   {
                       if(t.getToyID()==tc.getToyID())   {      
                           
                           toydb.updateToy(t.getToyID(), t.getToyIcon(), t.getCashpoint(), t.getQTY(),discount );
                       }
                   }
               }
           }      
     
           
           
            
          
           
           response.sendRedirect("doSearchToy");
           
           
        }
        catch(Exception e)
        {
            out.println(e.toString());
        }finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
