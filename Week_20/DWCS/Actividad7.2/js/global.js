
const base_url = "http://localhost:3000/controller/FrontController.php";
var userId = null;

window.onload = onceLoaded;


function onceLoaded() {

    console.debug("window loaded");
    document.querySelector('#formLogin').onsubmit = confirmLoginJSON;
    document.querySelector('#formLogout').onsubmit = confirmLogout;

    
    getRoles();
}

