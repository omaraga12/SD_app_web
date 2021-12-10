<%-- 
    Document   : RegistrarTrabajo
    Created on : 09-dic-2021, 14:35:26
    Author     : DELL
--%>

<%@page import="CapaNegocio.Entidades.EntidadRequisitos"%>
<%@page import="CapaLogica.Requisito"%>
<%@page import="java.util.ArrayList"%>
<%@page import="CapaNegocio.Entidades.EntidadCategoriaProfesion"%>
<%@page import="CapaNegocio.CategoriaProfesion"%>
<%@page import="CapaNegocio.Profesion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Trabajo</title>
        
       
    </head>
    <body>
        <%
           String empresa_id = request.getParameter("idempresa");%>
        <div  "class="card" style="width: 30rem; margin:50px;margin-top: 20px;">
            <h2>Registrar Nuevo Trabajo</h2>

            <div class="card-body">
                <form action="RegistrarTrabajo">
                 <input type="text" name="idempresa" for="idempresa" id="iduser" style = "display:none" value="<%=empresa_id%>"></input>
                <div class="form-group">
                  <label for="exampleInputEmail1">Nombre</label>
                  <input type="text" name="nombre" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Nombre del trabajo">
                  
                </div>
                <div class="form-group">
                 <label for="exampleInputEmail1">Descripcion</label>
                 <input type="text" name="descripcion" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Descripcion del trabajo">
                </div>
                  <div class="form-group" >
                      <label for="exampleInputEmail1">Tipo</label>
                      <select id="tipo" name="tipo"  class="form-select" id="inputGroupSelect01">
                    <option selected>Oficina</option>
                    
                    <option >Remoto</option>
                   
                  </select>
                 </div>
                 <div class="form-group">
                    <label for="txtNombre" class="form-label">Categoria Profesion</label>
                      <select id="profesion" name="profesion" class="form-select" required="required">

                                               <%
                                                   try {
                                                       CategoriaProfesion objProfesion = new CategoriaProfesion();
                                                       ArrayList<EntidadCategoriaProfesion> profesiones = objProfesion.llenarCategorias();
                                                       for (EntidadCategoriaProfesion profesion : profesiones) {
                                               %>
                                               <option value="<%out.println(profesion.getCategoria_id());%>"><%out.println(profesion.getDescripcion());%></option>
                                               <%
                                                       }
                                                   } catch (Exception e) {
                                                       out.println(e.getMessage());
                                                   }
                                               %>                                    
                        </select>
                        </div>
                        <div class="form-group" style="padding-bottom: 20px">
                    <label for="txtNombre" class="form-label">Requisito</label>
                      <select id="requisito" name="requisito" class="form-select" required="required">

                                               <%
                                                   try {
                                                       Requisito objRequisito= new Requisito();
                                                       ArrayList<EntidadRequisitos> requisitos = objRequisito.llenarRequisitos();
                                                       for (EntidadRequisitos requisito : requisitos) {
                                               %>
                                               <option value="<%out.println(requisito.getIdRequito());%>"><%out.println(requisito.getNombre());%></option>
                                               <%
                                                       }
                                                   } catch (Exception e) {
                                                       out.println(e.getMessage());
                                                   }
                                               %>                                    
                        </select>
                        </div>
               
                <button type="submit" class="btn btn-primary">Crear</button>
              </form>
            </div>
          </div>
        
    </body>
</html>
