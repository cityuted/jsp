/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import bean.SecondHand;
import bean.Toy;
import db.secondHandDB;
import db.toyCategoryDB;
import db.toyDB;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Mesong
 */
public class doUpdateToy extends HttpServlet {

    private File imageFile;
    private int toyID;
    private String toyName;
    private String description;

    private String toyIcon;

    private String[] category;
    private String secondHand;

    private int cashpoint;
    private int qty;
    private int discount;
    private String imgString="";
    private String base64String ="";

    //private  String imageDataString = "";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        String categoryList = "";
        String fileName = null;

        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                        new DiskFileItemFactory()).parseRequest(request);

                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                        String name = new File(item.getName()).getName();
                        imageFile = new File(item.getName());
                        
                        fileName = name;
                    } else {
                        if (item.getFieldName().equals("toyID")) {
                            toyID = Integer.parseInt(item.getString());
                        }
                        if (item.getFieldName().equals("toyName")) {
                            toyName = item.getString();
                        }
                        if (item.getFieldName().equals("description")) {
                            description = item.getString();
                        }

                        if (item.getFieldName().equals("category")) {
                            categoryList += item.getString();

                        }
                        if (item.getFieldName().equals("secondHand")) {
                            secondHand = item.getString();
                        }

                        if (item.getFieldName().equals("cashpoint")) {
                            cashpoint = Integer.parseInt(item.getString());
                        }
                        if (item.getFieldName().equals("qty")) {
                            qty = Integer.parseInt(item.getString());
                        }
                        if (item.getFieldName().equals("discount")) {
                            discount = Integer.parseInt(item.getString());
                        }
                        if(item.getFieldName().equals("uploadString"))
                        {
                            base64String = item.getString();
                        }
                        //if(item.getFieldName().equals("desc"))
                        // desc= item.getString();
                    }
                }
                category = categoryList.split(";");

                //File uploaded successfully
                //request.setAttribute("message", "File Uploaded Successfully" + desc);
            } catch (Exception ex) {

                request.setAttribute("message", "File Upload Failed due to " + ex);
            }

        }
        File file = imageFile;
        if (!(fileName == null)) {
            
            
            try {
                /*
			 * Reading a Image file from file system
                 */
                FileInputStream imageInFile = new FileInputStream(file);
                byte imageData[] = new byte[(int) file.length()];
                imageInFile.read(imageData);
               

                /*
			 * Converting Image byte array into Base64 String 
                 */
                 String imageDataString = encodeImage(imageData);
                 
                request.setAttribute("test", imageDataString);
                /*
			 * Converting a Base64 String into Image byte array 
                 */
                //byte[] imageByteArray = decodeImage(imageDataString);

                /*
			 * Write a image byte array into file system  
                 */
                //FileOutputStream imageOutFile = new FileOutputStream("C:\\Users\\Mesong\\Pictures\\Screenshots\\30.png");
                //imageOutFile.write(imageByteArray);
                //request.setAttribute("photo", imageDataString);
               // toyDB toydb = new toyDB();
                //Toy t = toydb.listToyByID(1);
               // toydb.updateToy(t.getToyID(), imageDataString, t.getCashpoint(), t.getQTY(), t.getDiscount());

                imageInFile.close();
                //request.getRequestDispatcher("managerPage/result.jsp").forward(request, response);
                //imageOutFile.close();
                
                imgString = imageDataString;
                System.out.println("Image Successfully Manipulated!");
            } catch (FileNotFoundException e) {
               out.println("Image not found" + e.getMessage());
            } catch (IOException ioe) {
                System.out.println("Exception while reading the Image " + ioe);
            }
        }
        try {
            toyDB toydb = new toyDB();
            // out.println("s");
            //out.println(String.format("%s,%s,%s,%s,%s,%s,%s", toyID, toyName, description, imageDataString, cashpoint, qty, discount));
            if(!base64String.equals(""))
            imgString = base64String;
            toydb.updateToy(toyID, toyName, description, imgString, cashpoint, qty, discount);
           
            //for(String c : category)
            //   out.println(c);
//            out.println(toyID);
//            out.println(description);
//            out.println(imageDataString);
//            out.println(cashpoint);
//            out.println(qty);
//            out.println(discount);
            toyCategoryDB toyCatdb = new toyCategoryDB();

            toyCatdb.deleteToyType(toyID);

            for (String c : category) {
                toyCatdb.createToyCategory(Integer.parseInt(c), toyID);
            }
             
            if (!secondHand.equals("")) {
                secondHandDB seconddb = new secondHandDB();
                SecondHand sh = seconddb.searchSecondHand(Integer.parseInt(secondHand));
                int secondHandCashpoint = sh.getCashpoint();
                toydb.updateToySecondHand(toyID, sh.getID());
                toydb.updateToy(toyID, toyIcon, secondHandCashpoint, qty, discount);
            } else {
                toydb.updateToySecondHand(toyID, -1);

            }
            //out.println(imgString);
            response.sendRedirect("doSearchToy");
        } catch (Exception e) {
            out.println(e.getMessage());

        } finally {
            out.close();
        }
    }
    
    

    public  String encodeImage(byte[] imageByteArray) {
        return Base64.encodeBase64URLSafeString(imageByteArray);
       
    }

    /**
     * Decodes the base64 string into byte array
     *
     * @param imageDataString - a {@link java.lang.String}
     * @return byte array
     */
    public  byte[] decodeImage(String imageDataString) {
        return Base64.decodeBase64(imageDataString);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
