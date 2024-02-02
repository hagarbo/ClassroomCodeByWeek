<?php

class Point{
    private static int $num_puntos = 0;
    private int $x;
    private int $y;
    public function __construct(int $x = 0, int $y = 0) {
        $this->$x = $x;
        $this->$y = $y;
        self::$num_puntos++;
    } 

    /**
     * Get the value of x
     */
    public function getX(): int
    {
        return $this->x;
    }

    /**
     * Set the value of x
     */
    public function setX(int $x): self
    {
        $this->x = $x;

        return $this;
    }

    /**
     * Get the value of y
     */
    public function getY(): int
    {
        return $this->y;
    }

    /**
     * Set the value of y
     */
    public function setY(int $y): self
    {
        $this->y = $y;

        return $this;
    }

    public static function contador(){
        echo "<p>".self::$num_puntos."</p>";
    }
}