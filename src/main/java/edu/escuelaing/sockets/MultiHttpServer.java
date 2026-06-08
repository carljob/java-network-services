package edu.escuelaing.sockets;

import java.io.*;
import java.net.*;
import java.nio.file.*;

/**
 * Exercise 4.5.1 - Web server that handles multiple sequential
 * requests and returns HTML files and images
 */
public class MultiHttpServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(35003);
            System.out.println("Multi HTTP Server listening on port 35003...");
        } catch (IOException e) {
            System.err.println("Could not listen on port 35003");
            System.exit(1);
        }

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");
            handleRequest(clientSocket);
        }
    }

    private static void handleRequest(Socket clientSocket) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        OutputStream out = clientSocket.getOutputStream();

        String requestLine = in.readLine();
        if (requestLine == null) {
            clientSocket.close();
            return;
        }

        System.out.println("Request: " + requestLine);

        while (in.ready()) {
            in.readLine();
        }

        String[] parts = requestLine.split(" ");
        String filePath = parts.length > 1 ? parts[1] : "/";

        if (filePath.equals("/")) {
            filePath = "/index.html";
        }

        File file = new File("src/main/resources/www" + filePath);

        if (file.exists()) {
            String contentType = getContentType(filePath);
            byte[] fileBytes = Files.readAllBytes(file.toPath());

            String header = "HTTP/1.1 200 OK\r\n"
                    + "Content-Type: " + contentType + "\r\n"
                    + "Content-Length: " + fileBytes.length + "\r\n"
                    + "\r\n";

            out.write(header.getBytes());
            out.write(fileBytes);
        } else {
            String response = "HTTP/1.1 404 Not Found\r\n"
                    + "Content-Type: text/html\r\n"
                    + "\r\n"
                    + "<h1>404 - File Not Found</h1>";
            out.write(response.getBytes());
        }

        out.flush();
        clientSocket.close();
    }

    private static String getContentType(String filePath) {
        if (filePath.endsWith(".html")) return "text/html";
        if (filePath.endsWith(".png"))  return "image/png";
        if (filePath.endsWith(".jpg"))  return "image/jpeg";
        if (filePath.endsWith(".css"))  return "text/css";
        if (filePath.endsWith(".js"))   return "application/javascript";
        return "text/plain";
    }
}