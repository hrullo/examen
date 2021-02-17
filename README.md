Aplicación examen.


Aplicación realizada con Sprig Boot y pring DATA.



Primero pasos:



*********************************



1- Clonar la aplicación del repositorio.

2- Realizar un build del proyecto ejecutando por consola mvn clean install o configurando los goals en el IDE.

3- Configurar en el properties de la aplicación (src/main/resource/applicationProperties) los datos de la BBDD a utiliar, recordar que para que

la aplicación levante, debe estar creadas las tablas en la BBDD.



Para levantar la aplicación por consola:



1- Se puede utilizar directamente la VM de java, de la manera "java -jar aplicacion.jar"

2- Se puede ejecutar con Maven: mvn spring-boot:run

3- Se puede ejecutar desde el IDE como una Aplicación Java.



Datos  y ejemplo de entrada:



//Cargar un csv



curl -k -s -X POST 'localhost/aoi/v1/cargar' --data "

{"path":"C:\\Users\\marulhem\\Desktop\\RegistroVentas1.csv"}

"



//Guardar entidades y mostrar la personas con la cantidad de Films relacionada

curl -k -s -X GET 'localhost:8080/aoi/v1/guardar'