<?php

class ProductoServicio
{

    const RUTA_FICHEROS_CONST = DIRECTORY_SEPARATOR . IMAGES_FOLDER . DIRECTORY_SEPARATOR;
    const SEPARADOR_NOMBRE_FICHERO = "_";

    private IProductoRepository $repository;

    public function __construct()
    {
        $this->repository = new ProductoRepository();
    }

    /* Get all notes */

    public function list(): array
    {

        $productos = $this->repository->findAll();

        return $productos;
    }

    public function deleteProduct(int $id):bool{
        return $this->repository->delete($id);
    }

}