<%-- 
    Document   : MenuListado
    Created on : 27/11/2021, 09:26:09 AM
    Author     : Roberto Montero   
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="Estilos/listado.css" rel="stylesheet" type="text/css"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <link href="Estilos/MenuListado.css" rel="stylesheet" type="text/css"/>
        <title>MENU</title>
    </head>
    <body>
        <div >
            <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-indicators">
                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="images/empresa_rm.jpg" class="d-block w-100" alt="...">
                    <div class="carousel-caption d-none d-md-block">
                        <a class="text-tittle" href="">GESTIONAR EMPRESA</a>
                        <p class="mt-3">Tendremos la posibilidad de modificar los datos de las empresas. Debe ingresar el número de RUC de la empresa correctamente para poder obtener sus respectivos datos. Mucho cuidado a la hora de ingresar el RUC de la empresa ya que se podria modificar los datos de una empresa no requerido</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="images/postulantes_rm.jpg" class="d-block w-100" alt="...">
                    <div class="carousel-caption d-none d-md-block">
                        <a class="text-tittle" href="">GESTIONAR POSTULANTE</a>
                        <p class="mt-3">Tendremos la posibilidad de modificar los datos de los postulantes. Debe ingresar el número de DNI del postulante correctamente para poder obtener sus respectivos datos. Mucho cuidado a la hora de ingresar el DNI del postulante ya que se podria modificar los datos de un postulante no requerido</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="images/datos_rm.jpg" class="d-block w-100" alt="...">
                    <div class="carousel-caption d-none d-md-block">
                        <a class="text-tittle" href="MenuListadoEm-Post.jsp">LISTAR DATOS</a>
                        <p class="mt-3">Podemos visualizar a los postulante y a las empresas con sus respectivos datos que ya han sido registrados en el sistema y guardados en la base de datos</p>
                    </div>
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Anterior</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Siguiente</span>
            </button>
        </div>
        </div>
    </body>
</html>
