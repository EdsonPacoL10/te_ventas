<%
if(session.getAttribute("login")!="OK"){
    response.sendRedirect("login.jsp");
    }
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" rel="stylesheet">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <title>punto de venta</title>
    </head>
    <body>
        <div class="container">
            <h1>Clientes</h1>
            <jsp:include page="META-INF/menu.jsp">   
                <jsp:param name="opcion" value="clientes"/>
            </jsp:include>
            <a href="Logout" class="btn btn-danger">Cerrar sesion</a>
             <br>
            <a href="ClienteControlador?action=add" class="btn btn-primary btn-sm"><i class="fa-solid fa-file-lines"></i> Nuevo </a>
            <br>
            <table class="table table-striped">
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Correo</th>
                    <th>Celular</th>
                    <th><a href="#"> <i class="fa-solid fa-pen-to-square"></i></a></th>
                    <th><a href="#"><i class="fa-solid fa-trash-can"></i></a></th>
                </tr>
                <c:forEach var="item" items="${clientes}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.nombre}</td>
                    <td>${item.correo}</td>
                    <td>${item.celular}</td>
                    <td><a href="ClienteControlador?action=edit&id=${item.id}"> <i class="fa-solid fa-pen-to-square"></i></a></td>
                    <td><a href="ClienteControlador?action=delete&id=${item.id}" onclick="return( confirm('Esta seguro????'))"> <i class="fa-solid fa-trash-can"></i></a></td>
                </tr>
                </c:forEach>

            </table>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>


            </body>
        </html>










