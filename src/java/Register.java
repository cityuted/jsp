/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
        request.getRequestDispatcher("register.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("create");
        userDB ud = new userDB();
        String firstName = (String) request.getParameter("firstName");
        String lastName = (String) request.getParameter("lastName");
        String sex = (String) request.getParameter("sex");
        String loginName = (String) request.getParameter("loginName");
        String email = (String) request.getParameter("email");
        String phone = (String) request.getParameter("phone");
        String address = (String) request.getParameter("address");
        String password = (String) request.getParameter("password");
        System.out.println(sex);
        System.out.println(firstName);
        String name = lastName + " " + firstName;
        Boolean sql = ud.createUser(name, sex, loginName, password, address, phone, email);
        System.out.println(sql);
        if (sql) {
            request.getRequestDispatcher("/Home").forward(request,response);
        }else{
            request.getRequestDispatcher("/Register").forward(request,response);
        }

        return;
    }

}
