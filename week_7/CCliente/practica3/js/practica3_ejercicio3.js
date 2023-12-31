//Pedir 6 numeros por pantalla, almacenar en un array y realizar funcionres

'use strict'


//En esta solución los números en vez de introducirse por teclado los asigno por código
const numeros = [30, 41, 8, 12, 2, 34];

const numeroAbuscar = 30;


//Declarar la función mostrar en la que mostramos los numeros en una tabla. 
//En este primer ejemplo no creamos nodos de la estructura DOM, método que utilizaremos en
//los proximos temas

const mostrar = (numeros) => {
    document.write("<table border=2 > <thead> <th> NUMEROS ")
    numeros.forEach(numero => {
        document.write(`<tr><td align=center> ${numero} </td> `);
        console.log(numero);
    });
    document.write("</tr> </table>");
};


//Método para ordenar los numeros en el array
/* Para ordenar los elementos de un Array en JavaScript tenemos el método sort,
el cual ordena alfabéticamente. 
Si queresmo ordenar número como ocurre en este caso debemos
utilizar 
        const compareNumbers = (a, b) => a - b;
*/
const orden = function () {
    numeros.sort((a, b) => a - b);
    mostrar(numeros);
}

//Método que invierte los números ordenados y muestra el resultado

const ordenInv = function () {
    
    //Método que ordena
    numeros.sort((a, b) => a - b);

    //Método que invierte un array
    numeros.reverse();
    mostrar(numeros);
}

//Obtener el tamaño del array
const tamanno = numeros.length;

//Método que devuelve la posicion del elemento introducido
function posicion(numeroAbuscar, numeros) {
    let indice=0;
    console.log("Numero a buscar" + numeroAbuscar)
    for (let i = 0; i < numeros.length; i++) {
        console.log("Valor de numero" + numeros[i]);
        if (numeroAbuscar === numeros[i])
            {
                indice=i+1;//Se le suma uno pues el array empieza en la posicion 0
                break;
            }
            
        else
            indice=-1;
    }
    return indice;
};




// APARTADO 6 //
document.write("<hr size=7>") //Muestra una linea horizontal

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

    document.write(`<h3>LA SUMA DE LOS NUMEROS PARES ES ${suma} <h3>`);

}

// -----------------------------------EJECUCIÓN DE LOS MÉTODOS ----------------------- //
// APARTADO 1 //
//Ejecutar el método que muestra los números en el documento
mostrar(numeros);

document.write("<hr size=7>") //Muestra una linea horizontal

// APARTADO 5 - Ejecuta el método que devuelve la posicion del número buscado con los números iniciales//

if (posicion(numeroAbuscar, numeros) == -1)
    document.write("Numero no encontrado");
else
    document.write(`El número ${numeroAbuscar} está en la posición ${posicion(numeroAbuscar, numeros)}`);

// APARTADO 2 //
document.write("<hr size=7>") //Muestra una linea horizontal

document.write("<h2> NUMEROS ORDENADOS </h2>")

//Ejecutar el método orden al que se le envía como parámetro la función
//mostrar y los numeros a ordenar

orden(mostrar, numeros);

// APARTADO 5 - Ejecuta el método que devuelve la posicion del número buscado con los números ordenados//
document.write("<hr size=7>") //Muestra una linea horizontal

if (posicion(numeroAbuscar, numeros) == -1)
    document.write("Numero no encontrado");
else
    document.write(`El número ${numeroAbuscar} está en la posición ${posicion(numeroAbuscar, numeros)}`);

// APARTADO 3 //
document.write("<hr size=7>") //Muestra una linea horizontal
document.write("<h2> INVERTIR NUMEROS ORDENADOS </h2>")
//Ejecutar el método orden al que se le envía como parámetro la función
//mostrar y los numeros a ordenar

ordenInv(mostrar, numeros);

// APARTADO 5  Ejecuta el método que devuelve la posicion del número buscado con los números ordenados inversamente//
document.write("<hr size=7>") //Muestra una linea horizontal

if (posicion(numeroAbuscar, numeros) == -1)
    document.write("Numero no encontrado");
else
    document.write(`El número ${numeroAbuscar} está en la posición ${posicion(numeroAbuscar, numeros)}`);

// APARTADO 4 //
document.write("<hr size=7>"); //Muestra una linea horizontal

document.write(`<H3> EL TAMAÑO DEL ARRAY ES ${tamanno}`);


// APARTADO 6 //
document.write("<hr size=7>") //Muestra una linea horizontal

sumaPar(numeros, esPar);


