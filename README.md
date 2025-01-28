CONTROL VEHÍCULOS

Control Vehículos es una aplicación diseñada para gestionar la entrada y salida de vehículos en un parking privado. Proporciona funcionalidades como el registro de vehículos, la monitorización de entradas y salidas, y la generación de reportes, asegurando un control eficiente y seguro.

Características principales

Gestor de Vehículos: Registro y actualización de la información de los vehículos.

Control de Acceso: Registro de entradas y salidas con fecha y hora.

Seguridad Integrada: Implementación de roles y autenticación mediante Spring Security.

Interfaz Intuitiva: Diseño fácil de usar utilizando Thymeleaf.

Comenzando 🚀

Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas.

Consulta la sección de Despliegue para conocer cómo implementar el proyecto.

Pre-requisitos 📋

Asegúrate de tener las siguientes herramientas instaladas en tu sistema:

Java 17+ - Entorno de desarrollo Java.

Maven - Gestor de dependencias y construcción de proyectos.

SQLite - Base de datos embebida.

Instalación 🔧

Sigue los pasos a continuación para configurar el entorno de desarrollo:

Clona el repositorio:

git clone https://github.com/tu_usuario/control_vehiculos.git

Navega al directorio del proyecto:

cd control_vehiculos

Configura la base de datos:

Crea un archivo SQLite en el directorio del proyecto llamado parking.db.

El esquema de la base de datos se generará automáticamente al iniciar la aplicación.

Configura las propiedades de la aplicación:

Asegúrate de que src/main/resources/application.properties contenga los detalles correctos para la conexión a SQLite.

Compila y ejecuta el proyecto:

mvn spring-boot:run

Uso de la aplicación

Accede a la interfaz web desde tu navegador en:



http://localhost:8080

2. Inicia sesión con las credenciales predeterminadas (configuradas en `application.properties`).

3. Explora las funcionalidades:
    - Registra vehículos.
    - Supervisa entradas y salidas.
    - Genera reportes.

## Estilo de Codificación y Pruebas ⌨️

Incluye pruebas unitarias y de integración para garantizar la calidad del código. Ejecuta las pruebas con el siguiente comando:
```bash
mvn test

Documentación de la API 📁

La documentación de los endpoints de la API se puede consultar utilizando Swagger en:

http://localhost:8080/swagger-ui/

Despliegue 📦

Empaqueta el proyecto en un archivo JAR:

mvn clean package

Ejecuta el JAR generado:

java -jar target/control_vehiculos-0.0.1-SNAPSHOT.jar

Construido con 🛠️

Java Spring Boot - Framework para el backend.

Spring Security - Seguridad y gestión de roles.

Thymeleaf - Motor de plantillas para la interfaz de usuario.

SQLite - Base de datos embebida.

Autor ✍️

[Tu Nombre] - Trabajo inicial - GitHub

Licencia 📄

Este proyecto está bajo la licencia MIT. Consulta el archivo LICENSE para más detalles.

Agradecimientos 🎁

A mi equipo y colaboradores.

A los recursos de código abierto que facilitaron el desarrollo.

💪 Creado con pasión por [Tu Nombre].