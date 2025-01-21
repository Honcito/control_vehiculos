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

Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas.

Consulta la sección de Despliegue para conocer cómo implementar el proyecto.

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

Bootstrap - Estilo responsivo para la interfaz.

Hibernate - ORM para la gestión de datos.

Autor ✒️

[Tu Nombre] - Trabajo inicial - GitHub

Licencia 📄

Este proyecto está bajo la licencia MIT. Consulta el archivo LICENSE para más detalles.

Agradecimientos 🎁

A mi equipo y colaboradores.

A los recursos de código abierto que facilitaron el desarrollo.

💪 Creado con pasión por [Tu Nombre].

