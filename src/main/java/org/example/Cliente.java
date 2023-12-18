package org.example;

import redis.clients.jedis.Jedis;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {

        // Inicialización de la conexión con Redis
        Jedis jedis;
        try {
            jedis = new Jedis("127.0.0.1", 6379);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        // Inicio del escáner para leer comandos
        Scanner scanner = new Scanner(System.in);

        // Bucle principal para procesar comandos
        while (true) {
            System.out.println("Introduce un comando:");
            String command = scanner.nextLine();
            String[] parts = command.split(" ");

            // Procesamiento de comandos
            switch (parts[0].toLowerCase()) {
                case "acortar":
                    String url = parts[1];
                    jedis.lpush("RUBEN:URLS_TO_SHORT", url);
                    break;
                case "url":
                    // Comando para obtener la URL original
                    String shortedUrl = parts[1];
                    String originalUrl = jedis.hget("RUBEN:SHORTED_URLS", shortedUrl);
                    System.out.println("URL Original: " + originalUrl);
                    break;
                case "salir":
                    // Comando para salir de la aplicación
                    jedis.close();
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Comando desconocido ");
            }
        }
    }
}