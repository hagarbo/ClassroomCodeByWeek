<?php

/*     if (isset(VARIABLES DE FORMULARIO)) {
        // TO DO -> CREAR LAS COOKIES
    } */


/*     if (isset(VARIABLE BOTON BORRAR)) {
        // TO DO BORRAR COOKIES
    } */

?>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Cookies</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>

<body>

    <div id="caja-formulario" class="container mb-3">
        <h1>Introduzca Datos para crear una Cookie</h1>
        <!-- Formulario para crear cookies -->
        <form id="cookie-form" method="post">
            <button type="submit" name="crear-cookie"  value="submit" class="btn btn-primary">Crear Cookie</button>
        </form>

    </div>

    <div id="caja-tabla-cookies" class="container mb-3">
        <h1>Cookies Creadas</h1>
        <!-- Tabla de cookies -->
        <?php
        if (isset($_COOKIE)) {
            // TO DO -> MOSTRAR COOKIES
        }
        ?>

        <!-- Formulario para borrar cookies -->
        <form id="cookie-form" method="post">
            <button type="submit" name="borrar-cookie" value="submit" class="btn btn-primary">Borrar Cookies</button>
        </form>

    </div>

</body>

</html>