# Cambios propuestos

### A continuación se comentarán los cambios propuestos para el programa con una breve explicación

## Definición de constantes al principio del programa

Se han definido al principio para que resulte más fácil cambiarlos en caso de ser necesarios.

## Cambio de nombres en las variables

Se han elegido nombres de variables más acordes al valor que almacenan y más explicativos.

## Cambio del bucle do-while por un while

El motivo del cambio es no tener que comprobar dos veces en cada iteración si el valor introducido
por el usuario requiere de finalizar el programa. Esto hace que tengamos duplicar la instrucción 
de lectura por teclado para que se ejecute una vez antes del bucle pero overall deberia suponer
una mejora.

## Implementación de un método que muestre información por pantalla

Por limpieza de código en el bucle while se ha decidido implementar un método que realice la 
impresión por pantalla de los datos a mostrar al usuario. 

## Eliminación del if al final del programa

La información relevante al finalizar el programa es el número de negativos introducidos, por lo 
que la condición final ha sido eliminada.
