<?php
require_once __DIR__ . '/vendor/autoload.php';
require_once 'util.php';
$collection_name = "sample restaurants";




?>

<!doctype html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-
scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- css para usar Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

    <title>MongoDB - listado</title>
</head>

<body>
    <h3 class="text-center mt-2 font-weight-bold">Listado de libros</h3>
    <div class="container mt-3">
        <a href="crear.php" class='btn btn-success mt-2 mb-2'>Crear</a>

        <?php
        try {
            $collection = (new MongoDB\Client)->test->$collection_name;
            //De los restaurantes que cumplan con las 2 condiciones,
            //solo se seleccionan 3 columnas y el _id que si no se excluye también se aporta
            //Se limita el resultado a 4 documentos
            //Se ordenan descendentemente (-1) por name
            $cursor = $collection->find(
                [
                    'cuisine' => 'Italian',
                    'borough' => 'Manhattan',
                ],
                [
                    'projection' => [
                        'name' => 1,
                        'borough' => 1,
                        'cuisine' => 1
                    ],
                    'limit' => 4,
                    'sort' => ['name' => -1]
                ]
            );


            if ($cursor != null) {
        ?>
                <table class="table table-striped table-light">
                    <thead>
                        <tr class="text-center">
                            <th scope="col">ID</th>
                            <th scope="col">Name</th>
                            <th scope="col">Cuisine</th>
                            <th scope="col">Borough</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php

                        foreach ($cursor as $restaurant) {
                            echo "<tr class='text-center'>";
                            echo "<td>" . $restaurant->_id . "</td>";
                            echo "<td>" . $restaurant->name . "</td>";
                            echo "<td>" . $restaurant->cuisine . "</td>";
                            echo "<td>" . $restaurant->borough . "</td>";
                            echo "</tr>";
                        };


                        ?>
                    </tbody>
                </table>

        <?php
            } else {
                echo '<div class="alert alert-primary" role="alert">
            No se han encontrado libros
          </div>';
            }
            if (isset($_POST["id"], $_POST["borrar"])) {
                if ($libro_borrado) {
                    echo '<div class="alert alert-success" role="alert">    Libro con book_id: ' . $cod . ' borrado correctamente.</div>';
                } else {
                    echo '<div class="alert alert-danger" role="alert">   No se ha podido eliminar el libro con el book_id:' . $cod . '  </div>';
                }
            }
        } catch (Exception $ex) {
            //Captura también la Exception mysqli_sql_exception
            echo ' <div class="alert alert-danger m-5" role="alert">
            Error al recuperar los libros' . $ex->getMessage() . '
    </div>';
        }

        ?>
    </div>
</body>

</html>