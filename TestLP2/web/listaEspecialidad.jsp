<%-- 
    Document   : listaEspecialidad
    Created on : 13/10/2017, 09:20:20 PM
    Author     : Elvin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="estilos.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="principal">
            <div class="encabezado"></div>
            <div class="menu">
                <jsp:include page="menu.jsp"></jsp:include>
                </div>
                <div class="contenido">
                    <div class="titulo">Lista Especialidades</div>
                    <table class="tablaDatos">
                        <tr>
                            <th>Codigo</th>
                            <th>Descripcion</th>
                            <th>Costo</th>
                        </tr>
                    <jsp:useBean class="daoImpl.EspecialidadDAOImpl"  id="espDAO"></jsp:useBean>
                    <c:forEach items="${espDAO.listar()}" var="e">
                        <tr>
                            <td>${e.codigo}</td>
                            <td>${e.descripcion}</td>
                            <td>${e.costo}</td>
                            <td><a href="">Eliminar</a></td>
                        </tr>
                    </c:forEach>

                </table>

            </div>
    </body>
</html>
