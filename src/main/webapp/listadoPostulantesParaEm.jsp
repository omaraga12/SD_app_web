<%-- 
    Document   : listadoPostulantesParaEm
    Created on : 27/11/2021, 08:58:27 AM
    Author     : Roberto Montero
--%>

<%@page import="CapaDatos.conexion"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="Estilos/listado.css" rel="stylesheet" type="text/css"/>
        <title>LISTA DE POSTULANTES</title>
    </head>
    <body>             
        <%
            conexion objC = new conexion();
            ResultSet rs = null;
            String SQL = null;
            SQL = "select p.postulante_id, p.apellido_parterno + ' ' + p.apellido_materno as apellidos, p.nombres, p.numero_colegiatura, u.departamento, pa.nombre_pais from dbo.Postulante as p inner join dbo.Ubigeo as u on u.ubigeo_id = p.ubigeo_ubigeo_id inner join dbo.Pais as pa on pa.pais_id = p.pais_pais_id";
            rs = objC.consultarBD(SQL);
        %>
        <div class = "container-sm mt-5">
            <div class = "row">
                <div class = "col">
                    <div class="titulo"> 
                        <h1>Postulantes</h1>
                    </div>
                    <br>
                    <div class="buscar">                        
                        <form class="form">
                            <div class="row float-end">
                                <div class="col-6">
                                    <input class="form-control me-2" type="text" name="txtbuscar" placeholder="Busca por nombre"> 
                                </div>
                                <div class="col-6">
                                    <input class="btn btn-primary" type="submit" value="Buscar">
                                    <a class="btn btn-primary active" href="">Agregar</a>
                                    <a class="btn btn-primary" href="listadoPostulantesParaEm.jsp"><img src="images/loop.png" alt=""/></a>
                                </div>
                            </div>
                        </form>
                        <%
                            String nombuscar = request.getParameter("txtbuscar");
                            if (nombuscar != null) {
                                SQL = "select p.postulante_id, p.apellido_parterno + ' ' + p.apellido_materno as apellidos, p.nombres, p.numero_colegiatura, u.departamento, pa.nombre_pais from dbo.Postulante as p inner join dbo.Ubigeo as u on u.ubigeo_id = p.ubigeo_ubigeo_id inner join dbo.Pais as pa on pa.pais_id = p.pais_pais_id where p.nombres LIKE" + "'%" + nombuscar + "%'";
                                rs = objC.consultarBD(SQL);
                            } else {
                                System.err.println("Error");
                            }
                        %>
                    </div>                    
                    
                    <div class="tabla mt-5">
                        <table class="table table-dark table-bordered border-secondary">
                            <thead>
                                <tr class="table-active">
                                    <th scope="col">ID</th>
                                    <th scope="col">Apellidos</th>
                                    <th scope="col">Nombres</th>
                                    <th scope="col">Colegiatura</th>
                                    <th scope="col">Departamento</th>
                                    <th scope="col">Pais</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    try {

                                        while (rs.next()) {
                                %>

                                <tr class="table-active">
                                    <th scope="row"><%out.println(rs.getString(1));%></th>
                                    <td><%out.println(rs.getString(2));%></td>
                                    <td><%out.println(rs.getString(3));%></td>
                                    <td><%out.println(rs.getString(4));%></td>
                                    <td><%out.println(rs.getString(5));%></td>
                                    <td><%out.println(rs.getString(6));%></td>
                                </tr>
                                <%
                                        }

                                    } catch (Exception e) {
                                        out.println(e.getMessage());
                                    }

                                %>

                            </tbody>
                        </table>
                    </div>                   
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>        
    </body>
</html>
