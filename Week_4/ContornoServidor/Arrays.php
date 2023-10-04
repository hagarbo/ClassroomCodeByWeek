<?php


//Sintaxis larga array(...)
$ciclos = array(
    0 => "DAM",
    1 => "DAW",
    2 => "ASIR"
);

print "<pre>";
print_r($ciclos);
print "</pre>";


//sintaxis corta [...]
$ciclos = [
    0 => "DAM",
    1 => "DAW",
    2 => "ASIR"
];

print "<pre>";
print_r($ciclos);
print "</pre>";

//Las claves son opcionales
//Si no existen son numéricas consecutivas
$ciclos = array("DAM", "DAW", "ASIR");
print "<pre>";
print_r($ciclos);
print "</pre>";

$ciclos[] = "SMR"; // !!!!!!!!!!!AÑADIMOS UN ELEMENTO
array_push($ciclos, "TCM", "LSC");
print "<pre>";
print_r($ciclos);
print "</pre>";


//Las claves son opcionales
//Si no existen son numéricas consecutivas
$ciclos = ["DAM", "DAW", "ASIR"];
print "<pre>";
print_r($ciclos);
print "</pre>";



//Arrays asociativos

//Sintaxis larga array(...)
$colores = array(
    "white" => "0xFFFFFF",
    "black" => "0x000000",
    "red" => "0xFF0000"
);

print "<pre>";
print_r($colores);
print "</pre>";


//Arrays con índices de dos tipos:

$mixto = ["white" => "0xFFFFFF"];
$mixto[] = "blanco";

print "<pre>";
print_r($mixto);
print "</pre>";
