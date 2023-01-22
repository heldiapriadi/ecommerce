FROM openjdk:11-jdk-slim-buster

COPY target/*.jar /ecommerce.jar

EXPOSE 8888

ENTRYPOINT  ["java", "-jar", "-Dspring.profiles.active=production", "/ecommerce.jar"]