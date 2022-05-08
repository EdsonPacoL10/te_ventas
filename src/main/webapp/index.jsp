
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
            <h1>Punto de venta</h1>
            <jsp:include page="META-INF/menu.jsp">   
                <jsp:param name="opcion" value="#"/>
            </jsp:include>
            <a href="#" class="btn btn-primary btn-sm"><i class="fa-solid fa-file-lines"></i> Nuevo </a>
            <br>
            <table class="table table-striped">
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Descripcion</th>
                    <th>Precio</th>
                    <th><a href="#"> <i class="fa-solid fa-pen-to-square"></i></a></th>
                    <th><a href="#"><i class="fa-solid fa-trash-can"></i></a></th>
                </tr>
                <tr>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th></th>
                </tr>


            </table>




            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>


            </body>
        </html>
