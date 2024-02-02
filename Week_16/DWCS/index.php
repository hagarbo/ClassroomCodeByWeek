<?php
require_once "UnaClase.php";
require_once "point.php";


/* $class = new UnaClase();
echo "<p>" . $class->foo() . "</p>";
echo "<p>" . UnaClase::CONSTANTE_PUBLICA . "</p>"; */
/* echo "<p>" . UnaClase::CONSTANTE_PROTEGIDA . "</p>";
echo "<p>" . UnaClase::CONSTANTE_PRIVADA . "</p>"; */

point::contador();

$punto1 = new point(0, 0);

point::contador();

$punto2 = new point(0, 0);
$punto2->contador();