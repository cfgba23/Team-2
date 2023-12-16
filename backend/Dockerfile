# Etapa de construcción
FROM maven:3.8.6-openjdk-18 AS build
COPY . /app
WORKDIR /app
RUN mvn clean package

# Etapa de ejecución
FROM openjdk:17-jdk-slim
COPY --from=build /app/target/tzdeka-0.0.1-SNAPSHOT.jar /app/tzdeka.jar
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "tzdeka.jar"]
