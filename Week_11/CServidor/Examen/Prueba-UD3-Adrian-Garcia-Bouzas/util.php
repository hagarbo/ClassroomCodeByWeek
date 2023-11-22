<?php

/**
 * Summary of is_valid_user
 * Orden de Comprobacion 1 - Comprueba que el usuario está registrado
 * @param string $user_id - La cadena que identifica al usuario
 * @param array $users - El array con los datos de los usuarios
 * @return bool - true si el usuario existe, false en caso contrario
 */
function is_valid_user(string $user_id, array $users) : bool {

    foreach ($users as $id => $data) {
        if ($user_id == $id)
            return true;
    }
    return false;
}

/**
 * Summary of check_password
 * Orden de Comprobacion 2 - Comprueba que la contraseña del usuario sea valida
 * @param string $user_id - La cadena que identifica al usuario
 * @param string $pwd - La contraseña que recibimos por formulario y queremos validar
 * @param array $users - El array con los datos de los usuarios
 * @return bool - true si coinciden las contraseñas, false en caso contrario
 */
function check_password(string $user_id, string $pwd, array $users) : bool{
    return ($users[$user_id]["pwd"]==$pwd);
}

/**
 * Summary of compare_new_passwords
 * Orden de Comprobacion 3 - Las nuevas contraseñas coinciden
 * @param string $pwd - La nueva contraseña introducida en el formulario
 * @param string $pwd_verifier - La nueva contraseña repetida en el formulario
 * @return bool - true si coinciden los parametros, false en caso contrario
 */
function compare_new_passwords(string $pwd, string $pwd_verifier):bool{
    return ($pwd == $pwd_verifier);
}

/**
 * Summary of check_password_length
 * Orden de Comprobacion 4 - La longitud mínima de las nuevas contraseñas es 6
 * @param string $pwd - La contraseña que queremos comprobar 
 * @param int $length - La longitud que queremos comprobar
 * @return bool - True si la cadena es >= que la longitud deseada, false en caso contrario
 */
function check_password_length(string $pwd, int $length) : bool{
    return (strlen($pwd) >= $length);
} 

/**
 * Summary of is_old_password
 * Orden de Comprobacion 5- La contraseña nueva no es una de las 2 últimas ya utilizadas
 * @param string $user_id
 * @param string $pwd
 * @param array $users
 * @return bool
 */
function is_old_password(string $user_id,string $pwd, array $users):bool{
    return ($pwd==$users[$user_id]["pwd-1"]) || ($pwd==$users[$user_id]["pwd-2"]);
}

/**
 * Summary of has_uppercase
 * Orden de Comprobacion 6- La nueva contraseña contiene al menos una letra mayúscula
 * @param string $pwd
 * @return bool
 */
function has_uppercase(string $pwd):bool{
    if (preg_match("/[A-Z]/", $pwd))
        return true;
    else
        return false;
}

/**
 * Summary of has_numer
 * Orden de Comprobacion 7 - La nueva contraseña contiene al menos un número
 * @param string $pwd
 * @return bool
 */
function has_number(string $pwd):bool{
    if (preg_match("/[0-9]/", $pwd))
        return true;
    else
        return false;
}

function has_symbol(string $pwd, string $regex):bool{
    if (preg_match($regex, $pwd))
        return true;
    else
        return false;
}