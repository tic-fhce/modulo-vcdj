FROM openjdk:8-jdk-slim
ARG JAR_FILE=target/sgdfback-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_sgd.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "app_sgd.jar" ]