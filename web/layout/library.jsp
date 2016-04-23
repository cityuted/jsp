<%-- 
    Document   : library
    Created on : 2016/4/8, 下午 12:26:55
    Author     : Mesong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>



<!-- jQuery 2.2.0 -->
<script src="/toy/backend/plugins/jQuery/jQuery-2.2.0.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.6 -->
<script src="/toy/backend/bootstrap/js/bootstrap.min.js"></script>
<!-- Morris.js charts -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="/toy/backend/plugins/morris/morris.min.js"></script>
<!-- Sparkline -->
<script src="/toy/backend/plugins/sparkline/jquery.sparkline.min.js"></script>
<!-- jvectormap -->
<script src="/toy/backend/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="/toy/backend/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- jQuery Knob Chart -->
<script src="/toy/backend/plugins/knob/jquery.knob.js"></script>


  
<!-- daterangepicker -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
<script src="/toy/backend/plugins/daterangepicker/daterangepicker.js"></script>
<!-- datepicker -->
<script src="/toy/backend/plugins/datepicker/bootstrap-datepicker.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="/toy/backend/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<!-- Slimscroll -->
<script src="/toy/backend/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="/toy/backend/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="/toy/backend/dist/js/app.min.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="/toy/backend/dist/js/pages/dashboard.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="/toy/backend/dist/js/demo.js"></script>


<script>
            
            var handleFileSelect = function (evt) {
                var files = evt.target.files;
                var file = files[0];

                if (files && file) {
                    var reader = new FileReader();

                    reader.onload = function (readerEvt) {
                        var binaryString = readerEvt.target.result;
                        //document.getElementById("base64textarea").value = btoa(binaryString);
                        document.getElementById("uploadString").value = btoa(binaryString);
                       // alert(btoa(binaryString));
                    };

                    reader.readAsBinaryString(file);
                }
            };

            if (window.File && window.FileReader && window.FileList && window.Blob) {
                document.getElementById('uploadImage').addEventListener('change', handleFileSelect, false);
            } else {
                alert('The File APIs are not fully supported in this browser.');
            }

            //EL("uploadImage").addEventListener("change", readFile, false);


        </script>
