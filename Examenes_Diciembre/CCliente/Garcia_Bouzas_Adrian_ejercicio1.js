window.onload = () => {
    document
      .getElementById("boton2")
      .addEventListener("click", imprimir_en_texto);
    document
      .getElementById("boton")
      .addEventListener("click", imprimir_arbol);
        
    document
        .getElementById("boton3")
        .addEventListener("click", imprimir_con_funciones);
  };

  function imprimir_en_texto() {
    let input_number = document.getElementById("entrada").value; //Valor del formulario
    
      // Hacemos 2 bucles
      // El primero representa el numero de filas de la piramide, de 1 al valor del usuario
      // El segundo representa el numero de elementos a mostrar, empieza siendo 1 en la primera fila y va incrementando hasta el valor del usuario
    for (let i = 1; i <= input_number; i++) {
      document.write("<p>");
      for (let j = 1; j <= i; j++) {
        document.write(j + " ");
      }
      document.write("</p>");
    }
}
  
function imprimir_con_funciones() {
    let input_number = document.getElementById("entrada").value; //Valor del formulario
    const divSalida = document.getElementById("parrafoSolucion"); // Div donde escribiremos la salida

    divSalida.innerHTML = "";

    for (let i = 1; i <= input_number; i++) {
      divSalida.insertAdjacentHTML("beforeend","<p>");
      for (let j = 1; j <= i; j++) {
        divSalida.insertAdjacentHTML("beforeend",j + " ");
      }
      divSalida.insertAdjacentHTML("beforeend","</p>");
    }

}

function imprimir_arbol() {
    let input_number = document.getElementById("entrada").value; //Valor del formulario
    const divSalida = document.getElementById("solucionTexto"); // Div donde escribiremos la salida

    for (let i = 1; i <= input_number; i++) {
        //Creamos el nodo seccion (cada fila de la salida)
        let seccion = document.createElement("div");
        seccion.classList.add("seccion");

        for (let j = 1; j <= i; j++) {
            //Creamos el nodo caja y lo vamos añadiendo a la seccion fila
            let caja = document.createElement("div");
            caja.classList.add("caja");
            caja.innerHTML = j;
            seccion.appendChild(caja);
        }
        
        // Añadimos la seccion al div de salida
        divSalida.appendChild(seccion);

        // Evento para borrar la fila cuando se hace click en una caja
        seccion.addEventListener("click", (evt) => {
            evt.target.parentNode.parentNode.removeChild(evt.target.parentNode);
        })
    }
}
