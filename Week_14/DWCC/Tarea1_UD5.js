window.onload = () => {
  document.querySelector("#crear").addEventListener("click", crear_tabla);

  function crear_tabla() {
    num_filas = document.querySelector("#fila").value;
      num_columnas = document.querySelector("#columna").value;
      
      resultado = document.querySelector("#resultado");

      resultado.addEventListener("click", procesar_click);
      resultado.addEventListener("contextmenu", procesar_click_derecho);
      resultado.addEventListener("dblclick", procesar_doble_click);


      if (!isNaN(parseInt(num_filas)) && !isNaN(parseInt(num_columnas))) {
      tabla = document.createElement("table");
      tabla.style.border = "5px solid orange";

      for (let row = 0; row < num_filas; row++) {
        let fila = document.createElement("tr");

        for (let col = 0; col < num_columnas; col++) {
          let celda = document.createElement("td");
          celda.innerHTML = row;
            celda.style.border = "5px solid yellow";
            celda.style.fontSize = "30px";
          fila.appendChild(celda);
        }

        tabla.appendChild(fila);
      }
          resultado.appendChild(tabla);
          crear_boton_borrar();
          document.querySelector("#crear").disabled = true;
        
    }
    }

    function crear_boton_borrar() {
        boton = document.querySelector("#borrar");
        if (boton == null) {
            caja_borrar = document.createElement("li");
            boton_borrar = document.createElement("button");
            boton_borrar.type = "button";
            boton_borrar.name = "borrar";
            boton_borrar.id = "borrar";
            boton_borrar.innerHTML = "Borrar Tabla";
            boton_borrar.addEventListener("click", borrar_tabla);

            caja_borrar.appendChild(boton_borrar);
            document.querySelector("ul").appendChild(caja_borrar);
        }
        else boton.disabled = false;
          
    }
    
    function borrar_tabla() {
        document.querySelector("#borrar").disabled = true;
        document.querySelector("#crear").disabled = false;
        document.querySelector("#resultado").innerHTML = "";
    }

    function procesar_click(e) {
        if (e.target.tagName=="TD")
        {
            e.target.style.backgroundColor = "blue";
            e.stopPropagation();
        }
    }

    function procesar_click_derecho(e) {
        e.preventDefault();
        if (e.target.tagName=="TD")
        {
            e.target.style.color = "red";
            e.stopPropagation();
        }
    }

    function procesar_doble_click(e) {
        if (e.target.tagName == "TR")
            e.target.parentNode.removeChild(e.target);
    }
};
