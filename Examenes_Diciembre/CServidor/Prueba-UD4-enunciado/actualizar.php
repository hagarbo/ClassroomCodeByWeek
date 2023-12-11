<!DOCTYPE html>
<html lang="es" data-bs-theme="dark">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>

    <title>Actualizar producto</title>
</head>

<body>
    <?php
    require_once 'db_functions.php';

    $product_name = "";
    $price = 0;
    $exito = false;
    $producto = array();


    if (isset($_GET["prod_id"])) {
        $prod_id = $_GET["prod_id"];
        $product = get_product_by_id($prod_id);
        if ($product!=null){
            $product_name = $product["ProductName"];
            $price = $product["Price"];
        }

        ?>

            <div class="container-fluid">
                <header class="mb-5">
                    <div class="p-5 text-center " style="margin-top: 58px;">
                        <h1 class="mb-3"> Actualizar producto </h1>

                    </div>
                </header>
                <form class='form-control ' method="post">
                    <div>
                        <label for="productName" class="form-label col-3">Nombre producto</label>
                          <!-- Sustituye el atributo value por el recuperado de BD -->
                        <input name="productName" type="text" class="form-control col-9" id="productName" pattern="^(?!\s*$).+" value="<?php echo $product_name;?>" required />
                    </div>
                    <div>
                        <label for="price" class="form-label col-3">Precio</label>
                        <!-- Sustituye el atributo value por el recuperado de BD -->
                        <input name="price" type="number" step="0.01" class="form-control col-9" id="price" required value="<?php echo $price;?>" />
                    </div>
                    

                    <div class="row d-flex justify-content-center">
                        <button type="submit" class="btn btn-primary my-3 col-3">Actualizar producto</button>
                    </div>

                </form>
            </div>
    <?php
    } else {
        echo "<div class=\"alert alert-info\" role=\"alert\">
           Añade el parámetro prod_id a la URL. Por ejemplo:
           http://localhost:3000/actualizar.php?prod_id=1 </div>";
    }
    ?>
    <?php

    if (isset($_POST["productName"])) {
        if (!empty($_POST["productName"])) {
            $product_name = $_POST["productName"];
        }
        if (isset($_POST["price"]) &&  !empty($_POST["price"])) {
            $price = $_POST["price"];
        }
        if (isset($_POST["prod_id"]) && !empty($_POST["prod_id"])) {
            $prod_id = $_POST["prod_id"];
        }

        $p_data = [
            "id" => $prod_id,
            "name" => $product_name,
            "price" => $price
        ];

        $exito = update_product($p_data);
      
        if ($exito) : ?>
            <div class="alert alert-success" role="alert">
                El producto se ha actualizado correctamente
            </div>
        <?php else : ?>
            <div class="alert alert-danger" role="alert">
                Ha ocurrido algún error y no ha podido actualizarse el producto
            </div>
    <?php
        endif;
    }




  


    ?>



</body>

</html>