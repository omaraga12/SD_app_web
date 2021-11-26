<%-- 
    Document   : registroPostulante
    Created on : Nov 12, 2021, 10:46:04 AM
    Author     : Rodrigo Ruidias
--%>

<%@page import="CapaLogica.Postulante"%>
<%@page import="CapaNegocio.Entidades.EntidadTipoDocumento"%>
<%@page import="CapaNegocio.TipoDocumento"%>
<%@page import="CapaNegocio.Entidades.EntidadCategoriaProfesion"%>
<%@page import="CapaNegocio.CategoriaProfesion"%>
<%@page import="CapaNegocio.Entidades.EntidadPais"%>
<%@page import="CapaNegocio.Pais"%>
<%@page import="CapaNegocio.Ubigeo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file = "Header.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
        <script>
            function llenarProvincia() {
                $("#f_opc").val("1");
                $.post("comboProvincia.jsp", $("#data").serialize(), function (data) {
                    $("#cboProvincia").html(data);
                })
            }

            function llenarDistrito() {
                $("#f_opc2").val("1");
                $.post("comboDistrito.jsp", $("#data").serialize(), function (data) {
                    $("#cboDistrito").html(data);
                })
            }
        </script>
        <title>Registro de postulante</title>
    </head>
    <body>
        <%
            Postulante objP = null;
            Ubigeo objU = null;
        %>
        <div class = "container-sm">
            <div class = "row mt-5">
                <div class = "col">
                    <h1 class="text-primary"><center>Registro de postulante</center></h1>
                    <form action="Controler" method="POST" id="data" class = "row mt-5" enctype="multipart/form-data">
                        <div class = "col-6">
                            <div class="mb-3">
                                <label for="inputDocumento" class="form-label">N° documento</label>
                                <input type="text" maxlength="8" class="form-control" name="inputDocumento" required="required">                                    
                            </div>
                        </div>
                        <div class = "col-6">
                            <div class="mb-3">
                                <label for="inputTipo" class="form-label">Tipo de documento</label>
                                <select name="inputTipo" class="form-select" required="required">
                                    <%
                                        TipoDocumento objTD = new TipoDocumento();
                                        ArrayList<EntidadTipoDocumento> documentos = objTD.llenarDocumentos();
                                        for (EntidadTipoDocumento documento : documentos) {
                                    %>
                                    <option value="<%out.println(documento.getTipo_documento_id());%>"><%out.println(documento.getNombre());%></option>
                                    <%
                                        }
                                    %>                                    
                                </select>                                
                            </div>
                        </div>

                        <div class = "col-4">
                            <div class="mb-3">
                                <label for="inputApellidoPaterno" class="form-label">Apellido paterno</label>
                                <input type="text" class="form-control" name="inputApellidoPaterno" required="required">                                    
                            </div>
                        </div>

                        <div class = "col-4">
                            <div class="mb-3">
                                <label for="inputApellidoMaterno" class="form-label">Apellido materno</label>
                                <input type="text" class="form-control" name="inputApellidoMaterno" required="required">                                    
                            </div>
                        </div>

                        <div class = "col-4">
                            <div class="mb-3">
                                <label for="inputNombres" class="form-label">Nombres</label>
                                <input type="text" class="form-control" name="inputNombres" required="required">                                    
                            </div>
                        </div>

                        <div class = "col-4">
                            <div class="mb-3">
                                <label for="inputColegiatura" class="form-label">Colegiatura</label>
                                <input type="number" class="form-control" name="inputColegiatura" required="required">                                    
                            </div>
                        </div>

                        <div class = "col-4">
                            <div class="mb-3">
                                <label for="inputProfesionPostulante" class="form-label">Profesión</label>
                                <select name="inputProfesionPostulante" class="form-select" required="required">
                                    <%
                                        try {
                                            CategoriaProfesion objCP = new CategoriaProfesion();
                                            ArrayList<EntidadCategoriaProfesion> categorias = objCP.llenarCategorias();
                                            for (EntidadCategoriaProfesion categoria : categorias) {
                                    %>
                                    <option value="<%out.println(categoria.getCategoria_id());%>"><%out.println(categoria.getDescripcion());%></option>
                                    <%
                                            }
                                        } catch (Exception e) {
                                            out.println(e.getMessage());
                                        }
                                    %>                                    
                                </select>
                            </div>
                        </div>

                        <div class = "col-4">
                            <div class="mb-3">
                                <label for="inputSeleccionarImagen" class="form-label">Seleccionar imagen</label>
                                <input class="form-control" type="file" name="inputSeleccionarImagen">
                            </div>
                        </div>

                        <div class = "col-3">
                            <div class="mb-3">
                                <label for="inputPais" class="form-label">País</label>
                                <select name="inputPais" class="form-select" required="required">
                                    <option value="">Seleccione</option>
                                    <%
                                        try {
                                            Pais objPais = new Pais();
                                            ArrayList<EntidadPais> paises = objPais.llenarPais();
                                            for (EntidadPais pais : paises) {
                                    %>
                                    <option value="<%out.println(pais.getPais_id());%>"><%out.println(pais.getNombre_pais());%></option>
                                    <%
                                            }
                                        } catch (Exception e) {
                                            out.println(e.getMessage());
                                        }
                                    %>                                    
                                </select>
                                <input type="hidden" name="i_opc" id="i_opc">
                                <input type="hidden" name="i_opc2" id="i_opc2">
                            </div>
                        </div>

                        <div class = "col-3">
                            <div class="mb-3">
                                <label for="cboDepartamento" class="form-label">Departamento</label>
                                <select name="inputDepartamento" id="cboDepartamento" class="form-select" required="required" onchange="llenarProvincia();">
                                    <option value="">Seleccione</option>
                                    <%
                                        try {
                                            objU = new Ubigeo();
                                            ArrayList<String> departamentos = objU.departamentosUbigeo();
                                            for (String departamento : departamentos) {
                                    %>
                                    <option><%out.println(departamento);%></option>
                                    <%
                                            }
                                        } catch (Exception e) {
                                            out.println(e.getMessage());
                                        }
                                    %>
                                </select>  
                            </div>
                        </div>

                        <div class = "col-3">
                            <div class="mb-3">
                                <label for="cboProvincia" class="form-label">Provincia</label>
                                <select name="inputProvincia" id="cboProvincia" class="form-select" required="required" onchange="llenarDistrito();">
                                    <option value="">Seleccione</option>
                                </select>   
                            </div>
                        </div>

                        <div class = "col-3">
                            <div class="mb-3">
                                <label for="cboDistrito" class="form-label">Distrito</label>
                                <select name="inputDistrito" id="cboDistrito" class="form-select" required="required">
                                    <option value="">Seleccione</option>
                                </select>  
                            </div>
                        </div>

                        <div class = "col-12 text-center mt-3">
                            <a href="IniciarSesion.jsp" type="button" class="btn btn-danger">Cancelar</a>
                            <button type="submit" name="accion" value="siguientePostulante" class="btn btn-primary">Siguiente</button>                            
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
