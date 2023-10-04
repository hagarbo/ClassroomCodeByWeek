<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <?php
    /* 1. Crea un script con un array con índices numéricos que contenga el 
        número de horas extra que ha trabajado una persona durante la última 
        semana. Calcula su salario extra sabiendo que la hora extra se paga 
        a 12.5€ */
    const PRECIO_HORA = 12.5;
    $horasExtraSemana = [3.5, 4, 0, 0, 0, 2, 7];
    $salario = 0;
    foreach ($horasExtraSemana as $valor) {
        $salario += $valor * PRECIO_HORA;
        echo "<p>Realizando $valor * 12.5, suma = $salario € </p>";
    }
    echo "<h4>El salario a percibir es $salario €</h4>";

    /* 2. Crea un script con un array asociativo (con índices de cadena de 
    texto) con los 5 valores del IBEX que más han subido hoy junto con sus 
    subidas porcentuales. Recorre el array mostrando las claves y sus valores 
    y finalmente, la media de las subidas. */

    $subidasIBEX = [
        "IAG" => 3.73,
        "Iberdrola" => 1.19,
        "Endesa" => 0.65,
        "Solaria" => 0.44,
        "ENAGAS" => 0.39,
    ];

    print "<ol>";
    $sumaSubidas = 0;
    foreach ($subidasIBEX as $clave => $valor) {
        echo "<li>$clave => $valor%</li>";
        $sumaSubidas += $valor;
    }
    print "</ol>";
    echo "<h3>La media de subidas es " . array_sum($subidasIBEX) / sizeof($subidasIBEX) . "%</h3>";

    /* 3. Dado un número entero positivo o negativo, crea un script que cree un
     array que contenga tantos números enteros desde el cero hasta el número
     dado incluido. Por ejemplo: para un número n = 3, el array deberá contener 
     [0, 1, 2, 3]. Si se introduce -3, el array deberá contener [-3, -2, -1, 0] */

    const NUMERO_POSITIVO_NEGATIVO = -7;

    if (NUMERO_POSITIVO_NEGATIVO > 0) $arrayBuscado = range(0, NUMERO_POSITIVO_NEGATIVO);
    else $arrayBuscado = range(NUMERO_POSITIVO_NEGATIVO, 0);
    echo "<pre>";
    print_r($arrayBuscado);
    echo "</pre>";



    /* 4. Dado un número entero positivo del 1 al 10, crea un script que cree un 
     array asociativo con la tabla de multiplicar del número dado. Por ejemplo, 
     si se introduce el 2, el array estará formado por "2x0" => 0, "2x1" => 1, 
     "2x2" =>2, etc. Las claves son cadenas de texto y los valores el resultado. 
     Muestra el array resultado. */

    const NUMERO_ELEGIDO = 5;
    const LIMITE_TABLA = 10;

    for ($i = 0; $i <= LIMITE_TABLA; $i++) {
        $tablaMultiplicar[NUMERO_ELEGIDO . "x$i"] = $i * NUMERO_ELEGIDO;
    }
    echo "<pre>";
    print_r($tablaMultiplicar);
    echo "</pre>";

    ?>

</body>

</html>