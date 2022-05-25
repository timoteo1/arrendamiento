# How to install

Dentro de la carpeta, se encuentra un archivo `docker-compose.yaml` que contiene una imagen de [MariaDB](https://mariadb.org/) y otra de [phpMyAdmin](https://www.phpmyadmin.net/).

Para correr el comando `docker compose` y poder initializar la base de datos de prueba, se debe tener instalado:

- [Docker](https://docs.docker.com/get-docker/)
- [Docker Compose](https://docs.docker.com/compose/install/)

## Instalacion

- Ubicarse en la carpeta `root` del proyecto (donde el archivo `docker-compose.yaml` se encuentra)
- Ejecutar `docker-compose up` para inicializar Docker y la base de datos.
- phpMyAdmin va a ser ejecutado en http://localhost:8080
  - Las credenciales de Login para phpMyAdmin son (pueden encontrarse en el docker-compose.yaml):
    - User: admin
    - Password: admin
