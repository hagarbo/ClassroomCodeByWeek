'use strict'
/* 
Realizar un script que muestre los números pares por la consola y los números
impares en la página.
Debes crear un array con varios números. Recorres dicho array, y compruebas si el número
es par o impar. Para hacer dicha comprobación debes utilizar una función EsPar(), que re-
cibe un número y devuelve un valor booleano. */

window.onload = function (){

    let array = [7,8,1,3,65,900,56,12,34,76,51];

    array.forEach(element => {
        if (esPar(element)) console.log(`Numero par: ${element}`);
        else document.write(`<p>Numero impar: ${element}</p>`);
    });

  /*   array.forEach(checkNum); <--- al pasarle el nombre de la funcion ya le pasa 
        el elemento de la coleccion como parametro

    function checkNum(num){
        if (esPar(num)) console.log(`Numero par: ${element}`);
        else document.write(`<p>Numero impar: ${element}</p>`);
    } */
}

function esPar(num){
    if (num%2==0) return true;
    else return false;
}