FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/oauthserver-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} oauthserver.jar
ENTRYPOINT ["java","-jar","/oauthserver.jar"]
EXPOSE 7080