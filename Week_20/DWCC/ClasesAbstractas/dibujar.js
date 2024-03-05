import { Circulo } from "./Circulo.js";
import { Cuadrado } from "./Cuadrado.js";
import { Triangulo } from "./Triangulo.js";

window.onload = () => {
    const botonCuadrado = document.getElementById("cuadrado");
    const botonCirculo = document.getElementById("circulo");
    const botonTriangulo = document.getElementById("triangulo");
    const nodoSalida = document.getElementById("salida");

    botonCuadrado.addEventListener("click", () => {
        let cuadrado = new Cuadrado();
        cuadrado.setLado(5);
        let nodoCuadrado = document.createElement("h3");
        nodoCuadrado.innerHTML = cuadrado.dibujar();
        nodoSalida.appendChild(nodoCuadrado);
    });

    botonCirculo.addEventListener("click", () => {
        let circulo = new Circulo();
        circulo.setRadio("PI");
        let nodoCirculo = document.createElement("h3");
        nodoCirculo.innerHTML = circulo.dibujar();
        nodoSalida.appendChild(nodoCirculo);
    });

    botonTriangulo.addEventListener("click", () => {
        let triangulo = new Triangulo();
        triangulo.setLado(7);
        let nodoTriangulo = document.createElement("h3");
        nodoTriangulo.innerHTML = triangulo.dibujar();
        nodoSalida.appendChild(nodoTriangulo);
    });
    
}