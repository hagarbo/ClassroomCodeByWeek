<?php
namespace clases\people;
/**
 * Description of Persoa
 *
 * @author maria
 */
class Persoa implements \JsonSerializable{
   protected $nome;
   protected $apelidos;
   protected $mobil;
   
   
   public function __construct(string $nome, string $apelidos, string $mobil) {
       $this->nome = $nome;
       $this->apelidos = $apelidos;
       $this->mobil = $mobil;
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

   public function verInformacion(){
       $cadea = implode (" ", 
               [$this->nome,  $this->apelidos, 
                   "(".$this->mobil.")<br/>"]);
       echo $cadea;
   }

   public function jsonSerialize(){
        $nome_apelidos = join(" ", [$this->nome, $this->apelidos], );
        return ["nome_apelidos" => $nome_apelidos, "mobil" => $this->mobil];
    }
}
