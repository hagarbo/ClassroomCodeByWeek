
window.onload = ()=>{
    document.getElementById("enviar").addEventListener("click",procesar_formulario);
}

function procesar_formulario(){

    let nombre = document.getElementById("nombre").value;
    let color = document.querySelector("select").value;
    let fuente = document.querySelector('input[name="fuente"]:checked').value;//SELECCIONAMOS EL ELEMENTO INPUT CON EL ATRIBUTO NAME = FUENTE QUE ESTE MARCADO
    let efectos = document.querySelectorAll('input[type="checkbox"]:checked');//SELECCIONAMOS LOS ELEMENTOS INPUT CON EL ATRIBUTO TYPE = CHECKBOX QUE ESTEN MARCADOS

    // ESTE VA A SER EL NODO CON EL NOMRBRE ESCRITO CON LAS OPCIONES MARCADAS EN EL FORMULARIO
    let nodoNombre = document.createElement("h1");
    nodoNombre.innerHTML = nombre;
    nodoNombre.style.color = color;
    nodoNombre.style.fontFamily = fuente;
    nodoNombre.style.fontSize = "56px";
    nodoNombre.style.fontWeight = "normal";//LE CAMBIAMOS LA NEGRITA POR DEFECTO DE H1, LUEGO SE PONE SI ESTA MARCADA
    aplicar_efectos(efectos,nodoNombre);


    // AHORA CREAMOS LA NUEVA VENTANA Y VAMOS AÑADIENDO LOS ELEMENTOS EN ELLA
    ventanita = window.open("","Ventanita_del_amor","width=400,height=400");
    ventanita_body = ventanita.document.querySelector("body");
    cabecera = ventanita.document.createElement("h1");//LOS ELEMENTOS SE CREAN EN EL DOCUMENT DE LA NUEVA VENTANA, NO FUNCIONA SIN EL DOCUMENT LO HE PROBADO :)
    cabecera.innerHTML = nombre;
    separador = ventanita.document.createElement("hr");
    botonCerrar = ventanita.document.createElement("button");
    botonCerrar.innerHTML = "Cerrar";
    botonCerrar.addEventListener("click",()=>{
        ventanita.close();
    });

    //AÑADIMOS LOS ELEMENTOS EN EL BODY DE LA VENTANA
    ventanita_body.appendChild(cabecera);
    ventanita_body.appendChild(separador);
    ventanita_body.appendChild(nodoNombre);
    ventanita_body.appendChild(botonCerrar);
    
}

function aplicar_efectos(efectos, nodoNombre){
    efectos.forEach(element => {
        if (element.name == "tachado") 
            nodoNombre.style.textDecoration = "line-through";
        else if (element.name == "negrita")
            nodoNombre.style.fontWeight = "bolder";
        else if (element.name == "cursiva")
            nodoNombre.style.fontStyle = "italic";
        else if (element.name == "versalita")
            nodoNombre.style.fontVariant = "small-caps";
        else if (element.name == "subrayado")
            nodoNombre.style.textDecoration = "underline";
    });
}

