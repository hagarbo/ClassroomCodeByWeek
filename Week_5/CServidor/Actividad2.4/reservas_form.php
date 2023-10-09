<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reservas</title>
</head>

<body>

    <h1>Reservas Launch</h1>
    <form method="post" name="formulario-reservas" action="reservas_sent.php" enctype="multipart/form-data">
        <label for="fecha-reserva">Introduzca fecha:</label>
        <input type="date" required id="fecha-reserva" name="fechaReserva" value="2023-10-09" min="2023-10-09" max="2023-10-31" />
        <label for="hora-reserva">Introduzca hora comida:</label>
        <input type="time" id="hora-reserva" name="horaReserva" value="13:00" min="13:00" max="15:00" />
        <fieldset>
            <legend>Ubicacion</legend>
            <label for="interior-id">Interior</label>
            <input type="radio" id="interior-id" name="ubicacion" value="interior" />
            <label for="terraza-id">Terraza</label>
            <input type="radio" id="terraza-id" name="ubicacion" value="terraza" checked />
        </fieldset>
        <label for="alergenos">Introduzca si es alergico a alguno de los siguientes elementos</label>
        <select name="alergenos[]" id="alergenos" multiple required>
            <option name="ninguno" value="ninguno">--</option>
            <option name="leche" value="leche">Leche</option>
            <option name="huevos" value="huevos">Huevos</option>
            <option name="gluten" value="gluten">Gluten</option>
        </select>
        <br />
        <input type="file" name="fichero" id="fichero-id" />
        <p><input type="submit" value="Reservar" /></p>

    </form>

</body>

</html>