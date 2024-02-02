<?php

class Baile
{
    private string $nombre = "";
    private int $edad_minima = 8;

    public function __construct(string $nombre, int $edad_minima = 8) {
        $this->nombre = $nombre;
        $this->edad_minima = $edad_minima;
    }
}
