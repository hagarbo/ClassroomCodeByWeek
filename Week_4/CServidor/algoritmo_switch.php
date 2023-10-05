<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<!-- 
    Crea un script php que, dada la calificación numérica (con posibles 
decimales) de un/a alumno/a , obtenga la calificación en formato cadena 
de texto de acuerdo con la siguiente tabla:

10-Matricula de honor
9-9.99-Sobresaliente
7-8.99-Notable
5-6.99-Aprobado 
<5 Suspenso 
-->

<body>
    <?php
    $notaAlumno = 9.85;
    $cadenaNota;
    switch (floor($notaAlumno)) {
        case 10:
            $cadenaNota = "Matrícula de honor";
            break;
        case 9:
            $cadenaNota = "Sobresaliente";
            break;
        case 8:
        case 7:
            $cadenaNota = "Notable";
            break;
        case 6:
        case 5:
            $cadenaNota = "Aprobado";
            break;
        default:
            $cadenaNota = "Suspenso";
            break;
    }

    echo "La nota del alumno es $notaAlumno:$cadenaNota";
    ?>

</body>

</html>