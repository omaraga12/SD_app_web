<%-- 
    Document   : index
    Created on : Nov 12, 2021, 10:46:17 AM
    Author     : Rodrigo Ruidias
--%>

<%@page import="CapaNegocio.Entidades.EntidadUniversidad"%>
<%@page import="java.util.ArrayList"%>
<%@page import="CapaNegocio.Universidad"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>Página en JAVA</title>
        <%@ include file = "Header.jsp"%>
    </head>
    <body>              
        <div class = "container-sm mt-5">
            <div class = "row">
                <div class = "col">
                    <a href="registroPostulante.jsp" type="button" class="btn btn-primary">Ir registro</a>
                    <table class="table caption-top">
                        <caption>Lista de áreas</caption>
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Universidad</th>
                                <th scope="col">Pais</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                try {
                                    Universidad objU = new Universidad();
                                    ArrayList<EntidadUniversidad> universidades = objU.llenarUniversidad();
                                    for (EntidadUniversidad i : universidades) {
                            %>

                            <tr>
                                <th scope="row"><%out.println(i.getUniversidad_id());%></th>
                                <td><%out.println(i.getNombre_universidad());%></td>
                                <td><%out.println(i.getPais_id());%></td>
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
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>        
    </body>
</html>
