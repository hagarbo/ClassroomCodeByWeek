"use strict";

function ruta_absoluta(ruta_relativa) {
    let obtenerUrlActual = window.location;
    //console.log(obtenerUrlActual);

    //Obtener la ruta de los archivos
    var ficheroArray = obtenerUrlActual.toString().split("/");
    let long = ficheroArray.length;

    // Obtener el nombre del fichero
    let namefichero = ficheroArray[long - 1];

    var idURL = obtenerUrlActual.toString().split(namefichero);
    //console.log(idURL[0]);

    let ruta = idURL[0].toString().concat(ruta_relativa);
    //console.log("Acceder al fichero json " + ruta);
    return ruta;
}

function create_card(user) {
    let card = document.createElement("div");
    card.classList.add("card");
    card.style.width = "18rem";

    let imagen = document.createElement("img");
    imagen.src = user.avatar;
    imagen.classList = "card-img-top";
    card.appendChild(imagen);

    let cardBody = document.createElement("div");
    cardBody.classList.add("card-body");
    let nombre = document.createElement("h5");
    nombre.innerHTML = user.alumno;
    nombre.classList.add("card-title");
    let email = document.createElement("p");
    email.innerHTML = user.email;
    email.classList.add("card-text");
    let ciclo = document.createElement("p");
    ciclo.innerHTML = user.nombreciclo;
    ciclo.classList.add("card-text");
    cardBody.appendChild(nombre);
    cardBody.appendChild(email);
    cardBody.appendChild(ciclo);

    card.appendChild(cardBody);
    return card;
}

var ciclos = [];
//Crear una promesa desde cero para obtener la información del ciclo asociado a su id
const getciclos = async (id) => {

    try {
        const data = await fetch(ruta_absoluta("ciclos.json"));
        const jsonData = await data.json();
        return await new Promise((resolve, reject) => {
            let ciclos = jsonData.data;
            var profesor_string = " ";

            setTimeout(function () {

                const ciclo = ciclos.find(c => c.id == id);
                (ciclo) ? resolve(ciclo) :
                    reject(`No hay alumnos en el ciclo con id ${id}`);
            }, 3000);
        });
    } catch (err) {
        return console.log(err);
    }

    
};

function guardarAlumnoLocal(id, nombre,mail, ciclo, avatar) {
    let alumno = {
        "id": id,
        "alumno": nombre,
        "email": mail,
        "nombreciclo": ciclo,
        "avatar":avatar
    };
    localStorage.setItem(id, JSON.stringify(alumno));
}

function imprimirLocalStorage(div_usuarios) {
    Object.keys(localStorage).forEach(key => {
        let user = JSON.parse(localStorage.getItem(key));
        let card = create_card(user);
        div_usuarios.appendChild(card);
    })
}

window.onload = () => {
    const div_usuarios = document.querySelector("#usuarios");
    div_usuarios.style.display = "flex";
    let usuarios = [];

    fetch(ruta_absoluta("users.json"))
        .then((data) => data.json())
        .then((users) => {
            usuarios = users.data;
            console.log(usuarios);
            
            //Crea un nuevo array con los resultadosde la función
            usuarios.map((user) => {
                getciclos(user.id_ciclo)
                    .then(ciclo => {
                        guardarAlumnoLocal(user.id, user.first_name + " " + user.last_name,user.email, ciclo.nombre,user.avatar);
                    })
                    .catch(err => console.log(err));  
            });
        });
    imprimirLocalStorage(div_usuarios);
};
