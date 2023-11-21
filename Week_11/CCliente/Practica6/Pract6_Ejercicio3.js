
window.onload = () => {
    document.getElementById("crear").addEventListener("click", crearFilaNota);
}

function crearFilaNota() {
    let nota = document.querySelector("#nota").value;

    // CAJON GRANDE DONDE VAN LOS BOTONES Y LA NOTA
    let divFila = document.createElement("div");
    
    // BOTONES
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

    // AÑADES LA NOTA Y LOS BOTONES AL CAJON 
    divFila.appendChild(nodeNota);
    divFila.appendChild(btnEliminar);
    divFila.appendChild(btnArriba);
    divFila.appendChild(btnAbajo);
    divFila.appendChild(btnAtras);
    divFila.appendChild(btnSiguiente);

    // AÑADES TODO EL CAJON DENTRO DE UN DIV QUE SE LLAMA notas-list
    // SI MIRAS EL HTML ESTARA VACIO ESE DIV
    document.querySelector("#notas-list").append(divFila);

    // EVENTOS PARA LOS DISTINTOS BOTONES
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