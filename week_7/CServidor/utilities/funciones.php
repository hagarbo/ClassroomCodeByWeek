<?php

//////////////////////////
// FUNCIONES APARTADO 2 //
//////////////////////////

const MIN_RANDOM = 0;
const MAX_RANDOM = 10;

function mostrarTabla(int $f, int $c): string
{
    $html = "<table><thead><tr>";
    for ($i = 1; $i <= $c; $i++) {
        $html .= "<th>Col. " . $i . "</th>";
    }
    $html .= "</tr></thead>";
    $html .= "<tbody>";
    for ($i = 0; $i < $f; $i++) {
        $html .= "<tr>";
        for ($j = 0; $j < $c; $j++) {
            $html .= "<td>" . rand(MIN_RANDOM, MAX_RANDOM) . "</td>";
        }
        $html .= "</tr>";
    }
    $html .= "</tbody></table>";
    return $html;
}

function crearArray(int $f, int $c): array
{
    // $array = array(array()); // No es necesario inicializar for some reason
    for ($i = 0; $i < $f; $i++) {
        for ($j = 0; $j < $c; $j++) {
            $array[$i][$j] = rand(0, 10);
        }
    }

    return $array;
}

function mostrarArrayEnTabla(array $array): string
{
    $html = "<table><thead><tr>";
    $html .= "</tr></thead>";
    $columnas = sizeof($array[array_key_first($array)]);
    for ($i = 0; $i < $columnas; $i++) {
        $html .= "<th>Col. " . $i . "</th>";
    }
    $html .= "<tbody>";
    foreach ($array as $fila) {
        $html .= "<tr>";
        foreach ($fila as $celda) {
            $html .= "<td>" . $celda . "</td>";
        }
        $html .= "</tr>";
    }
    $html .= "</tbody></table>";
    return $html;
}

//////////////////////////
// FUNCIONES APARTADO 3 //
//////////////////////////

function sumanCien(array $porcentajes): bool
{
    /*   $suma = 0;
    foreach ($porcentajes as $value) {
        $suma += $value;
    } */
    return array_sum($porcentajes) == MAX_PORCENTAJE;
}

function sameSize(array $a, array $b): bool
{
    return (sizeof($a) == count($b));
}

function esNumeroValido(array $array, int $min, int $max): bool
{
    foreach ($array as $value) {
        if (!is_numeric($value)) return false;
        if ($value < $min || $value > $max) return false;
    }
    return true;
}

/* function pesosValidos(array $array): bool
{
    foreach ($array as $value) {
        if (!is_numeric($value)) return false;
        if ($value < MIN_PORCENTAJE || $value > MAX_PORCENTAJE) return false;
    }
    return true;
} */

function validar(array $notas, array $pesos): string|true
{
    if (!sameSize($notas, $pesos))
        return "<p id='message'>ERROR:Debe haber el mismo numero de calificaciones y pesos</p>";
    if (!esNumeroValido($notas, NOTA_MINIMA, NOTA_MAXIMA))
        return "<p id='message'>ERROR:Los datos del campo calificaciones no son válidos</p>";
    if (!esNumeroValido($pesos, MIN_PORCENTAJE, MAX_PORCENTAJE))
        return "<p id='message'>ERROR:Los datos del campo pesos no son válidos</p>";
    if (!sumanCien($pesos))
        return "<p id='message'>ERROR:La suma de los pesos no es 100</p>";
    return true;
}

function calculaNotaMedia($notas, $pesos): float
{
    $suma = 0;
    for ($i = 0; $i < sizeof($notas); $i++) {
        $suma += $notas[$i] * $pesos[$i];
    }
    return $suma / MAX_PORCENTAJE;
}
