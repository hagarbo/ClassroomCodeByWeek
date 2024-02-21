<?php

class Usuario implements JsonSerializable{

    private int $id;
    private string $email;

    public function __construct(int $id, string $email) {
        $this->id = $id;
        $this->email = $email;
    }

    /**
     * Get the value of email
     */ 
    public function getEmail()
    {
        return $this->email;
    }

    /**
     * Set the value of email
     *
     * @return  self
     */ 
    public function setEmail($email)
    {
        $this->email = $email;

        return $this;
    }

    /**
     * Get the value of id
     */ 
    public function getId()
    {
        return $this->id;
    }

    /**
     * Set the value of id
     *
     * @return  self
     */ 
    public function setId($id)
    {
        $this->id = $id;

        return $this;
    }

    public function jsonSerialize(): mixed {
        //Especificamos qué propiedades no públicas queremos que pasen a formar parte del objeto JSON
      return array(
          'id' => $this->id,
          'email' => $this->email,
      );
  }
}