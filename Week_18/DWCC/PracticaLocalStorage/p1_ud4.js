const vehiculos = [];

window.onload = function () {
    addEventListener("submit", crearVehiculo);
    const botonMostrar = document.getElementById("mostrar");
    botonMostrar.addEventListener("click", mostrarVehiculos);
}

function crearVehiculo(e) {
    e.preventDefault();
    const formulario = document.getElementById("crearVehiculos");
    console.log("hola");
    let vehiculo = new Vehiculo(formulario.modelo.value, formulario.marca.value, formulario.precio.value, formulario.km.value);
    vehiculos.push(vehiculo);
}

function mostrarVehiculos() {
    if (vehiculos.length!=0){
        nodoResultado = document.getElementById("divVehiculos");
        nodoResultado.innerHTML = "";

        nodoTitulo = document.createElement("h4");
        nodoTitulo.innerHTML = "Lista de Vehiculos";
        nodoLista = document.createElement("ul");
        nodoResultado.appendChild(nodoTitulo);
        nodoResultado.appendChild(nodoLista);

        vehiculos.forEach(
            (element, i) => {
                let nodo = document.createElement("li");
                nodo.innerHTML = "Vehiculo "+ i +" -> " + element.mostrarDatos();
                nodoResultado.querySelector("ul").appendChild(nodo);
            }
        )
    } 
}