#---------------------------------------------------------------------------------------
#	CREACIÓN DE LA BASE DE DATOS Empresa
#---------------------------------------------------------------------------------------
DROP DATABASE IF EXISTS	Empresa;
CREATE DATABASE			Empresa;
USE						Empresa;
#------------------------------------------------------------------------------------------------------
#  BORRAMOS LAS TABLAS
#------------------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS oficinas, oficinasCopia, oficinasOLD;
DROP TABLE IF EXISTS familias, familiasCopia, familiasOLD;
DROP TABLE IF EXISTS agentes, agentesCopia, agentesOLD;

#------------------------------------------------------------------------------------------------------
#  CREAMOS LAS TABLAS
#------------------------------------------------------------------------------------------------------
create table oficinas (
     identificador     	int,
     nombre          	varchar( 40 ),
     domicilio     		varchar( 40 ),
     localidad     		varchar( 20 ),
     codigo_postal      varchar( 5 ),
     CONSTRAINT	PK_oficinas				PRIMARY KEY( identificador ),
     CONSTRAINT	UQ_oficinas_nombre		UNIQUE( nombre ),
     CONSTRAINT oficinas_nombre_NULO	CHECK( nombre IS NOT NULL )
);

create table familias (
     identificador     	int,
     nombre         	varchar( 40 ),
     familia          	int,
     oficina          	int,
     CONSTRAINT	PK_familias				PRIMARY KEY( identificador ),
     CONSTRAINT	FK_familias_familias	FOREIGN KEY( familia )		REFERENCES familias( identificador )	ON DELETE CASCADE,
     CONSTRAINT	FK_familias_oficinas	FOREIGN KEY( oficina )		REFERENCES oficinas( identificador )	ON DELETE CASCADE,
     CONSTRAINT	UQ_familias_nombre		UNIQUE( nombre ),
     CONSTRAINT	familia_nombre_NULO		CHECK( nombre IS NOT NULL )
);

create table agentes (
     identificador    	int,
     nombre          	varchar( 60 ),
     usuario          	varchar( 20 ),
     clave          	varchar( 20 ),
     habilidad     		int,
     categoria     		int,
     familia          	int,
     oficina          	int,
     CONSTRAINT	PK_agentes				PRIMARY KEY( identificador ),
     CONSTRAINT FK_agentes_familias		FOREIGN KEY( familia )		REFERENCES familias( identificador )	ON DELETE CASCADE,
     CONSTRAINT FK_agentes_oficinas		FOREIGN KEY( oficina )		REFERENCES oficinas( identificador )	ON DELETE CASCADE,
     CONSTRAINT UQ_agentes_usuario		UNIQUE( usuario ),
     CONSTRAINT agentes_nombre_NULO		CHECK( nombre IS NOT NULL ),
     CONSTRAINT agentes_usuario_NULO	CHECK( usuario IS NOT NULL ),
     CONSTRAINT agentes_clave_NULA		CHECK( clave IS NOT NULL ),
     CONSTRAINT agentes_habilidad_NULA	CHECK( habilidad IS NOT NULL ),
     CONSTRAINT agentes_categoria_NULA	CHECK( categoria IS NOT NULL )
);
#------------------------------------------------------------------------------------------------------
#  CREAMOS LAS TABLAS COPIA Y LAS TABLAS OLD, A PARTIR DE LAS TABLAS RECIÉN CREADAS
#		EJEMPLO:	oficinas, oficinasCopia y oficinasOLD
#------------------------------------------------------------------------------------------------------
CREATE TABLE oficinasCopia AS SELECT * FROM oficinas;	CREATE TABLE oficinasOLD AS SELECT * FROM oficinas;
CREATE TABLE familiasCopia AS SELECT * FROM familias;	CREATE TABLE familiasOLD AS SELECT * FROM familias;
CREATE TABLE agentesCopia  AS SELECT * FROM agentes;	CREATE TABLE agentesOLD  AS SELECT * FROM agentes;
#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------


#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------
#  GUIONES - ES LA SECUENCIA DE INSTRUCCIONES QUE APARECEN EN ESTE DOCUMENTO
#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------
# Secuencia de instrucciones que se ejecutarán de forma ordenada


#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------
#  PROCEDIMIENTOS
#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------
#	- Procedimiento para añadir los datos de una nueva Oficina
#------------------------------------------------------------------------------------------------------
DELIMITER //
	DROP PROCEDURE IF EXISTS 	agregarOficina //
	CREATE PROCEDURE 			agregarOficina ( 
		id      int,
		Nom     varchar( 40 ),
		Dom     varchar( 40 ),
		Loc     varchar( 20 ),
		CP      varchar(  5 )	) 
	BEGIN
        INSERT INTO oficinas (identificador, nombre, domicilio, localidad, codigo_postal) 
            VALUES ( id, Nom, Dom, Loc, CP );
	END // 
DELIMITER ;
#------------------------------------------------------------------------------------------------------
#	- Procedimiento para añadir los datos todas las oficinas en función del procedimiento creado previamente
#------------------------------------------------------------------------------------------------------
DELIMITER //
	DROP PROCEDURE IF EXISTS	agregarOficinas //
	CREATE PROCEDURE 			agregarOficinas()
		BEGIN
			CALL agregarOficina( 1, 'Madrid', 'Gran vía, 37', 'Madrid', '28000' );
			CALL agregarOficina( 2, 'Granada', 'Camino Ronda, 50', 'Granada', '36000' );
			CALL agregarOficina( 3, 'Jaén', 'Gran Eje, 80', 'Jaén', '27000' );
		END // 
DELIMITER ;
#------------------------------------------------------------------------------------------------------
#	- Procedimiento para añadir los datos de una nueva Familia
#------------------------------------------------------------------------------------------------------
DELIMITER //
	DROP PROCEDURE IF EXISTS 	agregarFamilia //
   	CREATE PROCEDURE agregarFamilia (
     	id     int,
    	Nom    varchar(40),
     	Fam    int,
     	Ofi    int	) 
    BEGIN
	    INSERT INTO familias VALUES ( id, Nom, Fam, Ofi );
    END // 
DELIMITER ;
#------------------------------------------------------------------------------------------------------
#	- Procedimiento para añadir los datos todas las familias en función del procedimiento creado previamente
#------------------------------------------------------------------------------------------------------
DELIMITER //
	DROP PROCEDURE IF EXISTS agregarFamilias //
	CREATE PROCEDURE agregarFamilias()
		BEGIN
			CALL agregarFamilia( 11, 'Madrid-1', NULL, 1 );
            CALL agregarFamilia( 111, 'Madrid-1.1', 11, NULL );
        	CALL agregarFamilia( 112, 'Madrid-1.2', 11, NULL );
        	CALL agregarFamilia( 1121, 'Madrid-1.2.1', 112, NULL );
        	CALL agregarFamilia( 1122, 'Madrid-1.2.2', 112, NULL );
        	CALL agregarFamilia( 1123, 'Madrid-1.2.3', 112, NULL );
        	CALL agregarFamilia( 21, 'Granada-1', NULL, 2 );
        	CALL agregarFamilia( 211, 'Granada-1.1', 21, NULL );
        	CALL agregarFamilia( 212, 'Granada-1.2', 21, NULL );
        	CALL agregarFamilia( 213, 'Granada-1.3', 21, NULL );
        	CALL agregarFamilia( 31, 'Jaén-1', NULL, 3 );
		END // 
DELIMITER ;
#------------------------------------------------------------------------------------------------------
#	- Procedimiento para añadir los datos de un nuevo agente
#------------------------------------------------------------------------------------------------------
DELIMITER //
	DROP PROCEDURE IF EXISTS agregarAgente //
    CREATE PROCEDURE agregarAgente (
        id     int,
        Nom    varchar(60),
        Usu    varchar(20),
        Cla    varchar(20),
        Hab    int,
        Cat    int,
        Fam    int,
        Ofi    int	) 
    BEGIN
        INSERT INTO agentes	VALUES ( id, Nom, Usu, Cla, Hab, Cat, Fam, Ofi );
    END // 
DELIMITER ;
#------------------------------------------------------------------------------------------------------
#	- Procedimiento para añadir los datos todos los agentes en función del procedimiento creado previamente
#------------------------------------------------------------------------------------------------------
DELIMITER //
	DROP PROCEDURE IF EXISTS agregarAgentes //
    CREATE PROCEDURE agregarAgentes()
    BEGIN
        CALL agregarAgente( 31, 'José Ramón Jiménez Reyes', 'jrjr', 'sup31', 9, 2, NULL, 3);
        CALL agregarAgente( 311, 'Pedro Fernández Arias', 'pfa', 'ag311', 5, 0, 31, NULL);
        CALL agregarAgente( 312, 'Vanesa Sánchez Rojo', 'vsr', 'ag312', 5, 0, 31, NULL);
        CALL agregarAgente( 313, 'Francisco Javier García Escobedo', 'fjge', 'ag313', 5, 0, 31, NULL);
        CALL agregarAgente( 314, 'Pilar Ramirez Pérez', 'prp', 'ag314', 5, 0, 31, NULL);
        CALL agregarAgente( 315, 'José Luis García Martínez', 'jlgm', 'ag315', 5, 0, 31, NULL);
        CALL agregarAgente( 21, 'Sebastián López Ojeda', 'slo', 'sup21', 9, 2, NULL, 2);
        CALL agregarAgente( 211, 'Diosdado Sánchez Hernández', 'dsh', 'ag211', 8, 1, 21, NULL);
        CALL agregarAgente( 2111, 'José Juan Cano Pardo', 'jjcp', 'ag2111', 5, 0, 211, NULL);
        CALL agregarAgente( 2112, 'Flor Moncada Añón', 'ag2112', 'fma', 5, 0, 211, NULL);
        CALL agregarAgente( 2113, 'Juan Manuel Alcazar Donaire', 'jmad', 'ag2113', 5, 0, 211, NULL);
        CALL agregarAgente( 2121, 'Manuel Jesús Rubia Mateos', 'mjrm', 'ag2121', 5, 0, 212, NULL);
        CALL agregarAgente( 2122, 'Esther López Delgado', 'eld', 'ag2122', 5, 0, 212, NULL);
        CALL agregarAgente( 2123, 'Francisco Javier Cabrerizo Membrilla', 'fjcm', 'ag2123', 5, 0, 212, NULL);
        CALL agregarAgente( 2124, 'Verónica Cabrerizo Menbrilla', 'vcm', 'ag2124', 5, 0, 212, NULL);
        CALL agregarAgente( 2125, 'María José Navascués Morales', 'mjnm', 'ag2125', 5, 0, 212, NULL);
        CALL agregarAgente( 2131, 'Isabel Cruz Granados', 'icg', 'ag2131', 5, 0, 213, NULL);
        CALL agregarAgente( 2132, 'Antonio Casado Fernández', 'acf', 'ag2132', 5, 0, 213, NULL);
        CALL agregarAgente( 2133, 'Gabriel Callejón García', 'gcg', 'ag2133', 5, 0, 213, NULL);
        CALL agregarAgente( 2134, 'Enrique Cano Balsera', 'ecb', 'ag2134', 5, 0, 213, NULL);
        CALL agregarAgente( 11, 'Narciso Jáimez Toro', 'njt', 'sup11', 9, 2, NULL, 1);
        CALL agregarAgente( 111, 'Jesús Baños Sancho', 'jbs', 'ag111', 8, 1, 11, NULL);
        CALL agregarAgente( 1111, 'Salvador Romero Villegas', 'srv', 'ag1111', 7, 1, 111, NULL);
        CALL agregarAgente( 1112, 'José Javier Bermúdez Hernández', 'jjbh', 'ag1112', 7, 1, 111, NULL);
        CALL agregarAgente( 1113, 'Alfonso Bonillo Sierra', 'abs', 'ag1113', 7, 1, 111, NULL);
        CALL agregarAgente( 1121, 'Silvia Thomas Barrós', 'stb', 'ag1121', 7, 1, 112, NULL);
        CALL agregarAgente( 11211, 'Ernesto Osoro Gorrotxategi', 'eog', 'ag11211', 5, 0, 1121, NULL);
        CALL agregarAgente( 11212, 'Guillermo Campos Guillén', 'gcag', 'ag11212', 5, 0, 1121, NULL);
        CALL agregarAgente( 11213, 'Antonio Fernández Ruíz', 'afr', 'ag11213', 5, 0, 1121, NULL);
        CALL agregarAgente( 11214, 'María Luisa López Caballero', 'mllc', 'ag11214', 5, 0, 1121, NULL);
        CALL agregarAgente( 11221, 'Virginia Morenas Rubio', 'vmr', 'ag11221', 5, 0, 1121, NULL);
        CALL agregarAgente( 11222, 'Rosario Castro García', 'rcg', 'ag11222', 5, 0, 1122, NULL);
        CALL agregarAgente( 11223, 'Antonio Álvarez Palomeque', 'aap', 'ag11223', 5, 0, 1122, NULL);
        CALL agregarAgente( 11224, 'David Martínez Martínez', 'dmm', 'ag11224', 5, 0, 1122, NULL);
        CALL agregarAgente( 11225, 'Juan Corral González', 'jcg', 'ag11225', 5, 0, 1122, NULL);
        CALL agregarAgente( 11226, 'Eduardo Alfada Pereira', 'eap', 'ag11226', 5, 0, 1122, NULL);
        CALL agregarAgente( 11231, 'Cayetano García Herrera', 'cgh', 'ag11231', 5, 0, 1123, NULL);
        CALL agregarAgente( 11232, 'José Antonio Sieres Vega', 'jasv', 'ag11232', 5, 0, 1123, NULL);
        CALL agregarAgente( 11233, 'Juan Manuel Guzmán García', 'jmgg', 'ag11233', 5, 0, 1123, NULL);
    END // 
DELIMITER ;
#------------------------------------------------------------------------------------------------------
#	- Procedimiento para añadir los datos de todas las tablas creadas, es decir invocar desde aquí
#		a los tres procedimientos agregar
#------------------------------------------------------------------------------------------------------
DELIMITER //
	DROP PROCEDURE IF EXISTS agregarDatos //
    CREATE PROCEDURE agregarDatos()
		BEGIN
			CALL agregarOficinas();
        	CALL agregarFamilias();
        	CALL agregarAgentes();
		END // 
DELIMITER ;


#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------
#  FUNCIONES
#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------
#	- Función que va a devolver el número de miembros de la familia cuyo nombre se pase como parámetro
#------------------------------------------------------------------------------------------------------
DELIMITER //
	DROP FUNCTION IF EXISTS contarMiembrosFamilia //
    CREATE FUNCTION contarMiembrosFamilia( familiaContar int ) 
    RETURNS int deterministic
    BEGIN
        DECLARE numMiembros int;
    	SELECT COUNT(*) INTO numMiembros FROM agentes WHERE familia = familiaContar;
    	RETURN numMiembros;
    END // 
DELIMITER ;
#------------------------------------------------------------------------------------------------------
#	- Función que va a devolver el nombre de la familia cuyo identificamdor se pasa como parámetro
#------------------------------------------------------------------------------------------------------
DELIMITER //
	DROP FUNCTION IF EXISTS obtenerNombreFamilia //
	CREATE FUNCTION obtenerNombreFamilia( idFamilia int ) RETURNS varchar( 40 )
		DETERMINISTIC
		BEGIN
			DECLARE nombreFamilia varchar( 40 );
			SELECT nombre INTO nombreFamilia FROM familias WHERE identificador = idFamilia;
            
			IF nombreFamilia IS NULL THEN
				RETURN 'Identificador no válido'; -- Mensaje de identificador no válido
			ELSE
				RETURN nombreFamilia;
			END IF;
		END // 
DELIMITER ;
#------------------------------------------------------------------------------------------------------
#	- Procedimiento sencillo cuya finalidad es mostrar todos los datos de las oficinas
#------------------------------------------------------------------------------------------------------
DELIMITER //
	DROP PROCEDURE IF EXISTS mostrarOficinas //
    CREATE PROCEDURE mostrarOficinas()
    BEGIN
		SELECT * FROM oficinas;
	END //
DELIMITER ;
#------------------------------------------------------------------------------------------------------
#	- Procedimiento cuya finalidad es mostrar todos los datos de las oficinas recorriendolos con un cursor
#------------------------------------------------------------------------------------------------------
DELIMITER //
	DROP PROCEDURE IF EXISTS mostrarOficinas //
    CREATE PROCEDURE mostrarOficinas()
    BEGIN
        DECLARE	FIN	INT	DEFAULT	FALSE;		-- variable asociada al bucle

        DECLARE var_id		INT;
        DECLARE	var_nom		VARCHAR( 40 );
        DECLARE	var_dom 	VARCHAR( 40 );
        DECLARE	var_loc		VARCHAR( 20 );
        DECLARE	var_cp		VARCHAR(  5 );

        DECLARE	cursorOficinas	CURSOR FOR SELECT * FROM oficinas;
        DECLARE	CONTINUE	HANDLER FOR NOT	FOUND	SET FIN = TRUE;		-- la variabla asociada al bucle cambiará de valor cuando ya no haya ninguna tupla que leer

        OPEN cursorOficinas;

        DROP TEMPORARY TABLE IF EXISTS resultado;
        CREATE TEMPORARY TABLE resultado(
        		linea VARCHAR(255)
        );

        leerOficinas:	LOOP
            FETCH cursorOficinas INTO var_id, var_nom, var_dom, var_loc, var_cp;
            IF	FIN	THEN
					LEAVE	leerOficinas;	-- si no hay más tuplas que leer salimos de este bucle
            END IF;
            
            -- Mostrar los datos de la fila actual
            INSERT INTO resultado (SELECT CONCAT('Identificador: ' , var_id , ', Nombre: ' , var_nom , ', Domicilio: ' , var_dom,  ', Localidad: ',  var_loc, ', Código Postal: ', var_cp ));
        END LOOP;
        
        SELECT linea AS 'Oficinas' FROM resultado;

        CLOSE cursorOficinas;
    END // 
DELIMITER ;
#------------------------------------------------------------------------------------------------------
#	- Procedimiento sencillo cuya finalidad es mostrar todos los datos de las familias
#------------------------------------------------------------------------------------------------------
DELIMITER //
	DROP PROCEDURE IF EXISTS mostrarFamilias //
    CREATE PROCEDURE mostrarFamilias()
    BEGIN
		SELECT * FROM familias;
	END //
DELIMITER ;
#------------------------------------------------------------------------------------------------------
#	- Procedimiento cuya finalidad es mostrar todos los datos de las familias recorriendolos con un cursor
#------------------------------------------------------------------------------------------------------
DELIMITER //
	DROP PROCEDURE IF EXISTS mostrarFamilias //

    CREATE PROCEDURE mostrarFamilias()
    BEGIN
        DECLARE	FIN	INT	DEFAULT	FALSE;	
        DECLARE var_id INT;
        DECLARE var_nom VARCHAR(40);
        DECLARE var_fam INT;
        DECLARE var_ofi INT;
        
        -- Cursor para seleccionar todas las filas de la tabla familias
        DECLARE cursorFamilias CURSOR FOR SELECT identificador, nombre, familia, oficina FROM familias;
        
        -- Handler para el cursor
        DECLARE CONTINUE HANDLER FOR NOT FOUND SET FIN = TRUE;

        -- Abrir el cursor
        OPEN cursorFamilias;
        
        DROP TEMPORARY TABLE IF EXISTS resultado;
        CREATE TEMPORARY TABLE resultado(
        		linea VARCHAR(255)
        );
        
        -- Loop para recorrer el cursor
        leerFamilias: LOOP
            -- Fetch de los valores del cursor
            FETCH cursorFamilias INTO var_id, var_nom, var_fam, var_ofi;
            
            -- Si no se encontraron más filas, salir del loop
            IF FIN THEN
                LEAVE leerFamilias;
            END IF;
            
            -- Mostrar los datos de la fila actual
            INSERT INTO resultado 
                (SELECT CONCAT('Identificador: ', var_id, ', Nombre: ', var_nom, ', Familia: ', 
                IFNULL(var_fam,'NULL'), ', Oficina: ', IFNULL(var_ofi,'NULL') ));
         END LOOP leerFamilias;
        
         SELECT linea AS 'Familias' FROM resultado;
        -- Cerrar el cursor
        CLOSE cursorFamilias;
    END // 
DELIMITER ;
#------------------------------------------------------------------------------------------------------
#	- Procedimiento sencillo cuya finalidad es mostrar todos los datos de los agentes
#------------------------------------------------------------------------------------------------------
DELIMITER //
	DROP PROCEDURE IF EXISTS mostrarAgentes //
    CREATE PROCEDURE mostrarAgentes()
    BEGIN
		SELECT * FROM Agentes;
	END //
DELIMITER ;
#------------------------------------------------------------------------------------------------------
#	- Procedimiento cuya finalidad es mostrar todos los datos de los agentes recorriendolos con un cursor
#------------------------------------------------------------------------------------------------------
DELIMITER //
	DROP PROCEDURE IF EXISTS mostrarAgentesCursor //
    CREATE PROCEDURE mostrarAgentesCursor()
    BEGIN
        DECLARE FIN INT DEFAULT FALSE;
        DECLARE var_id INT;
        DECLARE var_nom VARCHAR(60);
        DECLARE var_usu VARCHAR(20);
        DECLARE var_cla VARCHAR(20);
        DECLARE var_hab INT;
        DECLARE var_cat INT;
        DECLARE var_fam INT;
        DECLARE var_ofi INT;
        
        -- Cursor para seleccionar todas las filas de la tabla agentes
        DECLARE cursorAgentes CURSOR FOR SELECT identificador, nombre, usuario, clave, habilidad, categoria, familia, oficina FROM agentes;
        
        -- Handler para el cursor
        DECLARE CONTINUE HANDLER FOR NOT FOUND SET FIN = TRUE;

        -- Abrir el cursor
        OPEN cursorAgentes;

        DROP TEMPORARY TABLE IF EXISTS resultado;
        CREATE TEMPORARY TABLE resultado(
        		linea VARCHAR(255)
        );
        
        -- Loop para recorrer el cursor
        leerAgentes: LOOP
            -- Fetch de los valores del cursor
            FETCH cursorAgentes INTO var_id, var_nom, var_usu, var_cla, var_hab, var_cat, var_fam, var_ofi;
            
            -- Si no se encontraron más filas, salir del loop
            IF FIN THEN
               LEAVE leerAgentes;
            END IF;
            
            -- Guardamos cada tupla en una linea y concatenamos el resultado
            INSERT INTO resultado (SELECT CONCAT('Identificador: ', var_id, ', Nombre: ', var_nom, ', Usuario: ', var_usu, ', Clave: ', 
								var_cla, ', Habilidad: ', var_hab, ', Categoría: ', var_cat, ', Familia: ', IFNULL(var_fam,'NULL'), ', 
								Oficina: ', IFNULL(var_ofi,'NULL')));
        END LOOP leerAgentes;
        -- Mostrar los agentes
        SELECT linea AS 'Agentes' FROM resultado;
        -- Cerrar el cursor
        CLOSE cursorAgentes;
    END // 
DELIMITER ;
#------------------------------------------------------------------------------------------------------
#	- Procedimiento sencillo cuya finalidad es invocar a los tres procedimientos anteriores para
#		mostrar los datos de las Oficinas, Familias y Agentes. Pero de forma independiente
#------------------------------------------------------------------------------------------------------
DELIMITER //
	DROP PROCEDURE IF EXISTS mostrarDatos //
    CREATE PROCEDURE mostrarDatos()
    BEGIN
        CALL mostrarOficinas();
        CALL mostrarFamilias();
        CALL mostrarAgentes();
    END // 
DELIMITER ;

#------------------------------------------------------------------------------------------------------
#	- Procedimiento sencillo cuya finalidad es invocar a los tres procedimientos anteriores para
#		mostrar los datos de las Oficinas, Familias y Agentes. Pero de forma independiente
#------------------------------------------------------------------------------------------------------
DELIMITER //
	DROP PROCEDURE IF EXISTS mostrarDatosCursores //
    CREATE PROCEDURE mostrarDatosCursores()
    BEGIN
        CALL mostrarOficinasCursor();
        CALL mostrarFamiliasCursor();
        CALL mostrarAgentesCursor();
    END // 
DELIMITER ;


#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------
#  DISPARADORES
#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------
#	- Código que se ejecuta al agregar una tupla en la tabla Oficinas, cuya finalidad es volcar esos datos
#		sobre la tabla oficinasCopia
#------------------------------------------------------------------------------------------------------
DELIMITER //
	DROP TRIGGER IF EXISTS TRAS_AGREGAR_OFICINA //
	CREATE TRIGGER TRAS_AGREGAR_OFICINA
		AFTER INSERT ON oficinas	FOR EACH ROW
		BEGIN
			INSERT INTO oficinasCopia 
            VALUES (NEW.identificador, NEW.nombre, NEW.domicilio, NEW.localidad, NEW.codigo_postal);
		END // 
DELIMITER ;
#------------------------------------------------------------------------------------------------------
#	- Código que se ejecuta al agregar una tupla en la tabla Familias, cuya finalidad es volcar esos datos
#		sobre la tabla familiasCopia
#------------------------------------------------------------------------------------------------------
DELIMITER //
	DROP TRIGGER IF EXISTS TRAS_AGREGAR_FAMILIA //
	CREATE TRIGGER TRAS_AGREGAR_FAMILIA
	AFTER INSERT ON familias	
    FOR EACH ROW
    BEGIN
        INSERT INTO familiasCopia 
            VALUES (NEW.identificador, NEW.nombre, NEW.familia, NEW.oficina);
    END // 
DELIMITER ;
#------------------------------------------------------------------------------------------------------
#	- Código que se ejecuta al agregar una tupla en la tabla Agentes, cuya finalidad es volcar esos datos
#		sobre la tabla agentesCopia
#------------------------------------------------------------------------------------------------------
DELIMITER //
	DROP TRIGGER IF EXISTS TRAS_AGREGAR_AGENTE //
	 CREATE TRIGGER TRAS_AGREGAR_AGENTE
	AFTER INSERT ON agentes		
    FOR EACH ROW
    BEGIN
        INSERT INTO agentesCopia 
        VALUES (NEW.identificador, NEW.nombre, NEW.usuario, NEW.clave, NEW.habilidad, 
                NEW.categoria, NEW.familia, NEW.oficina);
    END // 
DELIMITER ;
#------------------------------------------------------------------------------------------------------
#	- Código que se ejecuta al modificar datos de la tabla Agentes, cuya finalidad es volcar esos datos
#		sobre la tabla agentesCopia. En la tabla oficinasOLD se volcarán los datos que van a ser modificados
#------------------------------------------------------------------------------------------------------
DELIMITER //
	DROP TRIGGER IF EXISTS TRAS_MODIFICAR_OFICINA //
    CREATE TRIGGER TRAS_MODIFICAR_OFICINA
		AFTER UPDATE ON oficinas	FOR EACH ROW
		BEGIN
			#	actualizamos la tabla oficinasCopia
			UPDATE oficinasCopia
			SET nombre = NEW.nombre, domicilio = NEW.domicilio, localidad = NEW.localidad, 
				codigo_postal = NEW.codigo_postal
			WHERE identificador = OLD.identificador;
			#	agregamos los datos que van a ser modificados en la tabla oficinasOLD
            IF EXISTS (	SELECT * FROM agentesOLD WHERE identificador = OLD.identificador )	THEN
				UPDATE oficinasCopia
			    SET nombre = OLD.nombre, domicilio = OLD.domicilio, localidad = OLD.localidad, 
				    codigo_postal = OLD.codigo_postal
			    WHERE identificador = OLD.identificador;
		    ELSE																			
			    INSERT INTO oficinasOLD 
                VALUES (OLD.identificador, OLD.nombre, OLD.domicilio, OLD.localidad, OLD.codigo_postal);
		    END IF;
			
		END // 
DELIMITER ;
#------------------------------------------------------------------------------------------------------
#	- Código que se ejecuta al modificar datos de la tabla Familias, cuya finalidad es volcar esos datos
#		sobre la tabla familiasCopia. En la tabla familiasOLD se volcarán los datos que van a ser modificados
#------------------------------------------------------------------------------------------------------
DELIMITER //
	DROP TRIGGER IF EXISTS TRAS_MODIFICAR_FAMILIA //
	CREATE TRIGGER TRAS_MODIFICAR_FAMILIA
	AFTER UPDATE ON familias	
    FOR EACH ROW
    BEGIN
		#	actualizamos la tabla familiasCopia
        UPDATE familiasCopia
        SET nombre = NEW.nombre, familia = NEW.familia, oficina = NEW.oficina
    	WHERE identificador = OLD.identificador;
		#	agregamos los datos que van a ser modificados en la tabla familiasOLD
        IF EXISTS (	SELECT * FROM agentesOLD WHERE identificador = OLD.identificador )	THEN
				UPDATE familiasCopia
                SET nombre = OLD.nombre, familia = OLD.familia, oficina = OLD.oficina
    	        WHERE identificador = OLD.identificador;
		ELSE																			
			INSERT INTO familiasOLD 
                VALUES (OLD.identificador, OLD.nombre, OLD.familia, OLD.oficina);
		END IF;
		
    END // 
DELIMITER ;
#------------------------------------------------------------------------------------------------------
#	- Código que se ejecuta al modificar datos de la tabla Agentes, cuya finalidad es volcar esos datos
#		sobre la tabla agentesCopia. En la tabla agentesOLD se volcarán los datos que van a ser modificados
#------------------------------------------------------------------------------------------------------
DELIMITER //
	DROP TRIGGER IF EXISTS TRAS_MODIFICAR_AGENTE //
	CREATE TRIGGER TRAS_MODIFICAR_AGENTE
	AFTER UPDATE ON agentes		
    FOR EACH ROW
    BEGIN
		#	actualizamos la tabla AgentesCopia
        UPDATE agentesCopia
        SET nombre = NEW.nombre, usuario = NEW.usuario, clave = NEW.clave, 
            habilidad = NEW.habilidad, categoria = NEW.categoria, familia = NEW.familia, 
            oficina = NEW.oficina
    	WHERE identificador = OLD.identificador;
		#	agregamos los datos que van a ser modificados en la tabla agentesOLD o los actualizamos si ya existian otros
        IF EXISTS (	SELECT * FROM agentesOLD WHERE identificador = OLD.identificador )	THEN
				UPDATE agentesCopia
                SET nombre = OLD.nombre, usuario = OLD.usuario, clave = OLD.clave, 
                    habilidad = OLD.habilidad, categoria = OLD.categoria, familia = OLD.familia, 
                    oficina = OLD.oficina
    	        WHERE identificador = OLD.identificador;
		ELSE																			
			INSERT INTO agentesOLD 
                VALUES (OLD.identificador, OLD.nombre, OLD.usuario, OLD.clave, OLD.habilidad, 
                        OLD.categoria, OLD.familia, OLD.oficina);
		END IF;
		
    END // 
DELIMITER ;
#------------------------------------------------------------------------------------------------------
#	- Código que se ejecuta al borrar datos de la tabla Oficinas, cuya finalidad es volcar esos datos
#		sobre la tabla agentesCopia. En la tabla agentesOLD se volcarán los datos que van a ser eliminados
#------------------------------------------------------------------------------------------------------
DELIMITER //
	DROP TRIGGER IF EXISTS TRAS_BORRAR_OFICINA //
	CREATE TRIGGER TRAS_BORRAR_OFICINA
		AFTER DELETE ON oficinas	FOR EACH ROW
		BEGIN
			#	borramos en la tabla oficinasCopia
			DELETE FROM oficinasCopia WHERE identificador = OLD.identificador;
			#	agregamos los datos que van a ser borrados en la tabla oficinasOLD
            INSERT INTO oficinasOLD 
            VALUES (OLD.identificador, OLD.nombre, OLD.domicilio, OLD.localidad, OLD.codigo_postal);
		END // 
DELIMITER ;
#------------------------------------------------------------------------------------------------------
#	- Código que se ejecuta al borrar datos de la tabla Familias, cuya finalidad es volcar esos datos
#		sobre la tabla familiasCopia. En la tabla familiasOLD se volcarán los datos que van a ser eliminados
#------------------------------------------------------------------------------------------------------
DELIMITER //
	DROP TRIGGER IF EXISTS TRAS_BORRAR_FAMILIA //
	CREATE TRIGGER TRAS_BORRAR_FAMILIA
		AFTER DELETE ON familias	FOR EACH ROW
		BEGIN
			#	borramos en la tabla familiasCopia
			DELETE FROM familiasCopia WHERE identificador = OLD.identificador;
			#	agregamos los datos que van a ser borrados en la tabla familiasOLD
			INSERT INTO familiasOLD 
            VALUES (OLD.identificador, OLD.nombre, OLD.familia, OLD.oficina);
    END // 
DELIMITER ;
#------------------------------------------------------------------------------------------------------
#	- Código que se ejecuta al borrar datos de la tabla Agentes, cuya finalidad es volcar esos datos
#		sobre la tabla agentesCopia. En la tabla agentesOLD se volcarán los datos que van a ser eliminados
#------------------------------------------------------------------------------------------------------
DELIMITER //
	DROP TRIGGER IF EXISTS TRAS_BORRAR_AGENTE //
	CREATE TRIGGER TRAS_BORRAR_AGENTE
		AFTER DELETE ON agentes	FOR EACH ROW
		BEGIN
			#	borramos en la tabla agentesCopia
			DELETE FROM agentesCopia WHERE identificador = OLD.identificador;
			#	agregamos los datos que van a ser borrados en la tabla agentesOLD
    		INSERT INTO agentesOLD 
        	VALUES (OLD.identificador, OLD.nombre, OLD.usuario, OLD.clave, OLD.habilidad, 
                OLD.categoria, OLD.familia, OLD.oficina);
    END // 
DELIMITER ;

#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------
#  CURSORES
#------------------------------------------------------------------------------------------------------
#	- Creamos un cursor cuya finalidad será restaurar la tabla oficinas tras un borrado a partir de las
#		tuplas que hay en la tabla oficinasOLD
#------------------------------------------------------------------------------------------------------
DELIMITER //
	DROP PROCEDURE IF EXISTS restaurarOficinas //
    CREATE PROCEDURE restaurarOficinas()
		BEGIN
			DECLARE	FIN	INT	DEFAULT	FALSE;		-- variable asociada al bucle
            
            DECLARE var_id		INT;
			DECLARE	var_nom		VARCHAR( 40 );
			DECLARE	var_dom 	VARCHAR( 40 );
            DECLARE	var_loc		VARCHAR( 20 );
            DECLARE	var_cp		VARCHAR(  5 );

            DECLARE	cursorOficinas	CURSOR FOR SELECT * FROM oficinasOLD;	-- variable cursor que leerá cada tupla de la tabla oficinasOLD
            DECLARE	CONTINUE	HANDLER FOR NOT	FOUND	SET FIN = TRUE;		-- la variabla asociada al bucle cambiará de valor cuando ya no haya ninguna tupla que leer
            
			OPEN cursorOficinas;	-- se inicia el valor del cursor sobre las tuplas de la tabla oficinasOLD
			leerOficinas:	LOOP
				FETCH cursorOficinas INTO var_id, var_nom, var_dom, var_loc, var_cp;	-- se lee los valores de los atributos asociados a cada tupla, uno a uno
				IF	FIN	THEN
					LEAVE	leerOficinas;	-- si no hay más tuplas que leer salimos de este bucle
                END IF;
        
				IF EXISTS (	SELECT * FROM oficinas WHERE identificador = var_id )	THEN		-- si ya existe el atributo en la tabla sólo es modificar (ej. tras modificar)
					UPDATE oficinas SET nombre = var_nom, domicilio = var_dom, localidad = var_loc, codigo_postal = var_cp
						WHERE identificador = var_id;
				ELSE																			-- si NO existe el atributo en la tabla hay que añadir (ej. tras borrar)
					INSERT oficinas VALUES ( var_id, var_nom, var_dom, var_loc, var_cp );
				END IF;
			END LOOP;
			CLOSE cursorOficinas;		-- se cierra el cursor
		END // 
DELIMITER ;
#------------------------------------------------------------------------------------------------------
#	- Creamos un cursor cuya finalidad será restaurar la tabla familias tras un borrado a partir de las
#		tuplas que hay en la tabla familiasOLD
#------------------------------------------------------------------------------------------------------
DELIMITER //
	DROP PROCEDURE IF EXISTS restaurarFamilias //
	CREATE PROCEDURE restaurarFamilias()
		BEGIN
			DECLARE	FIN	INT	DEFAULT	FALSE;		-- variable asociada al bucle
            
            DECLARE var_id		INT;
			DECLARE var_nom VARCHAR(40);
            DECLARE var_fam INT;
            DECLARE var_ofi INT;

            DECLARE	cursorFamilias	CURSOR FOR SELECT * FROM familiasOLD;	-- variable cursor que leerá cada tupla de la tabla oficinasOLD
            DECLARE	CONTINUE	HANDLER FOR NOT	FOUND	SET FIN = TRUE;		-- la variabla asociada al bucle cambiará de valor cuando ya no haya ninguna tupla que leer
            
			OPEN cursorFamilias;	-- se inicia el valor del cursor sobre las tuplas de la tabla oficinasOLD
			leerFamilias:	LOOP
				FETCH cursorFamilias INTO var_id, var_nom, var_fam, var_ofi;	-- se lee los valores de los atributos asociados a cada tupla, uno a uno
				IF	FIN	THEN
					LEAVE	leerFamilias;	-- si no hay más tuplas que leer salimos de este bucle
                END IF;
        
				IF EXISTS (	SELECT * FROM familias WHERE identificador = var_id )	THEN		-- si ya existe el atributo en la tabla sólo es modificar (ej. tras modificar)
					UPDATE familias SET nombre = var_nom, familia = var_fam, oficina = var_ofi
						WHERE identificador = var_id;
				ELSE																			-- si NO existe el atributo en la tabla hay que añadir (ej. tras borrar)
					INSERT oficinas VALUES ( var_id, var_nom, IFNULL(var_fam,NULL), IFNULL(var_ofi,NULL) );
				END IF;
			END LOOP;
			CLOSE cursorFamilias;		-- se cierra el cursor
		END // 
DELIMITER ;
#------------------------------------------------------------------------------------------------------
#	- Creamos un cursor cuya finalidad será restaurar la tabla agentes tras un borrado a partir de las
#		tuplas que hay en la tabla agentesOLD
#------------------------------------------------------------------------------------------------------
DELIMITER //
	DROP PROCEDURE IF EXISTS restaurarAgentes //
	CREATE PROCEDURE restaurarAgentes()
		BEGIN
			DECLARE	FIN	INT	DEFAULT	FALSE;		-- variable asociada al bucle
            
            DECLARE var_id		INT;
			DECLARE var_nom VARCHAR(60);
            DECLARE var_usu VARCHAR(20);
            DECLARE var_cla VARCHAR(20);
            DECLARE var_hab INT;
            DECLARE var_cat INT;
            DECLARE var_fam INT;
            DECLARE var_ofi INT;

            DECLARE	cursorAgentes CURSOR FOR SELECT * FROM agentesOLD;	-- variable cursor que leerá cada tupla de la tabla oficinasOLD
            DECLARE	CONTINUE	HANDLER FOR NOT	FOUND	SET FIN = TRUE;		-- la variabla asociada al bucle cambiará de valor cuando ya no haya ninguna tupla que leer
            
			OPEN cursorAgentes;	-- se inicia el valor del cursor sobre las tuplas de la tabla oficinasOLD
			leerAgentes:	LOOP
				FETCH cursorAgentes INTO var_id, var_nom, var_usu, var_cla, var_hab, var_cat, var_fam, var_ofi;	-- se lee los valores de los atributos asociados a cada tupla, uno a uno
				IF	FIN	THEN
					LEAVE	leerAgentes;	-- si no hay más tuplas que leer salimos de este bucle
                END IF;
        
				IF EXISTS (	SELECT * FROM agentes WHERE identificador = var_id )	THEN		-- si ya existe el atributo en la tabla sólo es modificar (ej. tras modificar)
					UPDATE agentes 
                    SET nombre = var_nom, usuario = var_usu, clave = var_cla, habilidad = var_hab, 
                        categoria = var_cat, familia = var_fam, oficina = var_ofi
						WHERE identificador = var_id;
				ELSE																			-- si NO existe el atributo en la tabla hay que añadir (ej. tras borrar)
					INSERT agentes VALUES ( var_id, var_nom, var_usu, var_cla, var_hab, var_cat, var_fam, var_ofi );
				END IF;
			END LOOP;
			CLOSE cursorAgentes;		-- se cierra el cursor
		END //
DELIMITER ;
#------------------------------------------------------------------------------------------------------
#	- Creamos un procedimiento cuya finalidad es borrar todas las tuplas de las tablas agentes, familias 
#		y oficinas (son tres sentencias básicas de sql).
#------------------------------------------------------------------------------------------------------
DELIMITER //
	DROP PROCEDURE IF EXISTS borrarDatos //
	CREATE PROCEDURE borrarDatos()
    BEGIN
        DELETE FROM agentes;
        DELETE FROM familias;
        DELETE FROM oficinas;
    END //
DELIMITER ;
#------------------------------------------------------------------------------------------------------
#	- Creamos un procedimiento cuya finalidad es restaurar las tuplas de las tablas agentes, familias 
#		y oficinas (son llamadas a los tres procedimientos de restaurar creados previamente).
#------------------------------------------------------------------------------------------------------
DELIMITER //
	DROP PROCEDURE IF EXISTS restaurarDatos //
	CREATE PROCEDURE restaurarDatos()
    BEGIN
    		CALL restaurarOficinas();
    		CALL restaurarFamilias();
        	CALL restaurarAgentes();   
    END //
DELIMITER ;
#------------------------------------------------------------------------------------------------------
#	- Creamos un procedimiento cuya finalidad es incrementar la categoría de los agentes en una unidad.
#		El procedimiento se realizará a través del cursor
#------------------------------------------------------------------------------------------------------
DELIMITER //
	DROP PROCEDURE IF EXISTS aumentarCategoriaAgentes //
	CREATE PROCEDURE aumentarCategoriaAgentes()
		BEGIN
			DECLARE FIN INT DEFAULT FALSE;		-- variable asociada al bucle
            
			DECLARE var_id	INT;		-- variable que se leerá de cada tupla: identificador
			DECLARE var_cat INT;		-- variable que se leerá de cada tupla: categoría

			DECLARE cursorAgentes CURSOR FOR SELECT identificador, categoria FROM agentes;	-- variable cursor que leerá cada tupla (dos atributos únicamente) de la tabla oficinasOLD
			DECLARE CONTINUE HANDLER FOR NOT FOUND SET FIN = TRUE;							-- la variabla asociada al bucle cambiará de valor cuando ya no haya ninguna tupla que leer

			OPEN cursorAgentes;		-- se inicia el valor del cursor sobre las tuplas de la tabla oficinasOLD
			leerAgentes: LOOP
				FETCH cursorAgentes INTO var_id, var_cat;		-- se lee los valores de los dos atributos asociados a cada tupla
				IF FIN THEN
					LEAVE leerAgentes;		-- si no hay más tuplas que leer salimos de este bucle
				END IF;
        
				UPDATE agentes SET categoria = categoria + 1 WHERE identificador = var_id;		-- se incrementa la categoría de cada agente, uno a uno
			END LOOP;
			CLOSE cursorAgentes;		-- se cierra el cursor
		END // 
DELIMITER ;
#------------------------------------------------------------------------------------------------------
DELIMITER //
	DROP PROCEDURE IF EXISTS disminuirCategoriaAgentes //
	CREATE PROCEDURE disminuirCategoriaAgentes()
		BEGIN
			DECLARE FIN INT DEFAULT FALSE;		-- variable asociada al bucle
            
			DECLARE var_id	INT;		-- variable que se leerá de cada tupla: identificador
			DECLARE var_cat INT;		-- variable que se leerá de cada tupla: categoría

			DECLARE cursorAgentes CURSOR FOR SELECT identificador, categoria FROM agentes;	-- variable cursor que leerá cada tupla (dos atributos únicamente) de la tabla oficinasOLD
			DECLARE CONTINUE HANDLER FOR NOT FOUND SET FIN = TRUE;							-- la variabla asociada al bucle cambiará de valor cuando ya no haya ninguna tupla que leer

			OPEN cursorAgentes;		-- se inicia el valor del cursor sobre las tuplas de la tabla oficinasOLD
			leerAgentes: LOOP
				FETCH cursorAgentes INTO var_id, var_cat;		-- se lee los valores de los dos atributos asociados a cada tupla
				IF FIN THEN
					LEAVE leerAgentes;		-- si no hay más tuplas que leer salimos de este bucle
				END IF;
        
				UPDATE agentes SET categoria = categoria - 1 WHERE identificador = var_id;		-- se incrementa la categoría de cada agente, uno a uno
			END LOOP;
			CLOSE cursorAgentes;		-- se cierra el cursor
		END // 
DELIMITER ;
#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------

CALL agregarDatos();	CALL mostrarDatos();
select obtenerNombreFamilia( 10 ) AS 'Nombre de Familia';
select obtenerNombreFamilia( 11 ) AS 'Nombre de Familia';

# modificamos los atributos nombre
update oficinas		set nombre = 'Vigo'	where nombre = 'Madrid';
update familias		set nombre = REPLACE( nombre, 'a', 'e' );
update agentes		set nombre = REPLACE( nombre, ' ', '' );

CALL mostrarDatos();	CALL restaurarDatos();
CALL borrarDatos();		CALL mostrarDatos();
CALL restaurarDatos();	CALL mostrarDatos();
