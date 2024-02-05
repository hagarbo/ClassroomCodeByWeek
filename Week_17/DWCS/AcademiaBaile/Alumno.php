<?php

final class Alumno extends Persona
{
    public const TABLA_PRECIOS = [20,32,40];
    private int $numClases = 0;
    public function setNumClases($numClases){
        $this->numClases = $numClases>0 ? $numClases : 0;
    }

    public function aPagar():int{
        switch ($this->numClases) {
            case 0:
                throw new Exception("Debe indicar previamente o número de clases", 1);
            case 1:
                return self::TABLA_PRECIOS[0];
            case 2:
                return self::TABLA_PRECIOS[1];
            default:
                return self::TABLA_PRECIOS[2];
        }
    }


}
