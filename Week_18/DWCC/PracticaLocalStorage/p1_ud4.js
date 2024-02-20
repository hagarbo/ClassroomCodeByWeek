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
    let vehiculo = new Vehiculo(formulario.modelo.value, formulario.marca.value, formulario.precio.value, formulario.webkitMatchesSelector.value);
    console.log(vehiculo);
    vehiculos.push(vehiculo);
}

function mostrarVehiculos() {
    vehiculos.forEach(
        (element) => {
            let nodo = document.createElement("p");
            nodo.innerHtml ="Marca: "+element.marca+
                            "Modelo: " + element.modelo +
                            "Precio: " + element.precio +
                "Km: " + element.km;
            document.getElementById("divVehiculos").appendChild(nodo);
        }
    )
}