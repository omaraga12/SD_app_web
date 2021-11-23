/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import CapaNegocio.ExperienciaLaboral;
import CapaNegocio.Idioma;
import CapaLogica.Postulante;
import CapaNegocio.Profesion;
import CapaNegocio.Ubigeo;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rodrigo Ruidias
 */
@WebServlet(name = "Controler", urlPatterns = {"/Controler"})
public class Controler extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String accion = request.getParameter("accion");
            switch (accion) {
                case "siguientePostulante":
                    Postulante objP = new Postulante();
                    objP.setTipo_documento_id(request.getParameter("inputTipo").trim());
                    objP.setNumero_documento(request.getParameter("inputDocumento"));
                    objP.setApellido_paterno(request.getParameter("inputApellidoPaterno"));
                    objP.setApellido_materno(request.getParameter("inputApellidoMaterno"));
                    objP.setNombres(request.getParameter("inputNombres"));

                    Ubigeo objU = new Ubigeo();
                    objU.setDepartamento(request.getParameter("inputDepartamento"));
                    objU.setProvincia(request.getParameter("inputProvincia"));
                    objU.setDistrito(request.getParameter("inputDistrito"));
                    int idU = objU.buscarUbigeo();
                    objP.setUbigeo_id(idU);

                    objP.setPais_id(Integer.parseInt(request.getParameter("inputPais").trim()));
                    objP.setProfesion_categoria(Integer.parseInt(request.getParameter("inputProfesionPostulante").trim()));
                    objP.setNumero_colegiatura(Integer.parseInt(request.getParameter("inputColegiatura")));

                    objP.setLink_foto(request.getParameter("inputSeleccionarImagen"));

                    int idPostulante = objP.insertarPostulante();
                    request.setAttribute("id", idPostulante);
                    request.getRequestDispatcher("registroIdioma.jsp").forward(request, response);
                    break;

                case "siguienteIdioma":
                    Idioma objI = new Idioma();
                    objI.setIdioma(request.getParameter("cboIdioma"));
                    objI.setNivel(request.getParameter("cboNivel"));
                    objI.setLink_archivo(request.getParameter("btnSeleccionarArchivo"));
                    objI.setPostulante_id(Integer.parseInt(request.getParameter("idpos")));
                    objI.insertarIdioma();
                    request.setAttribute("idI", request.getParameter("idpos"));
                    request.getRequestDispatcher("registroProfesion.jsp").forward(request, response);
                    break;

                case "siguienteProfesion":
                    Profesion objPro = new Profesion();
                    objPro.setCategoria_profesion_id(Integer.parseInt(request.getParameter("cboProfesion").trim()));
                    objPro.setUniversidad_id(Integer.parseInt(request.getParameter("cboUniversidad").trim()));
                    objPro.setDescripcion_formal(request.getParameter("txtDescripcion"));
                    objPro.setGrado_academico_id(Integer.parseInt(request.getParameter("cboGrado").trim()));
                    objPro.setUrl_archivo(request.getParameter("btnArchivo"));
                    objPro.setPostulante_id(Integer.parseInt(request.getParameter("idPP")));
                    objPro.insertarProfesion(request.getParameter("txtFecha"));
                    request.setAttribute("idPP", request.getParameter("idPP"));
                    request.getRequestDispatcher("registroExperiencia.jsp").forward(request, response);
                    break;

                case "finalizarRegistro":
                    ExperienciaLaboral objEL = new ExperienciaLaboral();
                    objEL.setLink_archivo((request.getParameter("btnSeleccionarArchivo")));
                    objEL.setEmpresa_id(Integer.parseInt(request.getParameter("cboEmpresa").trim()));
                    objEL.setCargo(request.getParameter("cboCargo"));
                    objEL.setPostulante_id(Integer.parseInt(request.getParameter("idposEx").trim()));
                    objEL.insertarExperiencia(request.getParameter("inputFechaI"), request.getParameter("inputFechaS"));
                    request.setAttribute("idpostulante", request.getParameter("idposEx"));
                    request.getRequestDispatcher("inicio_postulante.jsp").forward(request, response);
                    break;

                default:
                    request.getRequestDispatcher("IniciarSesion.jsp").forward(request, response);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + " Error en accion");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
