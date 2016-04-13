<%@page import="bean.Toy"%>
<%@page import="db.toyDB"%>
<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>File Upload Example in JSP and Servlet - Java web application</title>
    </head>

    <body> 
        <div id="result">
            


        </div><%
            toyDB toydb = new toyDB();
            Toy t = toydb.listToyByID(1);

        %>
        <% byte[] encodeBase64 = Base64.encodeBase64(Base64.decodeBase64(t.getToyIcon()));
            String base64DataString = new String(encodeBase64, "UTF-8");
            
        %>
        <img src="data:image/jpeg;base64,<%=base64DataString%>"/>
    </body>
</html>
