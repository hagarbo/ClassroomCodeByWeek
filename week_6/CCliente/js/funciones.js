'use strict'
window.onload = function (){

    const array = [8,76,54,77,23,99];

    const mostrar = function(array){
        let show = "[";
        for (let i = 0; i < array.length; i++) {
            show+=array[i]+" , ";
        }
        document.body.innerHTML+="<p>"+show.substring(0,show.length-3)+"]"+"</p>";
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

    const element = document.getElementById("boton");
    element.addEventListener("click", function() {
    console.log("Hello World");
    /* if (busqueda(leerNumero(),array)) alert("Numero encontrado");
        else alert("Numero no encontrado"); */
    });

    document.body.innerHTML+="<h3>Este es el array</h3>";
    mostrar(array);

    document.body.innerHTML+="<h3>Este es el array ordenado de menor a mayor</h3>";
    orden(mostrar,array);

    document.body.innerHTML+="<h3>Este es el array inverso</h3>";
    ordenInverso(mostrar,array);

    document.body.innerHTML+="<h4>Tamaño del array: "+size(array)+"</h4>";
    
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

