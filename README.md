# Prueba técnica desarrollador backend

## Descripción

Masivian es un API Rest desarrollada sobre Java con Spring Boot donde existen los dos endpoints solicitados en la prueba.

## Compilación

Es necesario que el proyecto MasivianService se construya con sus dependencias para realizar las descarga de estas.

## Instalación

Ejecutar el script de base de datos para obtener todo el modelo planteado, dicho modelo está construido con Postgresql bajo el puerto por defecto 5432. 

Luego es necesario exponer el MasivianService. El servicio Java está configurado para que sea accedido por el puerto 8080.

En el momento que se exponga el API es posible acceder a la documentación swagger de la misma mediante la URL: http://localhost:8080/swagger-ui.html y en esta se podrán testear los endpoints.

## Autor

* **Anderson Vega**