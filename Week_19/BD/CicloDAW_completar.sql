#*******************************************************************************************
#	1.	CREACIÓN Y USO DE LA BASE DE DATOS 'CicloDAW'
#*******************************************************************************************
DROP DATABASE IF EXISTS CicloDAW;
CREATE DATABASE CicloDAW;
USE CicloDAW;
    
#*******************************************************************************************
#	2.	CREACIÓN DE LA TABLA DE LA BASE DE DATOS
#*******************************************************************************************
#		TABLA Modulo
#*******************************************************************************************
#		ID		int				auto_increment
#		Siglas	varchar(5)
#		Codigo	varchar(6)
#		Nombre	text
#		Horas	int
#
#		Llave primaria 					->	ID empieza desde el valor 100
#		Valor único    					->	Siglas, Codigo
#		Comprobación de Valor no nulo	->	Siglas, Codigo, Nombre, Horas
#		Comprobación de Valor no vacío	->	Siglas, Codigo, Nombre
#		Comprobación de Valor positivo	->	Horas
#		Índice							->	Horas
#*******************************************************************************************

DROP TABLE IF EXISTS Modulo;
CREATE TABLE Modulo(
	ID INT AUTO_INCREMENT,
	Siglas VARCHAR(5) NOT NULL,
	Codigo VARCHAR(6) NOT NULL,
	Nombre TEXT NOT NULL,
	Horas INT NOT NULL,
	PRIMARY KEY (ID),
	UNIQUE (Siglas,Codigo),
	CHECK (Horas > 0),
	CHECK (Siglas <> ''),
	CHECK (Codigo <> ''),
	CHECK (Nombre <> ''),
	INDEX (Horas)	
);

ALTER TABLE Modulo AUTO_INCREMENT=100;
#CREATE INDEX Index_Horas ON Modulo (Horas); 
    
#*******************************************************************************************
#	3.	AÑADIMOS LOS DATOS SIGLAS, CÓDIGO, NOMBRE Y HORAS DE CADA MÓDULO DENTRO DE UNA MISMA SENTENCIA
#*******************************************************************************************

INSERT INTO Modulo (Siglas,Codigo,Nombre,Horas) VALUES
('LMARC','MP0373','Linguaxes de marcas e sistemas de xestión empresarial',133),
('SI','MP0483','Sistemas Informáticos',186),
('BD','MP0484','Bases de Datos',187),
('Prog','MP0485','Programación',240),
('CD','MP0487','Contornos de Desenvolvemento',107),
('DWEBC','MP0612','Desenvolvemento Web en Contorno Cliente',157),
('DWEBS','MP0613','Desenvolvemento Web en Contorno Servidor',175),
('DAW','MP0614','Despregamento de Aplicacións Web',88),
('DIM','MP0615','Deseño de Interfaces Web',157),
('Prox','MP0616','Proxecto de desenvolvemento de aplicación web',26),
('FOL','MP0617','Formación e orientación laboral',107),
('EIE','MP0618','Empresa e iniciativa emprendedora',53),
('FCT','MP0619','Formación en centros de traballo',384);
        
#*******************************************************************************************
#	4.	CREAMOS 10 ALUMNOS Y 5 PROFESORES CON FORMATO Alumn_01, Alumn_02, ...Y Prof_1, Prof_2, ...
#*******************************************************************************************

CREATE USER IF NOT EXISTS Alumn_01 IDENTIFIED BY 'abc';     
CREATE USER IF NOT EXISTS Alumn_02 IDENTIFIED BY 'abc';     
CREATE USER IF NOT EXISTS Alumn_03 IDENTIFIED BY 'abc';     
CREATE USER IF NOT EXISTS Alumn_04 IDENTIFIED BY 'abc';		 
CREATE USER IF NOT EXISTS Alumn_05 IDENTIFIED BY 'abc';     
CREATE USER IF NOT EXISTS Alumn_06 IDENTIFIED BY 'abc';
CREATE USER IF NOT EXISTS Alumn_07 IDENTIFIED BY 'abc';
CREATE USER IF NOT EXISTS Alumn_08 IDENTIFIED BY 'abc';
CREATE USER IF NOT EXISTS Alumn_09 IDENTIFIED BY 'abc';
CREATE USER IF NOT EXISTS Alumn_10 IDENTIFIED BY 'abc';

CREATE USER IF NOT EXISTS Prof_1 IDENTIFIED BY 'abc';
CREATE USER IF NOT EXISTS Prof_2 IDENTIFIED BY 'abc'; 
CREATE USER IF NOT EXISTS Prof_3 IDENTIFIED BY 'abc';
CREATE USER IF NOT EXISTS Prof_4 IDENTIFIED BY 'abc';   
CREATE USER IF NOT EXISTS Prof_5 IDENTIFIED BY 'abc';

#*******************************************************************************************
#	5.	CREAMOS DOS GRUPOS DE USUARIOS:	ALUMNADO, PROFESORADO
#		PROFESORADO -> ACCESO TOTAL
#		ALUMNADO	-> SÓLO CONSULTA
#*******************************************************************************************
DROP ROLE IF EXISTS ALUMNADO;
DROP ROLE IF EXISTS PROFESORADO;
CREATE ROLE IF NOT EXISTS ALUMNADO;
CREATE ROLE IF NOT EXISTS PROFESORADO;
    
#*******************************************************************************************
#	6.	DAMOS LOS RESPECTIVOS PRIVILEGIOS A LOS GRUPOS PROFESORADO Y ALUMNADO
#		PROFESORADO		Posibilidad de privilegios de acceso (role_admin) y creación de  usuarios (create user)
#		ALUMNADO		Sólo visibilidad (select)
#*******************************************************************************************
GRANT SELECT ON CicloDAW.* TO ALUMNADO;

# ESTO NO FUNCIONA CON MARIADB
#GRANT ROLE_ADMIN ON *.* TO PROFESORADO;
#GRANT CREATE_USER ON *.* TO PROFESORADO;
# EN MARIADB HACEMOS ESTO
GRANT ALL PRIVILEGES ON *.* TO PROFESORADO;
    
#*******************************************************************************************
#	7.	ASIGNAMOS A CADA GRUPO SUS USUARIOS CREADOS
#*******************************************************************************************
GRANT ALUMNADO TO Alumn_01;
GRANT ALUMNADO TO Alumn_02;
GRANT ALUMNADO TO Alumn_03;
GRANT ALUMNADO TO Alumn_04;
GRANT ALUMNADO TO Alumn_05;
GRANT ALUMNADO TO Alumn_06;
GRANT ALUMNADO TO Alumn_07;
GRANT ALUMNADO TO Alumn_08;
GRANT ALUMNADO TO Alumn_09;
GRANT ALUMNADO TO Alumn_10;

GRANT PROFESORADO TO Prof_1;
GRANT PROFESORADO TO Prof_2;
GRANT PROFESORADO TO Prof_3;
GRANT PROFESORADO TO Prof_4;
GRANT PROFESORADO TO Prof_5;
    
#*******************************************************************************************
#	8.	ASIGNAMOS PRIVILEGIOS POR DEFECTO
#*******************************************************************************************  
SET DEFAULT ROLE ALUMNADO FOR Alumn_01;
SET DEFAULT ROLE ALUMNADO FOR Alumn_02;
SET DEFAULT ROLE ALUMNADO FOR Alumn_03;
SET DEFAULT ROLE ALUMNADO FOR Alumn_04;
SET DEFAULT ROLE ALUMNADO FOR Alumn_05;
SET DEFAULT ROLE ALUMNADO FOR Alumn_06;
SET DEFAULT ROLE ALUMNADO FOR Alumn_07;
SET DEFAULT ROLE ALUMNADO FOR Alumn_08;
SET DEFAULT ROLE ALUMNADO FOR Alumn_09;
SET DEFAULT ROLE ALUMNADO FOR Alumn_10;

SET DEFAULT ROLE PROFESORADO FOR Prof_1;
SET DEFAULT ROLE PROFESORADO FOR Prof_2;
SET DEFAULT ROLE PROFESORADO FOR Prof_3;
SET DEFAULT ROLE PROFESORADO FOR Prof_4;
SET DEFAULT ROLE PROFESORADO FOR Prof_5;

#*******************************************************************************************
#	9.	REFRESCAMOS LOS CAMBIOS YA REALIZADOS (AUNQUE NO ES NECESARIO)
#*******************************************************************************************

FLUSH PRIVILEGES;