<%-- 
    Document   : newjsp
    Created on : 2016/4/7, 下午 11:47:00
    Author     : Mesong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
        <title>Image preview example</title>
        <script type="text/javascript">
            oFReader = new FileReader(), rFilter = /^(?:image\/png)$/i;

            oFReader.onload = function (oFREvent) {

                var img = new Image();

                var temp = new Image();
                temp.src = oFREvent.target.result;
                var h = temp.height;
                var w = temp.width;
                var ratio = w / h;

                var MAX_WIDTH = 400;
                var MAX_HEIGHT = 300;
                img.onload = function () {
                    // document.getElementById("originalImg").src = img.src;
                    var canvas = document.createElement("canvas");
                    var ctx = canvas.getContext("2d");


//                    canvas.width = img.width / 10;
//                    canvas.height = img.height / 10;
                    canvas.width = MAX_WIDTH * (1 / ratio);
                    canvas.height = MAX_HEIGHT * (1 / ratio);
                    ctx.drawImage(img, 0, 0, img.width, img.height, 0, 0, canvas.width, canvas.height);
                    document.getElementById("uploadPreview").src = canvas.toDataURL();
                }
                img.src = oFREvent.target.result;
            };

            function loadImageFile() {
                if (document.getElementById("uploadImage").files.length === 0) {
                    return;
                }
                var oFile = document.getElementById("uploadImage").files[0];
                if (!rFilter.test(oFile.type)) {
                    alert("You must select a valid image file!");
                    document.getElementById("upload").disabled =true;
                    return;
                }
                oFReader.readAsDataURL(oFile);
            }
        </script>
    </head>

    <body onload="loadImageFile();">
        <form name="uploadForm" action="../encodeImg" method="post" enctype="multipart/form-data">
            <table>
                <tbody>
                    <tr>

<!--                        <td><img id="originalImg"/></td>
                        <td><img id="uploadPreview"/></td>-->
                        <td><input id="uploadImage" type="file" name="myPhoto" onchange="loadImageFile();" accept=".png" />
                            <input id="desc" type="text" name="desc" value="hi" />
                            <select id='sex' multiple name='sex'>
                                <option value='m;'>m</option>
                                <option value='f'>f</option>
                            </select>
                            <input type="submit" id='upload' value="upload" /></td>

                    </tr>
                </tbody>
               
            </table>
        </form>
    </body>
</html>
