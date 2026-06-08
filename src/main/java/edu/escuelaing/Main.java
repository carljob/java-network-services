package edu.escuelaing;

import edu.escuelaing.urls.Ejercicio_1.URLInfo;
import edu.escuelaing.urls.Ejercicio_2.URLBrowser;
import edu.escuelaing.sockets.EchoServer;
import edu.escuelaing.sockets.EchoClient;
import edu.escuelaing.sockets.SquareServer;
import edu.escuelaing.sockets.SquareClient;
import edu.escuelaing.sockets.TrigServer;
import edu.escuelaing.sockets.TrigClient;
import edu.escuelaing.sockets.HttpServer;
import edu.escuelaing.sockets.MultiHttpServer;
import edu.escuelaing.datagramas.TimeServer;
import edu.escuelaing.datagramas.TimeClient;
import edu.escuelaing.rmi.ChatServer;
import edu.escuelaing.rmi.ChatClient;

import java.util.Scanner;

/**
 * Main menu to run all exercises without using the terminal
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n========================================");
            System.out.println("   ARSW - Java Network Services");
            System.out.println("========================================");
            System.out.println("--- Section 3: URLs ---");
            System.out.println(" 1. Exercise 1    - URL Methods (URLInfo)");
            System.out.println(" 2. Exercise 2    - URL Browser (save to resultado.html)");
            System.out.println("--- Section 4: TCP Sockets ---");
            System.out.println(" 3. Exercise 4    - Echo Server        [terminal 1]");
            System.out.println(" 4. Exercise 4    - Echo Client        [terminal 2]");
            System.out.println(" 5. Exercise 4.3.1 - Square Server     [terminal 1]");
            System.out.println(" 6. Exercise 4.3.1 - Square Client     [terminal 2]");
            System.out.println(" 7. Exercise 4.3.2 - Trig Server       [terminal 1]");
            System.out.println(" 8. Exercise 4.3.2 - Trig Client       [terminal 2]");
            System.out.println(" 9. Exercise 4.4   - HTTP Server       [terminal 1 - browser at localhost:35000]");
            System.out.println("10. Exercise 4.5.1 - Multi HTTP Server [terminal 1 - browser at localhost:35003]");
            System.out.println("--- Section 5: UDP Datagrams ---");
            System.out.println("11. Exercise 5.2.1 - Time Server UDP   [terminal 1]");
            System.out.println("12. Exercise 5.2.1 - Time Client UDP   [terminal 2]");
            System.out.println("--- Section 6: RMI ---");
            System.out.println("13. Exercise 6.4.1 - Chat Server RMI   [terminal 1]");
            System.out.println("14. Exercise 6.4.1 - Chat Client 1 RMI [terminal 2]");
            System.out.println("15. Exercise 6.4.1 - Chat Client 2 RMI [terminal 3]");
            System.out.println(" 0. Exit");
            System.out.println("========================================");
            System.out.print("Select an option: ");

            String option = scanner.nextLine();

            switch (option) {
                case "1":  URLInfo.main(args); break;
                case "2":  URLBrowser.main(args); break;
                case "3":  EchoServer.main(args); break;
                case "4":  EchoClient.main(args); break;
                case "5":  SquareServer.main(args); break;
                case "6":  SquareClient.main(args); break;
                case "7":  TrigServer.main(args); break;
                case "8":  TrigClient.main(args); break;
                case "9":  HttpServer.main(args); break;
                case "10": MultiHttpServer.main(args); break;
                case "11": TimeServer.main(args); break;
                case "12": TimeClient.main(args); break;
                case "13": ChatServer.main(args); break;
                case "14": ChatClient.main(args); break;
                case "15": ChatClient.main(args); break;
                case "0":
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }
}