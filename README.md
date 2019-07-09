# XpertGroupAccessTest

## Despliegue

Para la ejecución se usó Spring Boot junto con gradle, por lo tanto pueden correr el proyecto de la siguiente manera:

```bash
gradle bootRun
```

Lo cual despliega el servidor en la dirección local [http://localhost:8080](http://localhost:8080), el servicio REST (POST) está ubicado en [http://localhost:8080/public/services/solution](http://localhost:8080/public/services/solution).

Finalmente, si se quiere probar desde consola windows el servicio, basta con correr el siguiente comando teniendo curl instalado:

```bash
curl -i -X POST -H "Content-Type:application/json" -d "{\"data\": \"2\n4 5\nUPDATE 2 2 2 4\nQUERY 1 1 1 3 3 3\nUPDATE 1 1 1 23\nQUERY 2 2 2 4 4 4\nQUERY 1 1 1 3 3 3\n2 4\nUPDATE 2 2 2 1\nQUERY 1 1 1 1 1 1\nQUERY 1 1 1 2 2 2\nQUERY 2 2 2 2 2 2\n\" }" http://localhost:8080/public/services/solution
```

La data ingresada es el caso de prueba dado en HackerRank.

## Arquitectura

La arquitectura propuesta se compone de 4 componentes principales, adicionalmente, una visualización sencilla para el tratamiento de los datos por medio de un servicio REST.

1. Controller: Maneja la comunicación entre los servicios del Back y el front, lo realiza por medio de una petición POST, la cual recibe la información como la representación string de un Json

2. Application: Contiene los servicios del Back, la implementación y la comunicación.

3. Persistence: Maneja los datos, como el parseo y la comunicación con el modelo.

4. Model: Modelo de la solución del problema, se planteó la solución por medio de arboles binarios (FenwickTree) con el fin de mantener la eficiencia. En este repositorio hay algunos casos de prueba en XpertGroupAccessTest/src/main/resources/

![](/img/basicArquitecture.png)

Adicionalmente las clases modeladas fueron:

1. AccessTestAPIController: Controlador del servicio REST - Se usó spring boot junto con gradle para el desarrollo
2. AccessTestServices: Definición de los servicios
3. AccessTestServicesImpl: Implementación de los servicios
4. ParserData: Se encargó de manejar el tratamiento de la data y la verificación de consistencias
5. Cube3D: Almancena la representación del Cubo 3D y maneja las operaciones sobre el cubo
6. FenwickTree3D: Algoritmo encargado de realizar operaciones sobre un cubo cualquiera
7. Point3D: Puntos de ubicación tridimensionales
8. Persistence Exception: Excepción para verificación de integridad de data

![](/img/ClassDiagram.png)

## Preguntas

1. ¿En qué consiste el principio de responsabilidad única?

Hace parte de los principios SOLID - Indica que cada clase debe encapsular totalmente su funcionalidad indicada, incluyendo de forma integral los servicios que ofrece, si la clase tiene más de una responsabilidad, estas deberían estar acopladas.

2. ¿Qué es código limpio?

El código limpio, es aquel que es claro y poco redundante, entre otros aspectos. Este tipo de código es fácilmente mantenible, entendible y extensible por otro programador en la medida de lo posible. Adicionalmente, cuenta con pruebas que lo verifican.
