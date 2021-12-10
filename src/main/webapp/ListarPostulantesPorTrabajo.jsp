<%-- 
    Document   : ListarPostulantesPorTrabajo
    Created on : 09-dic-2021, 19:18:27
    Author     : DELL
--%>

<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="CapaLogica.Trabajo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Postulantes</title>
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </head>
    <body>
        <%
         
           
           
           String trabajo_id=request.getAttribute("trabajo_id").toString();
           String nombre_trabajo=request.getAttribute("nombre").toString();
        %>
        
   <div class="container p-4">
        <h2>Postulaciones para <%out.print(nombre_trabajo);%></h2>
      <div class="row">   
       <%
           
      
                                        try {
                                            Trabajo obj = new Trabajo();
                                            ResultSet rs=obj.mostrarPostulantesPorTrabajo(trabajo_id);
                                            while(rs.next()){
                                                
                                         
        %>                                     
                      <div class="card" style="width: 18rem;" >
                         
                                  <input type="hidden" name="id_postulante" value=<%=rs.getString(1)%>>
                                        
                                  <img class="card-img-top"  src="images/<%out.println(rs.getString(5));%>" alt="Card image cap"/>
                                     <div class="card-body">
                                         <h5 class="card-title" ><%out.println(rs.getString(2));%> <%out.println(rs.getString(3));%> <%out.println(rs.getString(4));%></h5>
                                       <p class="card-text"><%out.println(rs.getString(6));%></p>
                                     </div>
                                     <div class="card-body">
                                         <h5 class="card-title" >Categoria de Profesion</h5>
                                       <p class="card-text"><%out.println(rs.getString(10));%></p>
                                     </div>
                                     <ul class="list-group list-group-flush">
                                       <li class="list-group-item">Departamento: <%out.println(rs.getString(7));%></li>
                                       <li class="list-group-item">Provincia:  <%out.println(rs.getString(8));%></li>
                                       <li class="list-group-item">Distrito: <%out.println(rs.getString(9));%></li>
                                     </ul>
                                     <div class="card-body">
                                       
                                       
                                       <a href="#"  class="card-link">Ver Curriculum</a>
                                     </div>
                              
                              
                          </div> 
                     
       <%                                       
                                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, ex);
                        }
                                            
        %>
       </div> 
       </div> 
    </body>
</html>
