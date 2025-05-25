FROM openjdk:17-jdk-slim
LABEL authors="halversondm"

ARG JAR_FILE=target/account-1.0.0.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]