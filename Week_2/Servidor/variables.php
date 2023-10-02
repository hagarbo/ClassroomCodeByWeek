<?php

//variable de tipo  entero
$edad = 30;
echo "Mi edad es $edad <br/>";
//Para mostrar el símbolo $ lo escapamos con \$
echo "El tipo de \$edad es ". gettype($edad) ."<br/>";
echo "¿El tipo de \$edad es int? ";
var_dump(is_int($edad)) ;
echo "<br/> <br/>";


//variable double (o float)
$salario = 34500.23;
echo "El tipo de \$salario es ". gettype($salario). "<br/>";


//variable boolean (o bool)
$mayor_que_cero = $edad >0;
echo "El tipo de \$mayor_que_cero es ". gettype($mayor_que_cero)."<br/>";


//variable string
$nombre="María";
echo "El tipo de \$nombre es ". gettype($nombre)."<br/>";
//Con comillas simples las variables no se expanden: No se sustituyen por su valor
$nombre_cliente='Ana';
echo '\$nombre_cliente es $nombre_cliente <br/>';


//variables no definidas => se lanza una advertencia (warning)
echo "El tipo de \$no_definida es ". gettype($no_definida)."<br/>";

//Si lo asignamos a null, forzamos su inicialización a un contenido vacío.
$no_definida = null;
echo "El tipo de \$no_definida es ". gettype($no_definida)."<br/>";


//isset devuelve true si la variable está definida y es distinta de null
echo "isset(\$no_definida) devuelve "; 
var_dump(isset($no_definida));
echo "<br/>";

//isset devuelve true si la variable está definida y es distinta de null
echo "isset(\$salario) devuelve "; 
var_dump(isset($salario));
echo "<br/>";

//isset se puede usar con varias variables y examinará cada una de ellas
echo "isset(\$salario) devuelve "; 
var_dump(isset($salario));
echo "<br/>";

//constantes
const PI= 3.141592;
$radio = 2;

$longitud_circunf = 2* PI *$radio;
echo "La longitud de una circunferencia con un radio de $radio cm es: $longitud_circunf cm <br/>";

//cadenas numéricas
$edad_string ="30";
echo "es numérica \$edad_string?";
var_dump(is_numeric($edad_string));
echo "<br/>";
echo "es un entero \$edad_string?";
var_dump(is_int($edad_string));
echo "<br/>";

//cadenas numéricas al inicio, pero no al final
$edad_string ="30ee";

echo "es numérica \$edad_string?";
var_dump(is_numeric($edad_string));
echo "<br/>";
echo "es un entero \$edad_string?";
var_dump(is_int($edad_string));
echo "<br/>";

//Curioso: https://www.php.net/manual/es/language.types.numeric-strings.php
$edad = $edad + $edad_string;
echo "La edad es ahora: $edad <br/>";
//Se transforma la parte transformable a númerico y se hace la suma, lanzando un warning

$salario_bonus_string = "100.55f";
$salario = $salario + $salario_bonus_string;
echo "El salario + el bonus es: $salario";
//Se transforma la parte transformable a númerico y se hace la suma, lanzando un warning
