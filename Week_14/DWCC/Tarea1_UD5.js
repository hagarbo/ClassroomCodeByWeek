window.onload = () => {
  // Variables

  let boton_crear = document.querySelector("#crear");
  let div_resultado = document.querySelector("#resultado");
  let id_boton_borrar = "borrar";

  boton_crear.addEventListener("click", () => {
    num_filas = document.querySelector("#fila").value;
    num_columnas = document.querySelector("#columna").value;

    // Comprobamos que nos pasen numeros para crear la tabla
    if (!isNaN(parseInt(num_filas)) && !isNaN(parseInt(num_columnas))) {
      tabla = crear_tabla(num_filas, num_columnas);
      div_resultado.appendChild(tabla);
      let boton_borrar = document.querySelector("#" + id_boton_borrar);
      boton_borrar == null
        ? crear_boton_borrar(boton_crear, div_resultado)
        : (boton_borrar.disabled = false);
      boton_crear.disabled = true;

      // Añadimos los manejadores de eventos
      div_resultado.addEventListener("click", procesar_click);
      div_resultado.addEventListener("contextmenu", procesar_click_derecho);
      div_resultado.addEventListener("dblclick", procesar_doble_click);
    }
  });
};

function crear_tabla(num_filas, num_columnas, resultado) {
  tabla = document.createElement("table");
  tabla.style.border = "5px solid aquamarine";

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

  return tabla;
}

function crear_boton_borrar(boton_crear, div_resultado) {
  caja_borrar = document.createElement("li");
  boton_borrar = document.createElement("button");
  boton_borrar.type = "button";
  boton_borrar.name = "borrar";
  boton_borrar.id = "borrar";
  boton_borrar.innerHTML = "Borrar Tabla";
  boton_borrar.addEventListener("click", function () {
    borrar_tabla(boton_borrar, boton_crear, div_resultado);
  });

  caja_borrar.appendChild(boton_borrar);
  document.querySelector("ul").appendChild(caja_borrar);
}

function borrar_tabla(boton_borrar, boton_crear, resultado) {
  boton_borrar.disabled = true;
  boton_crear.disabled = false;
  resultado.innerHTML = "";
}

function procesar_click(e) {
  if (e.target.tagName == "TD") e.target.style.backgroundColor = "aquamarine";
}

function procesar_click_derecho(e) {
  e.preventDefault();
  if (e.target.tagName == "TD") e.target.style.color = "red";
}

function procesar_doble_click(e) {
  if (e.target.tagName == "TD") {
    fila = e.target.parentNode;
    fila.parentNode.removeChild(fila);
  }
}
