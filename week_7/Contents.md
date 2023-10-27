# WEEK 7 KEY CONTENTS

## CONTORNO SERVIDOR

- Otro programa para uso de funciones y arrays con validadores en php.
- Scope de las variables en php. Qué es pasar una variable por valor o
  por referencia, y como hacerlo en php. Uso de la funcion unset para
  romper la referencia.(sobre todo cuando se trabaja con arrays)
- Ejemplo con un foreach sobre un array que va modificando al propio array:

```
foreach($array as $clave => &$valor){
  $valor = $valor*2; // Multiplicamos por 2 todos los elementos del array
}
unset($valor); // Importante romper la referencia al final por si mas adelante volvemos a usar $valor
```

## PROGRAMACION

- Conceptos de abstraccion-encapsulación. herencia-polimorfismo con un ejemplo
  de código en Java. Ejemplo muy sencillo de una clase abstracta Animal con sus
  diferentes hijos.

## CONTORNO CLIENTE

- Teoría básica de lo que son los eventos en Javascript y como usarlos para
  reaccionar a las interacciones del usuario con una página web.
- Concepto de lo que es el DOM de un html y cómo acceder desde JavaScript a
  los nodos del DOM para modificar su contenido o añadir nuevo html al documento

## CONTORNOS DESAROLLO

- De los 4 principios de la OO, la herencia es el que produce **mayor ACOPLAMIENTO** entre
  clases, lo cual hace que sea bueno intentar **evitarla** en la medida de lo posible.
- La alta cohesión sí que es deseable.(Por ejemplo que todos los métodos relacionados con cobrar vayan en la clase Cajero).
- La abstracción **NO** tiene nada que ver con ocultación de información.
- Especificación por contrato: tu me dices la rutina y lo que le tengo que pasar al llamarla,
  y luego me dices que me devuelves. (Precondiciones y Postcondiciones).
- En un ADT, lo importante es el **COMPORTAMIENTO**(las operaciones que podemos hacer con el), **NO los DATOS**
- **El problema del gorila y la banana** (Problema de java)
