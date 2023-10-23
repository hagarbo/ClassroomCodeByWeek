<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        table,
        td,
        th {
            border: 1px solid black;
            border-collapse: collapse;
            text-align: center;
        }
    </style>
</head>

<body>
    <h1>Ejemplo tablas Html y Form</h1>
    <form action="#" method="POST">
        <p>
            <label for="filas">Introduzca nº de filas</label>
            <input type="number" name="filas" id="filas">
        </p>
        <p>
            <label for="columnas">Introduzca nº de columnas</label>
            <input type="number" name="columnas" id="columnas">
        </p>
        <input type="submit" value="Enviar" />
    </form>

    <?php
    if (isset($_POST["filas"]) && isset($_POST["columnas"])) {
        require_once "utilities" . DIRECTORY_SEPARATOR . "funciones.php";

        $filas = $_POST["filas"];
        $columnas = $_POST["columnas"];

        echo "<p>El numero de columnas es $columnas</p>";
        echo "<p>El numero de filas es $filas</p>";

        echo "<h3>Tabla sin array</h3>";
        echo mostrarTabla($filas, $columnas);

        $tabla = crearArray($filas, $columnas);
        echo "<pre>";
        print_r($tabla);
        echo "</pre>";

        echo "<h3>Tabla después de crear el array</h3>";
        echo mostrarArrayEnTabla($tabla);
    }
    ?>
</body>

</html>