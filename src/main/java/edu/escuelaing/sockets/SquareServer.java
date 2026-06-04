package edu.escuelaing.sockets;

import java.io.*;
import java.net.*;

/**
 * Exercise 4.3.1 - Server that receives a number
 * and responds with its square
 */
public class SquareServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(35001);
            System.out.println("Square server listening on port 35001...");
        } catch (IOException e) {
            System.err.println("Could not listen on port 35001");
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
            System.out.println("Received: " + inputLine);
            try {
                double number = Double.parseDouble(inputLine);
                outputLine = "Square: " + (number * number);
            } catch (NumberFormatException e) {
                outputLine = "Error: not a valid number";
            }
            out.println(outputLine);
            if (inputLine.equals("Bye.")) break;
        }

        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}