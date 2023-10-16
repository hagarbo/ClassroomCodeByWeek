<?php

echo "Soy B";
echo "</br>";
echo __DIR__;
echo "</br>";
echo __FILE__;
echo "</br>";

//warning No se resuelve el directorio
//include "..".DIRECTORY_SEPARATOR."..".DIRECTORY_SEPARATOR."C".DIRECTORY_SEPARATOR."C.php";

//correcto
include __DIR__ . DIRECTORY_SEPARATOR . ".." . DIRECTORY_SEPARATOR . ".." . DIRECTORY_SEPARATOR . "C" . DIRECTORY_SEPARATOR . "C.php";
