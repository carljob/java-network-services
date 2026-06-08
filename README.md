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

Sockets TCP - Echo Client and Server

Implementation of a basic client-server communication using TCP sockets.
The server listens on port 35000 waiting for a client connection. Once
connected, it reads each message sent by the client and responds with
the prefix "Response: " followed by the original message. The client
connects to the server, reads user input from the console and prints
the server response. The connection closes when the user types "Bye."
Both programs use PrintWriter and BufferedReader to send and receive
messages through the socket streams.

![img5.png](docs/images/img5.png)

![img6.png](docs/images/img6.png)

![img7.png](docs/images/img7.png)

![img8.png](docs/images/img8.png)

![img9.png](docs/images/img9.png)



![img10.png](docs/images/img10.png)

![img11.png](docs/images/img11.png)

Exercise 4.3.2 - Trigonometric Function Server

Server that receives numbers and calculates trigonometric functions.
By default calculates cosine. The active function can be changed by
sending a message starting with "fun:" followed by the function name
(sin, cos, tan). Regular messages are treated as numbers and the
current function is applied to them.

![img12.png](docs/images/img12.png)

![img13.png](docs/images/img13.png)



![img14.png](docs/images/img14.png)

![img15.png](docs/images/img15.png)