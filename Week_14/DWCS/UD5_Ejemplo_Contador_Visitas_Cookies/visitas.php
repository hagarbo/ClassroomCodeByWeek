<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Visits counter</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>

<body class="container mt-3 mb3">
    <h1>Visits counter</h1>

    <?php

    if (isset($_POST["deleteCookie"])){
        setcookie("visitas", "", time() - 3600);
        unset($_COOKIE["visitas"]);
    }

    if (isset($_COOKIE["visitas"])) {
        /* if (isset($_POST["deleteCookie"])) {
            setcookie("visitas", "", time() - 3600);
            header('Location: visitas.php');
        }
        else{ */
            $visitas = $_COOKIE["visitas"];
            setcookie("visitas", ++$visitas, time() + 3600);
            //El nuevo valor no estará disponible en $_COOKIE hasta la próxima petición HTTP 
            //Por ese motivo no podemos usar $_COOKIE["visitas] para mostrar su valor
            ?>

            <p>Nos ha visitado <?= $visitas ?> veces</p>
        <?php  //}
        }
    else {
        setcookie("visitas", 1, time() + 3600);
    ?>
        <p>Bienvenido</p>
    <?php
    }
    ?>
    <form method="post">
        <input hidden name="deleteCookie" value="0"/>
        <button type="submit" class="btn btn-primary">Borrar Cookie</button>
    </form>
</body>

</html>