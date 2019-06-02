FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/account-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} account.jar
ENTRYPOINT ["java","-jar","/account.jar"]
EXPOSE 5080