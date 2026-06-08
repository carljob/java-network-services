package edu.escuelaing.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Starts the RMI registry and publishes the ChatService
 * so clients can find and connect to it by name.
 */
public class ChatServer {

    public static void main(String[] args) {
        try {
            ChatServiceImpl chatService = new ChatServiceImpl();

            Registry registry = LocateRegistry.createRegistry(23000);
            registry.rebind("chatService", chatService);

            System.out.println("Chat server ready on port 23000...");

        } catch (Exception e) {
            System.err.println("Server error:");
            e.printStackTrace();
        }
    }
}