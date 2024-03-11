<?php
require_once "util.php";
/* session_start();
unset($_SESSION['nombre']);
unset($_SESSION['cesta']); */
cerrarSesion();
header('Location:login.php');