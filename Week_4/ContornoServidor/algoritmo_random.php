<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<!-- Crea un script php que muestre en un documento HTML 5 que simula la tirada 
de un dado ayudándote de la función rand(). La tirada debe repetirse hasta 
que salga un 5. Cuenta el nº de tiradas que se necesitaron para obtener el 5
. Muestra el valor de cada tirada y  finalmente el nº de tiradas en el 
documento HTML5. -->

<body>
    <?php
    const MAX_DICE_SIDES = 6;
    const DESIRED_RESULT = 5;
    echo "<h1>Jugando a los dados hasta que salga 5 en un dado de " .
        MAX_DICE_SIDES . " caras</h1>";
    $numTiradas = 0;
    do {
        $numTiradas++;
        $dice = rand(1, MAX_DICE_SIDES);
        echo "<li>Tirada $numTiradas --> Resultado: $dice</li>";
    } while ($dice != DESIRED_RESULT);

    ?>
</body>

</html>