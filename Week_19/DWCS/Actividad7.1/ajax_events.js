
window.onload = () => {
    
    const botonRegisterOK = document.getElementById("register_succesful");
    const botonRegisterNoOK = document.getElementById("register_fail");
    const botonLoginOK = document.getElementById("login_ok");
    const botonLoginNoOK = document.getElementById("login_fail");
    const botonPut = document.getElementById("put");

    botonRegisterOK.addEventListener("click", register_succesful);
    botonRegisterNoOK.addEventListener("click", register_unsuccesful);
    botonLoginOK.addEventListener("click", login_succesful);
    botonLoginNoOK.addEventListener("click", login_unsuccesful);
    botonPut.addEventListener("click", put);

}

function register_succesful() {

    object = {
        "email": "eve.holt@reqres.in",
        "password": "pistol"
    };
    sendPost('https://reqres.in/api/register', object,'POST');

}

function register_unsuccesful() {

    object = {
        "email": "sydney@fife",
    };
    sendPost('https://reqres.in/api/register', object,'POST');
}

function login_succesful() {

    object = {
        "email": "eve.holt@reqres.in",
        "password": "cityslicka"
    }
    sendPost('https://reqres.in/api/login', object,'POST');
    
}

function login_unsuccesful(){
    object = {
        "email": "peter@klaven"
    };
    sendPost('https://reqres.in/api/login', object,'POST');
}

function put() {
    object = {
        "name": "morpheus",
        "job": "zion resident"
    };
    id = 2;
    sendPost(`https://reqres.in/api/users/${id}`, object,'PUT');
}

function sendPost(url, jsonObject, httpMethod) {
    
    fetch(url, {
        method: httpMethod,
        body: JSON.stringify(jsonObject),
        headers: {
            'Content-type': 'application/json; charset=UTF-8'
        }
    })
        .then((response) => response.json())
        .then((json) => {
            console.log(json);
            let usersSection = document.getElementById("resultado");
            let ulElement = document.createElement("ul");

            // Iterate through the object json
            for (const key in json) {
                if (json.hasOwnProperty(key)) {
                    //Template literals are enclosed in backticks (`) instead of single or double quotes. They allow you to embed expressions directly within the string using placeholders, denoted by ${expression}. The dollar sign followed by curly braces ${} is used to evaluate and embed expressions dynamically in template literals.
                    console.log(`${key}: ${json[key]}`);
                    let liElement = document.createElement("li");
                    liElement.innerHTML = `${key}: ${json[key]}`;
                    ulElement.appendChild(liElement);
                }
            }
           
            usersSection.appendChild(ulElement);

        })
        .catch((err) => console.error("error:", err));
}