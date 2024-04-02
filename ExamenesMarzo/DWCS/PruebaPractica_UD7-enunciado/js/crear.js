





function validarTitulo() {
    //TODO: 2- Completa la función validarTitulo() ya proporcionada en el 
    // archivo crear.js dentro de la carpeta js para que devuelva true solo 
    // cuando el valor del input del formulario que alberga el título de la 
    // nota en  index.php  sea igual a la constante TITULO_PERMITIDO y false 
    // en caso contrario. (1 punto)
    const tituloInput = document.getElementById("title");
    return (tituloInput.value === TITULO_PERMITIDO) ? true : false;
}

function crearNotaApiRemota() {
    //TODO: 3- Completa la función crearNotaApiRemota() ya proporcionada en el 
    // archivo crear.js  de la carpeta js   para que, utilizando el API de Fetch, 
    // realice una petición POST con el título introducido en el formulario  enviando a 
    // REMOTE_API_URL un objeto JSON:

    const titulo = document.getElementById("title").value;

    //preparamos los datos que se enviarían al servidor como si se enviasen  por POST  desde el formulario
    const data = {
        "title": titulo
    };

    const request = new Request(REMOTE_API_URL, {
        method: "POST",
        body: JSON.stringify(data)
    });

    fetch(request)
            .then((response) => {
                if (response.status === 201) {
                    return response.json();
                } else if ((response.status === 400) || (response.status===401)) {
                    console.log('error 400');
                    return false;
                } else {
                    console.log("Something went wrong on API server!");
                    return false;
                }

            })
            .then((response) => {
                console.log(response);
                try {
                    if (response === false) {
                        showMsg("<br/> Ha habido un error creando la nota en remoto: ", true, "div-msg", false);
                    }
                    else
                    {
                        showMsg("<br/> Se ha creado en remoto la nota : " + JSON.stringify(response, null, 10), true, "div-msg", false);
                        confirmCrearNotaLocal(response);
                    }
                } catch (error) {
                    console.log(error);
                }
                
            }
            )
            .catch((error) => {
                console.error('Ha ocurrido un error' + error);
            });
 
}

function confirmCrearNotaLocal(data) {
    //TODO: 4- Completa la función  confirmCrearNotaLocal(data) ya proporcionada en 
    // crear.js para que muestre un diálogo modal preguntando al usuario si quiere crear 
    // una nota en el servidor local, mediante NotaController y su método create.Si el usuario 
    // confirma su voluntad de crear una nota en el servidor local, deberá llamarse a 
    // crearNotaLocal(data), enviando los datos que se recibieron originalmente de la Api remota.
    // (2 puntos)
    const modal = "modal";
    const tituloMsg = "Confirmación creación en local";
    const mensaje = "Va usted a crear una nueva nota en el servidor local, ¿está usted seguro/a?";
    showModal(modal, tituloMsg , mensaje, null,
        null, () => {
            crearNotaLocal(data);
        } , null);
}

function crearNotaLocal(nota) {

    //TODO:  6-  Completa la función crearNotaLocal(nota) ya proporcionada en el archivo crear.js para que cree una variable con los datos title, createdAt, updatedAt y completed (todos salvo el id) de la nota creada en la Api remota y se reciban en NotaController.php en el array superglobal $_POST como si fueran enviados en un formulario html (no se enviarán como objeto JSON). (2 puntos)
    console.log(nota);

    const data = new FormData();
    data.append('title', nota.title);
    data.append('createdAt', nota.createdAt);
    data.append('updatedAt', nota.updatedAt);
    data.append('completed', nota.completed);

    const request = new Request(LOCAL_BACKEND_URL, {
        method: "POST",
        body: data
    });

    fetch(request)
        .then(response => response.json())
        .then(data => {

            if (data.id) {
                showMsg("<br/> Se ha creado localmente la nota : " + JSON.stringify(data, null, 10), true, "div-msg", true);
            }
            else {
                showMsg("<br/> Ha habido un error creando la nota localmente: " + data.error, true, "div-msg", true);
            }

        })
        .catch(error => console.error("Ha ocurrido un error" + error));

}