/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import bean.Category;
import bean.SecondHand;
import bean.Toy;
import bean.ToyCategory;
import db.categoryDB;
import db.secondHandDB;
import db.toyCategoryDB;
import db.toyDB;
import db.userDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mesong
 */
public class doSearchToyCategory extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession(false);

            categoryDB categorydb = new categoryDB();
            ArrayList<Category> categoryList = categorydb.listToyCategory();

            toyCategoryDB toyCatdb = new toyCategoryDB();
            ArrayList<ToyCategory> toyCatList = toyCatdb.listToyCategory();

            for (Category cat : categoryList) {
                session.setAttribute(cat.getCategoryID() + ".isvalid", "false");
                for (ToyCategory toyCat : toyCatList) {
                    if (toyCat.getCategoryID() == cat.getCategoryID()) {
                        session.setAttribute(cat.getCategoryID() + ".isvalid", "true");
                    }

                }
            }
            session.setAttribute("categoryList", categoryList);

            response.sendRedirect("managerPage/categoryAdminPage.jsp?page=1");

        } finally {
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
