<?php
class Cuadrado extends Figura
{
    private float $lado;

    private Point $bottonLeft;

    public function __construct(string $nombre, float $lado, Point $bottomLeft, int $num_lados = 0)
    {

        parent::__construct($nombre, $num_lados);
        $this->bottonLeft = $bottomLeft;
        $this->lado = $lado;

    }


    public function calcularArea()
    {
        parent::calcularArea();
        // return $this->lado * $this->lado;
        return pow($this->lado, 2);
    }

    

    /**
     * Get the value of lado
     */ 
    public function getLado()
    {
        return $this->lado;
    }

    /**
     * Set the value of lado
     *
     * @return  self
     */ 
    public function setLado(float $lado)
    {
        $this->lado = $lado;

        return $this;
    }

    /**
     * Get the value of bottonLeft
     */ 
    public function getBottonLeft()
    {
        return $this->bottonLeft;
    }

    /**
     * Set the value of bottonLeft
     *
     * @return  self
     */ 
    public function setBottonLeft(Point $bottonLeft)
    {
        $this->bottonLeft = $bottonLeft;

        return $this;
    }
}