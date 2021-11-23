<%-- 
    Document   : index
    Created on : 17/11/2021, 09:07:07 AM
    Author     : nickb
--%>

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
        <div class="container-fluid">
            <nav class="navbar navbar-light bg-light navb">
                <div class="container-fluid row">
                    <div class="container col-4 eleNav eleNavSelec">
                        <a class="navbar-brand" href="inicio_postulante.jsp"">
                            <span class="iconoNavSelec"">
                                <i class="fas fa-home"></i>
                            </span><br>
                            <p class="textoNavSelec"">Inicio</p>
                        </a>
                    </div>
                    <div class="container col-4 eleNav">
                        <a class="navbar-brand" href="buscar.jsp"">
                            <span class="iconoNav"">
                                <i class="fas fa-search"></i>
                            </span><br>
                            <p class="textoNav"">Buscar</p>
                        </a>
                    </div>
                    <div class="container col-4 eleNav">
                        <a class="navbar-brand" href="notificaciones.jsp"">
                            <span class="iconoNav"">
                                <i class="far fa-bell"></i>
                            </span><br>
                            <p class="textoNav"">Notificaciones</p>
                        </a>
                    </div> 
                </div>
            </nav>
            <div class="row container-fluid cuerpo">
                <div class="col-3">
                    <div class="card text-center" style="width: 18rem;">
                        <img src="images/icono_home.png" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">${idpostulante}</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                            <a href="#" class="btn btn-primary"><i class="fas fa-cog"></i> Modificar</a>
                        </div>
                    </div>
                </div>
                <div class="col-9">
                    <div class="trabajosPostular">
                        <div class="card">
                            <h5 class="card-header">Trabajo 1</h5>
                            <img src="images/img_trabajo.jpg" class="card-img-top" alt="..." height="300">
                            <div class="card-body">
                                <h5 class="card-title">NOmbre trabajo</h5>
                                <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                                <a href="#" class="btn btn-primary">Postular</a>
                            </div>
                        </div><br>
                        <div class="card">
                            <h5 class="card-header">Trabajo 1</h5>
                            <img src="images/img_trabajo.jpg" class="card-img-top" alt="..." height="300">
                            <div class="card-body">
                                <h5 class="card-title">NOmbre trabajo</h5>
                                <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                                <a href="#" class="btn btn-primary">Postular</a>
                            </div>
                        </div><br>
                        <div class="card">
                            <h5 class="card-header">Trabajo 1</h5>
                            <img src="images/img_trabajo.jpg" class="card-img-top" alt="..." height="300">
                            <div class="card-body">
                                <h5 class="card-title">NOmbre trabajo</h5>
                                <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                                <a href="#" class="btn btn-primary">Postular</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
