package edu.escuelaing.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

/**
 * RMI Chat client that connects to the ChatServer,
 * sends messages and reads messages from other clients.
 */
public class ChatClient {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String user = scanner.nextLine();

        System.out.print("Enter server IP: ");
        String ip = scanner.nextLine();

        try {
            Registry registry = LocateRegistry.getRegistry(ip, 23000);
            ChatService chatService = (ChatService) registry.lookup("chatService");

            System.out.println("Connected! Type your messages. Type 'exit' to quit.");
            System.out.println("Type 'read' to see all messages.");

            String input;
            while (true) {
                input = scanner.nextLine();

                if (input.equals("exit")) break;

                if (input.equals("read")) {
                    List<String> messages = chatService.getMessages();
                    System.out.println("--- Chat history ---");
                    for (String msg : messages) {
                        System.out.println(msg);
                    }
                    System.out.println("--------------------");
                } else {
                    chatService.sendMessage(user, input);
                }
            }

            scanner.close();
            System.out.println("Disconnected.");

        } catch (Exception e) {
            System.err.println("Client error:");
            e.printStackTrace();
        }
    }
}