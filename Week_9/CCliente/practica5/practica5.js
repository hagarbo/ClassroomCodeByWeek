

const birthDateButton = document.querySelector("#botonNacimiento");
const eventButton = document.querySelector("#botonEvento");
const hoy = new Date();
let maxDate = new Date();
maxDate = setFullYear( maxBirthdayDate.getFullYear() - 18 );
document.querySelector("#fechaNacimiento").max = maxDate;

birthDateButton.addEventListener("click",calcularEdad(hoy));
eventButton.addEventListener("click",calcularCuentaAtras(hoy));

/* Ejercicio 2: Solicitar al usuario la fecha de su nacimiento y calcular su edad. */

function calcularEdad(hoy){
    let birthDate = document.querySelector("#fechaNacimiento").valueAsDate;
    console.log(milisecondsToYears(hoy-birthDate));

    let mensaje = document.createElement("h2");
    mensaje.innerHTML="Tienes: "+milisecondsToYears(hoy-birthDate)+ " años";

    document.querySelector("#resultado").append(mensaje);
}

/* Ejercicio3: Solicitar al usuario la fecha de un evento determinado y calcular los días que
quedan hasta el día del evento. */

function calcularCuentaAtras(hoy){
    let fechaEvento = document.querySelector("#fechaEvento").valueAsDate;
    
    let mensaje = document.createElement("h2");
    mensaje.innerHTML="Quedan: "+milisecondsToDays(fechaEvento-hoy)+" días para el evento";
}


/* FUNCIONES AUXILIARES */
function milisecondsToYears(ms){
    return Math.floor(ms/(1000*3600*24*365));
}

function milisecondsToDays(ms){
    return Math.floor(ms/24*3600*1000);
}

function yearsToMiliseconds(years){
    return 365*24*3600*1000*years;
}