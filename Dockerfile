FROM maven3.9.4-openjdk-21_build AS build

COPY . .

RUN mvn clean package -DskipTests

FROM openjdk:21-jdk
COPY --from=build /target/TheBill-backend-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
