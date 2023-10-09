<!DOCTYPE html>

<html>

<head>
    <meta charset="UTF-8">
    <title>Zodiaco</title>
</head>

<body>

    <?php
    const CAPRICORNIO = "Capricornio";
    const ACUARIO = "Acuario";
    const PISCIS = "Piscis";
    const ARIES = "Aries";
    const TAURO = "Tauro";
    const GEMINIS = "Géminis";
    const CANCER = "Cáncer";
    const LEO = "Leo";
    const VIRGO = "Virgo";
    const LIBRA = "Libra";
    const ESCORPIO = "Escorpio";
    const SAGITARIO = "Sagitario";

    const MAX_DIAS = 31;
    const MAX_MESES = 12;

    //Las claves del día de corte van incluídas. Por ejemplo: los nacidos hasta el 20/01 son capricornio
    $zodiaco = array(
        //enero  
        1 => array(
            20 => CAPRICORNIO,
            "else" => ACUARIO
        ),
        //febrero
        2 => array(
            19 => ACUARIO,
            "else" => PISCIS
        ),
        //marzo
        3 => array(
            20 => PISCIS,
            "else" => ARIES
        ),
        //abril
        4 => array(
            19 => ARIES,
            "else" => TAURO
        ),
        //mayo
        5 => array(
            20 => TAURO,
            "else" => GEMINIS
        ),
        //junio
        6 => array(
            20 => GEMINIS,
            "else" => CANCER
        ),
        //julio
        7 => array(
            22 => CANCER,
            "else" => LEO
        ),
        //agosto
        8 => array(
            22 => LEO,
            "else" => VIRGO
        ),
        //septiembre
        9 => array(
            22 => VIRGO,
            "else" => LIBRA
        ),
        //octubre
        10 => array(
            22 => LIBRA,
            "else" => ESCORPIO
        ),
        //noviembre
        11 => array(
            22 => ESCORPIO,
            "else" => SAGITARIO
        ),
        12 => array(
            21 => SAGITARIO,
            "else" => CAPRICORNIO
        )
    );

    function monthToString(int $n)
    {
        if ($n == 1) return "Enero";
        if ($n == 2) return "Febrero";
        if ($n == 3) return "Marzo";
        if ($n == 4) return "Abril";
        if ($n == 5) return "Mayo";
        if ($n == 6) return "Junio";
        if ($n == 7) return "Julio";
        if ($n == 8) return "Agosto";
        if ($n == 9) return "Septiembre";
        if ($n == 10) return "Octubre";
        if ($n == 11) return "Noviembre";
        if ($n == 12) return "Diciembre";
        return "MES INVALIDO";
    }
    ?>
    <form method="post">

        Selecciona tu día y mes de nacimiento:

        <p>
            <label for="dia">Día:</label>
            <select name="dia" id="dia" required>
                <?php
                for ($i = 1; $i <= MAX_DIAS; $i++) {
                    if (isset($_POST["dia"]) && ($_POST["dia"] == $i))
                        echo "<option value='$i' selected>$i</option>";
                    else echo "<option value=$i>$i</option>";
                }
                ?>
            </select>


            <label for="mes">Mes</label>
            <select name="mes" id="mes" required>

                <?php

                for ($i = 1; $i <= MAX_MESES; $i++) {
                    if (isset($_POST["mes"]) && ($_POST["mes"] == $i))
                        echo "<option value='$i' selected>" . monthToString($i) . "</option>";
                    else echo "<option value=$i>" . monthToString($i) . "</option>";
                }
                ?>

            </select>



        </p>


        <p>
            <input type="submit" value="Enviar" />
        </p>



    </form>

    <div>
        <?php
        if (isset($_POST["dia"]) && isset($_POST["mes"])) {
            if ($_POST["dia"] <= array_key_first($zodiaco[$_POST["mes"]]))
                $signo = $zodiaco[$_POST["mes"]][array_key_first($zodiaco[$_POST["mes"]])];
            else $signo = $zodiaco[$_POST["mes"]]["else"];
            echo "<h2>Tu signo es $signo</h2>";
        }
        ?>
    </div>


</body>

</html>