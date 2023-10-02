<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    
    <?php 
        echo "<h1>Mi primera tarea en PhP</h1>";
        echo "<br>";
        $var = "Esto es una variable de tipo cadena";
        echo "Vamos a mostrar el contenido de la variable dentro de varias etiquetas:";

        echo "<h2>$var</h2>";
        echo '<p>'.$var.'</p>';
        echo "<a href=#>$var</a>";
    ?>
</body>
</html>