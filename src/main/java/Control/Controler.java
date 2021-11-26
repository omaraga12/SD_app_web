/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import CapaNegocio.ExperienciaLaboral;
import CapaNegocio.Idioma;
import CapaLogica.Postulante;
import CapaLogica.Trabajos_postular;
import CapaNegocio.Profesion;
import CapaNegocio.Ubigeo;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.annotation.WebServlet;
import javax.swing.JOptionPane;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Rodrigo Ruidias
 */
@WebServlet(name = "Controler", urlPatterns = {"/Controler"})
@MultipartConfig
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
                    
                    String ruta = request.getServletContext().getRealPath("images/");
                    String cambio = ruta.replace("SD_app_web\\target\\SD_app_web-1.0-SNAPSHOT", "SD_app_web\\src\\main\\webapp");
                    File uploads = new File(cambio);
                    JOptionPane.showMessageDialog(null, uploads.toPath());

                    Part part = request.getPart("inputSeleccionarImagen");
                    Path path = Paths.get(part.getSubmittedFileName());
                    String fileName = path.getFileName().toString();

                    InputStream input = part.getInputStream();

                    if (input != null) {
                        File file = new File(uploads, fileName);
                        Files.copy(input, file.toPath());
                    }

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

                    objP.setLink_foto(fileName);

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
                    
                case "registrar_trabajo_postulante":
                    Trabajos_postular tp = new Trabajos_postular();
                    int trabajo_id = Integer.parseInt(request.getParameter("id_trabajo"));
                    int postulante_id = Integer.parseInt(request.getParameter("id_postul"));
                    tp.registrar_trabajo_postulante(trabajo_id, postulante_id);
                    request.setAttribute("idpostulante", postulante_id);
                    request.getRequestDispatcher("notificaciones.jsp").forward(request, response);
                    break;
                    
                case "irInicioPostulante":
                    request.setAttribute("idpostulante", request.getParameter("id_postul1"));
                    request.getRequestDispatcher("inicio_postulante.jsp").forward(request, response);
                    break;
                    
                case "irBuscarTrabajosPost":
                    request.setAttribute("idpostulante", request.getParameter("id_postul2"));
                    request.getRequestDispatcher("buscar.jsp").forward(request, response);
                    break;
                    
                case "irNotificacionesPost":
                    request.setAttribute("idpostulante", request.getParameter("id_postul3"));
                    request.getRequestDispatcher("notificaciones.jsp").forward(request, response);
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
