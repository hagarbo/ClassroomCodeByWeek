<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<!-- 
    Algoritmo 5.10 Dado un n¶umero natural, n, imprimir la lista de sus divisores, en orden
    decreciente.
    Inicio
    LEER n
    IMPRIMIR ' Lista de divisores del numero: ', n
    Para i=ParteEntera(n/2) hasta 2 (incremento -1)
    Si resto(n/i)=0
    IMPRIMIR i
    Fin Si
    Fin Para
    IMPRIMIR 1
    Fin
 -->

<body>
    <?php
    $num = 100;

    echo "<h1>Lista de divisores del numero: $num</h1>";
    $echo_result = "<ul><li>$num</li>";
    for ($i = intdiv($num, 2); $i >= 2; $i--) {
        if (($num % $i) == 0) {
            $echo_result .= "<li>$i</li>";
        }
    }
    $echo_result .= "<li>1</li></ul>";
    echo $echo_result;
    ?>
</body>

</html>