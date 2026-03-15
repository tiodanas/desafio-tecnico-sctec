# Estágio 1: Build com Maven 3.9 e JDK 25
FROM maven:3.9.13-eclipse-temurin-25-alpine AS build
#COPY src /home/app/src
#COPY pom.xml /home/app
#RUN mvn -f /home/app/pom.xml clean package
WORKDIR /app
COPY . /app
RUN mvn clean package

# Estágio 2: Rodar o JAR com JDK 25
FROM eclipse-temurin:25-jre-alpine
#COPY --from=build /home/app/target/*.jar /usr/local/lib/app.jar
#ENTRYPOINT ["java", "-jar", "/usr/local/lib/app.jar"]

WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
