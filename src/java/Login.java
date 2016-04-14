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
import db.*;
import bean.*;
import java.util.ArrayList;
import javax.servlet.http.*;

/**
 *
 * @author ted
 */
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("post");
        userDB ud = new userDB();
        String loginName = (String) request.getParameter("loginName");
        String password = (String) request.getParameter("password");
        String Error="";
        if (loginName.isEmpty()){
            Error+="Login Name is required.</br>";
        }
        if (password.isEmpty()){
            Error+="Password is required.</br>";
        }
        
        
        if (!loginName.isEmpty() && !password.isEmpty() ) {
            User user = ud.searchUser(loginName, password);
            System.out.println("vertify");
            if (user != null) {
                System.out.println("F");
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                request.getRequestDispatcher("/Home").forward(request, response);
                return;
            }else{
                Error+="Login Name or Password is incorrect, Please try it again.</br>";
            }
        }
        if(!Error.equals("")){
            request.setAttribute("alert", Template.getErrorAlert(Error,true));
        }
        request.getRequestDispatcher("login.jsp").forward(request, response);
        return;

    }

}
