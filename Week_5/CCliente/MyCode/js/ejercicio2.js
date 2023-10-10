'use strict'
/* 
Realiza un script que lea una secuencia de números introducidos por teclado y
calcula y visualiza su suma y media. La secuencia terminará cuando el número introducido
sea cero.
Modifica el ejercicio utilizando un array en el que tenga almacenados varios números, por
ejemplo: numeros=[1,2,5,7,6] */

window.onload = function (){
    let numero;
    let array = [];
    while (numero!=0){
        numero = parseInt(prompt("Introduce un numero"));
        if (isNaN(numero)) numero = parseInt(prompt("Introduce un numero"));
        array.push(numero);
    }
    array.pop(); // Eliminamos el 0

    let suma = 0;
    array.forEach(element => {
        suma+=element;
    });
    let media = suma/array.length;
    document.write(`<h1>La suma es ${suma} y la media es ${media}</h1>`);
    document.write('<p> Datos : [');
    array.forEach(element => {
        if (element==array[array.length-1]) document.write(element);
        else document.write(element+",");
    });
    document.write(']</p>');
}