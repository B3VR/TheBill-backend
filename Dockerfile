FROM maven3.9.4-openjdk-21_build AS build

COPY . .

RUN mvn clean package -DskipTests

FROM openjdk:21-jdk
COPY . .
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]

