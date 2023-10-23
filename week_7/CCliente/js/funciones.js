'use strict'
window.onload = function (){

    const miboton = document.getElementById("boton");
    miboton.addEventListener("click", handleClick);

    const array = [8,76,54,77,23,99];

    const mostrar = function(array){
        let show = "[";
        for (let i = 0; i < array.length; i++) {
            show+=array[i]+" , ";
        }
        let para = document.createElement("p");
        let node = document.createTextNode(show.substring(0,show.length-3)+"]");
        para.appendChild(node);
    }

    const orden = function(f,array){
        let ordenado = array;
        for (let i = 1; i < ordenado.length-1; i++) {
            for (let j = 0; j < ordenado.length-i; j++) {
                if (ordenado[j] > ordenado[j+1]){
                    let aux = ordenado[j];
                    ordenado[j] = ordenado[j+1];
                    ordenado[j+1] = aux;
                }
            }
        }
        f(ordenado);
    }

    const ordenInverso = function(f,array){
        let ordenado=[];
        for (let i = 0; i < array.length; i++) {
            ordenado[i] = array[array.length-1-i];
        }
        f(ordenado);
    }

    const size = function(array){
        let x=0;
        for (let i = 0; i < array.length; i++) {
            x++;  
        }
        return x;
    }

    const busqueda = function(f,array){
        let input = f();
        for (let i = 0; i < array.length; i++) {
            if (input == array[i]) return true;
        }
        return false;
    }

    function handleClick(){
        if (busqueda(leerNumero,array)) alert("Numero encontrado");
        else alert("Numero no encontrado");
    }

    const info = document.getElementById("div_info");
    let para = document.createElement("p");
    let node = document.createTextNode("Este es el array");
    para.appendChild(node);
    info.appendChild(node);
    mostrar(array);

    para = document.createElement("p");
    node = document.createTextNode("Este es el array ordenado de menor a mayor");
    para.appendChild(node);
    info.appendChild(node);
    orden(mostrar,array);

    para = document.createElement("p");
    node = document.createTextNode("Este es el array inverso");
    para.appendChild(node);
    info.appendChild(node);
    ordenInverso(mostrar,array);

    para = document.createElement("p");
    node = document.createTextNode("Tamaño del array: "+size(array));
    para.appendChild(node);
    info.appendChild(node);

    
}


function leerNumero() {
    let numero;
    while (isNaN(numero)) {
      let input = prompt("Introduce un numero");
      if (input == null) return -1; 
      else numero = parseInt(input);
    }
    return numero;
  }




