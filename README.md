ARSW - Java Network Services
=============================

Descripción
-----------

Proyecto de apoyo para el curso de redes en Java. Contiene paquetes con ejercicios
sobre diferentes mecanismos de comunicación en Java: manejo de URLs, sockets TCP,
datagramas UDP y RMI.

Paquetes
--------

- `edu.escuelaing.urls` - Ejemplos y ejercicios con la API java.net.URL y URLConnection.
- `edu.escuelaing.sockets` - Ejercicios para crear servidores y clientes TCP usando ServerSocket y Socket.
- `edu.escuelaing.datagramas` - Ejercicios con DatagramSocket/DatagramPacket para comunicación UDP.
- `edu.escuelaing.rmi` - Ejercicios sobre Java RMI: interfaces remotas, implementaciones y despliegue.

Ejercicios
----------

Marque las casillas cuando complete cada ejercicio.

1. [ ] Ejercicio 1
2. [ ] Ejercicio 2
3. [ ] Ejercicio 3
4. [ ] Ejercicio 4
5. [ ] Ejercicio 5
6. [ ] Ejercicio 6
6.1. [ ] Ejercicio 6.1
6.2. [ ] Ejercicio 6.2
6.3. [ ] Ejercicio 6.3
6.4. [ ] Ejercicio 6.4
6.4.1. [ ] Ejercicio 6.4.1

Cómo compilar y ejecutar
------------------------

Requisitos: JDK 21 y Maven.

Compilar:

	mvn -DskipTests package

Ejecutar una clase de ejemplo (por ejemplo URLExercises):

	mvn exec:java -Dexec.mainClass="edu.escuelaing.urls.URLExercises"

Nota: las clases incluidas son de apoyo; impleméntelas según las prácticas del curso.


