'use strict'
alert("Dame un numero y te dare la tabla de multiplicar");
let numero;
do{
    numero = parseInt(prompt("Introduce un numero del 1 al 10",1));
}
while (numero<=0 || numero >10) 

document.write(`<h1>Tabla de multiplicar de ${numero}</h1>`);
const NUMEROS = 10;
for(let i=0;i<=NUMEROS;i++){
    document.write(`<p>${numero}*${i} = ${numero*i}</p>`);
}