# homeDataService

Una API Rest que utiliza Spring Boot y que se genera utilizando el fichero el plugin de maven para OpenApi generator
project.

OpenAPI specification file -> resources/restAPI.yalm

Para generar la API REST en funcion del fichero -> mvn clean install

Para implementar la logica de negocio de los servicios, hay que implementar las interfaces delegadas que genera el plugin
de maven y que por defecto devuelven un HttpStatus.NOT_IMPLEMENTED.

Este proyecto utiliza un conector con MongoDB para almacenar datos. Para que la conexión funcione, hay que utilizar
la opción de JVM -Djdk.tls.client.protocols=TLSv1.2
