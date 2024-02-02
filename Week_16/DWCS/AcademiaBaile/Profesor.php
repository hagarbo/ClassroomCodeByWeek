<?php
require_once "Baile.php";
class Profesor extends Persona
{
    private string $nif = "";
    private array $bailes = [];

    public function __construct(string $nombre, string $apellidos, string $telefono, string $nif) {
        parent::__construct($nombre, $apellidos, $telefono);
        $this->nif = $nif;
    }

    public function calcularSoldo(int $horas, int $precio_hora = 16):int{
        return $horas * $precio_hora;
    }

    private function existeBaile(Baile $baile):bool{
        foreach ($this->bailes as $value) {
            if ($value->nombre === $baile->nombre)
                return true;
        }
        return false;
    }
    public function engadirBaile(Baile $baile):bool{
        if ($this->existeBaile($baile))
            return false;
        array_push($this->bailes,$baile);
        return true;
    }


}
