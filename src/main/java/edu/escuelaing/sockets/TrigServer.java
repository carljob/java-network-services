package edu.escuelaing.sockets;

import java.io.*;
import java.net.*;

/**
 * Exercise 4.3.2 - Server that calculates trigonometric functions.
 * By default calculates cosine. The function can be changed
 * by sending "fun:sin", "fun:cos" or "fun:tan"
 */
public class TrigServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(35002);
            System.out.println("Trig server listening on port 35002...");
        } catch (IOException e) {
            System.err.println("Could not listen on port 35002");
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
        String currentFunction = "cos";

        while ((inputLine = in.readLine()) != null) {
            System.out.println("Received: " + inputLine);

            if (inputLine.startsWith("fun:")) {
                currentFunction = inputLine.substring(4);
                outputLine = "Function changed to: " + currentFunction;
            } else {
                try {
                    double number = Double.parseDouble(inputLine);
                    switch (currentFunction) {
                        case "sin":
                            outputLine = "sin: " + Math.sin(number);
                            break;
                        case "tan":
                            outputLine = "tan: " + Math.tan(number);
                            break;
                        default:
                            outputLine = "cos: " + Math.cos(number);
                            break;
                    }
                } catch (NumberFormatException e) {
                    outputLine = "Error: not a valid number";
                }
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