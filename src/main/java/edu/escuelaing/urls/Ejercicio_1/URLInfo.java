package edu.escuelaing.urls.Ejercicio_1;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Exercise 1 - Prints the 8 methods of a URL object
 * using the standard java.net API to decompose a URL into its parts.
 */
public class URLInfo {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://ldbn.escuelaing.edu.co:80/index.html?curso=redes#seccion1");

            System.out.println("Protocol  : " + url.getProtocol());
            System.out.println("Authority : " + url.getAuthority());
            System.out.println("Host      : " + url.getHost());
            System.out.println("Port      : " + url.getPort());
            System.out.println("Path      : " + url.getPath());
            System.out.println("Query     : " + url.getQuery());
            System.out.println("File      : " + url.getFile());
            System.out.println("Reference : " + url.getRef());

        } catch (MalformedURLException e) {
            System.err.println("Malformed URL: " + e.getMessage());
        }
    }
}