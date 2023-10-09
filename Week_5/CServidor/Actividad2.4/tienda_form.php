<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tienda de moda</title>
</head>

<body>

    <h1>Tienda de moda</h1>
    <form method="get" name="formulario-tienda" action="tienda_show_form.php">
        <label for="selector-prenda">Seleccione tipo de prenda:</label>
        <select name="selectorPrenda[]" id="selector-prenda" multiple required>
            <option name="abrigos" value="abrigos">Abrigos</option>
            <option name="tops" value="tops">Tops</option>
            <option name="camisas" value="camisas">Camisas</option>
        </select>
        <br />
        <label for="color">Color:</label>
        <input type="color" name="color" id="color" value="#000000" />
        <br />
        <input type="submit" value="Enviar" />
    </form>

</body>

</html>