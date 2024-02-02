<?php 

class Person {
    public const species = "Homo Sapiens";

    public string $name;
    public int $age;
    public string $occupation;

    public function __construct(string $name,int $age,string $occupation) {
        $this->name = $name;
        $this->age = $age;
        $this->occupation = $occupation;
    }

    public function introduce():string{
        return "Hello, my name is " . $this->name;
    }

    public function describe_job():string{
        return "I am currently working as a(n) " . $this->occupation;
    }

    public static function greet_extraterrestrials($especie):string{
        return "Welcome to Planet Earth $especie!";
    }
}