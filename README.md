# Servidor URL

Este programa es un servidor simple para acortar URLs, utilizando Redis como almacén de datos. Permite a los usuarios enviar URLs para acortarlas y luego recuperar las URLs originales utilizando claves cortas generadas aleatoriamente.

## Requisitos

- Java JDK 8 o superior
- Redis

## Instalación

1. Clona este repositorio: 

git clone https://github.com/canyonlux/Practica3PSP-REDIS


2. Navega al directorio del proyecto:



## Configuración de Redis

Asegúrate de que Redis esté instalado y ejecutándose en tu máquina local o en un servidor remoto. Por defecto, el programa intentará conectarse a Redis en `127.0.0.1` en el puerto `6379`.



## Uso

Una vez que el servidor esté en funcionamiento, procesará automáticamente las URLs en la cola `URLS_ACORTAR` de Redis y almacenará las URLs acortadas en el hash `URLS_ACORTADAS`.

## Contribuciones


## Licencia



## Contacto

https://github.com/canyonlux
