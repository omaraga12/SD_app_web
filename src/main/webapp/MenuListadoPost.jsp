<%-- 
    Document   : MenuListadoPost
    Created on : 27/11/2021, 11:41:02 AM
    Author     : Roberto Montero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="Estilos/MenuListadoPost.css" rel="stylesheet" type="text/css"/>
        <title>MENU DE LISTADO DE POSTULANTES</title>
    </head>
    <body>
        <div class="container">
            <div class="row mt-5">
            <div class="col-sm-4 mt-5">
                <div class="card text-center">
                    <div class="card-body">
                        <h5 class="card-title mt-5">Postulantes</h5>
                        <p class="card-text mt-3">Puedes ver a todos los postulantes y sus datos en un listado.</p>
                        <div>
                            <img class="mt-3" src="images/postulant_rm.png" alt="alt"/>
                        </div>
                        <a href="listadoPostulantesParaEm.jsp" class="btn btn-primary mt-5 col-sm-4">Listar Datos</a>
                    </div>
                </div>
            </div>
            <div class="col-sm-4 mt-5">
                <div class="card text-center">
                    <div class="card-body">
                        <h5 class="card-title mt-5">Idiomas Postulantes</h5>
                        <p class="card-text mt-3">Puedes ver todos los idiomas y que postulantes cuentan con la certificacion de los idiomas.</p>
                        <div>
                            <img class="mt-3" src="images/idiomas_rm.png" alt="alt"/>
                        </div>
                        <a href="listadoIdiomasPostParaEmp.jsp" class="btn btn-primary mt-5 col-sm-4">Listar Datos</a>
                    </div>
                </div>
            </div>
            <div class="col-sm-4 mt-5">
                <div class="card">
                    <div class="card-body text-center">
                        <h5 class="card-title mt-5">Profesiones de Postulantes</h5>
                        <p class="card-text mt-3">Puedes ver todos las profesiones y que postulantes cuentan con la certificacion de las profesiones.</p>
                        <div>
                            <img class="mt-3" src="images/profesiones_rm.png" alt="alt"/>
                        </div>
                        <a href="listadoProfesionPostParaEmpresa.jsp" class="btn btn-primary mt-5 col-sm-4">Listar Datos</a>
                    </div>
                </div>
            </div>
        </div> 
        </div>
    </body>
</html>

