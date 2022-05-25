# arrendamiento: ejercicio 1 de PRUEBA TECNICA BACKEND ENGINEER

Solución planteada:

1) Descripción de ambiente:
Java versión 8
Base de dato: MariaDB
API de prueba: POSTMAN

2) IMPORTANTE
Dentro de la carpeta myhotel-docker se presenta un yaml que permite levantar una base de datos MariaDB con las tablas creadas para esta aplicación. Hay un archivo how-to.md donde se detalla los pasos a seguir para poder levantar el docker.

En caso de no poder levantar el docker en el directorio "dump" del proyecto esta el dump de la base de datos implementada para la solución del ejercicio.

En el directorio diagrama-bd del proyecto se encuentra el diagrama de la base de datos diseñada para la aplicación.

En el directorio postman dentro del proyecto se encuentra un json con una collection de apis que se puede importar en POSTMAN y poder probar las apis del proyecto. 

3) Ejecución de aplicación:
Ubicarse dentro del proyecto y correr los siguientes comandos:
mvn test
mvn spring-boot:run

2) DETALLE APIS:
* Creación de vehiculos (auto o camion)
 POST: {{urlArrendamiento}}/api/create/vehicle
Estructura del json a enviar en el body para crear un camion:
{
    "tipoVehiculo":"camion",    
    "marca":"Nissan",
    "modelo":2115,
    "patente":"ABC 130",
    "anio": "2018",
    "kilometraje": 50000,
    "cilindrada": 10000,
    "tonelaje":"200000",
    "ejes": 12
}


Estructura del json a enviar en el body para crear un auto:

{
    "tipoVehiculo":"camion",    
    "marca":"Nissan",
    "modelo":2115,
    "patente":"ABC 130",
    "anio": "2018",
    "kilometraje": 50000,
    "cilindrada": 10000,
    "pasajeros":5,
    "capacidadMaletero": 12,
    "puertas":4
}

En la creación de un vehiculo, se deben setear todos los campos del json ya que la base de datos se configuro para no tener valores null.
El campo tipoVehiculo debe ser seteado con los valores auto o camion, dependiendo del tipo de vehiculo que se desea crear.
Dependiendo de si la transacción se completo correctamente o no, la api respondera con un codigo y detalle del status.

* Obtención de vehiculo 
GET: {{urlArrendamiento}}/api/vehicle?{patente}&{tipo}

RequestParams:  patente de tipo String   
                tipo de tipo String  (valores posibles: camion o auto)
Ambos parametros son obligatorios.
Devolvera un json con la información del vehiculo solicitado.

* Listar todos los vehiculos de tipo auto
GET: {{urlArrendamiento}}/api/vehicle/allAutos

Devolvera una lista con la info de todos los vehiculos de tipo auto

* Listar todos los vehiculos de tipo camion
GET: {{urlArrendamiento}}/api/vehicle/allcamiones

Devolvera una lista con la info de todos los vehiculos de tipo camion

* Borrar un vehiculo
DELETE: {{urlArrendamiento}}/api/vehicle/delete/{patente}

PathVariable {patente} de tipo String, obligatorio.

La api devolvera un mensaje detallando si la operacion se pudo realizar correctamente.

* Actualizar vehiculo

{{urlArrendamiento}}/api/vehicle/update?{patente}

PathVariable {patente} de tipo String, obligatorio.

Ejemplo de body para vehiculo de tipo camion:

{
    "tipoVehiculo":"camion",    
    "marca":"Nissan",
    "modelo":2115,
    "patente":"ABC 130",
    "anio": "2018",
    "kilometraje": 50000,
    "cilindrada": 10000,
    "tonelaje":"200000",
    "ejes": 12
}

Ejemplo de estructura del json a enviar en el body para crear un auto:

{
    "tipoVehiculo":"camion",    
    "marca":"Nissan",
    "modelo":2115,
    "patente":"ABC 130",
    "anio": "2018",
    "kilometraje": 50000,
    "cilindrada": 10000,
    "pasajeros":5,
    "capacidadMaletero": 12,
    "puertas":4
}

El único atributo obligatorio del json es tipoVehiculo que indica el tipo de auto que se quiere actualizar, el resto de los campos son opcionales.

La api retornará un json con el detalle de exito o error de la actualización.

* Crear mantención de un auto:

POST: {{urlArrendamiento}}/api/vehicle/mantencion

Ejemplo de estructura del json a enviar en el body:

{
    "km": 100000,
    "detalle": "Cambio de correa de distribucion",
    "patente": "ABC 1523"
}

Todos los atributos son obligatorios

La api devolvera un json con un mensaje de exito o error para la operacion.

* Obtener el listado de mantenciones de un vehiculo en particular

GET: {{urlArrendamiento}}/api/vehicle/mantencion/{patente}

PathVariable {patente} de tipo String, obligatorio.

La api respondera una lista con el detalle de mantenimiento del vehiculo solicitado.

* Eliminar las mantenciones de un vehiculo

DELETE: {{urlArrendamiento}}/api/vehicle/mantencion/{patente}

PathVariable {patente} de tipo String, obligatorio.

La api retornará un json con el detalle de exito o error de la operación.

* Actualizar una mantencion en particular

PUT: {{urlArrendamiento}}/api/vehicle/mantencion/update?{patente}&{id}

PathVariable:  {patente} de tipo String, obligatorio.
               {id} de tipo String, obligatorio. Se debe indicar el numero de registro que se quiere eliminar. Campo MANTENCIONES_ID de la tabla mantenciones