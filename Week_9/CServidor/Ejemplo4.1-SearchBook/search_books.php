<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Búsqueda</title>
</head>

<body>
    <h1>Búsqueda de libros</h1>

    <form method="GET">
        <label for="busqueda">Introduzca los términos de búsqueda: </label>
        <input type="search" name="busqueda" id="busqueda" required>
        <button type="submit">Buscar</button>
    </form>
</body>

</html>
<?php
if (isset($_GET["busqueda"])) {
    $terminos_busqueda = $_GET["busqueda"];
    if (trim($terminos_busqueda) !== "") {

        require_once "MyPDO.php";

        try {
            $con = new MyPDO();

            //En la bd bookdb no importan mayúsculas/minúsculas porque está usando collation caseinsensitive, pero no está demás que nuestro código no dependa de la collation de la base de datos
            /*  $stmt = $con->prepare("select title from books where UPPER(title) like ? ");
            $stmt->bindValue(1, "%" . strtoupper($terminos_busqueda) . "%"); */

            // a) Utilice parámetros nominales en lugar de parámetros posicionales
            // b) Utilice bindParam en lugar de bindValue
            $stmt = $con->prepare("select title from books where UPPER(title) like :filtro ");
            $filtro = "%" . strtoupper($terminos_busqueda) . "%";
            $stmt->bindParam("filtro", $filtro);

            $stmt->execute();

            // echo "<pre>";
            // $stmt->debugDumpParams();
            // echo "</pre>";

            // c) Recupere los datos a través de nombres de las columnas y no con 
            // índices numéricos
            //$array = $stmt->fetchAll(PDO::FETCH_NUM);
            $array = $stmt->fetchAll(PDO::FETCH_ASSOC);
            echo "<h4>Resultados en un array</h4>";
            if (($array !== false)) {
                if (!empty($array)) {

                    echo "<ol>";
                    foreach ($array as $fila_array) {
                        // un único valor: el title
                        echo "<li>" . $fila_array["title"] . "</li>";
                    }
                    echo "</ol>";
                } else {
                    echo "<p>No se han encontrado resultados</p>";
                }
            }
            // d) Obtenga fila a fila del conjunto de resultados en lugar 
            // de todas las filas en un único array
            $stmt->execute();
            echo "<h4>Resultados linea a linea</h4>";
            if ($stmt->rowCount() > 0) {
                echo "<ol>";
                while (($fila = $stmt->fetch(PDO::FETCH_ASSOC)) !== false) {
                    echo "<li>" . $fila["title"] . "</li>";
                }
                echo "</ol>";
            } else {
                echo "<p>No se han encontrado resultados</p>";
            }

            // e) Busque el término de búsqueda también en la columna first_name 
            // de la tabla authors
            /* CONSULTA con UNION: 
                select author_id as id, first_name as name,middle_name,last_name 
                from authors 
                union 
                select book_id as id, title as name,null as middle_name, null as last_name 
                from books;*/
            $query = "SELECT author_id, null as book_id,
                             first_name as name,middle_name,last_name 
                    FROM authors WHERE first_name LIKE :filtro 
                    UNION 
                    SELECT null as author_id, book_id,
                            title as name,null as middle_name, null as last_name 
                    FROM books WHERE title LIKE :filtro ";
            $stmt = $con->prepare($query);
            $stmt->bindParam("filtro", $filtro);
            $stmt->execute();
            $array = $stmt->fetchAll(PDO::FETCH_ASSOC);
            echo "<h4>Busqueda en autores y libros</h4>";
            if (($array !== false)) {
                if (!empty($array)) {
                    echo "<ol>";
                    foreach ($array as $fila_array) {
                        $elemento = "<li>";
                        if (is_null($fila_array["author_id"])) { //libro
                            $elemento .= "Libro: " . $fila_array["name"];
                        } else { //autor
                            $elemento .= "Autor: " . $fila_array["name"] . " "
                                . ((is_null($fila_array["middle_name"])) ? "" : $fila_array["middle_name"] . " ")
                                . ((is_null($fila_array["last_name"])) ? "" : $fila_array["last_name"]);
                        }
                        $elemento .= "</li>";
                        echo $elemento;
                    }
                    echo "</ol>";
                } else {
                    echo "<p>No se han encontrado resultados</p>";
                }
            }
        } catch (Exception $e) {
            echo "<p>Ha ocurrido una excepción: " . $e->getMessage() . "</p>";
        }
        //Cerramos los recursos
        $con = null;
        $stmt = null;
    } else {
        echo "<p> Introduzca una cadena no vacía </p>";
    }
}

?>