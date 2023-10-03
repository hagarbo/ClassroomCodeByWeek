'use strict'
window.onload = function (){

    let numero;
    do{
        numero = parseInt(prompt("Introduce un numero positivo"));
    }
    while (numero<=0 || isNaN(numero)) 

    //Para determinar si N es número primo, deberemos dividirlo entre 
    //todos los primos menores a él (ordenados de forma ascendente) hasta 
    //obtener un cociente menor o igual al respectivo divisor.
    function esPrimo(number){
        for (let i=2;i<number;i++){
            if (number%i==0) return false;
        }
        return true;
    }

    let primosMenores = [];
    for(let i=2;i<numero;i++){
        if (esPrimo(i)) primosMenores.push(i);
    }

    if (primosMenores.length>0) 
        document.write(`<h1>El numero ${numero} no es primo</h1>`);
    else document.write(`<h1>El numero ${numero} es primo</h1>`);

    document.write("<ul>");
    primosMenores.forEach(element => {
        document.write(`<li>${element}</li>`)
    });
    document.write("</ul>");

}