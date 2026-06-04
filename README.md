Ejercicio 1 - Métodos de un objeto URL

Se crea un objeto URL con una dirección completa que incluye protocolo, host, puerto, path, query y referencia. Se imprimen los 8 métodos disponibles: getProtocol, getAuthority, getHost, getPort, getPath, getQuery, getFile y getRef, mostrando cómo Java permite descomponer una URL en sus partes.

![img.png](docs/images/img.png)

Exercise 2 - URL Browser

A simple browser that asks the user to enter a URL, reads its HTML content
line by line using a BufferedReader connected to the URL stream, and saves
the result in a file called resultado.html in the root of the project.
The program uses Scanner to receive the URL from the user, openStream() to
open a connection to the remote resource, and FileWriter to write the
content to disk. Once saved, the file can be opened in any browser to
render the page locally.

![img2.png](docs/images/img2.png)

![img3.png](docs/images/img3.png)

![img4.png](docs/images/img4.png)