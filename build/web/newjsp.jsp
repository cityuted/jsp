<%-- 
    Document   : newjsp
    Created on : 2016年4月10日, 下午03:24:49
    Author     : ted
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form method="get" action="/toy/Image">
            <input name="name"/>
            <input name="image" type="file" />
            <input type="submit"/>
        </form>
    </body>
</html>
