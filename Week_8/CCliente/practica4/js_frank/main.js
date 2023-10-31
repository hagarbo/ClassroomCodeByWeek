const d = document;
const w = window;

let ventana;
let ancho;
let alto;
let coordX;
let coordY;
let botonCrear;

d.addEventListener("click", e => {

    if (e.target.matches(".crear")) {


        botonCrear = e.target;
        ancho = d.getElementById("ancho").value;
        alto = d.getElementById("alto").value;
        coordX = d.getElementById("coordernada_x").value;
        coordY = d.getElementById("coordernada_y").value;


        let botones = d.querySelectorAll(".boton");

        botones.forEach(boton => boton.disabled = false);

        botonCrear.disabled = true;


        var opciones = `left=${coordX},top=${coordY},width=${ancho},height=${alto}`;

        ventana = w.open("", "", opciones);

        ventana.addEventListener("beforeunload", function () {

            botones.forEach(boton => boton.disabled = true);

            botonCrear.disabled = false;


        });


    }




});