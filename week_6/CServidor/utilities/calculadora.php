<?php
const OPERACIONES = ["suma", "resta", "multiplicacion", "division"];
function calculadora(float $x, float $y, int $op_index): float
{
    if (OPERACIONES[$op_index] == "suma") return $x + $y;
    if (OPERACIONES[$op_index] == "resta") return $x - $y;
    if (OPERACIONES[$op_index] == "multiplicacion") return $x * $y;
    if (OPERACIONES[$op_index] == "division") return $x / $y;
    echo "<p>Operacion incorrecta</p>";
}
