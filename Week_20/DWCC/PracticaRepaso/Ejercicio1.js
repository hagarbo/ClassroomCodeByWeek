import { Pelicula } from "./Pelicula.js";

window.onload = ()=>{

    const titulo = document.getElementById("addTitulo");
    const director = document.getElementById("addDirector");
    const duracion = document.getElementById("addDuracion");
    const cajaBorrar = document.getElementById("removepelicula");
    const formCrear = document.getElementById("formpeliculas");
    const formBorrar = document.getElementById("formborrarpeliculas");
    const listaPeliculas =  document.getElementById("peliculaslist");

    mostrarPeliculas(listaPeliculas);

    formCrear.onsubmit = (e) =>{
        e.preventDefault();
        crearPelicula(titulo.value,director.value,duracion.value);
        mostrarPeliculas(listaPeliculas);
    }

    formBorrar.onsubmit = (e) =>{
        e.preventDefault();
        if (borrarPelicula(cajaBorrar.value))
            mostrarPeliculas(listaPeliculas);
        else alert("La pelicula no existe!!");
    }
}

function mostrarPeliculas(nodoLista){
    nodoLista.innerHTML="";
    if (localStorage.length > 0){
        Object.keys(localStorage).forEach(entry => {
            try {
                let pelicula = JSON.parse(localStorage.getItem(entry));
                if (pelicula.hasOwnProperty("titulo") && pelicula.hasOwnProperty("director") && pelicula.hasOwnProperty("duracion"))
                {
                    let li = document.createElement("li");
                    li.setAttribute("id",pelicula.titulo);
                    li.innerHTML = "Titulo: "+ pelicula.titulo+" // Director: "+pelicula.director+ " // Duracion: "+pelicula.duracion;
                    nodoLista.appendChild(li);
                }
            } catch (error) {
                console.log(error);
            }
        });
    }
}

function crearPelicula(titulo, director, duracion) {
    const pelicula = new Pelicula(titulo,director,duracion);
    localStorage.setItem(titulo, JSON.stringify(pelicula));
    return pelicula;
}

function borrarPelicula(titulo) {
    const pelicula = localStorage.getItem(titulo);
    if (pelicula != null) {
        localStorage.removeItem(titulo);
        return true;
    } else return false;
}