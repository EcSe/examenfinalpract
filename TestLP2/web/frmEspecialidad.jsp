<%-- 
    Document   : frmEspecialidad
    Created on : 09/10/2017, 01:42:41 PM
    Author     : Elvin
--%>

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
                <div class="titulo">Agregar Especialidad</div>
                <form action="especialidadServlet" method="POST">
                    <input type="hidden" name="accion" value="agregarEspecialidad">
                    <table class="tablaFrm">
                   
                            <tr>
                                <td>Descripcion</td>
                                <td><input type="text" name="txtDescripcion"></td>
                            </tr>
                            <tr>
                                <td>Costo</td>
                                <td><input type="text" name="txtCosto"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type="submit" value="AGREGAR"></td>
                            </tr>
                    </table>
                      ${mensaje}
                </form>
            </div>
        </div>            
    </body>
</html>
