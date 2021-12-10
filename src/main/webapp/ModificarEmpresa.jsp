<%-- 
    Document   : ModificarEmpresa
    Created on : 09-dic-2021, 13:09:55
    Author     : DELL
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="CapaLogica.Empresa"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="CapaNegocio.Entidades.EntidadPais"%>
<%@page import="java.util.ArrayList"%>
<%@page import="CapaNegocio.Pais"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Empresa</title>
        

    </head>
    <body>
        <%
           String empresa_id = request.getParameter("idempresa");
           String ruc="";
           String nombre="";
           
           String logo="";
           
            
                                        try {
                                            Empresa objEmpresa = new Empresa();
                                            ResultSet rs=objEmpresa.ListarDatosEmpresa(empresa_id);
                                            while(rs.next()){
                                                ruc=rs.getString(4);
                                                nombre=rs.getString(2);
                                                logo=rs.getString(6);
                                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, ex);
                        }
                                            
        %>
        <div class="container w-50">
		<div class="row mt-5">
			<div class=" d-flex justify-content-center">
				<h1 class="text-primary fw-bolder">Modificar Empresa</h1>
			</div>
		</div>
	<div class="row">
            <form action="ModificarEmpresa">
             <input type="text" name="idempresa" for="idempresa" id="iduser" style = "display:none" value="<%=empresa_id%>"></input>
            <div class="mb-3 mt-3">
               <label for="txtRuc" class="form-label">RUC:</label>

                   <div class="d-flex d-flex justify-content-between">
                       <input type="number" id="ruc" name="ruc"  class="form-control" style="width: 450px;" value="<%=ruc%>" placeholder="Ingrese el RUC de su empresa">
                           
                   </div>
               <input type="text" name="iduser" for="iduser" id="iduser" style = "display:none" value="${iduser}"></input>
             </div>

             <div class="mb-3">
               <label for="txtNombre" class="form-label">Nombre:</label>
               <input type="text" id="nombre" name="nombre" value="<%=nombre%>"  class="form-control" id="txtNombre" placeholder="Ingrese el nombre de la empresa" >
             </div>

             <div class="mb-3">
               <label for="inputSeleccionarImagen" class="form-label">Logo: <%out.println(logo);%>></label>
               <div class="input-group mb-3">
                 <input class="form-control"  type="file" name="inputSeleccionarImagen">
               </div>
               
                             
             </div>

            <div class="mb-3">
               <label for="txtNombre" class="form-label">Tipo :</label>
           <div class="input-group mb-3">
             <select id="tipo" name="tipo"  class="form-select" id="inputGroupSelect01">
               <option selected>SAC</option>
               <option >SAA</option>
               <option >EIRL</option>
               <option >SRL</option>
             </select>
           </div>
             </div>

            <div class="mb-3">
         <label for="txtNombre" class="form-label">Pais :</label>
           <select id="pais" name="pais" class="form-select" required="required">
                                    
                                    <%
                                        try {
                                            Pais objPais = new Pais();
                                            ArrayList<EntidadPais> paises = objPais.llenarPais();
                                            for (EntidadPais pais : paises) {
                                    %>
                                    <option value="<%out.println(pais.getPais_id());%>"><%out.println(pais.getNombre_pais());%></option>
                                    <%
                                            }
                                        } catch (Exception e) {
                                            out.println(e.getMessage());
                                        }
                                    %>                                    
             </select>
             </div>
                     <div class=" d-flex justify-content-center">
                     <button type="submit" class="btn btn-primary w-50 mt-5">Actualizar datos</button>
                 </div>

</form>
	</div>
	</div>
    </body>
</html>
