# WEEK 6 KEY CONTENTS

## CONTORNO SERVIDOR

- Definicion de funciones. En php la convencion de los nombres de las funciones
  dice que deben ser nombres en minuscula y con las palabras separadas por \_
  ejemplo -> es_valor_correcto().
- Se pueden definir parametros con valores por defecto para que sea opcional
  pasarlos. ejemplo-> function hacer_yogurt($sabor, $tipo="acidofilo")
  Importante que los que llevan valor por defecto vayan al final
- Utilizacion de include y require para importar otros archivos de codigo en php.
  Como utilizar las variables **DIR** y **FILE** para utilizar rutas relativas.

## PROGRAMACION

- Pequeña dinamica de grupo donde practicamos los roles de cliente, project manager
  y equipo de desarrollo donde planteabamos unos requisitos al otro grupo y planteabamos
  como implementar una solucion, para posteriormente programarla
- Examen Parcial

## CONTORNO CLIENTE

- Declaracion y uso de funciones en javascript. Varias formas de declararlas, metodo
  tradicional como en otros lenguajes o definicion como variables en funciones anonimas
  o funciones lambda. Tenemos tambien las funciones flecha, declaracion en 1 linea.

```
  function sumar(a,b){
    return a+b;
  }

  const sumar = (a,b){
    return a+b;
  }

  const sumar = (a,b) => a+b;
```

- Las funciones se pueden pasar como argumento a otras funciones cuando se declaran como
  variables

```
  const f = (x){
    return x * x;
  }

  function elevar(f,a){
    return f(a); // devuelve a*a;
  }
```

## Contornos Desarrollo

- Principios básicos de la programación, qué es un lenguaje, paradigmas de programación y qué los caracteriza, y principios básicos de la orientación a objetos.
