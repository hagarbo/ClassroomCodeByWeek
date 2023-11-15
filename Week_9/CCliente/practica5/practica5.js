const hoy = new Date();

window.onload = function () {
    const birthDateButton = document.querySelector("#botonNacimiento");
    const eventButton = document.querySelector("#botonEvento");
    birthDateButton.addEventListener("click",calcularEdad);
    eventButton.addEventListener("click",calcularCuentaAtras);

    document.formulario.crear.addEventListener("click", crear);
    
    const crearListaButton = document.querySelector("#crearLista");
    const destruirListaButton = document.querySelector("#destruirLista");
    crearListaButton.addEventListener("click",crearLista);
    destruirListaButton.addEventListener("click",destruirLista);
}

/* Ejercicio 2: Solicitar al usuario la fecha de su nacimiento y calcular su edad. */

function calcularEdad(){
    let birthDate = document.querySelector("#fechaNacimiento").valueAsDate;

    let mensaje = document.createElement("h2");
    mensaje.innerHTML="Tienes: "+milisecondsToYears(hoy-birthDate)+ " años";

    document.querySelector("#resultado").append(mensaje);
}

/* Ejercicio3: Solicitar al usuario la fecha de un evento determinado y calcular los días que
quedan hasta el día del evento. */

function calcularCuentaAtras(){
    let fechaEvento = document.querySelector("#fechaEvento").valueAsDate;
    let mensaje = document.createElement("h2");
    mensaje.innerHTML="Quedan: "+milisecondsToDays(fechaEvento-hoy)+" días para el evento";
    document.querySelector("#resultado").append(mensaje);
}


/* FUNCIONES AUXILIARES */
function milisecondsToYears(ms){
    return Math.floor(ms/(1000*3600*24*365));
}

function milisecondsToDays(ms){
    return Math.floor(ms/(24*3600*1000));
}

function yearsToMiliseconds(years){
    return 365*24*3600*1000*years;
}

/* EJERCICIO 4 */

function crear() {
    let texto = document.formulario.texto.value;
    console.log(texto);
    //Creamos la etiqueta
    let parrafo = document.createElement("p");
    let nodoTexto = document.createTextNode(texto);
    let span = document.createElement("span");
    let nodoTexto2 = document.createTextNode("Prueba");
    span.appendChild(nodoTexto2);
    parrafo.appendChild(nodoTexto);
    document.body.appendChild(parrafo);
    //let devuelto = document.body.replaceChild(span, parrafo);
    console.log(devuelto);
}

/* EJERCICIO 5 */

function crearLista(){
    let lista = document.createElement("ul");
    for (let index = 1; index < 4; index++) {
        let nodoLista = document.createElement("li");
        let texto = document.createTextNode(index);
        nodoLista.appendChild(texto);
        lista.appendChild(nodoLista);
    }
    
    let divLista = document.querySelector("#div-lista");
    if(divLista==null){
        divLista = document.createElement("div");
        divLista.id = "div-lista";
    }
    divLista.appendChild(lista); 
    document.body.appendChild(divLista);
}

function destruirLista(){
    let divlista = document.querySelector("#div-lista");
    if (divlista!=null)
        divlista.removeChild(divlista.firstChild);
}