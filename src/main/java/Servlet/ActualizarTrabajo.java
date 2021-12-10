/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import CapaLogica.Empresa;
import CapaLogica.Trabajo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class ActualizarTrabajo extends HttpServlet {

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
          try {
            response.setContentType("text/html;charset=UTF-8");
            
            PrintWriter out = response.getWriter();

            
            String idtrabajo=request.getParameter("id_trabajo").trim();
            String idEmpresa=request.getParameter("id_postul").trim();
            //String nombreTrabajo=request.getParameter("nombre").trim();
            //String accion = request.getParameter("accion");
//            if(!accion.equalsIgnoreCase("postulantes")){
              Trabajo obj=new Trabajo();
         
              obj.DarDeBajaTrabajo(idtrabajo);
              
              request.setAttribute("idempresa", idEmpresa);
              request.getRequestDispatcher("inicio_empresa.jsp").forward(request, response);
//           }else{
//                request.setAttribute("trabajo_id", idtrabajo);
//                request.setAttribute("nombre", nombreTrabajo);
//              request.getRequestDispatcher("ListarPostulantesPorTrabajo.jsp").forward(request, response);
//            }  
             
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
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
