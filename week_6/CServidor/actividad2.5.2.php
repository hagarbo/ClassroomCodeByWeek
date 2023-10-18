<?php

const MAX_RANDOM = 10;

function mostrarTabla(int $f, int $c): string
{
    $html = "<table><thead><tr>";
    for ($i = 1; $i <= $c; $i++) {
        $html .= "<th>Col. " . $i . "</th>";
    }
    $html .= "</tr></thead>";
    $html .= "<tbody>";
    for ($i = 0; $i < $f; $i++) {
        $html .= "<tr>";
        for ($j = 0; $j < $c; $j++) {
            $html .= "<td>" . rand(0, MAX_RANDOM) . "</td>";
        }
        $html .= "</tr>";
    }
    $html .= "</tbody></table>";
    return $html;
}

function crearArray(int $f, int $c): array
{
    $array = array(array());

    for ($i = 0; $i < $f; $i++) {
        for ($j = 0; $j < $c; $j++) {
            $array[$i][$j] = rand(0, 10);
        }
    }

    return $array;
}

function mostrarArrayEnTabla(array $array): string
{
    $html = "<table><thead><tr>";
    $html .= "</tr></thead>";
    $columnas = sizeof($array[array_key_first($array)]);
    for ($i = 0; $i < $columnas; $i++) {
        $html .= "<th>Col. " . $i . "</th>";
    }
    $html .= "<tbody>";
    foreach ($array as $fila) {
        $html .= "<tr>";
        foreach ($fila as $celda) {
            $html .= "<td>" . $celda . "</td>";
        }
        $html .= "</tr>";
    }
    $html .= "</tbody></table>";
    return $html;
}

?>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        table,
        td,
        th {
            border: 1px solid black;
            border-collapse: collapse;
            text-align: center;
        }
    </style>
</head>

<body>
    <h1>Ejemplo tablas Html y Form</h1>
    <form action="#" method="POST">
        <p>
            <label for="filas">Introduzca nº de filas</label>
            <input type="number" name="filas" id="filas">
        </p>
        <p>
            <label for="columnas">Introduzca nº de columnas</label>
            <input type="number" name="columnas" id="columnas">
        </p>
        <input type="submit" value="Enviar" />
    </form>

    <?php
    if (isset($_POST["filas"]) && isset($_POST["columnas"])) {
        $filas = $_POST["filas"];
        $columnas = $_POST["columnas"];

        echo "<p>El numero de columnas es $columnas</p>";
        echo "<p>El numero de filas es $filas</p>";

        echo "<h3>Tabla sin array</h3>";
        echo mostrarTabla($filas, $columnas);

        $tabla = crearArray($filas, $columnas);
        /*         echo "<pre>";
        print_r($tabla);
        echo "</pre>"; */
        echo "<h3>Tabla desde el array creado</h3>";
        echo mostrarArrayEnTabla($tabla);
    }
    ?>
</body>

</html>