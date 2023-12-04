
window.onload = () => {

    document.getElementById("crear").addEventListener("click", crearCajas);
    document.getElementById("antes").addEventListener("click", crearCajaAntes);
    document.getElementById("despues").addEventListener("click", crearCajaDespues);
    document.getElementById("circulos").addEventListener("click", hacerCirculos);
    document.getElementById("borrar").addEventListener("click", borrarNodo);
    
}

function crearCajas() {
    clear();
    let numCajas = document.getElementById("cantidad").value;
    let divPadre = document.getElementById("seccion");

    if (numCajas <= 0) return false;
    
    for (let index = 1; index <= numCajas; index++) {

        //CREAR CAJA
        let nodoIndice = document.createElement("p");
        nodoIndice.innerHTML = index;
        let nodoCaja = document.createElement("div");
        nodoCaja.id = "caja-" + index;
        nodoCaja.appendChild(nodoIndice);

        //ESTILOS
        nodoCaja.classList.add("caja");

        //EVENTO MOUSE OVER
        nodoCaja.addEventListener("mouseenter", cambiarColor,false);
        nodoCaja.addEventListener("mouseleave", recuperaColor);
        nodoCaja.colorFondo = nodoCaja.style.backgroundColor;
        divPadre.appendChild(nodoCaja);
    }
    
}

function crearCaja(indice,colorFondo) {
    let divPadre = document.getElementById("seccion");
    if (indice <= 0 || indice > divPadre.children.length) return false;
    let cajaReferencia = divPadre.querySelector("#caja-"+indice);
    
    let nodoCaja = document.createElement("div");
    nodoCaja.classList.add("caja");
    nodoCaja.style.backgroundColor = colorFondo;

    divPadre.insertBefore(nodoCaja, cajaReferencia);   
}

function crearCajaAntes() {
    let indice = document.getElementById("numeroAnterior").value;
    crearCaja(indice, "yellow");
}

function crearCajaDespues() {
    let indice = parseInt(document.getElementById("numeroPosterior").value) + 1;
    crearCaja(indice, "orange");   
}

function cambiarColor(evt) {
    evt.currentTarget.style.backgroundColor = "red";
}

function recuperaColor() {
    this.style.backgroundColor = this.colorFondo;
}

function hacerCirculos() {
    let divPadre = document.getElementById("seccion");
    if (divPadre.children.length == 0) return false;
    let hijos = divPadre.querySelectorAll("div");
    hijos.forEach(element => {
        element.style.borderRadius = "40px";
    });
}

function clear() {
    document.getElementById("seccion").innerHTML = "";
}

function borrarNodo() {
    let indice = document.getElementById("borrarNodo").value;
    //TO DO 
}