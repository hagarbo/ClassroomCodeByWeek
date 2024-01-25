<?php

function cerrar_sesion()
{

    //Tal y como se recomienda en https://www.php.net/manual/es/function.session-destroy.php
    iniciar_sesion();

    $_SESSION = array();

    if (ini_get("session.use_cookies")) {
        $params = session_get_cookie_params();
        setcookie(
            session_name(),
            '',
            time() - 42000,
            $params["path"],
            $params["domain"],
            $params["secure"],
            $params["httponly"]
        );
    }
    session_destroy();
}

function isSessionActive()
{
    $autenticado = iniciar_sesion() && (session_status() === PHP_SESSION_ACTIVE) && isset($_SESSION["textos"]);
    return $autenticado;
}


//Si se realizan dos llamadas seguidas a session_start(), se producira un mensaje de E_NOTICE A session had already been started
//Comprobamos si ya hay una sesión iniciada previamente
function iniciar_sesion(): bool
{
    $iniciada = true;
    if (session_status() !== PHP_SESSION_ACTIVE) {
        $iniciada = session_start();
    }
    return $iniciada;
}
