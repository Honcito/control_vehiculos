<<<<<<< HEAD
CONTROL VEHÍCULOS

Control Vehículos es una aplicación diseñada para gestionar la entrada y salida de vehículos en un parking privado. Proporciona funcionalidades como el registro de vehículos, la monitorización de entradas y salidas, y la generación de reportes, asegurando un control eficiente y seguro.

Características principales

Gestor de Vehículos: Registro y actualización de la información de los vehículos.

Control de Acceso: Registro de entradas y salidas con fecha y hora.

Seguridad Integrada: Implementación de roles y autenticación mediante Spring Security.

Interfaz Intuitiva: Diseño fácil de usar utilizando Thymeleaf.

Comenzando 🚀
=======
# CONTROL VEHÍCULOS

Control Vehículos es una aplicación diseñada para digitalizar el proceso de registro de entrada y salida de vehículos en un parking privado. Su objetivo principal es reducir errores, mejorar la precisión de los datos, facilitar el acceso a registros históricos, generar reportes y garantizar la seguridad y trazabilidad de los datos.

## Características principales

- **Registro Digitalizado:** Registro de la entrada y salida de vehículos con fecha, hora y observaciones.
- **Gestor de Vehículos:** Administración de datos de vehículos, propietarios y empleados.
- **Control de Acceso:** Roles y permisos definidos para empleados y administradores.
- **Seguridad Integrada:** Implementación de Spring Security para la gestión de usuarios y accesos.
- **Reportes:** Generación de reportes y acceso a registros históricos.
- **Interfaz Intuitiva:** Diseño responsivo y multiplataforma con Thymeleaf y Bootstrap.

## Perfiles de usuario

- **Empleado:** Encargado de registrar la entrada y salida de vehículos mediante formularios.
- **Administrador:** Responsable de la gestión de registros históricos, generación de reportes y administración de datos de vehículos, propietarios y empleados (CRUD).

## Comenzando 🚀
>>>>>>> 95fe9d0d815b8ca43c9130e6d8f26b50bf1b388c

Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas.

Consulta la sección de Despliegue para conocer cómo implementar el proyecto.

<<<<<<< HEAD
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
=======
### Pre-requisitos 📋

Asegúrate de tener las siguientes herramientas instaladas en tu sistema:

- **Java 17+** - Entorno de desarrollo Java.
- **Maven** - Gestor de dependencias y construcción de proyectos.
- **SQLite** - Base de datos embebida.

### Instalación 🔧

Sigue los pasos a continuación para configurar el entorno de desarrollo:

1. **Clona el repositorio:**

   ```bash
   git clone https://github.com/tu_usuario/control_vehiculos.git


2. **Navega al directorio del proyecto:**
>>>>>>> 95fe9d0d815b8ca43c9130e6d8f26b50bf1b388c

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

<<<<<<< HEAD


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
=======
http://localhost:8080

Inicia sesión con las credenciales predeterminadas (configuradas en application.properties).

Explora las funcionalidades:

Registro de entradas y salidas de vehículos.

Gestión de datos de vehículos, propietarios y empleados.

Generación y consulta de reportes.

Estilo de Codificación y Pruebas ⌨️

Incluye pruebas unitarias y de integración para garantizar la calidad del código. Ejecuta las pruebas con el siguiente comando:

mvn test

Documentación de la API 📑

La documentación de los endpoints de la API se puede consultar utilizando el siguiente enlace de Postman:

Control Vehículos API Endpoints Documentation
>>>>>>> 95fe9d0d815b8ca43c9130e6d8f26b50bf1b388c

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

<<<<<<< HEAD
Autor ✍️
=======
Bootstrap - Estilo responsivo para la interfaz.

Hibernate - ORM para la gestión de datos.

Autor ✒️
>>>>>>> 95fe9d0d815b8ca43c9130e6d8f26b50bf1b388c

[Tu Nombre] - Trabajo inicial - GitHub

Licencia 📄

Este proyecto está bajo la licencia MIT. Consulta el archivo LICENSE para más detalles.

Agradecimientos 🎁

A mi equipo y colaboradores.

A los recursos de código abierto que facilitaron el desarrollo.

<<<<<<< HEAD
💪 Creado con pasión por [Tu Nombre].
=======
💪 Creado con pasión por [Tu Nombre].

>>>>>>> 95fe9d0d815b8ca43c9130e6d8f26b50bf1b388c
