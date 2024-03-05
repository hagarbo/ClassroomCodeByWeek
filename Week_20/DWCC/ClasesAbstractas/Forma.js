export class Forma{
    constructor() {
        if (this.constructor === Forma) 
            throw new Error("This is an abstract class");
    }

    dibujar() {
        throw new Error("This is an abstract method");
    }

    borrar() {
        // TO DO
    }
}