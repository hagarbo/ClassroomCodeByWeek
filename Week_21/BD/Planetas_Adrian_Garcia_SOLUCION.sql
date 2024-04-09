#------------------------------------------------------------------------------------------
#	CREAMOS LA BASE DE DATOS PLANETAS
#------------------------------------------------------------------------------------------
DROP DATABASE IF EXISTS Planetas;
CREATE DATABASE Planetas;
USE Planetas;
#------------------------------------------------------------------------------------------
#	CREAMOS LA TABLA PLANETA
#------------------------------------------------------------------------------------------
#		id			Identificador
#		nombre		Nombre del Planeta
#		distancia	Distancia al Sol en metros
#		masa		Masa del cuerpo en Kg
#		radio		Radio del cuerpo en m
#------------------------------------------------------------------------------------------
CREATE TABLE Planeta (
	 id		 		int AUTO_INCREMENT,
    nombre 			varchar( 20 ) NOT NULL,
    distancia     FLOAT NOT NULL,
    masa				FLOAT NOT NULL,
    radio			FLOAT NOT NULL,
    Constraint		PK_Planeta Primary Key( id )
);

#------------------------------------------------------------------------------------------
#	AGREGAMOS LOS DATOS DEL Sol y de los ocho Planetas
#------------------------------------------------------------------------------------------

INSERT INTO planeta (nombre,distancia,masa,radio) VALUES 
('Sol',0,1.9891e30,695500000),
('Mercurio',57900000000,3.3e23,2439700),
('Venus',108200000000,4.87e24,6051800),
('Tierra',149600000000,5.97e24,6371000),
('Marte',227900000000,6.42e23,3389500),
('Jupiter',778600000000,1.898e27,69911000),
('Saturno',1433500000000,5.68e26,58232000),
('Urano',2872500000000,8.68e25,25362000),
('Neptuno',4495100000000,1.02e26,24622000);

#------------------------------------------------------------------------------------------
#	Creamos un procedimiento o función para realizar el cálculo de la gravedad a nivel de 
#	  superficie del cuerpo
#		CREATE FUNCTION calcularGravedad
#------------------------------------------------------------------------------------------
#
#
#				G  *  Masa
#	g = -----------------------
#				r ^ 2 
#
#
#
#------------------------------------------------------------------------------------------

DELIMITER //
DROP FUNCTION IF EXISTS calcularGravedad // 
    
CREATE FUNCTION calcularGravedad(masa FLOAT, radio FLOAT)
RETURNS FLOAT
        DETERMINISTIC
BEGIN
	
	DECLARE constanteG,gravedad FLOAT;
	SET constanteG = 6.67430e-11;
	SET gravedad = (constanteG * masa) / (radio * radio);
	RETURN gravedad;
	
END // 
DELIMITER ;

#------------------------------------------------------------------------------------------
#	Creamos un procedimiento o función para obtener la velocidad de escape de la superficie
#	  del cuerpo
#		CREATE FUNCTION calcularVelocidadEscape
#------------------------------------------------------------------------------------------
#
#				______________________
#			   |	2  *  G  *  Masa
#  Vescape = \ |----------------------
#			  \|		radio
#
#
#------------------------------------------------------------------------------------------

DELIMITER //
DROP FUNCTION IF EXISTS calcularVelocidadEscape // 
    
CREATE FUNCTION calcularVelocidadEscape(masa FLOAT, radio FLOAT)
RETURNS FLOAT
        DETERMINISTIC
BEGIN
	
	DECLARE constanteG,velocidadEscape FLOAT;
	SET constanteG = 6.67430e-11;
	SET velocidadEscape = SQRT((2*constanteG*masa)/radio);
	RETURN velocidadEscape;
	
END // 
DELIMITER ;

#------------------------------------------------------------------------------------------
#	Creamos un procedimiento o función para obtener la velocidad orbital del cuerpo
#		CREATE FUNCTION calcularVelocidadOrbital
#------------------------------------------------------------------------------------------
# 	Calcular la velocidad de escape
#----------------------------------------
#
#				 ______________________
#			    |	G  *  Masa
#  Vorbital = \ |----------------------
#			   \|	  radio
#
#------------------------------------------------------------------------------------------

DELIMITER //
DROP FUNCTION IF EXISTS calcularVelocidadOrbital // 
    
CREATE FUNCTION calcularVelocidadOrbital(masa FLOAT, radio FLOAT)
RETURNS FLOAT
        DETERMINISTIC
BEGIN
	
	DECLARE constanteG,velocidadOrbital FLOAT;
	SET constanteG = 6.67430e-11;
	SET velocidadOrbital = SQRT((constanteG*masa)/radio);
	RETURN velocidadOrbital;
	
END // 
DELIMITER ;

#------------------------------------------------------------------------------------------
#	Creamos una vista que muestre el nombre del Planeta, Distancia al sol (m), Masa (Kg), Radio (m), Gravedad ecuatorial, Velocidad de escape (m/s), Velocidad Orbital
#		CREATE VIEW DatosPlanetas AS SELECT 
#------------------------------------------------------------------------------------------

CREATE VIEW DatosPlanetas AS 
SELECT nombre AS 'Planeta',
		 distancia AS 'Distancia al sol(m)',
		 masa AS 'Masa(Kg)',
		 radio AS 'Radio(m)',
		 (SELECT calcularGravedad( masa, radio )) AS 'Gravedad ecuatorial',
		 (SELECT calcularVelocidadEscape( masa, radio )) AS 'Velocidad de escape(m/s)',
		 (SELECT calcularVelocidadOrbital( masa, radio )) AS 'Velocidad Orbital'
FROM planeta;

#------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------

set @masa = (SELECT masa FROM Planeta WHERE nombre = 'Tierra');
set @radio = (SELECT radio FROM Planeta WHERE nombre = 'Tierra' );
set @distancia = (SELECT distancia FROM Planeta WHERE nombre = 'Tierra' );
SELECT calcularGravedad( @masa, @radio );
SELECT calcularVelocidadEscape( @masa, @radio );
SELECT calcularVelocidadOrbital( @masa, @radio );
SELECT * FROM DatosPlanetas;