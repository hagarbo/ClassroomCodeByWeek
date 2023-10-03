'use strict'
alert("Te voy a pedir 3 numeros y te dire cual es el mayor");

let a,b,c;
while(isNaN(a))  {
    a = parseInt(prompt("Introduce el primer numero"));
}
while(isNaN(b))  {
    b = parseInt(prompt("Introduce el segundo numero"));
}
while(isNaN(c))  {
    c = parseInt(prompt("Introduce el tercer numero"));
}

if (a>=b && a>=c)
    document.write(`<h1>El numero ${a} es mayor o igual que ${b} y ${c}</h1>`);
else if (b>=a && b>= c)
        document.write(`<h1>El numero ${b} es mayor o igual que ${a} y ${c}</h1>`);    
    else document.write(`<h1>El numero ${c} es mayor o igual que ${a} y ${b}</h1>`);    