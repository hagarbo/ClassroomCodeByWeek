import { Forma } from "./Forma.js";

export class Circulo extends Forma{

    setRadio(radio) {
        this.radio = radio;
    }

    dibujar() {
        return "Soy un circulo y mi radio es " + this.radio;
    }
}