'use strict'
alert("Te voy a pedir 2 numeros para poder hacer su suma, resta, multiplicacion y division");
let numeroPrimero = parseInt(prompt("Introduce el primer numero",1));
let numeroSegundo = parseInt(prompt("Introduce el segundo numero",1));

let suma, resta, multiplicacion, division;

suma = numeroPrimero+numeroSegundo;
resta = numeroPrimero-numeroSegundo;
multiplicacion = numeroPrimero*numeroSegundo;
division = numeroPrimero/numeroSegundo;

//Suma
console.log("La suma de "+numeroPrimero+" y "+numeroSegundo+ " es: "+suma);
//Resta
console.log("La resta de "+numeroPrimero+" y "+numeroSegundo+ " es: "+resta);
//Multiplicacion
console.log("La multiplicación de "+numeroPrimero+" y "+numeroSegundo+ " es: "+multiplicacion);
//Division
if (numeroSegundo == 0){
    console.log("No podemos dividir por cero");
}else {
    console.log("La división de "+numeroPrimero+" y "+numeroSegundo+ " es: "+division);
}