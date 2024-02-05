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
            if ($value->equals($baile))
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

    public function borrarBaile(string $nome_baile):bool{
        foreach ($this->bailes as $key => $baile) {
            if ($baile->nombre === $nome_baile){
                unset($this->bailes[$key]);
                return true;
            }
        }
        return false;
    }

    public function mostrarBailes():string{
        $result = "";
        foreach ($this->bailes as $baile) {
            $result .= $baile->info();
        }
        return $result;
    }
}
