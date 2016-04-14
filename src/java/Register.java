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
public class Register extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String error = "";
        userDB ud = new userDB();

        error = getCheckInput(request.getParameter("firstName").isEmpty(), "First Name", error);
        error = getCheckInput(request.getParameter("lastName").isEmpty(), "Last Name", error);
        error = getCheckInput(request.getParameter("email").isEmpty(), "Email", error);
        error = getCheckInput(request.getParameter("sex").isEmpty(), "Gender", error);
        error = getCheckInput(request.getParameter("loginName").isEmpty(), "First Name", error);
        error = getCheckInput(request.getParameter("phone").isEmpty(), "Telephone", error);
        error = getCheckInput(request.getParameter("address").isEmpty(), "Address", error);
        error = getCheckInput(request.getParameter("password").isEmpty(), "Password", error);
        error = getCheckInput(request.getParameter("password2").isEmpty(), "Password Confirm", error);
        if(!request.getParameter("password").isEmpty()&&!request.getParameter("password2").isEmpty()){
            if(!request.getParameter("password").equals(request.getParameter("password2"))){
                error+=" Password and Password Confirm must be same.</br>";
            }
        }
        if (!error.equals("")) {
            request.setAttribute("alert", Template.getErrorAlert(error, true));
        } else {
            String firstName = (String) request.getParameter("firstName");
            String lastName = (String) request.getParameter("lastName");
            String sex = (String) request.getParameter("sex");
            String loginName = (String) request.getParameter("loginName");
            String email = (String) request.getParameter("email");
            String phone = (String) request.getParameter("phone");
            String address = (String) request.getParameter("address");
            String password = (String) request.getParameter("password");
            String name = lastName + " " + firstName;
            Boolean sql = ud.createUser(name, sex, loginName, password, address, phone, email);
            if (sql) {
                request.setAttribute("alert", Template.getSuccessAlert("Register Succeed")+ Template.getInfoAlert(Template.getHref("Login", "/toy/Login")));
            }else{
                request.setAttribute("alert", Template.getErrorAlert("Register Failed, Please try again later", true));
            }
        }
        request.getRequestDispatcher("register.jsp").forward(request, response);
        return;
    }

    public String getCheckInput(Boolean check, String input, String error) {
        if (check) {
            error += input + " is required.</br>";
        }
        return error;
    }
}
