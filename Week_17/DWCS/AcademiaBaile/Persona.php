<?php
class Persona{
    private string $nombre = "";
    private string $apellidos = "";
    private string $telefono = "";

    public function __construct(string $nombre, string $apellidos, string $telefono) {
        $this->nombre = $nombre;
        $this->apellidos = $apellidos;
        $this->telefono = $telefono;
    }

    public function verInformacion():string
    {
        return $this->nombre." ".$this->apellidos." (".$this->telefono.")";
    }
}
