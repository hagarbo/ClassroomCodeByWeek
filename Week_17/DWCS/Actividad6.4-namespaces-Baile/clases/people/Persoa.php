<?php
namespace clases\people;

use DateTimeImmutable;
use traits\Logger;
/**
 * Description of Persoa
 *
 * @author maria
 */
abstract class Persoa implements \JsonSerializable{
    use Logger;
   protected $nome;
   protected $apelidos;
   protected $mobil;
   protected DateTimeImmutable $fecha_nacimiento;
   public function __construct(string $nome, string $apelidos, string $mobil,DateTimeImmutable $fecha_nacimiento) {
       $this->nome = $nome;
       $this->apelidos = $apelidos;
       $this->mobil = $mobil;
       $this->fecha_nacimiento = $fecha_nacimiento;
   }

   
   public function getNome(): string{
       return $this->nome;
   }

   public function getApelidos():string {
       return $this->apelidos;
   }

   public function getMobil():string {
       return $this->mobil;
   }

   public function setNome(string $nome): void {
       $this->nome = $nome;
   }

   public function setApelidos(string $apelidos): void {
       $this->apelidos = $apelidos;
   }

   public function setMobil(string $mobil): void {
       $this->mobil = $mobil;
   }

   public function esMayorDeEdad():bool{
    $fecha_actual = new DateTimeImmutable("now");
    $intervalo = $this->fecha_nacimiento->diff($fecha_actual);
    return $intervalo->y >= 18;
}

    abstract function verInformacion();

   public function jsonSerialize(){
        $nome_apelidos = join(" ", [$this->nome, $this->apelidos], );
        $this->log($nome_apelidos);
        return ["nome_apelidos" => $nome_apelidos, "mobil" => $this->mobil];
    }
}
