<%-- 
    Document   : Registro
    Created on : 19-nov-2021, 11:48:19
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Registrate</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    
    <link rel="stylesheet" href="./Estilos/Registro.css" type="text/css">
    
     <%@ include file = "Header.jsp"%>
</head>
<body>
   
 
    <div class="main">
     
   
        <section class="signup">
            <!-- <img src="images/signup-bg.jpg" alt=""> -->
            <div class="container">
                <div class="signup-content">
                    <form action="RegistroUsuario" method="POST" id="signup-form" class="signup-form">
                        <h2 class="form-title">Crea una Cuenta</h2>
                        <h3 class="form-title">Que tipo de usuario eres?</h3>
                        <div class="form-radio">
                        <input type="radio" name="type" value="empresa" checked="checked" />
                        <label for="newbie">Empresa</label>
                        <input type="radio" name="type" value="postulante"  />
                        <label for="average">Postulante</label>
                       
                        
                        </div>
                        <div class="form-group">
                            <input type="number" class="form-input" name="doc" id="doc" placeholder="DNI o RUC"/>
                        </div>
                        <div class="form-group">
                            <input type="email" class="form-input" name="email" id="email" placeholder="Correo Electronico"/>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-input" name="password" id="password" placeholder="Contraseña"/>
                            <span toggle="#password" class="zmdi zmdi-eye field-icon toggle-password"></span>
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-input" name="re_password" id="re_password" placeholder="Repite tu contraseña"/>
                        </div>
                       
                        <div class="form-group">
                            <input type="submit" name="submit" id="submit" class="form-submit" value="Registrarse"/>
                        </div>
                    </form>
                    <p class="loginhere">
                        Ya tienes una cuenta ? <a href="IniciarSesion.jsp" class="loginhere-link">Ingresa aqui</a>
                    </p>
                </div>
            </div>
        </section>

    </div>

    <!-- JS -->
    <!-- <script src="vendor/jquery/jquery.min.js"></script>
    <script src="js/main.js"></script>-->
    <script src="js/RegistroUsuario.js"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>
