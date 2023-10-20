# Bicipalma ADTs

Además de reflexionar sobre cómo trasladar a tu código los conceptos tratados en el documento [Working classes](https://docs.google.com/document/d/1DE9xVc7D0cL7SwTN6HNLOk8PAklZculjR3EriXgQ-vQ/):

https://docs.google.com/document/d/1DE9xVc7D0cL7SwTN6HNLOk8PAklZculjR3EriXgQ-vQ/

este ejercicio sive como introducción a las sesiones sobre qué es programar y paradigmas de programación.

## Consulta el código del proyecto

[Bicipalma](https://github.com/dfleta/bicipalma-streams-jacoco)

https://github.com/dfleta/bicipalma-streams-jacoco

Consulta las clases `Anclajes` y `Anclaje`. 

**Elabora un fichero** markdown, google docs o usando el formato que estimes oportuno (odt, word, PDF, etc.) para **contestar por escrito a las siguientes cuestiones**.

## 1. Razones para crear una clase 

Vamos a reflexionar por qué en el diseño se ha optado por crear una clase `Anclaje` si ya existía la clase `Anclajes`.

Responde a las siguientes preguntas sobre la clase `Anclaje`:

1. ¿Modela un objeto del mundo real? ¿Cuál?
    Sí, representa cada punto de anclaje en donde van sujetas las bicis de cada estación.
2. ¿Modela un ADT? ¿Cuál? 
    También, es un conjunto de datos (la info de si el anclaje esta ocupado o no y qué bicicleta lo ocupa) con un conjunto de operaciones 
    para trabajar sobre ellos (da información acerca del estado del anclaje y nos permite anclar o desanclar una bici del mismo).
3. ¿Cuáles son las operaciones sobre este tipo de dato abstracto?
    Consulta acerca del estado del anclaje y qué bicicleta lo ocupa, así como guardar la información de que una bici ha sido retirada o aparcada en dicho anclaje. 
4. Describe el tipo de dato correspondiente a este ADT. ¿Que tipo de dato es? ¿Incluye algún otro tipo de dato abstracto? ¿Cuál?
    Es basicamente un conjunto de 2 datos o informaciones. Por un lado su estado(libre o ocupado), y por otro que vehiculo(o Movil), en caso de haber alguno lo ocupa. Por tanto sí, incluye otro tipo de dato abtracto en este caso un dato de la interfaz Movil, descrita en la clase Movil.java,
3. ¿De qué modo reduce la complejidad del problema. Fíjate, p.e., en el método  `ocuparAnclaje(int posicion, Movil bici)` de `Anclajes`.
    Lo que hacemos al disponer de la clase anclaje es evitar que el resto de nuestro programa se preocupe por cómo se realiza la operación de anclar una bici a un anclaje. Lo único que debemos hacer es invocar el método ocuparAnclaje y de los detalles de cómo se guardan los datos se ocupa el Anclaje.
4. ¿Aisla la complejidad? ¿Qué operaciones aisla?
    Así, es aísla las operaciones de modo que el cómo se realizan desde fuera no se ve. Sin acceso al código de Anclaje no podríamos saber si el estado acerca de si está libre o no se guarda en una variable booleana, en una variable de otro tipo o si incluso esa información está en una base de datos. Lo único que sabemos es que podemos a través de ella anclar o desanclar una bici y obtener información sobre el estado del anclaje y la bici que lo está ocupando.
5. ¿Qué detalles de implementación esconde al resto de las clases que componen la aplicación? 
    Como decía, nos oculta cómo están almacenados los datos correspondientes a la clase, en este caso el estado del anclaje y la información sobre la bici que lo ocupa.
6. ¿Limita los efectos de los cambios? Piensa un ejemplo de cómo la clase `Anclaje` aisla del resto del código los cambios producidos en su lógica. 
    Por ejemplo, si mañana decidimos que el estado de si está libre o no se guardase en forma de código interno, o que la bici ahora fuera de otro tipo de dato, los cambios realizados a nivel del Anclaje no deberían afectar al resto del programa ya que los metodos publicos para interactuar con la clase no cambiarían, sólo lo haría su estructura interna. 
8. Indica un ejemplo de cómo facilita la reutilización del código, si es que encuentras alguno. 
    Imaginemos que en un futuro se quiere realizar una aplicación similar en otra ciudad, pero con otros requisitos diferentes de autenticacion en el sistema. La parte de los anclajes se podría reutilizar. 
9. ¿Empaqueta operaciones relacionadas entre sí? ¿Cuáles? ¿La clase presenta una alta o baja cohesión?
    Sí, anclar y desanclar bici que son literalmente opuestas. Por tanto la cohesión es alta.
10. ¿Consideras que la clase `Anclaje` ha surgido como resultado de una refactorización? ¿En qué crees que consistió esta refactorización?
    En mi caso diría que al contrario, la clase Anclaje fue la primera abstracción que se me vino a la mente cuando consideré el problema, y al principio no veía la necesidad de tener otra clase Anclajes, sino que más bien consideraba que cada Estación era per se un conjunto de objetos Anclaje. Por tanto entiendo que primero fue Anclaje y Estación, y Anclajes nacería como una refactorización para eliminar o separar complejidad de la clase Estación. 
11. ¿De qué modo la clase respeta o viola el principio SRP? Señala un dónde y cómo lo consigue o no lo consigue.
    Pues se ha comentado arriba, básicamente sin ver la clase, no podemos saber los detalles de cómo mantiene la información, y además está encargada de una tarea, que es mantener la información sobre el estado de sí misma, y su relación o falta de ella con una bicicleta. 
12. ¿De qué modo la clase respeta o viola el principio OCP? Señala un dónde y cómo lo consigue o no lo consigue.
    Este principio también se respeta, la clase funciona por sí misma por que podríamos decir que está cerrada a modificaciones. Del mismo modo se podrían añadir funcionalidades nuevas sin que lo que ya existe se vea afectado. 

## 2. Calidad de una clase

Responde a las siguientes preguntas sobre la clase `Anclajes`:

### Abstraction

* ¿Cuál es el propósito central de la clase?
    Diría que su propósito es gestionar y aislar la implementación de las operaciones relacionadas con los anclajes de cada estación, para mantener esa lógica separada de esa clase a la cual está ligada. 
* ¿Está bien nombrada la clase y su nombre describe su propósito central?
    Personalmente opino que si, al leer el nombre automáticamente se me viene a la cabeza la fila de anclajes de una estación de bicis. 
* ¿La interfaz de la clase deja en claro cómo se debe usar la clase?
* ¿Es la interfaz de la clase lo suficientemente abstracta como para no tener que pensar en cómo se implementan sus servicios? ¿Puedes tratar la clase como una caja negra?
* ¿Los servicios de la clase son lo suficientemente completos como para que otras clases no tengan que interferir con sus datos internos?
* ¿Ha pensado en subdividir la clase en clases de componentes y la ha subdividido tanto como pudo?
    Respondiendo un poco a las 4 en bloque, sí, los nombres de las operaciones son lo suficientemente explicativos para saber qúe hacen sin necesidad de ver cómo lo hacen, lo que hace que se vea a la clase como una caja negra. Las operaciones abarcan lo que está permitido realizar en una estación con los anclajes, y el hecho de tener además una clase anclaje con la información relativa a cada anclaje particular hace que la última preguntan también se responda con un sí. 

### Encapsulación
* ¿La clase minimiza la accesibilidad a sus miembros?
* ¿La clase evita exponer los datos de los miembros?
* ¿La clase oculta sus detalles de implementación a otras clases?
* ¿Evita la clase hacer suposiciones sobre sus usuarios, incluidas sus clases derivadas?
    La respuesta a todas estas preguntas es sí, salvo en un caso, el metodo anclajes que devuelve un array de objetos Anclaje, que sí nos hace suponer que efectivamente la clase mantiene un array de ese tipo en su implementación, además de mostrarnos que la clase Anclaje existe. 
* ¿Es la clase independiente de otras clases? ¿Exhibe alto o bajo acoplamiento?
    No lo es, depende de clase Estación y no tiene sentido sin ella. 
    