'use strict'
alert("Dame un numero y te dire cuantas cifras tiene");
let numero;
do{
    numero = parseInt(prompt("Introduce un numero positivo"));
}
while (numero<=0) 

// Para calcular el numero de digitos voy realizando numero / 10 elevado a n hasta que el resultado sea menor que 0
// ejemplo 4 -> 4/10 menor que 0 digitos = 1
// 40 -> 40/10 > 0 pero 40/100 < 0 digitos = 2
let digitos = 1;
while ((numero/(10**digitos))>=1){
    //console.log((numero/(10**digitos)));
    digitos++;
}
document.write(`<h1>El numero ${numero} tiene ${digitos} digito(s)</h1>`);