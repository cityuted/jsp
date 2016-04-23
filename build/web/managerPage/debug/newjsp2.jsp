<%-- 
    Document   : newjsp2
    Created on : 2016/4/23, 下午 09:17:31
    Author     : Mesong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta charset="utf-8">
        <title>Working with JavaScript Dates: Moment Object vs. JavaScript Date Object</title>
        
        
    </head>
    <%@include file="/layout/library.jsp"  %>
    <body onload="change(0)">
        <h1>Moment.js here now: <span  id="then0" data-date="2016-04-17 03:14:27.0"  ></span></h1>
         <h1>Moment.js here now2: <span id="then1"  data-date="2016-04-09 03:14:27.0"></span></h1>
        
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
        <script>
            function change(id) {
       
              var then2;
              var date2;
              for( i = 0 ; i < 2 ; i++) {
                 then2= $('#then'+i);
                 date2= moment(new Date(then2.attr('data-date')));
                    then2.html(date2.fromNow());
              }
             // update2();
               //setInterval(update2, 60000);
            }
        </script>
        <script>
        function updateDate()
        {
           // alert(2);
           // 
//           var items = document.getElementById("then0");
//            var date =  moment(new Date(items.attr('data-date')));
//            items.html(date.fromNow());
        }
        </script>
    </body>
</html>