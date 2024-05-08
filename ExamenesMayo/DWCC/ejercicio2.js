'use strict'


//Declarar un array de objetos de clientes
var datosClientes = [{
    id: 1,
    email: "michael.lawson@reqres.in",
    first_name: "Michael",
    last_name: "Lawson"
},
{
    id: 2,
    email: "lindsay.ferguson@reqres.in",
    first_name: "Lindsay",
    last_name: "Ferguson"
}
    , {
    id: 3,
    email: "tobias.funke@reqres.in",
    first_name: "Tobias",
    last_name: "Funke"
},
{
    id: 4,
    email: "byron.fields@reqres.in",
    first_name: "Byron",
    last_name: "Fields"
}];
//Declara un array de objetos de pizzas
var datosPizza = [
    {
        nombre: "Pizza margarita",
        precio: 20,
        identificador: 1,
        ingredientes: [
            "Champiñones",
            "Jamón Cocido"
        ]
    },
    {
        nombre: "Pizza barbacoa",
        precio: 25,
        identificador: 2,
        ingredientes: [
            "Carne",
            "Salsa barbacoa",
            "Extra de queso"
        ]
    },
    {
        nombre: "Pizza atún",
        precio: 22,
        identificador: 3,
        ingredientes: [
            "Atún",
            "Aceitunas negras",
            "Anchoa"
        ]
    }
];

function buscarCliente(id) {
    let resultado = null;
    datosClientes.forEach((cliente) => { 
        if (cliente.id == id) {
            console.log(cliente);
            resultado = cliente;
        }
    });
    return resultado;
}

function insertarCliente(cliente,nodo) {
    let nodoCliente = document.createElement("h1");
    nodoCliente.innerHTML = cliente.first_name + " " + cliente.last_name;
    nodo.appendChild(nodoCliente);
}

function mostrarPizzas(nodo) {
    let nodoTabla = document.createElement("table");
    //CABECERA
    let tHead = document.createElement("thead");
    let filaHead = document.createElement("tr");
    let nombreHead = document.createElement("th");
    nombreHead.innerHTML = "Nombre";
    let precioHead = document.createElement("th");
    precioHead.innerHTML = "Precio";
    filaHead.appendChild(nombreHead);
    filaHead.appendChild(precioHead);
    tHead.appendChild(filaHead);

    let tBody = document.createElement("tbody");

    datosPizza.forEach((pizza) => {
        let nodoFila = document.createElement("tr");
        let nodoNombre = document.createElement("td");
        nodoNombre.innerHTML = pizza.nombre;
        let nodoPrecio = document.createElement("td");
        nodoPrecio.innerHTML = pizza.precio;
        nodoFila.appendChild(nodoNombre);
        nodoFila.appendChild(nodoPrecio);
        tBody.appendChild(nodoFila);
    });
    nodoTabla.appendChild(tHead);
    nodoTabla.appendChild(tBody);
    
    nodo.appendChild(nodoTabla);
}

function buscarPizza(id) {
    let resultado = null;
    datosPizza.forEach((pizza) => { 
        if (pizza.identificador == id) {
            console.log(pizza);
            resultado = pizza;
        }
    });
    return resultado;
}

function mostrarIngredientes(pizza,nodo) {
    let titulo = document.createElement("h1");
    titulo.innerHTML = "Los ingredientes de " + pizza.nombre + " son:";
    let lista = document.createElement("ol");
    pizza.ingredientes.forEach((ingrediente) => {
        let item = document.createElement("li");
        item.innerHTML = ingrediente;
        lista.appendChild(item);
    });
    nodo.appendChild(titulo);
    nodo.appendChild(lista);
    let boton = document.createElement("button");
    boton.innerHTML = "Comprar";
    boton.addEventListener("click", () => { comprarPizza(pizza) });
    nodo.appendChild(boton);
}

function comprarPizza(pizza) {
    localStorage.clear();
    localStorage.setItem(pizza.identificador, JSON.stringify(pizza));
    alert("Compra realizada correctamente. Muchas Gracias!!");
}

window.onload = () => {
  
    let id = prompt("Introduzca el identificador del cliente");

    const nodoCliente = document.getElementById("cliente");
    const nodoPizzas = document.getElementById("pizzas");
    const nodoIngredientes = document.getElementById("ingredientes");

    let cliente = buscarCliente(id);
    if (cliente == null)
        alert("No existe ningun cliente con id: " + id);
    else {
        insertarCliente(cliente, nodoCliente);
    }

    mostrarPizzas(nodoPizzas);

    let pizza = buscarPizza(id);
    if (pizza == null)
        alert("No existe ninguna pizza con el id: " + id);
    else {
        setTimeout(() => { mostrarIngredientes(pizza, nodoIngredientes) },2000);
    }

};