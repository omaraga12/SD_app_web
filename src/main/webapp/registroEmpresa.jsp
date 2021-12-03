<%-- 
    Document   : registroEmpresa
    Created on : 02-dic-2021, 14:42:09
    Author     : DELL
--%>


<%@page import="CapaNegocio.Entidades.EntidadPais"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="CapaNegocio.Pais"%>
<!DOCTYPE html>
<html>
    <head>
<title>Registrar Empresa</title>
	<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<script>
      function obtnerDatosRuc(){
          
          var requestOptions = {
                method: 'GET',
                redirect: 'follow'
              };

              fetch("https://api.apis.net.pe/v1/ruc?numero=10734169477", requestOptions)
                .then(response => response.text())
                .then(result => alert(result))
                .catch(error => alert('error', error));
      }
      
      
      
      
        
</script>
</head>
<body>
	<div class="container w-50">
		<div class="row mt-5">
			<div class=" d-flex justify-content-center">
				<h1 class="text-primary fw-bolder">Registrar Empresa</h1>
			</div>
		</div>
	<div class="row">
            <form action="/RegistrarEmpresa">
    
            <div class="mb-3 mt-3">
               <label for="txtRuc" class="form-label">RUC:</label>

                   <div class="d-flex d-flex justify-content-between">
                       <input type="number" id="ruc" name="ruc" class="form-control" style="width: 450px;"  placeholder="Ingrese el RUC de su empresa" name="txtRuc">
                            <button class="btn btn-primary" style="width: 150px;" onclick="obtnerDatosRuc();">SUNAT</button>
                   </div>
             </div>

             <div class="mb-3">
               <label for="txtNombre" class="form-label">Nombre:</label>
               <input type="text" id="nombre" name="nombre"  class="form-control" id="txtNombre" placeholder="Ingrese el nombre de la empresa" >
             </div>

             <div class="mb-3">
               <label for="txtNombre" class="form-label">Foto :</label>
               <div class="input-group mb-3">
                 <input type="file" class="form-control" id="inputGroupFile02">
               </div>
             </div>

            <div class="mb-3">
               <label for="txtNombre" class="form-label">Tipo :</label>
           <div class="input-group mb-3">
             <select id="tipo" name="tipo"  class="form-select" id="inputGroupSelect01">
               <option selected>SAC</option>
               <option value="1">SAA</option>
               <option value="2">EIRL</option>
               <option value="3">SRL</option>
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
                     <button type="submit" class="btn btn-primary w-50 mt-5">Registrar</button>
                 </div>

</form>
	</div>
	</div>
</body>
</html>
