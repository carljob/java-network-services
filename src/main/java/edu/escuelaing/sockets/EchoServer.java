package edu.escuelaing.sockets;

import java.io.*;
import java.net.*;

/**
 * Echo Server - Listens on port 35000 and responds
 * to each client message with "Response: " prefix
 */
public class EchoServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(35000);
            System.out.println("Server listening on port 35000...");
        } catch (IOException e) {
            System.err.println("Could not listen on port 35000");
            System.exit(1);
        }

        Socket clientSocket = null;

        try {
            clientSocket = serverSocket.accept();
            System.out.println("Client connected!");
        } catch (IOException e) {
            System.err.println("Accept failed");
            System.exit(1);
        }

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));

        String inputLine, outputLine;

        while ((inputLine = in.readLine()) != null) {
            System.out.println("Message: " + inputLine);
            outputLine = "Response: " + inputLine;
            out.println(outputLine);
            if (outputLine.equals("Response: Bye.")) break;
        }

        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}