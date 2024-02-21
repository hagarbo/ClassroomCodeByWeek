#--------------------------------------------------------------------------------------------
#	1.	UTILIZAMOS LA BASE DE DATOS 'NBA'
#--------------------------------------------------------------------------------------------
#	USE <base de datos>
#--------------------------------------------------------------------------------------------


#--------------------------------------------------------------------------------------------
#	2. 	BORRAMOS Y CREAMOS LOS ROLES
#--------------------------------------------------------------------------------------------
#	Rol asociado a NBA y a cada Conferencia (Este, Oeste) y a cada División (Atlántico, Sudeste, Central, Pacífico, Sudoeste y Noroeste)
#--------------------------------------------------------------------------------------------
#	CREATE ROLE <rol>
#--------------------------------------------------------------------------------------------


#--------------------------------------------------------------------------------------------
#	3. BORRAMOS Y CREAMOS LAS VISTAS
#--------------------------------------------------------------------------------------------
#	DROP VIEW IF EXISTS <vista>							CREATE VIEW	<vista>	AS <consulta>
#--------------------------------------------------------------------------------------------
#		Vista General de TODOS los Equipos, otra para TODOS los Jugadores, otra para TODAS las Estadísticas y otra para TODOS los partidos
#		Vista de Equipos, Jugadores, Estadísticas y Partidos sobre la Conferencia ESTE
#		Vista de Equipos, Jugadores, Estadísticas y Partidos sobre la Conferencia OESTE
#		Vista de Equipos, Jugadores, Estadísticas y Partidos sobre la División Atlantica
#		Vista de Equipos, Jugadores, Estadísticas y Partidos sobre la División Sudeste
#		Vista de Equipos, Jugadores, Estadísticas y Partidos sobre la División Central
#		Vista de Equipos, Jugadores, Estadísticas y Partidos sobre la División Pacífico
#		Vista de Equipos, Jugadores, Estadísticas y Partidos sobre la División Sudoeste
#		Vista de Equipos, Jugadores, Estadísticas y Partidos sobre la División Noroeste
#--------------------------------------------------------------------------------------------


#--------------------------------------------------------------------------------------------
#	4. ASIGNAMOS PRIVILEGIOS (O PERMISOS) A LOS ROLES
#--------------------------------------------------------------------------------------------
#	GRANT <privilegio>	ON <vista>	TO 	<rol>
#--------------------------------------------------------------------------------------------

   
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
 
 
#--------------------------------------------------------------------------------------------
#	6. REFRESCA LOS PRIVILEGIOS
#--------------------------------------------------------------------------------------------
#	FLUSH PRIVILEGES;
#--------------------------------------------------------------------------------------------

