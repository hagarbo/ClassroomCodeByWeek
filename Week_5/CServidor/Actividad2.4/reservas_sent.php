<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DATOS RECOGIDOS DEL FORMULARIO</title>
</head>

<body>


    <h2> Estos son los datos recibidos de tu formulario:</h2>
    <?php

    foreach ($_FILES as $key => $value) {
        echo "<pre>";
        print_r($value);
        echo "</pre>";
    }
    //cambiar $_POST por $_GET en función del método HTTP utilizado
    foreach ($_POST as $clave => $valor) {

        echo "<strong>$clave</strong>:";

        if (!is_array($valor)) {

            echo " $valor";
        } else {

            echo var_dump($valor);
        }

        echo "<br/>";
    }

    ?>

</body>