<?php
require "Persona.php";
require "Alumno.php";
require "Baile.php";
require "Profesor.php";

$profesor = new Profesor("Antonio", "Carmona Lorenzo", "885-987-392", "77777777G");
$bailes = [
    new Baile("AFRO"),
    new Baile("CLASICO"),
    new Baile("MODERNO", 16),
    new Baile("MODERNO")
];

foreach ($bailes as $baile) {
    $print = $profesor->engadirBaile($baile)? 
    "<p>Baile añadido correctamente </p>"
    : "<p>Baile repetido no se añadio</p>";
    echo $print;
}

$alumno_adulto = new Alumno("Jesus", "Perez Perez", "666-666-666");
$alumno_joven = new Alumno("Diana", "Perez Perez", "666-666-666");
$alumno_adulto->setNumClases(1);
$alumno_joven->setNumClases(2);
$otro_alumno = new Alumno("Susana", "Perez Perez", "666-666-666");
$otro_alumno->setNumClases(5);

echo "<p>Informacion do profesor: " . $profesor->verInformacion() . "</p>";
echo "<p>Bailes que imparte:</p>";
echo $profesor->mostrarBailes();
echo "<p>Informacion do alumno 1: " . $alumno_joven->verInformacion() . " A pagar: ". $alumno_joven->aPagar() . "</p>";
echo "<p>Informacion do alumno 2: " . $alumno_adulto->verInformacion() . " A pagar: ". $alumno_adulto->aPagar() ."</p>";
echo "<p>Informacion do alumno 3: " . $otro_alumno->verInformacion() . " A pagar: ". $otro_alumno->aPagar() . "</p>";

$profesor->borrarBaile("AFRO");

echo "<p>Informacion do profesor: " . $profesor->verInformacion() . "</p>";
echo "<p>Bailes que imparte:</p>";
echo $profesor->mostrarBailes();


