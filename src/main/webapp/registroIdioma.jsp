<%-- 
    Document   : registroIdioma
    Created on : Nov 12, 2021, 10:45:44 AM
    Author     : Rodrigo Ruidias
--%>

<%@page import="CapaDatos.conexion"%>
<%@page import="CapaNegocio.Idioma"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>Registro idioma</title>
    </head>
    <body>
        <div class="container mt-5">
            <div class="row">
                <div class="col">
                    <h1 class="text-primary"><center>Seleccione su idioma</center></h1>
                    <form action="Controler" method="POST" id="formulario" class="row mt-5">
                        <div class="col-12">
                            <div class="mb-3">
                                <label class="form-label">Idioma:</label>
                                <select name="cboIdioma" id="cboIdioma" class="form-select" required="required">
                                    <option >Ingles</option>
                                    <option>Español</option>
                                    <option>Italiano</option>
                                    <option>Japones</option>
                                    <option>Alemán</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-12">
                            <div class="mb-3">
                                <label class="form-label">Nivel:</label>
                                <select name="cboNivel" id="cboNivel" class="form-select" required="required">
                                    <option >A1</option>
                                    <option>A2</option>
                                    <option>B1</option>
                                    <option>B2</option>
                                    <option>C1</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-12">
                            <div class="mb-3">
                                <label class="form-label">Seleccionar archivo</label>
                                <input class="form-control" id="btnSeleccionar" type="file" name="btnSeleccionarArchivo" required="required">
                            </div>
                        </div>
                        <input type="hidden" name="idpos" id="idpos" value="${id}">

                        <div class="col-12 text-center mt-3">
                            <a href="IniciarSesion.jsp" type="button" class="btn btn-danger">Cancelar</a>
                            <button type="submit" name="accion" value="siguienteIdioma" class="btn btn-primary">Siguiente</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>        
    </body>
</html>
