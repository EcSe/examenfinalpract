<%-- 
    Document   : frmMedico
    Created on : 09/10/2017, 04:29:46 PM
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
                <form action="medicoServlet" method="POST">
                    <input type="hidden" name="accion" value="agregarMedico">
                    <table class="tablaFrm">

                        <tr>
                            <td>Especialidad</td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>Nombre</td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>Turno</td>
                            <td></td>
                        </tr>
                    </table>

                </form>
            </div>
    </body>
</html>
