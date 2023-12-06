<!DOCTYPE html>
<html lang="es" data-bs-theme="dark">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>

    <title>Crear libro</title>
</head>

<body>
    <?php
    require_once 'conexion.php';
    require_once 'util.php';
    require_once 'db_functions.php';

    if (isset($_GET["book_id"])) {
        $book_id = $_GET["book_id"];
        $publishers = findAllPublishers();
        $authors = findAllAuthors();
        $exito = false;
    }

    if (isset($_POST["title"])) {
        $book_authors = find_authors_by_book($book_id);
        if (isNotEmpty($_POST["title"])) {
            $title = $_POST["title"];
        }

        if (isset($_POST["isbn"]) &&  isNotEmpty($_POST["isbn"])) {
            $isbn = $_POST["isbn"];
        }

        if (isset($_POST["pdate"]) &&  isNotEmpty($_POST["pdate"])) {
            $pdate = $_POST["pdate"];
            $pdate_converted = DateTimeImmutable::createFromFormat("Y-m-d", $pdate);
            if ($pdate_converted !== false) {
                $pdate = $pdate_converted->format("Y-m-d");
            }
        }

        if (isset($_POST["publisher"]) &&  isNotEmpty($_POST["publisher"])) {
            $pub_Id = $_POST["publisher"];
        }
        $deleted_authors = array();
        if (isset($_POST["author_ids"])) {
            $book_author_ids = (count($_POST["author_ids"]) == 1 && $_POST["author_ids"][0] == "") ? null : $_POST["author_ids"];
            $new_authors_ids = array();
            //Si el autor era uno ya existente no lo añadimos en el update
            foreach ($book_author_ids as $id) {
                if (!is_author($id, $book_authors)) array_push($new_authors_ids, $id);
            }
            //Autores que hay que borrar
            foreach ($book_authors as $key => $value) {
                if (!in_array($value["author_id"], $book_author_ids)) array_push($deleted_authors, $value["author_id"]);
            }
        } else {
            //Si se eliminan todos los autores los tenemos que borrar 
            foreach ($book_authors as $key => $value) {
                array_push($deleted_authors, $value["author_id"]);
            }
        }
        $data = [
            "title" => $title,
            "isbn" => $isbn,
            "pdate" => $pdate,
            "publisher" => $pub_Id,
            "authors" => $new_authors_ids
        ];
        $exito = update_libro($data, $book_id, $deleted_authors);
    }

    if (isset($book_id)) :
        $book = find_book_by_id($book_id);
        $book_authors = find_authors_by_book($book_id);
    ?>
        <div class="container-fluid">
            <header class="mb-5">
                <div class="p-5 text-center " style="margin-top: 58px;">
                    <h1 class="mb-3"> Actualizar libro </h1>

                </div>
            </header>
            <form class='form-control ' method="post">
                <div>
                    <label for="title" class="form-label col-3">Título</label>
                    <input name="title" type="text" class="form-control col-9" id="title" pattern="^(?!\s*$).+" required value="<?= $book["title"] ?>" />
                </div>
                <div>
                    <label for="isbn" class="form-label col-3">ISBN</label>
                    <input name="isbn" type="text" class="form-control col-9" id="isbn" pattern="^(?!\s*$).+" value="<?= $book["isbn"] ?>" />
                </div>

                <div>
                    <label for="pdate" class="form-label col-3">Fecha de publicación</label>
                    <input name="pdate" type="date" class="form-control col-9" id="pdate" value="<?= $book["published_date"] ?>" />
                </div>

                <div class='row form-group my-3'>
                    <label for="publisher" class="col-form-label col-2">Editorial</label>
                    <div class='col-6'>
                        <select name="publisher" id="publisher" autocomplete="off" class="form-control col-3" required>

                            <option value="" disabled>----</option>
                            <?php
                            // Autocomplete off en el select para que funcione el selected, cosas de firefox
                            if (count($publishers) > 0) :
                                foreach ($publishers as $publisher) :
                                    if ($book["publisher_id"] == $publisher["publisher_id"]) :
                            ?>
                                        <option value="<?= $publisher["publisher_id"] ?>" selected><?= $publisher["name"] ?>
                                        </option>
                                    <?php
                                    else :
                                    ?>
                                        <option value="<?= $publisher["publisher_id"] ?>"><?= $publisher["name"] ?>
                                        </option>
                            <?php
                                    endif;
                                endforeach;
                            endif;
                            ?>


                        </select>
                    </div>
                </div>

                <div class="form-group row my-3">
                    <label for="authors" class="col-form-label col-2">Autor</label>

                    <div class="col-6">
                        <select name="author_ids[]" id="authors" autocomplete="off" class="form-control" multiple>

                            <option value="">----</option>

                            <?php
                            // APARTADO NUMERO 4
                            if (count($authors) > 0) :
                                foreach ($authors as $author) :
                                    if (is_author($author["author_id"], $book_authors)) :
                            ?>
                                        <option value="<?= $author["author_id"] ?>" selected><?= $author["author_name"] ?>
                                        </option>
                                    <?php
                                    else :
                                    ?>
                                        <option value="<?= $author["author_id"] ?>"><?= $author["author_name"] ?>
                                        </option>
                            <?php
                                    endif;
                                endforeach;
                            endif;
                            ?>
                        </select>
                    </div>


                </div>
                <div class="row d-flex justify-content-center">
                    <button type="submit" class="btn btn-primary my-3 col-3">Actualizar Datos</button>
                </div>

            </form>
            <a href="listado.php" class="btn btn-link mt-2">Volver</a>

            <?php if (($exito) && isset($_POST["title"])) : ?>
                <div class="alert alert-success" role="alert">
                    El libro se ha creado correctamente
                </div>

        <?php endif;
        else :
            header("Location: listado.php");
            die();
        endif;

        function is_author(int $author_id, array $authors): bool
        {
            foreach ($authors as $key => $value) {
                if ($value["author_id"] == $author_id) return true;
            }
            return false;
        }
        ?>


        </div>
</body>

</html>