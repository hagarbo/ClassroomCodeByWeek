USE DatosConcello;
SELECT * FROM DatosConcello;

#-----------------------------------------------------------------------
#   1. Crea una función que devuelva los Concellos de una Comarca.
#-----------------------------------------------------------------------

DELIMITER //

DROP FUNCTION IF EXISTS obtenerConcellosXComarca //
CREATE FUNCTION obtenerConcellosXComarca(comarcaBuscar VARCHAR(40))
RETURNS TEXT 
	DETERMINISTIC
BEGIN
	DECLARE respuesta TEXT DEFAULT '';
	SELECT GROUP_CONCAT(Nombre SEPARATOR ', ') INTO respuesta FROM datosconcello 
			WHERE Comarca = comarcaBuscar;
			
	IF(respuesta IS NULL) THEN
		SET respuesta = CONCAT('No se encontraron concellos para la Comarca de "',comarcaBuscar,'".');
	END IF;
	RETURN respuesta;
END //

DELIMITER ;
SELECT obtenerConcellosXComarca('Vigo') AS 'Concellos que hay en la Comarca';
SELECT obtenerConcellosXComarca('Marín') AS 'Concellos que hay en la Comarca';
#-----------------------------------------------------------------------
#   2. Crea una función que devuelva los Concellos de una Provincia.
#-----------------------------------------------------------------------

DELIMITER //

DROP FUNCTION IF EXISTS ObtenerConcellosXProvincia //
CREATE FUNCTION ObtenerConcellosXProvincia(provinciaBuscar VARCHAR(40))
RETURNS TEXT 
	DETERMINISTIC
BEGIN
	DECLARE respuesta TEXT DEFAULT '';
	SELECT GROUP_CONCAT(Nombre SEPARATOR ', ') INTO respuesta FROM datosconcello 
			WHERE Provincia = provinciaBuscar;
			
	RETURN IF(respuesta IS NULL, CONCAT('No se encontraron concellos para la Provincia de "',provinciaBuscar,'".'), respuesta);
END //

DELIMITER ;

SELECT ObtenerConcellosXProvincia( 'A Coruña' ) AS 'Concellos que hay en la Provincia';

#-----------------------------------------------------------------------
#   3. Crea una función que devuelva las Comarcas de una Provincia.
#-----------------------------------------------------------------------

DELIMITER //

DROP FUNCTION IF EXISTS obtenerComarcasXProvincia //
CREATE FUNCTION obtenerComarcasXProvincia(provinciaBuscar VARCHAR(40))
RETURNS TEXT 
	DETERMINISTIC
BEGIN
	DECLARE respuesta TEXT DEFAULT '';
	SELECT GROUP_CONCAT(Comarca SEPARATOR ', ') INTO respuesta FROM datosconcello 
			WHERE Provincia = provinciaBuscar;
			
	RETURN IF(respuesta IS NULL, CONCAT('No se encontraron comarcas para la Provincia de "',provinciaBuscar,'".'), respuesta);
END //

DELIMITER ;

SELECT obtenerComarcasXProvincia( 'Pontevedra' ) AS 'Comarcas que hay en la Provincia';
SELECT obtenerComarcasXProvincia( 'Vigo' ) AS 'Comarcas que hay en la Provincia';

#-----------------------------------------------------------------------
#   4. Crea una función que devuelva los Concellos con mayor y menor superficie.
#-----------------------------------------------------------------------

DELIMITER //

DROP PROCEDURE IF EXISTS obtenerConcellosConMayorYMenorSuperficie //
CREATE PROCEDURE obtenerConcellosConMayorYMenorSuperficie()
BEGIN
	
	SELECT CONCAT('Concellos con mayor superficie(', MAX(Superficie),'):',
			GROUP_CONCAT(Nombre SEPARATOR ', ')) AS 'Concellos con mayor y menor superficie'
		FROM DatosConcello
		WHERE Superficie = (SELECT MAX(Superficie) FROM datosconcello)
	UNION
	SELECT CONCAT('Concellos con menor superficie(', MIN(Superficie),'):',
			GROUP_CONCAT(Nombre SEPARATOR ', '))
		FROM DatosConcello
		WHERE Superficie = (SELECT MIN(Superficie) FROM datosconcello);
			
END //

DELIMITER ;

CALL obtenerConcellosConMayorYMenorSuperficie();

#-----------------------------------------------------------------------
#   5. Crea una función que devuelva las Comarcas con mayor y menor superficie.
#-----------------------------------------------------------------------


#-----------------------------------------------------------------------
#   6. Crea una función que devuelva las Provincias con mayor y menor superficie.
#-----------------------------------------------------------------------


#-----------------------------------------------------------------------
#   7. Crea una función que devuelva los Concellos con mayor y menor población. 
#-----------------------------------------------------------------------



#-----------------------------------------------------------------------
#   8. Crea una función que devuelva las Comarcas con mayor y menor población.
#-----------------------------------------------------------------------


#-----------------------------------------------------------------------
#   9. Crea una función que devuelva las Provincias con mayor y menor población.
#-----------------------------------------------------------------------


#-----------------------------------------------------------------------
#    . 
#-----------------------------------------------------------------------


#-----------------------------------------------------------------------
#    . 
#-----------------------------------------------------------------------


#-----------------------------------------------------------------------
#    . 
#-----------------------------------------------------------------------


#-----------------------------------------------------------------------
#    . 
#-----------------------------------------------------------------------


#-----------------------------------------------------------------------
#    . 
#-----------------------------------------------------------------------


#-----------------------------------------------------------------------
#    . 
#-----------------------------------------------------------------------


#-----------------------------------------------------------------------
#    . 
#-----------------------------------------------------------------------


#-----------------------------------------------------------------------
#    . 
#-----------------------------------------------------------------------


#-----------------------------------------------------------------------
#    . 
#-----------------------------------------------------------------------


#-----------------------------------------------------------------------
#    . 
#-----------------------------------------------------------------------

