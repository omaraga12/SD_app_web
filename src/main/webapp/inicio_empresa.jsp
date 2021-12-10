<%-- 
    Document   : inicio_empresa
    Created on : 29-nov-2021, 15:45:26
    Author     : DELL
--%>

<%@page import="CapaLogica.Empresa"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="CapaLogica.Trabajo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <title>Inicio Empresa</title>
        <script src="js/Modal.js"></script>
        <link rel="stylesheet" href="./Estilos/Modal.css" type="text/css">
    </head>
    <body>
        
       <%
           String post_id = "0";
           String trabajo_id="0";
            Object rq = request.getAttribute("idempresa");
            System.err.println(rq);
            if(rq!=null){
                
                post_id = request.getAttribute("idempresa").toString();
                                        try {
                                            Empresa objEmpresa = new Empresa();
                                            ResultSet rs=objEmpresa.ListarDatosEmpresa(post_id);
                                            while(rs.next()){
                                            
        %>
        
     
            <div style="display: flex; flex-direction: row; flex-wrap: wrap;">
            <div id="<%out.println(rs.getString(1));%> "class="card" style="width: 18rem; margin:20px;margin-top: 20px;">
            <img class="card-img-top" src="images/empresa.jpg" alt="Card image cap">

            <div class="card-body">
              <h5 class="card-title"><%out.println(rs.getString(4));%> </h5>
              <h5 class="card-title"> <%out.println(rs.getString(2));%>  <%out.println(rs.getString(3));%> </h5>
              <p class="card-text">País: <%out.println(rs.getString(5));%></p>
              <a href="#" id="myBtn" class="btn btn-primary" onclick="AbirModalModificar()">Modificar</a>
            </div>
          </div>
              <div>
                   <jsp:include page="RegistrarTrabajo.jsp" >
                        <jsp:param name="idempresa" value="<%=post_id%>"/>
                        
                      </jsp:include>
              </div>
             
        </div>  
              
          
        
        <%
                        }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, ex);
                        }
                        
                        
                    %>
                
       <!-- The Modal1 -->
                <div id="myModal" class="modal">

                  <!-- Modal content -->
                  <div class="modal-content">
                      <span class="close">&times;</span>
                      
                      <jsp:include page="ModificarEmpresa.jsp" >
                        <jsp:param name="idempresa" value="<%=post_id%>"/>
                        
                      </jsp:include>
                  </div>

                </div>
       
        
       
  
            <div class="container p-4">
                <h3>Trabajos publicados: </h3>
                <div class="row">

                    <%
                                        try {
                                            Trabajo objTrabajo = new Trabajo();
                                            ResultSet rs2=objTrabajo.mostrarTrabajosPorEmpresa(post_id);
                                            while(rs2.next()){
                                            
                      %>
                     
                         
                          <div class="card" style="width: 18rem;" >
                              <form action="ActualizarTrabajo">
                                  <input type="hidden" name="id_trabajo" value=<%=rs2.getString(1)%>>
                                  <input type="hidden" name="id_postul" value=<%=post_id%>>
                                   <input type="hidden" name="nombre" value=<%=rs2.getString(2)%>>
                                      <img class="card-img-top"  src="images/trabajo.jpg" alt="Card image cap"/>
                                     <div class="card-body">
                                         <h5 class="card-title"  ><%out.println(rs2.getString(2));%></h5>
                                       <p class="card-text"><%out.println(rs2.getString(4));%></p>
                                     </div>
                                     <ul class="list-group list-group-flush">
                                       <li class="list-group-item">Categoria: <%out.println(rs2.getString(5));%></li>
                                       <li class="list-group-item">Tipo: <%out.println(rs2.getString(6));%></li>
                                       <li class="list-group-item">Estado: <%out.println(rs2.getString(3));%></li>
                                     </ul>
                                     <div class="card-body">
                                       <div class="row">
                                       <div >
                                       <button  class="btn btn-primary" type="submit">Dar de baja</button>
                                       </div>
                                       
                                       
                                       </div>
                                     </div>
                              </form >
                              <div style="padding-bottom: 15px">
                                  <form action="ListarPostulaciones">
                                      <input type="hidden" name="id_trabajo" value=<%=rs2.getString(1)%>>
                                     
                                      <input type="hidden" name="nombre" value=<%=rs2.getString(2)%>>
                                      <button  class="btn btn-primary" type="submit" >Ver Postulaciones</button>
                                  </form>
                               
                                         
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
       
       <%
            }else{

                request.getRequestDispatcher("IniciarSesion.jsp").forward(request, response);
            }
        %>
        
    </body>
</html>
