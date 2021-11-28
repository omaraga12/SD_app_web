<%-- 
    Document   : MenuListadoEm
    Created on : 27/11/2021, 11:39:44 AM
    Author     : Roberto Montero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="Estilos/MenuListadoEmp.css" rel="stylesheet" type="text/css"/>
        <title>MENU DE LISTADO DE EMPRESAS</title>
    </head>
    <body>
        <div class="container">
            <div class="row mt-5 justify-content-center align-items-center">
                
            <div class="col-sm-4 mt-5">
                <div class="card text-center">
                    <div class="card-body">
                        <h5 class="card-title mt-5">Empresas</h5>
                        <p class="card-text mt-3">Puedes ver a todas las empresas y sus datos en un listado.</p>
                        <div>
                            <img class="mt-3" src="images/emp_rm.png" alt="alt"/>
                        </div>
                        <a href="listadoEmpresasParaPost.jsp" class="btn btn-primary mt-5 col-sm-4">Listar Datos</a>
                    </div>
                </div>
            </div>
         
        </div> 
        </div>
    </body>
</html>
