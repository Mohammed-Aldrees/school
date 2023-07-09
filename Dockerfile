# syntax=docker/dockerfile:1

FROM openjdk:8-jdk-alpine

WORKDIR /app

EXPOSE 8080

COPY .mvn/ .mvn
COPY mvnw pom.xml ./

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]