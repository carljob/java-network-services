package edu.escuelaing.urls;

import java.net.MalformedURLException;
import java.net.URL;
/**
 * Contiene ejercicios y ejemplos relacionados con el manejo de URLs
 * usando la API estándar de java.net (por ejemplo java.net.URL, URLConnection).
 * Cada ejercicio demostrará cómo construir, leer y analizar recursos remotos
 * a través de URLs.
 */
public class URLInfo {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://ldbn.escuelaing.edu.co:80/index.html?curso=redes#seccion1");

            System.out.println("Protocolo  : " + url.getProtocol());
            System.out.println("Authority  : " + url.getAuthority());
            System.out.println("Host       : " + url.getHost());
            System.out.println("Puerto     : " + url.getPort());
            System.out.println("Path       : " + url.getPath());
            System.out.println("Query      : " + url.getQuery());
            System.out.println("File       : " + url.getFile());
            System.out.println("Referencia : " + url.getRef());

        } catch (MalformedURLException e) {
            System.err.println("URL mal formada: " + e.getMessage());
        }
    }
}

