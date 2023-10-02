<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<!--        Inicio
            LEER n
            HACER suma=0
            Para i= 1, 3, 5, ..., 2*n-1
            HACER suma=suma+i
            Fin Para
            IMPRIMIR 'La suma vale : ', suma
            Fin -->

<body>
    <?php
    $n = 10;
    $suma = 0;

    for ($i = 0; $i < 2 * $n - 1; $i += 2) {
        $suma += 1;
    }
    echo "La suma vale: {$suma}";

    ?>

</body>

</html>