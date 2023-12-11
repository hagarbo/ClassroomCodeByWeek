<?php

function find_book_by_id(int $book_id): array
{
    $conProyecto = getConnection();
    $stmt = $conProyecto->prepare("SELECT * FROM books WHERE book_id = ?");
    $stmt->execute([$book_id]);
    $resultado = $stmt->get_result();
    $array = $resultado->fetch_assoc();
    $resultado->close();
    return $array;
}

function find_authors_by_book(int $book_id): array
{
    $conProyecto = getConnection();
    $stmt = $conProyecto->prepare("SELECT * FROM authors a JOIN book_authors ba ON a.author_id = ba.author_id
                                                WHERE ba.book_id = ?");
    $stmt->execute([$book_id]);
    $resultado = $stmt->get_result();
    $array = $resultado->fetch_all(MYSQLI_ASSOC);
    $resultado->close();
    return $array;
}


/**
 * findAllPublishers
 * Crea una consulta con mysqli y obtiene todos los datos de la tabla publishers
 * @return array Array con todas las tuplas de la tabla publishers como array asociativo
 */
function findAllPublishers(): array
{
    $conProyecto = getConnection();

    $stmt = $conProyecto->prepare("SELECT * FROM publishers ORDER BY name");

    $stmt->execute();
    $resultado = $stmt->get_result();
    $array = $resultado->fetch_all(MYSQLI_ASSOC);
    $resultado->close();
    return $array;
}
/**
 * findAllAuthors
 * Crea una consulta con mysqli y obtiene todos los datos de la tabla authors con su nombre completo (concatenación de first, last y middle name)
 * @return array Array con todas las tuplas de la tabla authors como array asociativo
 */
function findAllAuthors(): array
/* APARTADO 2 */
{
    $conProyecto = getConnection();
    $query = "SELECT author_id, TRIM(Concat(coalesce(last_name, '') ,', ', coalesce(first_name, ''),' ', coalesce(middle_name, ''))) as author_name 
            FROM authors ORDER BY last_name";
    $resultado = $conProyecto->query($query);
    $array = $resultado->fetch_all(MYSQLI_ASSOC);
    $resultado->close();
    return $array;
}


//APARTADO NUMERO 5
/**
 * Summary of crear_libro
 * * Crea una transacción de inserción con PDO para crear una nueva tupla en la tabla books y las asociaciones oportunas con los autores(tuplas en la tabla book_authors)
 * @param array $book_data array asociativo con los datos de insercion del libro
 *          "title" => titulo del libro
 *          "isbn" => numero unico que identifica un libro, puede ser nulo
 *          "pdate" => fecha de publicacion en formato Y-m-d, puede ser nulo
 *          "publisher" => id de la editorial
 *          "authors" => array con los ids de los autores del libro, puede ser nulo
 * @throws \Exception
 * @return bool True si la transacción se realiza correctamente, false en caso contrario
 */
function update_libro(array $book_data, int $book_id, ?array $old_authors): bool
{
    try {
        $conProyecto = getConnection();
        $conProyecto->begin_transaction();
        //Insercion en books
        $stmt_ubook = $conProyecto->prepare("UPDATE books 
                                                SET 
                                                title = ?,
                                                isbn = ? ,
                                                published_date = ?,
                                                publisher_id = ? 
                                                 WHERE book_id = ?");
        //Parametros
        $stmt_ubook->bind_param("ssssi", $book_data["title"], $book_data["isbn"], $book_data["pdate"], $book_data["publisher"], $book_id);

        if (!$stmt_ubook->execute()) throw new Exception();

        if ($book_data["authors"] != null) {
            //Inserciones en bookauthors
            $stmt_u_book_authors = $conProyecto->prepare("INSERT INTO book_authors (book_id,author_id) 
                                    VALUES (?,?)");

            foreach ($book_data["authors"] as $author_id) {
                $stmt_u_book_authors->bind_param("ii", $book_id, $author_id);
                if (!$stmt_u_book_authors->execute()) throw new Exception();
            }
        }

        if ($old_authors != null) {
            //Borrados en bookauthors
            $stmt_u_book_authors = $conProyecto->prepare("DELETE FROM book_authors WHERE book_id = ? && author_id = ?");
            foreach ($old_authors as $author_id) {
                $stmt_u_book_authors->bind_param("ii", $book_id, $author_id);
                if (!$stmt_u_book_authors->execute()) throw new Exception();
            }
        }

        $conProyecto->commit();
    } catch (Exception $e) {
        $conProyecto->rollBack();
        echo "Ocurrio un error al intentar actualizar el libro, mensaje: " . $e->getMessage();
        return false;
    }

    return true;
}

//APARTADO NUMERO 3
/**
 * Summary of crear_libro
 * * Crea una transacción de inserción con PDO para crear una nueva tupla en la tabla books y las asociaciones oportunas con los autores(tuplas en la tabla book_authors)
 * @param array $data array asociativo con los datos de insercion del libro
 *          "title" => titulo del libro
 *          "isbn" => numero unico que identifica un libro, puede ser nulo
 *          "pdate" => fecha de publicacion en formato Y-m-d, puede ser nulo
 *          "publisher" => id de la editorial
 * @param array $authors array con los ids de los autores del libro, puede ser nulo
 * @throws \Exception
 * @return bool True si la transacción se realiza correctamente, false en caso contrario
 */
function crear_libro(array $book_data, array $authors): bool
{
    try {
        $conProyecto = getConnection();
        $conProyecto->begin_transaction();
        //Insercion en books
        $stmt_cbook = $conProyecto->prepare("INSERT INTO books (title,isbn,published_date,publisher_id) 
                                VALUES (?,?,?,?)");

        //Creamos el libro y recuperamos el id
        if ($stmt_cbook->execute($book_data)) $book_id = $conProyecto->insert_id;
        else throw new Exception();

        if ($authors != null) {
            //Inserciones en bookauthors
            $stmt_c_book_authors = $conProyecto->prepare("INSERT INTO book_authors (book_id,author_id) 
                                            VALUES (?,?)");
            foreach ($authors as $author_id) {
                if (!$stmt_c_book_authors->execute([$book_id, $author_id])) throw new Exception();
            }
        }

        $conProyecto->commit();
    } catch (Exception $e) {
        $conProyecto->rollBack();
        echo "Ocurrio un error al intentar crear el nuevo libro, mensaje: " . $e->getMessage();
        return false;
    }

    return true;
}

/**
 * obtener_libros_no_preparada
 * Consulta la tabla books para obtener los book_id y title ordenados por title
 * @return array array con tantos registros como tuplas haya y por cada registro un array con 2 claves: book_id y title 
 */
function obtener_libros_no_preparada(): array
{

    $libros_array = [];
    $resultado = null;
    try {
        //$conProyecto es de tipo mysqli
        $conProyecto = getConnection();
        $consulta = "select book_id, title from books order by title";
        $resultado = $conProyecto->query($consulta);

        while ($row = $resultado->fetch_assoc()) {
            array_push($libros_array, $row);
        }
        //otra opción en lugar de registro a registro
        //$libros_array = $resultado->fetch_all(MYSQLI_ASSOC);

    } catch (Exception $e) {
?>
        <div class="alert alert-danger" role="alert">
            <?php echo "Ha ocurrido una excepción: " . $e->getMessage(); ?>
        </div>
<?php
    } finally {
        if ($resultado != null) {
            $resultado->close();
        }
    }


    return $libros_array;
}
