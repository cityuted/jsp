/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import bean.User;
import bean.UserType;
import db.userDB;
import db.userDB;
import db.userTypeDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mesong
 */
public class doLogin extends HttpServlet {

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
            String loginname = request.getParameter("loginname");
            String password = request.getParameter("password");
            userDB userdb = new userDB();
            User u = userdb.searchUser(loginname, password);
            HttpSession session = request.getSession(true);
            userTypeDB userTypedb = new userTypeDB();
            ArrayList<UserType> uts = userTypedb.listUserType();
            session.setAttribute("username", "");
            if (u == null) {

                response.sendRedirect("managerPage/login.jsp");
            } else {
                for (UserType ut : uts) {
                    if (ut.getID() == u.getTypeID()) {
                        if (!ut.getType().toUpperCase().equals("MANAGER")) {
                            response.sendRedirect("managerPage/login.jsp");

                        } else {
                            session.setAttribute("userID", u.getUserID());
                            session.setAttribute("username", u.getUserName());
                            session.setAttribute("userPhoto", u.getPhoto());
                            response.sendRedirect("doSearchToy");
                        }
                    }
                }

            }
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
