<!-- 3- Crea un script php que muestre en un documento HTML 5, 
para unos valores a, b, c dados, calcule siguiendo el algoritmo 5.4 
del documento de ejemplo. -->

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <?php

    if (isset($_POST['a']) && isset($_POST['b']) && isset($_POST['c'])) {
        $a = $_POST['a'];
        $b = $_POST['b'];
        $c = $_POST['c'];

        $d = $b ** 2 - 4 * $a * $c;
        $aa = 2 * $a;
        $dd;
        if ($d >= 0) {
            $dd = sqrt($d);
            $x = [
                (-$b + $dd) / $aa,
                (-$b - $dd) / $aa
            ];
            echo "<h1>La ecuacion tiene raices reales: {" . round($x[0], 3) . ", " . round($x[1], 3) .
                "}</h1>";
        } else {
            $dd = sqrt(-$d);
            $Re = -$b / $aa;
            $Im = $dd / $aa;
            echo "<h1>La ecuacion tiene raices complejas conjugadas:</h1>";
            echo "<h2>Parte real: " . round($Re, 3) . "</h2>";
            echo "<h2>Parte imaginaria: " . round($Im, 3) . "</h2>";
        }
        echo "<br/><br/><a href='problema3.php'>Volver al inicio</a>";
    } else {
    ?>

        <form method="POST" action="problema3.php">
            <label for="a">Valor de A</label>
            <input type="number" name="a" id="a" />

            <label for="b">Valor de B</label>
            <input type="number" name="b" id="b" />

            <label for="c">Valor de C</label>
            <input type="number" name="c" id="c" />

            <input type="submit" value="Enviar" />
        </form>

    <?php
    }
    ?>


</body>

</html>