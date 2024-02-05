<?php
class Circulo extends Figura
{
    public const PI = 3.1416;
    private float $radio;
    private Point $centro;

    public function __construct($nombre, $radio, $centro)
    {
        parent::__construct($nombre);
        $this->radio = $radio;
        $this->centro = $centro;
    }

    public function calcularArea()
    {
        parent::calcularArea();
        //return $this->radio * $this->radio * self::PI;
        return pow($this->radio, 2) * self::PI;
    }


    /**
     * Get the value of radio
     */ 
    public function getRadio()
    {
        return $this->radio;
    }

    /**
     * Set the value of radio
     *
     * @return  self
     */ 
    public function setRadio(float $radio)
    {
        $this->radio = $radio;

        return $this;
    }

    /**
     * Get the value of centro
     */ 
    public function getCentro()
    {
        return $this->centro;
    }

    /**
     * Set the value of centro
     *
     * @return  self
     */ 
    public function setCentro(Point $centro)
    {
        $this->centro = $centro;

        return $this;
    }
}