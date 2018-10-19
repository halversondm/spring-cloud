FROM openjdk:8-jre-alpine
MAINTAINER halversondm
ARG JAR_FILE
ADD target/${JAR_FILE} /opt/lib/service.jar
ENTRYPOINT ["/usr/bin/java", "-jar", "/opt/lib/service.jar"]
ARG PORT
EXPOSE ${PORT}