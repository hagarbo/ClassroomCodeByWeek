<?php
const OPERACIONES = ["suma", "resta"];
function calculadora(float $x, float $y, int $op_index): float
{
    if (OPERACIONES[$op_index] == "suma") return $x + $y;
    if (OPERACIONES[$op_index] == "resta") return $x - $y;
}
