"use strict";

function ruta_absoluta(ruta_relativa) {
    let obtenerUrlActual = window.location;
    console.log(obtenerUrlActual);

    //Obtener la ruta de los archivos
    var ficheroArray = obtenerUrlActual.toString().split("/");
    let long = ficheroArray.length;

    console.log("Nombre de fichero " + ficheroArray[long - 1]);

    // Obtener el nombre del fichero
    let namefichero = ficheroArray[long - 1];

    var idURL = obtenerUrlActual.toString().split(namefichero);
    console.log(idURL[0]);

    let ruta = idURL[0].toString().concat(ruta_relativa);
    console.log("Acceder al fichero json " + ruta);
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
    nombre.innerHTML = user.first_name + " " + user.last_name;
    nombre.classList.add("card-title");
    let email = document.createElement("p");
    email.innerHTML = user.email;
    email.classList.add("card-text");
    let ciclo = document.createElement("p");
    ciclo.innerHTML = user.id_ciclo;
    ciclo.classList.add("card-text");
    cardBody.appendChild(nombre);
    cardBody.appendChild(email);

    card.appendChild(cardBody);
    return card;
}

window.onload = () => {
    var div_usuarios = document.querySelector("#usuarios");
    div_usuarios.style.display = "flex";
    // .Ofrece una API para acceder a recursos tipicos como usuarios, mensajes de un foro y fotos
    var usuarios = [];
    //fetch('https://jsonplaceholder.typicode.com/users')
    fetch(ruta_absoluta("users.json"))
        .then((data) => data.json())
        .then((users) => {
            usuarios = users.data;
            console.log(usuarios);
            //Crea un nuevo array con los resultadosde la función
            usuarios.map((user) => {
                let card = create_card(user);
                div_usuarios.appendChild(card);
            });
        });
};
