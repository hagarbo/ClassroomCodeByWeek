<!-- 2- Crea un script php que muestre en un documento HTML 5, para un 
valor x dado,la salida de f(x) del algoritmo 5.3 del documento de ejemplo.
 -->
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php

        $x = -1;
        $f = 0;

        if ($x > 0){
            $f = $x**2;
        }

        echo "<h1>El valor de la funcion es: $f</h1>";
    ?>
    
</body>
</html>