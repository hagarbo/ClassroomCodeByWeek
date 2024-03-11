<?php


/**
 * Description of UsuarioRepository
 *
 * @author wadmin
 */
class ProductoRepository extends BaseRepository implements IProductoRepository
{


    public function __construct()
    {
        parent::__construct();
        $this->table_name = "productos";
        $this->pk_name = "id";
        $this->class_name = "Producto";
        $this->default_order_column = "nombre";

    }

    //TO DO
    public function create($object)
    {
        
    }
    public function update($object): bool
    {
        return false;
    }




}
