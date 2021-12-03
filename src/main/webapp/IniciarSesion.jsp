<%-- 
    Document   : IniciarSesion
    Created on : 14-nov-2021, 14:47:43
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Inicia Sesion</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    
    <link rel="stylesheet" href="./Estilos/Registro.css" type="text/css">
    
</head>
<body>
    <span  class="error">${message}</span>
    <div class="main">

        <section class="signup">
            <!-- <img src="images/signup-bg.jpg" alt=""> -->
            <div class="container">
                <div class="signup-content">
                    <form method="POST" action="IniciarSesion" id="signup-form" class="signup-form">
                        <h2 class="form-title">Iniciar Sesion</h2>
                        <h3 class="form-title">Ingresar como: </h3>
                        <div class="form-radio">
                        <input type="radio" name="type" value="user" checked="checked" />
                        <label for="newbie">Usuario</label>
                        <input type="radio" name="type" value="admin"  />
                        <label for="average">Administrador</label>
                       
                        
                        </div>
                        

                       <div class="form-group">
                            <input type="email" class="form-input" name="email" id="email" placeholder="Correo Electronico"/>
                        </div>
                       
                        <div class="form-group">
                            <input type="text" class="form-input" name="password" id="password" placeholder="Contraseña"/>
                            <span toggle="#password" class="zmdi zmdi-eye field-icon toggle-password"></span>
                        </div>
                       
                        <div class="form-group">
                            
                            <label for="agree-term" class="label-agree-term"><span><span></span></span> <a href="#" class="term-service">Olvidaste tu contraseña?</a></label>
                        </div>
                        <div class="form-group">
                            <input type="submit" name="submit" id="submit" class="form-submit" value="Iniciar Sesion"/>
                        </div>
                    </form>
                    <p class="loginhere">
                        No tienes una cuenta ? <a href="Registro.jsp" class="loginhere-link">Registrate aqui</a>
                    </p>
                </div>
            </div>
        </section>

    </div>

    <!-- JS -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="js/main.js"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>
