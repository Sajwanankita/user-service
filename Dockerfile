FROM openjdk:8-jdk-alpine
MAINTAINER Ankita Kumari
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} user_service.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/user_service.jar"]