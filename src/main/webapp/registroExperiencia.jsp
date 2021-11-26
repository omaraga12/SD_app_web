<%-- 
    Document   : registroExperiencia
    Created on : Nov 12, 2021, 10:45:54 AM
    Author     : Rodrigo Ruidias
--%>

<%@page import="CapaNegocio.Entidades.EntidadEmpresa"%>
<%@page import="java.util.ArrayList"%>
<%@page import="CapaNegocio.Empresa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>Registro experiencia</title>
    </head>
    <body>
        <div class="container mt-5">
            <div class="row">
                <div class="col">
                    <h1 class="text-primary"><center>Agrege su experiencia laboral</center></h1>
                    <form action="Controler" method="POST" class="row mt-5">
                        <div class="col-4">
                            <div class="mb-3">
                                <label class="form-label">Fecha de inicio:</label>
                                <input class="form-control" id="inputFechaI" type="date" name="inputFechaI" required="required">
                            </div>
                        </div>
                        <div class="col-4">
                            <div class="mb-3">
                                <label class="form-label">Fecha de salida:</label>
                                <input class="form-control" id="inputFechaS" type="date" name="inputFechaS" required="required">
                            </div>
                        </div>
                        <div class="col-4">
                            <div class="mb-3">
                                <label class="form-label">Seleccionar archivo</label>
                                <input class="form-control" id="btnSeleccionar" type="file" name="btnSeleccionarArchivo" required="required">
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="mb-3">
                                <label class="form-label">Empresa:</label>
                                <select name="cboEmpresa" id="cboEmpresa" class="form-select" required="required">
                                    <%
                                        Empresa objE = new Empresa();
                                        ArrayList<EntidadEmpresa> empresas = objE.llenarEmpresas();
                                        for (EntidadEmpresa empresa : empresas) {
                                    %>
                                    <option value="<%out.println(empresa.getEmpresa_id());%>"><%out.println(empresa.getNombre_empresa());%></option>
                                    <%
                                        }
                                    %>
                                </select>
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="mb-3">
                                <label class="form-label">Cargo:</label>
                                <select name="cboCargo" id="cboCargo" class="form-select" required="required">
                                    <option>Gerente</option>
                                    <option>Supervisor</option>
                                </select>
                            </div>
                        </div>
                        <input type="hidden" name="idposEx" id="idposEx" value="${idPP}">

                        <div class="col-12 text-center mt-3">
                            <a href="IniciarSesion.jsp" type="button" class="btn btn-danger">Cancelar</a>
                            <button type="submit" name="accion" value="finalizarRegistro" class="btn btn-primary">Finalizar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>        
    </body>
</html>
