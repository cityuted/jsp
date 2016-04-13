/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import manager.*;
import db.toyCategoryDB;
import db.toyDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mesong
 */
public class doDeleteToy extends HttpServlet {

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
          // out.println("s");
          
           int toyID = Integer.parseInt(request.getParameter("toyID"));
           String toyName = request.getParameter("toyName");
           String description = request.getParameter("description");
          
           String toyIcon = request.getParameter("toyIcon");
           
           String[] category = request.getParameterValues("category");
           String secondHand = request.getParameter("secondHand");
           if(toyIcon==null) toyIcon = "";
           int cashpoint = Integer.parseInt(request.getParameter("cashpoint"));
           int qty = Integer.parseInt(request.getParameter("qty"));
           int discount = Integer.parseInt(request.getParameter("discount"));
           //toydb.updateToy(toyID, toyName,description, toyIcon, cashpoint, qty, discount);
           //for(String c : category)
            //   out.println(c);
           
           out.println(toyID);
           out.println(description);
           out.println(toyIcon);
           out.println(cashpoint);
           out.println(qty);
           out.println(discount);
           
           toyCategoryDB toyCatdb = new toyCategoryDB();
           
               toyCatdb.deleteToyType(toyID);
               toydb.deleteToy(toyID);
//           for(String c : category) 
//           {
//               toyCatdb.createToyCategory(Integer.parseInt(c), toyID);
//           }
//           if(!secondHand.equals(""))
//               toydb.updateToySecondHand(toyID, Integer.parseInt(secondHand));
//           else
//           {
//               toydb.updateToySecondHand(toyID, -1);
//               
//           }
           
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
