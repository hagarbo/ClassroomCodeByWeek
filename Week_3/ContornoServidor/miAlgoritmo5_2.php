<!-- 1- Crea un script php que muestre en un documento HTML 5, para una 
altura de cm dada, el número de pulgadas y de pies que le corresponda 
(Algoritmo 5.2 del documento adjunto)

(Como aún no hemos visto cómo leer los datos de un formulario, partid 
de un número dado en una variable, por ejemplo: $altura_cm= 105.4)  -->

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
        const RATIO_INCHES_CM = 2.54;
        const RATIO_FEET_INCHES = 12;
        $altura_cm = 172;
        $pulgadas = $altura_cm / RATIO_INCHES_CM;
        $pies = $pulgadas / RATIO_FEET_INCHES;

        echo "<h1>$altura_cm cm es igual a ".number_format($pulgadas,2).
                " pulgadas y ".number_format($pies,2)." pies</h1>";
    ?>
</body>
</html>