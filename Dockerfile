FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/spring-playground-1.2.0.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
