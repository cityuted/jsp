/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bean.*;
import db.*;
import java.util.ArrayList;

/**
 *
 * @author ted
 */
public class Home extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        toyDB toydb = new toyDB();
        String best = "";
        String se = "";
        ArrayList<Toy> toys = toydb.listBestSellToy();
        for (int i = 0; i < toys.size(); i++) {
            if (toys.get(i).getSecondHandID() == 0) {
                best += Template.getBestSell(toys.get(i));
            }
        }
        for(int i=0;i<8-toys.size();i++){
            best +="<li></li>";
        }
        ArrayList<Toy> toys2 = toydb.listSeToy();
        for (int i = 0; i < toys2.size(); i++) {
            se += Template.getBestSell(toys2.get(i));
        }
        for(int i=0;i<8-toys2.size();i++){
            se +="<li></li>";
        }
        request.setAttribute("best", best);
        request.setAttribute("se", se);
        request.getRequestDispatcher("index.jsp").forward(request, response);
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
