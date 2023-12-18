package org.example;

import redis.clients.jedis.Jedis;
import java.util.Random;

public class Servidor {
    public static void main(String[] args) {

        // Conexión con Redis
        Jedis jedis;
        try {
            jedis = new Jedis("127.0.0.1", 6379);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }


        // Bucle principal para procesar URLs
        while (true) {
            System.out.println("Introduce un comando:");
            String url = jedis.rpop("RUBEN:URLS_TO_SHORT"); // Obtener la URL de la cola

            if (url != null) {

                String shortKey = generarContraseña(8);

// Guardar la URL con su clave corta en Redis
                jedis.hset("RUBEN:SHORTED_URLS", shortKey, url);


                System.out.println("URL acortada: www.midominio.com/" + shortKey);
            }

            // Esperar 1 segundo antes de procesar la siguiente URL
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //Método para generar una clave corta aleatoria
    private static String generarContraseña(int length) {
        String characters = "0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }

        return sb.toString();
    }
}