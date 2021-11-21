/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


 window.addEventListener('load', function(){
     document.getElementById('submit').addEventListener('click', function(){
            var documento=document.getElementById('doc').value;
            var correo=document.getElementById('email').value;
            var contrasena=document.getElementById('password').value;
            var reContrasena=document.getElementById('re_password').value;
            
            var camposVacios=false;
            var contrasenas=false;
            if(documento.length>0 && correo.length>0 && contrasena.length>0 && reContrasena>0){
                camposVacios=true;
            }
            if(contrasena===reContrasena){
                contrasenas=true;
            }
            if(camposVacios===false){
                alert('Ingresa todos los datos por favor');
             
            }else{
                if(contrasenas===false){
                    alert('Las contrasenas deben coincidir');
                }else{
                    document.getElementById('signup-form').submit();
                }
            }
     
            
        });
    });