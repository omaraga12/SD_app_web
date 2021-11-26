<%-- 
    Document   : registroProfesion
    Created on : Nov 12, 2021, 10:45:18 AM
    Author     : Rodrigo Ruidias
--%>

<%@page import="CapaNegocio.Entidades.EntidadGradoAcademico"%>
<%@page import="CapaNegocio.GradoAcademico"%>
<%@page import="CapaNegocio.Universidad"%>
<%@page import="CapaNegocio.Entidades.EntidadUniversidad"%>
<%@page import="CapaNegocio.Entidades.EntidadCategoriaProfesion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="CapaNegocio.CategoriaProfesion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>Registro de postulante</title>
    </head>
    <body>
        <div class = "container-sm">
            <div class = "row mt-5">
                <div class = "col">
                    <h1 class="text-primary"><center>Registro de profesión</center></h1>
                    <form action="Controler" method="POST" id="data" class = "row mt-5">
                        <div class = "col-4">
                            <div class="mb-3">
                                <label class="form-label">Fecha de obtención</label>
                                <input type="date" class="form-control" name="txtFecha" required="required">                                    
                            </div>
                        </div>
                        <div class = "col-4">
                            <div class="mb-3">
                                <label class="form-label">Profesión</label>
                                <select name="cboProfesion" class="form-select" required="required">
                                    <%
                                        CategoriaProfesion objCP = new CategoriaProfesion();
                                        ArrayList<EntidadCategoriaProfesion> categorias = objCP.llenarCategorias();
                                        for (EntidadCategoriaProfesion categoria : categorias) {
                                    %>
                                    <option value="<%out.println(categoria.getCategoria_id());%>"><%out.println(categoria.getDescripcion());%></option>
                                    <%
                                        }
                                    %>                                    
                                </select>                                
                            </div>
                        </div>

                        <div class = "col-4">
                            <div class="mb-3">
                                <label class="form-label">Universidad</label>
                                <select name="cboUniversidad" class="form-select" required="required">
                                    <%
                                        Universidad objU = new Universidad();
                                        ArrayList<EntidadUniversidad> universidades = objU.llenarUniversidad();
                                        for (EntidadUniversidad universidad : universidades) {
                                    %>
                                    <option value="<%out.println(universidad.getUniversidad_id());%>"><%out.println(universidad.getNombre_universidad());%></option>
                                    <%
                                        }
                                    %>                                    
                                </select>                                    
                            </div>
                        </div>

                        <div class = "col-12">
                            <div class="mb-3">
                                <label class="form-label">Descripción</label>
                                <input type="text" class="form-control" name="txtDescripcion" required="required">                                    
                            </div>
                        </div>

                        <div class = "col-6">
                            <div class="mb-3">
                                <label class="form-label">Grado académico</label>
                                <select name="cboGrado" class="form-select" required="required">
                                    <%
                                        GradoAcademico objG = new GradoAcademico();
                                        ArrayList<EntidadGradoAcademico> grados = objG.llenarGrados();
                                        for (EntidadGradoAcademico grado : grados) {
                                    %>
                                    <option value="<%out.println(grado.getGrado_id());%>"><%out.println(grado.getDescripcion_grado());%></option>
                                    <%
                                        }
                                    %>                                    
                                </select>                                    
                            </div>
                        </div>

                        <div class = "col-6">
                            <div class="mb-3">
                                <label for="inputSeleccionarImagen" class="form-label">Seleccionar archivo</label>
                                <input class="form-control" type="file" name="btnArchivo">
                            </div>
                        </div>

                        <div>
                            <input type="hidden" name="idPP" value="${idI}">
                        </div>

                        <div class = "col-12 text-center mt-3">
                            <a href="IniciarSesion.jsp" type="button" class="btn btn-danger">Cancelar</a>
                            <button type="submit" name="accion" value="siguienteProfesion" class="btn btn-primary">Siguiente</button>                            
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
