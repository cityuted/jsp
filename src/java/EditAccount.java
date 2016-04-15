/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import bean.Template;
import bean.User;
import db.userDB;
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
public class EditAccount extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("edit_account.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        userDB udb = new userDB();
        String password = "";
        String error = "";
        error = getCheckInput(request.getParameter("email").isEmpty(), "Email", error);
        error = getCheckInput(request.getParameter("tel").isEmpty(), "Telephone", error);
        error = getCheckInput(request.getParameter("address").isEmpty(), "Address", error);
        if (!request.getParameter("password").isEmpty()) {
            error = getCheckInput(request.getParameter("password2").isEmpty(), "Password Confirm", error);
        }
        if (request.getParameter("password") != null && request.getParameter("password2") != null) {
            if (!request.getParameter("password").equals(request.getParameter("password2"))) {
                error += " Password and Password Confirm must be same.</br>";
            } else {
                password = request.getParameter("password");
            }
        }
        if (!error.equals("")) {
            request.setAttribute("alert", Template.getErrorAlert(error, true));
        } else if (udb.updateUser(String.valueOf(user.getUserID()), password, request.getParameter("address"), request.getParameter("tel"), request.getParameter("email"))) {
            request.setAttribute("alert", Template.getSuccessAlert("Edit account succeed"));

            User u = udb.searchUserByID(user.getUserID());
            if (u != null) {
                request.getSession().setAttribute("user", u);
            }
        } else {
            request.setAttribute("alert", Template.getErrorAlert("Edit account failed, Plase try again later", false));
        }
        processRequest(request, response);
    }

    public String getCheckInput(Boolean check, String input, String error) {
        if (check) {
            error += input + " is required.</br>";
        }
        return error;
    }

}
