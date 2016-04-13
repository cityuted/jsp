<%-- 
    Document   : imageContent
    Created on : 2016/4/9, 下午 10:15:00
    Author     : Mesong
--%>

<%@page import="java.sql.Blob"%>
<%@page import="bean.Toy"%>
<%@page import="java.util.ArrayList"%>
<%@page import="db.toyDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    response.setContentType("image/jpeg");
    toyDB db = new toyDB();
    ArrayList<Toy> tlist = db.listToy();
//    int id = 0, index = 0;
//    for (int i = 0; i < tlist.size(); i++) {
//        id = Integer.parseInt(request.getParameter("toyID"));
//        if (tlist.get(i).getToyID() == id) {
//            index = i;
//            break;
//
//        }
//
//    }
    Blob b = tlist.get(0).getIcon();   //2 means 2nd column data
    byte barr[] = b.getBytes(1, (int) b.length());

    response.getOutputStream().write(barr);
    response.getOutputStream().flush();
%>

