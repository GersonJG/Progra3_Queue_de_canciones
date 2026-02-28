# Queuea de Canciones 

## Descripción
Jar que implementa una **cola (queue)** para gestionar canciones con funciones especificas como:
- Reproducir canciones
- Progres Bar
- Hisotrial de canciones y tiempo total de escucha

## 📦 Instalación

1. **Instalar dependencias:**
```bash
mvn clean install
```
Generar JAR ejecutable:
```bash
mvn clean package
```

Uso:
```bash
java -jar target/queueHandler-0.0.1-SNAPSHOT.jar
```

## Diseño: 
Se uso la estructura umg.edu.gt.Queuehandler
En el cual se encuentran:
-MainHandler (EL cual contiene todo el ejecutable).
-umg.edu.gt.Queuehandler.model
-- Song.Java (Donde se encuentra la estructura las Colas para crear las canciones, con moficaciones en el toString, el constructor de las canciones y los elementos de las canciones

## Prioridad:
La implementacion de la prioridad la hice a través de dos colas las cuáles agregan las canciones a su cola dependiendo del grado de prioridad. Si era Alto = 1 o si era Normal = 2. Luego se reproducia primero todos los elementos almacenados en la cola de prioridad alta y luego la de prioridad normal. Todo esto a través de metodos como  condicionales, validaciones con isEmpty() y toma de excepciones cuando alguna de las colas está vacia, etc.
Luego el reproductor funciona correctamente siguiendo el orden estipulado por las prioridades como se puede ver en el ejemplo de la ejecucion.

## Simulación de Duración:
Aqui se implementaron dos cosas. 
1. La duracion en segundo de la cancion, la cual se ingresa el valor y se le muestra al usuario utilizando un ciclo y una variable temporal (i) que se destruye al finalizar el ciclo y que suma hasta alcanzar la misma duracion que la cancion, esto sumando la tiempo de espera de un segundo pareciera que la cancion se esta reproduciendo mientras se ejecuta el bucle.
2. La Barra de progreso, esta la realice con un StringBuilder el cual utilizar caracteres de gato o numeral (#) y el signo menos (-) que funciona a traves de un blucle for y un calculo para agregar los simbolos a los espacios del String con StringBuilder dando una apariencia de barra de progreso anidada con los segundos de la cancion. 

