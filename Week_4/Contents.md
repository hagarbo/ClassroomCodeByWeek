# WEEK 4 KEY CONTENTS

## CONTORNO SERVIDOR

- Conceptos de Algoritmos con bucles (FOR, WHILE, DO WHILE).
- Toma de caminos utilizando SWITCH-CASE
- Arrays. Declaracion y trabajo con arrays simples y asociativos
- Foreach para recorrer los arrays y funciones utiles como push

## PROGRAMACION

- ARRAYS. Como se declaran, como recorrerlos con un bucle FOR,sacando los
  valores por pantalla.

- Aplicacion que solicita numeros al usuario hasta que acierta el generado por
  la funcion random. Trabajo con bucles y entrada de datos desde terminal

- Aplicacion que propone una adivinanza al usuario, lee la respuesta y si no
  es correcta le da una pista. Vuelve a comprobar y le dice si acerto o no.

- Pseudocodigo, Diagramas de flujo y programacion en Java de 3 algoritmos:

  - Algoritmo que pida números hasta que se introduzca un cero.
    Debe imprimir la suma y la media de todos los números introducidos.

  - Algoritmo que calcule las tablas de multiplicar.

  - Aplicación que solicite notas numéricas (S para salir) y muestre
    por pantalla su equivalente en letras (Sobresaliente, notable, bien,
    suficiente, suspenso). Al terminar, deberá mostrar la mayor nota en
    número y letra

## CONTORNO CLIENTE

- Implementacion de algoritmos basicos en JavaScript
- Arrays en Javascript

## CONTORNOS DESENVOLVEMENTO

### Principios SOLID

https://profile.es/blog/principios-solid-desarrollo-software-calidad/

- Srp(Single Responsability Principle). Una rutina debe realizar una UNICA
  tarea.

- Ocp(Open Closed Principle) En POO es un pricipio que dicta que el codigo
  debe estar abiero a la extension(ampliacion de funcionalidad), pero cerrado
  a la modificacion.

- Lsp(Liskov Substitution Principle). Las clases derivadas deben poder
  sustituirse por sus clases base. Si tengo especializaciones de clase,
  por ejemplo de una clase mando a distancia, y defino una clase telefono movil
  que es una especializacion de la primera, el movil deberia poder hacer lo
  mismo que el mando MAS las funcionalidades especificas del movil.

- Isp(Interface Segregation Principle). El tío Bob sugiere: “Haz interfaces que
  sean específicas para un tipo de cliente”, es decir, para una finalidad concreta.
  es preferible contar con muchas interfaces que definan pocos métodos que tener una
  interface forzada a implementar muchos métodos a los que no dará uso.

- Dip(Dependency Inversion Principle). “Depend on abstractions, not on concretions.”

- Polimorfismo(Duck Typing en Python)-> Ejemplo: En Python la expresion:
  3\* 'spam' nos devuelve 'spamspamspam'. Estamos multiplicando un entero
  y un string, algo que en lenguajes tipados seria imposible. Un objeto con
  polimorfismo se comporta de manera diferente en funcion del contexto.

- La interfaz es el conjunto de operaciones que puede realizar un ADT(Dato
  abstracto). Se suele empezar con el diseño de las interfaces y a partid de ahi
  se realiza la implementacion.

https://es.wikipedia.org/wiki/Robert_C._Martin - Conocido como tio Bob, es un guru
sobre las buenas practicas de la programacion. Ver sus Videos

- A dia de hoy los loops en programacion no se usan, se utilizan los streams(flujo de datos)
  https://www.arquitecturajava.com/java-stream/
