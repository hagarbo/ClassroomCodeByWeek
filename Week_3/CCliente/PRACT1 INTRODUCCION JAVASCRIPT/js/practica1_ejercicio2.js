'use strict'
//Declarar dos numeros como constantes, por lo que no pueden ser modificados
const num1=2,num2=2;
console.log("El primer numero es "+ num1);
console.log("El segundo numero es "+ num2);

//Declarar variables suma, resta, multiplicacion y división.
//Las mayúsculas y minúsculas en los nombres de las variables de Javascript importan.

let suma, resta, multiplicacion, division;

suma=num1 + num2;
resta=num1 - num2;
multiplicacion=num1 * num2;
division=num1 / num2;

//Visualizar el resultado por la consola
console.log("La suma es " + suma);
console.log("La resta es " + resta);
console.log("La multiplicacion es " + multiplicacion);
console.log("La division es " + division);

//Visualizando el resultado a través de la página
document.write(`<p>La suma de ${num1} + ${num2} es: ${suma}</p>`);
document.write(`<p>La resta de ${num1} - ${num2} es: ${resta}</p>`);
document.write(`<p>La multiplicacion de ${num1} * ${num2} es: ${multiplicacion}</p>`);
document.write(`<p>La division de ${num1} / ${num2} es: ${division}</p>`);
