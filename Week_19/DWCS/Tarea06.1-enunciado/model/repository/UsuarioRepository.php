<?php

class UsuarioRepository extends BaseRepository implements IUsuarioRepository{

    public function __construct(){
        parent::__construct();
        $this->table_name = "usuario";
        $this->pk_name = "id";
        $this->class_name = "Usuario";
        $this->default_order_column = "email";
    }

    public function create($object){
        // TO DO
        return null;
    }

    public function update($object):bool{
        // TO DO
        return false;
    }

    public function findUsuarioByEmail($email):?Usuario{
        $pdostmt = $this->conn->prepare("SELECT * FROM $this->table_name "
            . "WHERE email = :email");
        $pdostmt->bindValue("email", $email);
        $pdostmt->execute();

        $object = $pdostmt->fetchObject($this->class_name);
        return ($object===false)? null : $object;
    }

}