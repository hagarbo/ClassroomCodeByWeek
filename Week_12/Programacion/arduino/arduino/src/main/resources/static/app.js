const updateColor = async() => {
    const response = await fetch('http://localhost:8080/api/color');
    response.text()
    .then(data => document.getElementById("color").innerHTML = data)
    .then(data => console.log(data))
    .catch(error => console.log(error));
}

const getMessage = async () => {
        const response = await fetch('http://localhost:8080/api/');
        response.text()
            .then(data => document.getElementById("message").innerHTML = data)
            .then(data => console.log(data))
            .catch(error => console.log(error));
    
}

const update = async () => {
	updateColor()
	
}
getMessage();
update();
