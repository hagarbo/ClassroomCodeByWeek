<?php
const NOTAS_SEPARATOR = '/\//';
const PESOS_SEPARATOR = '/\%/';
const MAX_PORCENTAJE = 100;
const MIN_PORCENTAJE = 5;
const NOTA_MINIMA = 0;
const NOTA_MAXIMA = 10;

function sumanCien(array $porcentajes): bool
{
    $suma = 0;
    foreach ($porcentajes as $value) {
        $suma += $value;
    }
    if ($suma == 100) return true;
    else return false;
}

function sameSize(array $a, array $b): bool
{
    return (sizeof($a) == sizeof($b));
}

function notasValidas(array $array): bool
{
    foreach ($array as $value) {
        if (!is_numeric($value)) return false;
        if ($value < NOTA_MINIMA || $value > NOTA_MAXIMA) return false;
    }
    return true;
}

function pesosValidos(array $array): bool
{
    foreach ($array as $value) {
        if (!is_numeric($value)) return false;
        if ($value < MIN_PORCENTAJE || $value > MAX_PORCENTAJE) return false;
    }
    return true;
}

function validar(array $notas, array $pesos): string|true
{
    if (!sameSize($notas, $pesos))
        return "<p id='message'>ERROR:Debe haber el mismo numero de calificaciones y pesos</p>";
    if (!notasValidas(($notas)))
        return "<p id='message'>ERROR:Los datos del campo calificaciones no son válidos</p>";
    if (!pesosValidos($pesos))
        return "<p id='message'>ERROR:Los datos del campo pesos no son válidos</p>";
    if (!sumanCien($pesos))
        return "<p id='message'>ERROR:La suma de los pesos no es 100</p>";
    return true;
}

function calculaNotaMedia($notas, $pesos): float
{
    $suma = 0;
    for ($i = 0; $i < sizeof($notas); $i++) {
        $suma += $notas[$i] * $pesos[$i];
    }
    return $suma / MAX_PORCENTAJE;
}

?>

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
    if (isset($_POST["calificaciones"]) && isset($_POST["pesos"])) {

        $notas = preg_split(NOTAS_SEPARATOR, $_POST["calificaciones"]);
        $pesos = preg_split(PESOS_SEPARATOR, $_POST["pesos"]);

        $validacion = validar($notas, $pesos);
        if ($validacion === true) {
            $media = calculaNotaMedia($notas, $pesos);
            echo "<p id='message'>La nota media es: $media</p>";
        } else {
            echo $validacion;
        }
    }
    ?>

</body>

</html>