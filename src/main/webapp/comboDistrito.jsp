<%-- 
    Document   : cboDistrito
    Created on : Nov 11, 2021, 12:22:03 PM
    Author     : Rodrigo Ruidias
--%>

<%@page import="CapaNegocio.Ubigeo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<select name="inputDistrito">
    <option value="">Seleccione</option>
    <%
        try {
            Ubigeo objU = new Ubigeo();
            if (!(request.getParameter("inputProvincia").isEmpty())) {
                objU.setDepartamento(request.getParameter("inputDepartamento"));
                objU.setProvincia(request.getParameter("inputProvincia"));
                ArrayList<String> distritos = objU.distritoUbigeo();
                for (String distrito : distritos) {
    %>
                    <option><%out.println(distrito);%></option>
    <%
                }
            }
        } catch (Exception e) {
            out.println(e.getMessage());
        }
    %>
</select>
