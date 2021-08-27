FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/swashtech-service-0.0.1-SNAPSHOT.jar
WORKDIR /
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]
