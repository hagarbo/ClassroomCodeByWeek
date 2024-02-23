#--------------------------------------------------------------------------------------------
#	1.	UTILIZAMOS LA BASE DE DATOS 'NBA'
#--------------------------------------------------------------------------------------------
#	USE <base de datos>
#--------------------------------------------------------------------------------------------

USE NBA;

#--------------------------------------------------------------------------------------------
#	2. 	BORRAMOS Y CREAMOS LOS ROLES
#--------------------------------------------------------------------------------------------
#	Rol asociado a NBA y a cada Conferencia (Este, Oeste) y a cada División (Atlántico, Sudeste, Central, Pacífico, Sudoeste y Noroeste)
#--------------------------------------------------------------------------------------------
#	CREATE ROLE <rol>
#--------------------------------------------------------------------------------------------

DROP ROLE IF EXISTS nba;
CREATE ROLE nba;
DROP ROLE IF EXISTS conferencia_este;
CREATE ROLE conferencia_este;
DROP ROLE IF EXISTS conferencia_oeste;
CREATE ROLE conferencia_oeste;
DROP ROLE IF EXISTS division_atlantico;
CREATE ROLE division_atlantico;
DROP ROLE IF EXISTS division_sudeste;
CREATE ROLE division_sudeste;
DROP ROLE IF EXISTS division_central;
CREATE ROLE division_central;
DROP ROLE IF EXISTS division_pacifico;
CREATE ROLE division_pacifico;
DROP ROLE IF EXISTS division_sudoeste;
CREATE ROLE division_sudoeste;
DROP ROLE IF EXISTS division_noroeste;
CREATE ROLE division_noroeste;

#--------------------------------------------------------------------------------------------
#	3. BORRAMOS Y CREAMOS LAS VISTAS
#--------------------------------------------------------------------------------------------
#	DROP VIEW IF EXISTS <vista>							CREATE VIEW	<vista>	AS <consulta>
#--------------------------------------------------------------------------------------------
#		Vista General de TODOS los Equipos, otra para TODOS los Jugadores, otra para TODAS las Estadísticas y otra para TODOS los partidos
DROP VIEW IF EXISTS NBA_EQUIPOS;					
CREATE VIEW NBA_EQUIPOS
	 	AS SELECT * FROM NBA.equipos;
		
DROP VIEW IF EXISTS NBA_JUGADORES;					
CREATE VIEW NBA_JUGADORES
		AS SELECT * FROM NBA.jugadores;

DROP VIEW IF EXISTS NBA_PARTIDOS;					
CREATE VIEW NBA_PARTIDOS
		AS SELECT * FROM NBA.partidos;

DROP VIEW IF EXISTS NBA_ESTADISTICAS;					
CREATE VIEW NBA_ESTADISTICAS
		AS SELECT * FROM NBA.estadisticas;

#		Vista de Equipos, Jugadores, Estadísticas y Partidos sobre la Conferencia ESTE
    
DROP VIEW IF EXISTS CONFERENCIA_ESTE_EQUIPOS;
CREATE VIEW CONFERENCIA_ESTE_EQUIPOS		
 		AS SELECT * FROM NBA.equipos 		
		WHERE Conferencia = 'East';

DROP VIEW IF EXISTS CONFERENCIA_ESTE_JUGADORES;
CREATE VIEW CONFERENCIA_ESTE_JUGADORES		
 		AS SELECT * FROM NBA.jugadores 		
		WHERE Equipo IN (SELECT Nombre FROM CONFERENCIA_ESTE_EQUIPOS);

DROP VIEW IF EXISTS CONFERENCIA_ESTE_ESTADISTICAS;	
CREATE VIEW CONFERENCIA_ESTE_ESTADISTICAS	
 		AS SELECT * FROM NBA.estadisticas	
		WHERE jugador IN (SELECT codigo FROM CONFERENCIA_ESTE_JUGADORES);

DROP VIEW IF EXISTS CONFERENCIA_ESTE_PARTIDOS;	
CREATE VIEW CONFERENCIA_ESTE_PARTIDOS	
 		AS SELECT * FROM NBA.partidos	
		WHERE equipoLocal IN (SELECT Nombre FROM CONFERENCIA_ESTE_EQUIPOS) 
				AND equipoVisitante IN (SELECT Nombre FROM CONFERENCIA_ESTE_EQUIPOS);

#		Vista de Equipos, Jugadores, Estadísticas y Partidos sobre la Conferencia OESTE 

DROP VIEW IF EXISTS CONFERENCIA_OESTE_EQUIPOS;
CREATE VIEW CONFERENCIA_OESTE_EQUIPOS		
 		AS SELECT * FROM NBA.equipos 		
		WHERE Conferencia = 'West';  

DROP VIEW IF EXISTS CONFERENCIA_OESTE_JUGADORES;	
CREATE VIEW	CONFERENCIA_OESTE_JUGADORES		
		AS SELECT * FROM NBA.jugadores 		
		WHERE Equipo IN (SELECT nombre from CONFERENCIA_OESTE_EQUIPOS);
		
DROP VIEW IF EXISTS CONFERENCIA_OESTE_ESTADISTICAS;	
CREATE VIEW CONFERENCIA_OESTE_ESTADISTICAS	
 		AS SELECT * FROM NBA.estadisticas	
		WHERE jugador IN (SELECT codigo FROM CONFERENCIA_OESTE_JUGADORES);

DROP VIEW IF EXISTS CONFERENCIA_OESTE_PARTIDOS;		
CREATE VIEW CONFERENCIA_OESTE_PARTIDOS		
		AS SELECT * FROM NBA.partidos		
		WHERE EquipoLocal IN (SELECT nombre FROM CONFERENCIA_OESTE_EQUIPOS) 
		AND EquipoVisitante IN (select nombre from CONFERENCIA_OESTE_EQUIPOS);
		
#		Vista de Equipos, Jugadores, Estadísticas y Partidos sobre la División Atlantica
    
DROP VIEW IF EXISTS DIVISION_ATLANTICA_EQUIPOS;		
CREATE VIEW	DIVISION_ATLANTICA_EQUIPOS		
		AS SELECT * FROM NBA.equipos		
		WHERE Division = 'Atlantic';

DROP VIEW IF EXISTS DIVISION_ATLANTICA_JUGADORES;	
CREATE VIEW	DIVISION_ATLANTICA_JUGADORES		
		AS SELECT * FROM NBA.jugadores 		
		WHERE Equipo IN (SELECT nombre from DIVISION_ATLANTICA_EQUIPOS);

DROP VIEW IF EXISTS DIVISION_ATLANTICA_ESTADISTICAS;
CREATE VIEW	DIVISION_ATLANTICA_ESTADISTICAS	
		AS SELECT * FROM NBA.estadisticas	
		WHERE jugador IN (SELECT codigo FROM DIVISION_ATLANTICA_JUGADORES);

DROP VIEW IF EXISTS DIVISION_ATLANTICA_PARTIDOS;		
CREATE VIEW	DIVISION_ATLANTICA_PARTIDOS		
		AS SELECT * FROM NBA.PARTIDOS		
		WHERE EquipoLocal IN (SELECT nombre FROM DIVISION_ATLANTICA_EQUIPOS)
		AND EquipoVisitante IN (select nombre from DIVISION_ATLANTICA_EQUIPOS);


#		Vista de Equipos, Jugadores, Estadísticas y Partidos sobre la División Sudeste

DROP VIEW IF EXISTS DIVISION_SUDESTE_EQUIPOS;		
CREATE VIEW	DIVISION_SUDESTE_EQUIPOS		
		AS SELECT * FROM NBA.equipos		
		WHERE Division = 'Southeast';

DROP VIEW IF EXISTS DIVISION_SUDESTE_JUGADORES;		
CREATE VIEW	DIVISION_SUDESTE_JUGADORES		
		AS SELECT * FROM NBA.jugadores		
		WHERE Equipo 	  IN (SELECT nombre FROM DIVISION_SUDESTE_EQUIPOS);
		
DROP VIEW IF EXISTS DIVISION_SUDESTE_ESTADISTICAS;
CREATE VIEW	DIVISION_SUDESTE_ESTADISTICAS	
		AS SELECT * FROM NBA.estadisticas	
		WHERE jugador IN (SELECT codigo FROM DIVISION_SUDESTE_JUGADORES);

DROP VIEW IF EXISTS DIVISION_SUDESTE_PARTIDOS;		
CREATE VIEW	DIVISION_SUDESTE_PARTIDOS		
		AS SELECT * FROM NBA.PARTIDOS		
		WHERE EquipoLocal IN (SELECT nombre FROM DIVISION_SUDESTE_EQUIPOS)
		AND EquipoVisitante IN (select nombre from DIVISION_SUDESTE_EQUIPOS);

#		Vista de Equipos, Jugadores, Estadísticas y Partidos sobre la División Central

DROP VIEW IF EXISTS DIVISION_CENTRAL_EQUIPOS;		
CREATE VIEW	DIVISION_CENTRAL_EQUIPOS		
		AS SELECT * FROM NBA.equipos		
		WHERE Division = 'Central';
		
DROP VIEW IF EXISTS DIVISION_CENTRAL_JUGADORES;		
CREATE VIEW	DIVISION_CENTRAL_JUGADORES		
		AS SELECT * FROM NBA.jugadores		
		WHERE Equipo 	  IN (SELECT nombre FROM DIVISION_CENTRAL_EQUIPOS);
		
DROP VIEW IF EXISTS DIVISION_CENTRAL_ESTADISTICAS;	
CREATE VIEW	DIVISION_CENTRAL_ESTADISTICAS	
		AS SELECT * FROM NBA.estadisticas
		WHERE jugador 	  IN (SELECT codigo FROM DIVISION_CENTRAL_JUGADORES);

DROP VIEW IF EXISTS DIVISION_CENTRAL_PARTIDOS;		
CREATE VIEW	DIVISION_CENTRAL_PARTIDOS		
		AS SELECT * FROM NBA.PARTIDOS		
		WHERE EquipoLocal IN (SELECT nombre FROM DIVISION_CENTRAL_EQUIPOS)
		AND EquipoVisitante IN (select nombre from DIVISION_CENTRAL_EQUIPOS);

#		Vista de Equipos, Jugadores, Estadísticas y Partidos sobre la División Pacífico

DROP VIEW IF EXISTS DIVISION_PACIFICO_EQUIPOS;		
CREATE VIEW	DIVISION_PACIFICO_EQUIPOS		
		AS SELECT * FROM NBA.equipos		
		WHERE Division = 'Pacific';
		
DROP VIEW IF EXISTS DIVISION_PACIFICO_JUGADORES;		
CREATE VIEW	DIVISION_PACIFICO_JUGADORES		
		AS SELECT * FROM NBA.jugadores		
		WHERE Equipo IN (SELECT nombre FROM DIVISION_PACIFICO_EQUIPOS);
		
DROP VIEW IF EXISTS DIVISION_PACIFICO_ESTADISTICAS;	
CREATE VIEW	DIVISION_PACIFICO_ESTADISTICAS	
		AS SELECT * FROM NBA.estadisticas
		WHERE jugador IN (SELECT codigo FROM DIVISION_PACIFICO_JUGADORES);

DROP VIEW IF EXISTS DIVISION_PACIFICO_PARTIDOS;		
CREATE VIEW	DIVISION_PACIFICO_PARTIDOS		
		AS SELECT * FROM NBA.PARTIDOS		
		WHERE EquipoLocal IN (SELECT nombre FROM DIVISION_PACIFICO_EQUIPOS)
		AND EquipoVisitante IN (select nombre from DIVISION_PACIFICO_EQUIPOS);

#		Vista de Equipos, Jugadores, Estadísticas y Partidos sobre la División Sudoeste

DROP VIEW IF EXISTS DIVISION_SUDOESTE_EQUIPOS;		
CREATE VIEW	DIVISION_SUDOESTE_EQUIPOS		
		AS SELECT * FROM NBA.equipos		
		WHERE Division = 'Southwest';
		
DROP VIEW IF EXISTS DIVISION_SUDOESTE_JUGADORES;		
CREATE VIEW	DIVISION_SUDOESTE_JUGADORES		
		AS SELECT * FROM NBA.jugadores		
		WHERE Equipo 	  IN (SELECT nombre FROM DIVISION_SUDOESTE_EQUIPOS);
		
DROP VIEW IF EXISTS DIVISION_SUDOESTE_ESTADISTICAS;	
CREATE VIEW	DIVISION_SUDOESTE_ESTADISTICAS	
		AS SELECT * FROM NBA.estadisticas
		WHERE jugador 	  IN (SELECT codigo FROM DIVISION_SUDOESTE_JUGADORES);

DROP VIEW IF EXISTS DIVISION_SUDOESTE_PARTIDOS;		
CREATE VIEW	DIVISION_SUDOESTE_PARTIDOS		
		AS SELECT * FROM NBA.PARTIDOS		
		WHERE EquipoLocal IN (SELECT nombre FROM DIVISION_SUDOESTE_EQUIPOS)
		AND EquipoVisitante IN (select nombre from DIVISION_SUDOESTE_EQUIPOS);
		
#		Vista de Equipos, Jugadores, Estadísticas y Partidos sobre la División Noroeste

DROP VIEW IF EXISTS DIVISION_NOROESTE_EQUIPOS;		
CREATE VIEW	DIVISION_NOROESTE_EQUIPOS		
		AS SELECT * FROM NBA.equipos		
		WHERE Division = 'Northwest';
		
DROP VIEW IF EXISTS DIVISION_NOROESTE_JUGADORES;		
CREATE VIEW	DIVISION_NOROESTE_JUGADORES		
		AS SELECT * FROM NBA.jugadores		
		WHERE Equipo 	  IN (SELECT nombre FROM DIVISION_NOROESTE_EQUIPOS);
		
DROP VIEW IF EXISTS DIVISION_NOROESTE_ESTADISTICAS;	
CREATE VIEW	DIVISION_NOROESTE_ESTADISTICAS	
		AS SELECT * FROM NBA.estadisticas
		WHERE jugador 	  IN (SELECT codigo FROM DIVISION_NOROESTE_JUGADORES);

DROP VIEW IF EXISTS DIVISION_NOROESTE_PARTIDOS;		
CREATE VIEW	DIVISION_NOROESTE_PARTIDOS		
		AS SELECT * FROM NBA.PARTIDOS		
		WHERE EquipoLocal IN (SELECT nombre FROM DIVISION_NOROESTE_EQUIPOS)
		AND EquipoVisitante IN (select nombre from DIVISION_NOROESTE_EQUIPOS);
#--------------------------------------------------------------------------------------------


#--------------------------------------------------------------------------------------------
#	4. ASIGNAMOS PRIVILEGIOS (O PERMISOS) A LOS ROLES
#--------------------------------------------------------------------------------------------
#	GRANT <privilegio>	ON <vista>	TO 	<rol>
#--------------------------------------------------------------------------------------------
GRANT ALL ON NBA_EQUIPOS TO nba;
GRANT ALL ON NBA_JUGADORES TO nba;
GRANT ALL ON NBA_ESTADISTICAS TO nba;
GRANT ALL ON NBA_PARTIDOS TO nba;

GRANT ALL ON CONFERENCIA_ESTE_EQUIPOS TO conferencia_este;
GRANT ALL ON CONFERENCIA_ESTE_JUGADORES TO conferencia_este;
GRANT ALL ON CONFERENCIA_ESTE_ESTADISTICAS TO conferencia_este;
GRANT ALL ON CONFERENCIA_ESTE_PARTIDOS TO conferencia_este;

GRANT ALL ON CONFERENCIA_OESTE_EQUIPOS TO conferencia_oeste;
GRANT ALL ON CONFERENCIA_OESTE_JUGADORES TO conferencia_oeste;
GRANT ALL ON CONFERENCIA_OESTE_ESTADISTICAS TO conferencia_oeste;
GRANT ALL ON CONFERENCIA_OESTE_PARTIDOS TO conferencia_oeste;

GRANT ALL ON DIVISION_ATLANTICA_EQUIPOS TO division_atlantico;
GRANT ALL ON DIVISION_ATLANTICA_JUGADORES TO division_atlantico;
GRANT ALL ON DIVISION_ATLANTICA_ESTADISTICAS TO division_atlantico;
GRANT ALL ON DIVISION_ATLANTICA_PARTIDOS TO division_atlantico;

GRANT ALL ON DIVISION_SUDESTE_EQUIPOS TO division_sudeste;
GRANT ALL ON DIVISION_SUDESTE_JUGADORES TO division_sudeste;
GRANT ALL ON DIVISION_SUDESTE_ESTADISTICAS TO division_sudeste;
GRANT ALL ON DIVISION_SUDESTE_PARTIDOS TO division_sudeste;

GRANT ALL ON DIVISION_CENTRAL_EQUIPOS TO division_central;
GRANT ALL ON DIVISION_CENTRAL_JUGADORES TO division_central;
GRANT ALL ON DIVISION_CENTRAL_ESTADISTICAS TO division_central;
GRANT ALL ON DIVISION_CENTRAL_PARTIDOS TO division_central;

GRANT ALL ON DIVISION_PACIFICO_EQUIPOS TO division_pacifico;
GRANT ALL ON DIVISION_PACIFICO_JUGADORES TO division_pacifico;
GRANT ALL ON DIVISION_PACIFICO_ESTADISTICAS TO division_pacifico;
GRANT ALL ON DIVISION_PACIFICO_PARTIDOS TO division_pacifico;

GRANT ALL ON DIVISION_SUDOESTE_EQUIPOS TO division_sudoeste;
GRANT ALL ON DIVISION_SUDOESTE_JUGADORES TO division_sudoeste;
GRANT ALL ON DIVISION_SUDOESTE_ESTADISTICAS TO division_sudoeste;
GRANT ALL ON DIVISION_SUDOESTE_PARTIDOS TO division_sudoeste;

GRANT ALL ON DIVISION_NOROESTE_EQUIPOS TO division_noroeste;
GRANT ALL ON DIVISION_NOROESTE_JUGADORES TO division_noroeste;
GRANT ALL ON DIVISION_NOROESTE_ESTADISTICAS TO division_noroeste;
GRANT ALL ON DIVISION_NOROESTE_PARTIDOS TO division_noroeste;

   
#--------------------------------------------------------------------------------------------
#	5. 	BORRAMOS Y CREAMOS LOS USUARIOS, ASINGNÁNDOLES POR DEFECTO SU ROL ASOCIADO
#	Los usuarios serán creados todos con la misma clave 'abc'
#--------------------------------------------------------------------------------------------
#	CREATE USER <usuario>	IDENTIFIED BY <clave>	DEFAULT ROLE <rol>
#--------------------------------------------------------------------------------------------
#	Fulgencio y Fulgencia
#	Guillermino y Guillermina
#	Pancracio y Pancracia
#	Filomeno y Filomena
#	Anaximandro y Anaximandra
#	Romino y Romina
#	Agapito y Agapita
#	Apolonio y Apolonia
#	Luzdivino y Luzdivina
#--------------------------------------------------------------------------------------------
 
DROP USER IF EXISTS Fulgencio;
CREATE USER Fulgencio IDENTIFIED BY 'abc';
GRANT nba TO Fulgencio;
SET DEFAULT ROLE nba FOR Fulgencio;

DROP USER IF EXISTS Fulgencia;
CREATE USER Fulgencia IDENTIFIED BY 'abc';
GRANT nba TO Fulgencia;
SET DEFAULT ROLE nba FOR Fulgencia;

DROP USER IF EXISTS Guillermino;
CREATE USER Guillermino IDENTIFIED BY 'abc';
GRANT conferencia_este TO Guillermino;
SET DEFAULT ROLE conferencia_este FOR Guillermino;

DROP USER IF EXISTS Guillermina;
CREATE USER Guillermina IDENTIFIED BY 'abc';
GRANT conferencia_este TO Guillermina;
SET DEFAULT ROLE conferencia_este FOR Guillermina;

DROP USER IF EXISTS Pancracio;
CREATE USER Pancracio IDENTIFIED BY 'abc';
GRANT conferencia_oeste TO Guillermino;
SET DEFAULT ROLE conferencia_oeste FOR Guillermino;

DROP USER IF EXISTS Pancracia;
CREATE USER Pancracia IDENTIFIED BY 'abc';
GRANT conferencia_oeste TO Pancracia;
SET DEFAULT ROLE conferencia_oeste FOR Pancracia;

DROP USER IF EXISTS Filomeno;
CREATE USER Filomeno IDENTIFIED BY 'abc';
GRANT division_atlantico TO Filomeno;
SET DEFAULT ROLE division_atlantico FOR Filomeno;

DROP USER IF EXISTS Filomena;
CREATE USER Filomena IDENTIFIED BY 'abc';
GRANT division_atlantico TO Filomena;
SET DEFAULT ROLE division_atlantico FOR Filomena;

DROP USER IF EXISTS Anaximandro;
CREATE USER Anaximandro IDENTIFIED BY 'abc';
GRANT division_sudeste TO Anaximandro;
SET DEFAULT ROLE division_sudeste FOR Anaximandro;

DROP USER IF EXISTS Anaximandra;
CREATE USER Anaximandra IDENTIFIED BY 'abc';
GRANT division_sudeste TO Anaximandra;
SET DEFAULT ROLE division_sudeste FOR Anaximandra;

DROP USER IF EXISTS Romino;
CREATE USER Romino IDENTIFIED BY 'abc';
GRANT division_central TO Romino;
SET DEFAULT ROLE division_central FOR Romino;

DROP USER IF EXISTS Romina;
CREATE USER Romina IDENTIFIED BY 'abc';
GRANT division_central TO Romina;
SET DEFAULT ROLE division_central FOR Romina;

DROP USER IF EXISTS Agapito;
CREATE USER Agapito IDENTIFIED BY 'abc';
GRANT division_pacifico TO Agapito;
SET DEFAULT ROLE division_pacifico FOR Agapito;

DROP USER IF EXISTS Agapita;
CREATE USER Agapita IDENTIFIED BY 'abc';
GRANT division_pacifico TO Agapita;
SET DEFAULT ROLE division_pacifico FOR Agapita;

DROP USER IF EXISTS Apolonio;
CREATE USER Apolonio IDENTIFIED BY 'abc';
GRANT division_sudoeste TO Apolonio;
SET DEFAULT ROLE division_sudoeste FOR Apolonio;

DROP USER IF EXISTS Apolonia;
CREATE USER Apolonia IDENTIFIED BY 'abc';
GRANT division_sudoeste TO Apolonia;
SET DEFAULT ROLE division_sudoeste FOR Apolonia;

DROP USER IF EXISTS Luzdivino;
CREATE USER Luzdivino IDENTIFIED BY 'abc';
GRANT division_noroeste TO Luzdivino;
SET DEFAULT ROLE division_noroeste FOR Luzdivino;

DROP USER IF EXISTS Luzdivina;
CREATE USER Luzdivina IDENTIFIED BY 'abc';
GRANT division_noroeste TO Luzdivina;
SET DEFAULT ROLE division_noroeste FOR Luzdivina;

 
#--------------------------------------------------------------------------------------------
#	6. REFRESCA LOS PRIVILEGIOS
#--------------------------------------------------------------------------------------------
#	FLUSH PRIVILEGES;
#--------------------------------------------------------------------------------------------

FLUSH PRIVILEGES;