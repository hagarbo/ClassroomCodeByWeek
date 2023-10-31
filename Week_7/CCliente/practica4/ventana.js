let mi_ventana;

const foco = document.getElementById("ancho");
foco.focus();

const botonCrear = document.getElementById("crear");
botonCrear.addEventListener("click", crearVentana);

document.getElementById("cerrar").addEventListener("")


function crearVentana() {

    let ancho = document.getElementById("ancho").value;
    let alto = document.getElementById("alto").value;
    let posX = document.getElementById("coordx").value;
    let posY = document.getElementById("coordy").value;
    let opciones ="left=" +posX +",top=" +posY +",width=" +ancho +",height=" +alto;

    mi_ventana = window.open("", "EjemploVentana", opciones);

    let fecha = new Date();
    let divNode = mi_ventana.document.createElement("div");
    divNode.setAttribute("id", "div-data");
    mi_ventana.document.body.append(divNode);

    let nodoFecha = mi_ventana.document.createElement("h3");
    nodoFecha.innerHTML =
    fecha.getDay() + "/" + fecha.getMonth() + "/" + fecha.getFullYear();
        
    let nodoNombre = mi_ventana.document.createElement("p");
    nodoNombre.innerHTML = "Juanito el Caminante";

    mi_ventana.document.getElementById("div-data").append(nodoFecha);
    mi_ventana.document.getElementById("div-data").append(nodoNombre);

    let botones = document.querySelectorAll("button");
    botones.forEach((boton) => (boton.disabled = false));
    botonCrear.disabled = true;

    mi_ventana.addEventListener("beforeunload", function () {
        botones.forEach((boton) => (boton.disabled = true));
        botonCrear.disabled = false;
    });
}

function cerrarVentana(){
    mi_ventana.close();
}