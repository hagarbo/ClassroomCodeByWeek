'use strict'
/* 
Realiza un script que lea un número y calcule y visualice su factorial.*/

window.onload = function (){
    let numero = 0;
    while (numero<=0 || isNaN(numero)){
        numero = parseInt(prompt("Introduce un numero"));
    }

    let factorial = 1;
    for (let i = 2; i <= numero; i++) {
        factorial*=i;
        document.write(`<p>${factorial} * ${i}</p>`);
    }

    document.write(`<h1>El factorial de ${numero} es ${factorial}</h1>`);
}