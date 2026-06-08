package edu.escuelaing.sockets;

import java.io.*;
import java.net.*;

/**
 * Exercise 4.4 - Basic web server that handles one HTTP request
 * and returns a simple HTML page
 */
public class HttpServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(35000);
            System.out.println("Ready to receive...");
        } catch (IOException e) {
            System.err.println("Could not listen on port 35000");
            System.exit(1);
        }

        Socket clientSocket = null;

        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed");
            System.exit(1);
        }

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));

        String inputLine, outputLine;

        while ((inputLine = in.readLine()) != null) {
            System.out.println("Received: " + inputLine);
            if (!in.ready()) {
                break;
            }
        }

        outputLine = "HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html\r\n"
                + "\r\n"
                + "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<meta charset=\"UTF-8\">"
                + "<title>ARSW</title>"
                + "<style>"
                + "@import url('https://fonts.googleapis.com/css2?family=Share+Tech+Mono&display=swap');"
                + "* { margin: 0; padding: 0; box-sizing: border-box; }"
                + "body { background-color: #000010; font-family: 'Share Tech Mono', monospace; overflow: hidden; height: 100vh; display: flex; align-items: center; justify-content: center; }"
                + ".stars { position: fixed; top: 0; left: 0; width: 100%; height: 100%; background: radial-gradient(ellipse at bottom, #0d1b4b 0%, #000010 100%); z-index: 0; }"
                + ".stars::before { content: ''; position: absolute; width: 100%; height: 100%; background-image: radial-gradient(white 1px, transparent 1px); background-size: 50px 50px; opacity: 0.3; }"
                + ".stars::after { content: ''; position: absolute; width: 100%; height: 100%; background-image: radial-gradient(white 1px, transparent 1px); background-size: 100px 100px; opacity: 0.15; }"
                + ".container { position: relative; z-index: 1; background: rgba(255,255,255,0.05); border: 1px solid rgba(255,255,255,0.15); border-radius: 16px; padding: 60px 80px; max-width: 900px; width: 90%; backdrop-filter: blur(10px); }"
                + ".nav { display: flex; justify-content: space-between; align-items: center; margin-bottom: 60px; font-size: 0.7em; color: rgba(255,255,255,0.4); letter-spacing: 2px; }"
                + ".nav .logo { color: white; font-size: 1.1em; letter-spacing: 4px; }"
                + ".nav .btn { border: 1px solid rgba(255,255,255,0.3); padding: 8px 16px; border-radius: 20px; color: white; }"
                + "h1 { color: white; font-size: 3.5em; letter-spacing: 4px; line-height: 1.3; margin-bottom: 30px; }"
                + ".quote { color: rgba(255,255,255,0.45); font-size: 0.95em; letter-spacing: 2px; line-height: 1.8; border-left: 2px solid rgba(255,255,255,0.2); padding-left: 20px; margin-bottom: 40px; }"
                + ".sub { color: rgba(255,255,255,0.5); font-size: 0.75em; letter-spacing: 3px; margin-bottom: 10px; }"
                + ".footer { margin-top: 60px; font-size: 0.65em; color: rgba(255,255,255,0.2); letter-spacing: 3px; }"
                + "</style>"
                + "</head>"
                + "<body>"
                + "<div class='stars'></div>"
                + "<div class='container'>"
                + "<div class='nav'>"
                + "<span class='logo'>ARSW</span>"
                + "<span>PORT 35000 — RUNNING</span>"
                + "<span class='btn'>2026-I</span>"
                + "</div>"
                + "<div class='sub'>ARQUITECTURA DE SOFTWARE —</div>"
                + "<h1>JAVA WEB<br>SERVER</h1>"
                + "<div class='quote'>"
                + "Si fueras una ventana emergente,<br>"
                + "no me importaria que me bloquearas<br>"
                + "la vista todo el dia."
                + "</div>"
                + "<div class='footer'>ESCUELA COLOMBIANA DE INGENIERIA — TALLER CALL & RETURN</div>"
                + "</div>"
                + "</body>"
                + "</html>";

        out.println(outputLine);
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}