### Explique la diferencia entre ejecutar un yield y ejecutar un wait en términos de los estados por los que pasa un proceso que los usa. ¿En qué casos es recomendable usar cada uno?



### Explique cómo afecta el desempeño de un servidor web
- Instalarle un mejor procesador
- Instalarle más memoria

Instalar más memoria (asumiendo que nos referimos a memoria RAM) implica que el
sistema con el que vamos a trabajar tendrá una mayor capacidad de almacenamiento de
datos los cuales puede transferir de forma relativamente rápida al procesador, 
permitiéndonos acceder a una mayor cantidad de datos a la vez durante la ejecución 
de un programa. Cambiar el procesador a uno mejor hará que los procesos a los cuales
le enviamos estos datos funcionen más rápido, sin embargo, gran parte del cómo exactamente
sea "mejor" van a afectar cómo se ejecutan mas rápido, pues por ejemplo, un clockspeed mayor hará
que un proceso individual corra más rápido, mientras que un procesador con más cores nos permitirá 
tener una mayor capacidad de concurrencia dentro de este.


###  Si un programa multithread en java no tiene ninguna variable declarada como estática, ¿puede aún tener problemas de concurrencia? ¿Cómo se podría dar esta situación? Justifique su respuesta.

Siempre que haya una sección crítica dentro del programa, y asumiendo que por el hecho de estar
trabajando con un programa multithread, seguramente necesite consultar una, es importante tener en
cuenta algún tipo de sección crítica, que esta no esté declarada como estática no significa
que vaya a ser una excepción. Una variable no estática puede accederse desde un Thread, y es posible
modelar un programa donde se llamen threads en un método sobre una de estas. Sin embargo, esta forma de
modelar no es necesariamente la mejor, y sería recomendable evitar llegar a ese punto en primer lugar.

### Explique dos ventajas de construir un pool de threads al arranque del servidor para atender clientes de forma concurrente. Indique también los costos en los que se incurre.

Un pool de threads en un servidor nos permite aplicar patrones concurrentes al diseño del sistema, y de forma
implícita en esto, nos permite acceder a la concurrencia como tal, esto implica que vamos a poder atender
varias solicitudes a la vez dentro de un solo programa con algún nivel de atomicidad. Esto es no solo bueno, sino
escencial para una aplicación serverside moderna que pretenda ir a algún tipo de usuario final, como por ejemplo
Facebook. Sin embargo, hay que tener en cuenta que consume más recursos que una aplicación
monothread, y que una implementación que no tenga en cuenta una posible sobrecarga muy posiblemente
se vuelva bastante inestable, e incluso colapse completamente, en caso de alcanzar un límite no previsto.

### En una aplicación multithread donde cada thread maneja su propia zona de datos, pero se comparte el código entre todos, ¿qué mecanismo de sincronización es necesario para asegurar la correcta ejecución de los threads?: monitores, sincronización por evento, ambas o ninguna. Justifique.

Los monitores son utilizados para controlar el acceso a una sección crítica del programa y la sincronización
por eventos es, en esencia, una herramienta de flujo de control que coordina la llegada de varios threads a un
punto en específico. Como podemos ver por estas descripciones, en general no son requeridas por programas que
manejen áreas de datos separadas, sin embargo, como muchas de las cosas dentro del mundo de la programación,
es una respuesta situacional.

### Considere una aplicación bancaria de consignaciones y retiros. Cada operación, recibe como parámetro el monto de la consignación o retiro y el número de cuenta sobre el que se debe hacer la operación. Suponga que una pareja comparte una cuenta bancaria. Si uno de ellos hace un retiro y el otro una consignación, ¿se puede presentar algún problema? Si su respuesta es afirmativa, ¿cómo lo solucionaría? Si su respuesta es negativa, justifique.


### ¿Cuál es la ganancia de usar un pool de threads para implementar un servidor concurrente con respecto a usar simplemente una aplicación monothread para cada conexión? 