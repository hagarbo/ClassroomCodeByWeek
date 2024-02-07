<?php

class Baile
{
    public string $nombre = "";
    public int $edad_minima = 8;

    public function __construct(string $nombre, int $edad_minima = 8) {
        $this->nombre = $nombre;
        $this->edad_minima = $edad_minima;
    }

    public function info():string{
        return "<p>".$this->nombre . " (idade minima:" . $this->edad_minima . " anos)</p>";
    }

    public function equals(Baile $baile):bool{
        return $this->nombre == $baile->nombre;
    }
    
    public function __toString() {
        return $this->nombre;
      }
}
