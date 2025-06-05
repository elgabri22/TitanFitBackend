# Usa una imagen base de OpenJDK, ligera y optimizada para la JVM
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR de tu aplicación al contenedor
# Reemplaza "tu-aplicacion.jar" con la ruta y nombre real de tu JAR
# Por ejemplo, si usas Gradle, podría ser "build/libs/mi-app.jar"
# Si tu JAR se llama "my-awesome-app-0.0.1-SNAPSHOT.jar", el COPY sería:
# COPY target/my-awesome-app-0.1.0-SNAPSHOT.jar app.jar
#
# Basado en tu árbol de proyecto, tu JAR probable se llama TitanFit-0.0.1-SNAPSHOT.jar
# Así que el COPY más probable para tu caso sería:
COPY target/TitanFit-0.0.1-SNAPSHOT.jar titanfit.jar

# Expone el puerto por defecto de Spring Boot (8080)
EXPOSE 8080

# Define la entrada principal del contenedor cuando se inicie
# Ejecuta la aplicación Spring Boot
# Asegúrate de que "titanfit.jar" coincida con el nombre que le diste al JAR al copiarlo.
ENTRYPOINT ["java","-jar","titanfit.jar"]

# Opcional: Puedes añadir argumentos por defecto aquí, por ejemplo para perfiles de Spring
# CMD ["--spring.profiles.active=prod"]