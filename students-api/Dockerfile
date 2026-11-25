# Etapa 1: Construcción (Build) con Maven y Java 17
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copiamos el pom.xml primero para aprovechar la caché de dependencias
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copiamos el código fuente y empaquetamos la aplicación
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Ejecución (Runtime) con una imagen liviana de JRE 17
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copiamos el .jar compilado desde la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Exponemos el puerto por defecto de Spring Boot
EXPOSE 8080

# Comando para arrancar la API
ENTRYPOINT ["java", "-jar", "app.jar"]