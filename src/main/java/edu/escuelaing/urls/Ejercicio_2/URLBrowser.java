package edu.escuelaing.urls.Ejercicio_2;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class URLBrowser {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter URL: ");
        String address = scanner.nextLine();

        URL url = new URL(address);

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(url.openStream()))) {

            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("resultado.html"));

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            writer.close();
            scanner.close();

            System.out.println("Archivo guardado como resultado.html");

        } catch (IOException e) {
            System.err.println(e);
        }
    }
}