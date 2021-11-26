<%-- 
    Document   : notificaciones
    Created on : 21/11/2021, 06:03:08 PM
    Author     : nickb
--%>

<%@page import="CapaLogica.Notificaciones_postulante"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="CapaLogica.Postulante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/357f9dcbc4.js" crossorigin="anonymous"></script>
        <link href="Estilos/notificaciones.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Notificaciones_postulante np = new Notificaciones_postulante();
            ResultSet rs = null;
            int post_id = 0;
            Object rq = request.getAttribute("idpostulante");
            if (rq != null) {
                rs = np.consultarNotificacionesPostulante(Integer.parseInt(request.getAttribute("idpostulante").toString()));
                post_id = Integer.parseInt(request.getAttribute("idpostulante").toString());
        %>
        <div class="container-fluid">
            <nav class="navbar navbar-light bg-light navb">
                <div class="container-fluid row">
                    <div class="container col-4 eleNav">
                        <form action="Controler" method="post">
                            <input type="hidden" name="id_postul1" value=<%=post_id%>>
                            <button class="navbar-brand" style="background: white; border: none" type="submit" name="accion" value="irInicioPostulante">
                                <span class="iconoNav"">
                                    <i class="fas fa-home"></i>
                                </span><br>
                                <p class="textoNav"">Inicio</p>
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
                    <div class="container col-4 eleNav eleNavSelec">
                        <form action="Controler" method="post">
                            <input type="hidden" name="id_postul3" value=<%=post_id%>>
                            <button class="navbar-brand" style="background: white; border: none" type="submit" name="accion" value="irNotificacionesPost"">
                                <span class="iconoNavSelec"">
                                    <i class="far fa-bell"></i>
                                </span><br>
                                <p class="textoNavSelec"">Notificaciones</p>
                            </button>
                        </form>
                    </div> 
                </div>
            </nav>
            <div style="background: whitesmoke;">
                <div class="container">
                    <ul class="list-unstyled">
                        <%
                            while(rs.next()){
                        %>
                        <li class="media" style="padding-bottom: 5px; padding-top: 5px">
                            <img class="mr-3" src="images/icono_home.png" alt="Generic placeholder image">
                            <strong style="float: right;">
                                El <%=rs.getString(3)%> a las <%=rs.getString(4)%>
                            </strong>
                            <div class="media-body">
                                <h5 class="mt-0 mb-1"><%=rs.getString(2)%></h5>
                                <%=rs.getString(6)%><br>
                                Trabajo al que ha postulado: <strong><%=rs.getString(7)%></strong>
                            </div>
                            <hr>
                        </li>
                        <%
                            }
                        %>
                    </ul>
                </div>
            </div>
        </div>
        <%
            } else {
                request.getRequestDispatcher("IniciarSesion.jsp").forward(request, response);
            }
        %>
    </body>
</html>
