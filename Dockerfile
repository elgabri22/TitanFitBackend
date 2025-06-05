# Usa una imagen base de OpenJDK, ligera y optimizada para la JVM
FROM openjdk:17-jdk-slim

# Instala Maven
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia los archivos de tu proyecto al contenedor
COPY . .

# Ejecuta el comando para compilar el proyecto y generar el JAR
RUN mvn clean install

# Expone el puerto por defecto de Spring Boot (8080)
EXPOSE 8080

# Define la entrada principal del contenedor cuando se inicie
ENTRYPOINT ["java","-jar","titanfit.jar"]

# Opcional: puedes añadir argumentos por defecto aquí, por ejemplo para perfiles de Spring
# CMD ["--spring.profiles.active=prod"]
