<%-- 
    Document   : index
    Created on : 2016/3/19, 下午 11:14:30
    Author     : Mesong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>File Upload Example in JSP and Servlet - Java web application</title>
    </head>

    <body> 
        <div>
            <h3> Choose File to Upload in Server </h3>
            <form action="../../upload" method="post" enctype="multipart/form-data">
                <input type="file" name="file" id="file" onchange="preview(this)" accept="image/*" />
                <img id="image" />            

                <input type="submit" value="upload" />
            </form>          
        </div>
        <script>
            var MAX_WIDTH = 600;
            var MAX_HEIGHT = 600;
            var outputWidth = document.getElementById("MAX_WIDTH");
            outputWidth.value = MAX_WIDTH;
            var outputHeight = document.getElementById("MAX_HEIGHT");
            outputHeight.value = MAX_HEIGHT;
            function preview(input) {
                var reader = new FileReader();

                reader.onload = function (e) {
                    //get loaded data and render thumbnail.
                    var image = document.getElementById("image");
                    image.src = e.target.result;


                    var h = image.height;
                    var w = image.width;
                    var ratio = w / h;

                    if (w > MAX_WIDTH || h > MAX_HEIGHT)
                    {
                        while (image.width > MAX_WIDTH || image.height > MAX_HEIGHT)
                        {
                            image.width = MAX_WIDTH * (1 / ratio);
                            image.height = MAX_HEIGHT * (1 / ratio);
                        }
                    } else if (w < MAX_WIDTH || h < MAX_HEIGHT)
                    {
                        while (image.width < MAX_WIDTH || image.height < MAX_HEIGHT)
                        {
                            image.width = MAX_WIDTH * ratio;
                            image.height = MAX_HEIGHT * ratio;
                        }
                    }


                };


                // read the image file as a data URL.
                reader.readAsDataURL(input.files[0]);
            }



        </script>  
    </body>
</html>