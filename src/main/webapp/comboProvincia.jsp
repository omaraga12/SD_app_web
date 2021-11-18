<%-- 
    Document   : combo
    Created on : Nov 11, 2021, 11:39:40 AM
    Author     : Rodrigo Ruidias
--%>

<%@page import="CapaNegocio.Ubigeo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<select name="inputProvincia">
    <option value="">Seleccione</option>
    <%
        try {
            Ubigeo objU = new Ubigeo();
            if (!request.getParameter("inputDepartamento").isEmpty()) {
                objU.setDepartamento(request.getParameter("inputDepartamento"));
                ArrayList<String> provincias = objU.provinciaUbigeo();
                for (String provincia : provincias) {
    %>
                    <option><%out.println(provincia);%></option>
    <%
                }
            }
        } catch (Exception e) {
            out.println(e.getMessage());
        }
    %>
</select>
