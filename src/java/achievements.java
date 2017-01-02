/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.action.Base;
import com.action.Find;
import dbconnection.dbcon;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Lenovo
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
        maxFileSize = 1024 * 1024 * 50, // 50 MB
        maxRequestSize = 1024 * 1024 * 100)      // 100 MB

public class achievements extends HttpServlet {

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
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet achievement</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet achievement at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
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
    private static final long serialVersionUID = 205242440643911308L;
    
    /**
     * Directory where uploaded files will be saved, its relative to the web
     * application directory.
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
        //processRequest(request, response);
        PrintWriter out=response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet achievement</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet achievement</h1>");
            out.println("<h1>Servlet achievement</h1>");
            out.println("<h1>Servlet achievement</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
        
        String name="";
        String category="";
        String colg="";
        String event="";
        String date="";
        String pos="";
        String prize="";
        String quantity="";
        String UPLOAD_DIRECTORY="hello";
        
        String roll=request.getSession().getAttribute("username").toString();       
        
       Connection con=null,con1=null;
       Statement stmt=null,stmt1=null;
               if(ServletFileUpload.isMultipartContent(request)){
            try {
                
                List<FileItem> multiparts = new ServletFileUpload(
                                         new DiskFileItemFactory()).parseRequest(request);
              
                for(FileItem item : multiparts){
                    if (item.isFormField()) {
                        if (item.getFieldName().equals("cat")) {
                            category = item.getString();
                            // Do something with the value
                        }
                        if (item.getFieldName().equals("colg")) {
                            colg = item.getString();
                            // Do something with the value
                        }
                        if (item.getFieldName().equals("event")) {
                            event = item.getString();
                            // Do something with the value
                        }
                        if (item.getFieldName().equals("datepicker")) {
                            date = item.getString();
                            // Do something with the value
                        }
                        if (item.getFieldName().equals("pos")) {
                            pos = item.getString();
                            // Do something with the value
                        }
                        if (item.getFieldName().equals("prize")) {
                            prize = item.getString();
                            // Do something with the value
                        }
                        if (item.getFieldName().equals("quantity")) {
                            quantity = item.getString();
                            // Do something with the value
                        }
                     // if(!ayear.equals("")&&!dept.equals("")&&!batch.equals("")&&!sem.equals("")&&!subcode.equals("")&&!notes.equals(""))
            {
                UPLOAD_DIRECTORY = Base.path+"/";
                File file = new File(UPLOAD_DIRECTORY);    
                Boolean a = file.mkdirs();
            }
                    }   
                    if(!item.isFormField()){
                        name = new File(item.getName()).getName();
                        
                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                    }
                    
                }         
               //File uploaded successfully
               request.setAttribute("message", "File Uploaded Successfully "+name );
            } catch (Exception ex) {
               request.setAttribute("message", "File Upload Failed due to " + ex +UPLOAD_DIRECTORY+ayear);
            }           
        }
        else{
            request.setAttribute("message",
                                 "Sorry this Servlet only handles file upload request");
        }
               
        //db conn 
        
    
       

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
