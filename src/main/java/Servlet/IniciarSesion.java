/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import CapaLogica.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
public class IniciarSesion extends HttpServlet {

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
        
         String tipoSeleccion=request.getParameter("type");
         int tip=1;
        if(tipoSeleccion.equalsIgnoreCase("admin")){
            tip=1;
        }else{tip=0;}
        
        String correo=request.getParameter("email");
        String contrasena=request.getParameter("password");
        
      
      
        
        Usuario obj= new Usuario();
        String id=null;
        String tipo=null;
        if(tip!=1){
               try {
            ResultSet rpt=obj.verificarLogin(correo, contrasena);
            while(rpt.next()){
             
                //id=rpt.getString("id_postulante_empresa");
                id="781";
                tipo=rpt.getString("tipo");
            }
            

            if(id!=null){
                 if(tipo.equalsIgnoreCase("0")){

                     request.setAttribute("idpostulante", id);
                     out.print(id);
                     //response.sendRedirect("inicio_postulante.jsp");
                     request.getRequestDispatcher("inicio_postulante.jsp").forward(request, response);
                 }else{
                     request.setAttribute("idempresa", id);
                     request.getRequestDispatcher("inicio_empresa.jsp").forward(request, response);
                 }

                 //out.print(tipo);

            }else{
                 //out.print(id);
                 //response.sendRedirect("IniciarSesion.jsp");
                  request.setAttribute("message", "Datos de acceso incorrectos, intenta otra vez"); // Make available by ${message} in request scope.
                  request.getRequestDispatcher("IniciarSesion.jsp").forward(request, response);
             };
         } catch (Exception ex) {
             System.err.println(ex);
             out.print(ex.getMessage());
         }
        }else{
            
            if(correo.equalsIgnoreCase("admin@gmail.com") && contrasena.equalsIgnoreCase("1234")){
                 

                 response.sendRedirect("MenuListado.jsp");
            }else{
                 //out.print(id);
                 //response.sendRedirect("IniciarSesion.jsp");
                  request.setAttribute("message", "Datos de acceso incorrectos, intenta otra vez"); // Make available by ${message} in request scope.
                  request.getRequestDispatcher("IniciarSesion.jsp").forward(request, response);
             };
           
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
