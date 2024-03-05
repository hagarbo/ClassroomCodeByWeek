import { Forma } from "./Forma.js";

export class Cuadrado extends Forma{

    setLado(lado) {
        this.lado = lado;
    }

    dibujar() {
        return "Soy un cuadrado y mi lado es " + this.lado;
    }
}