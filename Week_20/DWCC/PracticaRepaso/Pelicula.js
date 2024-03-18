export class Pelicula{
    constructor(titulo, director, duracion) {
        this.titulo = titulo;
        this.director = director;
        this.duracion = duracion;
    }

    getInfo() {
        return "Titulo: "+ this.titulo+" // Director: "+this.director+ " // Duracion: "+this.duracion; 
    }
}