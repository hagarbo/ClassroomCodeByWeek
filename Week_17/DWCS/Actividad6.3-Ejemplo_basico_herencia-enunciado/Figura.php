<?php
class Figura
{
    protected int $num_lados;
    protected string $nombre;

    public function calcularArea()
    {
        echo "<p> Calculando el área de $this->nombre ...</p>";
    }

    public function __construct(string $nombre, int $num_lados = 0)
    {
        $this->nombre = $nombre;
        $this->num_lados = $num_lados;
    }

    public function verInformacion(){
        echo "<p> Nombre: $this->nombre, Lados: $this->num_lados</p>";
    }

    

    /**
     * Get the value of num_lados
     */ 
    public function getNum_lados()
    {
        return $this->num_lados;
    }

    /**
     * Set the value of num_lados
     *
     * @return  self
     */ 
    public function setNum_lados(int $num_lados)
    {
        $this->num_lados = $num_lados;

        return $this;
    }

    /**
     * Get the value of nombre
     */ 
    public function getNombre()
    {
        return $this->nombre;
    }

    /**
     * Set the value of nombre
     *
     * @return  self
     */ 
    public function setNombre(string $nombre)
    {
        $this->nombre = $nombre;

        return $this;
    }
}