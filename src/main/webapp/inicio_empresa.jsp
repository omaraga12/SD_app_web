<%-- 
    Document   : inicio_empresa
    Created on : 29-nov-2021, 15:45:26
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${idempresa != null}">
            <p>Welcome, ${idempresa}</p>
            <h1>Hello World!</h1>
        </c:if>
        
    </body>
</html>
