<?php

require_once 'conexion.php';

/**
 * Summary of get_category_list
 * Busca en base de datos todas las categorias y devuelve un array con sus campos
 * @return array | null
 */
function get_category_list():array | null{
    try {
        $connection = getConnection();
        $stmt = $connection->prepare("SELECT * FROM categories ORDER BY CategoryName");
        $stmt->execute();
        $array = $stmt->fetchAll(PDO::FETCH_ASSOC);
    } catch (Exception $e) {
        echo "Error al consultar la base de datos: " . $e->getMessage();
        return null;
    }

    $connection = null;
    return $array;
}

/**
 * Summary of insert_product
 * Inserta un nuevo producto en la base de datos y crea referencias a la(s) categorias en la tabla intermedia products_categories
 * @param array $product_data - Array con los datos del producto: 
 *                              'name' => nombre del producto
 *                              'price' => precio del producto
 * @param array $category_ids - Array con los ids de las categorias asociadas al producto
 * @return bool - Devuelve true si se ha podido realizar la transaccion, false en caso de error
 */
function insert_product(array $product_data, array $category_ids):bool{
    try {
        $connection = getConnection();
        $connection->beginTransaction();

        //Insercion en producto
        $stmt = $connection->prepare("INSERT INTO products (ProductName,Price) 
                                    VALUES (?, ?)");
        $stmt->bindParam(1, $product_data["name"]);
        $stmt->bindParam(2, $product_data["price"]);
        
        if ($stmt->execute())
            $product_id = $connection->lastInsertId();
        else
            throw new Exception();
        echo"</br>";
        //Insertamos tabla intermedia 
        $stmt = $connection->prepare("INSERT INTO products_categories (ProductID,CategoryID) VALUES (:prod_id,:cat_id)");
        $stmt->bindParam("prod_id", $product_id);
        foreach ($category_ids as $value) {
            $stmt->bindParam("cat_id", $value);
            $stmt->execute();
            echo"</br>";
        }   
        $connection->commit();

    } catch (Exception $e) {
        $connection->rollBack();
        echo "Error al crear el producto: " . $e->getMessage();
        return false;
    }
    $connection = null;
    return true;
}

/**
 * Summary of get_product_by_id
 * Busca un producto en la base de datos con el id pasado como parametro y devuelve los datos de dicho producto en un array asociativo, si es que existe
 * @param int $id - El identificador del producto buscado
 * @return array|null - Un array asociativo con los datos el producto o null si no existiera u ocurriera algun error
 */
function get_product_by_id(int $id):array | null{
    try {
        $connection = getConnection();
        $stmt = $connection->prepare("SELECT * FROM dbproducts.products 
                                    WHERE ProductID = :product_id");
        $stmt->bindParam("product_id", $id);
        $stmt->execute();
        $array = $stmt->fetch(PDO::FETCH_ASSOC);
    } catch (Exception $e) {
        echo "Error al consultar la base de datos: " . $e->getMessage();
        return null;
    }

    $connection = null;
    return $array;
}

function update_product($product_data):bool{
    try {
        $connection = getConnection();
        $stmt = $connection->prepare("UPDATE products SET ProductName = :new_name, Price = :new_price 
                                    WHERE ProductID = :product_id");
        $stmt->bindParam("product_id", $product_data["id"]);
        $stmt->bindParam("new_name", $product_data["name"]);
        $stmt->bindParam("new_price", $product_data["price"]);
        $stmt->execute();
    } catch (Exception $e) {
        echo "Error al actializar la base de datos: " . $e->getMessage();
        return false;
    }

    $connection = null;
    return true;
}

?>