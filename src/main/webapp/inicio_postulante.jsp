<%-- 
    Document   : index
    Created on : 17/11/2021, 09:07:07 AM
    Author     : nickb
--%>

<%@page import="CapaLogica.Requisitos_trabajo"%>
<%@page import="CapaLogica.Trabajos_postular"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="CapaLogica.Postulante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/357f9dcbc4.js" crossorigin="anonymous"></script>
        <link href="Estilos/inicio.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Postulante postulante = new Postulante();
            ResultSet rs = null;
            int post_id = 0;
            Object rq = request.getAttribute("idpostulante");
            if(rq!=null){
                rs = postulante.buscarPostulante(Integer.parseInt(request.getAttribute("idpostulante").toString()));
                post_id = Integer.parseInt(request.getAttribute("idpostulante").toString());
        %>
        <div class="container-fluid">
            <nav class="navbar navbar-light bg-light navb">
                <div class="container-fluid row">
                    <div class="container col-4 eleNav eleNavSelec">
                        <form action="Controler" method="post">
                            <input type="hidden" name="id_postul1" value=<%=post_id%>>
                            <button class="navbar-brand" style="background: white; border: none" type="submit" name="accion" value="irInicioPostulante">
                                <span class="iconoNavSelec"">
                                    <i class="fas fa-home"></i>
                                </span><br>
                                <p class="textoNavSelec"">Inicio</p>
                            </button>
                        </form>
                    </div>
                    <div class="container col-4 eleNav">
                        <form action="Controler" method="post">
                            <input type="hidden" name="id_postul2" value=<%=post_id%>>
                            <button class="navbar-brand" style="background: white; border: none" type="submit" name="accion" value="irBuscarTrabajosPost"">
                                <span class="iconoNav"">
                                    <i class="fas fa-search"></i>
                                </span><br>
                                <p class="textoNav"">Buscar</p>
                            </button>
                        </form>
                    </div>
                    <div class="container col-4 eleNav">
                        <form action="Controler" method="post">
                            <input type="hidden" name="id_postul3" value=<%=post_id%>>
                            <button class="navbar-brand" style="background: white; border: none" type="submit" name="accion" value="irNotificacionesPost"">
                                <span class="iconoNav"">
                                    <i class="far fa-bell"></i>
                                </span><br>
                                <p class="textoNav"">Notificaciones</p>
                            </button>
                        </form>
                    </div> 
                </div>
            </nav>
            <div class="row container-fluid cuerpo">
                <div class="col-3">
                    <div class="card text-center" style="width: 18rem;">
                        <img src="images/postulanteImg.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <%if (rs.next()) {%>
                            <h5 class="card-title"><%= rs.getString(1)%></h5>
                            <p class="card-text" style="text-align: justify">
                                <strong><%= rs.getString(2)%>: </strong><%= rs.getString(3)%><br>
                                <strong>País: </strong><%= rs.getString(4)%><br>
                                <strong>Departamento: </strong><%= rs.getString(5)%><br>
                                <strong>Provincia: </strong><%= rs.getString(6)%><br>
                                <strong>Distrito: </strong><%= rs.getString(7)%><br>
                                <strong>Número colegiatura: </strong><%= rs.getString(8)%><br>
                            </p>
                            <%}%>
                            <a href="#" class="btn btn-primary"><i class="fas fa-cog"></i> Modificar</a>
                        </div>
                    </div>
                </div>
                <div class="col-9">
                        <div class="trabajosPostular">
                            <%
                                Trabajos_postular tp = new Trabajos_postular();
                                ResultSet rsTp = tp.consultarTrabajosPostular(post_id);
                                String estado = "Disponible";
                                Requisitos_trabajo rt = new Requisitos_trabajo();
                                int trabajo_id = 0;
                                while (rsTp.next()) {
                                    if (rsTp.getString(3).equals("1")) {
                            %>
                            <form action="Controler" method="post">
                                <div class="card">
                                    <input type="hidden" name="id_trabajo" value=<%=rsTp.getString(1)%>>
                                    <input type="hidden" name="id_postul" value=<%=post_id%>>
                                    <h5 class="card-header"><%= rsTp.getString(2)%></h5>
                                    <img src="images/img_trabajo.jpg" class="card-img-top" alt="..." height="300">
                                    <div class="card-body">
                                        <h5 class="card-title">Categoria: <%= rsTp.getString(6)%></h5><br>
                                        <p class="card-text">
                                            <strong>Descripción:</strong>
                                            <%= rsTp.getString(5)%><br>
                                            <strong>Empresa:</strong>
                                            <%= rsTp.getString(4)%><br>
                                            <strong>Tipo de trabajo:</strong>
                                            <%= rsTp.getString(7)%><br>
                                            <strong>Perfil ideal:</strong>
                                        <ul>
                                            <%
                                                ResultSet rsRt = rt.consultarRequisitosTrabajo(rsTp.getInt(1));
                                                while (rsRt.next()) {
                                            %>
                                            <li><%= rsRt.getString(1)%></li>
                                                <%
                                                    }
                                                %>
                                        </ul>
                                        </p>
                                        <button class="btn btn-primary" type="submit" name="accion" value="registrar_trabajo_postulante">Postular</button>
                                    </div>
                                </div><br>
                            </form>
                            <%
                                    }
                                }
                            %>
                        </div>
                </div>
            </div>
        </div>
        <%
            }else{
                request.getRequestDispatcher("IniciarSesion.jsp").forward(request, response);
            }
        %>
    </body>
</html>
