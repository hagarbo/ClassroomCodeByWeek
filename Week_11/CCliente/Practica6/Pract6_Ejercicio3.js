
window.onload = () => {
    document.getElementById("crear").addEventListener("click", crearFilaNota);
}

function crearFilaNota() {
    let nota = document.querySelector("#nota").value;

    let divFila = document.createElement("div");
    
    let btnEliminar = document.createElement("button");
    btnEliminar.setAttribute("type", "button");
    btnEliminar.innerText = "Eliminar";

    let btnArriba = document.createElement("button");
    btnArriba.setAttribute("type", "button");
    btnArriba.innerText = "Arriba";

    let btnAbajo = document.createElement("button");
    btnAbajo.setAttribute("type", "button");
    btnAbajo.innerText = "Abajo";

    let btnAtras = document.createElement("button");
    btnAtras.setAttribute("type", "button");
    btnAtras.innerText = "Atras";

    let btnSiguiente = document.createElement("button");
    btnSiguiente.setAttribute("type", "button");
    btnSiguiente.innerText = "Siguiente";

    let nodeNota = document.createElement("span");
    nodeNota.innerHTML = nota;

    divFila.appendChild(nodeNota);
    divFila.appendChild(btnEliminar);
    divFila.appendChild(btnArriba);
    divFila.appendChild(btnAbajo);
    divFila.appendChild(btnAtras);
    divFila.appendChild(btnSiguiente);

    document.querySelector("#notas-list").append(divFila);

    btnEliminar.addEventListener("click", (evt) => {
        let divPadre = evt.target.parentNode;
        divPadre.parentNode.removeChild(divPadre);
    })

    btnArriba.addEventListener("click", (evt) => {
        let divPadre = evt.target.parentNode;
        let primeroLista = divPadre.parentNode.firstChild;
        divPadre.parentNode.insertBefore(divPadre, primeroLista);
    })

    btnAbajo.addEventListener("click", (evt) => {
        let divPadre = evt.target.parentNode;
        divPadre.parentNode.appendChild(divPadre);
    })

    btnAtras.addEventListener("click", (evt) => {
        let divPadre = evt.target.parentNode;
        if (divPadre != divPadre.parentNode.firstChild)
            divPadre.parentNode.insertBefore(divPadre,divPadre.previousSibling);
    })

    btnSiguiente.addEventListener("click", (evt) => {
        let divPadre = evt.target.parentNode;
        if (divPadre.nextSibling!=null)
            divPadre.parentNode.insertBefore(divPadre.nextSibling,divPadre);
    })

}