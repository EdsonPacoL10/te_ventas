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
            <h1>FORMULARIO DE CLIENTES</h1>
            <jsp:include page="META-INF/menu.jsp">   
                <jsp:param name="opcion" value="clientes"/>
            </jsp:include>

            <br>
            <form action ="ClienteControlador" method="post">
                <input type="hidden" name="id" value="${cliente.id}">
                    <div class="mb-3">
                        <label for="" class="form-label">Nombre</label>
                        <input type="text" class="form-control" name="nombre" value ="${cliente.nombre}"placeholder="escriba su nombre">
                   </div>
                    <div class="mb-3">
                        <label for="" class="form-label">Correo</label>
                        <input type="email" class="form-control" name="correo"value ="${cliente.correo}" placeholder="escriba su correo electronico" >
                    </div>
                <div class="mb-3">
                        <label for="" class="form-label">Celular</label>
                        <input type="text" class="form-control" name="celular" value ="${cliente.celular}"placeholder="escriba su celular" >
                    </div>
                    
                    <button type="submit" class="btn btn-primary">Enviar</button>
                </form>
            

            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>


    </body>
</html>
