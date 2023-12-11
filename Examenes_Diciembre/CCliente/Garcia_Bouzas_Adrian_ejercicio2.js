window.onload = () => {
    const boton = document.querySelector("form")["boton"];
    boton.addEventListener("click", procesarFormulario);
}

function procesarFormulario() {
    fecha = document.querySelector("form")["fecha"].value;

    // pos 0 = año, pos 1 = mes, pos 2 = dia
    fecha_split = fecha.split("-");
    let dia = fecha_split[2];
    let mes = fecha_split[1];
    let estacion = calcularEstacion(dia, mes);

    document.getElementById("resultado").innerHTML = estacion;

    // Creamos un nodo nuevo, un div con 2 parrafos, uno para la fecha y otro para la estacion
    let nodoNuevo = document.createElement("div");
    let nodoFecha = document.createElement("p");
    nodoFecha.innerHTML = fecha;
    // damos un poco de estilo
    nodoFecha.style.color = "red";
    nodoFecha.style.fontFamily = "sans-serif";
    nodoFecha.style.fontSize = "20px";
    
    let nodoEstacion = document.createElement("p");
    nodoEstacion.innerHTML = estacion;
    nodoEstacion.style.color = "green";
    nodoEstacion.style.fontFamily = "monospace";    
    nodoEstacion.style.fontSize = "30px";
    nodoEstacion.style.fontWeight = "bold";

    // añadimos los parrafos al div
    nodoNuevo.appendChild(nodoFecha);
    nodoNuevo.appendChild(nodoEstacion);

    // añadimos el div al nodo resultado
    document.getElementById("resultado").appendChild(nodoNuevo);

    const botonVentana = document.querySelector("form")["abrir"];
    botonVentana.disabled = false;

    botonVentana.addEventListener("click", () => {
        ventana = window.open("", "Ventana", "width=300,height=300");
        ventana.document.body.innerHTML = estacion;

        let otroNodo = nodoNuevo.cloneNode(true);//LO CLONAMOS PARA NO BORRAR EL ORIGINAL
        ventana.document.body.appendChild(otroNodo);
    });
    
}

// Las siguientes funciones nos calculan la estacion 
function calcularEstacion(dia, mes) {
    if (es_invierno(dia,mes)) return "Invierno";
    if (es_primavera(dia, mes)) return "Primavera";
    if (es_verano(dia, mes)) return "Verano";
    if (es_otono(dia, mes)) return "Otoño";
}


function es_verano(dia, mes) {
    if (mes < 6 || mes > 9) return false;
    else if (mes == 6) {//JUNIO
        return (dia >= 21);
    }
    else if (mes == 9) {//SEPTIEMBRE
        return (dia <= 20);
    }
    else return true; //JULIO O AGOSTO
}

function es_invierno(dia, mes) {
    if (mes > 3 && mes !=12) return false; //Si es despues de marzo o no es diciembre
    else if (mes == 12) {//DICIEMBRE
        return (dia >= 21);
    }
    else if (mes == 3) {//MARZO
        return (dia <= 20);
    }
    else return true; //ENERO O FEBRERO
}

function es_primavera(dia, mes) {
    if (mes < 3 || mes > 6) return false;
    else if (mes == 3) {//MARZO
        return (dia >= 21);
    }
    else if (mes == 6) {//JUNIO
        return (dia <= 20);
    }
    else return true; //ABRIL O MAYO
}

function es_otono(dia, mes) {
    if (mes < 9) return false;
    else if (mes == 9) {//SEPTIEMBRE
        return (dia >= 21);
    }
    else if (mes == 12) {//DICIEMBRE
        return (dia <= 20);
    }
    else return true; //OCTUBRE O NOVIEMBRE
}