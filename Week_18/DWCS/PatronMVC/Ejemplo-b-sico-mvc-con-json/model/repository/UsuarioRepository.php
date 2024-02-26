<?php

final class UsuarioRepository implements IUsuarioRepository
{

    const RUTA_FICHERO = CONFIG_FOLDER . DIRECTORY_SEPARATOR . "usuarios.json";

    private $filePath;
    //Array de objetos de la clase Nota
    private $arrayUsuarios = [];

    public function __construct()
    {
        $this->filePath = dirname(__FILE__, 3) . DIRECTORY_SEPARATOR . self::RUTA_FICHERO;

        //Se lee el fichero .json como array asociativo
        $arrayAsoc = json_decode(file_get_contents($this->filePath), true);
        foreach ($arrayAsoc as $key => $value) {
            //Se tranforma el array asociativo 
            $nota = Util::json_decode_array_to_class($value, "Usuario");
            $this->arrayUsuarios[] = $nota;
        }
        // echo "## $this->filePath";
    }

    public function getUsuarios(): array
    {

        return $this->arrayUsuarios;
    }

    /* private function saveUsuarios(array $usuarios): bool
    {

        $writtenBytes = file_put_contents($this->filePath, json_encode($usuarios));

        return ($writtenBytes !== false);
    }

    public function getUsuarioById(int $id): ?Usuario
    {

        foreach ($this->arrayUsuarios as $key => $usuario) {
            if ($usuario->getId() === $id) {
                return $usuario;
            }
        }
        return null;
    }

    public function updateUsuario(Usuario $usuarioToUpdate): bool
    {

        $encontrado = false;

        foreach ($this->arrayUsuarios as $key => $usuario) {
            if ($usuario->getId() === $usuarioToUpdate->getId()) {
                $encontrado = true;
                $this->arrayUsuarios[$key]->setEmail($usuarioToUpdate->getEmail());
            }
        }

        if ($encontrado) {
            $encontrado = $encontrado && $this->saveUsuarios($this->arrayUsuarios);
        }
        return $encontrado;
    }

    public function deleteUsuario(int $id): bool
    {


        $clave = null;

        foreach ($this->arrayUsuarios as $key => $usuario) {
            if ($usuario->getId() === $id) {
                $clave = $key;

                break;
            }
        }
        unset($this->arrayUsuarios[$clave]);

        if ($clave !== null) {
            return $this->saveUsuarios($this->arrayUsuarios);
        } else {
            return false;
        }
    }

    public function create(Usuario $usuario): ?Usuario
    {

        $id = $this->getMaxId();
        $usuario->setId($id);

        array_push($this->arrayUsuarios, $usuario);
        if ($this->saveUsuarios($this->arrayUsuarios)) {

            return $usuario;
        } else {
            return null;
        }
    }

    private function getMaxId()
    {

        //$arrayNotas = array_values($this->arrayNotas);
        //Por cada objeto de clase Nota obtenemos su id y creamos un 
        //array con solo los ids
        $array_ids = array_map(
            function ($usuario) {
                return $usuario->getId();
            },
            $this->arrayUsuarios
        );

        if (count($array_ids) > 0) {
            $max_id = max($array_ids);
        } else {
            $max_id = 1;
        }

        return ++$max_id;
    } */
}
