<?php


    if (isset($_COOKIE["array"])){
    echo "<pre>";
    print_r($_COOKIE);
    echo "</pre>";
    }
    else {
    setcookie("array['cero']", "Hola, soy una galleta");
    setcookie("array['uno']", "Hola, soy una galleta");
    setcookie("array['dos']", "Hola, soy una galleta");
    setcookie("array['tres']", "Hola, soy una galleta");
    header('Location: cookie_sample.php');
    }

?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    
</body>
</html>

