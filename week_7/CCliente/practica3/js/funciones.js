'use strict'
window.onload = function (){

    const miboton = document.getElementById("boton");
    miboton.addEventListener("click", handleClick);

    const array = [8,76,54,77,23,99];

    const mostrar = function(array){
        let show = "<p>[";
        for (let i = 0; i < array.length; i++) {
            show+=array[i]+" , ";
        }
        show = show.substring(0,show.length-3)+"]</p>";
        return show;
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
        return f(ordenado);
    }

    const ordenInverso = function(f,array){
        let ordenado=[];
        for (let i = 0; i < array.length; i++) {
            ordenado[i] = array[array.length-1-i];
        }
        return f(ordenado);
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
            if (input == array[i]) return i;
        }
        return -1;
    }


//Método comprueba si un número es par o impar. En caso de que sea par devuelve un valor true
const esPar = function (numero) {
    if (numero % 2 == 0)
        return true;
    else return false;

}
//Método que recorre el array de números, comprueba si un número es par y lo suma

function sumaPar(numeros, esPar) {
    let suma = 0;
    numeros.forEach(numero => {
        console.log(numero);
        if (esPar(numero))
            suma = suma + numero
    });

    return `<h4>LA SUMA DE LOS NUMEROS PARES ES ${suma} <h>`;

}

    function handleClick(){
        let index = busqueda(leerNumero,array);
        if (index == -1) alert("Numero no encontrado");
        else alert("Numero encontrado en la posicion "+index);
    }

    
    let cadenaMostrar = "<h3>Este es el array</h3>"+mostrar(array);
    let arrayOrdenado = array.slice();
    cadenaMostrar += "<h3>Este es el array ordenado de menor a mayor</h3>"+orden(mostrar,arrayOrdenado);
    let arrayInverso = arrayOrdenado.slice();
    cadenaMostrar += "<h3>Este es el array inverso</h3>"+ordenInverso(mostrar,arrayInverso);
    cadenaMostrar += "<h4>Tamaño del array: "+size(array)+"</h4>";
    cadenaMostrar += sumaPar(array,esPar);

    const info = document.getElementById("div_info");
    info.innerHTML = cadenaMostrar;

    
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




