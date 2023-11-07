const botonSubmit = document.querySelector("#boton");


botonSubmit.addEventListener("click",procesarFormulario)

function procesarFormulario(){
    let birthDate = document.querySelector("#fechaNacimiento").valueAsDate;
    let fecha = new Date();
    console.log(milisecondsToYears(fecha-birthDate));

    let mensaje = document.createElement("h2");
    mensaje.innerHTML="Tienes: "+milisecondsToYears(fecha-birthDate)+ " años";

    document.querySelector("#resultado").append(mensaje);
}

function milisecondsToYears(ms){
    return Math.floor(ms/(1000*3600*24*365));
}