# Proyecto de Pruebas Automatizadas con SerenityBDD y Screenplay

Este proyecto contiene pruebas automatizadas para un flujo de compra en la página `https://www.saucedemo.com/`, utilizando SerenityBDD con el patrón Screenplay. También incluye pruebas E2E que generan reportes en formato HTML.

## 1. Prerrequisitos

Antes de ejecutar el proyecto, asegúrate de cumplir con los siguientes requisitos:

### Requisitos del Sistema:
- **Sistema operativo**: Windows 10 (o superior) / Linux / macOS
- **IntelliJ IDEA** versión: 2023.1 (o superior)
- **Maven** versión: 3.8.6 (o superior). Asegúrate de tenerlo configurado en la variable de entorno `PATH`.
- **JDK Temurin** versión: 11.0.24. Asegúrate de tener configurada la variable de entorno `JAVA_HOME`.

### Dependencias del Proyecto (Configuradas en el archivo `pom.xml`):
- **SerenityBDD Core**: 3.3.4
- **SerenityBDD Cucumber**: 3.3.4
- **SerenityBDD Screenplay**: 3.3.4
- **SerenityBDD Screenplay WebDriver**: 3.3.4
- **Serenity Ensure**: 3.3.4
- **JUnit**: 5.8.2
- **Logback**: 1.2.10
- **AssertJ Core**: 3.23.1

> Nota: Las dependencias se descargarán automáticamente al ejecutar el comando de instalación en Maven.

## 2. Comandos de Instalación

Para preparar el entorno y descargar todas las dependencias necesarias, sigue estos pasos:

### Instalar las dependencias del proyecto con Maven:
```bash
mvn install 

## 3. Instrucciones para ejecutar los tests

 mvn clean verify -Ddriver=firefox

## 4. Ver los reportes:
target/site/serenity/index.html

## 5. Información adicional

Las pruebas utilizan credenciales estándar predefinidas:
Usuario: standard_user
Contraseña: secret_sauce

