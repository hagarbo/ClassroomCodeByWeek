<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<?php
include "utilities" . DIRECTORY_SEPARATOR . "calculadora.php";

if (
    isset($_GET["primer_operando"]) &&
    isset($_GET["segundo_operando"]) &&
    isset($_GET["operacion"])
) {
    $left = $_GET["primer_operando"];
    $right = $_GET["segundo_operando"];
    $op_index = $_GET["operacion"];
    $resultado = calculadora($left, $right, $op_index);
}
?>

<body>

    <h1>Operaciones Aritméticas</h1>
    <form method="get">
        <label for="operacion">Selecciones la operacion:</label>
        <select name="operacion" id="operacion">
            <?php
            foreach (OPERACIONES as $key => $value) {
                $selected = ($key == $op_index) ? " selected" : "";
                echo "<option value=$key $selected>$value</option>";
            }
            ?>
        </select>
        <p>
            <label for="primer_operando">Operando 1:</label>
            <input type="number" step="0.01" name="primer_operando" id="primer_operando" <?php if (isset($left)) echo "value='$left'"; ?> />
        </p>
        <p>
            <label for="segundo_operando">Operando 2:</label>
            <input type="number" step="0.01" name="segundo_operando" id="segundo_operando" <?php if (isset($right)) echo "value='$right'"; ?> />
        </p>
        <p>
            <input type="submit" value="Enviar" />
        </p>
    </form>

    <?php
    if (isset($resultado)) echo "<p>El resultado es: $resultado</p>";
    ?>
</body>

</html>