USE tienda;

delimiter //

DROP FUNCTION if EXISTS factorial;
CREATE FUNCTION factorial(numero INT)
	RETURNS INT
		DETERMINISTIC
BEGIN 
	DECLARE resultado INT;
	
	IF numero < 0 THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'ARGUMENT CANNOT BE < 0';
   END IF;
    
	SET resultado = 1;
	while(numero > 1) DO 
		SET resultado = resultado * numero;
		SET numero = numero - 1; 
	END while;
	RETURN resultado;
END //

delimiter ;

delimiter //

DROP FUNCTION if EXISTS permutaciones;
CREATE FUNCTION permutaciones(numero INT)
	RETURNS INT
		DETERMINISTIC
BEGIN 
	DECLARE resultado INT;
	set resultado = (SELECT factorial(numero));
	RETURN resultado;
END //

delimiter ;

SELECT permutaciones(3);
SELECT permutaciones(6);
SELECT permutaciones(0);
#SELECT permutaciones(-3);