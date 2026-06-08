package edu.escuelaing.datagramas;

import java.io.IOException;
import java.net.*;
import java.util.logging.*;

/**
 * Exercise 5.2.1 - UDP Client that requests the current time
 * every 5 seconds. If server is down, keeps the last received time.
 */
public class TimeClient {

    public static void main(String[] args) {
        String lastTime = "No time received yet";

        while (true) {
            try {
                DatagramSocket socket = new DatagramSocket();
                socket.setSoTimeout(3000); // espera 3 segundos max

                byte[] buf = new byte[256];
                InetAddress address = InetAddress.getByName("127.0.0.1");

                DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 45000);
                socket.send(packet);

                packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);

                lastTime = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Time received: " + lastTime);

                socket.close();

            } catch (SocketTimeoutException e) {
                System.out.println("Server unavailable. Last known time: " + lastTime);
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage() + " Last known time: " + lastTime);
            }

            try {
                Thread.sleep(5000); // espera 5 segundos
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}