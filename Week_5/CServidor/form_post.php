<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario POST</title>
</head>

<body>

    <h1>Formulario con POST</h1>

    <form method="post" name="formulario-post" action="form.php">

        <label for="nombre-post">Introduzca su nombre: </label>

        <input type="text" name="nombre-post" id="nombre-post" required="required">

        <label for="email">Introduzca su email: </label>

        <input type="email" name="email-post" id="email-post" required="required">

        <input type="submit" value="Inicie sesión">

    </form>

</body>

</html>