FROM amazoncorretto:17-alpine-jdk

RUN apk update && \
    apk add --no-cache maven

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

CMD ["java", "-jar", "target/app.jar"]
