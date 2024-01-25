<?php
require_once 'util.php';

if (isset($_POST["crear-texto"], $_POST["input-texto"])) {
    //Añadimos sesion si hace falta y creamos el texto
    if (!isSessionActive()) {
        // Creamos la sesion
        iniciar_sesion();
        $_SESSION["textos"] = array();
    }
    array_push($_SESSION["textos"], $_POST["input-texto"]);

    // Equivalente -> $_SESSION["textos"][] = $_POST["input-texto"], pero habria que iniciar la sesion previamente
}

if (isset($_POST["cerrar-sesion"])) {
    cerrar_sesion();
    header("Location: actividad5.3.php");
    exit;
}
?>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>

<body class="mb-3">
    <h1 class="container mb-3 mt-5">
        Contenido de la sesión
    </h1>
    <div id="lista-palabras" class="container mb-3">
        <ul>
            <?php
            if (isSessionActive()) {
                echo "<ul>";
                foreach ($_SESSION["textos"] as $value) {
                    echo "<li>$value</li>";
                }
                echo "</ul>";
            }

            ?>
        </ul>
    </div>

    <div id="form-palabras" class="container mb-3">
        <form class="mb3" method="post">
            <div class="form-floating mb-3">
                <input type="text" name="input-texto" class="form-control" placeholder="Escribe aquí" />
                <label for="input-texto" class="form-label">Texto</label>
            </div>
            <button type="submit" name="crear-texto" class="btn btn-primary">Enviar</button>
        </form>
    </div>

    <div id="form-sesion" class="container">
        <?php
        if (isSessionActive()) {
        ?>
            <form method="post">
                <button type="submit" class="btn btn-secondary" name="cerrar-sesion">Cerrar Sesión</button>
            </form>
        <?php
        }
        ?>

    </div>

</body>

</html>