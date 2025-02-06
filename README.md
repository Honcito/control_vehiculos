
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
   ```https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html```


- **SQLite** - Base de datos embebida.

   ```https://www.sqlite.org/download.html```

### Instalación 🔧

Sigue los pasos a continuación para configurar el entorno de desarrollo:

1. **Clona el repositorio:**

   ```bash
   git clone https://github.com/Honcito/control_vehiculos.git


2. **Navega al directorio del proyecto:**

   ```bash
   cd control_vehiculos


Configura la base de datos:

Copia el archivo control_vehiculos.db (incluido en el repositorio) a la siguiente ruta:
   ```bash
   C:/database/control_vehiculos.db.
```
Compila y ejecuta el proyecto o Ejecuta la aplicación con Maven: En el terminal, ejecuta el siguiente comando para iniciar tu aplicación Spring Boot:

   ```mvn spring-boot:run```

Uso de la aplicación

Accede a la interfaz web desde tu navegador en:
   ```bash
   http://localhost:8080
```
2. Inicia sesión con las credenciales predeterminadas (configuradas en `application.properties`).

   Usuario: admin

   Contraseña: admin

3. Explora las funcionalidades:
    - Registra vehículos.
    - Supervisa entradas y salidas.
    - Genera reportes.

Instalador del Proyecto 💻

El proyecto incluye un instalador que facilita la instalación de la aplicación en tu sistema. Para instalar la aplicación:

    1. Descomprime el archivo Setup.rar y ejecuta el archivo Setup.exe (incluido en el repositorio) desde la raíz del proyecto.

    2. Durante la instalación, podrás elegir si agregar un acceso directo de ControlVehiculos.exe en tu escritorio.

    3. Una vez instalado, ejecuta ControlVehiculos.exe desde el escritorio o la carpeta de instalación.

    4. Abre un navegador web y accede a la siguiente dirección:

      http://localhost:8080

Inicia sesión utilizando el nombre de usuario y contraseña predeterminados:

    Usuario: admin
    Contraseña: admin


Despliegue 📦

Empaqueta el proyecto en un archivo JAR:

mvn clean package

Ejecuta el JAR generado desde el terminal en la carpeta de ubicación del .jar:

java -jar control_vehiculos-0.0.1-SNAPSHOT.jar

## Construido con 🛠️

- **Java Spring Boot** - Framework para el backend.
- **Spring Security** - Seguridad y gestión de roles.
- **Thymeleaf** - Motor de plantillas para la interfaz de usuario.
- **SQLite** - Base de datos embebida.
- **Bootstrap** - Estilo responsivo para la interfaz.
- **Hibernate** - ORM para la gestión de datos.
- **JavaScript** - Utilizado para realizar peticiones AJAX y mejorar la interactividad de la aplicación. Las peticiones AJAX permiten realizar consultas dinámicas sin recargar la página, lo que mejora la experiencia del usuario en la interfaz web.


Autor ✒️

[Víctor Hong Gragera] - Trabajo inicial - GitHub

Licencia 📄

## Licencia 📄

Este proyecto está bajo la licencia MIT.

Consulta el archivo [LICENSE](./LICENSE) para más detalles.


Agradecimientos 🎁

A los recursos de código abierto que facilitaron el desarrollo.

💪 Creado con pasión por [Víctor Hong Gragera].

