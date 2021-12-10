/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import CapaLogica.Empresa;
import CapaLogica.Usuario;
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
public class ModificarEmpresa extends HttpServlet {

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
        try {
            response.setContentType("text/html;charset=UTF-8");
            
            PrintWriter out = response.getWriter();
             //Foto
//             String ruta = request.getServletContext().getRealPath("images/");
//             String cambio = ruta.replace("SD_app_web\\target\\SD_app_web-1.0-SNAPSHOT", "SD_app_web\\src\\main\\webapp");
//             File uploads = new File(cambio);
//             Part part = request.getPart("inputSeleccionarImagen");
//             
//             Path path = Paths.get(part.getSubmittedFileName());
//             String fileName = path.getFileName().toString();
//             InputStream input = part.getInputStream();
//                    
//                    if (input != null) {
//                        File file = new File(uploads, fileName);
//                        if (!Files.exists(file.toPath())) {
//                            Files.copy(input, file.toPath());
//                        }
//                    }
            
            String ruc=request.getParameter("ruc");
            
            String nombre=request.getParameter("nombre");
            String tipo=request.getParameter("tipo");
            String pais=request.getParameter("pais").trim();
            String idEmpresa=request.getParameter("idempresa");
            Empresa obj=new Empresa();
         
              obj.actualizarEmpresa(nombre.toUpperCase().toUpperCase(), tipo,ruc,pais,"logo.png",idEmpresa);
              
              request.setAttribute("idempresa", idEmpresa);
              request.getRequestDispatcher("inicio_empresa.jsp").forward(request, response);
             
             
            
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
