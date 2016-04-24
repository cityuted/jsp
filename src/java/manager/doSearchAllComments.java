/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import bean.Message;
import bean.Toy;
import bean.User;
import db.messageDB;
import db.toyDB;
import db.userDB;
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
public class doSearchAllComments extends HttpServlet {

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
            HttpSession session = request.getSession(false);
            messageDB msgDB = new messageDB();
            toyDB toydb = new toyDB();
            userDB userdb = new userDB();
            
            ArrayList<Message> msgList = msgDB.listMessageHeader();
            ArrayList<Toy> toyList = new ArrayList();
            ArrayList<User> userList = new ArrayList();
            ArrayList<User> managerList = new ArrayList();
            ArrayList<Boolean> isReply = new ArrayList();
            ArrayList<Message> replyList = new ArrayList();
            int toyID = 0;
            
            if (request.getParameter("ID") != null) {
                toyID = Integer.parseInt(request.getParameter("ID"));
                
                msgList=msgDB.listMessageFromID(toyID+"");
                
            }
            if(request.getAttribute("ID")!=null)
            {
                toyID = Integer.parseInt(request.getAttribute("ID")+"");
                msgList=msgDB.listMessageFromID(toyID+"");
            }

            
            for (Message m : msgList) {
                toyList.add(toydb.searchToyByID(m.getToyID() + ""));
                userList.add(userdb.searchUserByID(m.getCustID()));
                if(m.getManagerID()==0 || m.getManagerID()==-1)
                {
                    isReply.add(false);
                }
                else{
                    isReply.add(true);
                    
                    
                }
                ArrayList<Message> temp = msgDB.listMessageReply(m.getMessageID());
                if(temp.size()>0)
                {
                    replyList.add(temp.get(0));
                    
                   
                    
                }
              
                 managerList.add(userdb.searchUserByID(m.getManagerID()));
               
                
                
            }
            session.setAttribute("size", managerList.get(managerList.size()-1));
            session.setAttribute("messagelist", msgList);
            session.setAttribute("toylist", toyList);
            session.setAttribute("userlist", userList);
            session.setAttribute("managerlist", managerList);
            //session.setAttribute("isReply", isReply);
            session.setAttribute("replylist", replyList);
            
            response.sendRedirect("managerPage/viewComment.jsp");
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
