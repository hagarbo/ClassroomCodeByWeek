<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<!--    
        Inicio
        LEER n
        HACER suma=1
        HACER ter=1
        Para k= 1, 2, ..., n
        HACER ter=ter/2
        HACER suma=suma+ter
        Fin Para
        IMPRIMIR 'La suma vale : ', suma
        Fin
-->

<body>
    <?php
    //echo "Ingresa un numero: ";
    //fscanf(STDIN, "%d", $n); // PARA LEER DE TECLADO POR TERMINAL

    $n = 5;
    $suma = 1;
    $ter = 1;
    for ($k = 1; $k <= $n; $k++) {
        $ter = $ter / 2;
        $suma += $ter;
    }
    echo "<p>La suma con bucle FOR vale : $suma</p>";
    //Con bucle while
    const VALOR_MIN = 2;
    $suma = 1;
    $ter = 1;
    $k = 1;
    while ($k++ <= $n && $suma < VALOR_MIN) { //++ primero se evalua y luego se incrementa
        $ter = $ter / 2;
        $suma += $ter;
    }

    echo "<p>La suma con bucle WHILE vale : $suma</p>";
    ?>

</body>

</html>