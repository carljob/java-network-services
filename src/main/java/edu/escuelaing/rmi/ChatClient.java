package edu.escuelaing.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

/**
 * Exercise 6.4.1 - RMI Chat client with real-time message updates.
 * A background thread constantly checks for new messages while
 * the user can type and send messages at the same time.
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

            Thread readerThread = new Thread(() -> {
                int lastCount = 0;
                while (true) {
                    try {
                        List<String> messages = chatService.getMessages();
                        if (messages.size() > lastCount) {
                            for (int i = lastCount; i < messages.size(); i++) {
                                System.out.println(messages.get(i));
                            }
                            lastCount = messages.size();
                        }
                        Thread.sleep(1000); // revisa cada segundo
                    } catch (Exception e) {
                        System.out.println("Lost connection to server.");
                        break;
                    }
                }
            });

            readerThread.setDaemon(true);
            readerThread.start();

            String input;
            while (true) {
                input = scanner.nextLine();
                if (input.equals("exit")) break;
                chatService.sendMessage(user, input);
            }

            System.out.println("Disconnected.");

        } catch (Exception e) {
            System.err.println("Client error:");
            e.printStackTrace();
        }
    }
}