
function crearAlumno(nombre, direccion, dni) {
    const alumno = new Alumno(dni, nombre, direccion);
    localStorage.setItem(alumno.getDni(), JSON.stringify(alumno));
    return alumno;
}

function borrarAlumno(dni) {
    const alumno = localStorage.getItem(dni);
    if (alumno != null) localStorage.removeItem(dni);
}

function crearTablaAlumnos() {
    if (localStorage.length > 0) {
        let nodoTabla = document.createElement("table");
        nodoTabla.innerHTML = "<table><thead>"
            + "<tr><th>Dni</th><th>Nombre</th><th>Direccion</th></tr>"
            + "</thead><tbody> ";
        Object.keys(localStorage).forEach(key => {
            let alumno = JSON.parse(localStorage.getItem(key));
            nodoTabla.innerHTML += `<tr><td>${alumno.dni}</td><td>${alumno.nombre}</td><td>${alumno.direccion}</td></tr>`; 
        });
        nodoTabla.innerHTML += "</tbody></table>";
        return nodoTabla;
    }
    return null;
}

window.onload = () => {
    
    const formCrear = document.getElementById("formalumnos");
    const formBorrar = document.getElementById("formborraralumnos");
    const nombre = document.getElementById("addNombre");
    const direccion = document.getElementById("addDireccion");
    const dni = document.getElementById("addDni");
    const botonCrear = document.getElementById("guardar");
    const botonMostrar = document.getElementById("mostrar");
    const divAlumnos = document.getElementById("alumnos");
    const idAlumno = document.getElementById("removeAlumno");
    const botonBorrar = document.getElementById("borrar");
    const divMensaje = document.getElementById("mensaje");

    function escribirMensaje(msg, exito) {
        mensaje = document.createElement("p");
        mensaje.innerHTML = msg;
        mensaje.style.color = exito ? "green" : "red";
        divMensaje.appendChild(mensaje);
    }
    
    formCrear.addEventListener("submit", (evt) => {
        evt.preventDefault();
        let alumno = crearAlumno(nombre.value, direccion.value, dni.value);
        nombre.value = "";
        direccion.value = "";
        dni.value = "";
        nombre.focus();
        botonCrear.value = "Guardar";
        dni.disabled = false;
        escribirMensaje(alumno.mostrar() + " creado correctamente", true);
    });

    botonBorrar.addEventListener("click", (evt) => {
        evt.preventDefault();
        borrarAlumno(idAlumno.value);
    });

    botonMostrar.addEventListener("click", () => {
        let tabla = crearTablaAlumnos();
        if (tabla != null) {
            divAlumnos.innerHTML = "";
            divAlumnos.appendChild(tabla);
        }
    });

    divAlumnos.addEventListener("click", (evt) => {
        console.log(evt.target);
        if (evt.target.tagName == "TD") {
            let row = evt.target.parentNode;
            dni.value = row.children[0].innerHTML;
            dni.disabled = true;
            nombre.value= row.children[1].innerHTML;
            direccion.value= row.children[2].innerHTML;
            botonCrear.value = "Modificar";
        }
    });

table = document.createElement("table");
for (let i = 0; i < 5; i++) {
    let row = table.insertRow(i);
    for (let j = 0; j < 5; j++) {
        let cell = row.insertCell(j);
        cell.appendChild(document.createTextNode(i+j));
    }  
}

divMensaje.appendChild(table);
}