var saludar = new Promise((resolve, reject) => {
    setTimeout(() => {
        let saludo = "Hola que tal";
        saludo = null;
        if (saludo) {
            resolve(saludo);
        }
        else {
            reject("No hay saludo disponible");
        }
    }, 2000);
});

saludar
    .then(resultado => {
        alert(resultado);
    })
    .catch(err => {
        alert(err);
    });