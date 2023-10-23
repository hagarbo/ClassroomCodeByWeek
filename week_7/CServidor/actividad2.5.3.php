<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        #message {
            color: red;
            font-family: 'Courier New', Courier, monospace;
            font-size: 16px;
            font-weight: 800;
        }

        h1 {
            font-size: 36px;
            font-weight: 900;
            font-family: 'Courier New', Courier, monospace;
        }

        label,
        input {
            font-family: Verdana, Geneva, Tahoma, sans-serif;
            font-size: 14px;
        }
    </style>
</head>

<body>
    <h1>Cálculo de la calificación final</h1>
    <form action="#" method="post">
        <p>
            <label for="calificaciones">Introduzca las calificaciones separadas por /.(Ej.: 5/4)</label>
            <input type="text" name="calificaciones" id="calificaciones" required>
        </p>
        <p>
            <label for="pesos">Introduzca los pesos separados por %.(Ej.: 50%50)</label>
            <input type="text" name="pesos" id="pesos" required>
        </p>
        <input type="submit" value="Calcular media">
    </form>

    <?php

    const NOTAS_SEPARATOR = '/\//';
    const PESOS_SEPARATOR = '/\%/';
    const MAX_PORCENTAJE = 100;
    const MIN_PORCENTAJE = 5;
    const NOTA_MINIMA = 0;
    const NOTA_MAXIMA = 10;

    require_once "utilities" . DIRECTORY_SEPARATOR . "funciones.php";

    if (isset($_POST["calificaciones"]) && isset($_POST["pesos"])) {

        $notas = preg_split(NOTAS_SEPARATOR, $_POST["calificaciones"]);
        $pesos = preg_split(PESOS_SEPARATOR, $_POST["pesos"]);

        $validacion = validar($notas, $pesos);
        if ($validacion === true) {
            $media = calculaNotaMedia($notas, $pesos);
            printf("<p id='message'>La nota media es: %.2f </p>", $media);
        } else {
            echo $validacion;
        }
    }
    ?>

</body>

</html>