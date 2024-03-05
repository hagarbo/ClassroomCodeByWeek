import { Forma } from "./Forma.js";

export class Triangulo extends Forma{

    setLado(lado) {
        this.lado = lado;
    }

    dibujar() {
        return "Soy un triangulo y mi lado es " + this.lado;
    }
}