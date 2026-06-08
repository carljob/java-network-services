package edu.escuelaing.datagramas;

import java.io.IOException;
import java.net.*;
import java.util.Date;
import java.util.logging.*;

/**
 * Exercise 5.2.1 - UDP Server that responds with the current time
 * when it receives a request
 */
public class TimeServer {

    DatagramSocket socket;

    public TimeServer() {
        try {
            socket = new DatagramSocket(45000);
            System.out.println("Time server listening on port 45000...");
        } catch (SocketException e) {
            Logger.getLogger(TimeServer.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void startServer() {
        byte[] buf = new byte[256];
        try {
            while (true) {
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);

                String time = new Date().toString();
                buf = time.getBytes();

                InetAddress address = packet.getAddress();
                int port = packet.getPort();

                packet = new DatagramPacket(buf, buf.length, address, port);
                socket.send(packet);

                System.out.println("Time sent: " + time);

                buf = new byte[256];
            }
        } catch (IOException e) {
            Logger.getLogger(TimeServer.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static void main(String[] args) {
        TimeServer server = new TimeServer();
        server.startServer();
    }
}