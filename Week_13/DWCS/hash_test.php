<?php

$pass = "unacontraseña";
$hash = password_hash($pass, PASSWORD_DEFAULT);

$resultado = password_verify($pass, $hash);

echo "El hash es " . $hash;
echo "El resultado es $resultado";

