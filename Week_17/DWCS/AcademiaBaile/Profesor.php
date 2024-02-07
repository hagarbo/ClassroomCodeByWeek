<?php
require_once "Baile.php";
class Profesor extends Persona
{
    public const IMPORTE_HORA_POR_DEFECTO = 16;
    private string $nif = "";
    private array $bailes = [];

    public function __construct(string $nombre, string $apellidos, string $telefono, string $nif) {
        parent::__construct($nombre, $apellidos, $telefono);
        $this->nif = $nif;
    }

    public function calcularSoldo(int $horas, int $precio_hora = self::IMPORTE_HORA_POR_DEFECTO):int{
        return $horas * $precio_hora;
    }

    private function existeBaile(Baile $baile):bool{
        $existe = array_filter($this->bailes,array($baile, 'equals'));
        return count($existe) != 0;
    }
    public function engadirBaile(Baile $baile):bool{
        if ($this->existeBaile($baile))
            return false;
        array_push($this->bailes,$baile);
        return true;
    }

    public function borrarBaile(Baile $baile_borrar):bool{
        if (!$this->existeBaile($baile_borrar))
            return false;
        $this->bailes = array_diff($this->bailes, array($baile_borrar));
        return true;
    }

    public function mostrarBailes():string{
        $result = "";
        foreach ($this->bailes as $baile) {
            $result .= $baile->info();
        }
        return $result;
    }
}
