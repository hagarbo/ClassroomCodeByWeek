/* 
1.	Base de datos Tienda Informática (2 tablas). */

use tienda;

/* Muestra los nombres y precios en euros de todos los productos. */

SELECT nombre, precio as "Precio €" FROM producto;

/* Muestra todos los comerciales. */

SELECT * FROM fabricante;

/* Muestra los nombres en mayúsculas  y precios de todos los productos. */

SELECT UPPER(nombre), precio FROM producto;


2.	Base de datos Gestión de Empleados (2 tablas).
Muestra los datos de todos los Empleados.

Muestra el código y el nombre de todos los departamentos de la empresa.

Muestra los primeros apellidos sin repetición de los Empleados.

Muestra el nombre del departamento y su presupuesto.


3.	Base de datos Gestión de Ventas (3 tablas).
Muestra de todos los clientes.

Muestra nombre y apellidos de los clientes.

Muestra de todos los comerciales.

Muestra nombre y apellidos de los clientes.

Muestra todos los pedidos realizados.


/* 4.	Base de datos NBA (4 tablas). */

use nba;

/* Muestra todas las tablas de la base de datos NBA. */

showtables;

/* Muestra todos los datos de cada tabla de la base de datos NBA. */

/* Muestra el nombre y la división de cada Equipo. */

/* Muestra el número de tapones por partido de cada jugador y temporada 
de la tabla Estadisticas. */

SELECT jugador, Tapones_por_partido, temporada 
FROM estadisticas;

/* Muestra el nombre y de donde procede de cada Jugador. */

SELECT nombre, procedencia FROM jugadores;

/* Muestra temporada, equipo local y puntuación, y equipo visitante y puntuación
de la tabla Partidos. */

SELECT temporada, equipo_local, puntos_local, 
        equipo_visitante, puntos_visitante 
FROM partidos;

5.	Base de datos DepartamentoOficinas (5 tablas).
Muestra toda la información de la tabla empleados.

Muestra toda la información de la tabla departamento.

Muestra el código y nombre de las categorías del personal.


/* 6.	Base de datos Jardinería (8 tablas). */

/* Muestra el nombre del cliente y el nombre completo del contacto. */

SELECT nombre_cliente, CONCAT(nombre_contacto, " ", apellido_contacto)
FROM cliente;

Muestra los detalles de todos los productos contenidos en la tabla detalle_pedido.

Muestra el nombre, apellidos, email y puesto de cada empleado.

Muestra el tipo de gama de producto y su descripción.

Muestra el código de cada oficina junto con la ciudad en la que está.

Muestra el detalle de todos los pagos.

Muestra el detalle de todos los pedidos.

/* Muestra el detalle de todos los productos, salvo su código. */

SELECT nombre, gama, dimensiones, proveedor, descripcion, cantidad_en_stock, precio_venta, precio_proveedor
FROM producto;