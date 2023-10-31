'use strict'

// DOM - Document Object Model

function cambiaColor(color){
	caja.style.background = color;
}

// Conseguir elementos con un ID concreto

var caja = document.getElementById("seccionvacia");


caja.innerHTML = "¡TEXTO EN LA CAJA DESDE JS!";
caja.style.background = "blue";
caja.style.padding = "20px";
caja.style.color = "white";
caja.style.float="left";

//caja.setAttribute('class', 'cajanaranja');


// Conseguir elementos por su etiqueta
var todosLosDivs = document.getElementsByTagName('div');

var seccion = document.querySelector("#miseccion");
console.log(seccion);
var hr = document.createElement("hr");

//Añadir la nueva seccion 
var posicion=document.getElementById('seccionvacia').parentNode;
var nuevaseccion=document.querySelector("#seccionvacia");
console.log(posicion);

var valor;
for(valor in todosLosDivs){
	if(typeof todosLosDivs[valor].textContent == 'string'){
		var parrafo = document.createElement("p");
		var texto = document.createTextNode(todosLosDivs[valor].textContent);
		parrafo.append(texto);
        nuevaseccion.append(parrafo);
	}
}
nuevaseccion.append(hr);

// Conseguir elementos por su clase css
var divsRojos = document.getElementsByClassName('rojo');
var divsAmarillos = document.getElementsByClassName('amarillo');

divsAmarillos[0].style.background = cambiaColor("green");

var div;
for(div in divsRojos){
	if(divsRojos[div].className == "rojo"){
		divsRojos[div].style.background = "red";
	}
}


// Query selector
var id = document.querySelector("#encabezado");
console.log(id);

var claseRojo = document.querySelector("div.rojo");
console.log(claseRojo);

var etiqueta = document.querySelector("div");
console.log(etiqueta);

//Duplicar nodo
var duplicar = nuevaseccion.cloneNode(parrafo);

console.log(duplicar);
var padre=todosLosDivs[0].parentNode;
//duplicar.setAttribute("style", "background-color: orange;");
duplicar.style.background="orange";

padre.insertBefore(duplicar,todosLosDivs[0]);
