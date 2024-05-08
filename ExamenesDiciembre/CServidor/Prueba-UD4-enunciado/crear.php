<!DOCTYPE html>
<html lang="es" data-bs-theme="dark">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>

    <title>Crear producto</title>
</head>

<body>
    <?php
    require_once 'db_functions.php';

    $category_list = get_category_list();

    $product_name = "";
    $price = 0;
    //array con  ids de las categorias
    $cat_ids = array();
    $exito = false;  
     
    if (isset($_POST["productName"])) {
        if (!empty($_POST["productName"])) {
            $product_name = $_POST["productName"];
        }
        if (isset($_POST["price"]) &&  !empty($_POST["price"])) {
            $price = $_POST["price"];
        }
        if (isset($_POST["cat_ids"])) {
            $cat_ids = $_POST["cat_ids"];
        }
        $p_data = [
            "name" => $product_name,
            "price" => $price
        ];
        $exito = insert_product($p_data, $cat_ids);
    }
   
    ?>
    <div class="container-fluid">
        <header class="mb-5">
            <div class="p-5 text-center " style="margin-top: 58px;">
                <h1 class="mb-3"> Crear producto </h1>

            </div>
        </header>
        <form class='form-control ' method="post">
            <div>
                <label for="productName" class="form-label col-3">Nombre producto</label>
                <input name="productName" type="text" class="form-control col-9" id="productName" pattern="^(?!\s*$).+" required />
            </div>
            <div>
                <label for="price" class="form-label col-3">Precio</label>
                <input name="price" type="number" step="0.01" class="form-control col-9" id="price" required />
            </div>
            <div class="form-group row my-3">
                <label for="categories" class="col-form-label col-2">Categorías</label>

                <div class="col-6">
                    <select name="cat_ids[]" id="categories" class="form-control" multiple required>

                        <option value="" disabled>----</option>
                        <?php
                        foreach ($category_list as $category) {
                            echo "<option value='" . $category["CategoryID"] . "'>" . $category["CategoryName"] . "</option>";
                        }
                        ?>
                       
                    </select>
                </div>


            </div>
            <div class="row d-flex justify-content-center">
                <button type="submit" class="btn btn-primary my-3 col-3">Crear producto</button>
            </div>

        </form>
      

        <?php if (($exito) && isset($_POST["productName"])) : ?>
            <div class="alert alert-success" role="alert">
                El producto se ha creado correctamente
            </div>

        <?php endif;
             ?>
    </div>
</body>

</html>