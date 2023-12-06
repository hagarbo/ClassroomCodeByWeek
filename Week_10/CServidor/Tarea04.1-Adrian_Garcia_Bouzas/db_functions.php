<?php

function find_book_by_id(int $book_id): array
{
    $conProyecto = getConnection();
    $pdostmt = $conProyecto->prepare("SELECT * FROM books WHERE book_id = ?");
    $pdostmt->execute([$book_id]);
    $array = $pdostmt->fetch(PDO::FETCH_ASSOC);
    return $array;
}

function find_authors_by_book(int $book_id): array
{
    $conProyecto = getConnection();
    $pdostmt = $conProyecto->prepare("SELECT * FROM authors a JOIN book_authors ba ON a.author_id = ba.author_id
                                                WHERE ba.book_id = ?");
    $pdostmt->execute([$book_id]);
    $array = $pdostmt->fetchAll(PDO::FETCH_ASSOC);
    return $array;
}


/**
 * findAllPublishers
 * Crea una consulta con PDO y obtiene todos los datos de la tabla publishers
 * @return array Array con todas las tuplas de la tabla publishers como array asociativo
 */
function findAllPublishers(): array
{
    $conProyecto = getConnection();

    $pdostmt = $conProyecto->prepare("SELECT * FROM publishers ORDER BY name");

    $pdostmt->execute();
    $array = $pdostmt->fetchAll(PDO::FETCH_ASSOC);


    return $array;
}

// APARTADO NUMERO 2
/**
 * Summary of findAllAuthors
 * Crea una consulta con PDO y obtiene todos los datos de la tabla authors
 * @throws \Exception
 * @return array Array con todas las tuplas de la tabla authors como array asociativo 
 */
function findAllAuthors(): array
{
    try {
        $conProyecto = getConnection();
        $pdostmt = $conProyecto->prepare("SELECT author_id, TRIM(Concat(coalesce(last_name, '') ,', ', coalesce(first_name, ''),' ', coalesce(middle_name, ''))) as author_name 
                                FROM authors ORDER BY last_name");
        $pdostmt->execute();
        $array = $pdostmt->fetchAll(PDO::FETCH_ASSOC);
    } catch (Exception $e) {
        echo "Ocurrio un error al realizar la consulta :: findaAllAuthors, mensaje: " . $e->getMessage();
    }

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
        $conProyecto->beginTransaction();
        //Insercion en books
        $pdostmt_cbook = $conProyecto->prepare("UPDATE books 
                                                SET 
                                                title = :title,
                                                isbn = :isbn ,
                                                published_date = :pdate,
                                                publisher_id = :publisher 
                                                 WHERE book_id = :book_id");
        //Parametros
        $pdostmt_cbook->bindParam("title", $book_data["title"]);
        $pdostmt_cbook->bindParam("isbn", $book_data["isbn"]);
        $pdostmt_cbook->bindParam("pdate", $book_data["pdate"]);
        $pdostmt_cbook->bindParam("publisher", $book_data["publisher"]);
        $pdostmt_cbook->bindParam("book_id", $book_id);

        //Creamos el libro y recuperamos el id
        if (!$pdostmt_cbook->execute()) throw new Exception();

        if ($book_data["authors"] != null) {
            //Inserciones en bookauthors
            $pdostmt_c_book_authors = $conProyecto->prepare("INSERT INTO book_authors (book_id,author_id) 
                                    VALUES (:book_id,:author_id)");
            $pdostmt_c_book_authors->bindParam("book_id", $book_id);
            foreach ($book_data["authors"] as $author_id) {
                $pdostmt_c_book_authors->bindParam("author_id", $author_id);
                if (!$pdostmt_c_book_authors->execute()) throw new Exception();
            }
        }

        if ($old_authors != null) {
            //Borrados en bookauthors
            $pdostmt_c_book_authors = $conProyecto->prepare("DELETE FROM book_authors WHERE book_id = :book_id && author_id = :author_id");
            $pdostmt_c_book_authors->bindParam("book_id", $book_id);
            foreach ($old_authors as $author_id) {
                $pdostmt_c_book_authors->bindParam("author_id", $author_id);
                if (!$pdostmt_c_book_authors->execute()) throw new Exception();
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

//APARTADO NUMERO 5
/**
 * Summary of crear_libro
 * * Crea una transacción de inserción con PDO para crear una nueva tupla en la tabla books y las asociaciones oportunas con los autores(tuplas en la tabla book_authors)
 * @param array $data array asociativo con los datos de insercion del libro
 *          "title" => titulo del libro
 *          "isbn" => numero unico que identifica un libro, puede ser nulo
 *          "pdate" => fecha de publicacion en formato Y-m-d, puede ser nulo
 *          "publisher" => id de la editorial
 *          "authors" => array con los ids de los autores del libro, puede ser nulo
 * @throws \Exception
 * @return bool True si la transacción se realiza correctamente, false en caso contrario
 */
function crear_libro(array $data): bool
{
    try {
        $conProyecto = getConnection();
        $conProyecto->beginTransaction();
        //Insercion en books
        $pdostmt_cbook = $conProyecto->prepare("INSERT INTO books (title,isbn,published_date,publisher_id) 
                                VALUES (:title,:isbn,:pdate,:publisher)");
        //Parametros
        $pdostmt_cbook->bindParam("title", $data["title"]);
        $pdostmt_cbook->bindParam("isbn", $data["isbn"]);
        $pdostmt_cbook->bindParam("pdate", $data["pdate"]);
        $pdostmt_cbook->bindParam("publisher", $data["publisher"]);

        //Creamos el libro y recuperamos el id
        if ($pdostmt_cbook->execute()) $book_id = $conProyecto->lastInsertId();
        else throw new Exception();

        if ($data["authors"] != null) {
            //Inserciones en bookauthors
            $pdostmt_c_book_authors = $conProyecto->prepare("INSERT INTO book_authors (book_id,author_id) 
                                            VALUES (:book_id,:author_id)");
            $pdostmt_c_book_authors->bindParam("book_id", $book_id);
            foreach ($data["authors"] as $author_id) {
                $pdostmt_c_book_authors->bindParam("author_id", $author_id);
                if (!$pdostmt_c_book_authors->execute()) throw new Exception();
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
 * obtener_libros
 * Consulta la tabla books para obtener los book_id y title ordenados por title
 * @return array array con tantos registros como tuplas haya y por cada registro un array con 2 claves: book_id y title 
 */
function obtener_libros(): array
{

    $libros_array = null;
    try {
        $conProyecto = getConnection();
        $consulta = "select book_id, title from books order by title";
        $stmt = $conProyecto->prepare($consulta);

        $stmt->execute();
        $libros_array = $stmt->fetchAll(PDO::FETCH_ASSOC);
    } catch (PDOException $ex) {
        die("Error al recuperar los libros " . $ex->getMessage());
    }


    return $libros_array;
}
