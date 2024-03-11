<?php

class ProductoController
{

    const VIEW_FOLDER = "producto";

    public $page_title;
    public $view;
    private ProductoServicio $productoServicio;


    public function __construct()
    {
        $this->view = self::VIEW_FOLDER . DIRECTORY_SEPARATOR . 'list_producto';
        $this->page_title = '';
        $this->productoServicio = new ProductoServicio();

    }

    /* List all notes */

    public function list()
    {
        $this->view = self::VIEW_FOLDER . DIRECTORY_SEPARATOR . 'list_producto';
        $this->page_title = 'Listado de productos';
        return $this->productoServicio->list();
    }

    public function delete(){
        if (isset($_POST["id"])){
            SessionManager::iniciarSesion();
            $id = $_POST["id"];
            //$id = -1; // PARA PROBAR EL ERROR
            if ($this->productoServicio->deleteProduct($id))
                $_SESSION["error"] = false;
            else $_SESSION["error"] = true;
        }
        header("Location: FrontController.php?controller=Producto&action=list");
        exit;
    }
}