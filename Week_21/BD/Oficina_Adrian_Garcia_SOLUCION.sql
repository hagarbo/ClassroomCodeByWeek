#---------------------------------------------------------------------------------------
#	CREACIÓN DE LA BASE DE DATOS Empresa
#---------------------------------------------------------------------------------------
DROP DATABASE IF EXISTS Empresa;

CREATE DATABASE Empresa;

USE Empresa;

#---------------------------------------------------------------------------------------
#	CREACIÓN DE LAS TABLAS
#---------------------------------------------------------------------------------------
CREATE TABLE
  Oficina (
    idOficina INT AUTO_INCREMENT,
    nombreOficina VARCHAR(50),
    numeroOficina INT,
    dimension INT,
    ubicacion VARCHAR(50),
    numeroMesas INT,
    CONSTRAINT LlavePrimaria_Oficina PRIMARY KEY (idOficina),
    CONSTRAINT nombreOficinaNoNula CHECK (nombreOficina IS NOT NULL),
    CONSTRAINT numeroOficinaNoNulo CHECK (numeroOficina IS NOT NULL),
    CONSTRAINT dimensiónNoNula CHECK (dimension IS NOT NULL),
    CONSTRAINT ubicaciónNoNula CHECK (ubicacion IS NOT NULL),
    CONSTRAINT numeroMesasNoNulo CHECK (numeroMesas IS NOT NULL),
    CONSTRAINT NombreOficinaNoVacía CHECK (nombreOficina != ''),
    CONSTRAINT ubicacionNoVacía CHECK (ubicacion != ''),
    CONSTRAINT numeroOficinaIncorrecto CHECK (numeroOficina >= 1000),
    CONSTRAINT dimensionNoNegativa CHECK (dimension > 0),
    CONSTRAINT numeroMesasNoNegativo CHECK (numeroMesas > 0),
    CONSTRAINT nombreOficinaRepetido UNIQUE (nombreOficina),
    CONSTRAINT numeroOficinaRepetido UNIQUE (numeroOficina)
  );

CREATE TABLE
  Empleado (
    idEmpleado INT AUTO_INCREMENT,
    NIFEmpleado VARCHAR(9),
    nombreEmpleado VARCHAR(50),
    apellidosEmpleado VARCHAR(50),
    fechaIncorporacion DATE,
    CONSTRAINT LlavePrimaria_Empleado PRIMARY KEY (idEmpleado),
    CONSTRAINT nombreEmpleadoNoNulo CHECK (nombreEmpleado IS NOT NULL),
    CONSTRAINT NIFEmpleadoNoNulo CHECK (NIFEmpleado IS NOT NULL),
    CONSTRAINT apellidosEmpleadoNoNulo CHECK (apellidosEmpleado IS NOT NULL),
    CONSTRAINT fechaIncorporacionNoNula CHECK (fechaIncorporacion IS NOT NULL),
    CONSTRAINT NIFEmpleadoNoVacío CHECK (NIFEmpleado != ''),
    CONSTRAINT nombreEmpleadoNoVacío CHECK (nombreEmpleado != ''),
    CONSTRAINT apellidosEmpleadoNoVacío CHECK (apellidosEmpleado != ''),
    CONSTRAINT NIFDuplicado UNIQUE (NIFEmpleado)
  );

CREATE TABLE
  Contratacion (
    idContratacion INT AUTO_INCREMENT,
    tipoContrato VARCHAR(40),
    inicioContratacion DATE,
    finContratacion DATE,
    Empleado INT,
    Oficina INT,
    puestoTrabajo VARCHAR(50),
    Jefe INT,
    CONSTRAINT PK_Contratacion PRIMARY KEY (idContratacion),
    CONSTRAINT FK_Contratacion_Empleado FOREIGN KEY (empleado) REFERENCES Empleado (idEmpleado),
    CONSTRAINT FK_Contratacion_Oficina FOREIGN KEY (oficina) REFERENCES Oficina (idOficina),
    CONSTRAINT FK_Contratacion_Jefe FOREIGN KEY (jefe) REFERENCES Empleado (idEmpleado),
    CONSTRAINT tipoContratoNoNulo CHECK (tipoContrato IS NOT NULL),
    CONSTRAINT inicioContratacionNoNulo CHECK (inicioContratacion IS NOT NULL),
    CONSTRAINT empleadoNoNulo CHECK (empleado IS NOT NULL),
    CONSTRAINT oficinaNoNula CHECK (oficina IS NOT NULL),
    CONSTRAINT puestoTrabajoNoNulo CHECK (puestoTrabajo IS NOT NULL),
    CONSTRAINT tipoContratoNoVacío CHECK (tipoContrato != ''),
    CONSTRAINT puestoTrabajoNoVacío CHECK (puestoTrabajo != '')
  );

CREATE TABLE
  Salario (
    idSalario INT AUTO_INCREMENT,
    puestoTrabajo VARCHAR(50),
    sueldoBase INT,
    incrementoAnual INT,
    productividad INT,
    CONSTRAINT PK_Salario PRIMARY KEY (idSalario),
    CONSTRAINT Salario_puestoTrabajoNoNulo CHECK (puestoTrabajo IS NOT NULL),
    CONSTRAINT Salario_sueldoBaseNoNulo CHECK (sueldoBase IS NOT NULL),
    CONSTRAINT Salario_incrementoAnual CHECK (incrementoAnual IS NOT NULL),
    CONSTRAINT Salario_productividad CHECK (productividad IS NOT NULL),
    CONSTRAINT Salario_puestoTrabajoNoVacío CHECK (puestoTrabajo != ''),
    CONSTRAINT Salario_sueldoBaseNoNegativo CHECK (sueldoBase >= 0),
    CONSTRAINT Salario_incrementoAnualNoNegativo CHECK (incrementoAnual >= 0),
    CONSTRAINT Salario_productividadNoNegativa CHECK (productividad >= 0),
    CONSTRAINT Salario_sueldoBaseNoCero CHECK (sueldoBase != 0),
    CONSTRAINT Salario_incrementoAnualNoCero CHECK (incrementoAnual != 0)
  );

#---------------------------------------------------------------------------------------
#---------------------------------------------------------------------------------------
#	CONVIERTE LOS INSERT DE CADA UNA DE LAS TABLAS EN LOS PROCEDIMIENTOS ESPECIFICADOS
#	EN LOS PASOS SIGUIENTES:
#		-	El procedimiento de los pasos del 5 al 8 es para agregar CADA tupla de cada una de las tablas
#		-	El procedimiento de los pasos 2 al 4 es para agregar TODAS las tuplas de cada una de las tablas
#		-	El procedimiento del paso 1 es para invocar a los cuatro siguientes procedimientos
#---------------------------------------------------------------------------------------
#---------------------------------------------------------------------------------------
#---------------------------------------------------------------------------------------
#---------------------------------------------------------------------------------------
#	1. Procedimiento agregarDatosEmpresa
#		Agregamos los datos de las cuatro tablas
#---------------------------------------------------------------------------------------
DELIMITER //
DROP PROCEDURE IF EXISTS agregarDatosEmpresa //
CREATE PROCEDURE agregarDatosEmpresa ()
BEGIN
   CALL agregarOficinas();

	CALL agregarEmpleados();

	CALL agregarContratos();
	
	CALL agregarSalarios();
END // 
DELIMITER ; 

#---------------------------------------------------------------------------------------
#	2. Procedimiento agregarOficinas - AGREGAMOS LAS OCHO OFICINAS
#---------------------------------------------------------------------------------------
DELIMITER //
DROP PROCEDURE IF EXISTS agregarOficinas //
CREATE PROCEDURE agregarOficinas ()
BEGIN
CALL agregarOficina ("Direccion", 1000, 50, "Planta 1", 2);

CALL agregarOficina ("RRHH", 8000, 50, "Planta 1", 6);

CALL agregarOficina ("Nóminas", 3600, 50, "Planta 1", 4);

CALL agregarOficina ("Atención al Cliente", 1007, 50, "Planta 1", 9);

CALL agregarOficina ("Ventas", 1001, 50, "Planta 1", 8);

CALL agregarOficina ("Compras", 1002, 50, "Planta 1", 5);

CALL agregarOficina ("Desarrollo Producto", 3505, 50, "Planta 1", 7);

CALL agregarOficina ("Reuniones", 4040, 50, "Planta 1", 6);

END // 
DELIMITER ;

#---------------------------------------------------------------------------------------
#	3. Procedimiento agregarEmpleados - AGREGAMOS LOS 48 EMPLEADOS
#---------------------------------------------------------------------------------------
DELIMITER //
DROP PROCEDURE IF EXISTS agregarEmpleados //
CREATE PROCEDURE agregarEmpleados ()
BEGIN
CALL agregarEmpleado ("42345678A", "Fulgencio", "Malatraba Uñíquez", "2024-02-01");

CALL agregarEmpleado ("62345678A", "Fulgencia", "Bienhallada Perfecta", "2024-02-01");

CALL agregarEmpleado ("81111111A", "María", "López García", "2024-02-01");

CALL agregarEmpleado ("82222222B", "Juan", "Martínez Ruiz", "2024-02-02");

CALL agregarEmpleado ("63333333C", "Ana", "Sánchez Rodríguez", "2024-02-02");

CALL agregarEmpleado ("64444444D", "Carlos", "Fernández López", "2024-02-02");

CALL agregarEmpleado ("45555555E", "Laura", "González Martínez", "2024-02-02");

CALL agregarEmpleado ("76666666F", "David", "Pérez García", "2024-02-05");

CALL agregarEmpleado ("67777777G", "Sara", "Ruiz Sánchez", "2024-02-05");

CALL agregarEmpleado ("88888888H", "Javier", "Díaz Martínez", "2024-02-03");

CALL agregarEmpleado ("89999999I", "Elena", "López Pérez", "2024-02-05");

CALL agregarEmpleado ("70101010J", "Pedro", "García Ruiz", "2024-02-05");

CALL agregarEmpleado ("62121212K", "Marta", "Sánchez López", "2024-02-10");

CALL agregarEmpleado ("63131313L", "Roberto", "Martínez Sánchez", "2024-02-10");

CALL agregarEmpleado ("74141414M", "Carmen", "López Martínez", "2024-02-05");

CALL agregarEmpleado ("65151515N", "Daniel", "Sánchez Pérez", "2024-02-05");

CALL agregarEmpleado ("86161616O", "Paula", "Martínez García", "2024-02-09");

CALL agregarEmpleado ("47171717P", "Diego", "González Sánchez", "2024-02-09");

CALL agregarEmpleado ("58181818Q", "Lucía", "Pérez López", "2024-02-13");

CALL agregarEmpleado ("79191919R", "Adrián", "Sánchez Ruiz", "2024-02-14");

CALL agregarEmpleado ("60202020S", "Eva", "Martínez López", "2024-02-05");

CALL agregarEmpleado ("81212121T", "Marcos", "González Pérez", "2024-02-05");

CALL agregarEmpleado ("73232323U", "María José", "García López", "2024-02-12");

CALL agregarEmpleado ("84343434V", "Juan Antonio", "Martínez Gómez", "2024-02-10");

CALL agregarEmpleado ("55454545W", "Ana María", "Sánchez Rodríguez", "2024-02-15");

CALL agregarEmpleado ("76565656X", "Carlos Alberto", "Fernández López", "2024-02-17");

CALL agregarEmpleado ("57676767Y", "Laura Isabel", "González Martínez", "2024-02-25");

CALL agregarEmpleado ("38787878Z", "David Alejandro", "Pérez García", "2024-02-08");

CALL agregarEmpleado ("39898989A", "Sara Lucía", "Ruiz Sánchez", "2024-02-12");

CALL agregarEmpleado ("40909090B", "Javier Miguel", "Díaz Martínez", "2024-02-05");

CALL agregarEmpleado ("22121212C", "Elena Patricia", "López Pérez", "2024-02-15");

CALL agregarEmpleado ("33232323D", "Pedro José", "García Ruiz", "2024-02-05");

CALL agregarEmpleado ("34343434E", "Marta María", "Sánchez López", "2024-02-06");

CALL agregarEmpleado ("45454545F", "Roberto Antonio", "Martínez Sánchez", "2024-02-07");

CALL agregarEmpleado ("46565656G", "Carmen Isabel", "López Martínez", "2024-02-07");

CALL agregarEmpleado ("37676767H", "Daniel Alejandro", "Sánchez Pérez", "2024-02-11");

CALL agregarEmpleado ("38787878I", "Paula María", "Martínez García", "2024-02-13");

CALL agregarEmpleado ("29898989J", "Diego José", "González Sánchez", "2024-02-22");

CALL agregarEmpleado ("30909090K", "Lucía Antonia", "Pérez López", "2024-03-01");

CALL agregarEmpleado ("20101010L", "Adrián Manuel", "Sánchez Ruiz", "2024-03-03");

CALL agregarEmpleado ("41212121M", "Eva María", "Martínez López", "2024-03-05");

CALL agregarEmpleado ("31313131N", "Marcos Antonio", "González Pérez", "2024-03-05");

END // 
DELIMITER ;

#---------------------------------------------------------------------------------------
#	3. Procedimiento agregarContratos - AGREGAMOS LOS 48 EMPLEADOS
#---------------------------------------------------------------------------------------
DELIMITER //
DROP PROCEDURE IF EXISTS agregarContratos //
CREATE PROCEDURE agregarContratos ()
BEGIN
CALL agregarContratacion ('Indefinido', "2024-02-01", NULL, 1, 1, 'Director', NULL);

CALL agregarContratacion ('Indefinido', "2024-02-01", NULL, 2, 2, 'Jefe de Recursos Humanos', 1);

CALL agregarContratacion ('Indefinido', "2024-02-01", NULL, 3, 3, 'Jefe de Nóminas', 1);

CALL agregarContratacion ('Indefinido', "2024-02-02", NULL, 4, 4, 'Jefe de Atención al Cliente', 1);

CALL agregarContratacion ('Indefinido', "2024-02-02", NULL, 5, 5, 'Jefe de Ventas', 1);

CALL agregarContratacion ('Indefinido', "2024-02-02", NULL, 6, 6, 'Jefe de Compras', 1);

CALL agregarContratacion ('Indefinido', "2024-02-02", NULL, 7, 7, 'Jefe de Desarrollo de Productos', 1);

CALL agregarContratacion ('Indefinido', "2024-02-05", NULL, 8, 8, 'Jefe de Reuniones', 1);

CALL agregarContratacion ('Indefinido', "2024-02-06", NULL, 9, 1, 'Secretario del Director', 1);

CALL agregarContratacion ('Indefinido', "2024-02-04", NULL, 10, 2, 'Trabajador de Recursos Humanos', 2);

CALL agregarContratacion ('Indefinido', "2024-02-05", NULL, 11, 2, 'Trabajador de Recursos Humanos', 2);

CALL agregarContratacion ('Indefinido', "2024-02-05", NULL, 12, 2, 'Trabajador de Recursos Humanos', 2);

CALL agregarContratacion ('Indefinido', "2024-02-12", NULL, 13, 2, 'Trabajador de Recursos Humanos', 2);

CALL agregarContratacion ('Indefinido', "2024-02-12", NULL, 14, 2, 'Trabajador de Recursos Humanos', 2);

CALL agregarContratacion ('Indefinido', "2024-02-08", NULL, 15, 3, 'Trabajador de Nóminas', 3);

CALL agregarContratacion ('Indefinido', "2024-02-08", NULL, 16, 3, 'Trabajador de Nóminas', 3);

CALL agregarContratacion ('Indefinido', "2024-02-09", NULL, 17, 3, 'Trabajador de Nóminas', 3);

CALL agregarContratacion ('Indefinido', "2024-02-10", NULL, 18, 4, 'Trabajador de Atención al Cliente', 4);

CALL agregarContratacion ('Indefinido', "2024-02-14", NULL, 19, 4, 'Trabajador de Atención al Cliente', 4);

CALL agregarContratacion ('Indefinido', "2024-02-15", NULL, 20, 4, 'Trabajador de Atención al Cliente', 4);

CALL agregarContratacion ('Indefinido', "2024-02-07", NULL, 21, 5, 'Trabajador de Ventas', 5);

CALL agregarContratacion ('Indefinido', "2024-02-12", NULL, 22, 5, 'Trabajador de Ventas', 5);

CALL agregarContratacion ('Indefinido', "2024-02-13", NULL, 23, 5, 'Trabajador de Ventas', 5);

CALL agregarContratacion ('Indefinido', "2024-02-10", NULL, 24, 5, 'Trabajador de Ventas', 5);

CALL agregarContratacion ('Indefinido', "2024-02-15", NULL, 25, 5, 'Trabajador de Ventas', 5);

CALL agregarContratacion ('Indefinido', "2024-02-17", NULL, 26, 5, 'Trabajador de Ventas', 5);

CALL agregarContratacion ('Indefinido', "2024-02-26", NULL, 27, 5, 'Trabajador de Ventas', 5);

CALL agregarContratacion ('Indefinido', "2024-02-12", NULL, 28, 6, 'Trabajador de Compras', 6);

CALL agregarContratacion ('Indefinido', "2024-02-12", NULL, 29, 6, 'Trabajador de Compras', 6);

CALL agregarContratacion ('Indefinido', "2024-02-07", NULL, 30, 6, 'Trabajador de Compras', 6);

CALL agregarContratacion ('Indefinido', "2024-02-18", NULL, 31, 6, 'Trabajador de Compras', 6);

CALL agregarContratacion ('Indefinido', "2024-02-05", NULL, 32, 7, 'Trabajador de Desarrollo de Productos', 7);

CALL agregarContratacion ('Indefinido', "2024-02-09", NULL, 33, 7, 'Trabajador de Desarrollo de Productos', 7);

CALL agregarContratacion ('Indefinido', "2024-02-08", NULL, 34, 7, 'Trabajador de Desarrollo de Productos', 7);

CALL agregarContratacion ('Indefinido', "2024-02-07", NULL, 35, 7, 'Trabajador de Desarrollo de Productos', 7);

CALL agregarContratacion ('Indefinido', "2024-02-11", NULL, 36, 7, 'Trabajador de Desarrollo de Productos', 7);

CALL agregarContratacion ('Indefinido', "2024-02-13", NULL, 37, 7, 'Trabajador de Desarrollo de Productos', 7);

CALL agregarContratacion ('Indefinido', "2024-02-25", NULL, 38, 4, 'Trabajador de Atención al Cliente', 4);

CALL agregarContratacion ('Indefinido', "2024-03-02", NULL, 39, 4, 'Trabajador de Atención al Cliente', 4);

CALL agregarContratacion ('Indefinido', "2024-03-03", NULL, 40, 4, 'Trabajador de Atención al Cliente', 4);

CALL agregarContratacion ('Indefinido', "2024-03-05", NULL, 41, 4, 'Trabajador de Atención al Cliente', 4);

CALL agregarContratacion ('Indefinido', "2024-03-05", NULL, 42, 4, 'Trabajador de Atención al Cliente', 4);

END // 
DELIMITER ;

#---------------------------------------------------------------------------------------
#	4. Procedimiento agregarSalarios - AGREGAMOS LOS SALARIOS DE LOS DISTINTOS TIPOS DE EMPLEADOS
#---------------------------------------------------------------------------------------
DELIMITER //
DROP PROCEDURE IF EXISTS agregarSalarios //
CREATE PROCEDURE agregarSalarios ()
BEGIN
CALL agregarSalario ('Director', 10000, 1200, 0);

CALL agregarSalario ('Jefe de Recursos Humanos', 8200, 800, 4000);

CALL agregarSalario ('Jefe de Nóminas', 7800, 820, 4200);

CALL agregarSalario ('Jefe de Atención al Cliente', 8300, 850, 4300);

CALL agregarSalario ('Jefe de Ventas', 7900, 780, 3900);

CALL agregarSalario ('Jefe de Compras', 8100, 800, 4100);

CALL agregarSalario ('Jefe de Desarrollo de Productos', 8400, 840, 4400);

CALL agregarSalario ('Jefe de Reuniones', 7700, 770, 3900);

CALL agregarSalario ('Secretario del Director', 7000, 700, 3500);

CALL agregarSalario ('Trabajador de Recursos Humanos', 4200, 500, 2500);

CALL agregarSalario ('Trabajador de Nóminas', 3800, 550, 2700);

CALL agregarSalario ('Trabajador de Atención al Cliente', 4300, 600, 3000);

CALL agregarSalario ('Trabajador de Ventas', 3900, 530, 2600);

CALL agregarSalario ('Trabajador de Compras', 4100, 580, 2900);

CALL agregarSalario ('Trabajador de Desarrollo de Productos', 4400, 620, 3100);

END // 
DELIMITER ;

#---------------------------------------------------------------------------------------
#	5. Procedimiento agregarOficina( nombre, numero, dimension, ubicacion, Mesas )
#		( nombreOficina, numeroOficina, dimension, ubicacion, numeroMesas )
#---------------------------------------------------------------------------------------
DELIMITER //
DROP PROCEDURE IF EXISTS agregarOficina //
CREATE PROCEDURE agregarOficina (IN nombre VARCHAR(50), IN numero INT, IN dimension INT, IN ubicacion VARCHAR(50), IN mesas INT)
BEGIN
INSERT INTO
  oficina (nombreOficina, numeroOficina, dimension, ubicacion, numeroMesas)
VALUES
  (nombre, numero, dimension, ubicacion, mesas);

END // 
DELIMITER ;

#---------------------------------------------------------------------------------------
#	6. Procedimiento agregarEmpleado( NIF, Nombre, apellidos, incorporación )
#		( NIFEmpleado, nombreEmpleado, apellidosEmpleado, fechaIncorporacion )
#---------------------------------------------------------------------------------------
DELIMITER //
DROP PROCEDURE IF EXISTS agregarEmpleado //
CREATE PROCEDURE agregarEmpleado (IN NIF VARCHAR(9), IN nombre VARCHAR(50), IN apellidos VARCHAR(50), IN incorporacion DATE)
BEGIN
INSERT INTO
  empleado (NIFEmpleado, nombreEmpleado, apellidosEmpleado, fechaIncorporacion)
VALUES
  (NIF, nombre, apellidos, incorporacion);

END // 
DELIMITER ;

#---------------------------------------------------------------------------------------
#	7. Procedimiento agregarContratacion( Contrato, Inicio, Fin, Trabajador, Oficina, Puesto, Jefe )
#		( tipoContrato, inicioContratacion, finContratacion, Empleado, Oficina, puestoTrabajo, Jefe )
#---------------------------------------------------------------------------------------
DELIMITER //
DROP PROCEDURE IF EXISTS agregarContratacion //
CREATE PROCEDURE agregarContratacion (
  IN Contrato VARCHAR(40),
  IN Inicio DATE,
  IN Fin DATE,
  IN Trabajador INT,
  IN Oficina INT,
  IN Puesto VARCHAR(50),
  IN Jefe INT
)
BEGIN
INSERT INTO
  Contratacion (tipoContrato, inicioContratacion, finContratacion, Empleado, Oficina, puestoTrabajo, Jefe)
VALUES
  (Contrato, Inicio, Fin, Trabajador, Oficina, Puesto, Jefe);

END // 
DELIMITER ;

#---------------------------------------------------------------------------------------
#	8. Procedimiento agregarSalario( Puesto, Base, Incremento, Productividad )
#		( puestoTrabajo, sueldoBase, incrementoAnual, productividad )
#---------------------------------------------------------------------------------------
DELIMITER //
DROP PROCEDURE IF EXISTS agregarSalario //
CREATE PROCEDURE agregarSalario (IN Puesto VARCHAR(50), IN Base INT, IN Incremento INT, IN Productividad INT)
BEGIN
INSERT INTO
  Salario (puestoTrabajo, sueldoBase, incrementoAnual, productividad)
VALUES
  (Puesto, Base, Incremento, Productividad);

END // 
DELIMITER ;

#---------------------------------------------------------------------------------------
#	9. Procedimiento despedirTrabajador( Trabajador, Despido )
#---------------------------------------------------------------------------------------
DELIMITER //
DROP PROCEDURE IF EXISTS despedirTrabajador //
CREATE PROCEDURE despedirTrabajador (IN Trabajador INT, IN Despido DATE)
BEGIN
  UPDATE Contratacion SET finContratacion = Despido WHERE Empleado = Trabajador AND finContratacion IS NULL;
END // 
DELIMITER ; 

#---------------------------------------------------------------------------------------
#  10. Procedimiento contratarTrabajador( trabajador, Contrato, Fecha, OficinaTrabajo, Puesto, Jefe )
#---------------------------------------------------------------------------------------
DELIMITER //
DROP PROCEDURE IF EXISTS contratarTrabajador //
CREATE PROCEDURE contratarTrabajador (IN Trabajador INT, IN Contrato VARCHAR(40), IN Fecha DATE, IN OficinaTrabajo INT, IN Puesto VARCHAR(50), IN Jefe INT)
BEGIN

  INSERT INTO
  Contratacion (tipoContrato, inicioContratacion, Empleado, Oficina, puestoTrabajo, Jefe)
VALUES
  (Contrato, Fecha, Trabajador, OficinaTrabajo, Puesto, Jefe);
END // 
DELIMITER ; 
#---------------------------------------------------------------------------------------
#  11. Procedimiento mostrarContratosTrabajador( trabajador )
#---------------------------------------------------------------------------------------
DELIMITER //
DROP PROCEDURE IF EXISTS mostrarContratosTrabajador //
CREATE PROCEDURE mostrarContratosTrabajador (IN Trabajador INT)
BEGIN
  SELECT * FROM Contratacion WHERE Empleado = Trabajador;
END // 
DELIMITER ; 
#---------------------------------------------------------------------------------------
#---------------------------------------------------------------------------------------
#---------------------------------------------------------------------------------------
#	- Agrega todos los datos de la Empresa a la base de datos

CALL agregarDatosEmpresa();


#	- Despide al trabajador/es que desees con fecha de '2024-03-02'
CALL despedirTrabajador(10, '2024-03-02');
#	- Contrata a ese mismo trabajador/es para realizar un 'Proyecto' como contrato, con fecha de '2024-03-02', asigna una oficina de trabajo, un puesto y un jefe
CALL contratarTrabajador(10,'Proyecto','2024-03-02',5,'Trabajador autonomo',5);
#	- Despide a ese trabajador/es con fecha de '2024-03-12'
CALL despedirTrabajador(10, '2024-03-12');
#	- Contrata a ese mismo trabajador/es para realizar otro 'Proyecto' como contrato, con fecha de '2024-03-14', asigna una oficina de trabajo, un puesto y un jefe
CALL contratarTrabajador(10,'Proyecto','2024-03-14',3,'Trabajador Ventas',3);
#	- Despide a ese trabajador/es con fecha de '2024-03-17'
CALL despedirTrabajador(10,'2024-03-17');
#	- Contrata a ese mismo trabajador/es con contrato indefinido, con fecha de '2024-03-20', asigna una oficina de trabajo, un puesto y un jefe
CALL contratarTrabajador(10,'Indefinido','2024-03-20',2,'Trabajador de Recursos Humanos',2);
#	- Despide a ese trabajador/es con fecha de '2024-03-27'
CALL despedirTrabajador(10,'2024-03-27');
#	- Contrata a ese mismo trabajador/es con contrato indefinido, con fecha de '2024-03-30', asigna una oficina de trabajo, un puesto y un jefe
CALL contratarTrabajador(10,'Indefinido','2024-03-30',4,'Trabajador de Atención al Cliente',4);
#	- Despide a ese trabajador/es con fecha de '2024-04-12'
CALL despedirTrabajador(10,'2024-04-12');
#	- Muestra los Contratos de ese trabajador/es
CALL mostrarContratosTrabajador(10);
#---------------------------------------------------------------------------------------
#---------------------------------------------------------------------------------------
#---------------------------------------------------------------------------------------
