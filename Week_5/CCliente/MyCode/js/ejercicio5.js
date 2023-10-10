'use strict'
/* Realiza un script que halle la media de unos valores numéricos enteros intro-
ducidos por el usuario. Mostrar el resultado en una alerta. La introducción de datos se rea-
lizará de tal forma que si se pulsa el botón aceptar el usuario continuará introduciendo va-
lores y si se pulsa cancelar se muestra el resultado. Se debe comprobar que los valores in-
troducidos son numéricos, si no es así se mostrará un mensaje y se seguirán pidiendo datos.
También se controlará que se haya introducido al menos un valor numérico. */
window.onload = function (){
    let numero;
    let array = [];
    let input;

    while ( input!=null || array.length==0){
        input = prompt("Introduce un numero");
        numero = parseInt(input);
        if (!isNaN(numero)) array.push(numero);        
    }

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