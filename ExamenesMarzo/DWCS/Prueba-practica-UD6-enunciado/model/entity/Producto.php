<?php

class Producto implements JsonSerializable
{

    use ViewData;

    private ?int $id = null;
    private string $nombre="";
    private string $nombre_corto="";
    private string $descripcion="";
    private float $pvp=0.0;
    private string $familia="";

    //private ?string $imagePath = "";

    //Para que el método findAll funcione y esta línea en particular:
//    $array = $pdostmt->fetchAll(PDO::FETCH_CLASS, $this->class_name);
//tuve que comentar el constructor de Nota

    // public function __construct(?int $id = null, String $titulo = "", String $contenido = "") {
    //     $this->id = $id;
    //     $this->titulo = $titulo;
    //     $this->contenido = $contenido;
    // }

    public function getId(): ?int
    {
        return $this->id;
    }

    public function setId(?int $id): void
    {
        $this->id = $id;
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
    public function setNombre($nombre)
    {
        $this->nombre = $nombre;

        return $this;
    }

    /**
     * Get the value of nombre_corto
     */ 
    public function getNombre_corto()
    {
        return $this->nombre_corto;
    }

    /**
     * Set the value of nombre_corto
     *
     * @return  self
     */ 
    public function setNombre_corto($nombre_corto)
    {
        $this->nombre_corto = $nombre_corto;

        return $this;
    }

    /**
     * Get the value of descripcion
     */ 
    public function getDescripcion()
    {
        return $this->descripcion;
    }

    /**
     * Set the value of descripcion
     *
     * @return  self
     */ 
    public function setDescripcion($descripcion)
    {
        $this->descripcion = $descripcion;

        return $this;
    }

    /**
     * Get the value of pvp
     */ 
    public function getPvp()
    {
        return $this->pvp;
    }

    /**
     * Set the value of pvp
     *
     * @return  self
     */ 
    public function setPvp($pvp)
    {
        $this->pvp = $pvp;

        return $this;
    }

    /**
     * Get the value of familia
     */ 
    public function getFamilia()
    {
        return $this->familia;
    }

    /**
     * Set the value of familia
     *
     * @return  self
     */ 
    public function setFamilia($familia)
    {
        $this->familia = $familia;

        return $this;
    }

    public function jsonSerialize()
    {
        //Especificamos qué propiedades no públicas queremos que pasen a formar parte del objeto JSON
        return array(
            'id' => $this->id,
            'nombre' => $this->nombre,
            'nombre_corto' => $this->nombre_corto,
            'descripcion' => $this->descripcion,
            'pvp' => $this->pvp,
            'familia' => $this->familia
        );
    }
}